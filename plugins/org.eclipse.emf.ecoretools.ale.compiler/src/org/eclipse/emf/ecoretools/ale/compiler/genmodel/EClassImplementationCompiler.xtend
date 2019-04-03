package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterizedTypeName
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.xtext.xbase.lib.Functions.Function2

import static javax.lang.model.element.Modifier.*
import org.eclipse.emf.ecoretools.ale.compiler.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecore.EAttribute
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.WildcardTypeName
import java.util.Collection
import org.eclipse.emf.ecore.ETypedElement
import java.util.Optional
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.ecore.util.InternalEList
import com.squareup.javapoet.ParameterSpec
import org.eclipse.emf.ecore.InternalEObject

class EClassImplementationCompiler {

	extension CommonCompilerUtils ccu
	extension GenmodelNamingUtils anu
	extension JavaPoetUtils jpu
	val EClassGetterCompiler eClassGetterCompiler

	new(CommonCompilerUtils ccu, GenmodelNamingUtils anu, EClassGetterCompiler eClassGetterCompiler,
		JavaPoetUtils jpu) {
		this.ccu = ccu
		this.anu = anu
		this.eClassGetterCompiler = eClassGetterCompiler
		this.jpu = jpu
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
		val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
			eClass.EPackage.packageInterfaceClassName)
		
		val Map<String, TypeName> namedMap = newHashMap(
					"epit" -> ePackageInterfaceType,
					"esf" -> ClassName.get(EStructuralFeature.Setting)
				)
				for (esf : eClass.EStructuralFeatures) {
					if (esf instanceof EAttribute) {
						val tn = esf.EType.scopedTypeRef(packageRoot).box
						namedMap.put("fieldtype" + esf.name, tn)
						val genericType = WildcardTypeName.subtypeOf(tn)
						namedMap.put("collection" + esf.name,
							ParameterizedTypeName.get(ClassName.get(Collection), genericType.box))
					} else {
						val tn = ClassName.get((esf.EType as EClass).classInterfacePackageName(packageRoot),
							(esf.EType as EClass).classInterfaceClassName)
						namedMap.put("fieldtype" + esf.name, tn)
						namedMap.put("collection" + esf.name,
							ParameterizedTypeName.get(ClassName.get(Collection), WildcardTypeName.subtypeOf(tn.box)))
					}
				}
				return namedMap
	}
	
	def getEInverseAdd(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EReferences.filter[it.EOpposite !== null].empty) {

			val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot), eClass.EPackage.packageInterfaceClassName)
			val hm = newHashMap("nc" -> NotificationChain, "epit" -> ePackageInterfaceType,
				"eil" -> ParameterizedTypeName.get(ClassName.get(InternalEList), ClassName.get(InternalEObject)),
				"eilg" ->
					ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
				"ieo" -> TypeName.get(InternalEObject))

			for (ref : eClass.EReferences.filter[it.EOpposite !== null]) {
				hm.put('''«ref.name»eOppositeType'''.toString,
					ClassName.get((ref.EOpposite.eContainer as EClass).classInterfacePackageName(packageRoot),
						(ref.EOpposite.eContainer as EClass).classInterfaceClassName))
			}

			val ret = MethodSpec.methodBuilder('eInverseAdd').addAnnotation(Override).returns(NotificationChain).
					applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addParameter(InternalEObject, 'otherEnd').addParameter(int, 'featureID').addParameter(
						NotificationChain, 'msgs').addNamedCode('''
						switch (featureID) {
							«FOR ref : eClass.EReferences.filter[it.EOpposite !== null]»
								case $epit:T.«ref.name.normalizeUpperField(eClass.name)» :
									«IF ref.upperBound == 0 || ref.upperBound == 1»
										«IF ref.EOpposite !== null && ref.EOpposite.containment»
											if (eInternalContainer() != null)
												msgs = eBasicRemoveFromContainer(msgs);
											return basicSet«ref.name.toFirstUpper»(($«ref.name»eOppositeType:T) otherEnd, msgs);
										«ELSEIF ref.EOpposite !== null && ref.containment»
											if («ref.name» != null)
												msgs = (($ieo:T) «ref.name»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $epit:T.«ref.name.normalizeUpperField(ref.EOpposite.EType.name)», null, msgs);
											return basicSet«ref.name.toFirstUpper»(($«ref.name»eOppositeType:T) otherEnd, msgs);
										«ELSE»
											if («ref.name» != null)
												msgs = (($ieo:T) «ref.name»).eInverseRemove(this, $epit:T.«ref.EOpposite.name.normalizeUpperField((ref.EOpposite.eContainer as EClass).name)», «(ref.EOpposite.eContainer as EClass).name».class, msgs);
											return basicSet«ref.name.toFirstUpper»(($«ref.name»eOppositeType:T) otherEnd, msgs);
										«ENDIF»
									«ELSE»
										return (($eil:T) ($eilg:T) get«ref.name.toFirstUpper»()).basicAdd(otherEnd, msgs);
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
			val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot), eClass.EPackage.packageInterfaceClassName)
			val hm = newHashMap("epit" -> ePackageInterfaceType)

			for (field : eBasicRemoveFromContainerFeatureFields) {
				hm.put('''type«field.EType.name»'''.toString,
					ClassName.get(eClass.classInterfacePackageName(packageRoot), field.EType.name))
			}

			
			val ret=	MethodSpec.methodBuilder('''eBasicRemoveFromContainerFeature''').addAnnotation(Override).
					addModifiers(PUBLIC).returns(NotificationChain).addParameter(NotificationChain, 'msgs').
					addNamedCode('''
						switch (eContainerFeatureID()) {
							«FOR field : eBasicRemoveFromContainerFeatureFields»
								case $epit:T.«field.name.normalizeUpperField(eClass.name)» :
									return eInternalContainer().eInverseRemove(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $type«field.EType.name»:T.class, msgs);
							«ENDFOR»
						}
						return super.eBasicRemoveFromContainerFeature(msgs);
					''', hm).build
			Optional.of(ret)
		} else
			Optional.empty
	}
	
	def getEInverseRemove(EClass eClass, Dsl dsl, String packageRoot) {
		if (!eClass.EReferences.filter[it.containment || it.EOpposite !== null].empty) {
						val eInverseRemoveCodeMap = newHashMap("il" ->
							ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
							"package" ->
								ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
									eClass.EPackage.packageInterfaceClassName))
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
									case $package:T.«ref.name.normalizeUpperField(eClass.name)» :
										«IF ref.upperBound == 0 || ref.upperBound == 1»
											return basicSet«ref.name.toFirstUpper»(null, msgs);
										«ELSE»
											return (($il:T) get«ref.name.toFirstUpper»()).basicRemove(otherEnd, msgs);
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
		val namedMap = produceFeatureSwitchMap(eClass, packageRoot)
		MethodSpec.methodBuilder('eSet').addAnnotation(Override)// TODO: add conditional SuppressWarning annotation here
				.addParameter(int, 'featureID')
				.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
					addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
				])
				.addParameter(Object, 'newValue')
				.addModifiers(PUBLIC)
				.addNamedCode('''
					switch (featureID) {
						«FOR esf : eClass.EStructuralFeatures»
							case $epit:T.«esf.name.normalizeUpperField(eClass.name)» :
								«IF esf instanceof EAttribute»
									«IF esf.upperBound <= 1 && esf.upperBound >= 0»
										set«esf.name.toFirstUpper»(($fieldtype«esf.name»:T) newValue);
									«ELSE»
										get«esf.name.toFirstUpper»().clear();
										get«esf.name.toFirstUpper»().addAll(($collection«esf.name»:T) newValue);
									«ENDIF»
								«ELSE»
									«IF esf.upperBound <= 1 && esf.upperBound >= 0»
										set«esf.name.toFirstUpper»(($fieldtype«esf.name»:T) newValue);
									«ELSE»
										«IF (esf.EType.instanceClass !== null && esf.EType.instanceClass == Map.Entry)»
											(($esf:T)get«esf.name.toFirstUpper»()).set(newValue);
										«ELSE»
											get«esf.name.toFirstUpper»().clear();
											get«esf.name.toFirstUpper»().addAll(($collection«esf.name»:T) newValue);
										«ENDIF»
									«ENDIF»
								«ENDIF»
								return;
						«ENDFOR»
					}
					super.eSet(featureID, newValue);
				''', namedMap).build
	}
	
	def getEIsSet(EClass eClass, Dsl dsl, String packageRoot) {
		
		val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
			eClass.EPackage.packageInterfaceClassName)
		MethodSpec.methodBuilder('eIsSet').addAnnotation(Override).returns(
			boolean).addParameter(int, 'featureID').applyIfTrue(dsl.dslProp.getProperty('truffle', "false") ==
			"true", [
			addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
		]).addModifiers(PUBLIC).addCode( '''
			switch (featureID) {
				«FOR esf : eClass.EStructuralFeatures»
					case $1T.«esf.name.normalizeUpperField(eClass.name)» :
						«IF esf instanceof EAttribute»
							«IF esf.upperBound <= 1 && esf.upperBound >= 0»
								return «esf.name.normalizeVarName» != «esf.name.toUpperCase»_EDEFAULT;
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
	}
	
	def getEGet(EClass eClass, Dsl dsl, String packageRoot) {
		val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
			eClass.EPackage.packageInterfaceClassName)
		MethodSpec.methodBuilder('eGet').addAnnotation(Override).returns(Object).
			addParameter(int, 'featureID').applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addParameter(boolean, 'resolve').addParameter(boolean, 'coreType').addModifiers(PUBLIC).
			addCode('''
				switch (featureID) {
					«FOR esf : eClass.EStructuralFeatures»
						case $1T.«esf.name.normalizeUpperField(eClass.name)» :
							«IF esf.EType.instanceClass !== null && esf.EType.instanceClass == Map.Entry»
								if (coreType)
									return get«esf.name.toFirstUpper»();
								else
									return get«esf.name.toFirstUpper»().map();
							«ELSEIF esf.isResolveProxies && !esf.isListType»
								if (resolve)
									return «IF esf.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«esf.name.toFirstUpper»();
								return basic«IF esf.EType.name == "EBoolean"»Is«ELSE»Get«ENDIF»«esf.name.toFirstUpper»();
							«ELSE»
								return «IF esf.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«esf.name.toFirstUpper»();
							«ENDIF»
					«ENDFOR»
				}
				return super.eGet(featureID, resolve, coreType);
			''', ePackageInterfaceType).build
	}
	
	def getEUnset(EClass eClass, Dsl dsl, String packageRoot) {
		val namedMap = produceFeatureSwitchMap(eClass, packageRoot)
		MethodSpec.methodBuilder('eUnset').addAnnotation(Override).
			addParameter(int, 'featureID').addModifiers(PUBLIC).applyIfTrue(
				dsl.dslProp.getProperty('truffle', "false") == "true", [
					addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
				]).addNamedCode('''
				switch (featureID) {
					«FOR esf : eClass.EStructuralFeatures»
						case $epit:T.«esf.name.normalizeUpperField(eClass.name)» :
							«IF esf instanceof EAttribute»
								«IF esf.upperBound <= 1 && esf.upperBound >= 0»
									set«esf.name.toFirstUpper»(«esf.name.toUpperCase»_EDEFAULT);
								«ELSE»
									get«esf.name.toFirstUpper»().clear();
								«ENDIF»
							«ELSE»
								«IF esf.upperBound <= 1 && esf.upperBound >= 0»
									set«esf.name.toFirstUpper»(($fieldtype«esf.name»:T) null);
								«ELSE»
									get«esf.name.toFirstUpper»().clear();
								«ENDIF»
							«ENDIF»
							return;
					«ENDFOR»
				}
				super.eUnset(featureID);
			''', namedMap).build
	}

	def getEStaticClass(EClass eClass, Dsl dsl, String packageRoot) {
		MethodSpec.methodBuilder('eStaticClass').addAnnotation(Override).returns(EClass).addModifiers(PROTECTED).
			applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addCode('''
				return $T.Literals.$L;
			''', ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
				eClass.EPackage.packageInterfaceClassName), eClass.name.normalizeUpperField).build
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
