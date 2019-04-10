package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import java.util.List
import java.util.Map
import java.util.Optional
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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList
import org.eclipse.emf.ecore.util.EObjectContainmentEList
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList
import org.eclipse.emf.ecore.util.EObjectResolvingEList
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList
import org.eclipse.emf.ecore.util.EcoreEMap
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class EClassGetterCompiler {

	extension GenmodelNamingUtils namingUtils 
	extension CommonCompilerUtils icu
	extension JavaPoetUtils = new JavaPoetUtils
	
	new(GenmodelNamingUtils namingUtils, CommonCompilerUtils ccu) {
		this.namingUtils = namingUtils
		this.icu = ccu
	}
	
	def buildGetTyped(EStructuralFeature field, TypeName rt) {
		MethodSpec.methodBuilder('''getTyped«field.name.toFirstUpper»''')
			.returns(rt)
			.addModifiers(PUBLIC)
			.addNamedCode('''
				return $name:L;
				''', newHashMap(
				"name" -> field.name.normalizeVarName
				))
			.build
	}
	
	def buildSetTyped(EStructuralFeature field, TypeName rt, ClassName ePackageInterfaceType) {
		MethodSpec
			.methodBuilder('''setTyped«field.name.toFirstUpper»''')
			.addParameter(rt, field.name.normalizeVarNewName)
			.addModifiers(PUBLIC)
			.addNamedCode('''
			$rt:T $oldName:L = $name:L;
			$name:L = $newName:L;
			if (eNotificationRequired())
				eNotify(new $eni:T(this, $notif:T.SET, $package:T.$fieldName:L, $oldName:L, $name:L));
			''', newHashMap(
				"rt" -> rt,
				"oldName" -> field.name.normalizeVarOldName,
				"newName" -> field.name.normalizeVarNewName,
				"name" -> field.name.normalizeVarName,
				"eni" -> ClassName.get(ENotificationImpl),
				"package" -> ePackageInterfaceType,
				"fieldName" -> field.normalizeUpperField,
				"notif" -> ClassName.get(Notification)
			))
			.build
	}
	
	def buildSimpleGetter(EStructuralFeature field, TypeName fieldType, boolean isTyped) {
		field.buildSimpleGetter(fieldType, Optional.empty, isTyped)
	}
	
	def buildSimpleMultipleGetter(EStructuralFeature field, TypeName fieldType, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped, String packageRoot) {
		val lt = if(field.unique) {
			ParameterizedTypeName.get(ClassName.get(EDataTypeUniqueEList), rt.box)
		} else {
			ParameterizedTypeName.get(ClassName.get(EDataTypeEList), rt.box)
		}
		val t = field.computeFieldTypeEClass(packageRoot)
		val hm = newHashMap(
			"listtype" -> lt,
			"rt" -> rt.box,
			"epit" -> ePackageInterfaceType
		)
		
		
		MethodSpec.methodBuilder('''get«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').
			returns(t).addNamedCode('''
				if («field.name.normalizeVarName» == null) {
					«field.name.normalizeVarName» = new $listtype:T($rt:T.class, this, $epit:T.«field.normalizeUpperField»);
				}
				return «field.name.normalizeVarName»;
			''',hm).addModifiers(PUBLIC).build
	}
	
	def buildSimpleGetter(EStructuralFeature field, TypeName fieldType, Optional<Dsl> dsl, boolean isTyped) {
		MethodSpec.methodBuilder('''«IF isTyped»getTyped«field.name.toFirstUpper»«ELSE»«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»«ENDIF»''')
			.returns(fieldType)
			.applyIfTrue(dsl.map[it.dslProp.getProperty('truffle', "false") == "true"].orElse(false), [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			])
			.addCode('''
				return «field.name.normalizeVarName»;
			''')
			.addModifiers(PUBLIC)
			.build		
	}
	
	def buildSimpleSetter(EStructuralFeature field, TypeName fieldType, TypeName ePackageInterfaceType, boolean isTyped) {
		field.buildSimpleSetter(fieldType, ePackageInterfaceType, Optional.empty, isTyped)
	}
	
	def buildWithOppositeGetter(EStructuralFeature field, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		MethodSpec.methodBuilder('''get«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''')
			.returns(rt)
			.addNamedCode('''
			if («field.name.normalizeVarName» != null && «field.name.normalizeVarName».eIsProxy()) {
				$ieo:T «field.name.normalizeVarOldName» = ($ieo:T) «field.name.normalizeVarName»;
				«field.name.normalizeVarName» = ($fieldType:T) eResolveProxy(«field.name.normalizeVarOldName»);
				if («field.name.normalizeVarName» != «field.name.normalizeVarOldName») {
					if (eNotificationRequired())
						eNotify(new $eni:T(this, $notif:T.RESOLVE, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarOldName», «field.name.normalizeVarName»));
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
	}
	
	def buildWithMultipleGetter(EStructuralFeature field, TypeName fieldType, Dsl dsl, TypeName ePackageInterfaceType, TypeName rt, boolean isTyped) {
		MethodSpec.methodBuilder('''get«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
					dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addModifiers(PUBLIC).addNamedCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $eoce:T($rt:T.class, this, $epit:T.«field.normalizeUpperField»);
					}
					return «field.name.normalizeVarName»;
				''',
					newHashMap("eoce" -> ParameterizedTypeName.get(ClassName.get(EObjectResolvingEList), rt),
						"epit" -> ePackageInterfaceType, "rt" -> rt)).build
	}
	
	def buildBasicGetter(EStructuralFeature field, TypeName rt) {
		MethodSpec.methodBuilder('''basicGet«field.name.toFirstUpper»''').returns(rt).addCode('''
			return «field.name.normalizeVarName»;
		''').addModifiers(PUBLIC).build
	}
	
	def buildSimpleSetterNoNotification(EStructuralFeature field, TypeName fieldType, Dsl dsl, boolean isTyped) {
		val newName = '''«field.name.normalizeVarNewName»'''
		val oldName = '''«field.name.normalizeVarOldName»'''
		MethodSpec.methodBuilder('''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''')
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			])
			.returns(fieldType)
			.addParameter(ParameterSpec.builder(fieldType, newName).build)
			.addCode('''
			$1T «oldName» = this.«field.name.normalizeVarName»;
			this.«field.name.normalizeVarName» = «newName»;
			return «oldName»;
			''', fieldType)
			.addModifiers(PUBLIC)
			.build	
	}
	
	def buildSimpleSetter(EStructuralFeature field, TypeName fieldType, TypeName ePackageInterfaceType, Optional<Dsl> dsl, boolean isTyped) {
		val hm = newHashMap(
			"ft" -> fieldType,
			"eni" -> ClassName.get(ENotificationImpl),
			"notif" -> ClassName.get(Notification),
			"epit" -> ePackageInterfaceType
		)

		MethodSpec.methodBuilder('''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''')
			.addParameter(fieldType, '''new«field.name.toFirstUpper»''')
			.applyIfTrue(dsl.map[it.dslProp.getProperty('truffle', "false") == "true"].orElse(false), [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			])
			.addNamedCode('''
				$ft:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
				«IF field.EType instanceof EEnum»
				«field.name.normalizeVarName» = «field.name.normalizeVarNewName» == null ? «field.name.toUpperCase»_EDEFAULT : «field.name.normalizeVarNewName»;
				«ELSE»
				«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
				«ENDIF»
				if (eNotificationRequired())
					eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», old«field.name.toFirstUpper», «field.name.normalizeVarName»));
			''', hm)
			.addModifiers(PUBLIC)
			.build
	}
	
	def buildBasicSetter(EStructuralFeature field, TypeName rt, TypeName ePackageInterfaceType) {
		MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').returns(
			NotificationChain).addParameter(rt, '''«field.name.normalizeVarNewName»''').addParameter(NotificationChain,
			'msgs').addModifiers(PUBLIC).addNamedCode('''
			$fieldType:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
			«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
			if (eNotificationRequired()) {
				$eni:T notification = new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarOldName», «field.name.normalizeVarNewName»);
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
	}
	
	def buildWithOppositeSetter(EReference field, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		MethodSpec.methodBuilder('''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').
			addParameter(rt, '''«field.name.normalizeVarNewName»''').addNamedCode('''
				if («field.name.normalizeVarNewName» != «field.name.normalizeVarName») {
					$nc:T msgs = null;
					if («field.name.normalizeVarName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarName»).eInverseRemove(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldType:T.class, msgs);
					if («field.name.normalizeVarNewName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldType:T.class, msgs);
					msgs = basicSet«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
					if (msgs != null)
						msgs.dispatch();
				} else if (eNotificationRequired())
					eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
			''', newHashMap(
				"nc" -> ClassName.get(NotificationChain),
				"ieo" -> ClassName.get(InternalEObject),
				"epit" -> ePackageInterfaceType,
				"fieldType" -> rt,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification)
				)).addModifiers(PUBLIC).build
	}
	
	def buildWithOppositeWithContainementSetter(EReference field, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		MethodSpec.methodBuilder('''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''')
			.addParameter(rt, '''«field.name.normalizeVarNewName»''')
			.addNamedCode('''
				if («field.name.normalizeVarNewName» != «field.name.normalizeVarName») {
					$nc:T msgs = null;
					if («field.name.normalizeVarName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarName»).eInverseRemove(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldType:T.class, msgs);
					if («field.name.normalizeVarNewName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldType:T.class, msgs);
					msgs = basicSet«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
					if (msgs != null)
						msgs.dispatch();
				} else if (eNotificationRequired())
					eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
			''', newHashMap(
				"nc" -> ClassName.get(NotificationChain),
				"ieo" -> ClassName.get(InternalEObject),
				"epit" -> ePackageInterfaceType,
				"fieldType" -> rt,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification)
			))
			.addModifiers(PUBLIC)
			.build
	}
	
	
	def buildWithOppositeWithOppositeContainementSetter(EReference field, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		MethodSpec.methodBuilder('''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''')
			.addParameter(rt, field.name.normalizeVarNewName)
			.addNamedCode('''
			if («field.name.normalizeVarNewName» != eInternalContainer() || (eContainerFeatureID() != $epit:T.«field.normalizeUpperField» && «field.name.normalizeVarNewName» != null)) {
				if ($eu:T.isAncestor(this, «field.name.normalizeVarNewName»))
					throw new $iae:T("Recursive containment not allowed for " + toString());
				$nc:T msgs = null;
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				if («field.name.normalizeVarNewName» != null)
					msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldType:T.class, msgs);
				msgs = basicSet«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
				if (msgs != null)
					msgs.dispatch();
			} else if (eNotificationRequired())
				eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
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
	}
	
	def buildWithContainmentSetter(EReference field, Dsl dsl, TypeName fieldType, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		val newName = '''«field.name.normalizeVarNewName»'''
		val name = field.name.normalizeVarName
		MethodSpec.methodBuilder('''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').applyIfTrue(
			dsl.dslProp.getProperty('truffle', "false") == "true", [
				addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
			]).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
			if («newName» != «name») {
				$1T msgs = null;
				«IF field.EOpposite !== null»
					if («name» != null)
						msgs = (($2T) «name»).eInverseRemove(this, $5T.«field.EOpposite.normalizeUpperField», «rt».class, msgs);
					if («newName» != null)
						msgs = (($2T) «newName»).eInverseAdd(this, $5T.«field.EOpposite.normalizeUpperField», «rt».class,
								msgs);
				«ELSE»
					if («name» != null)
						msgs = (($2T) «name»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $5T.«field.normalizeUpperField», null, msgs);
					if («newName» != null)
						msgs = (($2T) «newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - $5T.«field.normalizeUpperField», null, msgs);
				«ENDIF»
				msgs = basicSet«name.toFirstUpper»(«newName», msgs);
				if (msgs != null)
					msgs.dispatch();
			} else if (eNotificationRequired())
				eNotify(new $3T(this, $4T.SET, $5T.«field.normalizeUpperField», «newName», «newName»));
		''', NotificationChain, InternalEObject, ENotificationImpl, Notification, ePackageInterfaceType).
			addModifiers(PUBLIC).build
	}

	def dispatch List<MethodSpec> compileAccessors(EAttribute field, TypeName fieldType, String packageRoot, EClass eClass,
		Dsl dsl, ClassName ePackageInterfaceType, boolean isTyped) {
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		
		if (!isMultiple) {
			val getter = field.buildSimpleGetter(fieldType, isTyped)
			val setter = field.buildSimpleSetter(fieldType, ePackageInterfaceType, isTyped)
			#[getter, setter]
		} else {
			val getter = field.buildSimpleMultipleGetter(fieldType, rt, ePackageInterfaceType, isTyped, packageRoot)
			#[getter]
		}

	}
	
	def List<MethodSpec> compileAccessors(EStructuralFeature field, TypeName fieldType, String packageRoot, EClass eClass,
		Dsl dsl, ClassName ePackageInterfaceType) {
			field.compileAccessors(fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, false)			
		}

	def dispatch List<MethodSpec> compileAccessors(EReference field, TypeName fieldType, String packageRoot, EClass eClass,
		Dsl dsl, ClassName ePackageInterfaceType, boolean isTyped) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		val existEOpposite = field.EOpposite !== null
		val isOppositeMulti = existEOpposite && (field.EOpposite.upperBound > 1 || field.EOpposite.upperBound < 0)
		val isContainment = field.containment
		val isOppositeContainment = existEOpposite && field.EOpposite.containment

		if (existEOpposite && !isMultiple && !isContainment && !isOppositeContainment) {
			val getter = field.buildWithOppositeGetter(rt, ePackageInterfaceType, isTyped) 
			val basicGetter = field.buildBasicGetter(rt)
			val basicSetter = field.buildBasicSetter(rt, ePackageInterfaceType)
			val setter = field.buildWithOppositeSetter(rt, ePackageInterfaceType, isTyped)
			#[getter, basicGetter, basicSetter, setter]
		}  else if (existEOpposite && !isMultiple && !isContainment && isOppositeContainment) {
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''')
				.returns(rt)
				.addNamedCode('''
				if (eContainerFeatureID() != $epit:T.«field.normalizeUpperField»)
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
				msgs = eBasicSetContainer(($ieo:T) «field.name.normalizeVarNewName», $epit:T.«field.normalizeUpperField», msgs);
				return msgs;
				''', newHashMap(
					"epit" -> ePackageInterfaceType,
					"ieo" -> ClassName.get(InternalEObject)
				))
				.addModifiers(PUBLIC)
				.build
				
			val setter = field.buildWithOppositeWithOppositeContainementSetter(rt, ePackageInterfaceType, isTyped)
			#[getter, basicSetter, setter]
		} else if (existEOpposite && !isMultiple && isContainment && !isOppositeContainment) {
			val getter = field.buildSimpleGetter(rt, isTyped)
			val basicSetter = field.buildBasicSetter(rt, ePackageInterfaceType) 
			val setter = field.buildWithOppositeWithContainementSetter(rt, ePackageInterfaceType, isTyped) 
			#[getter, basicSetter, setter]
		} else if (existEOpposite && isMultiple && !isOppositeMulti && !isContainment && !isOppositeContainment) {
			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
				addNamedCode('''
					if («field.name.normalizeVarName» == null) {
						«field.name.normalizeVarName» = new $eowrel:T($ft:T.class, this, $epit:T.«field.normalizeUpperField», $epit:T.«field.EOpposite.normalizeUpperField»);
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
						«field.name.normalizeVarName» = new $eowrel:T($ft:T.class, this, $epit:T.«field.normalizeUpperField», $epit:T.«field.EOpposite.normalizeUpperField»);
					}
					return «field.name.normalizeVarName»;
				''', newHashMap(
					"eowrel" ->
						ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList.ManyInverse), rt),
					"ft" -> rt,
					"epit" -> ePackageInterfaceType
				)).addModifiers(PUBLIC).build
			#[getter]
		} else if (!existEOpposite && !isMultiple && !isContainment && !isOppositeContainment) {
			val getter = MethodSpec.
						methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
						returns(fieldType).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).addModifiers(PUBLIC).addCode('''
							if («field.name.normalizeVarName» != null && «field.name».eIsProxy()) {
								$T «field.name.normalizeVarOldName» = ($T) «field.name.normalizeVarName»;
								«field.name.normalizeVarName» = ($T) eResolveProxy(«field.name.normalizeVarOldName»);
								if («field.name.normalizeVarName» != «field.name.normalizeVarOldName») {
									if (eNotificationRequired())
										eNotify(new $T(this, $T.RESOLVE, $T.«field.normalizeUpperField»,
												«field.name.normalizeVarOldName», «field.name.normalizeVarName»));
								}
							}
							return «field.name.normalizeVarName»;
						''', TypeName.get(InternalEObject), TypeName.get(InternalEObject), fieldType,
							TypeName.get(ENotificationImpl), TypeName.get(Notification), ePackageInterfaceType).build
			val basicGetter = field.buildBasicGetter(rt)
			val setter = field.buildSimpleSetter(fieldType, ePackageInterfaceType, isTyped) 
			
			#[getter, basicGetter, setter]
		} else if (!existEOpposite &&  !isMultiple && isContainment) {
			val getter = field.buildSimpleGetter(rt, isTyped)
			
			val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').returns(
				NotificationChain).addParameter(rt, '''«field.name.normalizeVarNewName»''').addParameter(NotificationChain,
				'msgs').addModifiers(PUBLIC).addNamedCode('''
				$fieldType:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
				«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
				if (eNotificationRequired()) {
					$eni:T notification = new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarOldName», «field.name.normalizeVarNewName»);
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
			
			val setter = field.buildWithContainmentSetter(dsl, fieldType, rt, ePackageInterfaceType, isTyped)
			
			#[getter, basicSetter, setter]
		} else if (!existEOpposite && isMultiple && !isContainment) {
			val getter = field.buildWithMultipleGetter(fieldType, dsl, ePackageInterfaceType, rt, isTyped)
			#[getter]
		} else {
			val getter = this.legacyCompileGetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType)

			#[getter]
		}
	}

	def legacyCompileGetter(EReference field, TypeName fieldType, String packageRoot, EClass eClass, Dsl dsl,
		ClassName ePackageInterfaceType) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
			val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
			val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
			MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
				dsl.dslProp.getProperty('truffle', "false") == "true", [
					addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
				]).addModifiers(PUBLIC).addCode('''
				if («field.name.normalizeVarName» == null) {
					«field.name.normalizeVarName» = new $1T($2T.Literals.«(field.EType as EClass).name.normalizeUpperField», $3T.class, this, $2T.«field.normalizeUpperField»);
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
					«field.name.normalizeVarName» = new $1T($2T.class, this, $3T.«field.normalizeUpperField», $3T.«field.EOpposite.normalizeUpperField»);
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
					«field.name.normalizeVarName» = new $eoce:T($rt:T.class, this, $epit:T.«field.normalizeUpperField»);
				}
				return «field.name.normalizeVarName»;
			''',
				newHashMap("eoce" -> ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList), rt),
					"epit" -> ePackageInterfaceType, "rt" -> rt)).build
		}
	}

}
