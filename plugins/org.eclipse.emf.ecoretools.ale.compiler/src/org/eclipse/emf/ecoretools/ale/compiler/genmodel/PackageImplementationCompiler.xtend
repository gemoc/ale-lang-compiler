package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.List
import java.util.Locale
import java.util.Map
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.impl.EPackageImpl
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class PackageImplementationCompiler {
	protected extension EcoreGenNamingUtils namingUtils
	val Dsl dsl
	extension CompilerDsl compilerDsl = new CompilerDsl

	new(EcoreGenNamingUtils namingUtils, Dsl dsl) {
		this.namingUtils = namingUtils
		this.dsl = dsl
	}
	
	def boolean isResolveProxiesFlag(EReference ref) {
		val eStructuralFeature = ref
		val isContainer = ref.EOpposite !== null && ref.EOpposite.containment
		val isContains = ref.isContainment
		return (!isContainer && !isContains) && eStructuralFeature instanceof EReference && ref.isResolveProxies;
	}
	
	def toFieldName(String name) {
		CodeGenUtil.uncapPrefixedName(name, false, Locale.^default)
	}

	def compilePackageImplementation(EPackage abstractSyntax, File directory, String packageRoot) {

		val allClasses = abstractSyntax.EClassifiers.filter(EClass)
		val allEnums = abstractSyntax.EClassifiers.filter(EEnum)

		val isInitedField = FieldSpec.builder(boolean, 'isInited').addModifiers(PRIVATE, STATIC).
			initializer('''false''').build

		val isCreatedField = FieldSpec.builder(boolean, 'isCreated').addModifiers(PRIVATE).initializer('''false''').
			build
		val isInitializedField = FieldSpec.builder(boolean, 'isInitialized').addModifiers(PRIVATE).
			initializer('''false''').build

		val packageInterfaceType = abstractSyntax.packageIntClassName(packageRoot) 
		
		val packageInterfaceName = abstractSyntax.packageInterfaceClassName
		val factoryInterfaceType = abstractSyntax.factoryIntClassName(packageRoot) 

		val test = '''«abstractSyntax.packageImplementationClassName»'''

		val initMethod = MethodSpec.methodBuilder('init')
			.addModifiers(PUBLIC, STATIC)
			.returns(packageInterfaceType)
			.addCode('''
				if (isInited)
					return ($1T) $2T.INSTANCE.getEPackage($1T.eNS_URI);
				
				// Obtain or create and register package
				Object registered«packageInterfaceName» = EPackage.Registry.INSTANCE.get(eNS_URI);
				«test» the«packageInterfaceName» = registered«packageInterfaceName» instanceof «test»
						? («test») registered«packageInterfaceName»
						: new «test»();

				isInited = true;
				
				// Create package meta-data objects
				the«packageInterfaceName».createPackageContents();
				
				// Initialize created meta-data
				the«packageInterfaceName».initializePackageContents();
				
				// Mark meta-data to indicate it can't be changed
				the«packageInterfaceName».freeze();
				
				// Update the registry and return the package
				$2T.INSTANCE.put($1T.eNS_URI, the«packageInterfaceName»);
				return the«packageInterfaceName»;
			''', packageInterfaceType, EPackage.Registry).build

		val createPackageContentsMethod = MethodSpec.methodBuilder('createPackageContents').addModifiers(PUBLIC).
			addCode('''
				if (isCreated)
					return;
				isCreated = true;
				
				// Create classes and their features
				«FOR eClass : allClasses SEPARATOR '\n'»
					«eClass.name.toFieldName»EClass = createEClass(«eClass.name.normalizeUpperField»);
					«FOR eAttr: eClass.EStructuralFeatures»
						«IF eAttr instanceof EReference»
							createEReference(«eClass.name.toFieldName»EClass, «eAttr.normalizeUpperField»);
						«ELSE»
							createEAttribute(«eClass.name.toFieldName»EClass, «eAttr.normalizeUpperField»);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
				«IF !allEnums.empty»

				// Create enums
				«FOR eEnum : allEnums»
					«eEnum.name.toFieldName»EEnum = createEEnum(«eEnum.name.normalizeUpperField»);
				«ENDFOR»
				«ENDIF»
			''').build
			
		val hm = newHashMap()
		
		for(eClass: allClasses) {
			val t =  if(eClass.instanceClassName != "java.util.Map$Entry")
			(if (dsl.truffle) 
					ClassName.get(eClass.classImplementationPackageName(packageRoot), eClass.name+'Impl') 
				else 
					ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.name)
			)
				 
				else ClassName.get("java.util.Map", "Entry")
			hm.put('''type«eClass.name»'''.toString, t)
		}
		
		for(eEnum: allEnums) {
			hm.put('''type«eEnum.name»'''.toString, 
				ClassName.get(eEnum.classInterfacePackageName(packageRoot), eEnum.name)
			)
		}

		val initializePackageContentsMethod = MethodSpec.methodBuilder('initializePackageContents').
			addModifiers(PUBLIC).addNamedCode('''
				if (isInitialized)
					return;
				isInitialized = true;
				
				// Initialize package
				setName(eNAME);
				setNsPrefix(eNS_PREFIX);
				setNsURI(eNS_URI);
				
				// Create type parameters
				
				// Set bounds for type parameters
				
				// Add supertypes to classes
				«FOR eClass : allClasses»
					«FOR esp: eClass.ESuperTypes»
						«eClass.name.toFirstLower»EClass.getESuperTypes().add(this.get«esp.name»());
					«ENDFOR»
				«ENDFOR»
				
				// Initialize classes, features, and operations; add parameters
				«FOR eClass : allClasses SEPARATOR '\n'»
					initEClass(«eClass.name.toFieldName»EClass, $type«eClass.name»:T.class, "«eClass.name»", «IF eClass.isAbstract»«ELSE»!«ENDIF»IS_ABSTRACT, «IF eClass.isInterface»«ELSE»!«ENDIF»IS_INTERFACE, «IF eClass.instanceClassName == "java.util.Map$Entry"»!«ENDIF»IS_GENERATED_INSTANCE_CLASS);
					«FOR eAttr: eClass.EStructuralFeatures»
						«IF eAttr instanceof EReference»
							«IF eAttr.EType.EPackage != abstractSyntax»
								initEReference(get«eClass.name»_«eAttr.name.toFirstUpper»(), ((«eAttr.EType.EPackage.packageInterfacePackageName(packageRoot)».«eAttr.EType.EPackage.packageInterfaceClassName»)org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.getEPackage(«eAttr.EType.EPackage.packageInterfacePackageName(packageRoot)».«eAttr.EType.EPackage.packageInterfaceClassName».eNS_URI)).get«eAttr.EType.name»(), «IF eAttr.EOpposite !== null»this.get«eAttr.EOpposite.name.normalizeUpperMethod((eAttr.EOpposite.eContainer as EClass).name)»()«ELSE»null«ENDIF», "«eAttr.name»", null, «eAttr.lowerBound», «eAttr.upperBound», $type«eClass.name»:T.class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT, «IF eAttr.isVolatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.isChangeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.isContainment»«ELSE»!«ENDIF»IS_COMPOSITE, «IF eAttr.isResolveProxiesFlag»«ELSE»!«ENDIF»IS_RESOLVE_PROXIES, «IF eAttr.isUnsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);
							«ELSE»
								initEReference(get«eClass.name»_«eAttr.name.toFirstUpper»(), this.get«eAttr.EType.name»(), «IF eAttr.EOpposite !== null»this.get«eAttr.EOpposite.name.normalizeUpperMethod((eAttr.EOpposite.eContainer as EClass).name)»()«ELSE»null«ENDIF», "«eAttr.name»", null, «eAttr.lowerBound», «eAttr.upperBound», $type«eClass.name»:T.class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT, «IF eAttr.isVolatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.isChangeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.isContainment»«ELSE»!«ENDIF»IS_COMPOSITE, «IF eAttr.isResolveProxiesFlag»«ELSE»!«ENDIF»IS_RESOLVE_PROXIES, «IF eAttr.isUnsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);
							«ENDIF»				
						«ELSEIF eAttr.EType instanceof EEnum»
							initEAttribute(get«eAttr.name.normalizeUpperMethod(eClass.name)»(), this.get«eAttr.EType.name.toFirstUpper»(), "«eAttr.name»", «IF eAttr.defaultValueLiteral === null»null«ELSE»"«eAttr.defaultValue»"«ENDIF», «eAttr.lowerBound», «eAttr.upperBound», $type«eClass.name»:T.class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT, «IF eAttr.volatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.changeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.unsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF (eAttr as EAttribute).isID»«ELSE»!«ENDIF»IS_ID, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);
						«ELSE»
							initEAttribute(get«eAttr.name.normalizeUpperMethod(eClass.name)»(), ecorePackage.get«IF !eAttr.EType.name.startsWith('E')»E«ENDIF»«eAttr.EType.name»(), "«eAttr.name»", «IF eAttr.defaultValueLiteral === null»null«ELSE»"«eAttr.defaultValue»"«ENDIF», «eAttr.lowerBound», «eAttr.upperBound», $type«eClass.name»:T.class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT, «IF eAttr.volatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.changeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.unsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF (eAttr as EAttribute).isID»«ELSE»!«ENDIF»IS_ID, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
				«IF !allEnums.empty»
				
				// Initialize enums and add enum literals
				«FOR eEnum: allEnums»
				initEEnum(«eEnum.name.toFieldName»EEnum, $type«eEnum.name»:T.class, "«eEnum.name»");
				«FOR lit: eEnum.ELiterals»
				addEEnumLiteral(«eEnum.name.toFieldName»EEnum, $type«eEnum.name»:T.«lit.name»);
				«ENDFOR»
				«ENDFOR»
				«ENDIF»

				// Create resource
				createResource(eNS_URI);
			''', hm).build

		val eClassifiers = abstractSyntax.EClassifiers.map[eClassifier |
			if(eClassifier instanceof EClass) {
				FieldSpec.builder(EClass, '''«eClassifier.name.toFieldName»EClass''').initializer('''null''').
				addModifiers(PRIVATE).build
			} else {
				FieldSpec.builder(EEnum, '''«eClassifier.name.toFieldName»EEnum''').initializer('''null''').
				addModifiers(PRIVATE).build
			}
		]

		val  eClassifierGetterMethods = abstractSyntax.EClassifiers.map[eClassifier| 
			if(eClassifier instanceof EClass) {
				eClassifier -> MethodSpec.methodBuilder('''get«eClassifier.name.toFirstUpper»''').returns(EClass).addModifiers(PUBLIC).
				addCode('''
					return «eClassifier.name.toFieldName»EClass;
				''').build
			} else {
				eClassifier -> MethodSpec.methodBuilder('''get«eClassifier.name.toFirstUpper»''').returns(EEnum).addModifiers(PUBLIC).
				addCode('''
					return «eClassifier.name.toFieldName»EEnum;
				''').build	
			}
		]

		val constructor = MethodSpec.constructorBuilder.addModifiers(PRIVATE).addCode('''
			super(eNS_URI, $T.eINSTANCE);
		''', abstractSyntax.factoryIntClassName(packageRoot)).build

		val Map<EClass, List<MethodSpec>> accessorsMethods = newHashMap
		for (EClass clazz : allClasses) {
			var cptrI = 0

			for (field : clazz.EStructuralFeatures) {
				
				if(!accessorsMethods.containsKey(clazz)) accessorsMethods.put(clazz, newArrayList())
				if (field instanceof EReference) {
					accessorsMethods.get(clazz).add(
						MethodSpec.methodBuilder('''get«clazz.name»_«field.name.toFirstUpper»''').
							returns(EReference).addCode('''
								return ($T) «clazz.name.toFieldName»EClass.getEStructuralFeatures().get(«cptrI»);
							''', EReference).addModifiers(PUBLIC).build)
				} else if (field instanceof EAttribute) {
					accessorsMethods.get(clazz).add(
						MethodSpec.methodBuilder('''get«field.name.normalizeUpperMethod(clazz.name).toFirstUpper»''').
							returns(EAttribute).addCode('''
								return ($T) «clazz.name.toFieldName»EClass.getEStructuralFeatures().get(«cptrI»);
							''', EAttribute).addModifiers(PUBLIC).build)
				}
				cptrI = cptrI + 1

			}
		}

		val getFactoryMethod = MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Factory''').returns(
			factoryInterfaceType).addCode('''
			return ($T) getEFactoryInstance();
		''', factoryInterfaceType).addModifiers(PUBLIC).build

		var packageImplTmp = TypeSpec
			.classBuilder(abstractSyntax.packageImplementationClassName)
			.superclass(EPackageImpl)
			.addSuperinterface(ClassName.get(abstractSyntax.packageInterfacePackageName(packageRoot), abstractSyntax.packageInterfaceClassName))
			.addField(isInitedField)
			.addFields(eClassifiers)
			.addFields(#[isCreatedField, isInitializedField])
			.addMethod(constructor)
			.addMethod(initMethod)
			
		for(mgf: eClassifierGetterMethods) {
			packageImplTmp = packageImplTmp.addMethod(mgf.value)
			if(accessorsMethods.containsKey(mgf.key))
				packageImplTmp = packageImplTmp.addMethods(accessorsMethods.get(mgf.key))
		}
			
		val packageImpl = packageImplTmp
			.addMethods(#[getFactoryMethod, createPackageContentsMethod, initializePackageContentsMethod])
			.addModifiers(PUBLIC)
			.build

		val javaFile = JavaFile.builder(abstractSyntax.packageImplementationPackageName(packageRoot), packageImpl)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
}
