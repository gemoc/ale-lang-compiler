package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import javax.lang.model.element.Modifier
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import java.util.Map
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EStructuralFeature

class EClassInterfaceCompiler {

//	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	extension InterpreterCompilerUtils = new InterpreterCompilerUtils

	def compileEClassInterface(EClass eClass, ExtendedClass aleClass, File directory) {

		// TODO: in case of truffle option: add parent interface com.oracle.truffle.api.nodes.NodeInterface
		// TODO: weave the dynamically declared fields on the class
//		val attributesFields = eClass.EAttributes.map [ field |
//			val fieldType = field.EType.scopedInterfaceTypeRef
//			FieldSpec.builder(fieldType, field.name).addModifiers(Modifier.PRIVATE, Modifier.FINAL, Modifier.STATIC).
//				build
//		]
		val attributesMethods = eClass.EAttributes.map [ field |
			val fieldType = field.EType.scopedInterfaceTypeRef
			val getter = MethodSpec.
				methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
				returns(fieldType).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(fieldType,
				field.name).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
			#[getter, setter]
		].flatten

		val referencesMethods = eClass.EReferences.map [ field |
			val ert = field.EGenericType.ERawType
			val rt = ert.scopedInterfaceTypeRef
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if (isMultiple) {
					if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
						val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
						val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
						if(key !== null && value !== null) {
							ParameterizedTypeName.get(ClassName.get(EMap), key.EType.scopedInterfaceTypeRef, value.EType.scopedInterfaceTypeRef)
						} else {
							ParameterizedTypeName.get(ClassName.get(EList), rt)
						}
					} else {
						ParameterizedTypeName.get(ClassName.get(EList), rt)
					}
				} else
					rt
			val setter = if (!isMultiple) {
					#[
						MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(fieldType,
							field.name).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build]
				} else {
					#[]
				}

			val getter = #[
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).addModifiers(
					Modifier.ABSTRACT, Modifier.PUBLIC).build]

			getter + setter
		].flatten

		val operations = if (aleClass !== null) {
				aleClass.methods.map [ method |
					val params = method.operationRef.EParameters.map [ param |
						ParameterSpec.builder(param.EType.scopedInterfaceTypeRef, param.name).build
					]

					MethodSpec.methodBuilder(method.operationRef.name).returnsIfNotNull(
						method.operationRef.EType?.scopedInterfaceTypeRef).addParameters(params).addModifiers(
						Modifier.ABSTRACT, Modifier.PUBLIC).build
				]
			} else
				#[]

		val factory = TypeSpec.interfaceBuilder(eClass.classInterfaceClassName).addSuperinterface(EObject).
			addSuperinterfaces(eClass.ESuperTypes.map [
				ClassName.get(it.classInterfacePackageName, it.classInterfaceClassName)
			]).addMethods(attributesMethods + referencesMethods + operations).addModifiers(Modifier.PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classInterfacePackageName, factory).build

		javaFile.writeTo(directory)

	}

	def MethodSpec.Builder returnsIfNotNull(MethodSpec.Builder builder, TypeName typeName) {
		if (typeName !== null)
			builder.returns(typeName)
		else
			builder
	}
}
