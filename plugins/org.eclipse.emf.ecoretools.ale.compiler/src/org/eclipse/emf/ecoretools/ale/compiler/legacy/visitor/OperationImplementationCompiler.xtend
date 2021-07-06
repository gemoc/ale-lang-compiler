package org.eclipse.emf.ecoretools.ale.compiler.legacy.visitor

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
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile
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
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

import static javax.lang.model.element.Modifier.*

@Deprecated
class OperationImplementationCompiler {

	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension JavaPoetUtils = new JavaPoetUtils
	extension VisitorTypeSystemUtil tsu
	extension VisitorExpressionCompiler vec
	extension CommonTypeInferer cti
	
	val File directory
	val String packageRoot
	val IQueryEnvironment queryEnvironment
	val List<ParsedFile<ModelUnit>> parsedSemantics
	val List<ResolvedClass> resolved
	val Map<String, Pair<String, String>> registeredServices
	var BaseValidator base
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val EnumeratorService es
	val IAleEnvironment env

	new(File directory, String packageRoot, Map<String, Pair<EPackage, GenModel>> syntaxes,
		IQueryEnvironment queryEnvironment, List<ParsedFile<ModelUnit>> parsedSemantics, List<ResolvedClass> resolved,
		Map<String, Pair<String, String>> registeredServices, EnumeratorService es, IAleEnvironment env) {
		this.directory = directory
		this.packageRoot = packageRoot
		this.queryEnvironment = queryEnvironment
		this.parsedSemantics = parsedSemantics
		this.resolved = resolved
		this.registeredServices = registeredServices
		this.syntaxes = syntaxes
		this.es = es
		this.env = env
	}
	
	def compile(EClass eClass, ExtendedClass aleClass) {
		
		this.base = new BaseValidator(this.env, #[new TypeValidator])
		base.validate(parsedSemantics)
		
		this.cti = new CommonTypeInferer(base)
		this.tsu = new VisitorTypeSystemUtil(syntaxes, namingUtils, packageRoot, resolved)
		
		this.vec = new VisitorExpressionCompiler(tsu, resolved, registeredServices, namingUtils, packageRoot, cti, es)
		
		val classInterfaceType = ClassName.get(namingUtils.classInterfacePackageName(eClass, packageRoot),
			namingUtils.classInterfaceClassName(eClass))

		val operationInterfaceType = ClassName.get(namingUtils.operationInterfacePackageName(packageRoot, eClass),
			namingUtils.operationInterfaceClassName(eClass))

		val visitorInterfaceType = ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot),
			namingUtils.visitorInterfaceClassName)

		val factory = TypeSpec.classBuilder(namingUtils.operationImplementationClassName(eClass)).applyIfTrue(
			!eClass.ESuperTypes.empty, [
				superclass(
					ClassName.get(namingUtils.operationImplementationPackageName(packageRoot, eClass.ESuperTypes.head),
						namingUtils.operationImplementationClassName(eClass.ESuperTypes.head)))
			]).addSuperinterface(operationInterfaceType).addModifiers(PUBLIC).addField(classInterfaceType, 'it',
			PRIVATE, FINAL).addField(visitorInterfaceType, 'vis', PRIVATE, FINAL).addMethod(
			MethodSpec.constructorBuilder.addParameter(classInterfaceType, 'it').addParameter(visitorInterfaceType,
				'vis').addCode('''
				«IF !eClass.ESuperTypes.empty»super(it, vis);«ENDIF»
				this.it = it;
				this.vis = vis;
			''').addModifiers(PUBLIC).build).applyIfTrue(aleClass !== null, [
			addMethods(aleClass.methods.map [ method |

				val retType = method.operationRef.EType?.resolveType2 

				MethodSpec.methodBuilder(method.operationRef.name).applyIfTrue(retType !== null, [returns(retType)]).
					addParameters(method.operationRef.EParameters.map [ param |
						if (param.EType.instanceClass !== null) {
							if (param.EType instanceof EClass && !(param.EType.EPackage == EcorePackage.eINSTANCE)) {
								ParameterSpec.builder(
									ClassName.get((param.EType as EClass).classInterfacePackageName(packageRoot),
										(param.EType as EClass).name), param.name).build
							} else {
								ParameterSpec.builder(param.EType.instanceClass, param.name).build

							}
						} else {
							ParameterSpec.builder(param.EType.resolveType, param.name).build
						}
					])
					.addModifiers(PUBLIC)
					.openMethod(method.operationRef.EType?.resolveType2)
					.compileBody(method.body, new CompilerExpressionCtx('????VISITOR???', aleClass, eClass))
					.closeMethod(method.operationRef.EType)
					.build
			])

		]).applyIfTrue(eClass.abstract, [addModifiers(ABSTRACT)]).build

		val javaFile = JavaFile.builder(namingUtils.operationImplementationPackageName(packageRoot, eClass), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}

	

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body, CompilerExpressionCtx ctx) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.addStatement('''$L.get$L().add($L)''', body.target.compileExpression(ctx), body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.
				addStatement('''$L.set$L($L)''', body.target.compileExpression(ctx), body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
		} else {
			builderSeed.
				addStatement('''$L.$L = $L''', body.target.compileExpression(ctx), body.targetFeature, body.value.compileExpression(ctx))

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body, CompilerExpressionCtx ctx) {
		builderSeed.
			addStatement('''$L.get$L().add($L)''', body.target.compileExpression(ctx), body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body, CompilerExpressionCtx ctx) {
		builderSeed.
			addStatement('''$L.get$L().remove($L)''', body.target.compileExpression(ctx), body.targetFeature.toFirstUpper, body.value.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body, CompilerExpressionCtx ctx) {
		val t = body.value.infereType.head?.type?.resolveType2.solveNothing(body)
		if(t === null)
			builderSeed.addStatement('''$L = $L''', body.name, body.value.compileExpression(ctx))
		else
			builderSeed.addStatement('''$L = (($T) ($L))''', body.name, t, body.value.compileExpression(ctx))
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body, CompilerExpressionCtx ctx) {

		val inft = body.initialValue?.infereType?.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression(ctx))
		} else {
			val t = body.type.resolveType2.solveNothing(body.initialValue)
			if(body.initialValue === null) {
				builderSeed.addStatement('''$T $L = null''', t, body.name)
			} else {
				builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression(ctx))
			}
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
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression(ctx)»)''',
				(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body, ctx).endControlFlow
		} else {
			val iteratorType = lt.collectionType.type.resolveType2
			val iteratorVariable = body.variable
			val iterable = body.collectionExpression.compileExpression(ctx)
			builderSeed
				.beginControlFlow('''for ($T $L: $L)''', iteratorType, iteratorVariable, iterable)
				.compileBody(body.body, ctx)
				.endControlFlow
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
