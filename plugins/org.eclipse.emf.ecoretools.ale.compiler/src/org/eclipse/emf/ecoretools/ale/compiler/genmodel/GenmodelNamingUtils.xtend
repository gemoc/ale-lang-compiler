package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EEnum

abstract class GenmodelNamingUtils extends AbstractNamingUtils {
	def String getIdentifier()

	override String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name»'''
	}

	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}

	def String packageInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name»'''
	}

	def String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	def String packageImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name».impl'''
	}

	def String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name».impl'''
	}

	def String factoryImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»FactoryImpl'''
	}

	override String classInterfacePackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryInterfacePackageName(packageRoot)
	}

	override String classInterfacePackageName(EEnum eEnum, String packageRoot) {
		eEnum.EPackage.factoryInterfacePackageName(packageRoot)
	}

	override String classInterfaceClassName(EClass eClass) {
		eClass.name.toFirstUpper
	}

	override String classInterfaceClassName(EEnum eEnum) {
		eEnum.name.toFirstUpper
	}

	override String classImplementationPackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryImplementationPackageName(packageRoot)
	}

	override String classImplementationClassName(EClass eClass) {
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
		'''«className»_«input.toFirstUpper»'''
	}
}
