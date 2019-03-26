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
	
	def normalizeVarName(String name) {
		if(name == "enum") 'enum_'
		else name
	}
	
	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»''' 
	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}