package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.validation.type.IType
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractExpressionCompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.implementation.Method

class SwitchExpressionCompiler extends AbstractExpressionCompiler {

	extension SwitchTypeSystemUtils tsu
	extension SwitchNamingUtils snu
	extension CommonTypeInferer cti
	extension EnumeratorService es

	new(SwitchTypeSystemUtils tsu, List<ResolvedClass> resolved, SwitchNamingUtils snu, String packageRoot,
		Map<String, Pair<String, String>> registeredServices, CommonTypeInferer cti, EnumeratorService es) {
		super(cti, es, tsu, snu, registeredServices, resolved, packageRoot, false, newHashSet)
		this.tsu = tsu
		this.snu = snu
		this.cti = cti
		this.es = es
	}

	override getThis(CompilerExpressionCtx ctx) {
		'this.it'
	}
	
	override implementationSpecificCall(Call call, CompilerExpressionCtx ctx, Iterable<Method> allMethods, ResolvedClass re) {
		val iType = re.ECls as EClass
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
	
			isDispatch = method !== null //&& method.isDispatch // TODO : a re-reporter
	
			val revc = rev
			rev = resolved.filter [
				revc.eCls instanceof EClass && (revc.eCls as EClass).ESuperTypes.contains(it.eCls)
			].head
		}
		
		val hm = newHashMap(
			"operationType" -> ClassName.get(packageRoot.operationPackageName, iType.solveType.operationClassName),
			"switched" -> call.arguments.head.compileExpression(ctx),
			"callService" -> call.serviceName
		)
	
		for (param : call.arguments.tail.enumerate) {
			hm.put("paramType" + param.value,
				param.key.infereType.head?.type?.resolveType2?.solveNothing(param.key))
			hm.put("paramExpr" + param.value, param.key.compileExpression(ctx))
		}
	
		CodeBlock.builder.
			addNamed('''(($operationType:T) emfswitch.doSwitch($switched:L)).$callService:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»«IF hm.get('paramType' + param.value) !== null»($paramType«param.value»:T) «ENDIF»($paramExpr«param.value»:L)«ENDFOR»)''',
				hm).build
	}
}
