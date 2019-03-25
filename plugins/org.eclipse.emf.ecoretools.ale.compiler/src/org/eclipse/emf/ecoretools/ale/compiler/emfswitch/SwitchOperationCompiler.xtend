package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.lang.reflect.Modifier
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.And
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
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
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
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

import static javax.lang.model.element.Modifier.*

class SwitchOperationCompiler {

	extension SwitchNamingUtils namingUtils = new SwitchNamingUtils
	extension JavaPoetUtils = new JavaPoetUtils
	extension EcoreUtils = new EcoreUtils
	extension TypeSystemUtils tsu

	val String packageRoot
	val File directory
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val IQueryEnvironment queryEnvironment
	val List<ParseResult<ModelUnit>> parsedSemantics
	val List<ResolvedClass> resolved
	val BaseValidator base
	val Map<String, Class<?>> registeredServices
	val Dsl dsl
	

	new(String packageRoot, File directory, Map<String, Pair<EPackage, GenModel>> syntaxes, IQueryEnvironment queryEnvironment, List<ParseResult<ModelUnit>> parsedSemantics, List<ResolvedClass> resolved, Map<String, Class<?>> registeredServices, Dsl dsl) {
		this.packageRoot = packageRoot
		this.directory = directory
		this.syntaxes = syntaxes
		this.queryEnvironment = queryEnvironment
		this.parsedSemantics = parsedSemantics
		this.resolved = resolved
		base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		this.tsu =  new TypeSystemUtils(syntaxes, packageRoot, base, resolved)
		this.registeredServices = registeredServices
		this.dsl = dsl
	}

	def compile(ResolvedClass resolved) {
		
		val eClassType = ClassName.get(resolved.genCls.genPackage.interfacePackageName, resolved.genCls.interfaceName)
		val switchType = ClassName.get(namingUtils.switchImplementationPackageName(packageRoot), namingUtils.switchImplementationClassName(packageRoot))
		
		val operationsPackage = namingUtils.operationPackageName(packageRoot)
		
		val factory = TypeSpec.classBuilder(namingUtils.operationClassName(resolved.eCls))
			.applyIfTrue(!(resolved.eCls as EClass).ESuperTypes.empty, [superclass(ClassName.get(operationsPackage, namingUtils.operationClassName((resolved.eCls as EClass).ESuperTypes.head)))])
			.addField(eClassType, 'it', PRIVATE, FINAL)
			.addField(switchType, 'emfswitch', PRIVATE, FINAL)
			.addMethod(MethodSpec.constructorBuilder
				.addParameter(eClassType, 'it')
				.addParameter(switchType, 'emfswitch')
				.addCode('''
				«IF !(resolved.eCls as EClass).ESuperTypes.empty»
				super(it, emfswitch);
				«ENDIF»
				this.it = it;
				this.emfswitch = emfswitch;
				''')
				.addModifiers(PUBLIC)
				.build
			)
			.applyIfTrue(resolved.getAleCls !== null, [addMethods(resolved.getAleCls.methods.map[compileMethodB])])
			.addModifiers(PUBLIC)
			.build

		val javaFile = JavaFile.builder(operationsPackage, factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
	
	def MethodSpec compileMethodB(Method method) {
		val retType = if (method.operationRef.EType !== null) {
				if (method.operationRef.EType instanceof EClass &&
					!(method.operationRef.EType.EPackage == EcorePackage.eINSTANCE)) {
					ClassName.get(getEcoreInterfacesPackage, (method.operationRef.EType as EClass).name)
				} else {
					TypeName.get(method.operationRef.EType.instanceClass)

				}
			} else
				null

		MethodSpec
			.methodBuilder(method.operationRef.name)
			.applyIfTrue(retType !== null, [returns(retType)])
			.addParameters(method.operationRef.EParameters.map [ param |
				if (param.EType.instanceClass !== null) {
					if (param.EType instanceof EClass && !(param.EType.EPackage == EcorePackage.eINSTANCE)) {
						ParameterSpec.builder(
							ClassName.get(getEcoreInterfacesPackage, (param.EType as EClass).name), param.name).
							build
					} else {
						ParameterSpec.builder(param.EType.instanceClass, param.name).build

					}
				} else {
					ParameterSpec.builder(param.EType.resolveType, param.name).build
				}
			])
			.addModifiers(PUBLIC)
			.openMethod(method.operationRef.EType)
			.compileBody(method.body)
			.closeMethod(method.operationRef.EType)
			.build
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
			if (e instanceof EClass) {
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
			} else {
				val GenClass gclass = gm.allGenPkgs.map [
					it.genClasses.filter [
						it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
					]
				].flatten.head
				val split = gclass.qualifiedInterfaceName.split("\\.")
				val pkg = newArrayList(split).reverse.tail.toList.reverse.join(".")
				val cn = split.last
				ClassName.get(pkg, cn)

			}
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}

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
	
	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		edt.instanceClass
	}
	
	def infereType(Expression exp) {
		
		base.getPossibleTypes(exp)
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
		builderSeed.addStatement('''«body.name» = «body.value.compileExpression»''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body) {

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression»)''', t,
				body.name, t)
		} else {
			val t = body.type.solveType
			// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression»)''', t,
				body.name, t)

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
			builderSeed.beginControlFlow('''for ($T $L: «body.collectionExpression.compileExpression»)''',
				(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body).endControlFlow
		} else {
			builderSeed.beginControlFlow('''for ($T $L: «body.collectionExpression.compileExpression»)''',
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
			case "lessThanEqual": '''(«call.arguments.get(0).compileExpression») <= («call.arguments.get(1).compileExpression»)'''
			case "greaterThanEqual": '''(«call.arguments.get(0).compileExpression») >= («call.arguments.get(1).compileExpression»)'''
			case "mult": '''(«call.arguments.get(0).compileExpression») * («call.arguments.get(1).compileExpression»)'''
			case "unaryMin": '''-(«call.arguments.get(0).compileExpression»)'''
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(«call.arguments.get(0).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(«call.arguments.get(0).compileExpression»)'''
				else if (call.type == CallType.CALLORAPPLY)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(«call.arguments.get(0).compileExpression»)'''
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
			case "exists":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.exists(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
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

						// it t is in the hierarchy of the current context eClass (as itself or one of his parents), we can skip the accessor and directly point to the field
						val lhs = call.arguments.head.compileExpression
						if (lhs.toString == 'this') {
							if (t instanceof SequenceType 
								&& (t as SequenceType).collectionType.type instanceof EClass 
								&& ((t as SequenceType).collectionType.type as EClass).instanceClassName != "java.util.Map$Entry"  
								) {
									val rhs = (call.arguments.get(1) as StringLiteral).value
								
									'''«lhs».get«rhs.toFirstUpper»()'''
							} else if (t.type instanceof EClass || t.type instanceof EDataType) {
								'''«lhs».«(call.arguments.get(1) as StringLiteral).value»'''
							} else {
								'''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»«(call.arguments.get(1) as StringLiteral).value»«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»'''
							}

						} else {
							if (t instanceof SequenceType &&
								(t as SequenceType).collectionType.type instanceof EClass) {
								'''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
							} else if (t !== null && (t.type instanceof EClass || t.type instanceof EDataType)) {
								if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
									(t.type as EDataType).instanceClass == boolean))
									'''«lhs».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
								else
									'''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
							} else {
								'''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»'''
							}
						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						'''«getEcoreInterfacesPackage».«epks.factoryInterfaceClassName».eINSTANCE.create«ecls.name»()'''
					} else {
						val argumentsh = call.arguments.head
						val ts = argumentsh.infereType
						val t = ts.head
						val re = resolved.filter [
							if (t !== null && t.type instanceof EClass) {
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
								val methods = allMethods.filter[it.operationRef.name == call.serviceName].toList

								/* Look for the most specific method that matches the resolved class by walking up the hierarchy */
								var Method method = null
								var ResolvedClass rev = re
								while (method === null) {
									val lc = rev.aleCls
									method = methods.filter[it.eContainer === lc].head

									val revc = rev
									rev = resolved.filter [
										revc.eCls instanceof EClass &&
											(revc.eCls as EClass).ESuperTypes.contains(it.eCls)
									].head
								}
								
								
								// lookup if one of the method declaration is declared with a dispatch
								var isDispatch=false
								rev = re
								while(!isDispatch && rev !== null) {
									val lc = rev.aleCls
									method = methods.filter[it.eContainer === lc].head
									
									isDispatch = method !== null && method.isDispatch

									val revc = rev
									rev = resolved.filter [
										revc.eCls instanceof EClass &&
											(revc.eCls as EClass).ESuperTypes.contains(it.eCls)
									].head
								}
								
//								'''((«namingUtils.operationPackageName(packageRoot)».«namingUtils.operationClassName(t.type as EClass)») emfswitch.doSwitch(«call.arguments.head.compileExpression»)).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
								
								
								// CASE A
//								'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)/*CASEA*/'''
								'''/*CASEA*/((«namingUtils.operationPackageName(packageRoot)».«namingUtils.operationClassName((t.type as EClassifier).solveType)») emfswitch.doSwitch(«call.arguments.head.compileExpression»)).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
							} else {

								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
									it.value.name == call.serviceName
								].head

								if (candidate !== null) {
									// CASE B
									'''/*CASEB*/«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)'''
								} else {
									// CASE C
//									'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)/*CASEC*/'''
									'''/*CASEC*/((«namingUtils.operationPackageName(packageRoot)».«namingUtils.operationClassName((t.type as EClassifier).solveType)») emfswitch.doSwitch(«call.arguments.head.compileExpression»)).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
								it.value.name == call.serviceName
							].head

							if (candidate !== null) {
								'''/*CASED*/«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)'''
							} else {
								// CASE D
//								'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)/*CASED*/'''
									if(t !== null && t.type !== null && t.type instanceof EClassifier && (t.type as EClassifier).solveType instanceof EClass )
										'''/*CASEE*/((«namingUtils.operationPackageName(packageRoot)».«namingUtils.operationClassName((t.type as EClassifier).solveType as EClass)») emfswitch.doSwitch(«call.arguments.head.compileExpression»)).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
									else
										'''/*CASEF*/«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''

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

	def dispatch String compileExpression(VarRef call) {
		if(call.variableName == 'self') 'this.it' else call.variableName
	}
	
	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}
	
}
