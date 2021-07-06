package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.Map
import java.util.Set
import java.util.function.Function
import javax.lang.model.element.Modifier
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator
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
import org.eclipse.xtext.xbase.lib.Functions.Function0

class ALERevisitorImplementationCompiler extends AbstractALECompiler {

	extension RevisitorNamingUtils rnu
	extension JavaPoetUtils jpu
	extension RevisitorExpressionCompiler rec
	extension RevisitorTypeSystemUtils tsu
	extension CommonTypeInferer cti

	new(String projectName, File projectRoot, IAleEnvironment dsl, EcoreUtils eu, JavaPoetUtils jpu, ServicesRegistrationManager srm) {
		this(projectName, projectRoot, dsl, newHashMap, eu, jpu, srm)
	}

	new(String projectName, File projectRoot, IAleEnvironment dsl, Map<String, Pair<String, String>> services, EcoreUtils eu, JavaPoetUtils jpu, ServicesRegistrationManager srm) {
		super(projectName, projectRoot, dsl, services, eu, srm)
		this.jpu = jpu
		
	}

	override compile(File projectRoot, String projectName) {

		val compileDirectory = new File(projectRoot, "revisitor-comp")

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val base = new BaseValidator(this.dsl, #[new TypeValidator])
		base.validate(parsedSemantics)

		
		this.rnu = new RevisitorNamingUtils(this.resolved.head.genCls.genPackage)
		this.tsu = new RevisitorTypeSystemUtils(syntaxes, eu, resolved)
		this.cti = new CommonTypeInferer(base)
		// FIXME: make the invalid assumption that the metamodel contains a single package
		
		val packageRoot = 'TODO REVISITOR PACKAGE ROOT'
		this.rec = new RevisitorExpressionCompiler(tsu, resolved, registeredServices, new CommonTypeInferer(base),
			new EnumeratorService, rnu, packageRoot)


		val comparator = Comparator.comparing(new Function<Pair<EClass, EClass>, String>() {
			override apply(Pair<EClass, EClass> arg0) {
				arg0.key.EPackage.name + '.'+ arg0.key.name
			}
		}).thenComparing(new Function<Pair<EClass, EClass>, String>() {
			override apply(Pair<EClass, EClass> arg0) {
				if(arg0.value !==null) arg0.value.EPackage.name + '.'+ arg0.value.name
				else ''
			}
		})
		val pairs = computeEClassPairs.sortWith(comparator)
		val fullInterfaceType = computeFullInterfaceType(pairs)
		buildSpecializedInterface(compileDirectory, fullInterfaceType, pairs)

		resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry" && it.eCls instanceof EClass].forEach [
			val aleClass = it.aleCls
			val eclscls = it.eCls
			try {
				val operationInterface = TypeSpec.interfaceBuilder(
					(it.eCls as EClass).revisitorOperationInterfaceClassName).addSuperinterfaces((eCls as EClass).
					ESuperTypes.map[dsl.getRevisitorOperationInterfaceClassName(it)]).addModifiers(Modifier.PUBLIC).
					addMethods(it.aleCls?.methods?.map [
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

				val operationImplementation = TypeSpec.classBuilder(
					(it.eCls as EClass).revisitorOperationImplementationClassName).addSuperinterfaces(
					#[ClassName.get(operationInterfaceFile.packageName, operationInterface.name)]).superOperationImpl(
					(eCls as EClass).ESuperTypes.head).addField(revField).addField(objField).addModifiers(
					Modifier.PUBLIC).addMethod(
					MethodSpec.constructorBuilder.addParameter(objField.type, "obj").addParameter(revField.type, "rev").
						addConditionalStatement([!(eCls as EClass).ESuperTypes.empty], 'super(obj, rev)').
						addStatement('''this.obj = obj''').addStatement('''this.rev = rev''').addModifiers(
							Modifier.PUBLIC).build).addModifiers(Modifier.PUBLIC).addMethods(it.aleCls?.methods?.map [
					val type = it.operationRef.EType
					val typeResolved = type?.resolveType2
					val parameters = it.operationRef.EParameters.map [
						if (it.EType.instanceClass !== null) {
							ParameterSpec.builder(it.EType.instanceClass, it.name).build
						} else {
							ParameterSpec.builder(it.EType.resolveType, it.name).build
						}
					]
					MethodSpec.methodBuilder(it.operationRef.name).addModifiers(Modifier.PUBLIC).returnType(type).
						addParameters(parameters).openMethod(typeResolved).compileBody(it.body, new CompilerExpressionCtx('''???REVISITOR???''', aleClass, eclscls as EClass)).closeMethod(type).build
				] ?: newArrayList).build
				val operationImplementationFile = JavaFile.builder('''«dsl.revisitorOperationImplementationPackage»''',
					operationImplementation).build
				operationImplementationFile.writeTo(compileDirectory)

			} catch (Exception e) {
				println(it)
				e.printStackTrace
			}
		]
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
			builderSeed.beginControlFlow('''for($T $L: $L)''', (lt.collectionType.type as EClass).solveType,
				body.variable, body.collectionExpression.compileExpression(ctx)).compileBody(body.body, ctx).endControlFlow
		} else {
			val iteratorType = lt.collectionType.type.resolveType2
			val iteratorName = body.variable
			val iterable = body.collectionExpression.compileExpression(ctx)
			builderSeed.beginControlFlow('''for($T $L: $L)''', iteratorType, iteratorName, iterable).
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

	@Deprecated
	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.metamodelsSources.head).value
		gm.genPackages.head.qualifiedPackageName
	}
	
	
	/**
	 * FIXME: duplicated from RevisitorInterfaceGenerator
	 */
	def allClassesCompl(EPackage pkg) {
		(pkg.allClasses + pkg.getComplementaryFromEPackage [ Map.Entry<String, String> z |
			z.key.loadEPackage.allClasses
		]).toMap(['''«it.EPackage.name».«it.name»'''], [it]).values.sortByName
	}
	
	def computeFullInterfaceType(List<Pair<EClass, EClass>> pairs) {
		val tmp = syntaxes.get(dsl.metamodelsSources.head)
//		val syntax = tmp.key
		val genSyntax = tmp.value.genPackages.head
		val allClasses = pairs
			.map[dsl.getRevisitorOperationInterfaceClassName(it.key as EClass)]
		
//		val typeParams = #[TypeName.get(Object)]
		/*resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry"]
			.filter [
				it.eCls instanceof EClass
			].sortWith(comparator).map[dsl.getRevisitorOperationInterfaceClassName(it.eCls as EClass)]*/
		ParameterizedTypeName.get(
			ClassName.get(genSyntax.revisitorPackageFqn, genSyntax.revisitorInterfaceName), allClasses)
	}
	
	def buildSpecializedInterface(File compileDirectory, ParameterizedTypeName fullInterfaceType, List<Pair<EClass, EClass>> pairs) {
		val interfaceName = dsl.revisitorImplementationClass
//		val tmp = syntaxes.get(dsl.allSyntaxes.head)
//		val syntax = tmp.key
		

		val revisitorInterface = TypeSpec.interfaceBuilder(interfaceName)
			.addSuperinterface(fullInterfaceType)
			.addModifiers(Modifier.PUBLIC)
//			.addMethods(syntax.allClasses.filter [
//				it.instanceClassName != "java.util.Map$Entry"
//			].map [
//				MethodSpec.methodBuilder(it.denotationName)
//.returns(dsl.getRevisitorOperationInterfaceClassName(it))
// .addParameter(it.solveType, "it").addCode('''
//						return new $T(it, this);
//					''', dsl.getRevisitorOperationImplementationClassName(it)).addModifiers(Modifier.DEFAULT,
//						Modifier.PUBLIC).build
//			])
			.addMethods(pairs.map[
				val methodName = if(it.value === null) {
					'''«it.key.EPackage.name»__«it.key.name»'''
				} else {
					'''«it.key.EPackage.name»__«it.key.name»__AS__«it.value.EPackage.name»__«it.value.name»'''
				}
				
				MethodSpec.methodBuilder(methodName)
					.returns(dsl.getRevisitorOperationInterfaceClassName(it.key))
					.addParameter(it.key.solveType, "it")
					.addCode('''
						return new $T(it, this);
					''', dsl.getRevisitorOperationImplementationClassName(it.key)).addModifiers(Modifier.DEFAULT,
						Modifier.PUBLIC).build
			])
				
			.build

		val javaFile = JavaFile.builder(dsl.revisitorImplementationPackage, revisitorInterface).indent('\t').build

		javaFile.writeTo(compileDirectory)
	}
	
	def Set<Pair<EClass, EClass>> computeEClassPairs() {
		val tmp = syntaxes.get(dsl.metamodelsSources.head)
//		val syntax = tmp.key
//		val genSyntax = tmp.value.genPackages.head
//		val interfaceName = dsl.revisitorImplementationClass
//		val comparator = Comparator.comparing(new Function<ResolvedClass, String>() {
//			override apply(ResolvedClass arg0) {
//				arg0.eCls.name
//			}
//		}).thenComparing(new Function<ResolvedClass, String>() {
//			override apply(ResolvedClass arg0) {
//				arg0.eCls.EPackage.name
//			}
//		})
		
		val pkg = tmp.key
		
		pkg.allClassesCompl.filter[it.instanceClassName != "java.util.Map$Entry"].toSet.toList.buildExtendedFactoryNames
		.toSet
	}
}
