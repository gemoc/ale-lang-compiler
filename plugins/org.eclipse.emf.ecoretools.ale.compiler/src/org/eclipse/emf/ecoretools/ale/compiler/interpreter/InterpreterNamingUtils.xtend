package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage

class InterpreterNamingUtils {
	def String factoryInterfacePackageName(EPackage ePackage) {
		'''«ePackage.name.toLowerCase».interpreter'''
	}

	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}

	def String packageInterfacePackageName(EPackage ePackage) {
		'''«ePackage.name.toLowerCase».interpreter'''
	}

	def String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	def String packageImplementationPackageName(EPackage ePackage) {
		'''«ePackage.name.toLowerCase».interpreter.impl'''
	}

	def String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

	def String factoryImplementationPackageName(EPackage ePackage) {
		'''«ePackage.name.toLowerCase».interpreter.impl'''
	}

	def String factoryImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»FactoryImpl'''
	}

	def String classInterfacePackageName(EClass eClass) {
		eClass.EPackage.factoryInterfacePackageName
	}

	def String classInterfaceClassName(EClass eClass) {
		eClass.name.toFirstUpper
	}

	def String classImplementationPackageName(EClass eClass) {
		eClass.EPackage.factoryImplementationPackageName
	}

	def String classImplementationClassName(EClass eClass) {
		'''«eClass.name.toFirstUpper»Impl'''
	}

	def String normalizeUpperField(String input) {
		'''«CodeGenUtil.format(input, '_', '', false, false)»'''.toString.toUpperCase
	}

	def String normalizeUpperField(String input, String className) {
		'''«CodeGenUtil.format(className, '_', '', false, false)»__«CodeGenUtil.format(input, '_', '', false, false)»'''.
			toString.toUpperCase
	}

	def String normalizeUpperMethod(String input, String className) {
		'''«CodeGenUtil.format(className, '_', '', false, false).toLowerCase.toFirstUpper»_«CodeGenUtil.format(input, '_', '', false, false).toLowerCase.toFirstUpper»'''
	}
}
