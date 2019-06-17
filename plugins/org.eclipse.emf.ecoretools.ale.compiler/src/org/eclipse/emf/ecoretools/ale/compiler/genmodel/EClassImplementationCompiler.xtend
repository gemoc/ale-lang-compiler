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
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecore.util.InternalEList
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2

import static javax.lang.model.element.Modifier.*

class EClassImplementationCompiler {

	extension CommonCompilerUtils ccu
	extension EcoreGenNamingUtils anu
	extension JavaPoetUtils jpu
	val EClassGetterCompiler eClassGetterCompiler
	val List<ResolvedClass> resolved
	extension EnumeratorService es
	extension TruffleHelper th

	new(CommonCompilerUtils ccu, EcoreGenNamingUtils anu, EClassGetterCompiler eClassGetterCompiler,
		JavaPoetUtils jpu, List<ResolvedClass> resolved, EnumeratorService es, TruffleHelper th) {
		this.ccu = ccu
		this.anu = anu
		this.eClassGetterCompiler = eClassGetterCompiler
		this.jpu = jpu
		this.resolved = resolved
		this.es = es
		this.th = th
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
		val eBaseStructuralFeatureID = this.getEBaseStructuralFeatureID(eClass, packageRoot)
		val eDerivedStructuralFeatureID = this.getEDerivedStructuralFeatureID(eClass, packageRoot)
		val eMethods = #[eInverseAdd, eInverseRemove, eBasicRemoveFromContainerFeature, eGetMethod, eSetMethod, eUnsetMethod, eIsSetMethod, eBaseStructuralFeatureID, eDerivedStructuralFeatureID]
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
			if (dsl.isTruffle) {
				if (!eClass.EAnnotations.exists[it.source == 'RuntimeData']) {
					superclass(ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.truffle", "MinimalTruffleEObjectImpl", "TruffleContainer"))
				} else {
					superclass(ClassName.get(MinimalEObjectImpl.Container))
				}
			} else {
				superclass(ClassName.get(MinimalEObjectImpl.Container))
			}
		])
		.applyIfTrue(!isMapElement && !dsl.truffle, [
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
	
	private def getEMapMethods(EClass eClass, Dsl dsl, String packageRoot) {
		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry

		if (!isMapElement) {
			#[]
		} else {
			val setHash = MethodSpec.methodBuilder('setHash')
				.addTruffleBoundaryAnnotation(dsl)
				.addParameter(int, 'hash')
				.addCode('''
				this.hash = hash;
				''')
				.addModifiers(PUBLIC)
				.build
			val getHash = MethodSpec.methodBuilder('getHash')
				.addTruffleBoundaryAnnotation(dsl)
				.returns(int)
				.addCode('''
					if (hash == -1) {
						Object theKey = getKey();
						hash = (theKey == null ? 0 : theKey.hashCode());
					}
					return hash;
				''')
				.addModifiers(PUBLIC)
				.build
			
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
				.addTruffleBoundaryAnnotation(dsl)
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

	private def produceFeatureSwitchMap(EClass eClass, String packageRoot) {
		val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)
		
		val Function1<TypeName, TypeName> f = [ TypeName p |
				ParameterizedTypeName.get(ClassName.get(Collection), WildcardTypeName.subtypeOf(p.box))
			]
		
		val Map<String, TypeName> namedMap = newHashMap(
			"epit" -> ePackageInterfaceType,
			"esf" -> ClassName.get(EStructuralFeature.Setting),
			"essf" ->  ClassName.get("org.eclipse.emf.ecore.EStructuralFeature", "Setting")
		)
		for (esf : eClass.allESFPlusInheritedESF) {
			val tnp = esf.computeFieldTypeEClass(packageRoot, f).box
			val tn = if(tnp instanceof ParameterizedTypeName) tnp.typeArguments.head else tnp
			namedMap.put("fieldtype" + esf.name, tn)
			namedMap.put("collection" + esf.name, tnp)
		}
		return namedMap
	}
	
	private def Optional<MethodSpec> getEBaseStructuralFeatureID(EClass eClass, String packageRoot) {
		if(eClass.allESFPlusInheritedESF.size <= eClass.EStructuralFeatures.size) {
			Optional.empty
		} else {
			val hm = newHashMap
			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)
			hm.put("epit", ePackageInterfaceType)
			for(clazz: eClass.allRightSupertypes.enumerate) {
				hm.put("baseClass" + clazz.value, clazz.key.scopedInterfaceTypeRef(packageRoot))
			}
			
			val method = MethodSpec.methodBuilder('eBaseStructuralFeatureID')
				.addAnnotation(Override)
				.addModifiers(PUBLIC)
				.addParameter(int, 'derivedFeatureID')
				.addParameter(ParameterizedTypeName.get(ClassName.get(Class), WildcardTypeName.subtypeOf(Object)), 'baseClass')
				.returns(int)
				.addNamedCode('''
				«FOR clazz: eClass.allRightSupertypes.enumerate»
				if (baseClass == $baseClass«clazz.value»:T.class) {
					switch (derivedFeatureID) {
						«FOR esf: clazz.key.EStructuralFeatures»
						case $epit:T.«esf.normalizeUpperField(eClass)»: return $epit:T.«esf.normalizeUpperField(clazz.key)»;
						«ENDFOR»
						default: return -1;
					}
				}
				«ENDFOR»
				return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
				''', hm)
				.build
			Optional.of(method)
		}
	}
	
	private def Optional<MethodSpec> getEDerivedStructuralFeatureID(EClass eClass, String packageRoot) {
		if(eClass.allESFPlusInheritedESF.size <= eClass.EStructuralFeatures.size) {
			Optional.empty
		} else {
			val hm = newHashMap
			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)
			hm.put("epit", ePackageInterfaceType)
			for(clazz: eClass.allRightSupertypes.enumerate) {
				hm.put("baseClass" + clazz.value, clazz.key.scopedInterfaceTypeRef(packageRoot))
			}
			
			val method = MethodSpec.methodBuilder('eDerivedStructuralFeatureID')
				.addAnnotation(Override)
				.addModifiers(PUBLIC)
				.addParameter(int, 'baseFeatureID')
				.addParameter(ParameterizedTypeName.get(ClassName.get(Class), WildcardTypeName.subtypeOf(Object)), 'baseClass')
				.returns(int)
				.addNamedCode('''
				«FOR clazz: eClass.allRightSupertypes.enumerate»
				if (baseClass == $baseClass«clazz.value»:T.class) {
					switch (baseFeatureID) {
						«FOR esf: clazz.key.EStructuralFeatures»
						case $epit:T.«esf.normalizeUpperField(clazz.key)»: return $epit:T.«esf.normalizeUpperField(eClass)»;
						«ENDFOR»
						default: return -1;
					}
				}
				«ENDFOR»
				return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
				''', hm)
				.build
			Optional.of(method)
		}
	}
	
	private def getEInverseAdd(EClass eClass, Dsl dsl, String packageRoot, boolean isTyped) {
		if (!eClass.EReferences.filter[it.EOpposite !== null].empty) {

			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)

			val hm = newHashMap("nc" -> NotificationChain, "epit" -> ePackageInterfaceType,
				"eil" -> ParameterizedTypeName.get(ClassName.get(InternalEList), ClassName.get(InternalEObject)),
				"eilg" ->
					ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
				"ieo" -> TypeName.get(InternalEObject))

			for (ref : eClass.EReferences.filter[it.EOpposite !== null]) {
				val ct = ref.computeFieldTypeEClass(packageRoot)
				val ct2 = if(ct instanceof ParameterizedTypeName) ct.rawType else ct
				hm.put('''«ref.name»eOppositeType'''.toString, ct)
				hm.put('''«ref.name»eOppositeTypeNoGen'''.toString, ct2)
			}

			val ret = MethodSpec.methodBuilder('eInverseAdd')
				.addAnnotation(Override)
				.returns(NotificationChain)
				.addTruffleBoundaryAnnotation(dsl)
				.addParameter(InternalEObject, 'otherEnd').addParameter(int, 'featureID').addParameter(
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
											msgs = (($ieo:T) «ref.name»).eInverseRemove(this, $epit:T.«ref.EOpposite.normalizeUpperField», $«ref.name»eOppositeTypeNoGen:T.class, msgs);
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
	
	private def getEBasicRemoveFromContainerFeature(EClass eClass, Dsl dsl, String packageRoot) {
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
	
	private def getEInverseRemove(EClass eClass, Dsl dsl, String packageRoot, boolean isTyped) {
		if (!eClass.EReferences.filter[it.containment || it.EOpposite !== null].empty) {
			val eInverseRemoveCodeMap = newHashMap("il" ->
				ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
				"package" -> eClass.packageIntClassName(packageRoot))
			val reteir = MethodSpec.methodBuilder('eInverseRemove').addAnnotation(Override).returns(
				NotificationChain).addModifiers(PUBLIC)
				.addTruffleBoundaryAnnotation(dsl)
				.addParameter(ParameterSpec.builder(InternalEObject, 'otherEnd').build).addParameter(
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
	
	
	
	private def getESet(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EStructuralFeatures.empty) {
			val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
			val namedMap = produceFeatureSwitchMap(eClass, packageRoot)
			val ret = MethodSpec.methodBuilder('eSet').addAnnotation(Override)
			.addParameter(int, 'featureID')
			.addTruffleBoundaryAnnotation(dsl)
			.addParameter(Object, 'newValue').addModifiers(PUBLIC).addNamedCode('''
				switch (featureID) {
					«FOR esf : eClass.allESFPlusInheritedESF»
						«esf.generateESetCase(isMapElement, eClass)»
					«ENDFOR»
				}
				super.eSet(featureID, newValue);
			''', namedMap).build
			Optional.of(ret)
		} else {
			Optional.empty
		}
	}
	
	private def isPrimitive(EStructuralFeature esf) {
		CodeGenUtil.isJavaPrimitiveType(esf.EType.getInstanceClassName())	
	}
	
	private def isEnum(EStructuralFeature esf) {
		esf.EType instanceof EEnum	
	}
	
	private def getEIsSet(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EStructuralFeatures.empty) {
			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot)
			
			val ret = MethodSpec.methodBuilder('eIsSet')
				.addAnnotation(Override)
				.returns(boolean)
				.addParameter(int, 'featureID')
				.addTruffleBoundaryAnnotation(dsl)
				.addModifiers(PUBLIC).addCode( '''
					switch (featureID) {
						«FOR esf : eClass.allESFPlusInheritedESF»
							case $1T.«esf.normalizeUpperField(eClass)» :
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
	
	
	private def String generateESetCase(EStructuralFeature esf, boolean isTyped, EClass eClass) {
		val genCls = resolved.filter[it.eCls.name == eClass.name && it.eCls.EPackage.name == eClass.EPackage.name].head.genCls
		val genFeature = genCls.declaredFieldGenFeatures.filter[it.name == esf.name].head
		'''
		case $epit:T.«esf.normalizeUpperField(eClass)» :
			«IF genFeature.isListType()»
				«IF genFeature.isWrappedFeatureMapType() »
					// TODO ((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal)((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal.Wrapper)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).featureMap()).set(newValue);
				«ELSEIF genFeature.isFeatureMapType()»
					// TODO ((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).set(newValue);
				«ELSEIF genFeature.isMapType()»
					«IF genFeature.isEffectiveSuppressEMFTypes()»
						// TODO ($essf:T)((<%=genModel.getImportedName("org.eclipse.emf.common.util.EMap")%>.InternalMapView<%=genFeature.getImportedMapTemplateArguments(genClass)%>)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).eMap()).set(newValue);
					«ELSE»
						(($essf:T)get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»()).set(newValue);
					«ENDIF»
				«ELSE»
					get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»().clear();
					get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»().addAll(($collection«esf.name»:T) newValue);
				«ENDIF»
			«ELSE»
				set«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»(«IF  (genFeature.getTypeGenDataType() === null || !genFeature.getTypeGenDataType().isObjectType() || !genFeature.getRawType().equals(genFeature.getType(genCls))) »($collection«esf.name»:T) «ENDIF»newValue);
			«ENDIF»
			return;
		'''
	}
	
	private def generatedEGetCase(EStructuralFeature esf, boolean isTyped, EClass currentEClass) {
		val eClass = esf.EContainingClass
		val genCls = resolved.filter[it.eCls.name == eClass.name && it.eCls.EPackage.name == eClass.EPackage.name].head.genCls
		val genFeature = genCls.declaredFieldGenFeatures.filter[it.name == esf.name].head
		'''
		case $1T.«esf.normalizeUpperField(currentEClass)» :
			«IF esf instanceof EAttribute»
			«IF esf.EType.name == "EBoolean" && !esf.many»
				return «IF isTyped»getTyped«ELSE»is«ENDIF»«esf.name.toFirstUpper»();
			«ELSE»
					return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
			    «ENDIF»
			«ELSEIF (genFeature.isResolveProxies() && !genFeature.isListType())»
				if (resolve)
					return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
				return basicGet«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
			  	«ELSEIF (genFeature.isMapType())»
					«IF  (genFeature.isEffectiveSuppressEMFTypes())»
						if (coreType) return null; // TODO ((<%=genModel.getImportedName("org.eclipse.emf.common.util.EMap")%>.InternalMapView<%=genFeature.getImportedMapTemplateArguments(genClass)%>)get«esf.name.toFirstUpper»()).eMap();
						else return get«esf.name.toFirstUpper»();
			    	«ELSE»
						if (coreType) return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
						else return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»().map();
			    	«ENDIF»
			  	«ELSEIF (genFeature.isWrappedFeatureMapType())»
					if (coreType) return null; // TODO((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal.Wrapper)get«esf.name.toFirstUpper»()).featureMap();
					return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
			  	«ELSEIF (genFeature.isFeatureMapType())»
					if (coreType) return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
					return null; // TODO ((<%=genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap")%>.Internal)get«esf.name.toFirstUpper»()).getWrapper();
			  	«ELSE»
					return get«IF isTyped»Typed«ENDIF»«esf.name.toFirstUpper»();
				«ENDIF»
		'''
	}
	private def getEGet(EClass eClass, Dsl dsl, String packageRoot, boolean isTyped) {
		if (!eClass.EStructuralFeatures.empty) {
			val ePackageInterfaceType = eClass.packageIntClassName(packageRoot) 
			val ret = MethodSpec.methodBuilder('eGet')
				.addAnnotation(Override)
				.returns(Object)
				.addParameter(int, 'featureID')
				.addTruffleBoundaryAnnotation(dsl)
				.addParameter(boolean, 'resolve').addParameter(boolean, 'coreType')
				.addModifiers(PUBLIC)
				.addCode('''
				switch (featureID) {
					«FOR esf : eClass.allESFPlusInheritedESF»
						«esf.generatedEGetCase(isTyped, eClass)»
					«ENDFOR»
				}
				return super.eGet(featureID, resolve, coreType);
			''', ePackageInterfaceType)
			.build
			Optional.of(ret)
		} else {
			Optional.empty
		}
	}
	
	private def getEUnset(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EStructuralFeatures.empty) {
			val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry			
			val namedMap = produceFeatureSwitchMap(eClass, packageRoot)
			val ret = MethodSpec.methodBuilder('eUnset')
				.addAnnotation(Override)
				.addParameter(int, 'featureID')
				.addModifiers(PUBLIC)
				.addTruffleBoundaryAnnotation(dsl)
				.addNamedCode('''
					switch (featureID) {
						«FOR esf : eClass.allESFPlusInheritedESF»
							case $epit:T.«esf.normalizeUpperField(eClass)» :
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

	private def getEStaticClass(EClass eClass, Dsl dsl, String packageRoot) {
		MethodSpec.methodBuilder('eStaticClass').addAnnotation(Override).returns(EClass)
			.addModifiers(PROTECTED)
			.addTruffleBoundaryAnnotation(dsl)
			.addCode('''
				return $T.Literals.$L;
			''', eClass.packageIntClassName(packageRoot), eClass.name.normalizeUpperField).build
	}
	
	
	private def allESFPlusInheritedESF(EClass eClass) {
		eClass.EAllStructuralFeatures
			.filter[eClass.ESuperTypes.head === null || !eClass.ESuperTypes.head.EAllStructuralFeatures.contains(it)]
	}
	
	private def Iterable<EClass> allRightSupertypes(EClass eClass) {
		val superTypes = eClass.ESuperTypes
		if (superTypes.isEmpty() || (superTypes.size() == 1 && !superTypes.get(0).isInterface())) {
			return newArrayList;
		}

		val allBases = eClass.EAllSuperTypes
		val result = newArrayList

		// If extending an interface, its mix-ins must be included, since there is no implementation to handle them.
		//
		val baseGenClass = eClass.ESuperTypes.head
		if (baseGenClass !== null && baseGenClass.isInterface()) {
			result.addAll(baseGenClass.allRightSupertypes())
		}

		// Mix-ins are everything after the base class.
		//
		val i = allBases.indexOf(baseGenClass) + 1;
		result.addAll(allBases.subList(i, allBases.size()));
		return result;
	}

	private def Iterable<MethodSpec> getMethodsEReferences(EClass eClass, String packageRoot, Dsl dsl,
		ClassName ePackageInterfaceType, boolean isMapElement) {
		eClass.allESFPlusInheritedESF
			.map [ field |
			val fieldType = field.resolveFieldType(packageRoot)
			eClassGetterCompiler.compileAccessors(field, fieldType, packageRoot, eClass, ePackageInterfaceType, isMapElement)
		].flatten
	}

	private def Iterable<FieldSpec> getFieldsEReferences(EClass eClass, String packageRoot, Function2<FieldSpec.Builder, EReference, FieldSpec.Builder> f2) {
		eClass.EAllReferences
			.filter[eClass.ESuperTypes.head === null || !eClass.ESuperTypes.head.EAllReferences.contains(it)]
			.filter[field|if(field.EOpposite !== null) !field.EOpposite.containment else true].map [ field |
			val fieldType = field.computeFieldTypeEClass(packageRoot)
			val builderTmp = FieldSpec.builder(fieldType, field.name)
			val builderTmp2 = if(f2 !== null) f2.apply(builderTmp, field) else builderTmp
			builderTmp2.addModifiers(PROTECTED).build
		]
	}

	private def Iterable<FieldSpec> getFieldsEAttributes(EClass eClass, String packageRoot) {
		eClass.EAllAttributes
			.filter[eClass.ESuperTypes.head === null || !eClass.ESuperTypes.head.EAllAttributes.contains(it)]
			.map [ field |
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
