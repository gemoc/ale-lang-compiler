package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Arrays
import java.util.Collections
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils

import static javax.lang.model.element.Modifier.*
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils

class EClassInterfaceCompiler {

	extension AbstractNamingUtils namingUtils
	extension CommonCompilerUtils ccu

	new(AbstractNamingUtils namingUtils, CommonCompilerUtils ccu) {
		this.namingUtils = namingUtils
		this.ccu = ccu
	}
	
	def Iterable<MethodSpec> getAttributeMethods(EClass eClass, String packageRoot) {
		eClass.EAttributes.map [ field |
			val fieldType = field.EType.scopedInterfaceTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			if (isMultiple) {
				val elistType = ParameterizedTypeName.get(ClassName.get(EList), fieldType.box)
				val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(elistType).
					addModifiers(ABSTRACT, PUBLIC).build
				#[getter]
			} else {
				val getter = MethodSpec.
					methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
					returns(fieldType).addModifiers(ABSTRACT, PUBLIC).build
				val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(fieldType,
					'value').addModifiers(ABSTRACT, PUBLIC).build
				#[getter, setter]
			}
		].flatten
	}
	
	
	def Iterable<MethodSpec> getReferenceMethods(EClass eClass, String packageRoot) {
		eClass.EReferences.map [ field |
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
			val setter = if (!isMultiple) {
					#[
						MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(fieldType, 'value').
							addModifiers(ABSTRACT, PUBLIC).build]
				} else {
					#[]
				}

			val getter = #[
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).addModifiers(ABSTRACT,
					PUBLIC).build]

			getter + setter
		].flatten
	}

	def compileEClassInterface(EEnum eEnum, File directory, String packageRoot) {

		val selfClassName = eEnum.name
		val selfPackageName = eEnum.classInterfacePackageName(packageRoot)
		val selfClass = ClassName.get(selfPackageName, selfClassName)
		val selfArrayClass = ArrayTypeName.of(selfClass)
		val selfListClass = ParameterizedTypeName.get(ClassName.get(List), selfClass)

		val factory = TypeSpec.enumBuilder(selfClassName).addSuperinterface(
			ClassName.get('org.eclipse.emf.common.util', 'Enumerator')).addEnumConstants(eEnum.ELiterals.map [
			it.name -> TypeSpec.anonymousClassBuilder('''$L, $S, $S''', it.value, it.name, it.literal).build
		]).addFields(eEnum.ELiterals.map [
			FieldSpec.builder(int, '''«it.name.toUpperCase»_VALUE''', PUBLIC, STATIC, FINAL).
				initializer('''«it.value»''').build
		]).addField(
			FieldSpec.builder(selfArrayClass, 'VALUES_ARRAY', PRIVATE, STATIC, FINAL).
				initializer('''new $T { «FOR lit : eEnum.ELiterals SEPARATOR ', '»«lit.name»«ENDFOR» }''',
					selfArrayClass).build
		).addField(
			FieldSpec.builder(selfListClass, 'VALUES', PUBLIC, STATIC, FINAL).
				initializer('''$T.unmodifiableList($T.asList(VALUES_ARRAY))''', Collections, Arrays).build
		).addMethod(
			MethodSpec.methodBuilder('''get''').returns(selfClass).addParameter(int, 'value').addCode('''
				switch (value) {
					«FOR lit : eEnum.ELiterals»
						case «lit.name»_VALUE: return «lit.name»;
					«ENDFOR»
				}
				return null;
			''', selfClass).addModifiers(PUBLIC, STATIC).build
		).addMethod(
			MethodSpec.methodBuilder('''get''').returns(selfClass).addParameter(String, 'literal').addCode('''
				for (int i = 0; i < VALUES_ARRAY.length; ++i) {
					$T result = VALUES_ARRAY[i];
					if (result.toString().equals(literal)) {
						return result;
					}
				}
				return null;
			''', selfClass).addModifiers(PUBLIC, STATIC).build
		).addMethod(
			MethodSpec.methodBuilder('''getByName''').returns(selfClass).addParameter(String, 'name').addCode('''
				for (int i = 0; i < VALUES_ARRAY.length; ++i) {
					$T result = VALUES_ARRAY[i];
					if (result.getName().equals(name)) {
						return result;
					}
				}
				return null;
			''', selfClass).addModifiers(PUBLIC, STATIC).build
		).addField(int, 'value', PRIVATE, FINAL).addField(String, 'name', PRIVATE, FINAL).addField(String, 'literal',
			PRIVATE, FINAL).addMethod(
			MethodSpec.constructorBuilder.addParameter(int, 'value').addParameter(String, 'name').addParameter(String,
				'literal').addCode('''
				this.value = value;
				this.name = name;
				this.literal = literal;
			''').addModifiers(PRIVATE).build
		).addMethod(
			MethodSpec.methodBuilder('getValue').returns(int).addCode('''
				return value;
			''').addModifiers(PUBLIC).build
		).addMethod(
			MethodSpec.methodBuilder('getLiteral').returns(String).addCode('''
				return literal;
			''').addModifiers(PUBLIC).build
		).addMethod(
			MethodSpec.methodBuilder('getName').returns(String).addCode('''
				return name;
			''').addModifiers(PUBLIC).build
		).addMethod(
			MethodSpec.methodBuilder('toString').addAnnotation(Override).returns(String).addCode('''
				return literal;
			''').addModifiers(PUBLIC).build
		).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(selfPackageName, factory).indent('\t').build

		javaFile.writeTo(directory)
	}

	def TypeSpec.Builder addEnumConstants(TypeSpec.Builder seed, List<Pair<String, TypeSpec>> constants) {
		constants.fold(seed, [ builder, ec |
			builder.addEnumConstant(ec.key, ec.value)
		])
	}
}
