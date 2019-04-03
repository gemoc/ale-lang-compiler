package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.TypeName
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum

class CommonCompilerUtils {
	extension AbstractNamingUtils anu

	new(AbstractNamingUtils anu) {
		this.anu = anu
	}

	def dispatch scopedTypeRef(EDataType edt, String packageRoot) {
		TypeName.get(edt.instanceClass)
	}

	def dispatch scopedTypeRef(EClass clazz, String packageRoot) {
		ClassName.get(clazz.classImplementationPackageName(packageRoot), clazz.classImplementationClassName)
	}

	def dispatch scopedTypeRef(EEnum eEnum, String packageRoot) {
		ClassName.get(eEnum.classInterfacePackageName(packageRoot), eEnum.classInterfaceClassName)
	}

	def dispatch scopedInterfaceTypeRef(EDataType edt, String packageRoot) {
		TypeName.get(edt.instanceClass)
	}

	def dispatch scopedInterfaceTypeRef(EClass clazz, String packageRoot) {
		ClassName.get(clazz.classInterfacePackageName(packageRoot), clazz.classInterfaceClassName)
	}

	def dispatch scopedInterfaceTypeRef(EEnum eEnum, String packageRoot) {
		ClassName.get(eEnum.classInterfacePackageName(packageRoot), eEnum.classInterfaceClassName)
	}
}
