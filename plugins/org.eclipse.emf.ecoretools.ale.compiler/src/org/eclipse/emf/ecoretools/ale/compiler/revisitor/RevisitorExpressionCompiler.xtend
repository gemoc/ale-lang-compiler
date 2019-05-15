package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.CodeBlock
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.CallType
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.StringLiteral
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractExpressionCompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeInferer
import org.eclipse.emf.ecoretools.ale.compiler.common.CompilerExpressionCtx
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

class RevisitorExpressionCompiler extends AbstractExpressionCompiler {
	extension RevisitorTypeSystemUtils tsu
	extension EcoreUtils eu
	extension CommonTypeInferer cti
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val List<ResolvedClass> resolved
	extension EnumeratorService es
	val Dsl dsl

	new(RevisitorTypeSystemUtils tsu, Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved,
		EcoreUtils eu, Dsl dsl, Map<String, Class<?>> registeredServices, CommonTypeInferer cti, EnumeratorService es, AbstractNamingUtils anu) {
		super(cti, es, tsu, anu, registeredServices)
		this.tsu = tsu
		this.syntaxes = syntaxes
		this.resolved = resolved
		this.eu = eu
		this.dsl = dsl
		this.cti = cti
		this.es = es
	}

	
	override compileThis(VarRef call, CompilerExpressionCtx ctx) {
		CodeBlock.of(if(call.variableName == 'self') 'this.obj' else call.variableName)
	}
	
	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
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

	override defaultCall(Call call, CompilerExpressionCtx ctx) {
		if (call.type == CallType.CALLORAPPLY)
			if (call.serviceName == 'aqlFeatureAccess') {
				val t = infereType(call).head
				if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
					CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression(ctx),
						(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
				} else if (t !== null && (t.type instanceof EClass || t.type instanceof EDataType)) {
					if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
						(t.type as EDataType).instanceClass == boolean))
						CodeBlock.of('''$L.is$L()''', call.arguments.head.compileExpression(ctx),
							(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
					else
						CodeBlock.of('''$L.get$L()''', call.arguments.head.compileExpression(ctx),
							(call.arguments.get(1) as StringLiteral).value.toFirstUpper)
				} else {
					CodeBlock.builder.addNamed('''$lhs:L.$rhs:L''',
						newHashMap(
							"lhs" -> call.arguments.head.compileExpression(ctx)	,						
							"rhs" -> if (call.arguments.get(1) instanceof StringLiteral) '''get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
								else call.arguments.get(1).compileExpression(ctx)
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
						// TODO: also add explicit cast on parameters !
						val hm = newHashMap(
							'dispatch' -> "$",
							"callerType" -> t.type.resolveType2,
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
							addNamed('''rev.$dispatch:L(($callerType:T)$callerExpr:L).$callerServiceName:L(«FOR param : call.arguments.tail.enumerate SEPARATOR ', '»(($paramType«param.value»:T) ($paramExpr«param.value»:L))«ENDFOR»)''',
								hm).build
					} else {
						call.callService(ctx)
					}
				} else {
					call.callService(ctx)
				}
			}
		else
			CodeBlock.of('''/*Call «call»*/''')
	}

}
