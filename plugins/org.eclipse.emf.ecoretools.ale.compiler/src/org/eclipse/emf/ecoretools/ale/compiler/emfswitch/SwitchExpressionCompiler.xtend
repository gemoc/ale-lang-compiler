package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

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
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

class SwitchExpressionCompiler {
	
	extension TypeSystemUtils tsu
	extension SwitchNamingUtils snu
	extension CommonCompilerUtils ccu
	val List<ResolvedClass> resolved
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val Map<String, Class<?>> registeredServices
	val String packageRoot
	val Dsl dsl
	
	new(TypeSystemUtils tsu, List<ResolvedClass> resolved, SwitchNamingUtils snu, Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, Map<String, Class<?>> registeredServices, Dsl dsl) {
		this.tsu = tsu
		this.resolved = resolved
		this.snu = snu
		this.syntaxes = syntaxes
		this.packageRoot = packageRoot
		this.ccu = new CommonCompilerUtils(snu)
		this.registeredServices = registeredServices
		this.dsl = dsl
		
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
					CodeBlock.of('''$T.size($L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression)
				else if (call.type == CallType.CALLORAPPLY)
					CodeBlock.of('''$T.size($L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), call.arguments.get(0).compileExpression)
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
					CodeBlock.of('''$T.log($L)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService"),
						call.arguments.get(0).compileExpression)
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
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
								
									CodeBlock.of('''«lhs».get«rhs.toFirstUpper»()''')
							} else if (t.type instanceof EClass || t.type instanceof EDataType) {
								CodeBlock.of('''«lhs».«(call.arguments.get(1) as StringLiteral).value»''')
							} else {
								CodeBlock.of('''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»«(call.arguments.get(1) as StringLiteral).value»«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»''')
							}

						} else {
							if (t instanceof SequenceType &&
								(t as SequenceType).collectionType.type instanceof EClass) {
								CodeBlock.of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
							} else if (t !== null && (t.type instanceof EClass || t.type instanceof EDataType)) {
								if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
									(t.type as EDataType).instanceClass == boolean))
									CodeBlock.of('''«lhs».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
								else
									CodeBlock.of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
							} else {
								CodeBlock.of('''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»''')
							}
						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						CodeBlock.of('''$T.eINSTANCE.create«ecls.name»()''', ClassName.get(getEcoreInterfacesPackage, epks.factoryInterfaceClassName))
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

								val hm = newHashMap(
									"operationType" -> ClassName.get(packageRoot.operationPackageName, (t.type as EClassifier).solveType.operationClassName),
									"switched" -> call.arguments.head.compileExpression,
									"callService" -> call.serviceName
								)		
								
								for(param: call.arguments.tail.enumerate) {
									hm.put("paramType" + param.value, param.key.infereType.head.type.resolveType2)
									hm.put("paramExpr" + param.value, param.key.compileExpression)
								}
														
								CodeBlock.builder.
									addNamed('''(($operationType:T) emfswitch.doSwitch($switched:L)).$callService:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ','»($paramType«param.value»:T) $paramExpr«param.value»:L«ENDFOR»)''',
										hm).build
							} else {

								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
									it.value.name == call.serviceName
								].head

								if (candidate !== null) {
									CodeBlock.of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)''')
								} else {
									
									// TODO add parameters cast 
									CodeBlock.
										of('''(($T) emfswitch.doSwitch(«call.arguments.head.compileExpression»)).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)''',
											ClassName.get(packageRoot.operationPackageName, ((t.type as EClassifier).solveType).operationClassName))
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
									if(t !== null && t.type !== null && t.type instanceof EClassifier && (t.type as EClassifier).solveType instanceof EClass )
									// TODO add parameters cast 
										CodeBlock.
										of('''(($T) emfswitch.doSwitch(«call.arguments.head.compileExpression»)).«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)''',
											ClassName.get(packageRoot.operationPackageName,
												((t.type as EClassifier).solveType as EClass).operationClassName))
									else
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
		CodeBlock.of('''$T.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression»«ENDFOR»)''', ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"))
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
		CodeBlock.of(if(call.variableName == 'self') 'this.it' else call.variableName)
	}
	
	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}
}
