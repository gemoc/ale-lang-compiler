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
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration

abstract class CommonTypeSystemUtils implements AbstractTypeSystem {

	val Map<String, Pair<EPackage, GenModel>> syntaxes

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

	new(Map<String, Pair<EPackage, GenModel>> syntaxes) {
		this.syntaxes = syntaxes
	}

	abstract def TypeName resolveType2(Object type)

	override TypeName solveNothing(TypeName pt, Expression expr) {
		if (pt === null || pt.toString == "org.eclipse.acceleo.query.runtime.impl.Nothing") {
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
}
