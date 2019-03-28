package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.AnnotationSpec
import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
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
import java.util.Comparator
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.common.util.BasicEMap
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecore.util.InternalEList
import org.eclipse.emf.ecoretools.ale.compiler.InterpreterCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.Statement
import org.eclipse.emf.ecoretools.ale.implementation.While
import org.eclipse.xtext.EcoreUtil2

import static javax.lang.model.element.Modifier.*
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassGetterCompiler

class EClassImplementationCompiler {
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	extension InterpreterCompilerUtils = new InterpreterCompilerUtils(namingUtils)
	extension JavaPoetUtils = new JavaPoetUtils
	extension TypeSystemUtils tsu
	extension AleBodyCompiler abc
	val eClassGetterCompiler = new EClassGetterCompiler(namingUtils)
	
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	val String packageRoot
	var Set<Method> registreredDispatch = newHashSet
	var Set<String> registreredArrays = newHashSet
	val List<ResolvedClass> resolved
	
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
	
	new(String packageRoot, List<ResolvedClass> resolved) {
		this.packageRoot = packageRoot
		this.resolved = resolved
	}
	
	private def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass, ExtendedClass aleClass) {
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
				val fieldField = FieldSpec.builder(ParameterizedTypeName.get(ClassName.get(EList), type.box), '''«field.name»''', PROTECTED).build
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
				
			val isMutable = aleClass !== null && aleClass.mutable.exists[it == field.name]
			FieldSpec.builder(fieldType, field.name).applyIfTrue(dsl.dslProp.getOrDefault("child", "false").equals("true") 
				&& !isMultiple && !isMutable 
				&& field.containment
				&& !field.EType.EAnnotations.exists[it.source == 'RuntimeData']
				, [
				addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Child"))
			]).addModifiers(PROTECTED).build
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
							ParameterizedTypeName.get(ClassName.get(EList), rt.box)
						}
					} else {
						ParameterizedTypeName.get(ClassName.get(EList), rt.box)
					}
				} else
					rt

			eClassGetterCompiler.compileGetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement)
		].flatten

		val eStaticClassMethod = MethodSpec.methodBuilder('eStaticClass')
			.addAnnotation(Override)
			.returns(EClass)
			.addModifiers(PROTECTED)
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
				.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
							addModifiers(PUBLIC).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
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
				.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
		]).applyIfTrue(!hasSuperType, [
			if(dsl.dslProp.getOrDefault("truffle", "false") == 'true') {
				if(!eClass.EAnnotations.exists[it.source == 'RuntimeData']) {
					superclass(ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.truffle", "MinimalTruffleEObjectImpl", "TruffleContainer"))
				} else { 
					superclass(ClassName.get(MinimalEObjectImpl.Container))
					}
			} else {
				superclass(ClassName.get(MinimalEObjectImpl.Container))
			}
		]).applyIfTrue(
			!isMapElement, [
				addSuperinterface(ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName))
			])
			.addFields(fieldsEAttributes + fieldsEReferences)
			.addMethods(#[eStaticClassMethod] + methodsEReferences + eInverseAdd + eSetMethod) // methodsEAttributes
			.applyIfTrue(isMapElement, [
				it.addField(FieldSpec.builder(int, 'hash', PROTECTED).initializer('-1').build).addMethod(
				MethodSpec.methodBuilder('setHash')
					.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
					.addParameter(int, 'hash').addCode('''
					this.hash = hash;
				''').addModifiers(PUBLIC).build)
					.addMethod(MethodSpec.methodBuilder('getHash')
					.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
					.returns(int)
					.addCode('''
				if (hash == -1) {
					Object theKey = getKey();
					hash = (theKey == null ? 0 : theKey.hashCode());
				}
				return hash;
			''').addModifiers(PUBLIC).build)
		])
	}
	
	def dispatch compileEClassImplementation(EClassifier eClass, ExtendedClass aleClass, File directory,
		Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices, Dsl dsl, BaseValidator base) {
			
	}

	def dispatch compileEClassImplementation(EClass eClass, ExtendedClass aleClass, File directory,
		Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices, Dsl dsl, BaseValidator base) {
		this.syntaxes = syntaxes
		this.dsl = dsl
		val isTruffle = dsl.dslProp.getOrDefault("truffle", "false") == "true"
		tsu = new TypeSystemUtils(syntaxes, packageRoot, base, resolved)
		abc = new AleBodyCompiler(syntaxes, packageRoot, base, resolved, registreredDispatch, registreredArrays, registeredServices, isTruffle)
		
		val implPackage = eClass.classImplementationPackageName(packageRoot)
		
		
		val aleMethods = if(aleClass !== null) {
			val ret = newArrayList
			for(x : aleClass.methods) {
				ret += x.compile(aleClass, eClass, isTruffle)
			}
			ret
		} else #[]
		
		val whileOps = if(aleClass !== null) {
			EcoreUtil2.getAllContentsOfType(aleClass, While)
		} else #[]
		
		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName).compileEcoreRelated(eClass, aleClass)
			.applyIfTrue(aleClass !== null, [addMethods(aleMethods)])
			.applyIfTrue(isTruffle, [addFields(registreredArrays.map[fieldName|
				val x = eClass.EAllReferences.filter[it.name == fieldName].head.EType.resolveType
				val xa = ArrayTypeName.of(x)
				FieldSpec
					.builder(xa, '''«fieldName»Arr''', PRIVATE)
					.applyIfTrue(isTruffle && !eClass.EAnnotations.exists[it.source == 'RuntimeData'], [addAnnotation(ClassName.get('com.oracle.truffle.api.nodes.Node', 'Children'))])						
					.build
			])])
			.applyIfTrue(isTruffle && !eClass.EAnnotations.exists[it.source == 'RuntimeData'], [
				addAnnotation(
					AnnotationSpec.builder(ClassName.get("com.oracle.truffle.api.nodes", "NodeInfo")).addMember(
						"description", '$S', eClass.name).build
				)
			])
			.applyIfTrue(aleClass !== null, [
				addFields(aleClass.methods.filter [
					it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'
				].map [
					FieldSpec.builder(ClassName.get(eClass.classImplementationPackageName(packageRoot), '''«eClass.name»DispatchWrapper«it.operationRef.name.toFirstUpper»'''), '''cached«it.operationRef.name.toFirstUpper»''')
						.addModifiers(PRIVATE)
						.addAnnotation(ClassName.get('com.oracle.truffle.api.CompilerDirectives', 'CompilationFinal'))
						.build
				])
			])
			.applyIfTrue(aleClass !== null, [
				addMethods(aleClass.methods.filter [
					it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'
				].map [
					MethodSpec.methodBuilder('''getCached«it.operationRef.name.toFirstUpper»''')
						.returns(ClassName.get(eClass.classImplementationPackageName(packageRoot), '''«eClass.name»DispatchWrapper«it.operationRef.name.toFirstUpper»'''))
						.addModifiers(PUBLIC)
						.addCode('''
						return this.cached«it.operationRef.name.toFirstUpper»;
						''')
						.build
				])
			])
			.applyIfTrue(isTruffle, [addFields(registreredDispatch.toList.map[method|
				FieldSpec
					.builder(ClassName.get(implPackage, '''«(method.eContainer as ExtendedClass).normalizeExtendedClassName»Dispatch«method.operationRef.name.toFirstUpper»'''), '''dispatch«(method.eContainer as ExtendedClass).normalizeExtendedClassName»«method.operationRef.name.toFirstUpper»''', PRIVATE)
					.addAnnotation(ClassName.get('com.oracle.truffle.api.nodes.Node', 'Child'))
					.build
			])])
			.addMethod(MethodSpec.constructorBuilder.addCode('''
				super();
				«IF aleClass !== null»
					«FOR method: aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true']»
						this.cached«method.operationRef.name.toFirstUpper» = new «eClass.classImplementationPackageName(packageRoot)».«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»(this);
					«ENDFOR»
					«FOR w:whileOps»
					«ENDFOR»
				«ENDIF»
				«IF isTruffle»
				«FOR method: registreredDispatch.toList»
					this.dispatch«(method.eContainer as ExtendedClass).normalizeExtendedClassName»«method.operationRef.name.toFirstUpper» = «implPackage».«(method.eContainer as ExtendedClass).normalizeExtendedClassName»Dispatch«method.operationRef.name.toFirstUpper»NodeGen.create(); 
				«ENDFOR»
				«ENDIF»
				''')
				.addModifiers(PROTECTED)
				.build
			)
			.addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factory)
			.indent('\t')
			.build
		javaFile.writeTo(directory)
		
		
		generateDispatchClasses(aleClass, directory, eClass)
		generateDispatchWrapperClasses(aleClass, directory, eClass)
		generateRootNodes(aleClass, directory, eClass)

		registreredArrays = newHashSet
		registreredDispatch = newHashSet
	}
	
	def generateRootNodes(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val packageFQN = eClass.classImplementationPackageName(packageRoot)
				val rootNodeName = '''«eClass.name»«method.operationRef.name.toFirstUpper»RootNode'''
				val eClassInterfaceType = ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName)
				val virtualFrameType = ClassName.get('com.oracle.truffle.api.frame', 'VirtualFrame')
				
				val factoryDispatch = TypeSpec
					.classBuilder(rootNodeName)
					.superclass(ClassName.get('com.oracle.truffle.api.nodes', 'RootNode'))
					// TODO: add conditional, must be a child only if it type is a Node
					.addField(FieldSpec
							.builder(eClassInterfaceType, 'it', PRIVATE)
							.addAnnotation(ClassName.get('com.oracle.truffle.api.nodes.Node', 'Child'))
							.build)
					.addMethod(MethodSpec
						.constructorBuilder
						.addParameter(eClassInterfaceType, 'it')
						.addCode('''
							super(null);
							this.it = it;
							''')
						.addModifiers(PUBLIC)
						.build
					)
					.addMethod(MethodSpec
						.methodBuilder('execute')
						.addAnnotation(Override)
						.addParameter(virtualFrameType, 'frame')
						.returns(Object)
						.mapParameters(method)
						.addCode('''
						«IF method.operationRef.EType !== null»return «ENDIF»it.«method.operationRef.name»(«FOR p: method.operationRef.EParameters SEPARATOR ', '»«p.name»«ENDFOR»);
						«IF method.operationRef.EType === null»return null;«ENDIF»
						''')
						.addModifiers(PUBLIC)
						.build
					)
					.addModifiers(PUBLIC)
					.build

				val javaFileDispatch = JavaFile.builder(packageFQN, factoryDispatch)
					.indent('\t')
					.build
				javaFileDispatch.writeTo(directory)

			]
		}
	}
	
	def generateDispatchWrapperClasses(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val packageFQN = eClass.classImplementationPackageName(packageRoot)
				val cyclicAssumptionType = ClassName.get('com.oracle.truffle.api.utilities', 'CyclicAssumption')
				val rootCalltargetType = ClassName.get('com.oracle.truffle.api', 'RootCallTarget')
				val assumptionType = ClassName.get('com.oracle.truffle.api', 'Assumption')
				val truffleType = ClassName.get('com.oracle.truffle.api', 'Truffle')
				val rootNodeName = '''«eClass.name»«method.operationRef.name.toFirstUpper»RootNode'''
				val rootNodeType = ClassName.get(packageFQN, rootNodeName)
				val eClassInterfaceType = ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName)
				
				val name = '''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»_«Math.random * 99999999»'''
				
				/* Look for the closest method that is overriden by the current method and that also has a dispatch annotation */
				val s0 = resolved.filter[eClass.EAllSuperTypes.contains(it.eCls)]
				val s1 = s0.filter[it.aleCls !== null]
				val s2 = s1.map[resolved|
					resolved.aleCls.allMethods.filter[
					it.operationRef.name == method.operationRef.name && method.dispatch
					].map[resolved -> it]
				].flatten

				val overridenMethods = s2.filter[x | x.value.dispatch ]
					.sortWith(new Comparator<Pair<ResolvedClass, Method>>() {
						override compare(Pair<ResolvedClass, Method> arg0, Pair<ResolvedClass, Method> arg1) {
							if(arg0.key.eCls instanceof EClass) {
								val eCls = arg0.key.eCls as EClass
								if(eCls.EAllSuperTypes.contains(arg1.key.eCls)) {
									-1
								} else {
									1
								}
							} else {
								0
							}
						}
					}).head

				val factoryDispatch = TypeSpec.classBuilder(namingUtils.dispatchWrapperClassName(eClass, method))
					.applyIfTrue(overridenMethods !== null, [it.superclass(ClassName.get(packageFQN, namingUtils.dispatchWrapperClassName(overridenMethods.key.eCls as EClass, overridenMethods.value)))])
					.addField(ClassName.get('com.oracle.truffle.api', 'RootCallTarget'), 'callTarget', PRIVATE)
					.addField(cyclicAssumptionType, 'callTargetStable', PRIVATE, FINAL)
					.addMethod(MethodSpec
						.constructorBuilder
						.addParameter(eClassInterfaceType, 'it')
						.addCode('''
						«IF overridenMethods !== null»super(it);«ENDIF»
						this.callTargetStable = new $T($S);
						this.callTarget = $T.getRuntime().createCallTarget(new $T(it));
						''', cyclicAssumptionType, name, truffleType, rootNodeType)
						.addModifiers(PROTECTED)
						.build)
					.addMethod(MethodSpec
						.methodBuilder('getCallTarget')
						.returns(rootCalltargetType)
						.addCode('''return callTarget;''')
						.addModifiers(PUBLIC)
						.build
					)
					.addMethod(MethodSpec
						.methodBuilder('getCallTargetStable')
						.returns(assumptionType)
						.addCode('''return callTargetStable.getAssumption();''')
						.addModifiers(PUBLIC)
						.build
					)
					.addModifiers(PUBLIC)
					.build

				val javaFileDispatch = JavaFile.builder(packageFQN, factoryDispatch)
					.indent('\t')
					.build
				javaFileDispatch.writeTo(directory)

			]
		}
	}
	
	def generateDispatchClasses(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val specializationType = ClassName.get('com.oracle.truffle.api.dsl', 'Specialization')
				val cachedType = ClassName.get('com.oracle.truffle.api.dsl', 'Cached')

				val factoryDispatch = TypeSpec.
					classBuilder('''«eClass.name»Dispatch«method.operationRef.name.toFirstUpper»''').superclass(
						ClassName.get("com.oracle.truffle.api.nodes", "Node")).addField(
						FieldSpec.builder(int, 'INLINE_CACHE_SIZE', PUBLIC, STATIC, FINAL).initializer('3').build).
					addMethod(
						MethodSpec.methodBuilder('''executeDispatch''').addModifiers(PUBLIC, ABSTRACT).
							addParameter(Object, 'function').addParameter(typeof(Object[]), 'arguments').
							returns(Object).build).addMethod(
						MethodSpec.methodBuilder('doDirect').addAnnotation(
							AnnotationSpec.builder(specializationType).
								addMember('limit', '"INLINE_CACHE_SIZE"').addMember('guards',
									'"function.getCallTarget() == cachedTarget"')
								.addMember('assumptions', '"callTargetStable"').build
						).addModifiers(PROTECTED, STATIC).returns(Object).addParameter(
							ParameterSpec.builder(ClassName.get(eClass.classImplementationPackageName(packageRoot), '''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''), 'function').
								build
						).addParameter(typeof(Object[]), 'arguments').addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api', 'Assumption'),
								'callTargetStable').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"function.getCallTargetStable()"')
									.build
							).build
						).addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api', 'RootCallTarget'),
								'cachedTarget').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"function.getCallTarget()"')
									.build
							).build
						).addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api.nodes', 'DirectCallNode'),
								'callNode').addAnnotation(
								AnnotationSpec.builder(cachedType).
									addMember('value', '"create(cachedTarget)"')
									.build
							).build
						)
						.addCode("return callNode.call(arguments);")
						.build
					)
					.addMethod(MethodSpec
						.methodBuilder('doIndirect')
						.addAnnotation(AnnotationSpec
							.builder(specializationType)
							.addMember('replaces', '"doDirect"')
							.build
						)
						.addParameter(
							ParameterSpec.builder(ClassName.get(eClass.classImplementationPackageName(packageRoot), '''«eClass.name»DispatchWrapper«method.operationRef.name.toFirstUpper»'''), 'function').
								build
						)
						.addParameter(typeof(Object[]), 'arguments')
						.addParameter(ParameterSpec
							.builder(ClassName.get('com.oracle.truffle.api.nodes', 'IndirectCallNode'), 'callNode')
							.addAnnotation(AnnotationSpec.builder(cachedType).addMember('value', '"create()"').build)
							.build
						)
						.addCode('''return callNode.call(function.getCallTarget(), arguments);''')
						.returns(Object)
						.addModifiers(PROTECTED, STATIC)
						.build
					)
					.addModifiers(PUBLIC, ABSTRACT).build

				val javaFileDispatch = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factoryDispatch)
					.indent('\t')
					.build
				javaFileDispatch.writeTo(directory)

			]
		}
	}

	def MethodSpec compile(Method method, ExtendedClass aleClass, EClass aClass, boolean isTruffle) {
		val retType =  method.operationRef.EType?.resolveType2 // TODO: DEBUG & correct !!!

		MethodSpec.methodBuilder(method.operationRef.name).addModifiers(PUBLIC).applyIfTrue(retType !== null, [
			returns(retType)
		])
		.applyIfTrue(aClass.EAnnotations.exists[it.source == 'RuntimeData'], [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
		.addParameters(method.operationRef.EParameters.map [
			if (it.EType.instanceClass !== null) {
				if (it.EType instanceof EClass && !(it.EType.EPackage == EcorePackage.eINSTANCE)) {
					ParameterSpec.builder(
						ClassName.get((it.EType as EClass).classInterfacePackageName(packageRoot), (it.EType as EClass).name),
						it.name).build
				} else {
					ParameterSpec.builder(it.EType.instanceClass, it.name).build

				}
			} else {
				ParameterSpec.builder(it.EType.resolveType, it.name).build
			}
		])
		.openMethod(method.operationRef.EType)
		.compileBodyAndPrefix(method.body, new CompilerExpressionCtx('this', aleClass, aClass), isTruffle)
		.closeMethod(method.operationRef.EType).build
		
		
	}
	
	def MethodSpec.Builder compileBodyAndPrefix(MethodSpec.Builder builder, Statement body,
		CompilerExpressionCtx ctx, boolean isTruffle) {
		val cbb = compileBody(CodeBlock.builder, body, ctx)
		if(isTruffle) {
			registreredArrays.fold(builder, [b, array|
			val x = ctx.eClass.EAllReferences.filter[it.name == array].head.EType.resolveType
			b.addStatement(CodeBlock.builder.addNamed('''
			if (this.«array»Arr == null) {
				$cd:T.transferToInterpreterAndInvalidate();
				if (this.«array» != null) this.«array»Arr = this.«array».toArray(new «x»[0]);
				else this.«array»Arr = new «x»[] {};
				
			}
			''', newHashMap("cd" -> ClassName.get("com.oracle.truffle.api","CompilerDirectives"))).build)
		]).addStatement(cbb.build)
		
		} else {
			builder.addCode(cbb.build)
		}
		
	}

	def MethodSpec.Builder closeMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement("return result")
		} else {
			builder
		}
	}
	

	def MethodSpec.Builder openMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement('''$T result''', type.resolveType2)
		} else {
			builder
		}
	}

	def MethodSpec.Builder mapParameters(MethodSpec.Builder builderSeed, Method method) {
		var builder = builderSeed
		for (var i = 0; i < method.operationRef.EParameters.size; i = i + 1) {

			val parameter = method.operationRef.EParameters.get(i)

			val type = if (parameter.EType.instanceClass !== null) {
					if (parameter.EType instanceof EClass && !(parameter.EType.EPackage == EcorePackage.eINSTANCE)) {
						ClassName.get((parameter.EType as EClass).classInterfacePackageName(packageRoot),
							(parameter.EType as EClass).name)
					} else {
						ClassName.get(parameter.EType.instanceClass)
					}
				} else {
					parameter.EType.resolveType
				}
			builder = builder.addStatement('''«type» «parameter.name» = («type») frame.getArguments()[«i»]''')
		}

		return builder
	}

	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def returnType(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			if (type.instanceClass !== null) {
				builder.returns(type.instanceClass)
			} else {
				builder.returns(type.resolveType)
			}
		} else {
			builder
		}
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
