package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

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

	def normalizeVarName(String _name) {
		val name = _name.toFirstLower
		if (name == "enum")
			'enum_'
		else if (name == "while")
			'while_'
		else if (name == "if")
			'if_'
		else if (name == "this")
			'this_'
		else if(name == "int") 'int_' else name
	}

	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»'''

	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}
