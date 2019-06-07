package org.eclipse.emf.ecoretools.ale.compiler.genmodel

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
import org.eclipse.emf.ecore.EObject
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
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class EClassGetterCompiler {

	extension EcoreGenNamingUtils namingUtils
	extension CommonCompilerUtils icu
	extension TruffleHelper th
	val List<ResolvedClass> resolved
	val Dsl dsl

	new(EcoreGenNamingUtils namingUtils, CommonCompilerUtils ccu, List<ResolvedClass> resolved, Dsl dsl, TruffleHelper th) {
		this.namingUtils = namingUtils
		this.icu = ccu
		this.resolved = resolved
		this.dsl = dsl
		this.th = th
	}

	private def buildSimpleMultipleGetter(EStructuralFeature field, TypeName fieldType, TypeName ePackageInterfaceType,
		boolean isTyped, String packageRoot) {

		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		val lt = if (field.unique) {
				ParameterizedTypeName.get(ClassName.get(EDataTypeUniqueEList), rt.box)
			} else {
				ParameterizedTypeName.get(ClassName.get(EDataTypeEList), rt.box)
			}
		val t = field.computeFieldTypeEClass(packageRoot)
		val hm = newHashMap(
			"eoce" -> lt,
			"rt" -> rt.box,
			"epit" -> ePackageInterfaceType
		)

		commonBuildSimpleGetter(isTyped, field, t, hm)
	}

	private def buildSimpleGetter(EStructuralFeature field, TypeName fieldType,  boolean isTyped) {
		MethodSpec.methodBuilder(field.getGetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.returns(fieldType)
			.addCode('''
				return «field.name.normalizeVarName»;
			''')
			.addModifiers(PUBLIC)
			.build
	}

	

	private def buildWithOppositeGetter(EStructuralFeature field, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		val hm = newHashMap(
			"ieo" -> ClassName.get(InternalEObject),
			"fieldType" -> rt,
			"eni" -> ClassName.get(ENotificationImpl),
			"notif" -> ClassName.get(Notification),
			"epit" -> ePackageInterfaceType,
			"eobj" -> ClassName.get(EObject)
		)
		MethodSpec
			.methodBuilder(field.getGetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.returns(rt)
			.addNamedCode('''
				if («field.name.normalizeVarName» != null && «IF field.isObjectExtensionType»(($eobj:T) «field.name.normalizeVarName»)«ELSE»«field.name.normalizeVarName»«ENDIF».eIsProxy()) {
					$ieo:T «field.name.normalizeVarOldName» = ($ieo:T) «field.name.normalizeVarName»;
					«field.name.normalizeVarName» = ($fieldType:T) eResolveProxy(«field.name.normalizeVarOldName»);
					if («field.name.normalizeVarName» != «field.name.normalizeVarOldName») {
						if (eNotificationRequired())
							eNotify(new $eni:T(this, $notif:T.RESOLVE, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarOldName», «field.name.normalizeVarName»));
					}
				}
				return «field.name.normalizeVarName»;
			''', hm)
			.addModifiers(PUBLIC)
			.build
	}

	private def buildWithMultipleGetter(EStructuralFeature field, TypeName fieldType, TypeName ePackageInterfaceType,
		 boolean isTyped, String packageRoot) {
		val simpleType = if (field.EType.instanceClassName == "java.util.Map$Entry")
				(fieldType as ParameterizedTypeName).typeArguments.head
			else
				field.EType.scopedInterfaceTypeRef(packageRoot)
		val hm = newHashMap(
			"eoce" -> ParameterizedTypeName.get(ClassName.get(EObjectResolvingEList), simpleType),
			"epit" -> ePackageInterfaceType,
			"rt" -> if(simpleType instanceof ParameterizedTypeName) simpleType.rawType else simpleType)
		commonBuildSimpleGetter(isTyped, field, fieldType, hm)
	}

	private def buildBasicGetter(EStructuralFeature field, TypeName rt, boolean isTyped) {
		MethodSpec.methodBuilder('''basicGet«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').returns(rt).
			addCode('''
				return «field.name.normalizeVarName»;
			''').addModifiers(PUBLIC).build
	}

	private def buildSimpleSetter(EStructuralFeature field, TypeName fieldType, TypeName ePackageInterfaceType,
		 boolean isTyped, EClass eClass) {
		val hm = newHashMap(
			"ft" -> fieldType,
			"eni" -> ClassName.get(ENotificationImpl),
			"notif" -> ClassName.get(Notification),
			"epit" -> ePackageInterfaceType
		)

		MethodSpec.methodBuilder(field.getSetterMethodName(isTyped))
			.addParameter(fieldType, '''new«field.name.toFirstUpper»''')
			.addTruffleBoundaryAnnotation(dsl)
			.addNamedCode('''
				$ft:T «field.name.normalizeVarOldName» = «field.name.normalizeVarName»;
				«IF field.EType instanceof EEnum»
					«field.name.normalizeVarName» = «field.name.normalizeVarNewName» == null ? «field.name.toUpperCase»_EDEFAULT : «field.name.normalizeVarNewName»;
				«ELSE»
					«field.name.normalizeVarName» = «field.name.normalizeVarNewName»;
				«ENDIF»
				if (eNotificationRequired())
					eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField(eClass)», old«field.name.toFirstUpper», «field.name.normalizeVarName»));
			''', hm).addModifiers(PUBLIC).build
	}

	private def buildWithOppositeWithOppositeContainmentBasicSetter(EStructuralFeature field, TypeName rt,
		TypeName ePackageInterfaceType, boolean isTyped) {
		MethodSpec.methodBuilder('''basicSet«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').returns(
			NotificationChain).addParameter(rt, field.name.normalizeVarNewName).addParameter(NotificationChain, 'msgs').
			addNamedCode('''
				msgs = eBasicSetContainer(($ieo:T) «field.name.normalizeVarNewName», $epit:T.«field.normalizeUpperField», msgs);
				return msgs;
			''', newHashMap(
				"epit" -> ePackageInterfaceType,
				"ieo" -> ClassName.get(InternalEObject)
			)).addModifiers(PUBLIC).build
	}

	private def buildWithOppositedWithOppositeContainmentGetter(EStructuralFeature field, TypeName rt,
		TypeName ePackageInterfaceType, boolean isTyped) {
		MethodSpec.methodBuilder(field.getGetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.returns(rt)
			.addNamedCode('''
				if (eContainerFeatureID() != $epit:T.«field.normalizeUpperField»)
					return null;
				return ($fieldType:T) eInternalContainer();
			''', newHashMap(
				"fieldType" -> rt,
				"epit" -> ePackageInterfaceType
			)).addModifiers(PUBLIC).build
	}

	private def isObjectExtensionType(EStructuralFeature field) {
		val ecls = field.EContainingClass
		val gen = this.resolved.filter[it.eCls.name == ecls.name && it.eCls.EPackage.name == ecls.EPackage.name].head.
			genCls
		gen.ESetGenFeatures.filter[it.name == field.name].head.getSafeNameAsEObject().startsWith(
			"((org.eclipse.emf.ecore.EObject)")
	}

	private def buildWithContainmentSetter(EStructuralFeature field, TypeName rt, TypeName ePackageInterfaceType,
		boolean isTyped) {
		MethodSpec.methodBuilder('''basicSet«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''')
			.addTruffleBoundaryAnnotation(dsl)
			.returns(NotificationChain)
			.addParameter(rt, '''«field.name.normalizeVarNewName»''').addParameter(NotificationChain,
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

	private def buildWithOppositeWithOppositeContainementSetter(EReference field, TypeName rt, TypeName ePackageInterfaceType,
		boolean isTyped) {
		MethodSpec.methodBuilder(field.getSetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.addParameter(rt, field.name.normalizeVarNewName)
			.addNamedCode('''
				if («field.name.normalizeVarNewName» != eInternalContainer() || (eContainerFeatureID() != $epit:T.«field.normalizeUpperField» && «field.name.normalizeVarNewName» != null)) {
					if ($eu:T.isAncestor(this, «IF rt.toString.startsWith("java.util.Map.Entry")»($eot:T) «ENDIF»«field.name.normalizeVarNewName»))
						throw new $iae:T("Recursive containment not allowed for " + toString());
					$nc:T msgs = null;
					if (eInternalContainer() != null)
						msgs = eBasicRemoveFromContainer(msgs);
					if («field.name.normalizeVarNewName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.normalizeUpperField», $rawfieldType:T.class, msgs);
					msgs = basicSet«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
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
				"rawfieldType" -> if(rt instanceof ParameterizedTypeName) rt.rawType else rt,
				"eni" -> ClassName.get(ENotificationImpl),
				"notif" -> ClassName.get(Notification),
				"eot" -> ClassName.get(EObject)
			)).addModifiers(PUBLIC).build
	}

	private def buildWithContainmentSetter(EReference field,  TypeName fieldType, TypeName rt,
		TypeName ePackageInterfaceType, boolean isTyped) {
		val newName = '''«field.name.normalizeVarNewName»'''
		val name = field.name.normalizeVarName
		MethodSpec.methodBuilder(field.getSetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.addParameter(ParameterSpec.builder(fieldType, newName).build)
			.addCode('''
			if («newName» != «name») {
				$1T msgs = null;
				if («name» != null)
					msgs = (($2T) «name»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $5T.«field.normalizeUpperField», null, msgs);
				if («newName» != null)
					msgs = (($2T) «newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - $5T.«field.normalizeUpperField», null, msgs);
				msgs = basicSet«IF isTyped»Typed«ENDIF»«name.toFirstUpper»(«newName», msgs);
				if (msgs != null)
					msgs.dispatch();
			} else if (eNotificationRequired())
				eNotify(new $3T(this, $4T.SET, $5T.«field.normalizeUpperField», «newName», «newName»));
		''', NotificationChain, InternalEObject, ENotificationImpl, Notification, ePackageInterfaceType).
			addModifiers(PUBLIC).build
	}

	def dispatch List<MethodSpec> compileAccessors(EAttribute field, TypeName fieldType, String packageRoot,
		EClass eClass,  ClassName ePackageInterfaceType, boolean isTyped) {
		val isMultiple = field.upperBound > 1 || field.upperBound < 0

		if (!isMultiple) {
			val getter = field.buildSimpleGetter(fieldType, isTyped)
			val setter = field.buildSimpleSetter(fieldType, ePackageInterfaceType, isTyped, eClass)
			#[getter, setter]
		} else {
			val getter = field.buildSimpleMultipleGetter(fieldType, ePackageInterfaceType, isTyped, packageRoot)
			#[getter]
		}
	}

	def dispatch List<MethodSpec> compileAccessors(EReference field, TypeName fieldType, String packageRoot,
		EClass eClass, ClassName ePackageInterfaceType, boolean isTyped) {
		val rt = field.computeFieldTypeEClass(packageRoot)
		val isMultiple = field.upperBound > 1 || field.upperBound < 0
		val existEOpposite = field.EOpposite !== null
		val isOppositeMulti = existEOpposite && (field.EOpposite.upperBound > 1 || field.EOpposite.upperBound < 0)
		val isContainment = field.containment
		val isOppositeContainment = existEOpposite && field.EOpposite.containment

		if (existEOpposite && !isMultiple && !isContainment && !isOppositeContainment) {
			val getter = field.buildWithOppositeGetter(rt, ePackageInterfaceType, isTyped)
			val basicGetter = field.buildBasicGetter(rt, isTyped)
			val basicSetter = field.buildWithContainmentSetter(rt, ePackageInterfaceType, isTyped)
			val setter = field.buildWithOppositeSetter(rt, ePackageInterfaceType, isTyped)
			#[getter, basicGetter, basicSetter, setter]
		} else if (existEOpposite && !isMultiple && !isContainment && isOppositeContainment) {
			val getter = field.buildWithOppositedWithOppositeContainmentGetter(rt, ePackageInterfaceType, isTyped)
			val basicSetter = field.
				buildWithOppositeWithOppositeContainmentBasicSetter(rt, ePackageInterfaceType, isTyped)
			val setter = field.buildWithOppositeWithOppositeContainementSetter(rt, ePackageInterfaceType, isTyped)
			#[getter, basicSetter, setter]
		} else if (existEOpposite && !isMultiple && isContainment && !isOppositeContainment) {
			val getter = field.buildSimpleGetter(rt, isTyped)
			val basicSetter = field.buildWithContainmentSetter(rt, ePackageInterfaceType, isTyped)
			val setter = field.buildWithOppositeSetter(rt, ePackageInterfaceType, isTyped)
			#[getter, basicSetter, setter]
		} else if (existEOpposite && isMultiple && !isContainment && !isOppositeContainment) {
			val getter = field.buildWithOppositeWithMultipleGetter(fieldType, rt, ePackageInterfaceType, isTyped, isOppositeMulti)
			#[getter]
		} else if (!existEOpposite && !isMultiple && !isContainment && !isOppositeContainment) {
			val getter = field.buildWithOppositeGetter(fieldType, ePackageInterfaceType,  isTyped)
			val basicGetter = field.buildBasicGetter(rt, isTyped)
			val setter = field.buildSimpleSetter(fieldType, ePackageInterfaceType, isTyped, eClass)
			#[getter, basicGetter, setter]
		} else if (!existEOpposite && !isMultiple && isContainment) {
			val getter = field.buildSimpleGetter(rt, isTyped)
			val basicSetter = field.buildWithContainmentSetter(rt, ePackageInterfaceType, isTyped)
			val setter = field.buildWithContainmentSetter(fieldType, rt, ePackageInterfaceType, isTyped)
			#[getter, basicSetter, setter]
		} else if (!existEOpposite && isMultiple && !isContainment) {
			val getter = field.buildWithMultipleGetter(fieldType, ePackageInterfaceType, isTyped, packageRoot)
			#[getter]
		} else {
			val getter = this.legacyCompileGetter(field, fieldType, packageRoot, eClass, ePackageInterfaceType,
				isTyped)
			#[getter]
		}
	}

	private def String getSetterMethodName(EStructuralFeature field, boolean isTyped) {
		'''set«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»'''
	}
	
	private def String getGetterMethodName(EStructuralFeature field, boolean isTyped) {
		'''«IF isTyped»getTyped«ELSE»«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«ENDIF»«field.name.toFirstUpper»'''
	}
	
	
	
	private def buildWithOppositeSetter(EReference field, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped) {
		val hm = newHashMap(
			"nc" -> ClassName.get(NotificationChain),
			"ieo" -> ClassName.get(InternalEObject),
			"epit" -> ePackageInterfaceType,
			"fieldType" -> rt,
			"fieldTypeNoGen" -> if(rt instanceof ParameterizedTypeName) rt.rawType else rt,
			"eni" -> ClassName.get(ENotificationImpl),
			"notif" -> ClassName.get(Notification)
		)
		MethodSpec.methodBuilder(field.getSetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.addParameter(rt, '''«field.name.normalizeVarNewName»''')
			.addNamedCode('''
				if («field.name.normalizeVarNewName» != «field.name.normalizeVarName») {
					$nc:T msgs = null;
					if («field.name.normalizeVarName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarName»).eInverseRemove(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldTypeNoGen:T.class, msgs);
					if («field.name.normalizeVarNewName» != null)
						msgs = (($ieo:T) «field.name.normalizeVarNewName»).eInverseAdd(this, $epit:T.«field.EOpposite.normalizeUpperField», $fieldTypeNoGen:T.class, msgs);
					msgs = basicSet«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»(«field.name.normalizeVarNewName», msgs);
					if (msgs != null)
						msgs.dispatch();
				} else if (eNotificationRequired())
					eNotify(new $eni:T(this, $notif:T.SET, $epit:T.«field.normalizeUpperField», «field.name.normalizeVarNewName», «field.name.normalizeVarNewName»));
			''', hm)
			.addModifiers(PUBLIC)
			.build
	}
	
	private def commonBuildSimpleGetter(boolean isTyped, EStructuralFeature field, TypeName t,
		Map<String, ? extends Object> hm) {
		MethodSpec.methodBuilder(field.getGetterMethodName(isTyped))
			.returns(t)
			.addTruffleBoundaryAnnotation(dsl)
			.addNamedCode('''
			if («field.name.normalizeVarName» == null) {
				«field.name.normalizeVarName» = new $eoce:T($rt:T.class, this, $epit:T.«field.normalizeUpperField»);
			}
			return «field.name.normalizeVarName»;
		''', hm).addModifiers(PUBLIC).build
	}
	
	private def buildWithOppositeWithMultipleGetter(EReference field, TypeName fieldType, TypeName rt, TypeName ePackageInterfaceType, boolean isTyped, boolean isOppositedMulty) {
		val mapEntry = if(rt instanceof ParameterizedTypeName) rt.typeArguments.head else rt
		val entry = if(mapEntry instanceof ParameterizedTypeName) mapEntry.rawType else mapEntry
		
		val eoce = if(!isOppositedMulty) ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList), mapEntry)
			else ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList.ManyInverse), mapEntry)
		val hm = newHashMap(
			"eoce" -> eoce,
			"ft" -> entry,
			"epit" -> ePackageInterfaceType
		)
		MethodSpec.methodBuilder(field.getGetterMethodName(isTyped))
			.addTruffleBoundaryAnnotation(dsl)
			.returns(rt)
			.addNamedCode('''
				if («field.name.normalizeVarName» == null) {
					«field.name.normalizeVarName» = new $eoce:T($ft:T.class, this, $epit:T.«field.normalizeUpperField», $epit:T.«field.EOpposite.normalizeUpperField»);
				}
				return «field.name.normalizeVarName»;
			''', hm)
			.addModifiers(PUBLIC)
			.build
	}
	
	private def legacyCompileGetter(EReference field, TypeName fieldType, String packageRoot, EClass eClass, 
		ClassName ePackageInterfaceType, boolean isTyped) {
		val ert = field.EGenericType.ERawType
		val rt = ert.scopedInterfaceTypeRef(packageRoot)
		if (ert.instanceClass !== null && ert.instanceClass == Map.Entry) {
			val key = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
			val value = field.EType.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
			MethodSpec
				.methodBuilder(field.getGetterMethodName(isTyped))
				.addTruffleBoundaryAnnotation(dsl)
				.returns(fieldType)
				.addModifiers(PUBLIC).addCode('''
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
			MethodSpec.methodBuilder('''get«IF isTyped»Typed«ENDIF»«field.name.toFirstUpper»''').returns(fieldType)
				.addTruffleBoundaryAnnotation(dsl)
				.addModifiers(PUBLIC)
				.addCode('''
				if («field.name.normalizeVarName» == null) {
					«field.name.normalizeVarName» = new $1T($2T.class, this, $3T.«field.normalizeUpperField», $3T.«field.EOpposite.normalizeUpperField»);
				}
				return «field.name.normalizeVarName»;
			''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentWithInverseEList), rt), rt,
				ePackageInterfaceType).build
		} else {
			val hm = newHashMap(
				"eoce" -> ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList), rt),
				"epit" -> ePackageInterfaceType, "rt" -> rt)
			commonBuildSimpleGetter(isTyped, field, fieldType, hm)
		}
	}
}
