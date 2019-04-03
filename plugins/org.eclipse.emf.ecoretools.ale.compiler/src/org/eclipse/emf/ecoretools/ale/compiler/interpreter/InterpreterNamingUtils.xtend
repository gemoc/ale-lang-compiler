package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import java.math.BigInteger
import java.security.MessageDigest
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.GenmodelNamingUtils
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.While

class InterpreterNamingUtils extends GenmodelNamingUtils {
	
	override getIdentifier(){ "interpreter" }
	
	def String whileFieldName(While w) {
		val MessageDigest md = MessageDigest.getInstance("MD5");
		val hash = String.format("%032X", new BigInteger(1, md.digest(EcoreUtil.getURI(w).toString.bytes)))
		'''loopNode«hash»'''
	}
	
	def String dispatchWrapperClassName(EClass eClass, Method method) {
		'''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''
	}
	
	def String normalizeExtendedClassName(ExtendedClass ec) {
		ec.name.split('\\.').reverse.head.toFirstUpper
	}
	
}
