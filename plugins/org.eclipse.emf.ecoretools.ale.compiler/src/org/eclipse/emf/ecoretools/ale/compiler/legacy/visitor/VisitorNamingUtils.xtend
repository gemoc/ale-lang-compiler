package org.eclipse.emf.ecoretools.ale.compiler.legacy.visitor

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreGenNamingUtils

@Deprecated
class VisitorNamingUtils extends EcoreGenNamingUtils {

	override getIdentifier() { "visitor" }

	def String operationInterfacePackageName(String packageRoot, EClass eClass) {
		'''«IF packageRoot !== null && packageRoot !== ''»«packageRoot».«ENDIF»«identifier».operation.«eClass.EPackage.name»'''
	}

	def String operationInterfaceClassName(EClass eClass) {
		'''«eClass.name»Operation'''
	}

	def String operationImplementationPackageName(String packageRoot, EClass eClass) {
		'''«IF packageRoot !== null && packageRoot !== ''»«packageRoot».«ENDIF»«identifier».operation.«eClass.EPackage.name».impl'''
	}

	def String operationImplementationClassName(EClass eClass) {
		'''«eClass.name»OperationImpl'''
	}

	def String visitorInterfacePackageName(String packageRoot) {
		'''«IF packageRoot !== null && packageRoot !== ''»«packageRoot».«ENDIF»«identifier»'''
	}

	def String visitorInterfaceClassName() {
		'''VisitorInterface'''
	}

	def String visitorImplementationPackageName(String packageRoot) {
		'''«IF packageRoot !== null && packageRoot !== ''»«packageRoot».«ENDIF»«identifier»'''
	}

	def String visitorImplementationClassName() {
		'''VisitorImplementation'''
	}

	def String acceptInterfacePackageName(String packageRoot) {
		'''«IF packageRoot !== null && packageRoot !== ''»«packageRoot».«ENDIF»«identifier»'''
	}

	def String acceptInterfaceClassName() {
		'''AcceptInterface'''
	}
}
