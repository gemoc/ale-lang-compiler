package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.HashMap
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference

import static javax.lang.model.element.Modifier.*

class PackageInterfaceCompiler {

	extension GenmodelNamingUtils namingUtils

	new(GenmodelNamingUtils namingUtils) {
		this.namingUtils = namingUtils
	}
	
	def Iterable<EClass> getOrderedClasses(Iterable<EClass> classes, EPackage ePackage) {
		val List<EClass> result = newArrayList
		val Set<EClass> resultSet = newHashSet

		val iter = classes.iterator
		while (iter.hasNext) {
			val List<EClass> extendChain = newLinkedList
			val Set<EClass> visited = newHashSet
			var genClass = iter.next
			while (genClass !== null && visited.add(genClass)) {

				if (ePackage == genClass.EPackage && resultSet.add(genClass)) {
					extendChain.add(0, genClass)
				}
				genClass = genClass.ESuperTypes.head
			}
			result.addAll(extendChain)
		}
		result
	}
	
	def  getOrderedClassifiers(EPackage ePackage) {
		val packageClasses = ePackage.EClassifiers.filter(EClass).getOrderedClasses(ePackage)
		val packageEnums = ePackage.EClassifiers.filter(EEnum)
		val packageEDT = ePackage.EClassifiers.filter(EDataType)
		packageClasses + packageEnums + packageEDT
	}

	def compilePackageInterface(EPackage abstractSyntax, File directory, String packageRoot) {

		val allClasses = abstractSyntax.EClassifiers.filter(EClass).getOrderedClasses(abstractSyntax)
		val allEnums = abstractSyntax.EClassifiers.filter(EEnum)

		val packageInterfaceType = abstractSyntax.packageIntClassName(packageRoot) 
		
		val packageImplementationType = ClassName.get(abstractSyntax.packageImplementationPackageName(packageRoot),
			abstractSyntax.packageImplementationClassName)

		val factoryInterfaceType = abstractSyntax.factoryIntClassName(packageRoot) 
		
		val eInstanceField = FieldSpec.builder(packageInterfaceType, 'eINSTANCE').initializer('''$T.init()''',
			packageImplementationType).addModifiers(PUBLIC, STATIC, FINAL).build

		val eNSURIField = FieldSpec.builder(String, 'eNS_URI').
			initializer('$S', '''http://«abstractSyntax.name».«abstractSyntax.name».«abstractSyntax.name»/''').
			addModifiers(PUBLIC, STATIC, FINAL).build

		val eNameField = FieldSpec.builder(String, 'eNAME').initializer('$S', abstractSyntax.name).addModifiers(PUBLIC,
			STATIC, FINAL).build

		val eNSPrefixField = FieldSpec.builder(String, 'eNS_PREFIX').initializer('$S', abstractSyntax.name).
			addModifiers(PUBLIC, STATIC, FINAL).build

		val classFields = newHashMap

		var cptr = 0;
		for (EClass clazz : allClasses) {
			classFields.put(clazz,
				FieldSpec.builder(int, clazz.name.normalizeUpperField).initializer('''«cptr»''').addModifiers(STATIC,
					PUBLIC, FINAL).build)
			cptr = cptr + 1
		}

		for (EEnum eEnum : allEnums) {
			classFields.put(eEnum,
				FieldSpec.builder(int, eEnum.name.normalizeUpperField).initializer('''«cptr»''').addModifiers(STATIC,
					PUBLIC, FINAL).build)
			cptr = cptr + 1
		}

		val classFieldsLiterals = newHashMap
		val HashMap<EClassifier, HashMap<ENamedElement, FieldSpec>> classStructuralFeaturesLiterals = newHashMap
		for (clazz : allClasses) {
			classFieldsLiterals.put(clazz,
				FieldSpec.builder(EClass, clazz.name.normalizeUpperField).
					initializer('''eINSTANCE.get«clazz.name.toFirstUpper»()''').addModifiers(PUBLIC, STATIC, FINAL).
					build)

			if(!classStructuralFeaturesLiterals.containsKey(clazz)) classStructuralFeaturesLiterals.put(clazz,
				newHashMap)
			for (field : clazz.EReferences) {
				classStructuralFeaturesLiterals.get(clazz).put(field,
					FieldSpec.builder(EReference, field.name.normalizeUpperField(clazz.name)).
						initializer('''eINSTANCE.get«clazz.name»_«field.name.toFirstUpper»()''').addModifiers(PUBLIC,
							STATIC, FINAL).build)
			}

			for (field : clazz.EAllAttributes) {
				classStructuralFeaturesLiterals.get(clazz).put(field,
					FieldSpec.builder(EAttribute, field.name.normalizeUpperField(clazz.name)).
						initializer('''eINSTANCE.get«clazz.name»_«field.name.toFirstUpper»()''').addModifiers(PUBLIC,
							STATIC, FINAL).build)
			}
		}

		for (EEnum eEnum : allEnums) {
			classFieldsLiterals.put(eEnum,
				FieldSpec.builder(EEnum, eEnum.name.toUpperCase).
					initializer('''eINSTANCE.get«eEnum.name.toFirstUpper»()''').addModifiers(PUBLIC, STATIC, FINAL).
					build)
		}

		var tmpliteralType = TypeSpec.interfaceBuilder('Literals')

		for (clazz : abstractSyntax.orderedClassifiers) {
			if (clazz instanceof EClass) {
				tmpliteralType = tmpliteralType.addField(classFieldsLiterals.get(clazz))
				for (esf : clazz.EStructuralFeatures) {
					tmpliteralType = tmpliteralType.addField(classStructuralFeaturesLiterals.get(clazz).get(esf))
				}
			} else if (clazz instanceof EEnum) {
				tmpliteralType = tmpliteralType.addField(classFieldsLiterals.get(clazz))
			}
		}

		val literalType = tmpliteralType.addModifiers(PUBLIC, STATIC).build

		val getterFields = newHashMap
		val getterReferencesFields = newHashMap

		for (clazz : allClasses) {
			getterFields.put(clazz,
				MethodSpec.methodBuilder('''get«clazz.name.toFirstUpper»''').returns(EClass).addModifiers(ABSTRACT,
					PUBLIC).build)

			if(!getterReferencesFields.containsKey(clazz)) getterReferencesFields.put(clazz, newHashMap)
			for (field : clazz.EReferences) {
				getterReferencesFields.get(clazz).put(field,
					MethodSpec.methodBuilder('''get«clazz.name»_«field.name.toFirstUpper»''').returns(EReference).
						addModifiers(ABSTRACT, PUBLIC).build)
			}

			for (field : clazz.EAttributes) {
				getterReferencesFields.get(clazz).put(field,
					MethodSpec.methodBuilder('''get«clazz.name»_«field.name.toFirstUpper»''').returns(EAttribute).
						addModifiers(ABSTRACT, PUBLIC).build)
			}
		}

		for (eEnum : allEnums) {
			getterFields.put(eEnum,
				MethodSpec.methodBuilder('''get«eEnum.name.toFirstUpper»''').returns(EEnum).addModifiers(ABSTRACT,
					PUBLIC).build)
		}

		val fieldsAttributesFields = newHashMap

		for (EClass clazz : allClasses) {

			if(!fieldsAttributesFields.containsKey(clazz)) fieldsAttributesFields.put(clazz, newArrayList)
			var cptrI = 0
			val offset = countOffset(clazz)

			for (esf : clazz.EAllStructuralFeatures) {
				if (esf.EContainingClass === clazz) {
					fieldsAttributesFields.get(clazz).add(
						FieldSpec.builder(int, esf.name.normalizeUpperField(clazz.name)).
							initializer('''«cptrI+offset»''').addModifiers(PUBLIC, STATIC, FINAL).build // «FOR parentClazz: esf.EContainingClass.ESuperTypes»«parentClazz.name.normalizeUpperField»_FEATURE_COUNT + «ENDFOR»
					)
					cptrI = cptrI + 1
				} else {
					fieldsAttributesFields.get(clazz).add(
						FieldSpec.builder(int, esf.name.normalizeUpperField(clazz.name)).
							initializer('''«esf.name.normalizeUpperField(esf.EContainingClass.name)»''').
							addModifiers(PUBLIC, STATIC, FINAL).build
					)
				}
			}
		}

		val getFactoryMethod = MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Factory''').returns(
			factoryInterfaceType).addModifiers(PUBLIC, ABSTRACT).build

		var packageTmp = TypeSpec.interfaceBuilder(abstractSyntax.packageInterfaceClassName).
			addSuperinterface(EPackage).addField(eNameField).addField(eNSURIField).addField(eNSPrefixField).addField(
				eInstanceField)

		for (eClassifier : abstractSyntax.orderedClassifiers) {
			if (classFields.containsKey(eClassifier)) {
				packageTmp = packageTmp.addField(classFields.get(eClassifier))
			}

			if (fieldsAttributesFields.containsKey(eClassifier))
				packageTmp = packageTmp.addFields(fieldsAttributesFields.get(eClassifier))

			if (eClassifier instanceof EClass) {
				packageTmp = packageTmp.addField(
					FieldSpec.builder(int, '''«eClassifier.name.normalizeUpperField»_FEATURE_COUNT''', PUBLIC, STATIC,
						FINAL).
						initializer('''«FOR parentClazz : eClassifier.ESuperTypes»«parentClazz.name.normalizeUpperField»_FEATURE_COUNT + «ENDFOR»«eClassifier.EStructuralFeatures.size»''').
						build
				)
				packageTmp = packageTmp.addField(
					FieldSpec.builder(int, '''«eClassifier.name.normalizeUpperField»_OPERATION_COUNT''', PUBLIC, STATIC,
						FINAL).
						initializer('''«FOR parentClazz : eClassifier.ESuperTypes»«parentClazz.name.normalizeUpperField»_OPERATION_COUNT + «ENDFOR»0''').
						build
				)
			}
		}

		for (eClassifier : abstractSyntax.EClassifiers) {
			if (getterFields.containsKey(eClassifier)) {
				packageTmp = packageTmp.addMethod(getterFields.get(eClassifier))
				if (eClassifier instanceof EClass) {
					for (esf : eClassifier.EStructuralFeatures) {
						packageTmp = packageTmp.addMethod(getterReferencesFields.get(eClassifier).get(esf))
					}
				}
			} else {
				println('''«eClassifier» field generation not handled.''')
			}
		}

		val package = packageTmp.addMethod(getFactoryMethod).addType(literalType).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.packageInterfacePackageName(packageRoot), package).indent('\t').
			build

		javaFile.writeTo(directory)
	}

	def int countOffset(EClass clazz) {
		clazz.EAllSuperTypes.map[it.EStructuralFeatures.size].fold(0, [l, r|l + r])
	}
}
