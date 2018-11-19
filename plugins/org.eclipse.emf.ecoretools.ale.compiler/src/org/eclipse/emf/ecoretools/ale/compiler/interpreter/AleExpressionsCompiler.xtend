package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.CodeBlock
import java.lang.reflect.Modifier
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
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassImplementationCompiler.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.Switch

class AleExpressionsCompiler {

	extension TypeSystemUtils tsu
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	val String packageRoot
	var List<ResolvedClass> resolved
	val Set<Method> registreredDispatch
	val Map<String, Class<?>> registeredServices
	val List<String> registeredArray
	val boolean isTruffle

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, BaseValidator base,
		List<ResolvedClass> resolved, Set<Method> registreredDispatch, List<String> registeredArray,
		Map<String, Class<?>> registeredServices, boolean isTruffle) {
		this.packageRoot = packageRoot
		this.resolved = resolved
		tsu = new TypeSystemUtils(syntaxes, packageRoot, base, resolved)
		this.registreredDispatch = registreredDispatch
		this.registeredServices = registeredServices
		this.registeredArray = registeredArray
		this.isTruffle = isTruffle
	}

	def dispatch CodeBlock compileExpression(Call call, CompilerExpressionCtx ctx) {

		switch (call.serviceName) {
			case "not":
				CodeBlock.of('''!(«call.arguments.get(0).compileExpression(ctx)»)''')
			case "greaterThan":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») > («call.arguments.get(1).compileExpression(ctx)»)''')
			case "differs":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») != («call.arguments.get(1).compileExpression(ctx)»)''')
			case "sub":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») - («call.arguments.get(1).compileExpression(ctx)»)''')
			case "add":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») + («call.arguments.get(1).compileExpression(ctx)»)''')
			case "divOp":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») / («call.arguments.get(1).compileExpression(ctx)»)''')
			case "equals":
				CodeBlock.
					of('''java.util.Objects.equals((«call.arguments.get(0).compileExpression(ctx)»), («call.arguments.get(1).compileExpression(ctx)»))''')
			case "lessThan":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») < («call.arguments.get(1).compileExpression(ctx)»)''')
			case "mult":
				CodeBlock.
					of('''(«call.arguments.get(0).compileExpression(ctx)») * («call.arguments.get(1).compileExpression(ctx)»)''')
			case "unaryMin":
				CodeBlock.of('''-(«call.arguments.get(0).compileExpression(ctx)»)''')
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.
						of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(«call.arguments.get(0).compileExpression(ctx)»)''')
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.
						of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(«call.arguments.get(0).compileExpression(ctx)»)''')
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					CodeBlock.
						of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(«call.arguments.get(0).compileExpression(ctx)», «call.arguments.get(1).compileExpression(ctx)»)''')
				else
					CodeBlock.of('''/*FIRST «call»*/''')
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.
						of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression(ctx)», «call.arguments.get(1).compileExpression(ctx)»)''')
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						CodeBlock.
							of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression(ctx)», it -> it instanceof «call.arguments.get(1).compileExpression(ctx)»)''')
					} else {
						CodeBlock.
							of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression(ctx)», «call.arguments.get(1).compileExpression(ctx)»)''')
					}
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					CodeBlock.
						of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(«call.arguments.get(0).compileExpression(ctx)»)''')
				} else {
					CodeBlock.of('''/*FIRST «call»*/''')
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.
						of('''«call.arguments.get(0).compileExpression(ctx)» instanceof «call.arguments.get(1).compileExpression(ctx)»''')
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					CodeBlock.
						of('''org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(«call.arguments.get(0).compileExpression(ctx)»)''')
				} else {
					CodeBlock.of('''/*OCLISKINDOF*/''')
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head

						// it t is in the hierarchy of the current context eClass (as itself or one of his parents), we can skip the accessor and directly point to the field
						val lhs = call.arguments.head.compileExpression(ctx)
						if (lhs.toString == 'this') {
							if (t instanceof SequenceType &&
								(t as SequenceType).collectionType.type instanceof EClass) {
								if (isTruffle) {
									val rhs = (call.arguments.get(1) as StringLiteral).value
									registeredArray.add(rhs)
									CodeBlock.of('''«lhs».«rhs»Arr''')

								} else {
									CodeBlock.of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
								}
							} else if (t.type instanceof EClass || t.type instanceof EDataType) {
								CodeBlock.of('''«lhs».«(call.arguments.get(1) as StringLiteral).value»''')
							} else {
								CodeBlock.
									of('''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»«(call.arguments.get(1) as StringLiteral).value»«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»''')
							}

						} else {
							if (t instanceof SequenceType &&
								(t as SequenceType).collectionType.type instanceof EClass) {
								CodeBlock.
									of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
							} else if (t.type instanceof EClass || t.type instanceof EDataType) {
								if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
									(t.type as EDataType).instanceClass == boolean))
									CodeBlock.
										of('''«lhs».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
								else
									CodeBlock.
										of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
							} else {
								CodeBlock.
									of('''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»''')
							}
						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						CodeBlock.
							of('''«epks.factoryInterfacePackageName(packageRoot)».«epks.factoryInterfaceClassName».eINSTANCE.create«ecls.name»()''')
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
								val methods = allMethods.filter[it.operationRef.name == call.serviceName].toList

								/* Look for the most specific method that matches the resolved class by walking up the hierarchy */
								var Method method = null
								var ResolvedClass rev = re
								while (method === null) {
									val lc = rev.aleCls
									method = methods.filter[it.eContainer === lc].head

									val revc = rev
									rev = resolved.filter[it.eCls == revc.eCls.ESuperTypes].head
								}
								if (isTruffle && method.isDispatch) {
									this.registreredDispatch.add(method)
									CodeBlock.
										of('''dispatch«(method.eContainer as ExtendedClass).normalizeExtendedClassName»«method.operationRef.name.toFirstUpper».executeDispatch(«call.arguments.head.compileExpression(ctx)».getCached«call.serviceName.toFirstUpper»(), new Object[] {«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»})''')
								} else {
									CodeBlock.
										of('''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»)''')
								}
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
		val ret = if(call.value) 'true' else 'false'
		CodeBlock.of(ret)
	}

	def dispatch CodeBlock compileExpression(EnumLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*ENUMLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(IntegerLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(Lambda call, CompilerExpressionCtx ctx) {
		CodeBlock.
			of('''(«FOR p : call.parameters SEPARATOR ', '»«p.name»«ENDFOR») -> «call.expression.compileExpression(ctx)»''')
	}

	def dispatch CodeBlock compileExpression(NullLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('null')
	}

	def dispatch CodeBlock compileExpression(RealLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of(call.value.toString)
	}

	def dispatch CodeBlock compileExpression(SequenceInExtensionLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.
			of('''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression(ctx)»«ENDFOR»)''')
	}

	def dispatch CodeBlock compileExpression(SetInExtensionLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*SETINEXTENSIONLITERAL*/''')
	}

	def dispatch CodeBlock compileExpression(StringLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''"«call.value»"''')
	}

	def dispatch CodeBlock compileExpression(TypeLiteral call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''«(call.value as EClass).solveType»''')
	}

	def dispatch CodeBlock compileExpression(Switch call, CompilerExpressionCtx ctx) {
		CodeBlock.of('''/*SWITCH*/''')
	}

	def dispatch CodeBlock compileExpression(VarRef call, CompilerExpressionCtx ctx) {
		val ret = if(call.variableName == 'self') ctx.thisCtxName else call.variableName
		CodeBlock.of(ret)
	}
}
