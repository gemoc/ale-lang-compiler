package org.eclipse.emf.ecoretools.ale.compiler.interpreter

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
	val List<Method> registreredDispatch
	val Map<String, Class<?>> registeredServices

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, BaseValidator base,
		List<ResolvedClass> resolved, List<Method> registreredDispatch, Map<String, Class<?>> registeredServices) {
		this.packageRoot = packageRoot
		this.resolved = resolved
		tsu = new TypeSystemUtils(syntaxes, packageRoot, base, resolved)
		this.registreredDispatch = registreredDispatch
		this.registeredServices = registeredServices
	}

	def dispatch String compileExpression(Call call, CompilerExpressionCtx ctx) {
		switch (call.serviceName) {
			case "not": '''!(«call.arguments.get(0).compileExpression(ctx)»)'''
			case "greaterThan": '''(«call.arguments.get(0).compileExpression(ctx)») > («call.arguments.get(1).compileExpression(ctx)»)'''
			case "differs": '''(«call.arguments.get(0).compileExpression(ctx)») != («call.arguments.get(1).compileExpression(ctx)»)'''
			case "sub": '''(«call.arguments.get(0).compileExpression(ctx)») - («call.arguments.get(1).compileExpression(ctx)»)'''
			case "add": '''(«call.arguments.get(0).compileExpression(ctx)») + («call.arguments.get(1).compileExpression(ctx)»)'''
			case "divOp": '''(«call.arguments.get(0).compileExpression(ctx)») / («call.arguments.get(1).compileExpression(ctx)»)'''
			case "equals": '''java.util.Objects.equals((«call.arguments.get(0).compileExpression(ctx)»), («call.arguments.get(1).compileExpression(ctx)»))'''
			case "lessThan": '''(«call.arguments.get(0).compileExpression(ctx)») < («call.arguments.get(1).compileExpression(ctx)»)'''
			case "mult": '''(«call.arguments.get(0).compileExpression(ctx)») * («call.arguments.get(1).compileExpression(ctx)»)'''
			case "unaryMin": '''-(«call.arguments.get(0).compileExpression(ctx)»)'''
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(«call.arguments.get(0).compileExpression(ctx)»)'''
				else
					'''/*FIRST «call»*/'''
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(«call.arguments.get(0).compileExpression(ctx)»)'''
				else
					'''/*FIRST «call»*/'''
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(«call.arguments.get(0).compileExpression(ctx)», «call.arguments.get(1).compileExpression(ctx)»)'''
				else
					'''/*FIRST «call»*/'''
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression(ctx)», «call.arguments.get(1).compileExpression(ctx)»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression(ctx)», it -> it instanceof «call.arguments.get(1).compileExpression(ctx)»)'''
					} else {
						'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression(ctx)», «call.arguments.get(1).compileExpression(ctx)»)'''
					}
				} else {
					'''/*FIRST «call»*/'''
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(«call.arguments.get(0).compileExpression(ctx)»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					'''«call.arguments.get(0).compileExpression(ctx)» instanceof «call.arguments.get(1).compileExpression(ctx)»'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(«call.arguments.get(0).compileExpression(ctx)»)'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							'''«call.arguments.head.compileExpression(ctx)».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
								(t.type as EDataType).instanceClass == boolean))
								'''«call.arguments.head.compileExpression(ctx)».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
							else
								'''«call.arguments.head.compileExpression(ctx)».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else {
							'''«call.arguments.head.compileExpression(ctx)».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»'''

						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						'''«epks.factoryInterfacePackageName(packageRoot)».«epks.factoryInterfaceClassName».eINSTANCE.create«ecls.name»()'''
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
								if (method.isDispatch) {
									this.registreredDispatch.add(method)
									'''dispatch«(method.eContainer as ExtendedClass).name.toFirstUpper»«method.operationRef.name.toFirstUpper».executeDispatch(«call.arguments.head.compileExpression(ctx)».getCached«call.serviceName.toFirstUpper»(), new Object[] {«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»})'''
								} else {
									'''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»)'''
								}
							} else {

								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
									it.value.name == call.serviceName
								].head

								if (candidate !== null) {
									'''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression(ctx)»«ENDFOR»)'''
								} else {
									'''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»)'''

								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
								it.value.name == call.serviceName
							].head

							if (candidate !== null) {
								'''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression(ctx)»«ENDFOR»)'''
							} else {
								'''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression(ctx)»«ENDFOR»)'''

							}
						}
					}
				else
					'''/*Call «call»*/'''
		}
	}

	def dispatch String compileExpression(And call, CompilerExpressionCtx ctx) {
		'''((«call.arguments.get(0).compileExpression(ctx)») && («call.arguments.get(1).compileExpression(ctx)»))'''
	}

	def dispatch String compileExpression(ErrorCall call, CompilerExpressionCtx ctx) {
		'''/*ERRORCALL*/'''
	}

	def dispatch String compileExpression(Implies call, CompilerExpressionCtx ctx) {
		'''/*IMPLIES*/'''
	}

	def dispatch String compileExpression(Or call, CompilerExpressionCtx ctx) {
		'''((«call.arguments.get(0).compileExpression(ctx)») || («call.arguments.get(1).compileExpression(ctx)»))'''
	}

	def dispatch String compileExpression(ErrorConditional call, CompilerExpressionCtx ctx) {
		'''/*ERRORCONDITIONAL*/'''
	}

	def dispatch String compileExpression(ErrorBinding call, CompilerExpressionCtx ctx) {
		'''/*ERRORBINDING*/'''
	}

	def dispatch String compileExpression(EEnumLiteral call, CompilerExpressionCtx ctx) {
		'''/*EENUMLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorExpression call, CompilerExpressionCtx ctx) {
		'''/*ERROREXPRESSION*/'''
	}

	def dispatch String compileExpression(ErrorStringLiteral call, CompilerExpressionCtx ctx) {
		'''/*ERRORSTRINGLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorTypeLiteral call, CompilerExpressionCtx ctx) {
		'''/*ERRORTYPELITERAL*/'''
	}

	def dispatch String compileExpression(ErrorVariableDeclaration call, CompilerExpressionCtx ctx) {
		'''/*ERRORVARIABLEDECLARATION*/'''
	}

	def dispatch String compileExpression(Let call, CompilerExpressionCtx ctx) {
		'''/*let*/'''
	}

	def dispatch String compileExpression(BooleanLiteral call, CompilerExpressionCtx ctx) {
		if(call.value) 'true' else 'false'
	}

	def dispatch String compileExpression(EnumLiteral call, CompilerExpressionCtx ctx) {
		'''/*ENUMLITERAL*/'''
	}

	def dispatch String compileExpression(IntegerLiteral call, CompilerExpressionCtx ctx) {
		call.value.toString
	}

	def dispatch String compileExpression(Lambda call, CompilerExpressionCtx ctx) {
		'''(«FOR p : call.parameters SEPARATOR ', '»«p.name»«ENDFOR») -> «call.expression.compileExpression(ctx)»'''
	}

	def dispatch String compileExpression(NullLiteral call, CompilerExpressionCtx ctx) {
		'null'
	}

	def dispatch String compileExpression(RealLiteral call, CompilerExpressionCtx ctx) {
		call.value.toString
	}

	def dispatch String compileExpression(SequenceInExtensionLiteral call, CompilerExpressionCtx ctx) {
		'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression(ctx)»«ENDFOR»)'''
	}

	def dispatch String compileExpression(SetInExtensionLiteral call, CompilerExpressionCtx ctx) {
		'''/*SETINEXTENSIONLITERAL*/'''
	}

	def dispatch String compileExpression(StringLiteral call, CompilerExpressionCtx ctx) {
		'''"«call.value»"'''
	}

	def dispatch String compileExpression(TypeLiteral call, CompilerExpressionCtx ctx) {
		'''«(call.value as EClass).solveType»'''
	}

	def dispatch String compileExpression(Switch call, CompilerExpressionCtx ctx) {
		'''/*SWITCH*/'''
	}

	def dispatch String compileExpression(VarRef call, CompilerExpressionCtx ctx) {
		if(call.variableName == 'self') ctx.thisCtxName else call.variableName
	}
}
