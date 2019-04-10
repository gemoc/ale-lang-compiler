package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.GenmodelNamingUtils

class CommonCompilerUtils {
	extension GenmodelNamingUtils anu

	new(GenmodelNamingUtils anu) {
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
	
	def resolveFieldType(EStructuralFeature field, String packageRoot) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		val isMultiple = field.upperBound > 1 || field.upperBound < 0

		if (isMultiple) {
			if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
				val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
				val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
				if (key !== null && value !== null) {
					ParameterizedTypeName.get(ClassName.get(EMap), key.EType.scopedInterfaceTypeRef(packageRoot).box,
						value.EType.scopedInterfaceTypeRef(packageRoot).box)
				} else {
					ParameterizedTypeName.get(ClassName.get(EList), rt.box)
				}
			} else {
				ParameterizedTypeName.get(ClassName.get(EList), rt.box)
			}
		} else
			rt
	}
}
