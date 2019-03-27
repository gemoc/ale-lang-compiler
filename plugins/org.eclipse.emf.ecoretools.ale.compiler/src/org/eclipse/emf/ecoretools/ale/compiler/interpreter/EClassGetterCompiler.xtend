package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import java.util.List
import java.util.Map
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.ENotificationImpl
import org.eclipse.emf.ecore.util.EDataTypeEList
import org.eclipse.emf.ecore.util.EObjectContainmentEList
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList
import org.eclipse.emf.ecore.util.EcoreEMap
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.InterpreterCompilerUtils
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class EClassGetterCompiler {

	extension JavaPoetUtils = new JavaPoetUtils
	extension AbstractNamingUtils namingUtils 
	extension InterpreterCompilerUtils icu
	
	new(AbstractNamingUtils namingUtils) {
		this.namingUtils = namingUtils
		this.icu = new InterpreterCompilerUtils(namingUtils)
	}

	def dispatch List<MethodSpec> compileGetter(EAttribute field, TypeName fieldType, String packageRoot, EClass eClass,
		Dsl dsl, ClassName ePackageInterfaceType, boolean isMapElement) {
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		if (!isMultiple) {
			val getter = MethodSpec.
				methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
				returns(fieldType).addCode('''
					return «field.name.normalizeVarName»;
				''').addModifiers(PUBLIC).build

			val hm = newHashMap(
				"ft" -> fieldType,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification),
				"epit" -> ePackageInterfaceType
			)

			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').
				addParameter(fieldType, '''new«field.name.toFirstUpper»''').addNamedCode('''
					$ft:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
					«IF field.EType instanceof EEnum»
					«field.name.normalizeVarName» = «field.name.normalizeVarNewName» == null ? «field.name.toUpperCase»_EDEFAULT : «field.name.normalizeVarNewName»;
					«ELSE»
					«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
					«ENDIF»
					if (eNotificationRequired())
						eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.name.normalizeUpperField(eClass.name)», old«field.name.toFirstUpper», «field.name.normalizeVarName»));
				''', hm).addModifiers(PUBLIC).build

			#[getter, setter]
		} else {
			val hm = newHashMap(
				"listtype" -> ParameterizedTypeName.get(ClassName.get(EDataTypeEList), rt.box),
				"rt" -> rt,
				"epit" -> ePackageInterfaceType
			)
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').
				returns(fieldType).addNamedCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $listtype:T($rt:T.class, this, $epit:T.«field.name.normalizeUpperField(eClass.name)»);
					}
					return «field.name.normalizeVarName»;
				''',hm).addModifiers(PUBLIC).build
			#[getter]
		}

	}

	def dispatch List<MethodSpec> compileGetter(EReference field, TypeName fieldType, String packageRoot, EClass eClass,
		Dsl dsl, ClassName ePackageInterfaceType, boolean isMapElement) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		val existEOpposite = field.EOpposite !== null
		val isOppositeMulti = existEOpposite && (field.EOpposite.upperBound > 1 || field.EOpposite.upperBound < 0)
		val isContainment = field.containment
		val isOppositeContainment = existEOpposite && field.EOpposite.containment

		if (existEOpposite && !isMultiple && !isContainment && !isOppositeContainment) { // && !isContainer
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(rt).addNamedCode('''
				if («field.name.normalizeVarName» != null && «field.name.normalizeVarName».eIsProxy()) {
					$ieo:T «field.name.normalizeVarOldName» = ($ieo:T) «field.name.normalizeVarName»;
					«field.name.normalizeVarName» = ($fieldType:T) eResolveProxy(«field.name.normalizeVarOldName»);
					if («field.name.normalizeVarName» != «field.name.normalizeVarOldName») {
						if (eNotificationRequired())
							eNotify(new $eni:T(this, $notif:T.RESOLVE, $epit:T.«field.name.normalizeUpperField(eClass.name)», «field.name.normalizeVarOldName», «field.name.normalizeVarName»));
					}
				}
				return «field.name.normalizeVarName»;
			''', newHashMap(
				"ieo" -> ClassName.get(InternalEObject),
				"fieldType" -> rt,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification),
				"epit" -> ePackageInterfaceType
			)).addModifiers(PUBLIC).build
			val basicGetter = MethodSpec.methodBuilder('''basicGet«field.name.toFirstUpper»''').returns(rt).addCode('''
				return «field.name.normalizeVarName»;
			''').addModifiers(PUBLIC).build
			val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').returns(
				NotificationChain).addParameter(rt, '''«field.name.normalizeVarNewName»''').addParameter(NotificationChain,
				'msgs').addModifiers(PUBLIC).addNamedCode('''
				$fieldType:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
				«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
				if (eNotificationRequired()) {
					$eni:T notification = new $eni:T(this, $notif:T.SET, $epit:T.«field.name.normalizeUpperField(eClass.name)», «field.name.normalizeVarOldName», «field.name.normalizeVarNewName»);
					if (msgs == null)
						msgs = notification;
					else
						msgs.add(notification);
				}
				return msgs;
			''', newHashMap(
				"fieldType" -> rt,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification),
				"epit" -> ePackageInterfaceType
			)).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').
				addParameter(rt, '''«field.name.normalizeVarNewName»''').addNamedCode('''
					if («field.name.normalizeVarNewName» != «field.name.normalizeVarName») {
						$nc:T msgs = null;
						if («field.name.normalizeVarName» != null)
							msgs = (($ieo:T) «field.name.normalizeVarName»).eInverseRemove(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $fieldType:T.class, msgs);
						if («field.name.normalizeVarNewName» != null)
							msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $fieldType:T.class, msgs);
						msgs = basicSet«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
						if (msgs != null)
							msgs.dispatch();
					} else if (eNotificationRequired())
						eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.name.normalizeUpperField(eClass.name)», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
				''', newHashMap(
					"nc" -> ClassName.get(NotificationChain),
					"ieo" -> ClassName.get(InternalEObject),
					"epit" -> ePackageInterfaceType,
					"fieldType" -> rt,
					"eni" -> ClassName.get(ENotificationImpl),
					"notif" -> ClassName.get(Notification)
				)).addModifiers(PUBLIC).build
			#[getter, basicGetter, basicSetter, setter]
		} else if (existEOpposite && !isMultiple && !isContainment && isOppositeContainment) {
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''')
				.returns(rt)
				.addNamedCode('''
				if (eContainerFeatureID() != $epit:T.«field.name.normalizeUpperField(eClass.name)»)
					return null;
				return ($fieldType:T) eInternalContainer();
				''', newHashMap(
					"fieldType" -> rt,
					"epit" -> ePackageInterfaceType
				))
				.addModifiers(PUBLIC)
				.build
			val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''')
				.returns(NotificationChain)
				.addParameter(rt, field.name.normalizeVarNewName)
				.addParameter(NotificationChain, 'msgs')
				.addNamedCode('''
				msgs = eBasicSetContainer(($ieo:T) «field.name.normalizeVarNewName», $epit:T.«field.name.normalizeUpperField(eClass.name)», msgs);
				return msgs;
				''', newHashMap(
					"epit" -> ePackageInterfaceType,
					"ieo" -> ClassName.get(InternalEObject)
				))
				.addModifiers(PUBLIC)
				.build
				
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
				.addParameter(rt, field.name.normalizeVarNewName)
				.addNamedCode('''
				if («field.name.normalizeVarNewName» != eInternalContainer() || (eContainerFeatureID() != $epit:T.«field.name.normalizeUpperField(eClass.name)» && «field.name.normalizeVarNewName» != null)) {
					if ($eu:T.isAncestor(this, «field.name.normalizeVarNewName»))
						throw new $iae:T("Recursive containment not allowed for " + toString());
					$nc:T msgs = null;
					if (eInternalContainer() != null)
						msgs = eBasicRemoveFromContainer(msgs);
					if («field.name.normalizeVarNewName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $fieldType:T.class, msgs);
					msgs = basicSet«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
					if (msgs != null)
						msgs.dispatch();
				} else if (eNotificationRequired())
					eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.name.normalizeUpperField(eClass.name)», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
				''', newHashMap(
					"epit" -> ePackageInterfaceType,
					"eu" -> ClassName.get(EcoreUtil),
					"iae" -> ClassName.get(IllegalArgumentException),
					"nc" -> ClassName.get(NotificationChain),
					"ieo" -> ClassName.get(InternalEObject),
					"fieldType" -> rt,
					"eni" -> ClassName.get(ENotificationImpl),
					"notif" -> ClassName.get(Notification)
				))
				.addModifiers(PUBLIC)
				.build 
			#[getter, basicSetter, setter]			// TODO: adding a eBasicRemoveFromContainerFeature operation on the class additionnaly.
		} else if (existEOpposite && !isMultiple && isContainment && !isOppositeContainment) {
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(rt).addCode('''
				return «field.name.normalizeVarName»;
			''').addModifiers(PUBLIC).build
			val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').returns(
				NotificationChain).addParameter(rt, '''«field.name.normalizeVarNewName»''').addParameter(NotificationChain,
				'msgs').addModifiers(PUBLIC).addNamedCode('''
				$fieldType:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
				«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
				if (eNotificationRequired()) {
					$eni:T notification = new $eni:T(this, $notif:T.SET, $epit:T.«field.name.normalizeUpperField(eClass.name)», «field.name.normalizeVarOldName», «field.name.normalizeVarNewName»);
					if (msgs == null)
						msgs = notification;
					else
						msgs.add(notification);
				}
				return msgs;
			''', newHashMap(
				"fieldType" -> rt,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification),
				"epit" -> ePackageInterfaceType
			)).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').
				addParameter(rt, '''«field.name.normalizeVarNewName»''').addNamedCode('''
					if («field.name.normalizeVarNewName» != «field.name.normalizeVarName») {
						$nc:T msgs = null;
						if («field.name.normalizeVarName» != null)
							msgs = (($ieo:T) «field.name.normalizeVarName»).eInverseRemove(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $fieldType:T.class, msgs);
						if («field.name.normalizeVarNewName» != null)
							msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)», $fieldType:T.class, msgs);
						msgs = basicSet«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
						if (msgs != null)
							msgs.dispatch();
					} else if (eNotificationRequired())
						eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.name.normalizeUpperField(eClass.name)», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
				''', newHashMap(
					"nc" -> ClassName.get(NotificationChain),
					"ieo" -> ClassName.get(InternalEObject),
					"epit" -> ePackageInterfaceType,
					"fieldType" -> rt,
					"eni" -> ClassName.get(ENotificationImpl),
					"notif" -> ClassName.get(Notification)
				)).addModifiers(PUBLIC).build
			#[getter, basicSetter, setter]
		} else if (existEOpposite && isMultiple && !isOppositeMulti && !isContainment && !isOppositeContainment) {
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
				addNamedCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $eowrel:T($ft:T.class, this, $epit:T.«field.name.normalizeUpperField(eClass.name)», $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)»);
					}
					return «field.name.normalizeVarName»;
				''', newHashMap(
					"eowrel" -> ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList), rt),
					"ft" -> rt,
					"epit" -> ePackageInterfaceType
				)).addModifiers(PUBLIC).build
			#[getter]
		} else if (existEOpposite && isMultiple && isOppositeMulti && !isContainment && !isOppositeContainment) {
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
				addNamedCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $eowrel:T($ft:T.class, this, $epit:T.«field.name.normalizeUpperField(eClass.name)», $epit:T.«field.EOpposite.name.normalizeUpperField(field.EOpposite.EContainingClass.name)»);
					}
					return «field.name.normalizeVarName»;
				''', newHashMap(
					"eowrel" ->
						ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList.ManyInverse), rt),
					"ft" -> rt,
					"epit" -> ePackageInterfaceType
				)).addModifiers(PUBLIC).build
			#[getter]
		} else {
			val setters = this.legacyCompileSetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType,
				isMapElement)
			val getter = this.legacyCompileGetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType)

			(setters + #[getter]).toList
		}
	}

	def legacyCompileSetter(EReference field, TypeName fieldType, String packageRoot, EClass eClass, Dsl dsl,
		ClassName ePackageInterfaceType, boolean isMapElement) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		if (!isMultiple) {
			val newName = '''«field.name.normalizeVarNewName»'''
			val oldName = '''«field.name.normalizeVarOldName»'''
			val name = field.name.normalizeVarName

			if (field.EOpposite !== null) {
				if (!field.EOpposite.containment) {
					val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').applyIfTrue(
						dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
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
					''', NotificationChain, InternalEObject, ENotificationImpl, Notification, ePackageInterfaceType).
						addModifiers(PUBLIC).build
					val basicSetMethod = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').applyIfTrue(
						dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).returns(NotificationChain).addParameter(
						ParameterSpec.builder(fieldType, '''«field.name.normalizeVarNewName»''').build).addParameter(
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
					''', NotificationChain, fieldType, ENotificationImpl, Notification, ePackageInterfaceType).
						addModifiers(PRIVATE).build

					#[setter, basicSetMethod]
				} else {
					val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').applyIfTrue(
						dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
						if («newName» != eInternalContainer() || (eContainerFeatureID() != $1T.«field.name.normalizeUpperField(eClass.name)» && «newName» != null)) {
							if ($2T.isAncestor(this, «newName»))
								throw new $3T("Recursive containment not allowed for " + toString());
							$4T msgs = null;
							if (eInternalContainer() != null)
								msgs = eBasicRemoveFromContainer(msgs);
							if («newName» != null)
								msgs = (($5T)«newName»).eInverseAdd(this, $1T.«field.EOpposite.name.normalizeUpperField((field.eContainer as EClass).name)» , $6T.class, msgs);
							msgs = basicSet«field.name.toFirstUpper»(«newName», msgs);
							if (msgs != null) msgs.dispatch();
						}
						else if (eNotificationRequired())
							eNotify(new $7T(this, $8T.SET, $1T.«field.name.normalizeUpperField(eClass.name)» , «newName», «newName»));
					''', ePackageInterfaceType, EcoreUtil, IllegalArgumentException, NotificationChain, InternalEObject,
						fieldType, ENotificationImpl, Notification).addModifiers(PUBLIC).build

					val basicSetMethod = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').applyIfTrue(
						dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).returns(NotificationChain).addParameter(
						ParameterSpec.builder(fieldType, '''«field.name.normalizeVarNewName»''').build).addParameter(
						ParameterSpec.builder(NotificationChain, 'msgs').build).addCode('''
						msgs = eBasicSetContainer(($1T) «field.name.normalizeVarNewName», $2T.«field.name.normalizeUpperField(eClass.name)», msgs);
						return msgs;
					''', InternalEObject, ePackageInterfaceType).addModifiers(PUBLIC).build
					#[setter, basicSetMethod]
				}

			} else {
				if (field.containment) {
					val isEnum = field.EType instanceof EEnum
					val setter = if (isMapElement) {
							MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
								dsl.dslProp.getProperty('truffle', "false") == "true", [
									addAnnotation(
										ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
								]).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
								«IF isEnum»«ENDIF»
								$5T «oldName» = «field.name.normalizeVarName»;
								if («newName» != «field.name.normalizeVarName») {
									$4T msgs = null;
									if («field.name.normalizeVarName» != null)
										msgs = (($1T) «field.name.normalizeVarName»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
									if («newName» != null)
										msgs = (($1T)«newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
									msgs = basicSet«field.name.toFirstUpper»(«newName», msgs);
									if (msgs != null) msgs.dispatch();
								}
								else if (eNotificationRequired())
									eNotify(new $2T(this, $3T.SET, «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», «newName», «newName»));
								return «oldName»;
							''', InternalEObject, ENotificationImpl, Notification, NotificationChain, fieldType).
								addModifiers(PUBLIC).build
						} else {
							MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').applyIfTrue(
								dsl.dslProp.getProperty('truffle', "false") == "true", [
									addAnnotation(
										ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
								]).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
								«IF isEnum»«ENDIF»
								if («newName» != «field.name.normalizeVarName») {
									$4T msgs = null;
									if («field.name.normalizeVarName» != null)
										msgs = (($1T) «field.name.normalizeVarName»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
									if («newName» != null)
										msgs = (($1T)«newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
									msgs = basicSet«field.name.toFirstUpper»(«newName», msgs);
									if (msgs != null) msgs.dispatch();
								}
								else if (eNotificationRequired())
									eNotify(new $2T(this, $3T.SET, «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», «newName», «newName»));
							''', InternalEObject, ENotificationImpl, Notification, NotificationChain).
								addModifiers(PUBLIC).build
						}
					val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').applyIfTrue(
						dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).returns(NotificationChain).addParameter(ParameterSpec.builder(fieldType, newName).build).
						addParameter(ParameterSpec.builder(NotificationChain, 'msgs').build).addCode('''
							$1T «oldName» = «field.name.normalizeVarName»;
							«field.name.normalizeVarName» = «newName»;
							if (eNotificationRequired()) {
								$2T notification = new $2T(this, $3T.SET, «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», «oldName», «newName»);
								if (msgs == null) msgs = notification; else msgs.add(notification);
							}
							return msgs;
						''', fieldType, ENotificationImpl, Notification).addModifiers(PUBLIC).build

					#[setter, basicSetter]
				} else {
					val isMapValueField = (field.eContainer as EClass).instanceClass !== null &&
						(field.eContainer as EClass).instanceClass == Map.Entry && field.name == "value"
					if (isMapValueField) {
						val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').applyIfTrue(
							dsl.dslProp.getProperty('truffle', "false") == "true", [
								addAnnotation(
									ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
							]).returns(fieldType).addParameter(ParameterSpec.builder(fieldType, newName).build).
							addCode('''
								$1T «oldName» = this.«field.name.normalizeVarName»;
								this.«field.name.normalizeVarName» = «newName»;
								return «oldName»;
							''', fieldType).addModifiers(PUBLIC).build

						#[setter]
					} else {
						val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').applyIfTrue(
							dsl.dslProp.getProperty('truffle', "false") == "true", [
								addAnnotation(
									ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
							]).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
							$1T «oldName» = «field.name.normalizeVarName»;
							«field.name.normalizeVarName» = «newName»;
							if (eNotificationRequired())
								eNotify(new $2T(this, $3T.SET, $4T.«field.name.normalizeUpperField(eClass.name)», «oldName», «field.name.normalizeVarName»));
						''', fieldType, ENotificationImpl, Notification, ePackageInterfaceType).addModifiers(PUBLIC).
							build

						#[setter]

					}

				}
			}

		} else
			#[]
	}

	def legacyCompileGetter(EReference field, TypeName fieldType, String packageRoot, EClass eClass, Dsl dsl,
		ClassName ePackageInterfaceType) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		if (isMultiple) {
			if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
				val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
				val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
					dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addModifiers(PUBLIC).addCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $1T($2T.Literals.«(field.EType as EClass).name.normalizeUpperField», $3T.class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
					}
					return «field.name.normalizeVarName»;
				''',
					ParameterizedTypeName.get(ClassName.get(EcoreEMap), key.EType.scopedInterfaceTypeRef(packageRoot),
						value.EType.scopedInterfaceTypeRef(packageRoot)), ePackageInterfaceType,
					ClassName.get((field.EType as EClass).classImplementationPackageName(packageRoot),
						(field.EType as EClass).classImplementationClassName)).build
			} else if (field.EOpposite !== null) {
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
					dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addModifiers(PUBLIC).addCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $1T($2T.class, this, $3T.«field.name.normalizeUpperField(eClass.name)», $3T.«field.EOpposite.name.normalizeUpperField((field.EOpposite.eContainer as EClass).name)»);
					}
					return «field.name.normalizeVarName»;
				''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentWithInverseEList), rt), rt,
					ePackageInterfaceType).build
			} else {
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
					dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addModifiers(PUBLIC).addNamedCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $eoce:T($rt:T.class, this, $epit:T.«field.name.normalizeUpperField(eClass.name)»);
					}
					return «field.name.normalizeVarName»;
				''',
					newHashMap("eoce" -> ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList), rt),
						"epit" -> ePackageInterfaceType, "rt" -> rt)).build
			}
		} else {
			if (field.EOpposite !== null && field.EOpposite.containment) {
				MethodSpec.
					methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
					returns(fieldType).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addModifiers(PUBLIC).addCode('''
						if (eContainerFeatureID() != $1T.«field.name.normalizeUpperField(eClass.name)») return null;
						return ($2T)eInternalContainer();
					''', ePackageInterfaceType, fieldType).build
			} else {
				if (field.isContainment) {
					MethodSpec.
						methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
						returns(fieldType).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).addModifiers(PUBLIC).addCode('''
							return «field.name.normalizeVarName»;
						''').build
				} else {
					MethodSpec.
						methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
						returns(fieldType).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).addModifiers(PUBLIC).addCode('''
							if («field.name.normalizeVarName» != null && «field.name».eIsProxy()) {
								$T «field.name.normalizeVarOldName» = ($T) «field.name.normalizeVarName»;
								«field.name.normalizeVarName» = ($T) eResolveProxy(«field.name.normalizeVarOldName»);
								if («field.name.normalizeVarName» != «field.name.normalizeVarOldName») {
									if (eNotificationRequired())
										eNotify(new $T(this, $T.RESOLVE, $T.«field.name.normalizeUpperField(eClass.name)»,
												«field.name.normalizeVarOldName», «field.name.normalizeVarName»));
								}
							}
							return «field.name.normalizeVarName»;
						''', TypeName.get(InternalEObject), TypeName.get(InternalEObject), fieldType,
							TypeName.get(ENotificationImpl), TypeName.get(Notification), ePackageInterfaceType).build

				}
			}
		}
	}

}
