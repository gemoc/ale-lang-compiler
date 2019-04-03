package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.CodeBlock
import java.lang.reflect.Modifier
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
import com.squareup.javapoet.ClassName

class AleExpressionsCompiler extends AbstractExpressionCompiler {

	extension TypeSystemUtils tsu
	extension InterpreterNamingUtils namingUtils
	extension CommonTypeInferer cti
	extension EnumeratorService es

	val String packageRoot
	var List<ResolvedClass> resolved
	val Set<Method> registreredDispatch
	val Map<String, Class<?>> registeredServices
	val Set<String> registeredArray
	val boolean isTruffle

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, 
		List<ResolvedClass> resolved, Set<Method> registreredDispatch, Set<String> registeredArray,
		Map<String, Class<?>> registeredServices, boolean isTruffle, CommonTypeInferer cti, EnumeratorService es,  TypeSystemUtils tsu) {
			super(cti, es, tsu)
		this.packageRoot = packageRoot
		this.resolved = resolved
		this.tsu = tsu 
		this.registreredDispatch = registreredDispatch
		this.registeredServices = registeredServices
		this.registeredArray = registeredArray
		this.isTruffle = isTruffle
		this.namingUtils = new InterpreterNamingUtils
		this.cti = cti
		this.es = es
	}

	override compileThis(VarRef call, CompilerExpressionCtx ctx) {
		CodeBlock.of(if(call.variableName == 'self') ctx.thisCtxName else call.variableName)
	}

	override defaultCall(Call call, CompilerExpressionCtx ctx) {
		if (call.type == CallType.CALLORAPPLY)
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
						CodeBlock.of('''«lhs».«(call.arguments.get(1) as StringLiteral).value»''')
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
							CodeBlock.of('''«lhs».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()''')
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
				val hm = newHashMap("factory" -> epks.factoryIntClassName(packageRoot))
				CodeBlock.builder.addNamed('''$factory:T.eINSTANCE.create«ecls.name»()''', hm).build
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
							hm.put("typecaller", call.arguments.head.infereType.head.type.resolveType2)
							for (param : call.arguments.tail.enumerate) {
								hm.put("typeparam" + param.value, param.key.infereType.head.type.resolveType2)
							}

							CodeBlock.builder.
								addNamed('''(($typecaller:T) «call.arguments.head.compileExpression(ctx)»).«call.serviceName»(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»($typeparam«param.value»:T) («param.key.compileExpression(ctx)»)«ENDFOR»)''',
									hm).build
						}
					} else {
						val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten.toList

						val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
							it.value.name == call.serviceName
						].head

						if (candidate !== null) {
							CodeBlock.
								of('''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression(ctx)»«ENDFOR»)''')
						} else {
							CodeBlock.
								of('''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ', '»«param.compileExpression(ctx)»«ENDFOR»)''')

						}
					}
				} else {
					val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

					val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
						it.value.name == call.serviceName
					].head

					if (candidate !== null) {
						val Map<String, Object> hm = newHashMap(
							"cdt" -> ClassName.get(candidate.value.declaringClass)
						)
						for (param : call.arguments.enumerate) {
							val infTps = param.key.infereType
							hm.put("typeparam" + param.value, infTps.head.resolveType3)
							hm.put("exprparam" + param.value, param.key.compileExpression(ctx))
						}
						CodeBlock.builder.
							addNamed('''$cdt:T.«candidate.value.name»(«FOR p : call.arguments.enumerate SEPARATOR ', '»($typeparam«p.value»:T) ($exprparam«p.value»:L)«ENDFOR»)''',
								hm).build
					} else {
						val hm = newHashMap()

						for (param : call.arguments.tail.enumerate) {
							hm.put("typeparam" + param.value, param.key.infereType.head.type.resolveType2)
						}

						CodeBlock.builder.
							addNamed('''«call.arguments.head.compileExpression(ctx)».«call.serviceName»(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»($typeparam«param.value»:T)«param.key.compileExpression(ctx)»«ENDFOR»)''',
								hm).build
					}
				}
			}
		else
			CodeBlock.of('''/*Call «call»*/''')
	}
}
