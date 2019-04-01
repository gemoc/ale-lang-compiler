package org.eclipse.emf.ecoretools.ale.compiler

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

interface AbstractNamingUtils {
	
	def String normalizeUpperField(String input)
	def String normalizeUpperField(String input, String className)
	def String packageInterfaceClassName(EPackage ePackage)
	def String packageInterfacePackageName(EPackage ePackage, String packageRoot)
	def String classImplementationPackageName(EClass eClass, String packageRoot)
	def String classImplementationClassName(EClass eClass)
	def String classInterfacePackageName(EClass eClass, String packageRoot)
	def String classInterfacePackageName(EEnum eEnum, String packageRoot)
	def String classInterfaceClassName(EClass eClass)
	def String classInterfaceClassName(EEnum eEnum)
	def String packageImplementationClassName(EPackage ePackage)
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot)
	def String factoryInterfaceClassName(EPackage ePackage)
	def String normalizeUpperMethod(String input, String className)
	def String packageImplementationPackageName(EPackage ePackage, String packageRoot)
	
	def normalizeVarName(String _name) {
		val name = _name.toFirstLower
		if(name == "enum") 'enum_'
		else if(name == "while") 'while_'
		else if(name == "if") 'if_'
		else if(name == "this") 'this_'
		else if(name == "int") 'int_'
		else name
	}
	
	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»''' 
	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}