package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass

class SwitchNamingUtils {
	
	def String switchImplementationClassName(String pkg) {
		'''«pkg.toFirstUpper»SwitchImplementation'''
		
	}
	def String switchImplementationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»emfswitch'''
	}
	
	def String operationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»emfswitch.operation'''
	}
	
	def String operationClassName(EClass eCls) {
		'''«eCls.name.toFirstUpper»Operation'''
	}
	
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name»'''
	}
	
	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}
}