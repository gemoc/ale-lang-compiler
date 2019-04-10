package org.eclipse.emf.ecoretools.ale.compiler.visitor

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
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
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
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

import static javax.lang.model.element.Modifier.*

class OperationImplementationCompiler {

	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension JavaPoetUtils = new JavaPoetUtils
	extension VisitorTypeSystemUtil tsu
	extension VisitorExpressionCompiler vec
	
	val File directory
	val String packageRoot
	val IQueryEnvironment queryEnvironment
	val List<ParseResult<ModelUnit>> parsedSemantics
	val List<ResolvedClass> resolved
	val Map<String, Class<?>> registeredServices
	var BaseValidator base
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	var CommonTypeInferer cti
	val EnumeratorService es

	new(File directory, String packageRoot, Map<String, Pair<EPackage, GenModel>> syntaxes,
		IQueryEnvironment queryEnvironment, List<ParseResult<ModelUnit>> parsedSemantics, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices, EnumeratorService es) {
		this.directory = directory
		this.packageRoot = packageRoot
		this.queryEnvironment = queryEnvironment
		this.parsedSemantics = parsedSemantics
		this.resolved = resolved
		this.registeredServices = registeredServices
		this.syntaxes = syntaxes
		this.es = es
	}
	
	def compile(EClass eClass, ExtendedClass aleClass) {
		
		this.base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		
		this.cti = new CommonTypeInferer(base)
		this.tsu = new VisitorTypeSystemUtil(syntaxes, namingUtils, packageRoot, base)
		
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
					.compileBody(method.body)
					.closeMethod(method.operationRef.EType)
					.build
			])

		]).applyIfTrue(eClass.abstract, [addModifiers(ABSTRACT)]).build

		val javaFile = JavaFile.builder(namingUtils.operationImplementationPackageName(packageRoot, eClass), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}

	

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.addStatement('''$L.get$L().add($L)''', body.target.compileExpression, body.targetFeature.toFirstUpper, body.value.compileExpression)
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.
				addStatement('''«body.target.compileExpression».set«body.targetFeature.toFirstUpper»(«body.value.compileExpression»)''')
		} else {
			builderSeed.
				addStatement('''«body.target.compileExpression».«body.targetFeature» = «body.value.compileExpression»''')

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body) {
		builderSeed.
			addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression»)''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body) {
		builderSeed.
			addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().remove(«body.value.compileExpression»)''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body) {
		builderSeed.addStatement('''$L = $L''', body.name, body.value.compileExpression)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body) {

		val inft = body.initialValue?.infereType?.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression)
		} else {
			val t = body.type.solveType
			if(body.initialValue === null) {
				builderSeed.addStatement('''$T $L = null''', t, body.name)
			} else {
				builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression)
			}
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, Block body) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement)
		])
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ExpressionStatement body) {
		builderSeed.addStatement(body.expression.compileExpression)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeaturePut body) {
		builderSeed.addStatement('''throw new $T("FeaturePut not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ForEach body) {
		val lt = infereType(body.collectionExpression).head as SequenceType

		if (lt.collectionType.type instanceof EClass) {
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression»)''',
				(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body).endControlFlow
		} else {
			val iteratorType = lt.collectionType.type.resolveType2
			val iteratorVariable = body.variable
			val iterable = body.collectionExpression.compileExpression
			builderSeed
				.beginControlFlow('''for ($T $L: $L)''', iteratorType, iteratorVariable, iterable)
				.compileBody(body.body)
				.endControlFlow
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, If body) {
		var ret = builderSeed.beginControlFlow('''if($L)''', body.blocks.head.condition.compileExpression).compileBody(
			body.blocks.head.block).endControlFlow
		for (ConditionalBlock x : body.blocks.tail) {
			ret = ret.beginControlFlow('''else if ($L''', x.condition.compileExpression).compileBody(x.block).
				endControlFlow
		}
		if (body.^else !== null)
			ret = ret.beginControlFlow("else").compileBody(body.^else).endControlFlow
		ret
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ConditionalBlock body) {
		builderSeed.addStatement('''throw new $T("ConditionalBlock not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, While body) {
		val a = builderSeed.beginControlFlow("while ($L)", body.condition.compileExpression)
		a.compileBody(body.body).endControlFlow
	}
	
	
	
}
