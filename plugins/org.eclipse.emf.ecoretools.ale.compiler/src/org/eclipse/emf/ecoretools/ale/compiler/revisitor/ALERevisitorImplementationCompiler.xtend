package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
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
import java.util.Objects
import java.util.function.Function
import javax.lang.model.element.Modifier
import org.eclipse.acceleo.query.ast.And
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.ast.BooleanLiteral
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.CallType
import org.eclipse.acceleo.query.ast.EnumLiteral
import org.eclipse.acceleo.query.ast.ErrorBinding
import org.eclipse.acceleo.query.ast.ErrorCall
import org.eclipse.acceleo.query.ast.ErrorConditional
import org.eclipse.acceleo.query.ast.ErrorExpression
import org.eclipse.acceleo.query.ast.ErrorStringLiteral
import org.eclipse.acceleo.query.ast.ErrorTypeLiteral
import org.eclipse.acceleo.query.ast.ErrorVariableDeclaration
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.Implies
import org.eclipse.acceleo.query.ast.IntegerLiteral
import org.eclipse.acceleo.query.ast.Lambda
import org.eclipse.acceleo.query.ast.Let
import org.eclipse.acceleo.query.ast.NullLiteral
import org.eclipse.acceleo.query.ast.Or
import org.eclipse.acceleo.query.ast.RealLiteral
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral
import org.eclipse.acceleo.query.ast.SetInExtensionLiteral
import org.eclipse.acceleo.query.ast.StringLiteral
import org.eclipse.acceleo.query.ast.TypeLiteral
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.validation.type.EClassifierType
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
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
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager
import org.eclipse.xtext.xbase.lib.Functions.Function0
import java.util.stream.IntStream
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass

class ALERevisitorImplementationCompiler {

	extension RevisitorNamingUtils = new RevisitorNamingUtils
	extension EcoreUtils = new EcoreUtils

	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	val Map<String, Class<?>> registeredServices = newHashMap
	val JavaExtensionsManager javaExtensions
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	var List<ResolvedClass> resolved
	var BaseValidator base

	new() {
		this.queryEnvironment = createQueryEnvironment(false, null)
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE)
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE)
		javaExtensions = JavaExtensionsManager.createManagerWithOverride();
		javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {

			override loaded(String arg0, Class<?> arg1) {
				registeredServices.put(arg0, arg1)
			}

			override notFound(String arg0) {
				throw new RuntimeException('''«arg0» not found during services registration''')
			}

			override unloaded(String arg0, Class<?> arg1) {
				registeredServices.remove(arg0);
			}

		});
	}

	def IStatus compile(String projectName, File projectRoot, Dsl dsl) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

		registerServices(projectName)

		// must be last !
		compile(projectRoot)

		Status.OK_STATUS
	}

	def registerServices(String projectName) {

		javaExtensions.updateScope(newHashSet(), #{projectName});

		val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
		registerServices(services.toList);
	}

	def registerServices(List<String> services) {
		services.forEach[javaExtensions.addImport(it)]
		javaExtensions.reloadIfNeeded();
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
		val tmp = syntaxes.get(dsl.allSyntaxes.head)
		val syntax = tmp.key
		// FIXME: make the invalid assumption that the metamodel contains a single package
		val genSyntax = tmp.value.genPackages.head
		resolved = resolve(aleClasses, syntax)

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
							MethodSpec.methodBuilder(it.operationRef.name).addModifiers(Modifier.PUBLIC).returnType(
								it.operationRef.EType).addParameters(it.operationRef.EParameters.map [
								if (it.EType.instanceClass !== null) {
									ParameterSpec.builder(it.EType.instanceClass, it.name).build
								} else {
									ParameterSpec.builder(it.EType.resolveType, it.name).build
								}
							]).openMethod(it.operationRef.EType).compileBody(it.body).closeMethod(
								it.operationRef.EType).build
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

	def MethodSpec.Builder openMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement('''$T result''', type.resolveType2)
		} else {
			builder
		}
	}

	def MethodSpec.Builder closeMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement("return result")
		} else {
			builder
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.
				addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression»)''')
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
	
	def dispatch TypeName resolveType2(Object type) {
		return null
	}
	
	def dispatch TypeName resolveType2(Class<?> clazz) {
		return TypeName.get(clazz)
	}
	
	def dispatch TypeName resolveType2(EClassifier type) {
		if (type.instanceClass !== null) {
			TypeName.get(type.instanceClass)
		} else {
			type.resolveType
		}	
	}

	def dispatch CodeBlock compileExpression(Call call) {
		switch (call.serviceName) {
			case "not": CodeBlock.of('''!($L)''', call.arguments.get(0).compileExpression)
			case "greaterThan": CodeBlock.of('''($L) > ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "differs": CodeBlock.of('''($L) != ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "sub": CodeBlock.of('''($L) - ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "add": CodeBlock.of('''($L) + ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "divOp": CodeBlock.of( '''($L) / ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "equals": CodeBlock.of('''$T.equals(($L), ($L))''', ClassName.get(Objects), call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "lessThan": CodeBlock.of('''($L) < ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "lessThanEqual": CodeBlock.of('''($L) <= ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "greaterThanEqual":
				CodeBlock.of('''($L) >= ($L)''', call.arguments.get(0).compileExpression,
					call.arguments.get(1).compileExpression)
			case "mult": CodeBlock.of('''(«call.arguments.get(0).compileExpression») * («call.arguments.get(1).compileExpression»)''')
			case "unaryMin": CodeBlock.of('''-(«call.arguments.get(0).compileExpression»)''')
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.head($L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression)
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.size($L)''', ClassName.get('org.eclipse.emf.ecoretools.ale.compiler.lib', 'CollectionService'), call.arguments.get(0).compileExpression)
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.get($L, $L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.select($L, $L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						CodeBlock.of('''$T.select($L, it -> it instanceof $L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
					} else {
						CodeBlock.of('''$T.select($L, $L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
					}
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "exists":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.exists($L, $L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.isEmpty($L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression)
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.of('''$L instanceof $L''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.of('''$T.log($L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService"),
						call.arguments.get(0).compileExpression)
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							CodeBlock.of('''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
								(t.type as EDataType).instanceClass == boolean))
								CodeBlock.of('''«call.arguments.head.compileExpression».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
							else
								CodeBlock.of('''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
						} else {
							CodeBlock.of('''«call.arguments.head.compileExpression».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»''')
						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val gm = findGenModelFromExpression(e)
						CodeBlock.of('''$T.eINSTANCE.create«(t.type as EClass).name»()''', ClassName.get(gm.genPackages.head.qualifiedPackageName, '''«gm.EPackage.name.toFirstUpper»Factory'''))
					} else {

						// TODO: better identification of the caller in order to route to a $ operation or a service.
						val argumentsh = call.arguments.head
						val ts = argumentsh.infereType
						val t = ts.head
						val re = resolved.filter [
							if (t.type instanceof EClass) {
								val tecls = t.type as EClass
								it.ECls.name == tecls.name && it.ECls.EPackage.name == tecls.EPackage.name
							} else {
								false
							}
						].head
						if (re !== null) {
							val allMethods = re.getAleCls.allMethods
							val methodExist = allMethods.exists [
								it.operationRef.name == call.serviceName
							]
							if (methodExist) {
								// TODO: also add explicit cast on parameters !
								val hm = newHashMap(
									'dispatch' -> "$", 
									"callerType" -> t.type.resolveType2
								)
								
								call.arguments.tail.enumerate.forEach[
									hm.put('paramType' + it.value, it.key.infereType.head.type.resolveType2)
								]
								
								CodeBlock.builder.addNamed('''rev.$dispatch:L(($callerType:T)«call.arguments.head.compileExpression»).«call.serviceName»(«FOR param : call.arguments.tail.enumerate SEPARATOR ','»(($paramType«param.value»:T)«param.key.compileExpression»)«ENDFOR»)''', hm).build
							} else {

								// duplicate to following else block !!!
								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[java.lang.reflect.Modifier.isStatic(it.value.modifiers)].
									filter [
										it.value.name == call.serviceName
									].head

								if (candidate !== null) {
									CodeBlock.of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)''')
								} else {
									CodeBlock.of('''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)''')

								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[java.lang.reflect.Modifier.isStatic(it.value.modifiers)].
								filter [
									it.value.name == call.serviceName
								].head

							if (candidate !== null) {
								CodeBlock.of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)''')
							} else {
								CodeBlock.of('''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)''')

							}
						}
					}
				else
					CodeBlock.of('''/*Call «call»*/''')
		}
	}
	
	def <A> enumerate(Iterable<A> itt) {
		val ints = IntStream.range(0, itt.size).iterator
		itt.map[it -> ints.next]
	}

	def dispatch CodeBlock compileExpression(And call) {
		CodeBlock.of('''((«call.arguments.get(0).compileExpression») && («call.arguments.get(1).compileExpression»))''')
	}

	def dispatch CodeBlock compileExpression(ErrorCall call) {
		CodeBlock.of('''/*ERRORCALL*/''')
	}

	def dispatch CodeBlock compileExpression(Implies call) {
		CodeBlock.of('''/*IMPLIES*/''')
	}

	def dispatch CodeBlock compileExpression(Or call) {
		CodeBlock.of('''((«call.arguments.get(0).compileExpression») || («call.arguments.get(1).compileExpression»))''')
	}

	def dispatch CodeBlock compileExpression(ErrorConditional call) {
		CodeBlock.of('''/*ERRORCONDITIONAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorBinding call) {
		CodeBlock.of('''/*ERRORBINDING*/''')
	}

	def dispatch CodeBlock compileExpression(EEnumLiteral call) {
		CodeBlock.of('''/*EENUMLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorExpression call) {
		CodeBlock.of('''/*ERROREXPRESSION*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorStringLiteral call) {
		CodeBlock.of('''/*ERRORSTRINGLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorTypeLiteral call) {
		CodeBlock.of('''/*ERRORTYPELITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorVariableDeclaration call) {
		CodeBlock.of('''/*ERRORVARIABLEDECLARATION*/''')
	}

	def dispatch CodeBlock compileExpression(Let call) {
		CodeBlock.of('''/*let*/''')
	}

	def dispatch CodeBlock compileExpression(BooleanLiteral call) {
		CodeBlock.of(if(call.value) 'true' else 'false')
	}

	def dispatch CodeBlock compileExpression(EnumLiteral call) {
		CodeBlock.of('''/*ENUMLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(IntegerLiteral call) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(Lambda call) {
		val Map<String, Object> hm = newHashMap(
			"expr" -> call.expression.compileExpression
		)
		for(param: call.parameters.enumerate) {
			hm.put("param" + param.value, param.key.name)
		}
		
		CodeBlock.builder
			.addNamed('''(«FOR p : call.parameters.enumerate SEPARATOR ', '»$param«p.value»:L«ENDFOR») -> $expr:L''', hm).build
	}

	def dispatch CodeBlock compileExpression(NullLiteral call) {
		CodeBlock.of('null')
	}

	def dispatch CodeBlock compileExpression(RealLiteral call) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(SequenceInExtensionLiteral call) {
		CodeBlock.of('''$T.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression»«ENDFOR»)''', ClassName.get('org.eclipse.emf.ecoretools.ale.compiler.lib', 'CollectionService'))
	}

	def dispatch CodeBlock compileExpression(SetInExtensionLiteral call) {
		CodeBlock.of('''/*SETINEXTENSIONLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(StringLiteral call) {
		CodeBlock.of('''"«call.value»"''')
	}

	def dispatch CodeBlock compileExpression(TypeLiteral call) {
		CodeBlock.of('''$T''', (call.value as EClass).solveType)
	}

	def dispatch CodeBlock compileExpression(Switch call) {
		CodeBlock.of('''/*SWITCH*/''')
	}

	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def dispatch CodeBlock compileExpression(VarRef call) {
		CodeBlock.of(if(call.variableName == 'self') 'this.obj' else call.variableName)
	}

	def dispatch TypeName solveType(EClass type) {
		resolveType(type)
	}

	def dispatch TypeName solveType(EDataType edt) {
		TypeName.get(edt.instanceClass)
	}

	def returnType(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			if (type.instanceClass !== null) {
				builder.returns(type.instanceClass)
			} else {
				builder.returns(type.resolveType)
			}
		} else {
			builder
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

	def infereType(Expression exp) {

		base.getPossibleTypes(exp)
	}

	def resolveType(EClassifier e) {
		val stxs = syntaxes.values + #[(EcorePackage.eINSTANCE -> null)]
		val stx = stxs.filter [
			it.key.allClassifiers.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			if (e instanceof EClass) {
				if(e.instanceClassName == "java.util.Map$Entry") {
					val keyType = e.EStructuralFeatures.filter[it.name == 'key'].head.EType.solveType
					val valueType = e.EStructuralFeatures.filter[it.name == 'value'].head.EType.solveType
					ParameterizedTypeName.get(ClassName.get(Map.Entry), keyType, valueType)
				} else{
					val GenClass gl = syntaxes.filter[k, v|v.key.allClasses.exists[it.name == e.name && it.EPackage.name == e.EPackage.name]].values.map[value].map [
						it.genPackages.map[it.genClasses].flatten
					].flatten.filter[
						it.ecoreClass.name == e.name && it.ecoreClass.EPackage.name == e.EPackage.name
					].head
					ClassName.get(gl.genPackage.interfacePackageName, e.name)
				
				}
			} else {
				val GenClassifier gclass = gm.allGenPkgs.map [
					it.genClassifiers.filter [
						it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
					]
				].flatten.head
				
				if(gclass instanceof GenClass) {
					ClassName.get(gclass.qualifiedInterfaceName, gclass.name)
				} else if (gclass instanceof GenEnum ) {
					ClassName.get(gclass.genPackage.interfacePackageName, gclass.name)
				}

			}
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}

	}

	def findGenModelFromExpression(Expression e) {
		val t = infereType(e).head
		syntaxes.values.filter [
			it.key.allClasses.exists [
				it.name == (t.type as EClassifier).name && it.EPackage.name == (t.type as EClassifier).EPackage.name
			]
		].head.value
	}

	def TypeSpec.Builder superOperationImpl(TypeSpec.Builder builder, EClass clazz) {
		if (clazz !== null) {
			builder.superclass(dsl.getRevisitorOperationImplementationClassName(clazz))
		} else {
			builder
		}
	}

	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}

	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls as EClass

		resolved.filter[it.eCls == ecls || (eCls as EClass).isSuperTypeOf(ecls)].map [
			it.aleCls
		].filter[it !== null]
	}

	def <F> MethodSpec.Builder addConditionalStatement(MethodSpec.Builder builder, Function0<Boolean> f, String s) {
		if (f.apply()) {
			builder.addStatement(s)
		} else {
			builder
		}
	}

}
