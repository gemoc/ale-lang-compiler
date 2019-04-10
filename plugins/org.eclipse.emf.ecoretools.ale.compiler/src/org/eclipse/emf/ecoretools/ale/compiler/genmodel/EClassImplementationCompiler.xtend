package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import com.squareup.javapoet.WildcardTypeName
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.Optional
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.common.util.BasicEMap
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecore.util.InternalEList
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.xtext.xbase.lib.Functions.Function2

import static javax.lang.model.element.Modifier.*
import org.eclipse.xtext.xbase.lib.Functions.Function1

class EClassImplementationCompiler {

	extension CommonCompilerUtils ccu
	extension GenmodelNamingUtils anu
	extension JavaPoetUtils jpu
	val EClassGetterCompiler eClassGetterCompiler
	val List<ResolvedClass> resolved

	new(CommonCompilerUtils ccu, GenmodelNamingUtils anu, EClassGetterCompiler eClassGetterCompiler,
		JavaPoetUtils jpu, List<ResolvedClass> resolved) {
		this.ccu = ccu
		this.anu = anu
		this.eClassGetterCompiler = eClassGetterCompiler
		this.jpu = jpu
		this.resolved = resolved
	}
	
	def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass,  String packageRoot, Dsl dsl) {
		this.compileEcoreRelated(builder, eClass, null, packageRoot, dsl, null)
	}
	
	def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass, ExtendedClass aleClass, String packageRoot, Dsl dsl, Function2<FieldSpec.Builder, EReference, FieldSpec.Builder> f2) {
		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
		val ePackageInterfaceType = eClass.packageIntClassName(packageRoot) 
		
		val hasSuperType = !eClass.ESuperTypes.empty
		val superType = eClass.ESuperTypes.head

		val fieldsEAttributes = this.getFieldsEAttributes(eClass, packageRoot)
		val fieldsEReferences = this.getFieldsEReferences(eClass, packageRoot, f2)
		val methodsEReferences = this.getMethodsEReferences(eClass, packageRoot, dsl, ePackageInterfaceType, isMapElement)

		val eStaticClassMethod = this.getEStaticClass(eClass, dsl, packageRoot)
		val eSetMethod = this.getESet(eClass, dsl, packageRoot)
		val eUnsetMethod = this.getEUnset(eClass, dsl, packageRoot)
		val eGetMethod = this.getEGet(eClass, dsl, packageRoot, isMapElement)
		val eIsSetMethod = this.getEIsSet(eClass, dsl, packageRoot)
		val eInverseRemove = this.getEInverseRemove(eClass, dsl, packageRoot, isMapElement)
		val eBasicRemoveFromContainerFeature = this.getEBasicRemoveFromContainerFeature(eClass, dsl, packageRoot)
		val eInverseAdd = this.getEInverseAdd(eClass, dsl, packageRoot, isMapElement)
		val eMethods = #[eInverseAdd, eInverseRemove, eBasicRemoveFromContainerFeature, eGetMethod, eSetMethod, eUnsetMethod, eIsSetMethod]
			.map[it.map[#[it]].orElse(#[])].flatten
		val eMapMethods = this.getEMapMethods(eClass, dsl, packageRoot)

		val key = eClass.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
		val value = eClass.eContents.filter(EStructuralFeature).filter[it.name == "value"].head

		builder.applyIfTrue(eClass.isAbstract, [addModifiers(ABSTRACT)]).applyIfTrue(hasSuperType, [
			superclass(
				ClassName.get(superType.classImplementationPackageName(packageRoot),
					superType.classImplementationClassName))
		]).applyIfTrue(isMapElement, [
			it.addSuperinterface(
				ParameterizedTypeName.get(ClassName.get(BasicEMap.Entry),
					key.resolveFieldType(packageRoot).box,
					value.resolveFieldType(packageRoot).box))
		])
		.applyIfTrue(!hasSuperType, [
			if (dsl.dslProp.getOrDefault("truffle", "false") == 'true') {
				if (!eClass.EAnnotations.exists[it.source == 'RuntimeData']) {
					superclass(ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.truffle", "MinimalTruffleEObjectImpl", "TruffleContainer"))
				} else {
					superclass(ClassName.get(MinimalEObjectImpl.Container))
				}
			} else {
				superclass(ClassName.get(MinimalEObjectImpl.Container))
			}
		])
		.applyIfTrue(!isMapElement, [
			addSuperinterface(
				ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName))
		])
		.addFields(fieldsEAttributes)
		.addFields(fieldsEReferences)
		.addMethod(eStaticClassMethod)
		.addMethods(methodsEReferences)
	 	.addMethods(eMethods)
		.applyIfTrue(isMapElement, [it.addField(FieldSpec.builder(int, 'hash', PROTECTED).initializer('-1').build) ])
	 	.addMethods(eMapMethods)
	}
	
	def getEMapMethods(EClass eClass, Dsl dsl, String packageRoot) {
		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry

		if (!isMapElement) {
			#[]
		} else {
			val setHash = MethodSpec.methodBuilder('setHash')
				.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
					addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
				])
				.addParameter(int, 'hash')
				.addCode('''
				this.hash = hash;
				''')
				.addModifiers(PUBLIC)
				.build
			val getHash = MethodSpec.methodBuilder('getHash').applyIfTrue(dsl.dslProp.getProperty('truffle', "false") ==
				"true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).returns(int).addCode('''
				if (hash == -1) {
					Object theKey = getKey();
					hash = (theKey == null ? 0 : theKey.hashCode());
				}
				return hash;
			''').addModifiers(PUBLIC).build
			
			val keyField = eClass.EStructuralFeatures.filter[it.name == 'key'].head
			val valueField = eClass.EStructuralFeatures.filter[it.name == 'value'].head
			
			val krt = keyField.resolveFieldType(packageRoot)
			val vrt = valueField.resolveFieldType(packageRoot)
			
			val keyGetter = MethodSpec.methodBuilder('''getKey''')
				.returns(krt)
				.addCode('''
				return getTypedKey();
				''')
				.addModifiers(PUBLIC).build
				
			val isMultipleKey = keyField.upperBound > 1 || keyField.upperBound < 0
			val isMultipleValue = valueField.upperBound > 1 || valueField.upperBound < 0

			val keySetter = MethodSpec.methodBuilder('''setKey''')
			.addParameter(krt, '''key''')
			.addModifiers(PUBLIC)
			.addCode('''
			«IF isMultipleKey»
			getTypedKey().addAll(key);
			«ELSE»
			setTypedKey(key);
			«ENDIF»
			''')
			.build
			val valueGetter = MethodSpec.methodBuilder('''getValue''')
				.returns(vrt)
				.addCode('''
				return getTypedValue();
				''')
				.addModifiers(PUBLIC).build
			val valueSetter = MethodSpec.methodBuilder('''setValue''')
			.addParameter(vrt, '''value''')
			.returns(vrt)
			.addModifiers(PUBLIC)
			.addNamedCode('''
			$rt:T oldValue = getValue();
			«IF isMultipleValue»
			getTypedValue().clear();
			getTypedValue().addAll(value);
			«ELSE»
			setTypedValue(value);
			«ENDIF»
			return oldValue;
			''', newHashMap(
				"rt" -> vrt
			))
			.build
			val eMapRt = ParameterizedTypeName.get(ClassName.get(EMap), krt.box, vrt.box)
			val eMapGetter = MethodSpec.methodBuilder('''getEMap''')
			.returns(eMapRt)
			.addModifiers(PUBLIC)
			.addNamedCode('''
			$eo:T container = eContainer();
			return container == null ? null : ($rt:T)container.eGet(eContainmentFeature());
			''', newHashMap(
				"eo" -> ClassName.get(EObject),
				"rt" ->eMapRt 			
			))
			.build
			#[getHash, setHash, keyGetter, keySetter, valueGetter, valueSetter, eMapGetter]
		}
	}
	def fieldSetter(EStructuralFeature esf, String packageRoot) {
		val ekrt = esf.EGenericType.ERawType
		val vrt = ekrt.scopedInterfaceTypeRef(packageRoot)
		if(esf instanceof EReference) {
			MethodSpec.methodBuilder('''set«esf.name.toFirstUpper»''')
			.addParameter(vrt, '''«esf.name.normalizeVarName»''')
			.returns(vrt)
			.addModifiers(PUBLIC)
			.addNamedCode('''
			$rt:T $oldName:L = get$name:L();
			setTyped$name:L($ename:L);
			return $oldName:L;
			''', newHashMap(
				"rt" -> vrt,
				"oldName" -> esf.name.normalizeVarOldName,
				"name" -> esf.name.toFirstUpper,
				"ename" -> esf.name.normalizeVarName
			))
			.build
		} else if(esf instanceof EAttribute) {
			MethodSpec.methodBuilder('''set«esf.name.toFirstUpper»''')
			.addParameter(vrt, '''«esf.name.normalizeVarName»''')
			.addModifiers(PUBLIC)
			.addNamedCode('''
			setTyped$name:L($ename:L);
			''', newHashMap(
				"name" -> esf.name.toFirstUpper,
				"ename" -> esf.name.normalizeVarName
			))
			.build
		}
		
	}
	
	def boolean isResolveProxies(EStructuralFeature eStructuralFeature) {
		if (eStructuralFeature instanceof EReference) {
			val isContainer = eStructuralFeature.isContainer
			val isContains = eStructuralFeature.isContainment
			!isContainer && !isContains && eStructuralFeature.isResolveProxies
		} else {
			false
		}
	}
	
	def boolean isListType(ETypedElement eTypedElement) {
		eTypedElement !== null &&
			(eTypedElement.isMany() ||
				((eTypedElement instanceof EClass) &&
					(eTypedElement as EClass).instanceClassName == "java.util.Map$Entry"))
	}
	
	private def produceFeatureSwitchMap(EClass eClass, String packageRoot) {
		val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)
		
		val Function1<TypeName, TypeName> f = [ TypeName p |
				ParameterizedTypeName.get(ClassName.get(Collection), WildcardTypeName.subtypeOf(p.box))
			]
		
		val Map<String, TypeName> namedMap = newHashMap(
			"epit" -> ePackageInterfaceType,
			"esf" -> ClassName.get(EStructuralFeature.Setting)
		)
		for (esf : eClass.EStructuralFeatures) {
			val tnp = esf.computeFieldTypeEClass(packageRoot, f).box
			val tn = if(tnp instanceof ParameterizedTypeName) tnp.typeArguments.head else tnp
			namedMap.put("fieldtype" + esf.name, tn)
			namedMap.put("collection" + esf.name, tnp)
		}
		return namedMap
	}
	
	def getEInverseAdd(EClass eClass, Dsl dsl, String packageRoot, boolean isTyped) {
		if (!eClass.EReferences.filter[it.EOpposite !== null].empty) {

			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)

			val hm = newHashMap("nc" -> NotificationChain, "epit" -> ePackageInterfaceType,
				"eil" -> ParameterizedTypeName.get(ClassName.get(InternalEList), ClassName.get(InternalEObject)),
				"eilg" ->
					ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
				"ieo" -> TypeName.get(InternalEObject))

			for (ref : eClass.EReferences.filter[it.EOpposite !== null]) {
				hm.put('''«ref.name»eOppositeType'''.toString, ref.computeFieldTypeEClass(packageRoot))
			}

			val ret = MethodSpec.methodBuilder('eInverseAdd').addAnnotation(Override).returns(NotificationChain).
					applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addParameter(InternalEObject, 'otherEnd').addParameter(int, 'featureID').addParameter(
						NotificationChain, 'msgs').addNamedCode('''
						switch (featureID) {
							«FOR ref : eClass.EReferences.filter[it.EOpposite !== null]»
								case $epit:T.«ref.normalizeUpperField» :
									«IF ref.upperBound == 0 || ref.upperBound == 1»
										«IF ref.EOpposite !== null && ref.EOpposite.containment»
											if (eInternalContainer() != null)
												msgs = eBasicRemoveFromContainer(msgs);
											return basicSet«IF isTyped»Typed«ENDIF»«ref.name.toFirstUpper»(($«ref.name»eOppositeType:T) otherEnd, msgs);
										«ELSEIF ref.EOpposite !== null && ref.containment»
											if («ref.name» != null)
												msgs = (($ieo:T) «ref.name»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $epit:T.«ref.normalizeUpperField», null, msgs);
											return basicSet«IF isTyped»Typed«ENDIF»«ref.name.toFirstUpper»(($«ref.name»eOppositeType:T) otherEnd, msgs);
										«ELSE»
											if («ref.name» != null)
												msgs = (($ieo:T) «ref.name»).eInverseRemove(this, $epit:T.«ref.EOpposite.normalizeUpperField», «(ref.EOpposite.eContainer as EClass).name».class, msgs);
											return basicSet«IF isTyped»Typed«ENDIF»«ref.name.toFirstUpper»(($«ref.name»eOppositeType:T) otherEnd, msgs);
										«ENDIF»
									«ELSE»
										return (($eil:T) ($eilg:T) get«IF isTyped»Typed«ENDIF»«ref.name.toFirstUpper»()).basicAdd(otherEnd, msgs);
									«ENDIF»
							«ENDFOR»
						}
						return super.eInverseAdd(otherEnd, featureID, msgs);
					''', hm).addModifiers(PUBLIC).build
			Optional.of(ret)
		} else
			Optional.empty
	}
	
	def getEBasicRemoveFromContainerFeature(EClass eClass, Dsl dsl, String packageRoot) {
		val eBasicRemoveFromContainerFeatureFields = eClass.EReferences.filter [ field |
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val existEOpposite = field.EOpposite !== null
			val isContainment = field.containment
			val isOppositeContainment = existEOpposite && field.EOpposite.containment
			existEOpposite && !isMultiple && !isContainment && isOppositeContainment
		]
		if (!eBasicRemoveFromContainerFeatureFields.empty) {
			val Map<String, Object> hm = newHashMap("epit" -> eClass.packageIntClassName(packageRoot))

			for (field : eBasicRemoveFromContainerFeatureFields) {
				val tp = field.computeFieldTypeEClass(packageRoot)
				val tp2 = if(tp instanceof ParameterizedTypeName) tp.rawType else tp
				hm.put('''type«field.EType.name»'''.toString, tp2)
			}
			
			val ret = MethodSpec.methodBuilder('''eBasicRemoveFromContainerFeature''').addAnnotation(Override).
					addModifiers(PUBLIC).returns(NotificationChain).addParameter(NotificationChain, 'msgs').
					addNamedCode('''
						switch (eContainerFeatureID()) {
							«FOR field : eBasicRemoveFromContainerFeatureFields»
								case $epit:T.«field.normalizeUpperField» :
									return eInternalContainer().eInverseRemove(this, $epit:T.«field.EOpposite.normalizeUpperField», $type«field.EType.name»:T.class, msgs);
							«ENDFOR»
						}
						return super.eBasicRemoveFromContainerFeature(msgs);
					''', hm).build
			Optional.of(ret)
		} else
			Optional.empty
	}
	
	def getEInverseRemove(EClass eClass, Dsl dsl, String packageRoot, boolean isTyped) {
		if (!eClass.EReferences.filter[it.containment || it.EOpposite !== null].empty) {
			val eInverseRemoveCodeMap = newHashMap("il" ->
				ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
				"package" -> eClass.packageIntClassName(packageRoot))
			val reteir = MethodSpec.methodBuilder('eInverseRemove').addAnnotation(Override).returns(
				NotificationChain).addModifiers(PUBLIC).applyIfTrue(
				dsl.dslProp.getProperty('truffle', "false") == "true", [
					addAnnotation(
						ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
				]).addParameter(ParameterSpec.builder(InternalEObject, 'otherEnd').build).addParameter(
				ParameterSpec.builder(int, 'featureID').build).addParameter(
				ParameterSpec.builder(NotificationChain, 'msgs').build).addNamedCode('''
				switch (featureID) {
					«FOR ref : eClass.EReferences.filter[it.containment || it.EOpposite !== null]» 
						case $package:T.«ref.normalizeUpperField» :
							«IF ref.upperBound == 0 || ref.upperBound == 1»
								return basicSet«IF isTyped»Typed«ENDIF»«ref.name.toFirstUpper»(null, msgs);
							«ELSE»
								return (($il:T) get«IF isTyped»Typed«ENDIF»«ref.name.toFirstUpper»()).basicRemove(otherEnd, msgs);
							«ENDIF»
					«ENDFOR»
				}
				return super.eInverseRemove(otherEnd, featureID, msgs);
			''', eInverseRemoveCodeMap).build
			Optional.of(reteir)
		} else
			Optional.empty
	}
	
	
	
	def getESet(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EStructuralFeatures.empty) {
			val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
			val namedMap = produceFeatureSwitchMap(eClass, packageRoot)
			val ret = MethodSpec.methodBuilder('eSet').addAnnotation(Override) // TODO: add conditional SuppressWarning annotation here
			.addParameter(int, 'featureID').applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addParameter(Object, 'newValue').addModifiers(PUBLIC).addNamedCode('''
				switch (featureID) {
					«FOR esf : eClass.EStructuralFeatures»
						«esf.generateESetCase(isMapElement)»
					«ENDFOR»
				}
				super.eSet(featureID, newValue);
			''', namedMap).build
			Optional.of(ret)
		} else {
			Optional.empty
		}
	}
	
	def hasDefault(EStructuralFeature esf) {
		 esf instanceof EAttribute &&
			(esf.EType !== null && esf.EType.ETypeParameters.isEmpty && esf.EGenericType.ETypeParameter === null &&
				esf.EType.instanceTypeName == esf.EType.instanceClassName)
	}
	
	def isPrimitive(EStructuralFeature esf) {
		CodeGenUtil.isJavaPrimitiveType(esf.EType.getInstanceClassName())	
	}
	
	def isEnum(EStructuralFeature esf) {
		esf.EType instanceof EEnum	
	}
	
	def getEIsSet(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EStructuralFeatures.empty) {
			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)
			
			val ret = MethodSpec.methodBuilder('eIsSet').addAnnotation(Override).returns(boolean).addParameter(int,
				'featureID').applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addModifiers(PUBLIC).addCode( '''
				switch (featureID) {
					«FOR esf : eClass.EStructuralFeatures»
						case $1T.«esf.normalizeUpperField» :
							«IF esf instanceof EAttribute»
								«IF esf.upperBound <= 1 && esf.upperBound >= 0»
									«IF esf.isPrimitive || esf.isEnum»
									return «esf.name.normalizeVarName» != «esf.name.toUpperCase»_EDEFAULT;
									«ELSE»
									return «esf.name.toUpperCase»_EDEFAULT == null ? «esf.name.normalizeVarName» != null : !«esf.name.toUpperCase»_EDEFAULT.equals(«esf.name.normalizeVarName»);
									«ENDIF»
								«ELSE»
									return «esf.name.normalizeVarName» != null && !«esf.name.normalizeVarName».isEmpty();
								«ENDIF»
							«ELSE»
								«IF esf.upperBound <= 1»
									«IF (esf as EReference).EOpposite !== null && (esf as EReference).EOpposite.containment»
										return get«esf.name.toFirstUpper»() != null;
									«ELSE»
										«IF esf.upperBound == 0 || esf.upperBound == 1»
											return «esf.name.normalizeVarName» != null;
										«ELSE»
											return «esf.name.normalizeVarName» != null && !«esf.name.normalizeVarName».isEmpty();
										«ENDIF»
									«ENDIF»
								«ELSE»
									throw new RuntimeException("Not Implemented");
								«ENDIF»
							«ENDIF»
					«ENDFOR»
				}
				return super.eIsSet(featureID);
			''', ePackageInterfaceType).build
			Optional.of(ret)
		} else {
			Optional.empty
		}
	}
	
	
	def String generateESetCase(EStructuralFeature esf, boolean isTyped) {
		val eClass = esf.EContainingClass
		val genCls = resolved.filter[it.eCls.name == eClass.name && it.eCls.EPackage.name == eClass.EPackage.name].head.genCls
		val genFeature = genCls.declaredFieldGenFeatures.filter[it.name == esf.name].head
		'''
		case $epit:T.«esf.normalizeUpperField» :
			«IF genFeature.isListType()»
				«IF genFeature.isWrappedFeatureMapType() »
					((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal)((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal.Wrapper)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).featureMap()).set(newValue);
				«ELSEIF genFeature.isFeatureMapType()»
					((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).set(newValue);
				«ELSEIF genFeature.isMapType()»
					«IF genFeature.isEffectiveSuppressEMFTypes()»
						((<%=genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature")%>.Setting)((<%=genModel.getImportedName("org.eclipse.emf.common.util.EMap")%>.InternalMapView<%=genFeature.getImportedMapTemplateArguments(genClass)%>)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).eMap()).set(newValue);
					«ELSE»
						((<%=genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature")%>.Setting)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).set(newValue);
					«ENDIF»
				«ELSE»
					get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»().clear();
					get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»().addAll(($collection«esf.name»:T)newValue);
				«ENDIF»
			«ELSE»
				set«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»(«IF  (genFeature.getTypeGenDataType() === null || !genFeature.getTypeGenDataType().isObjectType() || !genFeature.getRawType().equals(genFeature.getType(genCls))) »($collection«esf.name»:T)«ENDIF»newValue);
			«ENDIF»
			return;
		'''
	}
	
	def generatedEGetCase(EStructuralFeature esf, boolean isTyped) {
		// FIXME: a lot of corner cases are not implemeted in this method		
		val eClass = esf.EContainingClass
		val genCls = resolved.filter[it.eCls.name == eClass.name && it.eCls.EPackage.name == eClass.EPackage.name].head.genCls
		val genFeature = genCls.declaredFieldGenFeatures.filter[it.name == esf.name].head
		'''
		case $1T.«esf.normalizeUpperField» :
			«IF esf instanceof EAttribute»
			«IF esf.EType.name == "EBoolean"»
				return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»() ? Boolean.TRUE : Boolean.FALSE;
			«ELSE»
					return new <%=genFeature.getObjectType(genClass)%>(get«esf.name.toFirstUpper»());
			    «ENDIF»
			«ELSEIF (genFeature.isResolveProxies() && !genFeature.isListType())»
				if (resolve) return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
				return basicGet«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
			  	«ELSEIF (genFeature.isMapType())»
					«IF  (genFeature.isEffectiveSuppressEMFTypes())»
						if (coreType) return ((<%=genModel.getImportedName("org.eclipse.emf.common.util.EMap")%>.InternalMapView<%=genFeature.getImportedMapTemplateArguments(genClass)%>)get«esf.name.toFirstUpper»()).eMap();
						else return get«esf.name.toFirstUpper»();
			    	«ELSE»
						if (coreType) return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
						else return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»().map();
			    	«ENDIF»
			  	«ELSEIF (genFeature.isWrappedFeatureMapType())»
					if (coreType) return ((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal.Wrapper)get«esf.name.toFirstUpper»()).featureMap();
					return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
			  	«ELSEIF (genFeature.isFeatureMapType())»
					if (coreType) return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
					return ((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal)get«esf.name.toFirstUpper»()).getWrapper();
			  	«ELSE»
					return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
				«ENDIF»
		'''
	}
	def getEGet(EClass eClass, Dsl dsl, String packageRoot, boolean isTyped) {
		if (!eClass.EStructuralFeatures.empty) {
			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot) 
			val ret = MethodSpec.methodBuilder('eGet').addAnnotation(Override).returns(Object).addParameter(int,
				'featureID').applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addParameter(boolean, 'resolve').addParameter(boolean, 'coreType').addModifiers(PUBLIC).addCode('''
				switch (featureID) {
					«FOR esf : eClass.EStructuralFeatures»
						«esf.generatedEGetCase(isTyped)»
					«ENDFOR»
				}
				return super.eGet(featureID, resolve, coreType);
			''', ePackageInterfaceType).build
			Optional.of(ret)
		} else {
			Optional.empty
		}
	}
	
	def getEUnset(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EStructuralFeatures.empty) {
			val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry			
			val namedMap = produceFeatureSwitchMap(eClass, packageRoot)
			val ret = MethodSpec.methodBuilder('eUnset').addAnnotation(Override).addParameter(int, 'featureID').
				addModifiers(PUBLIC).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
					addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
				]).addNamedCode('''
					switch (featureID) {
						«FOR esf : eClass.EStructuralFeatures»
							case $epit:T.«esf.normalizeUpperField» :
								«IF esf instanceof EAttribute»
									«IF esf.upperBound <= 1 && esf.upperBound >= 0»
										set«IF isMapElement»Typed«ENDIF»«esf.name.toFirstUpper»(«esf.name.toUpperCase»_EDEFAULT);
									«ELSE»
										get«IF isMapElement»Typed«ENDIF»«esf.name.toFirstUpper»().clear();
									«ENDIF»
								«ELSE»
									«IF esf.upperBound <= 1 && esf.upperBound >= 0»
										set«IF isMapElement»Typed«ENDIF»«esf.name.toFirstUpper»(($collection«esf.name»:T) null);
									«ELSE»
										get«IF isMapElement»Typed«ENDIF»«esf.name.toFirstUpper»().clear();
									«ENDIF»
								«ENDIF»
								return;
						«ENDFOR»
					}
					super.eUnset(featureID);
				''', namedMap).build
			Optional.of(ret)
		} else {
			Optional.empty
		}
	}

	def getEStaticClass(EClass eClass, Dsl dsl, String packageRoot) {
		MethodSpec.methodBuilder('eStaticClass').addAnnotation(Override).returns(EClass).addModifiers(PROTECTED).
			applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addCode('''
				return $T.Literals.$L;
			''', eClass.packageIntClassName(packageRoot), eClass.name.normalizeUpperField).build
	}

	def Iterable<MethodSpec> getMethodsEReferences(EClass eClass, String packageRoot, Dsl dsl,
		ClassName ePackageInterfaceType, boolean isMapElement) {
		eClass.EStructuralFeatures.map [ field |
			val fieldType = field.resolveFieldType(packageRoot)
			eClassGetterCompiler.compileAccessors(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement)
		].flatten
	}

	def Iterable<FieldSpec> getFieldsEReferences(EClass eClass, String packageRoot) {
		this.getFieldsEReferences(eClass, packageRoot, [b, e|b])
	}

	def isBlank(String string) {
		string === null || string.length() == 0
	}
	
	

	def Iterable<FieldSpec> getFieldsEReferences(EClass eClass, String packageRoot, Function2<FieldSpec.Builder, EReference, FieldSpec.Builder> f2) {
		eClass.EReferences.filter[field|if(field.EOpposite !== null) !field.EOpposite.containment else true].map [ field |
			val fieldType = field.computeFieldTypeEClass(packageRoot)
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
