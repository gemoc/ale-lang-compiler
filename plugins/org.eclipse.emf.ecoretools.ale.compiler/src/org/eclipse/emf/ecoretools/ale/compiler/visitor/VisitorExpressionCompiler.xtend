package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import java.lang.reflect.Modifier
import java.util.List
import java.util.Map
import java.util.Objects
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

class VisitorExpressionCompiler {
	
	extension VisitorTypeSystemUtil vtsu
	extension VisitorNamingUtils vnu
	extension CommonCompilerUtils ccu
	val List<ResolvedClass> resolved
	val Map<String, Class<?>> registeredServices
	val String packageRoot
	
	new(VisitorTypeSystemUtil vtsu, List<ResolvedClass> resolved, Map<String, Class<?>> registeredServices, VisitorNamingUtils vnu, CommonCompilerUtils ccu, String packageRoot) {
		this.vtsu = vtsu
		this.resolved = resolved
		this.registeredServices = registeredServices
		this.vnu = vnu
		this.ccu = ccu
		this.packageRoot = packageRoot
	}
	
	def dispatch CodeBlock compileExpression(Call call) {
		switch (call.serviceName) {
			case "not": CodeBlock.of('''!(«call.arguments.get(0).compileExpression»)''')
			case "greaterThan": CodeBlock.of('''(«call.arguments.get(0).compileExpression») > («call.arguments.get(1).compileExpression»)''')
			case "differs": CodeBlock.of('''(«call.arguments.get(0).compileExpression») != («call.arguments.get(1).compileExpression»)''')
			case "sub": CodeBlock.of('''(«call.arguments.get(0).compileExpression») - («call.arguments.get(1).compileExpression»)''')
			case "add": CodeBlock.of('''(«call.arguments.get(0).compileExpression») + («call.arguments.get(1).compileExpression»)''')
			case "divOp": CodeBlock.of('''(«call.arguments.get(0).compileExpression») / («call.arguments.get(1).compileExpression»)''')
			case "equals": CodeBlock.of('''$T.equals((«call.arguments.get(0).compileExpression»), («call.arguments.get(1).compileExpression»))''', ClassName.get(Objects))
			case "lessThan": CodeBlock.of('''(«call.arguments.get(0).compileExpression») < («call.arguments.get(1).compileExpression»)''')
			case "lessThanEqual": CodeBlock.of('''($L) <= ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "greaterThanEqual":
				CodeBlock.of('''($L) >= ($L)''', call.arguments.get(0).compileExpression,
					call.arguments.get(1).compileExpression)
			case "mult": CodeBlock.of('''($L) * ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "unaryMin": CodeBlock.of('''-($L)''', call.arguments.get(0).compileExpression)
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.head($L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
						call.arguments.get(0).compileExpression)
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.size($L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
						call.arguments.get(0).compileExpression)
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.of('''$T.get($L, $L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
						call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.select($L, $L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
						call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						CodeBlock.of('''$T.select($L, it -> it instanceof $L)''',
							ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
							call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
					} else {
						CodeBlock.of('''$T.select($L, $L)''',
							ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
							call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
					}
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.of('''$T.isEmpty($L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"),
						call.arguments.get(0).compileExpression)
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
					CodeBlock.of('''$T.log($L)''',
						ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService"), call.arguments.get(0).compileExpression)
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
								(t.type as EDataType).instanceClass == boolean))
								CodeBlock.of('''$L.is$L()''', call.arguments.head.compileExpression, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
							else
								CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
						} else {
							// TODO: add named block
							CodeBlock.of('''$L.«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»''', call.arguments.head.compileExpression)

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
								hm.put("typeoperation", ClassName.get(packageRoot.operationInterfacePackageName(t.type as EClass), (t.type as EClass).operationInterfaceClassName))
								for (param : call.arguments.tail.enumerate) {
									hm.put("typeparam" + param.value, param.key.infereType.head.type.resolveType2)
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