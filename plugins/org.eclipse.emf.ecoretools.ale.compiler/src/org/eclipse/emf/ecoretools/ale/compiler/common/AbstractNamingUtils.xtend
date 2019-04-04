package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import javax.lang.model.SourceVersion

abstract class AbstractNamingUtils {

	def String classInterfacePackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryInterfacePackageName(packageRoot)
	}

	def String classInterfacePackageName(EEnum eEnum, String packageRoot) {
		eEnum.EPackage.factoryInterfacePackageName(packageRoot)
	}

	def String getIdentifier()
	
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name»'''
	}

	def String normalizeVarName(String name) {
		val _name = name.toFirstLower
		if(SourceVersion.isKeyword(_name)) {
			'''«_name»_'''
		} else {
			_name
		}
	}

	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»'''

	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}
