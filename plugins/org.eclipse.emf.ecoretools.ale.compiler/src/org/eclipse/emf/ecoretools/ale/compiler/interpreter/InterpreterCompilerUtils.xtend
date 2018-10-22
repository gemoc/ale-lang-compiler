package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EClass
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.TypeName

class InterpreterCompilerUtils {

	extension InterpreterNamingUtils = new InterpreterNamingUtils

//	def isDispatch(AleMethod method) {
//		method instanceof DefMethod && (method as DefMethod).dispatch
//	}
	def dispatch scopedTypeRef(EDataType edt) {
		TypeName.get(edt.instanceClass)
	}

	def dispatch scopedTypeRef(EClass clazz) {
		ClassName.get(clazz.classImplementationPackageName, clazz.classImplementationClassName)
	}

	def dispatch scopedInterfaceTypeRef(EDataType edt) {
		TypeName.get(edt.instanceClass)
	}

	def dispatch scopedInterfaceTypeRef(EClass clazz) {
		ClassName.get(clazz.classInterfacePackageName, clazz.classInterfaceClassName)
	}
}
