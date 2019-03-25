package org.eclipse.emf.ecoretools.ale.compiler.visitor

import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EEnum

class VisitorNamingUtils {
	
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
	
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name»'''
	}

	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}

	def String packageInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name»'''
	}

	def String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	def String packageImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name».impl'''
	}

	def String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».visitor.«ePackage.name».impl'''
	}

	def String factoryImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»FactoryImpl'''
	}

	def String classInterfacePackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryInterfacePackageName(packageRoot)
	}
	
	def String classInterfacePackageName(EEnum eEnum, String packageRoot) {
		eEnum.EPackage.factoryInterfacePackageName(packageRoot)
	}

	def String classInterfaceClassName(EClass eClass) {
		eClass.name.toFirstUpper
	}
	
	def String classInterfaceClassName(EEnum eEnum) {
		eEnum.name.toFirstUpper
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
	
	def normalizeVarName(String name) {
		if(name == "enum") 'enum_'
		else name
	}
	
	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»''' 
	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}
