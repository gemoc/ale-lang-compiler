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
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils

class InterpreterNamingUtils implements AbstractNamingUtils {
	
	def String whileFieldName(While w) {
		val MessageDigest md = MessageDigest.getInstance("MD5");
		val hash = String.format("%032X", new BigInteger(1, md.digest(EcoreUtil.getURI(w).toString.bytes)))
		'''loopNode«hash»'''
	}
	
	def String dispatchWrapperClassName(EClass eClass, Method method) {
		'''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''
	}
	
	override String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name»'''
	}

	override String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}

	override String packageInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name»'''
	}

	override String packageInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Package'''
	}

	override String packageImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name».impl'''
	}

	override String packageImplementationClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»PackageImpl'''
	}

	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null»«packageRoot».«ENDIF»«ePackage.name».interpreter.«ePackage.name».impl'''
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
	
	def String normalizeExtendedClassName(ExtendedClass ec) {
		ec.name.split('\\.').reverse.head.toFirstUpper
	}
	
}
