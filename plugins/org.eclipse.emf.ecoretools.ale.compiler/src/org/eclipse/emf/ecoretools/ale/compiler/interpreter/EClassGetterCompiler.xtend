package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import java.util.Map
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.ENotificationImpl
import org.eclipse.emf.ecore.util.EObjectContainmentEList
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList
import org.eclipse.emf.ecore.util.EcoreEMap
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class EClassGetterCompiler {

	extension JavaPoetUtils = new JavaPoetUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	extension InterpreterCompilerUtils = new InterpreterCompilerUtils

	def compileGetter(EReference field, TypeName fieldType, String packageRoot, EClass eClass, Dsl dsl,
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
					if («field.name» == null) {
						«field.name» = new $1T($2T.Literals.«(field.EType as EClass).name.normalizeUpperField», $3T.class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
					}
					return «field.name»;
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
					if («field.name» == null) {
						«field.name» = new $1T($2T.class, this, $3T.«field.name.normalizeUpperField(eClass.name)», $3T.«field.EOpposite.name.normalizeUpperField((field.EOpposite.eContainer as EClass).name)»);
					}
					return «field.name»;
				''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentWithInverseEList), rt), rt,
					ePackageInterfaceType).build
			} else {
				MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).applyIfTrue(
					dsl.dslProp.getProperty('truffle', "false") == "true", [
						addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
					]).addModifiers(PUBLIC).addNamedCode('''
					if («field.name» == null) {
						«field.name» = new $eoce:T($rt:T.class, this, $epit:T.«field.name.normalizeUpperField(eClass.name)»);
					}
					return «field.name»;
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
							return «field.name»;
						''').build
				} else {
					MethodSpec.
						methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').
						returns(fieldType).applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [
							addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
						]).addModifiers(PUBLIC).addCode('''
							if («field.name» != null && «field.name».eIsProxy()) {
								$T old«field.name» = ($T) «field.name»;
								«field.name» = ($T) eResolveProxy(old«field.name»);
								if («field.name» != old«field.name») {
									if (eNotificationRequired())
										eNotify(new $T(this, $T.RESOLVE, $T.«field.name.normalizeUpperField(eClass.name)»,
												old«field.name», «field.name»));
								}
							}
							return «field.name»;
						''', TypeName.get(InternalEObject), TypeName.get(InternalEObject), fieldType,
							TypeName.get(ENotificationImpl), TypeName.get(Notification), ePackageInterfaceType).build

				}
			}
		}
	}

}
