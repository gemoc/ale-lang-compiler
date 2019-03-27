package org.eclipse.emf.ecoretools.ale.compiler.visitor

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
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.visitor.ALEVisitorImplementationCompiler.ResolvedClass
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
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

import static javax.lang.model.element.Modifier.*
import com.squareup.javapoet.CodeBlock
import java.util.stream.IntStream

class OperationImplementationCompiler {

	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension JavaPoetUtils = new JavaPoetUtils
	extension VisitorTypeSystemUtil tsu
	val File directory
	val String packageRoot
	val IQueryEnvironment queryEnvironment
	val List<ParseResult<ModelUnit>> parsedSemantics
	val List<ResolvedClass> resolved
	val Map<String, Class<?>> registeredServices
	var BaseValidator base

	new(File directory, String packageRoot, Map<String, Pair<EPackage, GenModel>> syntaxes,
		IQueryEnvironment queryEnvironment, List<ParseResult<ModelUnit>> parsedSemantics, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices) {
		this.directory = directory
		this.packageRoot = packageRoot
		this.queryEnvironment = queryEnvironment
		this.parsedSemantics = parsedSemantics
		this.resolved = resolved
		this.registeredServices = registeredServices
		this.tsu = new VisitorTypeSystemUtil(syntaxes, namingUtils, packageRoot)
	}

	def compile(EClass eClass, ExtendedClass aleClass) {
		
		this.base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		
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

				val retType = method.operationRef.EType.resolveType2 

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
					]).addModifiers(PUBLIC).openMethod(method.operationRef.EType).compileBody(method.body).closeMethod(
						method.operationRef.EType).build
			])

		]).applyIfTrue(eClass.abstract, [addModifiers(ABSTRACT)]).build

		val javaFile = JavaFile.builder(namingUtils.operationImplementationPackageName(packageRoot, eClass), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
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

	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		edt.instanceClass
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

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T)$L)''', t, body.name, t, body.initialValue.compileExpression)
		} else {
			val t = body.type.solveType
			builderSeed.addStatement('''$T $L = (($T)$L)''', t, body.name, t, body.initialValue.compileExpression)
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

	def dispatch CodeBlock compileExpression(Call call) {
		switch (call.serviceName) {
			case "not": CodeBlock.of('''!(«call.arguments.get(0).compileExpression»)''')
			case "greaterThan": CodeBlock.of('''(«call.arguments.get(0).compileExpression») > («call.arguments.get(1).compileExpression»)''')
			case "differs": CodeBlock.of('''(«call.arguments.get(0).compileExpression») != («call.arguments.get(1).compileExpression»)''')
			case "sub": CodeBlock.of('''(«call.arguments.get(0).compileExpression») - («call.arguments.get(1).compileExpression»)''')
			case "add": CodeBlock.of('''(«call.arguments.get(0).compileExpression») + («call.arguments.get(1).compileExpression»)''')
			case "divOp": CodeBlock.of('''(«call.arguments.get(0).compileExpression») / («call.arguments.get(1).compileExpression»)''')
			case "equals": CodeBlock.of('''$T.equals((«call.arguments.get(0).compileExpression»), («call.arguments.get(1).compileExpression»))''', ClassName.get(java.util.Objects))
			case "lessThan": CodeBlock.of('''(«call.arguments.get(0).compileExpression») < («call.arguments.get(1).compileExpression»)''')
			case "mult": CodeBlock.of('''(«call.arguments.get(0).compileExpression») * («call.arguments.get(1).compileExpression»)''')
			case "unaryMin": CodeBlock.of('''-(«call.arguments.get(0).compileExpression»)''')
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.head(«call.arguments.get(0).compileExpression»)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.size(«call.arguments.get(0).compileExpression»)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.
						of('''$T.get(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)''',
							ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.
						of('''$T.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)''',
							ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						CodeBlock.
							of('''$T.select(«call.arguments.get(0).compileExpression», it -> it instanceof «call.arguments.get(1).compileExpression»)''',
								ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
					} else {
						CodeBlock.
							of('''$T.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)''',
								ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
					}
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.isEmpty(«call.arguments.get(0).compileExpression»)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					val lhs = call.arguments.get(0).compileExpression
					val rhs = call.arguments.get(1).compileExpression
					CodeBlock.of('''$L instanceof $L''', lhs, rhs)
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.of('''$T.log(«call.arguments.get(0).compileExpression»)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService"))
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
								CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
						} else {
							CodeBlock.of('''«call.arguments.head.compileExpression».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»''')

						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						CodeBlock.of('''$T.eINSTANCE.create«ecls.name»()''', ClassName.get(epks.factoryInterfacePackageName(packageRoot), epks.factoryInterfaceClassName))
					} else {
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
								val hm = newHashMap()
								hm.put("typecaller", (call.arguments.head.infereType.head.type as EClass).solveType)
								hm.put("typeoperation", ClassName.get(namingUtils.operationInterfacePackageName(packageRoot, t.type as EClass), namingUtils.operationInterfaceClassName(t.type as EClass)))
								for (param : call.arguments.tail.enumerate) {
									hm.put("typeparam" + param.value, (param.key.infereType.head.type as EClass).solveType)
									hm.put("expression" + param.value, param.key.compileExpression)
								}
								
								val a0 = call.arguments.head
								hm.put("caller",  a0.compileExpression)
								hm.put("serviceName", call.serviceName)
								
								CodeBlock.builder.addNamed('''(($typeoperation:T)$caller:L.accept(vis)).$serviceName:L(«FOR p : call.arguments.tail.enumerate SEPARATOR ','»($typeparam«p.value»:T)$expression«p.value»:L«ENDFOR»)''', hm).build
							} else {

								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
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

							val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
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
		CodeBlock.of('''(«FOR p : call.parameters SEPARATOR ', '»«p.name»«ENDFOR») -> «call.expression.compileExpression»''')
	}

	def dispatch CodeBlock compileExpression(NullLiteral call) {
		CodeBlock.of('null')
	}

	def dispatch CodeBlock compileExpression(RealLiteral call) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(SequenceInExtensionLiteral call) {
		CodeBlock.of('''$T.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression»«ENDFOR»)''',
			ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
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

	def dispatch CodeBlock compileExpression(VarRef call) {
		if(call.variableName == 'self') CodeBlock.of('this.it') else CodeBlock.of(call.variableName)
	}

	def infereType(Expression exp) {
		
		base.getPossibleTypes(exp)
	}

	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}

	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls

		resolved.filter[it.eCls == ecls || it.eCls.isSuperTypeOf(ecls)].map [
			it.aleCls
		].filter[it !== null]
	}
	
	
}
