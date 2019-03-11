package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.impl.EPackageImpl

import static javax.lang.model.element.Modifier.*

class PackageImplementationCompiler {

	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils

	def boolean isResolveProxiesFlag(EReference ref) {
		val eStructuralFeature = ref
		val isContainer = ref.EOpposite !== null && ref.EOpposite.containment
		val isContains = ref.isContainment
		return (!isContainer && !isContains) && eStructuralFeature instanceof EReference && ref.isResolveProxies;
	}

	def compilePackageImplementation(EPackage abstractSyntax, File directory, String packageRoot) {

		val allClasses = abstractSyntax.EClassifiers.filter(EClass)

		val isInitedField = FieldSpec.builder(boolean, 'isInited').addModifiers(PRIVATE, STATIC).
			initializer('''false''').build

		val isCreatedField = FieldSpec.builder(boolean, 'isCreated').addModifiers(PRIVATE).initializer('''false''').
			build
		val isInitializedField = FieldSpec.builder(boolean, 'isInitialized').addModifiers(PRIVATE).
			initializer('''false''').build

		val packageInterfaceType = ClassName.get(abstractSyntax.packageInterfacePackageName(packageRoot),
			abstractSyntax.packageInterfaceClassName)
		val packageInterfaceName = abstractSyntax.packageInterfaceClassName
		val factoryInterfaceType = ClassName.get(abstractSyntax.factoryInterfacePackageName(packageRoot),
			abstractSyntax.factoryInterfaceClassName)

		val test = '''«abstractSyntax.packageImplementationPackageName(packageRoot)».«abstractSyntax.packageImplementationClassName»'''

		val initMethod = MethodSpec.methodBuilder('init').addModifiers(PUBLIC, STATIC).returns(packageInterfaceType).
			addCode('''
				if (isInited)
					return ($1T) $2T.INSTANCE.getEPackage($1T.eNS_URI);
				
				// Obtain or create and register package
				Object registered«packageInterfaceName» = EPackage.Registry.INSTANCE.get(eNS_URI);
				«test» the«packageInterfaceName»;
				if(registered«packageInterfaceName» instanceof «test») {
					 the«packageInterfaceName» =  («test») registered«packageInterfaceName»;
				} else {
				 	the«packageInterfaceName» = new «test»();
				}
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
				if(isCreated)
					return;
				isCreated = true;
				
				«FOR eClass : allClasses»
					«eClass.name.toFirstLower»EClass = createEClass(«eClass.name.normalizeUpperField»);
					«FOR eAttr: eClass.EStructuralFeatures»
						«IF eAttr instanceof EReference»
							createEReference(«eClass.name.toFirstLower»EClass, «eAttr.name.normalizeUpperField(eClass.name)»);
						«ELSE»
							createEAttribute(«eClass.name.toFirstLower»EClass, «eAttr.name.normalizeUpperField(eClass.name)»);						
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			''').build

		val initializePackageContentsMethod = MethodSpec.methodBuilder('initializePackageContents').
			addModifiers(PUBLIC).addCode('''
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
				«FOR eClass : allClasses»
					initEClass(«eClass.name.toFirstLower»EClass, «eClass.classInterfacePackageName(packageRoot)».«eClass.name».class, "«eClass.name»", «IF eClass.isAbstract»«ELSE»!«ENDIF»IS_ABSTRACT, «IF eClass.isInterface»«ELSE»!«ENDIF»IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
					«FOR eAttr: eClass.EStructuralFeatures»
						«IF eAttr instanceof EReference»
							«IF eAttr.EType.EPackage != abstractSyntax»
								initEReference(get«eAttr.name.normalizeUpperMethod(eClass.name)»(), 
								((«eAttr.EType.EPackage.packageInterfacePackageName(packageRoot)».«eAttr.EType.EPackage.packageInterfaceClassName»)org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.getEPackage(«eAttr.EType.EPackage.packageInterfacePackageName(packageRoot)».«eAttr.EType.EPackage.packageInterfaceClassName».eNS_URI)).get«eAttr.EType.name»(), 
									«IF eAttr.EOpposite !== null»this.get«eAttr.EOpposite.name.normalizeUpperMethod((eAttr.EOpposite.eContainer as EClass).name)»()«ELSE»null«ENDIF», "«eAttr.name»", null, «eAttr.lowerBound», «eAttr.upperBound»,  «eClass.classInterfacePackageName(packageRoot)».«eClass.name».class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT, «IF eAttr.isVolatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.isChangeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.isContainment»«ELSE»!«ENDIF»IS_COMPOSITE, «IF eAttr.isResolveProxiesFlag»«ELSE»!«ENDIF»IS_RESOLVE_PROXIES, «IF eAttr.isUnsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);
							«ELSE»
								initEReference(get«eAttr.name.normalizeUpperMethod(eClass.name)»(), this.get«eAttr.EType.name»(),  
									«IF eAttr.EOpposite !== null»this.get«eAttr.EOpposite.name.normalizeUpperMethod((eAttr.EOpposite.eContainer as EClass).name)»()«ELSE»null«ENDIF», "«eAttr.name»", null, «eAttr.lowerBound», «eAttr.upperBound»,  «eClass.classInterfacePackageName(packageRoot)».«eClass.name».class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT, «IF eAttr.isVolatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.isChangeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.isContainment»«ELSE»!«ENDIF»IS_COMPOSITE, «IF eAttr.isResolveProxiesFlag»«ELSE»!«ENDIF»IS_RESOLVE_PROXIES, «IF eAttr.isUnsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);
							«ENDIF»				
						«ELSE»
							initEAttribute(get«eAttr.name.normalizeUpperMethod(eClass.name)»(), ecorePackage.get«IF !eAttr.EType.name.startsWith('E')»E«ENDIF»«eAttr.EType.name»(), "«eAttr.name»", null, «eAttr.lowerBound», «eAttr.upperBound»,  «eClass.classInterfacePackageName(packageRoot)».«eClass.name».class, «IF eAttr.isTransient»«ELSE»!«ENDIF»IS_TRANSIENT,«IF eAttr.volatile»«ELSE»!«ENDIF»IS_VOLATILE, «IF eAttr.changeable»«ELSE»!«ENDIF»IS_CHANGEABLE, «IF eAttr.unsettable»«ELSE»!«ENDIF»IS_UNSETTABLE, «IF (eAttr as EAttribute).isID»«ELSE»!«ENDIF»IS_ID, «IF eAttr.isUnique»«ELSE»!«ENDIF»IS_UNIQUE, «IF eAttr.isDerived»«ELSE»!«ENDIF»IS_DERIVED, «IF eAttr.isOrdered»«ELSE»!«ENDIF»IS_ORDERED);				
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
				// Create resource
				createResource(eNS_URI);
			''').build

		val classFields = allClasses.map [ clazz |
			FieldSpec.builder(EClass, '''«clazz.name.toFirstLower»EClass''').initializer('''null''').
				addModifiers(PRIVATE).build
		]

		val methodGetterFields = allClasses.map [ clazz |
			MethodSpec.methodBuilder('''get«clazz.name.toFirstUpper»''').returns(EClass).addModifiers(PUBLIC).
				addCode('''
					return «clazz.name.toFirstLower»EClass;
				''').build
		]

		val constructor = MethodSpec.constructorBuilder.addModifiers(PRIVATE).addCode('''
			super(eNS_URI, $T.eINSTANCE);
		''',
			ClassName.get(abstractSyntax.factoryInterfacePackageName(packageRoot),
				abstractSyntax.factoryInterfaceClassName)).build

		val accessorsMethods = newArrayList
		for (EClass clazz : allClasses) {
			var cptrI = 0

			for (field : clazz.EStructuralFeatures) {
				if (field instanceof EReference) {
					accessorsMethods +=
						MethodSpec.methodBuilder('''get«field.name.normalizeUpperMethod(clazz.name).toFirstUpper»''').
							returns(EReference).addCode('''
								return ($T) «clazz.name.toFirstLower»EClass.getEStructuralFeatures().get(«cptrI»);
							''', EReference).addModifiers(PUBLIC).build
				} else if (field instanceof EAttribute) {
					accessorsMethods +=
						MethodSpec.methodBuilder('''get«field.name.normalizeUpperMethod(clazz.name).toFirstUpper»''').
							returns(EAttribute).addCode('''
								return ($T) «clazz.name.toFirstLower»EClass.getEStructuralFeatures().get(«cptrI»);
							''', EAttribute).addModifiers(PUBLIC).build
				}
				cptrI = cptrI + 1

			}
		}

		val getFactoryMethod = MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Factory''').returns(
			factoryInterfaceType).addCode('''
			return ($T) getEFactoryInstance();
		''', factoryInterfaceType).addModifiers(PUBLIC).build

		val packageImpl = TypeSpec.classBuilder(abstractSyntax.packageImplementationClassName).superclass(EPackageImpl).
			addSuperinterface(
				ClassName.get(abstractSyntax.packageInterfacePackageName(packageRoot),
					abstractSyntax.packageInterfaceClassName)).addFields(
				#[isInitedField, isCreatedField, isInitializedField] + classFields).addMethods(
				#[initMethod, createPackageContentsMethod, initializePackageContentsMethod, constructor,
					getFactoryMethod] + methodGetterFields + accessorsMethods).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.packageImplementationPackageName(packageRoot), packageImpl)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
}
