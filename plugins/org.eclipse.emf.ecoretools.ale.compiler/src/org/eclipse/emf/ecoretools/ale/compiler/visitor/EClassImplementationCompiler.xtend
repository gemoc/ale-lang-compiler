package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.common.util.BasicEMap
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.ENotificationImpl
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecore.util.EObjectContainmentEList
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList
import org.eclipse.emf.ecore.util.EcoreEMap
import org.eclipse.emf.ecore.util.EcoreUtil

import static javax.lang.model.element.Modifier.*

class EClassImplementationCompiler {
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension VisitorCompilerUtils = new VisitorCompilerUtils
	extension JavaPoetUtils = new JavaPoetUtils
	val String packageRoot
	
	new(String packageRoot) {
		this.packageRoot = packageRoot
	}

	private def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass) {
		val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
			eClass.EPackage.packageInterfaceClassName)

		val hasSuperType = !eClass.ESuperTypes.empty
		val superType = eClass.ESuperTypes.head

		val fieldsEAttributes = eClass.EAttributes.map [ field |
			val type = field.EType.scopedTypeRef(packageRoot)
			val edefault = FieldSpec.builder(type, '''«field.name.toUpperCase»_EDEFAULT''').
				initializer('''«IF field.defaultValue === null || field.defaultValue.toString == ''»null«ELSE»«field.defaultValue»«ENDIF»''').
				addModifiers(PROTECTED, STATIC, FINAL).build

			val fieldField = FieldSpec.builder(type, field.name.normalizeVarName).initializer('''«field.name.toUpperCase»_EDEFAULT''').
				addModifiers(PROTECTED).build
			#[edefault, fieldField]
		].flatten

		val methodsEAttributes = eClass.EAttributes.map [ field |
			val type = field.EType.scopedTypeRef(packageRoot)

			val getter = MethodSpec.methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').addModifiers(PUBLIC).
				addCode('''return «field.name.normalizeVarName»;''').returns(type).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(
				ParameterSpec.builder(type, field.name.normalizeVarName).build).addCode('''this.«field.name.normalizeVarName» = «field.name.normalizeVarName»;''').
				addModifiers(PUBLIC).build

			#[getter, setter]
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
				
			FieldSpec.builder(fieldType, field.name.normalizeVarName).addModifiers(PROTECTED).build
		]

		val methodsEReferences = eClass.EReferences.map [ field |
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

			val setter = if (!isMultiple) {
					val newName = field.name.normalizeVarNewName
					val oldName = field.name.normalizeVarOldName
					val name = field.name.normalizeVarName

					if (field.EOpposite !== null) {
						if(!field.EOpposite.containment) {
							val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
							.addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
								if («newName» != «name») {
									$1T msgs = null;
									«IF field.EOpposite !== null»
										if («name» != null)
											msgs = (($2T) «name»).eInverseRemove(this, $5T.«field.EOpposite.name.normalizeUpperField((field.EOpposite.eContainer as EClass).name)», «rt».class, msgs);
										if («newName» != null)
											msgs = (($2T) «newName»).eInverseAdd(this, $5T.«field.EOpposite.name.normalizeUpperField((field.EOpposite.eContainer as EClass).name)», «rt».class,
													msgs);
									«ELSE»
										if («name» != null)
											msgs = (($2T) «name»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $5T.«field.name.normalizeUpperField(eClass.name)», null, msgs);
										if («newName» != null)
											msgs = (($2T) «newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - $5T.«field.name.normalizeUpperField(eClass.name)», null, msgs);
									«ENDIF»
									msgs = basicSet«name.toFirstUpper»(«newName», msgs);
									if (msgs != null)
										msgs.dispatch();
								} else if (eNotificationRequired())
									eNotify(new $3T(this, $4T.SET, $5T.«field.name.normalizeUpperField(eClass.name)», «newName», «newName»));
							''', NotificationChain, InternalEObject, ENotificationImpl, Notification,
								ePackageInterfaceType).addModifiers(PUBLIC).build
							val basicSetMethod = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''')
							.returns(
								NotificationChain).addParameter(
								ParameterSpec.builder(fieldType, field.name.normalizeVarNewName).build).addParameter(
								ParameterSpec.builder(NotificationChain, 'msgsp').build).addCode('''
								$1T msgs = msgsp;
								$2T «oldName» = «name»;
								«name» = «newName»;
								if (eNotificationRequired()) {
									$3T notification = new $3T(this, $4T.SET, $5T.«field.name.normalizeUpperField(eClass.name)»,
											«oldName», «newName»);
									if (msgs == null)
										msgs = notification;
									else
										msgs.add(notification);
								}
								return msgs;
							''', NotificationChain, fieldType, ENotificationImpl, Notification,
								ePackageInterfaceType).addModifiers(PRIVATE).build
							
								#[setter, basicSetMethod]
							} else {
								val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
								.addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
								if («newName» != eInternalContainer() || (eContainerFeatureID() != $1T.«field.name.normalizeUpperField(eClass.name)» && «newName» != null)) {
									if ($2T.isAncestor(this, «newName»))
										throw new $3T("Recursive containment not allowed for " + toString());
									$4T msgs = null;
									if (eInternalContainer() != null)
										msgs = eBasicRemoveFromContainer(msgs);
									if («newName» != null)
										msgs = (($5T)«newName»).eInverseAdd(this, $1T.«field.name.normalizeUpperField(eClass.name)» , $6T.class, msgs);
									msgs = basicSetFsm(«newName», msgs);
									if (msgs != null) msgs.dispatch();
								}
								else if (eNotificationRequired())
									eNotify(new $7T(this, $8T.SET, $1T.«field.name.normalizeUpperField(eClass.name)» , «newName», «newName»));
							''', ePackageInterfaceType, EcoreUtil, IllegalArgumentException, NotificationChain, InternalEObject, fieldType, ENotificationImpl, Notification).addModifiers(PUBLIC).build
							
							val basicSetMethod = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''')
							.returns(
								NotificationChain).addParameter(
								ParameterSpec.builder(fieldType, field.name.normalizeVarNewName).build).addParameter(
								ParameterSpec.builder(NotificationChain, 'msgs').build).addCode('''
								msgs = eBasicSetContainer(($1T)newFsm, $2T.«field.name.normalizeUpperField(eClass.name)», msgs);
								return msgs;
							''', InternalEObject, ePackageInterfaceType).addModifiers(PRIVATE).build
							#[setter, basicSetMethod]
							}

						
						
					} else {
						if(field.containment) {
							val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
							.addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
							if («newName» != «field.name.normalizeVarName») {
								$4T msgs = null;
								if («field.name.normalizeVarName» != null)
									msgs = (($1T)«field.name.normalizeVarName»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
								if («newName» != null)
									msgs = (($1T)«newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
								msgs = basicSet«field.name.toFirstUpper»(«newName.normalizeVarName», msgs);
								if (msgs != null) msgs.dispatch();
							}
							else if (eNotificationRequired())
								eNotify(new $2T(this, $3T.SET, «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», «newName», «newName»));
						''', InternalEObject, ENotificationImpl, Notification, NotificationChain).addModifiers(PUBLIC).build
						val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''')
						.returns(NotificationChain)
							.addParameter(ParameterSpec.builder(fieldType, newName).build)
							.addParameter(ParameterSpec.builder(NotificationChain, 'msgs').build)
							.addCode('''
							$1T «oldName» = «field.name.normalizeVarName»;
							«field.name.normalizeVarName» = «newName»;
							if (eNotificationRequired()) {
								$2T notification = new $2T(this, $3T.SET, «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», «oldName», «newName»);
								if (msgs == null) msgs = notification; else msgs.add(notification);
							}
							return msgs;
							''', fieldType, ENotificationImpl, Notification)
							.addModifiers(PUBLIC)
						.build // TODO + taking into account into eSet/eGet implementation
						
							#[setter, basicSetter]
						} else { 
							val isMapValueField = (field.eContainer as EClass).instanceClass !== null && (field.eContainer as EClass).instanceClass == Map.Entry && field.name == "value"
							if(isMapValueField) {
								val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
								.returns(
									fieldType).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
									$1T «oldName» = this.«field.name.normalizeVarName»;
									this.«field.name.normalizeVarName» = «newName»;
									return «oldName»;
								''', fieldType).
									addModifiers(PUBLIC).build
		
								#[setter]						
							} else {
								val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(
									ParameterSpec.builder(fieldType, newName).build).addCode('''
									$1T «oldName» = «field.name.normalizeVarName»;
									«field.name.normalizeVarName» = «newName»;
									if (eNotificationRequired())
										eNotify(new $2T(this, $3T.SET, $4T.«field.name.normalizeUpperField(eClass.name)», «oldName», «field.name.normalizeVarName»));
								''', fieldType, ENotificationImpl, Notification,
									ePackageInterfaceType).addModifiers(PUBLIC).build
		
								#[setter]
							
							}
						
						}
					}

				} else
					#[]

			val getter = if (isMultiple) {
				if(ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
					val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
					val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
					MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
							addModifiers(PUBLIC).addCode('''
								if («field.name.normalizeVarName» == null) {
									«field.name.normalizeVarName» = new $1T($2T.Literals.«(field.EType as EClass).name.normalizeUpperField», $3T.class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
								}
								return «field.name.normalizeVarName»;
							''', ParameterizedTypeName.get(ClassName.get(EcoreEMap), key.EType.scopedInterfaceTypeRef(packageRoot), value.EType.scopedInterfaceTypeRef(packageRoot)), ePackageInterfaceType,
							ClassName.get((field.EType as EClass).classImplementationPackageName(packageRoot), (field.EType as EClass).classImplementationClassName)).build
							// EcoreEMap<String,EvalRes>
				}
					else if(field.EOpposite !== null) {
						MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
							addModifiers(PUBLIC).addCode('''
								if («field.name.normalizeVarName» == null) {
									«field.name.normalizeVarName» = new $1T($2T.class, this, $3T.«field.name.normalizeUpperField(eClass.name)», $3T.«field.EOpposite.name.normalizeUpperField((field.EOpposite.eContainer as EClass).name)»);
								}
								return «field.name.normalizeVarName»;
							''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentWithInverseEList), rt), rt, ePackageInterfaceType).build
					} else {
						MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
							addModifiers(PUBLIC).addCode('''
								if(«field.name.normalizeVarName» == null) {
									«field.name.normalizeVarName» = new $1T(«rt».class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
								}
								return «field.name.normalizeVarName»;
							''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList), rt),
								ePackageInterfaceType).build
					}
				} else {
					if(field.EOpposite !== null && field.EOpposite.containment) {
						MethodSpec.methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').returns(fieldType).
						addModifiers(PUBLIC).addCode('''
						if (eContainerFeatureID() != $1T.«field.name.normalizeUpperField(eClass.name)») return null;
						return ($2T)eInternalContainer();
						''', ePackageInterfaceType, fieldType).build
					}  else {
						MethodSpec.methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').returns(fieldType).
							addModifiers(PUBLIC).addCode('''return «field.name.normalizeVarName»;''').build
					}
				}

			setter + #[getter]
		].flatten

		val eStaticClassMethod = MethodSpec.methodBuilder('eStaticClass').returns(EClass).addModifiers(PROTECTED).
			addCode('''return $1T.Literals.«eClass.name.normalizeUpperField»;''', ePackageInterfaceType).build

		val eSetMethod = MethodSpec.methodBuilder('eSet').addParameter(int, 'featureID').addParameter(Object, 'newValue').addModifiers(PUBLIC).addCode( '''
			switch (featureID) {
			«FOR esf : eClass.EStructuralFeatures»
				case $1T.«esf.name.normalizeUpperField(eClass.name)»:
					«IF esf instanceof EAttribute»
						set«esf.name.toFirstUpper»((«esf.EType.scopedTypeRef(packageRoot)») newValue);
					«ELSE»
						«IF esf.upperBound <= 1 && esf.upperBound >= 0»
							set«esf.name.toFirstUpper»((«(esf.EGenericType.ERawType as EClass).classInterfacePackageName(packageRoot)».«(esf.EGenericType.ERawType as EClass).classInterfaceClassName») newValue);
						«ELSE»
							«IF (esf.EType.instanceClass !== null && esf.EType.instanceClass == Map.Entry)»
								((org.eclipse.emf.ecore.EStructuralFeature.Setting)get«esf.name.toFirstUpper»()).set(newValue);
							«ELSE»
							get«esf.name.toFirstUpper»().clear();
							get«esf.name.toFirstUpper»().addAll((java.util.Collection<? extends «(esf.EType as EClass).classInterfacePackageName(packageRoot)».«(esf.EType as EClass).classInterfaceClassName»>) newValue);
							«ENDIF»
						«ENDIF»
					«ENDIF»
				return;
			«ENDFOR»
			}
			super.eSet(featureID, newValue);
		''', ePackageInterfaceType).build

		val eUnsetMethod = MethodSpec.methodBuilder('eUnset').addParameter(int, 'featureID').addModifiers(PUBLIC).
			addCode('''
				switch (featureID) {
				«FOR esf : eClass.EStructuralFeatures»
					case $1T.«esf.name.normalizeUpperField(eClass.name)»:
						«IF esf instanceof EAttribute»
							set«esf.name.toFirstUpper»(«esf.name.toUpperCase»_EDEFAULT);
						«ELSE»
							«IF esf.upperBound <= 1 && esf.upperBound >= 0»
								set«esf.name.toFirstUpper»((«(esf.EGenericType.ERawType as EClass).classInterfacePackageName(packageRoot)».«(esf.EGenericType.ERawType as EClass).classInterfaceClassName») null);
							«ELSE»
								get«esf.name.toFirstUpper»().clear();
							«ENDIF»
						«ENDIF»
					return;
				«ENDFOR»
				}
				super.eUnset(featureID);
			''', ePackageInterfaceType).build

		val eGetMethod = MethodSpec.methodBuilder('eGet').returns(Object).addParameter(int, 'featureID').
			addParameter(boolean, 'resolve').addParameter(boolean, 'coreType').addModifiers(PUBLIC).addCode('''
				switch (featureID) {
				«FOR esf : eClass.EStructuralFeatures»
					case $1T.«esf.name.normalizeUpperField(eClass.name)»:
					«IF esf.EType.instanceClass !== null && esf.EType.instanceClass == Map.Entry»
					if (coreType)
						return get«esf.name.toFirstUpper»();
					else
						return get«esf.name.toFirstUpper»().map();
					«ELSE»
						return «IF esf.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«esf.name.toFirstUpper»();
					«ENDIF»
				«ENDFOR»
				}
				return super.eGet(featureID, resolve, coreType);
			''', ePackageInterfaceType).build

		val eIsSetMethod = MethodSpec.methodBuilder('eIsSet').returns(boolean).addParameter(int, 'featureID').
			addModifiers(PUBLIC).addCode( '''
				switch (featureID) {
				«FOR esf : eClass.EStructuralFeatures»
					case $1T.«esf.name.normalizeUpperField(eClass.name)»:
						«IF esf instanceof EAttribute»
							return «esf.name» != «esf.name.toUpperCase»_EDEFAULT;
						«ELSE»
							«IF esf.upperBound <= 1»
								«IF (esf as EReference).EOpposite !== null && (esf as EReference).EOpposite.containment»
								return get«esf.name.toFirstUpper»() != null;
								«ELSE»
								«IF esf.upperBound == 0 || esf.upperBound == 1»
								return «esf.name» != null;
								«ELSE»
								return «esf.name» != null && !«esf.name».isEmpty();
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

		val eInverseAdd = if (!eClass.EReferences.filter[it.EOpposite !== null].empty) {
				#[
					MethodSpec.methodBuilder('eInverseAdd').returns(NotificationChain)
					.addParameter(InternalEObject,
						'otherEnd').addParameter(int, 'featureID').addParameter(NotificationChain, 'msgs2').addCode('''
						$1T msgs = msgs2;
						switch (featureID) {
						«FOR ref : eClass.EReferences.filter[it.EOpposite !== null]»
							
							case $2T.«ref.name.normalizeUpperField(eClass.name)»:
								«IF ref.upperBound == 0 || ref.upperBound == 1»
									«IF ref.EOpposite !== null && ref.EOpposite.containment»
									if (eInternalContainer() != null)
											msgs = eBasicRemoveFromContainer(msgs);
										return basicSetFsm((«(ref.EType as EClass).classInterfacePackageName(packageRoot)».«(ref.EType as EClass).classInterfaceClassName»)otherEnd, msgs);
									«ELSE»
									if («ref.name» != null)
										msgs = ((org.eclipse.emf.ecore.InternalEObject) «ref.name»).eInverseRemove(this, $2T.«ref.EOpposite.name.normalizeUpperField((ref.EOpposite.eContainer as EClass).name)», «(ref.EOpposite.eContainer as EClass).name».class,
												msgs);
									return basicSet«ref.name.toFirstUpper»((«(ref.EOpposite.eContainer as EClass).classInterfacePackageName(packageRoot)».«(ref.EOpposite.eContainer as EClass).classInterfaceClassName») otherEnd, msgs);
									«ENDIF»
								«ELSE»
									return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) get«ref.name.toFirstUpper»()).basicAdd(otherEnd, msgs);
								«ENDIF»
						«ENDFOR»
						}
						return super.eInverseAdd(otherEnd, featureID, msgs);
					''', NotificationChain, ePackageInterfaceType).addModifiers(PUBLIC).build
				]
			} else
				#[]
				
				
		val eInverseRemove = MethodSpec.methodBuilder('eInverseRemove').returns(NotificationChain).addModifiers(PUBLIC).
			addParameter(ParameterSpec.builder(InternalEObject, 'otherEnd').build).addParameter(
				ParameterSpec.builder(int, 'featureID').build).addParameter(
				ParameterSpec.builder(NotificationChain, 'msgs').build).addCode('''
				switch(featureID) {
				«FOR ref: eClass.EReferences.filter[it.containment]»
				case «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«ref.name.normalizeUpperField(eClass.name)»:
					«IF ref.upperBound == 0 || ref.upperBound == 1»
					return basicSet«ref.name.toFirstUpper»(null, msgs);
					«ELSE»
					return ((org.eclipse.emf.ecore.util.InternalEList<?>) get«ref.name.toFirstUpper»()).basicRemove(otherEnd, msgs);
					«ENDIF»
				«ENDFOR»
				}
				return super.eInverseRemove(otherEnd, featureID, msgs);
			''').build
				
		val constructor = MethodSpec.constructorBuilder.addCode('''
			super();
		''').addModifiers(PROTECTED).build

		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
		val key = eClass.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
		val value = eClass.eContents.filter(EStructuralFeature).filter[it.name == "value"].head

		builder.applyIfTrue(eClass.isAbstract, [addModifiers(ABSTRACT)]).applyIfTrue(hasSuperType, [
			superclass(
				ClassName.get(superType.classImplementationPackageName(packageRoot),
					superType.classImplementationClassName))
		]).applyIfTrue(isMapElement, [
			it.addSuperinterface(
				ParameterizedTypeName.get(ClassName.get(BasicEMap.Entry), key.EType.scopedInterfaceTypeRef(packageRoot),
					value.EType.scopedInterfaceTypeRef(packageRoot)))
		]).applyIfTrue(!hasSuperType, [
			superclass(ClassName.get(MinimalEObjectImpl.Container))
		]).applyIfTrue(!isMapElement, [
			addSuperinterface(
				ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName))
		]).addFields(fieldsEAttributes + fieldsEReferences).addMethods(
			methodsEAttributes + methodsEReferences +
				#[eStaticClassMethod, eSetMethod, eUnsetMethod, eGetMethod, eIsSetMethod, constructor, eInverseRemove] +
				eInverseAdd).applyIfTrue(isMapElement, [
			it.addField(FieldSpec.builder(int, 'hash', PROTECTED).initializer('-1').build).addMethod(
				MethodSpec.methodBuilder('setHash').addParameter(int, 'hash').addCode('''
					this.hash = hash;
				''').addModifiers(PUBLIC).build).addMethod(MethodSpec.methodBuilder('getHash').returns(int).addCode('''
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
				.addParameter(
					ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot),
						namingUtils.visitorInterfaceClassName), 'visitor').addModifiers(PUBLIC).returns(Object).
					addCode('''return visitor.visit«eClass.EPackage.name»__«eClass.name»(this);''').build
		)])
	}

	def compileEClassImplementation(EClass eClass, File directory) {
		
		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName).compileEcoreRelated(eClass).
			addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factory)
			.indent('\t')
			.build
		javaFile.writeTo(directory)
	}
}
