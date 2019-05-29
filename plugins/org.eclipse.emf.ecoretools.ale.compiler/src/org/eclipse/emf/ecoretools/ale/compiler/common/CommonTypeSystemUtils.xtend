package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.TypeName
import java.util.Map
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.acceleo.query.validation.type.IType
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl
import org.eclipse.xtext.EcoreUtil2
import java.util.List

abstract class CommonTypeSystemUtils implements AbstractTypeSystem {

	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val List<ResolvedClass> resolved

	protected def getSyntaxes() {
		this.syntaxes
	}

	def TypeName resolveType(EClassifier e)
	
	def dispatch TypeName solveType(EClass type) {
		resolveType(type)
	}

	def dispatch TypeName solveType(EDataType edt) {
		TypeName.get(edt.instanceClass)
	}

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved) {
		this.syntaxes = syntaxes
		this.resolved = resolved
	}

	abstract def TypeName resolveType2(Object type)

	override TypeName solveNothing(TypeName pt, Expression expr) {
		if (pt === null || pt.toString == "org.eclipse.acceleo.query.runtime.impl.Nothing") {
			
			if(expr instanceof VarRef && (expr as VarRef).variableName == 'result') {
				val method = EcoreUtil2.getContainerOfType(expr, MethodImpl)
				method.operationRef.EType.resolveType2
			 } else {
				var EObject blk = expr
	
				while (true) {
					if (blk instanceof Block) {
						var EObject stmt = expr
						var stop = false
						while (stmt !== null && !stop) {
							if (blk.statements.contains(stmt)) {
								stop = true
							} else {
								stmt = stmt.eContainer
							}
						}
	
						if (stmt === null) {
							return pt
						}
	
						val idx = blk.statements.indexOf(stmt)
						if (idx > 0) {
							for (var i = idx - 1; i >= 0; i--) {
								val crt = blk.statements.get(i)
								if (crt instanceof VariableDeclaration) {
									if (expr instanceof VarRef && crt.name == (expr as VarRef).variableName) {
										return crt.type.resolveType2
									} else if (expr instanceof Call && crt.name == (expr as Call).serviceName) {
										return crt.type.resolveType2
									}
								}
							}
						}
					}
					blk = blk.eContainer
					if (blk === null) {
						return pt
					}
				}
			}
		} else {
			pt
		}
	}

	def dispatch TypeName resolveType3(IType iType) {
		iType.type.resolveType2
	}

	def dispatch TypeName resolveType3(SequenceType iType) {
		val ct = iType.getCollectionType().getType()
		if (ct instanceof EClass) {
			if (ct.instanceClassName == "java.util.Map$Entry") {
				TypeName.get(EMap)
			} else {
				iType.type.resolveType2
			}
		} else {
			iType.type.resolveType2
		}
	}
	
	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}

	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls

		resolved.filter [
			it.eCls == ecls ||
				it.eCls instanceof EClass && ecls instanceof EClass && (it.eCls as EClass).isSuperTypeOf(ecls as EClass)
		].map [
			it.aleCls
		].filter[it !== null]
	}
}
