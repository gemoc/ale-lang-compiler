package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.ecoretools.ale.implementation.Method
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterizedTypeName
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassImplementationCompiler.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove
import org.eclipse.emf.ecoretools.ale.implementation.ForEach
import org.eclipse.emf.ecoretools.ale.implementation.If
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

class AleBodyCompiler {
	
	extension TypeSystemUtils tsu
	extension AleExpressionsCompiler aec 
	
	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, BaseValidator base, List<ResolvedClass> resolved, List<Method> registreredDispatch, Map<String, Class<?>> registeredServices) {
		tsu = new TypeSystemUtils(syntaxes, packageRoot, base, resolved)
		aec = new AleExpressionsCompiler(syntaxes, packageRoot, base, resolved, registreredDispatch, registeredServices)
	}
	
	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body, CompilerExpressionCtx ctx) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.
				addStatement('''«body.target.compileExpression(ctx)».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression(ctx)»)''')
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.
				addStatement('''«body.target.compileExpression(ctx).escapeDollar».set«body.targetFeature.toFirstUpper»(«body.value.compileExpression(ctx).escapeDollar»)''')
		} else {
			builderSeed.
				addStatement('''«body.target.compileExpression(ctx)».«body.targetFeature» = «body.value.compileExpression(ctx)»''')

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body, CompilerExpressionCtx ctx) {
		builderSeed.
			addStatement('''«body.target.compileExpression(ctx)».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression(ctx)»)''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body, CompilerExpressionCtx ctx) {
		builderSeed.
			addStatement('''«body.target.compileExpression(ctx)».get«body.targetFeature.toFirstUpper»().remove(«body.value.compileExpression(ctx)»)''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''«body.name» = «body.value.compileExpression(ctx).escapeDollar»''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body, CompilerExpressionCtx ctx) {

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression(ctx).escapeDollar»)''', t,
				body.name, t)
		} else {
			val t = body.type.solveType
			// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression(ctx).escapeDollar»)''', t,
				body.name, t)

		}
	}
	
	

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, Block body, CompilerExpressionCtx ctx) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement, ctx)
		])
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ExpressionStatement body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement(body.expression.compileExpression(ctx).escapeDollar)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeaturePut body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''throw new $T("FeaturePut not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ForEach body, CompilerExpressionCtx ctx) {
		val lt = infereType(body.collectionExpression).head as SequenceType

		if (lt.collectionType.type instanceof EClass) {
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression(ctx)»)''',
				(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body, ctx).endControlFlow
		} else {
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression(ctx)»)''',
				lt.collectionType.type as Class<?>, body.variable).compileBody(body.body, ctx).endControlFlow
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, If body, CompilerExpressionCtx ctx) {
		var ret = builderSeed.beginControlFlow('''if($L)''', body.blocks.head.condition.compileExpression(ctx))
			.compileBody(body.blocks.head.block, ctx).endControlFlow
		for (ConditionalBlock x : body.blocks.tail) {
			ret = ret.beginControlFlow('''else if ($L''', x.condition.compileExpression(ctx))
				.compileBody(x.block, ctx)
				.endControlFlow
		}
		if (body.^else !== null)
			ret = ret.beginControlFlow("else").compileBody(body.^else, ctx).endControlFlow
		ret
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ConditionalBlock body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''throw new $T("ConditionalBlock not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, While body, CompilerExpressionCtx ctx) {
		builderSeed
			.beginControlFlow("while ($L)", body.condition.compileExpression(ctx)).compileBody(body.body, ctx)
			.endControlFlow
	}
	
	def escapeDollar(String s) {
		s.replaceAll("\\$\\(", "\\$\\$(")
	}
}