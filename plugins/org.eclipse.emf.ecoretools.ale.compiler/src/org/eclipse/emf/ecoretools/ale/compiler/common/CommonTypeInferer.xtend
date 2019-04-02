package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator

class CommonTypeInferer {
	
	val BaseValidator base
	
	new(BaseValidator base) {
		this.base = base
	}
	
	def infereType(Expression exp) {
		base.getPossibleTypes(exp)
	}
}