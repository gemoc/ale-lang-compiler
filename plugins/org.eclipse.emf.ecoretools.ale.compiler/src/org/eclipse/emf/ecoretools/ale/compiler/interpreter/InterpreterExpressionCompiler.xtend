package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.CallType
import org.eclipse.acceleo.query.ast.StringLiteral
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractExpressionCompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method

class InterpreterExpressionCompiler extends AbstractExpressionCompiler {

	extension InterpreterTypeSystemUtils tsu
	extension InterpreterNamingUtils namingUtils
	extension CommonTypeInferer cti
	extension EnumeratorService es

	val String packageRoot
	var List<ResolvedClass> resolved
	val Set<Method> registreredDispatch
	
	val Set<String> registeredArray
	val boolean isTruffle

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, 
		List<ResolvedClass> resolved, Set<Method> registreredDispatch, Set<String> registeredArray,
		Map<String, Class<?>> registeredServices, boolean isTruffle, CommonTypeInferer cti, 
		EnumeratorService es,  InterpreterTypeSystemUtils tsu, InterpreterNamingUtils namingUtils) {
		super(cti, es, tsu, namingUtils, registeredServices)
		this.packageRoot = packageRoot
		this.resolved = resolved
		this.tsu = tsu 
		this.registreredDispatch = registreredDispatch
		this.registeredArray = registeredArray
		this.isTruffle = isTruffle
		this.namingUtils = namingUtils
		this.cti = cti
		this.es = es
	}

	override compileThis(VarRef call, CompilerExpressionCtx ctx) {
		CodeBlock.of(if(call.variableName == 'self') ctx.thisCtxName else call.variableName)
	}

	override defaultCall(Call call, CompilerExpressionCtx ctx) {
		if (call.type == CallType.CALLORAPPLY) {
			if (call.serviceName == 'aqlFeatureAccess') {
				val t = infereType(call).head

				// it t is in the hierarchy of the current context eClass (as itself or one of his parents), we can skip the accessor and directly point to the field
				val lhs = call.arguments.head.compileExpression(ctx)
				if (lhs.toString == 'this') {
					if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass &&
						((t as SequenceType).collectionType.type as EClass).instanceClassName !=
							"java.util.Map$Entry") {
						val rhs = (call.arguments.get(1) as StringLiteral).value
						if (isTruffle && !(ctx.aleClass.mutable.contains(rhs))) {
							registeredArray.add(rhs)
							CodeBlock.of('''«lhs».«rhs»Arr''')
						} else {
							CodeBlock.of('''«lhs».get«rhs.toFirstUpper»()''')
						}
					} else if (t.type instanceof EClass || t.type instanceof EDataType) {
						CodeBlock.of('''$L.$L''', lhs, (call.arguments.get(1) as StringLiteral).value)
					} else {
						CodeBlock.
							of('''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»«(call.arguments.get(1) as StringLiteral).value»«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»''')
					}

				} else {
					if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
						CodeBlock.of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
					} else if (t !== null && (t.type instanceof EClass || t.type instanceof EDataType)) {
						if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
							(t.type as EDataType).instanceClass == boolean))
							CodeBlock.of('''«lhs».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
						else
							CodeBlock.of('''$L.get$L()''', lhs, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
					} else {
						CodeBlock.
							of('''«lhs».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression(ctx)»«ENDIF»''')
					}
				}
			} else if (call.serviceName == 'create') {
				call.callCreate(packageRoot)
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
								revc.eCls instanceof EClass && (revc.eCls as EClass).ESuperTypes.contains(it.eCls)
							].head
						}

						// lookup if one of the method declaration is declared with a dispatch
						var isDispatch = false
						rev = re
						while (!isDispatch && rev !== null) {
							val lc = rev.aleCls
							method = methods.filter[it.eContainer === lc].head

							isDispatch = method !== null && method.isDispatch

							val revc = rev
							rev = resolved.filter [
								revc.eCls instanceof EClass && (revc.eCls as EClass).ESuperTypes.contains(it.eCls)
							].head
						}

						if (isTruffle && isDispatch) {
							this.registreredDispatch.add(method)
							val effectFull = !(call.eContainer instanceof ExpressionStatement)
							CodeBlock.
								of('''«IF effectFull && method.operationRef.EType !==null»((«method.operationRef.EType.resolveType2»)«ENDIF»dispatch«(method.eContainer as ExtendedClass).normalizeExtendedClassName»«method.operationRef.name.toFirstUpper».executeDispatch(«call.arguments.head.compileExpression(ctx)».getCached«call.serviceName.toFirstUpper»(), new Object[] {«FOR param : call.arguments.tail SEPARATOR ', '»«param.compileExpression(ctx)»«ENDFOR»})«IF effectFull && method.operationRef.EType !==null»)«ENDIF»''')
						} else {
							val hm = newHashMap()
							val itt = call.arguments.head.infereType
							val lt = itt.head.type
							hm.put("typecaller", lt.resolveType2)
							hm.put("lhs", call.arguments.head.compileExpression(ctx))
							for (param : call.arguments.tail.enumerate) {
								val tmp = param.key.infereType.head
								if(tmp !== null)
									hm.put("typeparam" + param.value, tmp.type?.resolveType2?.solveNothing(param.key))
								else
									hm.put("typeparam" + param.value, null)
								hm.put("expr"+param.value, param.key.compileExpression(ctx))
							}

							CodeBlock.builder.
								addNamed('''(($typecaller:T) ($lhs:L)).«call.serviceName»(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»«IF hm.get("typeparam"+param.value) !== null»($typeparam«param.value»:T) ($expr«param.value»:L)«ELSE»$expr«param.value»:L«ENDIF»«ENDFOR»)''', hm).build
						}
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
}
