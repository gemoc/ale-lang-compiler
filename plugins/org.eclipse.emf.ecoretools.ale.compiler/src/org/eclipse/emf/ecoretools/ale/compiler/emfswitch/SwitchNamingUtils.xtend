package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import com.squareup.javapoet.ClassName
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils

class SwitchNamingUtils extends AbstractNamingUtils {
	
	def String switchImplementationClassName(String pkg) {
		'''«pkg.toFirstUpper»SwitchImplementation'''
		
	}
	def String switchImplementationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»emfswitch'''
	}
	
	def String operationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»emfswitch.operation'''
	}
	
	def dispatch String operationClassName(EClass eCls) {
		'''«eCls.name.toFirstUpper»Operation'''
	}

	def dispatch String operationClassName(ClassName eCls) {
		'''«eCls.simpleName»Operation'''
	}

	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}
	
	override classInterfacePackageName(EClass eClass, String packageRoot) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override classInterfacePackageName(EEnum eEnum, String packageRoot) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override classImplementationPackageName(EClass eClass, String packageRoot) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override classImplementationClassName(EClass eClass) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override classInterfaceClassName(EClass eClass) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override classInterfaceClassName(EEnum eEnum) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}