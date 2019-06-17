package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils
import com.squareup.javapoet.ClassName
import org.eclipse.emf.ecore.EStructuralFeature

abstract class EcoreGenNamingUtils extends AbstractNamingUtils {

	
	
	def factoryIntClassName(EPackage ePackage, String packageRoot) {
		ClassName.get(ePackage.factoryInterfacePackageName(packageRoot), ePackage.factoryInterfaceClassName)
	}

	override String packageInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null && packageRoot != ''»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name»'''
	}

	def String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	def packageIntClassName(EClass eClass, String packageRoot) {
		eClass.EPackage.packageIntClassName(packageRoot)
	}
	
	def packageIntClassName(EPackage ePackage, String packageRoot) {
		ClassName.get(ePackage.packageInterfacePackageName(packageRoot), ePackage.packageInterfaceClassName)
	}

	def String packageImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null && packageRoot != ''»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name».impl'''
	}

	def String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

//	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
//		'''«IF packageRoot !== null && packageRoot != ''»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name».impl'''
//	}

	def String factoryImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»FactoryImpl'''
	}

	def String classInterfaceClassName(EClass eClass) {
		eClass.name.toFirstUpper
	}

	def String classInterfaceClassName(EEnum eEnum) {
		eEnum.name.toFirstUpper
	}

//	def String classImplementationPackageName(EClass eClass, String packageRoot) {
//		eClass.EPackage.factoryImplementationPackageName(packageRoot)
//	}

	def String classImplementationClassName(EClass eClass) {
		'''«eClass.name.toFirstUpper»Impl'''
	}

	def String normalizeUpperField(String input) {
		'''«CodeGenUtil.format(input, '_', '', false, false)»'''.toString.toUpperCase
	}

	def String normalizeUpperField(EStructuralFeature esf) {
		esf.name.normalizeUpperField(esf.EContainingClass.name)
	}
	
	def String normalizeUpperField(EStructuralFeature esf, EClass eClass) {
		esf.name.normalizeUpperField(eClass.name)
	}

	def private String normalizeUpperField(String input, String className) {
		'''«CodeGenUtil.format(className, '_', '', false, false)»__«CodeGenUtil.format(input, '_', '', false, false)»'''.
			toString.toUpperCase
	}

	def String normalizeUpperMethod(String input, String className) {
		'''«className»_«input.toFirstUpper»'''
	}
}
