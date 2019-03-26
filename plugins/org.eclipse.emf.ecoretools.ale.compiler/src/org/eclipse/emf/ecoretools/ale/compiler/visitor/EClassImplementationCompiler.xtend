package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import com.squareup.javapoet.WildcardTypeName
import java.io.File
import java.util.Collection
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.common.util.BasicEMap
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecore.util.InternalEList
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassGetterCompiler
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

import static javax.lang.model.element.Modifier.*

class EClassImplementationCompiler {
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension VisitorCompilerUtils = new VisitorCompilerUtils
	extension JavaPoetUtils = new JavaPoetUtils
	val eClassGetterCompiler = new EClassGetterCompiler(namingUtils)
	
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	val Dsl dsl
	val String packageRoot
	
	static class CompilerExpressionCtx {
		public val String thisCtxName
		public val ExtendedClass aleClass
		public val EClass eClass 
		new(String thisCtxName, ExtendedClass aleClass, EClass eClass) {
			this.thisCtxName = thisCtxName
			this.aleClass = aleClass
			this.eClass = eClass
		}
	}
	
	new(String packageRoot, Dsl dsl) {
		this.packageRoot = packageRoot
		this.dsl = dsl
	}
	
	private def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass) {
		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
		val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
			eClass.EPackage.packageInterfaceClassName)

		val hasSuperType = !eClass.ESuperTypes.empty
		val superType = eClass.ESuperTypes.head

		val fieldsEAttributes = eClass.EAttributes.map [ field |
			val fet = field.EType
			val type = fet.scopedTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			if(isMultiple) {
				val fieldField = FieldSpec.builder(ParameterizedTypeName.get(ClassName.get(EList), type), '''«field.name»''', PROTECTED).build
				#[fieldField]
			} else {
				val edefault = if(fet instanceof EEnum) {
					var tmpfs = FieldSpec
						.builder(type, '''«field.name.toUpperCase»_EDEFAULT''')
						
					if(field.defaultValue === null || field.defaultValue.toString == '')
						tmpfs = tmpfs.initializer('''null''')
					else
						tmpfs = tmpfs.initializer('''$T.«field.defaultValue.toString.toUpperCase»''', 
							ClassName.get(namingUtils.classInterfacePackageName(fet, packageRoot), namingUtils.classInterfaceClassName(fet))
						)
						
					tmpfs.addModifiers(PROTECTED, STATIC, FINAL).build
				} else {
					FieldSpec
						.builder(type, '''«field.name.toUpperCase»_EDEFAULT''')
						.initializer('''«IF field.defaultValue === null || field.defaultValue.toString == ''»null«ELSE»«field.defaultValue»«ENDIF»''')
						.addModifiers(PROTECTED, STATIC, FINAL).build
				}
	
				val fieldField = FieldSpec.builder(type, field.name.normalizeVarName).initializer('''«field.name.toUpperCase»_EDEFAULT''').
					addModifiers(PROTECTED).build
				#[edefault, fieldField]
				
			}
		].flatten

		/*
		 * Do not generate physical fields for opposite relations to  containment fields
		 */
		val fieldsEReferences = eClass.EReferences.filter[field | if(field.EOpposite !== null) !field.EOpposite.containment else true].map [ field |
			val ert = field.EGenericType.ERawType
			val rt = ert.scopedInterfaceTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if (isMultiple) {
				if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
					val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
					val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
					if(key !== null && value !== null) {
						ParameterizedTypeName.get(ClassName.get(EMap), key.EType.scopedInterfaceTypeRef(packageRoot), value.EType.scopedInterfaceTypeRef(packageRoot))
					} else {
						ParameterizedTypeName.get(ClassName.get(EList), rt)
					}
				} else {
					ParameterizedTypeName.get(ClassName.get(EList), rt)
				}
			} else
				rt
				
			FieldSpec.builder(fieldType, field.name).addModifiers(PROTECTED).build
		]

		val methodsEReferences = eClass.EStructuralFeatures.map [ field |
			val ert = field.EGenericType.ERawType
			val rt = ert.scopedInterfaceTypeRef(packageRoot)
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if (isMultiple) {
					if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
						val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
						val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
						if(key !== null && value !== null) {
							ParameterizedTypeName.get(ClassName.get(EMap), key.EType.scopedInterfaceTypeRef(packageRoot), value.EType.scopedInterfaceTypeRef(packageRoot))
						} else {
							ParameterizedTypeName.get(ClassName.get(EList), rt)
						}
					} else {
						ParameterizedTypeName.get(ClassName.get(EList), rt)
					}
				} else
					rt

			eClassGetterCompiler.compileGetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement)
		].flatten

		val eStaticClassMethod = MethodSpec.methodBuilder('eStaticClass')
			.addAnnotation(Override)
			.returns(EClass)
			.addModifiers(PROTECTED)
			.addCode('''
			return $1T.Literals.«eClass.name.normalizeUpperField»;
			''', ePackageInterfaceType).build

		val eSetMethod = if(!eClass.EStructuralFeatures.empty) {
			val Map<String, TypeName> namedMap = newHashMap(
				"epit" -> ePackageInterfaceType,
				"esf" -> ClassName.get(EStructuralFeature.Setting)
			)
			for(esf: eClass.EStructuralFeatures) {
				if(esf instanceof EAttribute) {
					val tn = esf.EType.scopedTypeRef(packageRoot).box
					namedMap.put("fieldtype" + esf.name, tn)
					val genericType = WildcardTypeName.subtypeOf(tn)
					namedMap.put("collection" + esf.name,  ParameterizedTypeName.get(ClassName.get(Collection), genericType))					
				} else {
					val tn = ClassName.get((esf.EType as EClass).classInterfacePackageName(packageRoot), (esf.EType as EClass).classInterfaceClassName)
					namedMap.put("fieldtype" + esf.name, tn)
					namedMap.put("collection" + esf.name,  ParameterizedTypeName.get(ClassName.get(Collection), WildcardTypeName.subtypeOf(tn)))	
				}
			}
			
			val MethodSpec eSetMethod = MethodSpec.methodBuilder('eSet')
				.addAnnotation(Override)
				// TODO: add conditional SuppressWarning annotation here
				.addParameter(int, 'featureID')
				.addParameter(Object, 'newValue').addModifiers(PUBLIC).addNamedCode( '''
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
		
		val MethodSpec  eUnsetMethod = MethodSpec.methodBuilder('eUnset')
			.addAnnotation(Override)
			.addParameter(int, 'featureID')
			.addModifiers(PUBLIC)
			.addNamedCode('''
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
		val MethodSpec  eGetMethod = MethodSpec.methodBuilder('eGet')
			.addAnnotation(Override)
			.returns(Object)
			.addParameter(int, 'featureID')
			.addParameter(boolean, 'resolve').addParameter(boolean, 'coreType').addModifiers(PUBLIC).addCode('''
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
		val MethodSpec  eIsSetMethod = MethodSpec.methodBuilder('eIsSet')
			.addAnnotation(Override)
			.returns(boolean)
			.addParameter(int, 'featureID')
			.addModifiers(PUBLIC).addCode( '''
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
					
					
			val  eInverseRemove = if (!eClass.EReferences.filter[it.containment || it.EOpposite !== null].empty) {
						val eInverseRemoveCodeMap = newHashMap("il" ->
							ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
							"package" -> ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot), eClass.EPackage.packageInterfaceClassName))
						val reteir = MethodSpec.methodBuilder('eInverseRemove')
							.addAnnotation(Override)
							.returns(NotificationChain).
							addModifiers(PUBLIC)
							.addParameter(ParameterSpec.builder(InternalEObject, 'otherEnd').build).addParameter(
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
						#[reteir]
					} else
						#[]
						val eBasicRemoveFromContainerFeatureFields = eClass.EReferences.filter[field |
							val isMultiple = field.upperBound > 1 || field.upperBound < 0
							val existEOpposite = field.EOpposite !== null
							val isContainment = field.containment
							val isOppositeContainment = existEOpposite && field.EOpposite.containment
							existEOpposite && !isMultiple && !isContainment && isOppositeContainment
						]
				val eBasicRemoveFromContainerFeature = if(!eBasicRemoveFromContainerFeatureFields.empty) {
					val hm = newHashMap("epit" -> ePackageInterfaceType)
					
					for(field: eBasicRemoveFromContainerFeatureFields) {
						hm.put('''type«field.EType.name»'''.toString, ClassName.get(eClass.classInterfacePackageName(packageRoot), field.EType.name))
					}
					
					#[
					MethodSpec.methodBuilder('''eBasicRemoveFromContainerFeature''')
					.addAnnotation(Override)
					.addModifiers(PUBLIC)
					.returns(NotificationChain)
					.addParameter(NotificationChain, 'msgs')
					.addNamedCode('''
					switch (eContainerFeatureID()) {
						«FOR field: eBasicRemoveFromContainerFeatureFields»
						case $epit:T.«field.name.normalizeUpperField(eClass.name)» :
							return eInternalContainer().eInverseRemove(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $type«field.EType.name»:T.class, msgs);
						«ENDFOR»
					}
					return super.eBasicRemoveFromContainerFeature(msgs);
					''', hm)			
					.build		
				]} else #[]
				eInverseRemove + eBasicRemoveFromContainerFeature + #[eGetMethod, eSetMethod, eUnsetMethod, eIsSetMethod]
			} else
				#[]

		val eInverseAdd = if (!eClass.EReferences.filter[it.EOpposite !== null].empty) {
			
			val hm = newHashMap("nc" -> NotificationChain, 
						"epit" -> ePackageInterfaceType,
						"eil" -> ParameterizedTypeName.get(ClassName.get(InternalEList), ClassName.get(InternalEObject)),
						"eilg" -> ParameterizedTypeName.get(ClassName.get(InternalEList), WildcardTypeName.subtypeOf(Object)),
						"ieo" -> TypeName.get(InternalEObject))
						
			for(ref: eClass.EReferences.filter[it.EOpposite !== null]) {
				hm.put('''«ref.name»eOppositeType'''.toString, ClassName.get((ref.EOpposite.eContainer as EClass).classInterfacePackageName(packageRoot), (ref.EOpposite.eContainer as EClass).classInterfaceClassName))
			}

			#[MethodSpec.methodBuilder('eInverseAdd')
				.addAnnotation(Override)
				.returns(NotificationChain)
				.addParameter(InternalEObject, 'otherEnd').addParameter(int, 'featureID').addParameter(NotificationChain, 'msgs').addNamedCode('''
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
			]
		} else
			#[]
				
		val key = eClass.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
		val value = eClass.eContents.filter(EStructuralFeature).filter[it.name == "value"].head

		builder.applyIfTrue(eClass.isAbstract, [addModifiers(ABSTRACT)]).applyIfTrue(hasSuperType, [
			superclass(ClassName.get(superType.classImplementationPackageName(packageRoot), superType.classImplementationClassName))
		]).applyIfTrue(isMapElement, [
			it.addSuperinterface(
				ParameterizedTypeName.get(ClassName.get(BasicEMap.Entry), key.EType.scopedInterfaceTypeRef(packageRoot),
					value.EType.scopedInterfaceTypeRef(packageRoot)))
		])
		.applyIfTrue(!hasSuperType, [superclass(ClassName.get(MinimalEObjectImpl.Container))])
		.applyIfTrue(
			!isMapElement, [
				addSuperinterface(ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName))
			])
			.addFields(fieldsEAttributes + fieldsEReferences)
			.addMethods(#[eStaticClassMethod] + methodsEReferences + eInverseAdd + eSetMethod) // methodsEAttributes
			.applyIfTrue(isMapElement, [
				it.addField(FieldSpec.builder(int, 'hash', PROTECTED).initializer('-1').build).addMethod(
				MethodSpec.methodBuilder('setHash')
					.addParameter(int, 'hash').addCode('''
					this.hash = hash;
				''').addModifiers(PUBLIC).build)
					.addMethod(MethodSpec.methodBuilder('getHash')
					.returns(int)
					.addCode('''
				if (hash == -1) {
					Object theKey = getKey();
					hash = (theKey == null ? 0 : theKey.hashCode());
				}
				return hash;
			''').addModifiers(PUBLIC).build)
		]).applyIfTrue(!eClass.abstract && !isMapElement, [
			addMethod(
				MethodSpec.methodBuilder('accept').
				addAnnotation(Override)
				.addParameter(ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot), namingUtils.visitorInterfaceClassName), 'visitor')
				.addModifiers(PUBLIC)
				.returns(Object)
				.addCode('''
				return visitor.visit«eClass.EPackage.name»__«eClass.name»(this);
				''')
				.build
		)])
	}

	def compileEClassImplementation(EClass eClass, File directory) {
		val factory = TypeSpec
		.classBuilder(eClass.classImplementationClassName)
		.compileEcoreRelated(eClass)
		.addModifiers(PUBLIC)
		.addMethod(MethodSpec.constructorBuilder
			.addCode('''
				super();
			''')
			.addModifiers(PROTECTED)
			.build).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factory)
			.indent('\t')
			.build
		javaFile.writeTo(directory)
	}
	
	


	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def boolean isResolveProxies(EStructuralFeature eStructuralFeature) {
		if(eStructuralFeature instanceof EReference) {
			val isContainer = eStructuralFeature.isContainer
			val isContains = eStructuralFeature.isContainment
			!isContainer && !isContains && eStructuralFeature.isResolveProxies
		} else{
			false
		}
	}
	
	def boolean isListType(ETypedElement eTypedElement) { 
      eTypedElement !== null && (eTypedElement.isMany() || ((eTypedElement instanceof EClass) &&  (eTypedElement as EClass).instanceClassName == "java.util.Map$Entry")) 
	}
}
