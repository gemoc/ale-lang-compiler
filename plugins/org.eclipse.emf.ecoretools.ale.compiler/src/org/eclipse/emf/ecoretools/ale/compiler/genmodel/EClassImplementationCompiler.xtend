package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.ParameterizedTypeName
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecoretools.ale.compiler.CommonCompilerUtils

import static javax.lang.model.element.Modifier.*
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils
import java.util.Map
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.common.util.EMap
import org.eclipse.xtext.xbase.lib.Functions.Function2
import org.eclipse.emf.ecore.EReference
import com.squareup.javapoet.MethodSpec
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

class EClassImplementationCompiler {

	extension CommonCompilerUtils ccu
	extension AbstractNamingUtils anu
	val EClassGetterCompiler eClassGetterCompiler

	new(CommonCompilerUtils ccu, AbstractNamingUtils anu, EClassGetterCompiler eClassGetterCompiler) {
		this.ccu = ccu
		this.anu = anu
		this.eClassGetterCompiler = eClassGetterCompiler
	}

	def Iterable<MethodSpec> getMethodsEReferences(EClass eClass, String packageRoot, Dsl dsl,
		ClassName ePackageInterfaceType, boolean isMapElement) {
		eClass.EStructuralFeatures.map [ field |
			val ert = field.EGenericType.ERawType
			val rt = ert.scopedInterfaceTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if (isMultiple) {
					if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
						val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
						val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
						if (key !== null && value !== null) {
							ParameterizedTypeName.get(ClassName.get(EMap),
								key.EType.scopedInterfaceTypeRef(packageRoot).box,
								value.EType.scopedInterfaceTypeRef(packageRoot).box)
						} else {
							ParameterizedTypeName.get(ClassName.get(EList), rt.box)
						}
					} else {
						ParameterizedTypeName.get(ClassName.get(EList), rt.box)
					}
				} else
					rt

			eClassGetterCompiler.compileGetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType,
				isMapElement)
		].flatten
	}

	def Iterable<FieldSpec> getFieldsEReferences(EClass eClass, String packageRoot) {
		this.getFieldsEReferences(eClass, packageRoot, [b, e|b])
	}

	def Iterable<FieldSpec> getFieldsEReferences(EClass eClass, String packageRoot,
		Function2<FieldSpec.Builder, EReference, FieldSpec.Builder> f2) {
		eClass.EReferences.filter[field|if(field.EOpposite !== null) !field.EOpposite.containment else true].map [ field |
			val ert = field.EGenericType.ERawType
			val rt = ert.scopedInterfaceTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if (isMultiple) {
					if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
						val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
						val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
						if (key !== null && value !== null) {
							ParameterizedTypeName.get(ClassName.get(EMap),
								key.EType.scopedInterfaceTypeRef(packageRoot),
								value.EType.scopedInterfaceTypeRef(packageRoot))
						} else {
							ParameterizedTypeName.get(ClassName.get(EList), rt)
						}
					} else {
						ParameterizedTypeName.get(ClassName.get(EList), rt)
					}
				} else
					rt

			val builderTmp = FieldSpec.builder(fieldType, field.name)
			val builderTmp2 = if(f2 !== null) f2.apply(builderTmp, field) else builderTmp
			builderTmp2.addModifiers(PROTECTED).build
		]
	}

	def Iterable<FieldSpec> getFieldsEAttributes(EClass eClass, String packageRoot) {
		eClass.EAttributes.map [ field |
			val fet = field.EType
			val type = fet.scopedTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			if (isMultiple) {
				val fieldField = FieldSpec.builder(
					ParameterizedTypeName.get(ClassName.get(EList), type.box), '''«field.name»''', PROTECTED).build
				#[fieldField]
			} else {
				val edefault = if (fet instanceof EEnum) {
						var tmpfs = FieldSpec.builder(type, '''«field.name.toUpperCase»_EDEFAULT''')

						if (field.defaultValue === null || field.defaultValue.toString == '')
							tmpfs = tmpfs.initializer('''null''')
						else
							tmpfs = tmpfs.initializer(
								'''$T.«field.defaultValue.toString.toUpperCase»''',
								ClassName.get(fet.classInterfacePackageName(packageRoot), fet.classInterfaceClassName)
							)

						tmpfs.addModifiers(PROTECTED, STATIC, FINAL).build
					} else {
						FieldSpec.builder(type, '''«field.name.toUpperCase»_EDEFAULT''').
							initializer('''«IF field.defaultValue === null || field.defaultValue.toString == ''»null«ELSE»«field.defaultValue»«ENDIF»''').
							addModifiers(PROTECTED, STATIC, FINAL).build
					}

				val fieldField = FieldSpec.builder(type, field.name.normalizeVarName).
					initializer('''«field.name.toUpperCase»_EDEFAULT''').addModifiers(PROTECTED).build
				#[edefault, fieldField]

			}
		].flatten
	}
}
