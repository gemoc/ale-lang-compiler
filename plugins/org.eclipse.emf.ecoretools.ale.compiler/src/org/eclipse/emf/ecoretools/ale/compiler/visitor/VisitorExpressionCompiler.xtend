package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
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
import org.eclipse.emf.ecoretools.ale.compiler.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.acceleo.query.ast.Expression

class VisitorExpressionCompiler {

	extension VisitorTypeSystemUtil vtsu
	extension VisitorNamingUtils vnu
	extension CommonCompilerUtils ccu
	val List<ResolvedClass> resolved
	val Map<String, Class<?>> registeredServices
	val String packageRoot
	
	val collectionServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService")
	val equalServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "EqualService")
	val logServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService")

	new(VisitorTypeSystemUtil vtsu, List<ResolvedClass> resolved, Map<String, Class<?>> registeredServices,
		VisitorNamingUtils vnu, CommonCompilerUtils ccu, String packageRoot) {
		this.vtsu = vtsu
		this.resolved = resolved
		this.registeredServices = registeredServices
		this.vnu = vnu
		this.ccu = ccu
		this.packageRoot = packageRoot
	}

	def CodeBlock compileExpression(Expression call) {
		call.compileExpression(null)
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
					CodeBlock.of('''$L instanceof $L''', call.arguments.get(0).compileExpression(ctx),
						call.arguments.get(1).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.of('''$T.log($L)''', logServiceClassName, call.arguments.get(0).compileExpression(ctx))
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression(ctx),
								(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
								(t.type as EDataType).instanceClass == boolean))
								CodeBlock.of('''$L.is$L()''', call.arguments.head.compileExpression(ctx),
									(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
							else
								CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression(ctx),
									(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
						} else {
							// TODO: add named block
							CodeBlock.
								of('''$L.«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»''',
									call.arguments.head.compileExpression(ctx))

						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						CodeBlock.builder.addNamed('''$factory:T.eINSTANCE.create«ecls.name»()''',
							newHashMap("factory" -> ClassName.get(epks.factoryInterfacePackageName(packageRoot),
								epks.factoryInterfaceClassName))).build
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
								val hm = newHashMap()
								hm.put("typecaller", (call.arguments.head.infereType.head.type as EClass).solveType)
								hm.put("typeoperation",
									ClassName.get(packageRoot.operationInterfacePackageName(t.type as EClass),
										(t.type as EClass).operationInterfaceClassName))
								for (param : call.arguments.tail.enumerate) {
									hm.put("typeparam" + param.value, param.key.infereType.head.type.resolveType2)
									hm.put("expression" + param.value, param.key.compileExpression(ctx))
								}

								val a0 = call.arguments.head
								hm.put("caller", a0.compileExpression(ctx))
								hm.put("serviceName", call.serviceName)

								CodeBlock.builder.
									addNamed('''(($typeoperation:T)$caller:L.accept(vis)).$serviceName:L(«FOR p : call.arguments.tail.enumerate SEPARATOR ','»($typeparam«p.value»:T)$expression«p.value»:L«ENDFOR»)''',
										hm).build
							} else {

								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
									it.value.name == call.serviceName
								].head

								if (candidate !== null) {
									CodeBlock.
										of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression(ctx)»«ENDFOR»)''')
								} else {
									CodeBlock.
										of('''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»)''')

								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
								it.value.name == call.serviceName
							].head

							if (candidate !== null) {
								CodeBlock.
									of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression(ctx)»«ENDFOR»)''')
							} else {
								CodeBlock.
									of('''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»)''')

							}
						}
					}
				else
					CodeBlock.of('''/*Call «call»*/''')
		}
	}

	def dispatch CodeBlock compileExpression(And call, CompilerExpressionCtx ctx) {
		CodeBlock.
			of('''((«call.arguments.get(0).compileExpression(ctx)») && («call.arguments.get(1).compileExpression(ctx)»))''')
	}

	def dispatch CodeBlock compileExpression(ErrorCall call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ERRORCALL*/''')
	}

	def dispatch CodeBlock compileExpression(Implies call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*IMPLIES*/''')
	}

	def dispatch CodeBlock compileExpression(Or call, CompilerExpressionCtx ctx) {
		CodeBlock.
			of('''((«call.arguments.get(0).compileExpression(ctx)») || («call.arguments.get(1).compileExpression(ctx)»))''')
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
				CodeBlock.of(if(call.variableName == 'self') 'this.it' else call.variableName)

	}

	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}

	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls

		resolved.filter[it.eCls == ecls || (it.eCls as EClass).isSuperTypeOf(ecls as EClass)].map [
			it.aleCls
		].filter[it !== null]
	}
}
