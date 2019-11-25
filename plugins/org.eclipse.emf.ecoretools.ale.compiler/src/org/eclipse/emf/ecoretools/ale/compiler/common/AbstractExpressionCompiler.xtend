package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import java.util.Set
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
import org.eclipse.acceleo.query.validation.type.EClassifierType
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.Switch

abstract class AbstractExpressionCompiler {

	val collectionServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService")
	val equalServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "EqualService")
	val logServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService")
	val Map<String, Pair<String, String>> registeredServices
	val List<ResolvedClass> resolved
	
	protected def getResolved() {
		resolved
	}
	
	def compileThis(VarRef call, CompilerExpressionCtx ctx) {
		CodeBlock.of(if(call.variableName == 'self') getThis(ctx) else call.variableName)
	}
	
	def String getThis(CompilerExpressionCtx ctx)

	val String packageRoot
	val boolean isTruffle
	val Set<String> registeredArray
	extension CommonTypeInferer cti
	extension EnumeratorService es
	extension CommonTypeSystemUtils ats
	extension AbstractNamingUtils anu
	
	protected def getPackageRoot() {
		this.packageRoot
	}
	
	protected def getIsTruffle() {
		this.isTruffle
	}
	
	protected def getRegistrerArray() {
		this.registeredArray
	}

	new(CommonTypeInferer cti, EnumeratorService es, CommonTypeSystemUtils ats, AbstractNamingUtils anu, Map<String, Pair<String, String>> registeredServices, List<ResolvedClass> resolved, String packageRoot, boolean isTruffle, Set<String> registeredArray) {
		this.cti = cti
		this.es = es
		this.ats = ats
		this.anu = anu
		this.registeredServices = registeredServices
		this.resolved = resolved
		this.packageRoot = packageRoot
		this.isTruffle = isTruffle
		this.registeredArray = registeredArray 
	}

	def dispatch CodeBlock compileExpression(Call call, CompilerExpressionCtx ctx) {
		switch (call.serviceName) {
			case "not":
				CodeBlock.of('''!($L)''', call.arguments.get(0).compileExpression(ctx))
			case "greaterThan":
				CodeBlock.of('''($L) > ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "differs":
				CodeBlock.of('''!$T.equals(($L), ($L))''', equalServiceClassName,
					call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
			case "sub":
				CodeBlock.of('''($L) - ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "add":
				CodeBlock.of('''($L) + ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "divOp":
				CodeBlock.of('''($L) / ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "equals":
				CodeBlock.of('''$T.equals(($L), ($L))''', equalServiceClassName,
					call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
			case "lessThan":
				CodeBlock.of('''($L) < ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "lessThanEqual":
				CodeBlock.of('''($L) <= ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "greaterThanEqual":
				CodeBlock.of('''($L) >= ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "mult":
				CodeBlock.of('''($L) * ($L)''', call.arguments.get(0).compileExpression(ctx),
					call.arguments.get(1).compileExpression(ctx))
			case "unaryMin":
				CodeBlock.of('''-($L)''', call.arguments.get(0).compileExpression(ctx))
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.head($L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx))
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.size($L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx))
				else if (call.type == CallType.CALLORAPPLY)
					CodeBlock.of('''$T.size($L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx))
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.get($L, $L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.select($L, $L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "insertAt":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.set($L, $L, $L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx), call.arguments.get(2).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						CodeBlock.of('''$T.select($L, it -> it instanceof $L)''', collectionServiceClassName,
							call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
					} else {
						CodeBlock.of('''$T.select($L, $L)''', collectionServiceClassName,
							call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
					}
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "exists":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.exists($L, $L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.isEmpty($L)''', collectionServiceClassName,
						call.arguments.get(0).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					val exp = call.arguments.get(0).compileExpression(ctx)
					val tp = call.arguments.get(1).compileExpression(ctx)
					CodeBlock.of('''$L instanceof $L''', exp, tp)
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			case "oclAsType":
				if(call.type == CallType.CALLORAPPLY)
					CodeBlock.of('''(($L) ($L))''', call.arguments.get(1).compileExpression(ctx), call.arguments.get(0).compileExpression(ctx))
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.of('''$T.log($L)''', logServiceClassName, call.arguments.get(0).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			default:
				this.defaultCall(call, ctx)
		}
	}

	def dispatch CodeBlock compileExpression(And call, CompilerExpressionCtx ctx) {
		CodeBlock.
			of('''(($L) && ($L))''', call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
	}

	def dispatch CodeBlock compileExpression(ErrorCall call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORCALL*/''')
	}

	def dispatch CodeBlock compileExpression(Implies call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*IMPLIES*/''')
	}

	def dispatch CodeBlock compileExpression(Or call, CompilerExpressionCtx ctx) {
		CodeBlock.
			of('''(($L) || ($L))''', call.arguments.get(0).compileExpression(ctx), call.arguments.get(1).compileExpression(ctx))
	}

	def dispatch CodeBlock compileExpression(ErrorConditional call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORCONDITIONAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorBinding call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORBINDING*/''')
	}

	def dispatch CodeBlock compileExpression(EEnumLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*EENUMLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorExpression call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERROREXPRESSION*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorStringLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORSTRINGLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorTypeLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORTYPELITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(ErrorVariableDeclaration call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORVARIABLEDECLARATION*/''')
	}

	def dispatch CodeBlock compileExpression(Let call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*let*/''')
	}

	def dispatch CodeBlock compileExpression(BooleanLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of(if(call.value) 'true' else 'false')
	}

	def dispatch CodeBlock compileExpression(EnumLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ENUMLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(IntegerLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(Lambda call, CompilerExpressionCtx ctx) {
		val Map<String, Object> hm = newHashMap(
			"expr" -> call.expression.compileExpression(ctx)
		)
		for (param : call.parameters.enumerate) {
			hm.put("param" + param.value, param.key.name)
		}

		CodeBlock.builder.
			addNamed('''(«FOR p : call.parameters.enumerate SEPARATOR ', '»$param«p.value»:L«ENDFOR») -> $expr:L''',
				hm).build
	}

	def dispatch CodeBlock compileExpression(NullLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('null')
	}

	def dispatch CodeBlock compileExpression(RealLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(SequenceInExtensionLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''$T.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression(ctx)»«ENDFOR»)''',
			collectionServiceClassName)
	}

	def dispatch CodeBlock compileExpression(SetInExtensionLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*SETINEXTENSIONLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(StringLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''"«call.value»"''')
	}

	def dispatch CodeBlock compileExpression(TypeLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''$T''', (call.value as EClass).solveType)
	}

	def dispatch CodeBlock compileExpression(Switch call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*SWITCH*/''')
	}

	def dispatch CodeBlock compileExpression(VarRef call, CompilerExpressionCtx ctx) {
		call.compileThis(ctx)
	}

	def CodeBlock callCreate(Call call, String packageRoot) {
		val e = call.arguments.get(0)
		val t = infereType(e).head
		val ecls = t.type as EClass
		val epks = ecls.EPackage
		val hm = newHashMap("factory" -> epks.packageFactoryClassName(packageRoot))
		CodeBlock.builder.addNamed('''$factory:T.eINSTANCE.create«ecls.name»()''', hm).build
	}
	
	def CodeBlock callService(Call call, CompilerExpressionCtx ctx) {
		val candidate = registeredServices.get(call.serviceName)
		
		if (candidate !== null) {
			
			val Map<String, Object> hm = newHashMap(
				"serviceType" -> ClassName.get(candidate.key, candidate.value),
				"serviceMethodName" -> call.serviceName
			)
			
			for(p: call.arguments.enumerate) {
				val tmp = p.key.infereType.head
				if(tmp !== null)
					hm.put("paramType" + p.value, tmp.resolveType3?.solveNothing(p.key))
				else 
					hm.put("paramType" + p.value, solveNothing(null, p.key))
				hm.put("paramValue" + p.value, p.key.compileExpression(ctx))
			}
			
	
			CodeBlock.builder.addNamed('''$serviceType:T.$serviceMethodName:L(«FOR p : call.arguments.enumerate SEPARATOR ', '»«IF hm.get("paramType" + p.value) !== null»($paramType«p.value»:T) «ENDIF»($paramValue«p.value»:L)«ENDFOR»)''', hm).build
		} else {
			// primitive operation
			println('''unhandled call: «call»''')
			val Map<String, Object> hm = newHashMap
			hm.put("leftExpr", call.arguments.head.compileExpression(ctx))
			hm.put("serviceName", call.serviceName)
			for(param: call.arguments.tail.enumerate) {
				hm.put('''paramtype«param.value»''', param.key.infereType.head?.resolveType3.solveNothing(param.key))
				hm.put('''param«param.value»''', param.key.compileExpression(ctx))
			}
			CodeBlock.builder.addNamed('''$leftExpr:L.$serviceName:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»«IF hm.get("paramtype" + param.value) !== null»($paramtype«param.value»:T) «ENDIF»($param«param.value»:L)«ENDFOR»)''', hm).build
	
		}
	}
	
	def defaultCall(Call call, CompilerExpressionCtx ctx) {
		if (call.type == CallType.CALLORAPPLY) {
			if (call.serviceName == 'aqlFeatureAccess') {
				val t = infereType(call).head
				val lhs = call.arguments.head.compileExpression(ctx)
				if (lhs.toString == 'this') {
					if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass &&
						((t as SequenceType).collectionType.type as EClass).instanceClassName !=
							"java.util.Map$Entry") {
						val rhs = (call.arguments.get(1) as StringLiteral).value
//						if (isTruffle && !(ctx.aleClass.mutable.contains(rhs))) {
//							registeredArray.add(rhs)
//							CodeBlock.of('''«lhs».«rhs»Arr''')
//						} else {
							CodeBlock.of('''«lhs».get«rhs.toFirstUpper»()''')
//						}
					} else {
						val Map<String, Object> hm = newHashMap(
							'lhs' -> lhs,
							'rhs' -> if(call.arguments.get(1) instanceof StringLiteral) {
								val field = ctx.EClass.EStructuralFeatures.filter[it.name == (call.arguments.get(1) as StringLiteral).value].head
								val shoudlGoThroughAccessor = field !== null && field instanceof EReference								
								if(shoudlGoThroughAccessor) {
									'''get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
								} else {
									(call.arguments.get(1) as StringLiteral).value
								}
							} else {
								call.arguments.get(1).compileExpression(ctx)
							}
						)
						CodeBlock.builder.addNamed('''$lhs:L.$rhs:L''', hm).build
					}
				} else {
					if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
						CodeBlock.of('''$L.get$L()''', lhs, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
					} else if (t !== null && (t.type instanceof EClass || t.type instanceof EDataType)) {
						if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
							(t.type as EDataType).instanceClass == boolean))
							CodeBlock.of('''$L.is$L()''', lhs,
								(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
						else
							CodeBlock.of('''$L.get$L()''', lhs,
								(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
					} else {
						CodeBlock.
							of('''$L.«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»''',
								lhs)
					}
				}
			} else if (call.serviceName == 'create') {
				call.callCreate(packageRoot)
			} else {
				val argumentsh = call.arguments.head
				val ts = argumentsh.infereType
				val t = ts.head
				var re = resolved.filter [
					if (t !== null && t.type instanceof EClass) {
						val tecls = t.type as EClass
						it.ECls.name == tecls.name && it.ECls.EPackage.name == tecls.EPackage.name
					} else {
						false
					}
				].head
				if(re === null) {
					// defensive code in case of type system issues.
					val tmp = solveNothing(null, argumentsh) as ClassName
					if(tmp !== null)
						re = resolved.filter [
							it.ECls.name == tmp.simpleName // && it.ECls.EPackage.name == tmp.packageName
						].head
				}
				if (re !== null) {
					val allMethods = re.getAleCls.allMethods
					val methodExist = allMethods.exists [
						it.operationRef.name == call.serviceName
					]
					if (methodExist) {
						this.implementationSpecificCall(call, ctx, allMethods, re)
					} else {
						call.callService(ctx)
					}
				} else {
					call.callService(ctx)
				}
			}

		} else {
			CodeBlock.of('''/*Call «call»*/''')
		}
	}
	
	def CodeBlock implementationSpecificCall(Call call, CompilerExpressionCtx ctx, Iterable<Method> allMethods, ResolvedClass re)

//	def mutable(ExtendedClass aleClass) {
//		// TODO temporary
//		true
//	}
}
