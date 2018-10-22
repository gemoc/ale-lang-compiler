package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage

class InterpreterNamingUtils {
	def String factoryInterfacePackageName(EPackage ePackage) {
		'''«ePackage.name.toLowerCase».interpreter'''
	}

	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
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
}
