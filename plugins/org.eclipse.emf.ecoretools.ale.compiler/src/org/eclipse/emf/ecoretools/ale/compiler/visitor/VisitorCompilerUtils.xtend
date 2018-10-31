package org.eclipse.emf.ecoretools.ale.compiler.visitor

import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EClass
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.TypeName

class VisitorCompilerUtils {

	extension VisitorNamingUtils = new VisitorNamingUtils

	def dispatch scopedTypeRef(EDataType edt, String packageRoot) {
		TypeName.get(edt.instanceClass)
	}

	def dispatch scopedTypeRef(EClass clazz, String packageRoot) {
		ClassName.get(clazz.classImplementationPackageName(packageRoot), clazz.classImplementationClassName)
	}

	def dispatch scopedInterfaceTypeRef(EDataType edt, String packageRoot) {
		TypeName.get(edt.instanceClass)
	}

	def dispatch scopedInterfaceTypeRef(EClass clazz, String packageRoot) {
		ClassName.get(clazz.classInterfacePackageName(packageRoot), clazz.classInterfaceClassName)
	}
}
