package org.eclipse.emf.ecoretools.ale.compiler.visitor

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

class VisitorExpressionCompiler extends AbstractExpressionCompiler {

	extension VisitorTypeSystemUtil vtsu
	extension VisitorNamingUtils vnu
	extension EnumeratorService es
	extension CommonTypeInferer cti

	new(VisitorTypeSystemUtil vtsu, List<ResolvedClass> resolved, Map<String, Pair<String, String>> registeredServices,
		VisitorNamingUtils vnu, String packageRoot, CommonTypeInferer cti, EnumeratorService es) {
		super(cti, es, vtsu, vnu, registeredServices, resolved, packageRoot, false, newHashSet)
		this.vtsu = vtsu
		this.vnu = vnu
		this.es = es
		this.cti = cti
	}

	override getThis(CompilerExpressionCtx ctx) {
		'this.it'
	}

	override implementationSpecificCall(Call call, CompilerExpressionCtx ctx, Iterable<Method> allMethods,
		ResolvedClass re) {
		val hm = newHashMap()
		val iType = re.ECls as EClass
		hm.put("typecaller", iType)
		hm.put("typeoperation",
			ClassName.get(packageRoot.operationInterfacePackageName(iType), (iType).operationInterfaceClassName))
		for (param : call.arguments.tail.enumerate) {
			hm.put("typeparam" + param.value, param.key.infereType?.head?.type?.resolveType2.solveNothing(param.key))
			hm.put("expression" + param.value, param.key.compileExpression(ctx))
		}

		val a0 = call.arguments.head
		hm.put("caller", a0.compileExpression(ctx))
		hm.put("serviceName", call.serviceName)

		CodeBlock.builder.
			addNamed('''(($typeoperation:T)$caller:L.accept(vis)).$serviceName:L(«FOR p : call.arguments.tail.enumerate SEPARATOR ', '»«IF hm.get("typeparam" + p.value) !== null»($typeparam«p.value»:T)«ENDIF» ($expression«p.value»:L)«ENDFOR»)''',
				hm).build
	}
}
