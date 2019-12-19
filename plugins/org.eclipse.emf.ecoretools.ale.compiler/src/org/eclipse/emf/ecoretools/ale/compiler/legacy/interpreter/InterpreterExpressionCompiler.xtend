package org.eclipse.emf.ecoretools.ale.compiler.legacy.interpreter

import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractExpressionCompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method

@Deprecated
class InterpreterExpressionCompiler extends AbstractExpressionCompiler {

	extension InterpreterTypeSystemUtils tsu
	extension InterpreterNamingUtils namingUtils
	extension CommonTypeInferer cti
	extension EnumeratorService es

	val Set<Method> registreredDispatch

	new(String packageRoot, List<ResolvedClass> resolved, Set<Method> registreredDispatch, Set<String> registeredArray,
		Map<String, Pair<String, String>> registeredServices, boolean isTruffle, CommonTypeInferer cti,
		EnumeratorService es, InterpreterTypeSystemUtils tsu, InterpreterNamingUtils namingUtils) {
		super(cti, es, tsu, namingUtils, registeredServices, resolved, packageRoot, isTruffle, registeredArray)

		this.tsu = tsu
		this.registreredDispatch = registreredDispatch
		this.namingUtils = namingUtils
		this.cti = cti
		this.es = es
	}

	override getThis(CompilerExpressionCtx ctx) {
		ctx.thisCtxName
	}

	override implementationSpecificCall(Call call, CompilerExpressionCtx ctx, Iterable<Method> allMethods,
		ResolvedClass re) {
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
//			val itt = call.arguments.head.infereType
//			val lt = itt.head.type
			hm.put("typecaller", re.ECls.resolveType)
			hm.put("lhs", call.arguments.head.compileExpression(ctx))
			for (param : call.arguments.tail.enumerate) {
				val tmp = param.key.infereType.head
				if (tmp !== null)
					hm.put("typeparam" + param.value, tmp.type?.resolveType2?.solveNothing(param.key))
				else
					hm.put("typeparam" + param.value, null)
				hm.put("expr" + param.value, param.key.compileExpression(ctx))
			}

			CodeBlock.builder.
				addNamed('''(($typecaller:T) ($lhs:L)).«call.serviceName»(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»«IF hm.get("typeparam"+param.value) !== null»($typeparam«param.value»:T) ($expr«param.value»:L)«ELSE»$expr«param.value»:L«ENDIF»«ENDFOR»)''',
					hm).build
		}
	}
	
	def boolean isDispatch(Method method) {
		// TODO réinitégrer au mm
		false
	}
}
