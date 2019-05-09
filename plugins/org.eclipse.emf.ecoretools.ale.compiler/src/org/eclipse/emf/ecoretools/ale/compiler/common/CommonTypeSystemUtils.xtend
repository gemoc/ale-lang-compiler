package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.TypeName
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.xtext.EcoreUtil2

abstract class CommonTypeSystemUtils {
	
	abstract def TypeName resolveType2(Object type)
	
	def TypeName solveNothing(TypeName _pt, Expression expr) {
		var pt = _pt
		if(pt.toString == "org.eclipse.acceleo.query.runtime.impl.Nothing") {
			val blk = EcoreUtil2.getContainerOfType(expr, Block)
			var idx = blk.statements.indexOf(expr)
			var prt = expr.eContainer
			// TODO: WHAT A MESS !!!
			while(idx < 0) {
				prt = prt.eContainer
				idx = blk.statements.indexOf(prt)
			}
			var stop = false
			for(var i = idx-1; i >=0 && !stop; i--) {
				val crt = blk.statements.get(i)
				if(crt instanceof VariableDeclaration) {
					if(crt.name == (expr as VarRef).variableName) {
						pt = crt.type.resolveType2
						stop = true
					}
				}
			}
			pt								
		} else {
			pt
		}
	}
}