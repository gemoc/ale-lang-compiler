package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import javax.lang.model.element.Modifier
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

class EClassInterfaceCompiler {

	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	extension InterpreterCompilerUtils = new InterpreterCompilerUtils
	extension JavaPoetUtils = new JavaPoetUtils

	def compileEClassInterface(EClass eClass, ExtendedClass aleClass, File directory, Dsl dsl, String packageRoot) {

		// TODO: in case of truffle option: add parent interface com.oracle.truffle.api.nodes.NodeInterface
		// TODO: weave the dynamically declared fields on the class
		val attributesMethods = eClass.EAttributes.map [ field |
			val fieldType = field.EType.scopedInterfaceTypeRef(packageRoot)
			val getter = MethodSpec.
				methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
				returns(fieldType).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(fieldType, 'value').
				addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
			#[getter, setter]
		].flatten

		val referencesMethods = eClass.EReferences.map [ field |
			val ert = field.EGenericType.ERawType
			val rt = ert.scopedInterfaceTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if (isMultiple) {
					if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
						val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
						val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
						if (key !== null && value !== null) {
							ParameterizedTypeName.get(ClassName.get(EMap), key.EType.scopedInterfaceTypeRef(packageRoot),
								value.EType.scopedInterfaceTypeRef(packageRoot))
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
						MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(fieldType, 'value').
							addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build]
				} else {
					#[]
				}

			val getter = #[
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).addModifiers(
					Modifier.ABSTRACT, Modifier.PUBLIC).build]

			getter + setter
		].flatten

		val operations = if (aleClass !== null) {
				// methods signature are only generated when truffle and the dispatch option are not activated, or if activated, only when the dispatch option is not activated on the method
				aleClass.methods.filter[!(it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true')].map [ method |
					val params = method.operationRef.EParameters.map [ param |
						ParameterSpec.builder(param.EType.scopedInterfaceTypeRef(packageRoot), param.name).build
					]

					MethodSpec.methodBuilder(method.operationRef.name).returnsIfNotNull(
						method.operationRef.EType?.scopedInterfaceTypeRef(packageRoot)).addParameters(params).addModifiers(
						Modifier.ABSTRACT, Modifier.PUBLIC).build
				]
			} else
				#[]

		val factory = TypeSpec.interfaceBuilder(eClass.classInterfaceClassName).addSuperinterface(EObject).applyIfTrue(
			dsl.dslProp.getProperty("truffle", "false") == "true", [
				addSuperinterface(ClassName.get("com.oracle.truffle.api.nodes", "NodeInterface"))
			]).addSuperinterfaces(eClass.ESuperTypes.map [
			ClassName.get(it.classInterfacePackageName(packageRoot), it.classInterfaceClassName)
		]).addMethods(attributesMethods + referencesMethods + operations).addModifiers(Modifier.PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classInterfacePackageName(packageRoot), factory).build

		javaFile.writeTo(directory)

	}

	def MethodSpec.Builder returnsIfNotNull(MethodSpec.Builder builder, TypeName typeName) {
		if (typeName !== null)
			builder.returns(typeName)
		else
			builder
	}
}
