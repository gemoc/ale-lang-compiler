package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

class InterpreterNamingUtils {
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name»'''
	}

	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}

	def String packageInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name»'''
	}

	def String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	def String packageImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name».impl'''
	}

	def String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name».impl'''
	}

	def String factoryImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»FactoryImpl'''
	}

	def String classInterfacePackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryInterfacePackageName(packageRoot)
	}

	def String classInterfaceClassName(EClass eClass) {
		eClass.name.toFirstUpper
	}

	def String classImplementationPackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryImplementationPackageName(packageRoot)
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
	
	def String normalizeExtendedClassName(ExtendedClass ec) {
		ec.name.split('\\.').reverse.head.toFirstUpper
	}
}
