package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenTypedElementImpl
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.GenmodelNamingUtils

class CommonCompilerUtils {
	extension GenmodelNamingUtils anu
	val List<ResolvedClass> resolved

	new(GenmodelNamingUtils anu, List<ResolvedClass> resolved) {
		this.anu = anu
		this.resolved = resolved
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
	
	def TypeName computeFieldTypeEClass(EStructuralFeature field, String packageRoot) {
		val eClass = field.EContainingClass
		val genCls = resolved.filter[it.ECls.name == eClass.name && it.ECls.EPackage.name == eClass.EPackage.name].head.
			genCls
		val genFeature = genCls.declaredFieldGenFeatures.filter[it.name == field.name].head as GenTypedElementImpl

		val ert = field.EGenericType.ERawType
		if (genFeature.isFeatureMapType())
			return ClassName.get("org.eclipse.emf.ecore.util", "FeatureMap")
		if (genFeature.isMapType()) {
			val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
			val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
			val keyType = key.EType.scopedInterfaceTypeRef(packageRoot)
			val valueType = value.EType.scopedInterfaceTypeRef(packageRoot)
			return ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EMap"), keyType.box,
				valueType.box)
		}
		if (genFeature.isMapEntryType()) {
			val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
			val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
			val keyType = key.EType.scopedInterfaceTypeRef(packageRoot)
			val valueType = value.EType.scopedInterfaceTypeRef(packageRoot)
			if (genFeature.isListType()) {
				return ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
					ParameterizedTypeName.get(ClassName.get("java.util", "Map.Entry"), keyType.box, valueType.box))
			} else {
				return ParameterizedTypeName.get(ClassName.get("java.util", "Map.Entry"), keyType.box, valueType.box);
			}
		}
		if (genFeature.isListType()) {
			val listType = ert.scopedInterfaceTypeRef(packageRoot)
			return ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"), listType.box)
		}
		if (genFeature.isListDataType()) {
			val listType = ert.scopedInterfaceTypeRef(packageRoot)
			return ParameterizedTypeName.get(ClassName.get("java.util", "List"), listType)
		}
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		return rt
	}
}
