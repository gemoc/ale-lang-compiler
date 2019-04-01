package org.eclipse.emf.ecoretools.ale.compiler.revisitor

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
import org.eclipse.acceleo.query.validation.type.EClassifierType
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Switch

class RevisitorExpressionCompiler {
	extension TypeSystemUtils tsu
	extension EcoreUtils eu
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val List<ResolvedClass> resolved
	extension CommonCompilerUtils ccu
	val Dsl dsl
	val Map<String, Class<?>> registeredServices
	
	new(TypeSystemUtils tsu, Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved, EcoreUtils eu, CommonCompilerUtils ccu, Dsl dsl, Map<String, Class<?>> registeredServices) {
		this.tsu = tsu
		this.syntaxes = syntaxes
		this.resolved = resolved
		this.eu = eu
		this.ccu = ccu
		this.dsl = dsl
		this.registeredServices = registeredServices
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
			case "mult": CodeBlock.of('''($L) * ($L)''', call.arguments.get(0).compileExpression, call.arguments.get(1).compileExpression)
			case "unaryMin": CodeBlock.of('''-($L)''', call.arguments.get(0).compileExpression)
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

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].
									filter [
										it.value.name == call.serviceName
									].head

								if (candidate !== null) {
									CodeBlock.of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)''')
								} else {
									val hm = newHashMap(
										"caller" -> call.arguments.head.compileExpression,
										"serviceName" -> call.serviceName
									)

									for (param : call.arguments.tail.enumerate) {
										hm.put("param" + param.value, param.key.compileExpression)
									}

									CodeBlock.builder.addNamed('''$caller:L.$serviceName:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ','»$param«param.value»:L«ENDFOR»)''', hm).build

								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].
								filter [
									it.value.name == call.serviceName
								].head

							if (candidate !== null) {
								CodeBlock.of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)''')
							} else {
								val hm = newHashMap(
									"caller" -> call.arguments.head.compileExpression,
									"serviceName" -> call.serviceName
								)
								
								for(param: call.arguments.tail.enumerate) {
									hm.put("param" + param.value, param.key.compileExpression)
								}
								
								CodeBlock.builder.addNamed('''$caller:L.$serviceName:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ','»$param«param.value»:L«ENDFOR»)''', hm).build

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
	
	def findGenModelFromExpression(Expression e) {
		val t = infereType(e).head
		syntaxes.values.filter [
			it.key.allClasses.exists [
				it.name == (t.type as EClassifier).name && it.EPackage.name == (t.type as EClassifier).EPackage.name
			]
		].head.value
	}
	
	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}
	
	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls as EClass

		resolved.filter[it.eCls == ecls || ((eCls instanceof EClass) && (eCls as EClass).isSuperTypeOf(ecls))].map [
			it.aleCls
		].filter[it !== null]
	}
	
}