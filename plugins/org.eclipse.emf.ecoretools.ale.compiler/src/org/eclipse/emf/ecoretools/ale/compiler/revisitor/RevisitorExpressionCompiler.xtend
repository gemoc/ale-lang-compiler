package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractExpressionCompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.implementation.Method

class RevisitorExpressionCompiler extends AbstractExpressionCompiler {
	extension RevisitorTypeSystemUtils tsu
	extension CommonTypeInferer cti
	extension EnumeratorService es
	extension RevisitorNamingUtils anu

	new(RevisitorTypeSystemUtils tsu, List<ResolvedClass> resolved,
		Map<String, Pair<String, String>> registeredServices, CommonTypeInferer cti, EnumeratorService es,
		RevisitorNamingUtils anu, String packageRoot) {
		super(cti, es, tsu, anu, registeredServices, resolved, packageRoot, false, newHashSet())
		this.tsu = tsu
		this.cti = cti
		this.es = es
		this.anu = anu
	}

	override getThis(CompilerExpressionCtx ctx) {
		'this.obj'
	}

	override CodeBlock implementationSpecificCall(Call call, CompilerExpressionCtx ctx, Iterable<Method> allMethods,
		ResolvedClass re) {
		val iType = re.ECls as EClass
		val hm = newHashMap(
			'dispatch' -> "$",
			"callerType" -> iType.resolveType,
			"callerExpr" -> call.arguments.head.compileExpression(ctx),
			"callerServiceName" -> call.serviceName
		)

		call.arguments.tail.enumerate.forEach [
			var pt = it.key.infereType.head?.type?.resolveType2?.solveNothing(it.key)

			hm.put('paramType' + it.value, pt)
			val pe = it.key.compileExpression(ctx)
			hm.put('paramExpr' + it.value, pe)
		]

		CodeBlock.builder.
			addNamed('''rev.$dispatch:L(«IF hm.get("callerType") !== null»($callerType:T)«ENDIF»$callerExpr:L).$callerServiceName:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»(«IF hm.get("paramType" + param.value) !== null»($paramType«param.value»:T) «ENDIF»($paramExpr«param.value»:L))«ENDFOR»)''',
				hm).build
	}

}
