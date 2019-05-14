package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.TypeName
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration

abstract class CommonTypeSystemUtils {
	
	abstract def TypeName resolveType2(Object type)
	
	def TypeName solveNothing(TypeName pt, Expression expr) {
//		var pt = _pt
		if(pt === null || pt.toString == "org.eclipse.acceleo.query.runtime.impl.Nothing") {
			var EObject blk = expr
			
			while(true) {
//				if(blk instanceof CodeBlock) 
				if(blk instanceof Block) {
					var EObject stmt = expr
					var stop = false
					while(stmt !== null && !stop) {
						if(blk.statements.contains(stmt)) {
							stop = true
						} else {
							stmt = stmt.eContainer
						}
					}
					
					if(stmt === null) {
						return pt
					}
					
					val idx = blk.statements.indexOf(stmt)
					if (idx > 0) {
						for (var i = idx - 1; i >= 0; i--) {
							val crt = blk.statements.get(i)
							if (crt instanceof VariableDeclaration) {
								if (expr instanceof VarRef && crt.name == (expr as VarRef).variableName) {
									return crt.type.resolveType2
								} else if(expr instanceof Call && crt.name == (expr as Call).serviceName) {
									return crt.type.resolveType2
								}
							}
						}
					} 
				}
				blk = blk.eContainer
				if(blk === null) {
					return pt 
				}				
			}
			
//			return _pt
			
//			var idx = blk.statements.indexOf(expr)
//			var prt = expr.eContainer
//			// TODO: WHAT A MESS !!!
//			while(idx < 0) {
//				if(prt === null) {
//					prt 
//				}
//				prt = prt.eContainer
//				idx = blk.statements.indexOf(prt)
//			}
//			var stop = false
//			for(var i = idx-1; i >=0 && !stop; i--) {
//				val crt = blk.statements.get(i)
//				if(crt instanceof VariableDeclaration) {
//					if(crt.name == (expr as VarRef).variableName) {
//						pt = crt.type.resolveType2
//						stop = true
//					}
//				}
//			}
////			if(!stop) {
////				println("NOTSPOT")
////			}
//			pt								
		} else {
			pt
		}
	}
}