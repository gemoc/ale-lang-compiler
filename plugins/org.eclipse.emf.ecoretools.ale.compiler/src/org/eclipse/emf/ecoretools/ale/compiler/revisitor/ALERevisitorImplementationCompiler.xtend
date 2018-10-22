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
import org.eclipse.emf.ecoretools.ale.compiler.NamingUtils
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
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.xbase.lib.Functions.Function0

class ALERevisitorImplementationCompiler {

	@Data
	static class ResolvedClass {
		ExtendedClass alexCls
		public EClass eCls
		GenClass genCls
	}

	extension NamingUtils = new NamingUtils
	extension EcoreUtils = new EcoreUtils

	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	val Map<String, Class<?>> registeredServices = newHashMap
	val JavaExtensionsManager javaExtensions
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	var List<ResolvedClass> resolved

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

	def compile(String projectName, File projectRoot, Dsl dsl) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

		registerServices(projectName)

		// must be last !
		compile(projectRoot)
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

		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		// load all syntaxes in a cache
		syntaxes = dsl.allSyntaxes.toMap([it], [(loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel)])

		val syntax = syntaxes.get(dsl.allSyntaxes.head).key

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
		val typeParams = resolved.sortWith(comparator).map [
			ClassName.get('''«dsl.revisitorImplementationPackage».operation''', it.eCls.name)
		]
		val fullInterfaceType = ParameterizedTypeName.get(
			ClassName.get(syntax.revisitorPackageFqn, syntax.revisitorInterfaceName), typeParams)

		val revisitorInterface = TypeSpec.interfaceBuilder(interfaceName).addSuperinterface(fullInterfaceType).
			addModifiers(Modifier.PUBLIC).addMethods(syntax.allClasses.map [
				MethodSpec.methodBuilder(it.denotationName).returns(
					ClassName.get('''«dsl.revisitorImplementationPackage».operation''', it.name)).addParameter(
					it.solveType as TypeName, "it").addStatement('''return new $T(it, this)''',
					ClassName.get('''«dsl.revisitorImplementationPackage».operation.impl''', '''«it.name»Impl''')).
					addModifiers(Modifier.DEFAULT, Modifier.PUBLIC).build
			]).build

		val javaFile = JavaFile.builder(dsl.revisitorImplementationPackage, revisitorInterface).build

		javaFile.writeTo(compileDirectory)

		resolved.forEach [
			try {
				val operationInterface = TypeSpec.interfaceBuilder(it.eCls.name).addSuperinterfaces(eCls.ESuperTypes.map [
					ClassName.get('''«dsl.revisitorImplementationPackage».operation''', it.name)
				]).addModifiers(Modifier.PUBLIC).addMethods(it.alexCls?.methods?.map [
					MethodSpec.methodBuilder(it.operationRef.name).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).
						returnType(it.operationRef.EType).addParameters(it.operationRef.EParameters.map [
							if (it.EType.instanceClass !== null) {
								ParameterSpec.builder(it.EType.instanceClass, it.name).build
							} else {
								ParameterSpec.builder(it.EType.resolveType, it.name).build
							}
						]).build
				] ?: newArrayList).build
				val operationInterfaceFile = JavaFile.builder('''«dsl.revisitorImplementationPackage».operation''',
					operationInterface).build
				operationInterfaceFile.writeTo(compileDirectory)

				val revField = FieldSpec.builder(fullInterfaceType, "rev", Modifier.PRIVATE).build

				val objField = FieldSpec.builder(ClassName.get(getEcoreInterfacesPackage, it.eCls.name), "obj",
					Modifier.PRIVATE).build

				val operationImplementation = TypeSpec.classBuilder('''«it.eCls.name»Impl''').addSuperinterfaces(
					#[ClassName.get(operationInterfaceFile.packageName, operationInterface.name)]).superOperationImpl(
					it.eCls.ESuperTypes.head).addField(revField).addField(objField).addModifiers(Modifier.PUBLIC).
					addMethod(
						MethodSpec.constructorBuilder.addParameter(objField.type, "obj").addParameter(revField.type,
							"rev").addConditionalStatement([!it.ECls.ESuperTypes.empty], 'super(obj, rev)').
							addStatement('''this.obj = obj''').addStatement('''this.rev = rev''').addModifiers(
								Modifier.PUBLIC).build).addModifiers(Modifier.PUBLIC).addMethods(
						it.alexCls?.methods?.map [
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
					builder('''«dsl.revisitorImplementationPackage».operation.impl''', operationImplementation).build
				operationImplementationFile.writeTo(compileDirectory)

			} catch (Exception e) {
				println(it)
				e.printStackTrace
			}
		]
	}

	def MethodSpec.Builder openMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement('''$T result''', type.solveType)
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
				addStatement('''«body.target.compileExpression.escapeDollar».set«body.targetFeature.toFirstUpper»(«body.value.compileExpression.escapeDollar»)''')
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
		builderSeed.addStatement('''«body.name» = «body.value.compileExpression.escapeDollar»''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body) {

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression.escapeDollar»)''', t,
				body.name, t)
		} else {
			val t = body.type.solveType
			// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression.escapeDollar»)''', t,
				body.name, t)

		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, Block body) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement)
		])
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ExpressionStatement body) {
		builderSeed.addStatement(body.expression.compileExpression.escapeDollar)
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
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression»)''',
				lt.collectionType.type as Class<?>, body.variable).compileBody(body.body).endControlFlow
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

	def dispatch String compileExpression(Call call) {
		switch (call.serviceName) {
			case "not": '''!(«call.arguments.get(0).compileExpression»)'''
			case "greaterThan": '''(«call.arguments.get(0).compileExpression») > («call.arguments.get(1).compileExpression»)'''
			case "differs": '''(«call.arguments.get(0).compileExpression») != («call.arguments.get(1).compileExpression»)'''
			case "sub": '''(«call.arguments.get(0).compileExpression») - («call.arguments.get(1).compileExpression»)'''
			case "add": '''(«call.arguments.get(0).compileExpression») + («call.arguments.get(1).compileExpression»)'''
			case "divOp": '''(«call.arguments.get(0).compileExpression») / («call.arguments.get(1).compileExpression»)'''
			case "equals": '''java.util.Objects.equals((«call.arguments.get(0).compileExpression»), («call.arguments.get(1).compileExpression»))'''
			case "lessThan": '''(«call.arguments.get(0).compileExpression») < («call.arguments.get(1).compileExpression»)'''
			case "mult": '''(«call.arguments.get(0).compileExpression») * («call.arguments.get(1).compileExpression»)'''
			case "unaryMin": '''-(«call.arguments.get(0).compileExpression»)'''
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(«call.arguments.get(0).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», it -> it instanceof «call.arguments.get(1).compileExpression»)'''
					} else {
						'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
					}
				} else {
					'''/*FIRST «call»*/'''
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(«call.arguments.get(0).compileExpression»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					'''«call.arguments.get(0).compileExpression» instanceof «call.arguments.get(1).compileExpression»'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(«call.arguments.get(0).compileExpression»)'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							'''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
								(t.type as EDataType).instanceClass == boolean))
								'''«call.arguments.head.compileExpression».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
							else
								'''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else {
							'''«call.arguments.head.compileExpression».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»'''

						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val gm = findGenModelFromExpression(e)
						'''«gm.genPackages.head.qualifiedPackageName».«gm.EPackage.name.toFirstUpper»Factory.eINSTANCE.create«(t.type as EClass).name»()'''
					} else {

						// TODO: better identification of the caller in order to route to a $ operation or a service.
						val openClazz = EcoreUtil2.getContainerOfType(call, ExtendedClass)
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
							val allMethods = re.getAlexCls.allMethods
							val methodExist = allMethods.exists [
								it.operationRef.name == call.serviceName
							]
							if (methodExist) {
								'''rev.$(«call.arguments.head.compileExpression»).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
							} else {

								// duplicate to following else block !!!
								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[java.lang.reflect.Modifier.isStatic(it.value.modifiers)].
									filter [
										it.value.name == call.serviceName
									].head

								if (candidate !== null) {
									'''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)'''
								} else {
									'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''

								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[java.lang.reflect.Modifier.isStatic(it.value.modifiers)].
								filter [
									it.value.name == call.serviceName
								].head

							if (candidate !== null) {
								'''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)'''
							} else {
								'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''

							}
						}
					}
				else
					'''/*Call «call»*/'''
		}
	}

	def dispatch String compileExpression(And call) {
		'''((«call.arguments.get(0).compileExpression») && («call.arguments.get(1).compileExpression»))'''
	}

	def dispatch String compileExpression(ErrorCall call) {
		'''/*ERRORCALL*/'''
	}

	def dispatch String compileExpression(Implies call) {
		'''/*IMPLIES*/'''
	}

	def dispatch String compileExpression(Or call) {
		'''((«call.arguments.get(0).compileExpression») || («call.arguments.get(1).compileExpression»))'''
	}

	def dispatch String compileExpression(ErrorConditional call) {
		'''/*ERRORCONDITIONAL*/'''
	}

	def dispatch String compileExpression(ErrorBinding call) {
		'''/*ERRORBINDING*/'''
	}

	def dispatch String compileExpression(EEnumLiteral call) {
		'''/*EENUMLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorExpression call) {
		'''/*ERROREXPRESSION*/'''
	}

	def dispatch String compileExpression(ErrorStringLiteral call) {
		'''/*ERRORSTRINGLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorTypeLiteral call) {
		'''/*ERRORTYPELITERAL*/'''
	}

	def dispatch String compileExpression(ErrorVariableDeclaration call) {
		'''/*ERRORVARIABLEDECLARATION*/'''
	}

	def dispatch String compileExpression(Let call) {
		'''/*let*/'''
	}

	def dispatch String compileExpression(BooleanLiteral call) {
		if(call.value) 'true' else 'false'
	}

	def dispatch String compileExpression(EnumLiteral call) {
		'''/*ENUMLITERAL*/'''
	}

	def dispatch String compileExpression(IntegerLiteral call) {
		call.value.toString
	}

	def dispatch String compileExpression(Lambda call) {
		'''(«FOR p : call.parameters SEPARATOR ', '»«p.name»«ENDFOR») -> «call.expression.compileExpression»'''
	}

	def dispatch String compileExpression(NullLiteral call) {
		'null'
	}

	def dispatch String compileExpression(RealLiteral call) {
		call.value.toString
	}

	def dispatch String compileExpression(SequenceInExtensionLiteral call) {
		'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression»«ENDFOR»)'''
	}

	def dispatch String compileExpression(SetInExtensionLiteral call) {
		'''/*SETINEXTENSIONLITERAL*/'''
	}

	def dispatch String compileExpression(StringLiteral call) {
		'''"«call.value»"'''
	}

	def dispatch String compileExpression(TypeLiteral call) {
		'''«(call.value as EClass).solveType»'''
	}

	def dispatch String compileExpression(Switch call) {
		'''/*SWITCH*/'''
	}

	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def dispatch String compileExpression(VarRef call) {
		if(call.variableName == 'self') 'this.obj' else call.variableName
	}

	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		edt.instanceClass
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
		syntax.allClasses.map [ eClass |
			val aleClass = aleClasses.filter [
				it.name == eClass.name || it.name == eClass.EPackage.name + '.' + eClass.name
			].head
			val GenClass gl = syntaxes.filter[k, v|v.key.allClasses.contains(eClass)].values.map[value].map [
				it.genPackages.map[it.genClasses].flatten
			].flatten.filter[it.ecoreClass == eClass].head
			new ResolvedClass(aleClass, eClass, gl)
		]
	}

	def infereType(Expression exp) {
		val base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		base.getPossibleTypes(exp)
	}

	def resolveType(EClassifier e) {
		val stxs = syntaxes.values + #[(EcorePackage.eINSTANCE -> null)]
		val stx = stxs.filter [
			it.key.allClasses.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			val GenClass gclass = gm.allGenPkgs.map [
				it.genClasses.filter [
					it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
				]
			].flatten.head
			val split = gclass.qualifiedInterfaceName.split("\\.")
			val pkg = newArrayList(split).reverse.tail.toList.reverse.join(".")
			val cn = split.last
			ClassName.get(pkg, cn)
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

	def escapeDollar(String s) {
		s.replaceAll("\\$\\(", "\\$\\$(")
	}

	def TypeSpec.Builder superOperationImpl(TypeSpec.Builder builder, EClass clazz) {
		if (clazz !== null) {
			builder.superclass(
				ClassName.get('''«dsl.revisitorImplementationPackage».operation.impl''', '''«clazz.name»Impl'''))
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
		val ecls = resolved.filter[it.alexCls == aleClass].head.eCls

		resolved.filter[it.eCls == ecls || it.eCls.isSuperTypeOf(ecls)].map [
			it.alexCls
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
