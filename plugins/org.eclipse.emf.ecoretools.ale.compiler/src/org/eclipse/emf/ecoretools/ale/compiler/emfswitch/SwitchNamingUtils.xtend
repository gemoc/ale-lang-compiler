package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import com.squareup.javapoet.ClassName
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils

class SwitchNamingUtils extends AbstractNamingUtils {
	
	override getIdentifier(){ "emfswitch" }
	
	def String switchImplementationClassName(String pkg) {
		'''«pkg.toFirstUpper»SwitchImplementation'''
	}
	def String switchImplementationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«identifier»'''
	}
	
	def String operationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«identifier».operation'''
	}
	
	def dispatch String operationClassName(EClass eCls) {
		'''«eCls.name.toFirstUpper»Operation'''
	}

	def dispatch String operationClassName(ClassName eCls) {
		'''«eCls.simpleName»Operation'''
	}

	override String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}
	
	override packageInterfacePackageName(EPackage epkg, String packageRoot) {
		switchImplementationPackageName(packageRoot)
	}
	
}