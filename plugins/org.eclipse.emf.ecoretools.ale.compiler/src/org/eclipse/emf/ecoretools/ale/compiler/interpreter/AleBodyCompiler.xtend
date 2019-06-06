package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.ParameterizedTypeName
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
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
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While
import org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl
import org.eclipse.xtext.EcoreUtil2
import com.squareup.javapoet.TypeName

class AleBodyCompiler {

	extension InterpreterTypeSystemUtils tsu
	extension InterpreterExpressionCompiler aec
	extension CommonTypeInferer cti

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, BaseValidator base,
		List<ResolvedClass> resolved, Set<Method> registreredDispatch, Set<String> registeredArray,
		Map<String, Class<?>> registeredServices, boolean isTruffle, CommonTypeInferer cti, EnumeratorService es,
		InterpreterNamingUtils inu) {
		tsu = new InterpreterTypeSystemUtils(syntaxes, packageRoot, resolved, inu)
		aec = new InterpreterExpressionCompiler(packageRoot, resolved, registreredDispatch, registeredArray,
			registeredServices, isTruffle, cti, es, tsu, inu)
		this.cti = cti
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, FeatureAssignment body,
		CompilerExpressionCtx ctx) {
		val t = infereType(body.target).head
		val lhs = body.target.compileExpression(ctx)
		if (lhs == 'this') {
			if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
				builderSeed.addStatement('''$L.$L.add($L)''', lhs, body.targetFeature,
					body.value.compileExpression(ctx))
			} else if (t.type instanceof EClass || t.type instanceof EDataType) {
				builderSeed.addStatement('''$L.set$L($L)''', lhs, body.targetFeature.toFirstUpper,
					body.value.compileExpression(ctx))
			} else {
				builderSeed.addStatement('''$L.$L = ($T) ($L)''', lhs, body.targetFeature, t,
					body.value.compileExpression(ctx))
			}
		} else {
			if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
				builderSeed.addStatement('''$L.get$L().add($L)''', lhs, body.targetFeature.toFirstUpper,
					body.value.compileExpression(ctx))
			} else if (t.type instanceof EClass || t.type instanceof EDataType) {
				builderSeed.addStatement('''$L.set$L($L)''', lhs, body.targetFeature.toFirstUpper,
					body.value.compileExpression(ctx))
			} else {
				val tb = t.type.resolveType2.solveNothing(body.target)
				builderSeed.addStatement('''$L.$L = ($T) ($L)''', lhs, body.targetFeature, tb,
					body.value.compileExpression(ctx))
			}

		}

	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, FeatureInsert body,
		CompilerExpressionCtx ctx) {
		val lhs = body.target.compileExpression(ctx)
		if (lhs == 'this') {
			builderSeed.addStatement('''$L.$L.add($L)''', lhs, body.targetFeature, body.value.compileExpression(ctx))
		} else {
			builderSeed.addStatement('''$L.get$L().add($L)''', lhs, body.targetFeature.toFirstUpper,
				body.value.compileExpression(ctx))
		}
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, FeatureRemove body,
		CompilerExpressionCtx ctx) {
		val lhs = body.target.compileExpression(ctx)
		if (lhs == 'this') {
			builderSeed.addStatement('''$L.$L.remove($L)''', lhs, body.targetFeature, body.value.compileExpression(ctx))
		} else {
			builderSeed.addStatement('''$L.get$L().remove($L)''', lhs, body.targetFeature.toFirstUpper,
				body.value.compileExpression(ctx))

		}
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, VariableAssignment body,
		CompilerExpressionCtx ctx) {

		val t = if (body.name == 'result') {
				EcoreUtil2.getContainerOfType(body, MethodImpl).operationRef.EType.resolveType2
			} else
				body.value.resolveType2

		builderSeed.addStatement(
			CodeBlock.builder.addNamed('''$name:N = «IF t !== null»($exprtype:T) ($expr:L) «ELSE»$expr:L«ENDIF»''',
				newHashMap(
					"name" -> body.name,
					"exprtype" -> t,
					"expr" -> body.value.compileExpression(ctx)
				)).build)
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, VariableDeclaration body,
		CompilerExpressionCtx ctx) {

		val inft = body.initialValue?.infereType?.head
		if (inft instanceof SequenceType) {
			val ict = inft.collectionType.type
			val t = if (ict instanceof EClass) {
					ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"), ict.resolveType)
				} else {
					ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
						ClassName.get(inft.collectionType.type as Class<?>))
				}
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t,
				body.initialValue.compileExpression(ctx))
		} else {
			val t = body.type.solveType
			// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
			val cbb = CodeBlock.builder.addNamed('''$t:T $name:N = (($t:T) ($expr:L))''', newHashMap(
				"t" -> t,
				"name" -> body.name,
				"expr" -> body.initialValue?.compileExpression(ctx)
			))
			val cb = cbb.build
			builderSeed.addStatement(cb)
		}
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, Block body, CompilerExpressionCtx ctx) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement, ctx)
		])
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, ExpressionStatement body,
		CompilerExpressionCtx ctx) {
		builderSeed.addStatement(body.expression.compileExpression(ctx))
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, FeaturePut body,
		CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''throw new $T("FeaturePut not implemented")''', RuntimeException)
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, ForEach body, CompilerExpressionCtx ctx) {
		val its = infereType(body.collectionExpression)
		val iteratorVariable = body.variable
		if(its.head instanceof SequenceType) {
			val lt = its.head as SequenceType // here typing problem!
			if (lt.collectionType.type instanceof EClass) {
				builderSeed.beginControlFlow('''for ($T $L : $L)''',
					(lt.collectionType.type as EClass).solveType, iteratorVariable, body.collectionExpression.compileExpression(ctx)).compileBody(body.body, ctx).endControlFlow
			} else {
	
				val iteratorType = lt.collectionType.type.resolveType2
				val iterable = body.collectionExpression.compileExpression(ctx)
				builderSeed.beginControlFlow('''for ($T $L: $L)''', iteratorType, iteratorVariable, iterable).
					compileBody(body.body, ctx).endControlFlow
			}
		} else {
			val iteratorType = TypeName.get(Object) // FIXME: joker, did not find a way to identify the collection generic type so far
			val iterable = body.collectionExpression.compileExpression(ctx)			
			builderSeed.beginControlFlow('''for ($T $L: $L)''', iteratorType, iteratorVariable, iterable).
					compileBody(body.body, ctx).endControlFlow
		}
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, If body, CompilerExpressionCtx ctx) {
		var ret = builderSeed.beginControlFlow('''if ($L)''', body.blocks.head.condition.compileExpression(ctx)).
			compileBody(body.blocks.head.block, ctx).endControlFlow
		for (ConditionalBlock x : body.blocks.tail) {
			ret = ret.beginControlFlow('''else if ($L''', x.condition.compileExpression(ctx)).compileBody(x.block, ctx).
				endControlFlow
		}
		if (body.^else !== null)
			ret = ret.beginControlFlow("else").compileBody(body.^else, ctx).endControlFlow
		ret
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, ConditionalBlock body,
		CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''throw new $T("ConditionalBlock not implemented")''', RuntimeException)
	}

	def dispatch CodeBlock.Builder compileBody(CodeBlock.Builder builderSeed, While body, CompilerExpressionCtx ctx) {
		builderSeed.beginControlFlow("while ($L)", body.condition.compileExpression(ctx)).compileBody(body.body, ctx).
			endControlFlow
	}
}
