package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.xtend.lib.annotations.Data

@Data
class CompilerExpressionCtx {
	String thisCtxName
	ExtendedClass aleClass
	public EClass eClass

}
