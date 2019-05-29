package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.CallType
import org.eclipse.acceleo.query.ast.StringLiteral
import org.eclipse.acceleo.query.validation.type.IType
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractExpressionCompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method

class RevisitorExpressionCompiler extends AbstractExpressionCompiler {
	extension RevisitorTypeSystemUtils tsu
	extension CommonTypeInferer cti
	extension EnumeratorService es

	new(RevisitorTypeSystemUtils tsu, List<ResolvedClass> resolved, Map<String, Class<?>> registeredServices,
		CommonTypeInferer cti, EnumeratorService es, AbstractNamingUtils anu, String packageRoot) {
		super(cti, es, tsu, anu, registeredServices, resolved, packageRoot, false, newHashSet())
		this.tsu = tsu
		this.cti = cti
		this.es = es
	}

	override getThis(CompilerExpressionCtx ctx) {
		'this.obj'
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
	
	def defaultCallBis(Call call, CompilerExpressionCtx ctx) {
		if (call.type == CallType.CALLORAPPLY) {
			if (call.serviceName == 'aqlFeatureAccess') {
				val t = infereType(call).head
				val lhs = call.arguments.head.compileExpression(ctx)
				if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
					CodeBlock.of('''$L.get$L()''', lhs, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
				} else if (t !== null && (t.type instanceof EClass || t.type instanceof EDataType)) {
					if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
						(t.type as EDataType).instanceClass == boolean))
						CodeBlock.of('''$L.is$L()''', lhs, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
					else
						CodeBlock.of('''$L.get$L()''', lhs, (call.arguments.get(1) as StringLiteral).value.toFirstUpper)
				} else {
					CodeBlock.builder.addNamed(
						'''$lhs:L.$rhs:L''',
						newHashMap(
							"lhs" -> lhs,
							"rhs" ->
								if (call.arguments.
									get(
										1) instanceof StringLiteral) '''get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''' else call.
									arguments.get(1).compileExpression(ctx)
						)
					).build
				}
			} else if (call.serviceName == 'create') {
				call.callCreate(null)
			} else {

				// TODO: better identification of the caller in order to route to a $ operation or a service.
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
						// TOOD
						null
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

	override CodeBlock implementationSpecificCall(Call call, CompilerExpressionCtx ctx, IType iType, Iterable<Method> allMethods, ResolvedClass re) {
		val hm = newHashMap(
			'dispatch' -> "$",
			"callerType" -> iType.type.resolveType2,
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
			addNamed('''rev.$dispatch:L(($callerType:T)$callerExpr:L).$callerServiceName:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»(«IF hm.get("paramType" + param.value) !== null»($paramType«param.value»:T) «ENDIF»($paramExpr«param.value»:L))«ENDFOR»)''',
				hm).build
	}

}
