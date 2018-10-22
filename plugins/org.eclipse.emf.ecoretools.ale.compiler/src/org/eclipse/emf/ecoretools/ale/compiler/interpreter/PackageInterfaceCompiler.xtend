package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import javax.lang.model.element.Modifier
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EStructuralFeature
import com.squareup.javapoet.MethodSpec

class PackageInterfaceCompiler {

	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils

	def TypeSpec.Builder addFieldWithIndex(TypeSpec.Builder builder) {
	}

	def compilePackageInterface(EPackage abstractSyntax, File directory) {

		val allClasses = abstractSyntax.allClasses

		val packageInterfaceType = ClassName.get(abstractSyntax.packageInterfacePackageName,
			abstractSyntax.packageInterfaceClassName)
		val packageImplementationType = ClassName.get(abstractSyntax.packageImplementationPackageName,
			abstractSyntax.packageImplementationClassName)

		val eInstanceField = FieldSpec.builder(packageInterfaceType, 'eINSTANCE').initializer('''$T.init()''',
			packageImplementationType).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build

		// TODO: really bad naming!
		val eNSURIField = FieldSpec.builder(String, 'eNS_URI').
			initializer('$S', '''http://«abstractSyntax.name».«abstractSyntax.name».«abstractSyntax.name»/''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build

		val eNameField = FieldSpec.builder(String, 'eNAME').initializer('$S', abstractSyntax.name).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build

		val eNSPrefixField = FieldSpec.builder(String, 'eNS_PREFIX').initializer('$S', abstractSyntax.name).addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build

		val classFields = newArrayList

		var cptr = 0;
		for (EClass clazz : allClasses) {
			classFields +=
				FieldSpec.builder(int, clazz.name.normalizeUpperField).initializer('''«cptr»''').addModifiers(
					Modifier.STATIC, Modifier.PUBLIC, Modifier.FINAL).build
			cptr = cptr + 1
		}

		val classFieldsLiterals = allClasses.map [ clazz |
			FieldSpec.builder(EClass, clazz.name.toUpperCase).
				initializer('''eINSTANCE.get«clazz.name.toFirstUpper»()''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build
		]

		val Iterable<FieldSpec> eReferenceFieldsLiterals = allClasses.map[clazz|clazz.EReferences.map[field|
			FieldSpec.builder(EReference, field.name.normalizeUpperField(clazz.name)).initializer('''eINSTANCE.get«field.name.normalizeUpperMethod(clazz.name)»()''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build
		]].flatten
		val Iterable<FieldSpec> eAttributeFieldsLiterals = allClasses.map[clazz|clazz.EAttributes.map[field|
			FieldSpec.builder(EAttribute, field.name.normalizeUpperField(clazz.name)).initializer('''eINSTANCE.get«field.name.normalizeUpperMethod(clazz.name)»()''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build
		]].flatten
		val literalType = TypeSpec.interfaceBuilder('Literals').addFields(classFieldsLiterals +
			eReferenceFieldsLiterals + eAttributeFieldsLiterals).addModifiers(Modifier.PUBLIC, Modifier.STATIC).build
			
		val getterFields = allClasses.map[clazz|
			MethodSpec.methodBuilder('''get«clazz.name.toFirstUpper»''').returns(EClass).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
		]
		
		val Iterable<MethodSpec> getterReferencesFields = allClasses.map[clazz|clazz.EReferences.map[field|
			MethodSpec.methodBuilder('''get«field.name.normalizeUpperMethod(clazz.name).toFirstUpper»''').returns(EReference).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
		]].flatten

		val Iterable<MethodSpec> getterAttributesFields = allClasses.map[clazz|clazz.EAttributes.map[field|
			MethodSpec.methodBuilder('''get«field.name.normalizeUpperMethod(clazz.name).toFirstUpper»''').returns(EAttribute).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build
		]].flatten
		
		val featureCountField = 
			FieldSpec.builder(int, '''«abstractSyntax.name.toUpperCase»_FEATURE_COUNT''').initializer('''0''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build
		
		val fieldsAttributesFields = newArrayList
		
		for(EClass clazz: allClasses) {
		var cptrI = 0
			for(EStructuralFeature esf: clazz.EReferences) {
				fieldsAttributesFields += FieldSpec.builder(int, esf.name.normalizeUpperField(clazz.name)).initializer('''«abstractSyntax.name.toUpperCase»_FEATURE_COUNT + «cptrI»''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build
				cptrI = cptrI + 1
			}
		
			for(EStructuralFeature esf: clazz.EAttributes) {
				fieldsAttributesFields += FieldSpec.builder(int, esf.name.normalizeUpperField(clazz.name)).initializer('''«abstractSyntax.name.toUpperCase»_FEATURE_COUNT + «cptrI»''').addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).build
				cptrI = cptrI + 1
			}
		}
		
		val package = TypeSpec.interfaceBuilder(abstractSyntax.packageInterfaceClassName).addSuperinterface(EPackage).
			addFields(#[eInstanceField, eNSURIField, eNameField, eNSPrefixField, featureCountField] + classFields +  fieldsAttributesFields
			).addMethods(getterFields + getterReferencesFields + getterAttributesFields).addType(literalType).addModifiers(Modifier.PUBLIC).
			build

		val javaFile = JavaFile.builder(abstractSyntax.packageInterfacePackageName, package).build

		javaFile.writeTo(directory)
	}
}
