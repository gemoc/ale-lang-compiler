package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.Map
import java.util.function.Function
import javax.lang.model.element.Modifier
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
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
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While
import org.eclipse.xtext.xbase.lib.Functions.Function0

class ALERevisitorImplementationCompiler extends AbstractALECompiler {

	extension RevisitorNamingUtils rnu
	extension EcoreUtils eu = new EcoreUtils
	extension JavaPoetUtils = new JavaPoetUtils
	extension RevisitorExpressionCompiler rec
	extension TypeSystemUtils tsu
	extension CommonTypeInferer cti

	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	var List<ResolvedClass> resolved
	var BaseValidator base

	new() {
		this(newHashMap)
	}

	new(Map<String, Class<?>> services) {
		super(services)
		this.queryEnvironment = createQueryEnvironment(false, null)
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE)
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE)
		this.rnu = new RevisitorNamingUtils
	}

	def IStatus compile(String projectName, File projectRoot, Dsl dsl) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

		registerServices(projectName, parsedSemantics)

		// must be last !
		compile(projectRoot)

		Status.OK_STATUS
	}


	def private IQueryEnvironment createQueryEnvironment(boolean b, Object object) {
		val IQueryEnvironment newEnv = new ExtensionEnvironment()
		newEnv.registerEPackage(EcorePackage.eINSTANCE)
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
			EStringToStringMapEntryImpl)
		newEnv
	}

	def private void compile(File projectRoot) {

		val compileDirectory = new File(projectRoot, "revisitor-comp")

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		

		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		syntaxes = dsl.allSyntaxes.toMap([it], [
			(loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel)
		])
		
		this.tsu = new TypeSystemUtils(syntaxes, eu)
		this.cti = new CommonTypeInferer(base)
		val tmp = syntaxes.get(dsl.allSyntaxes.head)
		val syntax = tmp.key
		// FIXME: make the invalid assumption that the metamodel contains a single package
		val genSyntax = tmp.value.genPackages.head
		resolved = resolve(aleClasses, syntax)
		this.rec = new RevisitorExpressionCompiler(tsu, syntaxes, resolved, eu, dsl, registeredServices,
			new CommonTypeInferer(base), new EnumeratorService)

		val interfaceName = dsl.revisitorImplementationClass

		val comparator = Comparator.comparing(new Function<ResolvedClass, String>() {
			override apply(ResolvedClass arg0) {
				arg0.eCls.name
			}
		}).thenComparing(new Function<ResolvedClass, String>() {
			override apply(ResolvedClass arg0) {
				arg0.eCls.EPackage.name
			}
		})
		val typeParams = resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry"]
			.filter[it.eCls instanceof EClass]
			.sortWith(comparator)
			.map [dsl.getRevisitorOperationInterfaceClassName(it.eCls as EClass)]
		val fullInterfaceType = ParameterizedTypeName.get(
			ClassName.get(genSyntax.revisitorPackageFqn, genSyntax.revisitorInterfaceName), typeParams)

		val revisitorInterface = TypeSpec.interfaceBuilder(interfaceName).addSuperinterface(fullInterfaceType).
			addModifiers(Modifier.PUBLIC).addMethods(syntax.allClasses.filter [
				it.instanceClassName != "java.util.Map$Entry"
			].map [
				MethodSpec.methodBuilder(it.denotationName)
					.returns(dsl.getRevisitorOperationInterfaceClassName(it))
					.addParameter(it.solveType as TypeName, "it")
					.addCode('''
					return new $T(it, this);
					''', 
					dsl.getRevisitorOperationImplementationClassName(it))
					.addModifiers(Modifier.DEFAULT, Modifier.PUBLIC)
					.build
			]).build

		val javaFile = JavaFile.builder(dsl.revisitorImplementationPackage, revisitorInterface).indent('\t').build

		javaFile.writeTo(compileDirectory)

		resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry" && it.eCls instanceof EClass].forEach [
			try {
				val operationInterface = TypeSpec.interfaceBuilder((it.eCls as EClass).revisitorOperationInterfaceClassName)
					.addSuperinterfaces((eCls as EClass)
						.ESuperTypes.map [dsl.getRevisitorOperationInterfaceClassName(it)])
						.addModifiers(Modifier.PUBLIC).addMethods(it.aleCls?.methods?.map [
					MethodSpec.methodBuilder(it.operationRef.name).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).
						returnType(it.operationRef.EType).addParameters(it.operationRef.EParameters.map [
							if (it.EType.instanceClass !== null) {
								ParameterSpec.builder(it.EType.instanceClass, it.name).build
							} else {
								ParameterSpec.builder(it.EType.resolveType, it.name).build
							}
						]).build
				] ?: newArrayList).build
				val operationInterfaceFile = JavaFile.builder('''«dsl.revisitorOperationInterfacePackage»''',
					operationInterface).indent('\t').build
				operationInterfaceFile.writeTo(compileDirectory)

				val revField = FieldSpec.builder(fullInterfaceType, "rev", Modifier.PRIVATE).build

				val objField = FieldSpec.builder(ClassName.get(getEcoreInterfacesPackage, it.eCls.name), "obj",
					Modifier.PRIVATE).build

				val operationImplementation = TypeSpec.classBuilder((it.eCls as EClass).revisitorOperationImplementationClassName).addSuperinterfaces(
					#[ClassName.get(operationInterfaceFile.packageName, operationInterface.name)]).superOperationImpl(
					(eCls as EClass).ESuperTypes.head).addField(revField).addField(objField).addModifiers(Modifier.PUBLIC).
					addMethod(
						MethodSpec.constructorBuilder.addParameter(objField.type, "obj").addParameter(revField.type,
							"rev").addConditionalStatement([!(eCls as EClass).ESuperTypes.empty], 'super(obj, rev)').
							addStatement('''this.obj = obj''').addStatement('''this.rev = rev''').addModifiers(
								Modifier.PUBLIC).build).addModifiers(Modifier.PUBLIC).addMethods(
						it.aleCls?.methods?.map [
							val type = it.operationRef.EType
							val typeResolved = type?.resolveType2
							val parameters = it.operationRef.EParameters.map [
								if (it.EType.instanceClass !== null) {
									ParameterSpec.builder(it.EType.instanceClass, it.name).build
								} else {
									ParameterSpec.builder(it.EType.resolveType, it.name).build
								}
							]
							MethodSpec.methodBuilder(it.operationRef.name)
								.addModifiers(Modifier.PUBLIC)
								.returnType(type)
								.addParameters(parameters)
								.openMethod(typeResolved)
								.compileBody(it.body)
								.closeMethod(type)
								.build
						] ?: newArrayList).build
				val operationImplementationFile = JavaFile.
					builder('''«dsl.revisitorOperationImplementationPackage»''', operationImplementation).build
				operationImplementationFile.writeTo(compileDirectory)

			} catch (Exception e) {
				println(it)
				e.printStackTrace
			}
		]
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.
				addStatement('''$L.get$L().add($L)''', body.target.compileExpression, body.targetFeature.toFirstUpper, body.value.compileExpression)
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.
				addStatement('''$L.set$L($L)''', body.target.compileExpression, body.targetFeature.toFirstUpper, body.value.compileExpression)
		} else {
			builderSeed.
				addStatement('''$L.$L = $L''', body.target.compileExpression, body.targetFeature, body.value.compileExpression)

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body) {
		builderSeed.
			addStatement('''$L.get$L().add($L)''', body.target.compileExpression, body.targetFeature.toFirstUpper, body.value.compileExpression)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body) {
		builderSeed.
			addStatement('''$L.get$L().remove($L)''', body.target.compileExpression, body.targetFeature.toFirstUpper, body.value.compileExpression)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body) {
		builderSeed.addStatement('''«body.name» = $L''', body.value.compileExpression)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body) {

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression)
		} else {
			val t = body.type.solveType
			builderSeed.addStatement('''$T $L = (($T) ($L))''', t, body.name, t, body.initialValue.compileExpression)
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
			val iteratorName = body.variable
			val iterable = body.collectionExpression.compileExpression
			builderSeed
				.beginControlFlow('''for($T $L: $L)''', iteratorType, iteratorName, iterable)
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
	
	

	def MethodSpec.Builder returnType(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			if (type.instanceClass !== null) {
				return builder.returns(type.instanceClass)
			} else {
				return builder.returns(type.resolveType)
			}
		} else {
			return builder
		}
	}

	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax) {
		syntax.allClassifiers.map [ eClass |
			val aleClass = aleClasses.filter [
				it.name == eClass.name || it.name == eClass.EPackage.name + '.' + eClass.name
			].head
			new ResolvedClass(aleClass, eClass) // , gl
		]
	}

	def TypeSpec.Builder superOperationImpl(TypeSpec.Builder builder, EClass clazz) {
		if (clazz !== null) {
			builder.superclass(dsl.getRevisitorOperationImplementationClassName(clazz))
		} else {
			builder
		}
	}

	def <F> MethodSpec.Builder addConditionalStatement(MethodSpec.Builder builder, Function0<Boolean> f, String s) {
		if (f.apply()) {
			builder.addStatement(s)
		} else {
			builder
		}
	}

}
