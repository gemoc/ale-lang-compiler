package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import java.math.BigInteger
import java.security.MessageDigest
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.While

class InterpreterNamingUtils {
	
	def String whileFieldName(While w) {
		val MessageDigest md = MessageDigest.getInstance("MD5");
		val hash = String.format("%032X", new BigInteger(1, md.digest(EcoreUtil.getURI(w).toString.bytes)))
		'''loopNode«hash»'''
	}
	
	def String dispatchWrapperClassName(EClass eClass, Method method) {
		'''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''
	}
	
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
		//'''«CodeGenUtil.format(className, '_', '', false, false).toLowerCase.toFirstUpper»_«CodeGenUtil.format(input, '_', '', false, false).toLowerCase.toFirstUpper»'''
		'''«className»_«input.toFirstUpper»'''
	}
	
	def String normalizeExtendedClassName(ExtendedClass ec) {
		ec.name.split('\\.').reverse.head.toFirstUpper
	}
	
	def normalizeVarName(String name) {
		if(name == "enum") 'enum_'
		else name
	}
	
	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»''' 
	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}
