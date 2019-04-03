package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.GenmodelNamingUtils
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method

class InterpreterNamingUtils extends GenmodelNamingUtils {
	
	override getIdentifier(){ "interpreter" }
	
	def String dispatchWrapperClassName(EClass eClass, Method method) {
		'''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''
	}
	
	def String normalizeExtendedClassName(ExtendedClass ec) {
		ec.name.split('\\.').reverse.head.toFirstUpper
	}
	
}
