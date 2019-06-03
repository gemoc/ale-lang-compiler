package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreGenNamingUtils

class InterpreterNamingUtils extends EcoreGenNamingUtils {
	
	override getIdentifier(){ "interpreter" }
	
	def String dispatchWrapperClassName(EClass eClass, Method method) {
		'''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''
	}
	
	def String normalizeExtendedClassName(ExtendedClass ec) {
		ec.name.split('\\.').reverse.head.toFirstUpper
	}
	
}
