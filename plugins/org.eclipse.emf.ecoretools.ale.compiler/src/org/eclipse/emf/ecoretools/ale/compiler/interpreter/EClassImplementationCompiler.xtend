package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.xtext.xbase.lib.Functions.Function1

import static javax.lang.model.element.Modifier.*
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.ENotificationImpl
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.util.EObjectContainmentEList

class EClassImplementationCompiler {
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	extension InterpreterCompilerUtils = new InterpreterCompilerUtils

	private def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass) {

		// TODO add annotation if compiler to truffle target
		val hasSuperType = !eClass.ESuperTypes.empty
		val superType = eClass.ESuperTypes.head

		val fieldsEAttributes = eClass.EAttributes.map [ field |
			val type = field.EType.scopedTypeRef
			val edefault = FieldSpec.builder(type, '''«field.name.toUpperCase»_EDEFAULT''').
				initializer('''«IF field.defaultValue === null || field.defaultValue.toString == ''»null«ELSE»«field.defaultValue»«ENDIF»''').
				addModifiers(PRIVATE).build

			val fieldField = FieldSpec.builder(type, field.name).initializer('''«field.name.toUpperCase»_EDEFAULT''').
				addModifiers(PRIVATE).build
			#[edefault, fieldField]
		].flatten

		val methodsEAttributes = eClass.EAttributes.map [ field |
			val type = field.EType.scopedTypeRef

			val getter = MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').addModifiers(PUBLIC).
				addCode('''return «field.name»;''').returns(type).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(
				ParameterSpec.builder(type, field.name).build).addCode('''this.«field.name» = «field.name»;''').
				addModifiers(PUBLIC).build

			#[getter, setter]
		].flatten

		val fieldsEReferences = eClass.EReferences.map [ field |
			val rt = field.EGenericType.ERawType.scopedInterfaceTypeRef
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if(isMultiple) ParameterizedTypeName.get(ClassName.get(EList), rt) else rt

			// TODO: modify grammar to have explicit mutability
//				val isMutable = alexClass !== null && alexClass.mutables.exists[
//					it.name == field.name
//				]
			val fieldField = FieldSpec.builder(fieldType, field.name).addModifiers(PRIVATE).build
			#[fieldField]
		].flatten

		val methodsEReferences = eClass.EReferences.map [ field |
			val rt = field.EGenericType.ERawType.scopedInterfaceTypeRef
			val isMultiple = field.upperBound > 1 || field.upperBound < 0
			val fieldType = if(isMultiple) ParameterizedTypeName.get(ClassName.get(EList), rt) else rt

			val setter = if (!isMultiple) {
					val newName = '''new«field.name.toFirstUpper»'''
					val name = field.name

					val setterMethod = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(
						ParameterSpec.builder(fieldType, newName).build).addCode('''
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
						ClassName.get(eClass.EPackage.packageInterfacePackageName,
							eClass.EPackage.packageInterfaceClassName)).addModifiers(PUBLIC).build

					val oldName = '''old«field.name.toFirstUpper»'''

					val basicSetMethod = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''').returns(
						NotificationChain).addParameter(
						ParameterSpec.builder(fieldType, '''new«field.name.toFirstUpper»''').build).addParameter(
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
						ClassName.get(eClass.EPackage.packageInterfacePackageName,
							eClass.EPackage.packageInterfaceClassName)).addModifiers(PRIVATE).build
					#[setterMethod, basicSetMethod]
				} else
					#[]

			val getter = if (isMultiple) {

					MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
						addModifiers(PUBLIC).addCode('''
							if(«field.name» == null) {
								«field.name» = new $1T(«rt».class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
							}
							return «field.name»;
						''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList), rt),
							ClassName.get(eClass.EPackage.packageInterfacePackageName,
								eClass.EPackage.packageInterfaceClassName)).build

				} else {
					MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType).
						addModifiers(PUBLIC).addCode('''return «field.name»;''').build
				}

			setter + #[getter]
		].flatten

		builder.applyIfTrue(eClass.isAbstract, [addModifiers(ABSTRACT)]).applyIfTrue(hasSuperType, [
			superclass(ClassName.get(superType.classImplementationPackageName, superType.classImplementationClassName))
		]).applyIfTrue(!hasSuperType, [superclass(ClassName.get(MinimalEObjectImpl.Container))]).addSuperinterface(
			ClassName.get(eClass.classInterfacePackageName, eClass.classInterfaceClassName)).addFields(
			fieldsEAttributes + fieldsEReferences).addMethods(methodsEAttributes + methodsEReferences)
	}

	def <T> T applyIfTrue(T t, Boolean cond, Function1<T, T> app) {
		if (cond) {
			app.apply(t)
		} else {
			t
		}
	}

	def compileEClassImplementation(EClass eClass, ExtendedClass aleClass, File directory) {

		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName).compileEcoreRelated(eClass).
			addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName, factory).build

		javaFile.writeTo(directory)

	}
}
