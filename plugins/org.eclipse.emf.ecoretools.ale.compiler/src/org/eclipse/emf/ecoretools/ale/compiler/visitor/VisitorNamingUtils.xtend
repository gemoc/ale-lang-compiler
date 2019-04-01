package org.eclipse.emf.ecoretools.ale.compiler.visitor

import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.GenmodelNamingUtils

class VisitorNamingUtils extends GenmodelNamingUtils {
	
	def String operationInterfacePackageName(String packageRoot, EClass eClass) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»visitor.operation.«eClass.EPackage.name»'''
	}
	
	def String operationInterfaceClassName(EClass eClass) {
		'''«eClass.name»Operation'''
	}
	
	def String operationImplementationPackageName(String packageRoot, EClass eClass) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»visitor.operation.«eClass.EPackage.name».impl'''
	}
	
	def String operationImplementationClassName(EClass eClass) {
		'''«eClass.name»OperationImpl'''
	}
	
	def String visitorInterfacePackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»visitor'''
	}
	
	def String visitorInterfaceClassName() {
		'''VisitorInterface'''
	}
	
		
	def String visitorImplementationPackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»visitor'''
	}
	
	def String visitorImplementationClassName() {
		'''VisitorImplementation'''
	}
	
	def String acceptInterfacePackageName(String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»visitor'''
	}
	
	def String acceptInterfaceClassName() {
		'''AcceptInterface'''
	}
	
	override String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name»'''
	}

	override String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}

	override String packageInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name»'''
	}

	override String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	override String packageImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name».impl'''
	}

	override String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

	override String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name».impl'''
	}

	override String factoryImplementationClassName(EPackage ePackage) {
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

	override String normalizeUpperField(String input) {
		'''«CodeGenUtil.format(input, '_', '', false, false)»'''.toString.toUpperCase
	}

	override String normalizeUpperField(String input, String className) {
		'''«CodeGenUtil.format(className, '_', '', false, false)»__«CodeGenUtil.format(input, '_', '', false, false)»'''.
			toString.toUpperCase
	}

	override String normalizeUpperMethod(String input, String className) {
		'''«className»_«input.toFirstUpper»'''
	}
}
