package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove
import org.eclipse.emf.ecoretools.ale.implementation.ForEach
import org.eclipse.emf.ecoretools.ale.implementation.If
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

import static javax.lang.model.element.Modifier.*

class SwitchOperationCompiler {

	extension SwitchNamingUtils namingUtils
	extension SwitchTypeSystemUtils tsu
	extension JavaPoetUtils = new JavaPoetUtils
	extension SwitchExpressionCompiler swe
	extension CommonTypeInferer cti

	val String packageRoot
	val File directory
	val BaseValidator base
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val Dsl dsl

	new(
		String packageRoot,
		File directory,
		Map<String, Pair<EPackage, GenModel>> syntaxes,
		IQueryEnvironment queryEnvironment,
		List<ParseResult<ModelUnit>> parsedSemantics,
		List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices,
		Dsl dsl, SwitchNamingUtils namingUtils
	) {
		this.packageRoot = packageRoot
		this.directory = directory
		base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		this.tsu = new SwitchTypeSystemUtils(syntaxes, packageRoot, resolved)
		this.cti = new CommonTypeInferer(base)
		this.namingUtils = namingUtils
		this.swe = new SwitchExpressionCompiler(tsu, resolved, namingUtils, packageRoot, registeredServices, cti,
			new EnumeratorService)
		this.syntaxes = syntaxes
		this.dsl = dsl
	}

	@Deprecated
	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def compile(ResolvedClass resolved) {
		val eClassType = ClassName.get(resolved.genCls.genPackage.interfacePackageName, resolved.genCls.interfaceName)
		val switchType = ClassName.get(namingUtils.switchImplementationPackageName(packageRoot),
			namingUtils.switchImplementationClassName(packageRoot))
		val operationsPackage = namingUtils.operationPackageName(packageRoot)

		val factory = TypeSpec.classBuilder(namingUtils.operationClassName(resolved.eCls)).applyIfTrue(
			!(resolved.eCls as EClass).ESuperTypes.empty, [
				superclass(
					ClassName.get(operationsPackage,
						namingUtils.operationClassName((resolved.eCls as EClass).ESuperTypes.head)))
			]).addField(eClassType, 'it', PRIVATE, FINAL).addField(switchType, 'emfswitch', PRIVATE, FINAL).addMethod(
			MethodSpec.constructorBuilder.addParameter(eClassType, 'it').addParameter(switchType, 'emfswitch').
				addCode('''
					«IF !(resolved.eCls as EClass).ESuperTypes.empty»
						super(it, emfswitch);
					«ENDIF»
					this.it = it;
					this.emfswitch = emfswitch;
				''').addModifiers(PUBLIC).build
		).applyIfTrue(resolved.getAleCls !== null, [addMethods(resolved.getAleCls.methods.map[it.compileMethodB(resolved.eCls as EClass, resolved.aleCls)])]).
			addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(operationsPackage, factory).indent('\t').build

		javaFile.writeTo(directory)
	}

	def MethodSpec compileMethodB(Method method, EClass eCls, ExtendedClass aleClss) {
		val retType = if (method.operationRef.EType !== null) {
				if (method.operationRef.EType instanceof EClass &&
					!(method.operationRef.EType.EPackage == EcorePackage.eINSTANCE)) {
					ClassName.get(getEcoreInterfacesPackage, (method.operationRef.EType as EClass).name)
				} else {
					method.operationRef.EType.resolveType2

				}
			} else
				null

		MethodSpec.methodBuilder(method.operationRef.name).applyIfTrue(retType !== null, [returns(retType)]).
			addParameters(method.operationRef.EParameters.map [ param |
				if (param.EType.instanceClass !== null) {
					if (param.EType instanceof EClass && !(param.EType.EPackage == EcorePackage.eINSTANCE)) {
						ParameterSpec.builder(ClassName.get(getEcoreInterfacesPackage, (param.EType as EClass).name),
							param.name).build
					} else {
						ParameterSpec.builder(param.EType.instanceClass, param.name).build

					}
				} else {
					ParameterSpec.builder(param.EType.resolveType, param.name).build
				}
			]).addModifiers(PUBLIC).openMethod(method.operationRef.EType?.resolveType2)
			.compileBody(method.body, new CompilerExpressionCtx('''???SWTICH???''', aleClss, eCls)).
			closeMethod(method.operationRef.EType).build
	}

	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		edt.instanceClass
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body, CompilerExpressionCtx ctx) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.addStatement('''$L.get$L().add($L)''', body.target.compileExpression(ctx),
				body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.addStatement('''$L.set$L($L)''', body.target.compileExpression(ctx), body.targetFeature.toFirstUpper,
				body.value.compileExpression(ctx))
		} else {
			builderSeed.addStatement('''$L.$L = $L''', body.target.compileExpression(ctx), body.targetFeature,
				body.value.compileExpression(ctx))

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''$L.get$L().add($L)''', body.target.compileExpression(ctx),
			body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''$L.get$L().remove($L)''', body.target.compileExpression(ctx),
			body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''«body.name» = $L''', body.value.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body, CompilerExpressionCtx ctx) {

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression(ctx))
		} else {
			val t = body.type.solveType
			// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression(ctx))
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, Block body, CompilerExpressionCtx ctx) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement, ctx)
		])
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ExpressionStatement body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement(body.expression.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeaturePut body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''throw new $T("FeaturePut not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ForEach body, CompilerExpressionCtx ctx) {
		val lt = infereType(body.collectionExpression).head as SequenceType

		if (lt.collectionType.type instanceof EClass) {
			builderSeed.beginControlFlow('''for ($T $L: «body.collectionExpression.compileExpression(ctx)»)''',
				(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body, ctx).endControlFlow
		} else {

			val iteratorType = lt.collectionType.type.resolveType2
			val iteratorVariable = body.variable
			val iterable = body.collectionExpression.compileExpression(ctx)
			builderSeed.beginControlFlow('''for ($T $L: $L)''', iteratorType, iteratorVariable, iterable).
				compileBody(body.body, ctx).endControlFlow
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, If body, CompilerExpressionCtx ctx) {
		var ret = builderSeed.beginControlFlow('''if($L)''', body.blocks.head.condition.compileExpression(ctx)).compileBody(
			body.blocks.head.block, ctx).endControlFlow
		for (ConditionalBlock x : body.blocks.tail) {
			ret = ret.beginControlFlow('''else if ($L''', x.condition.compileExpression(ctx)).compileBody(x.block, ctx).
				endControlFlow
		}
		if (body.^else !== null)
			ret = ret.beginControlFlow("else").compileBody(body.^else, ctx).endControlFlow
		ret
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ConditionalBlock body, CompilerExpressionCtx ctx) {
		builderSeed.addStatement('''throw new $T("ConditionalBlock not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, While body, CompilerExpressionCtx ctx) {
		val a = builderSeed.beginControlFlow("while ($L)", body.condition.compileExpression(ctx))
		a.compileBody(body.body, ctx).endControlFlow
	}
}
