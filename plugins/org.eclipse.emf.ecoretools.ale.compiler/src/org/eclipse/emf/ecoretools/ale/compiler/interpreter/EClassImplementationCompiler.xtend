package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.lang.reflect.Modifier
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.And
import org.eclipse.acceleo.query.ast.BooleanLiteral
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.ast.CallType
import org.eclipse.acceleo.query.ast.EnumLiteral
import org.eclipse.acceleo.query.ast.ErrorBinding
import org.eclipse.acceleo.query.ast.ErrorCall
import org.eclipse.acceleo.query.ast.ErrorConditional
import org.eclipse.acceleo.query.ast.ErrorExpression
import org.eclipse.acceleo.query.ast.ErrorStringLiteral
import org.eclipse.acceleo.query.ast.ErrorTypeLiteral
import org.eclipse.acceleo.query.ast.ErrorVariableDeclaration
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.ast.Implies
import org.eclipse.acceleo.query.ast.IntegerLiteral
import org.eclipse.acceleo.query.ast.Lambda
import org.eclipse.acceleo.query.ast.Let
import org.eclipse.acceleo.query.ast.NullLiteral
import org.eclipse.acceleo.query.ast.Or
import org.eclipse.acceleo.query.ast.RealLiteral
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral
import org.eclipse.acceleo.query.ast.SetInExtensionLiteral
import org.eclipse.acceleo.query.ast.StringLiteral
import org.eclipse.acceleo.query.ast.TypeLiteral
import org.eclipse.acceleo.query.ast.VarRef
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.validation.type.EClassifierType
import org.eclipse.acceleo.query.validation.type.SequenceType
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.NotificationChain
import org.eclipse.emf.common.util.BasicEMap
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.impl.ENotificationImpl
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecore.util.EObjectContainmentEList
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList
import org.eclipse.emf.ecore.util.EcoreEMap
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove
import org.eclipse.emf.ecoretools.ale.implementation.ForEach
import org.eclipse.emf.ecoretools.ale.implementation.If
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.ecoretools.ale.implementation.Switch
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.implementation.While

import static javax.lang.model.element.Modifier.*
import com.squareup.javapoet.AnnotationSpec

class EClassImplementationCompiler {
	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	extension InterpreterCompilerUtils = new InterpreterCompilerUtils
	extension JavaPoetUtils = new JavaPoetUtils
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var List<ResolvedClass> resolved
	var Map<String, Class<?>> registeredServices
	var Dsl dsl
	var List<ParseResult<ModelUnit>> parsedSemantics
	var IQueryEnvironment queryEnvironment
	val String packageRoot
	
	new(String packageRoot) {
		this.packageRoot = packageRoot
	}

	private def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass, ExtendedClass aleClass) {
		val ePackageInterfaceType = ClassName.get(eClass.EPackage.packageInterfacePackageName(packageRoot),
			eClass.EPackage.packageInterfaceClassName)

		val hasSuperType = !eClass.ESuperTypes.empty
		val superType = eClass.ESuperTypes.head

		val fieldsEAttributes = eClass.EAttributes.map [ field |
			val type = field.EType.scopedTypeRef(packageRoot)
			val edefault = FieldSpec.builder(type, '''«field.name.toUpperCase»_EDEFAULT''').
				initializer('''«IF field.defaultValue === null || field.defaultValue.toString == ''»null«ELSE»«field.defaultValue»«ENDIF»''').
				addModifiers(PROTECTED, STATIC, FINAL).build

			val fieldField = FieldSpec.builder(type, field.name).initializer('''«field.name.toUpperCase»_EDEFAULT''').
				addModifiers(PROTECTED).build
			#[edefault, fieldField]
		].flatten

		val methodsEAttributes = eClass.EAttributes.map [ field |
			val type = field.EType.scopedTypeRef(packageRoot)

			val getter = MethodSpec.methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').addModifiers(PUBLIC).
				addCode('''return «field.name»;''').returns(type).build
			val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''').addParameter(
				ParameterSpec.builder(type, field.name).build).addCode('''this.«field.name» = «field.name»;''').
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
				
			val isMutable = aleClass !== null && aleClass.mutable.exists[it == field.name]
			FieldSpec.builder(fieldType, field.name).applyIfTrue(dsl.dslProp.getOrDefault("child", "false").equals("true") && !isMultiple && !isMutable && field.containment, [
				addAnnotation(ClassName.get("com.oracle.truffle.api.nodes.Node", "Child"))
			]).addModifiers(PROTECTED).build
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
					val newName = '''new«field.name.toFirstUpper»'''
					val oldName = '''old«field.name.toFirstUpper»'''
					val name = field.name

					if (field.EOpposite !== null) {
						if(!field.EOpposite.containment) {
							val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
							.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
							.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.returns(
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
								ePackageInterfaceType).addModifiers(PRIVATE).build
							
								#[setter, basicSetMethod]
							} else {
								val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
								.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
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
							.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.returns(
								NotificationChain).addParameter(
								ParameterSpec.builder(fieldType, '''new«field.name.toFirstUpper»''').build).addParameter(
								ParameterSpec.builder(NotificationChain, 'msgs').build).addCode('''
								msgs = eBasicSetContainer(($1T)newFsm, $2T.«field.name.normalizeUpperField(eClass.name)», msgs);
								return msgs;
							''', InternalEObject, ePackageInterfaceType).addModifiers(PRIVATE).build
							#[setter, basicSetMethod]
							}

						
						
					} else {
						if(field.containment) {
							val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
							.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
							if («newName» != «field.name») {
								$4T msgs = null;
								if («field.name» != null)
									msgs = (($1T)«field.name»).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
								if («newName» != null)
									msgs = (($1T)«newName»).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», null, msgs);
								msgs = basicSet«field.name.toFirstUpper»(«newName», msgs);
								if (msgs != null) msgs.dispatch();
							}
							else if (eNotificationRequired())
								eNotify(new $2T(this, $3T.SET, «eClass.EPackage.packageInterfacePackageName(packageRoot)».«eClass.EPackage.packageInterfaceClassName».«field.name.normalizeUpperField(eClass.name)», «newName», «newName»));
						''', InternalEObject, ENotificationImpl, Notification, NotificationChain).addModifiers(PUBLIC).build
						val basicSetter = MethodSpec.methodBuilder('''basicSet«field.name.toFirstUpper»''')
						.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
						.returns(NotificationChain)
							.addParameter(ParameterSpec.builder(fieldType, newName).build)
							.addParameter(ParameterSpec.builder(NotificationChain, 'msgs').build)
							.addCode('''
							$1T «oldName» = «field.name»;
							«field.name» = «newName»;
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
								.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
								.returns(
									fieldType).addParameter(ParameterSpec.builder(fieldType, newName).build).addCode('''
									$1T «oldName» = this.«field.name»;
									this.«field.name» = «newName»;
									return «oldName»;
								''', fieldType).
									addModifiers(PUBLIC).build
		
								#[setter]						
							} else {
								val setter = MethodSpec.methodBuilder('''set«field.name.toFirstUpper»''')
								
								.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
								.addParameter(
									ParameterSpec.builder(fieldType, newName).build).addCode('''
									$1T «oldName» = «field.name»;
									«field.name» = «newName»;
									if (eNotificationRequired())
										eNotify(new $2T(this, $3T.SET, $4T.«field.name.normalizeUpperField(eClass.name)», «oldName», «field.name»));
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
					MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType)
					.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.addModifiers(PUBLIC).addCode('''
								if («field.name» == null) {
									«field.name» = new $1T($2T.Literals.«(field.EType as EClass).name.normalizeUpperField», $3T.class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
								}
								return «field.name»;
							''', ParameterizedTypeName.get(ClassName.get(EcoreEMap), key.EType.scopedInterfaceTypeRef(packageRoot), value.EType.scopedInterfaceTypeRef(packageRoot)), ePackageInterfaceType,
							ClassName.get((field.EType as EClass).classImplementationPackageName(packageRoot), (field.EType as EClass).classImplementationClassName)).build
							// EcoreEMap<String,EvalRes>
				}
					else if(field.EOpposite !== null) {
						MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType)
						.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.addModifiers(PUBLIC).addCode('''
								if («field.name» == null) {
									«field.name» = new $1T($2T.class, this, $3T.«field.name.normalizeUpperField(eClass.name)», $3T.«field.EOpposite.name.normalizeUpperField((field.EOpposite.eContainer as EClass).name)»);
								}
								return «field.name»;
							''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentWithInverseEList), rt), rt, ePackageInterfaceType).build
					} else {
						MethodSpec.methodBuilder('''get«field.name.toFirstUpper»''').returns(fieldType)
						.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.addModifiers(PUBLIC).addCode('''
								if(«field.name» == null) {
									«field.name» = new $1T(«rt».class, this, $2T.«field.name.normalizeUpperField(eClass.name)»);
								}
								return «field.name»;
							''', ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList), rt),
								ePackageInterfaceType).build
					}
				} else {
					if(field.EOpposite !== null && field.EOpposite.containment) {
						MethodSpec.methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').returns(fieldType)
						.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
						.addModifiers(PUBLIC).addCode('''
						if (eContainerFeatureID() != $1T.«field.name.normalizeUpperField(eClass.name)») return null;
						return ($2T)eInternalContainer();
						''', ePackageInterfaceType, fieldType).build
					}  else {
						MethodSpec.methodBuilder('''«IF field.EType.name == "EBoolean"»is«ELSE»get«ENDIF»«field.name.toFirstUpper»''').returns(fieldType)
							.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
							.addModifiers(PUBLIC).addCode('''return «field.name»;''').build
					}
				}

			setter + #[getter]
		].flatten

		val eStaticClassMethod = MethodSpec.methodBuilder('eStaticClass').returns(EClass).addModifiers(PROTECTED)
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
			.addCode('''return $1T.Literals.«eClass.name.normalizeUpperField»;''', ePackageInterfaceType).build

		val eSetMethod = MethodSpec.methodBuilder('eSet').addParameter(int, 'featureID')
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
			.addParameter(Object, 'newValue').addModifiers(PUBLIC).addCode( '''
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

		val eUnsetMethod = MethodSpec.methodBuilder('eUnset').addParameter(int, 'featureID').addModifiers(PUBLIC)
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
			.addCode('''
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

		val eGetMethod = MethodSpec.methodBuilder('eGet').returns(Object).addParameter(int, 'featureID')
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
			.addParameter(boolean, 'resolve').addParameter(boolean, 'coreType').addModifiers(PUBLIC).addCode('''
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

		val eIsSetMethod = MethodSpec.methodBuilder('eIsSet').returns(boolean).addParameter(int, 'featureID')
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
			.addModifiers(PUBLIC).addCode( '''
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
						.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
						.addParameter(InternalEObject, 'otherEnd').addParameter(int, 'featureID').addParameter(NotificationChain, 'msgs2').addCode('''
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
				
				
		val eInverseRemove = MethodSpec.methodBuilder('eInverseRemove').returns(NotificationChain).addModifiers(PUBLIC)
			.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
			.addParameter(ParameterSpec.builder(InternalEObject, 'otherEnd').build).addParameter(
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
			«IF aleClass !== null»
			«FOR method: aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true']»
			this.dispatch«method.operationRef.name.toFirstUpper» = com.oracle.truffle.api.Truffle.getRuntime().createIndirectCallNode();
			«ENDFOR»
			«ENDIF»
		''').addModifiers(PROTECTED).build

		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
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
				superclass(ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.truffle", "MinimalTruffleEObjectImpl", "TruffleContainer"))
			} else {
				superclass(ClassName.get(MinimalEObjectImpl.Container))
			}
		]).applyIfTrue(
			!isMapElement, [
				addSuperinterface(ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName))
			]).addFields(fieldsEAttributes + fieldsEReferences).addMethods(
			methodsEAttributes + methodsEReferences +
				#[eStaticClassMethod, eSetMethod, eUnsetMethod, eGetMethod, eIsSetMethod, constructor, eInverseRemove] +
				eInverseAdd).applyIfTrue(isMapElement, [
			it.addField(FieldSpec.builder(int, 'hash', PROTECTED).initializer('-1').build).addMethod(
				MethodSpec.methodBuilder('setHash')
					.applyIfTrue(dsl.dslProp.getProperty('truffle', "false") == "true", [addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))])
					.addParameter(int, 'hash').addCode('''
					this.hash = hash;
				''').addModifiers(PUBLIC).build).addMethod(MethodSpec.methodBuilder('getHash').addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary")).returns(int).addCode('''
				if (hash == -1) {
					Object theKey = getKey();
					hash = (theKey == null ? 0 : theKey.hashCode());
				}
				return hash;
			''').addModifiers(PUBLIC).build)
		])
	}

	def compileEClassImplementation(EClass eClass, ExtendedClass aleClass, File directory,
		Map<String, Pair<EPackage, GenModel>> syntaxes, List<ResolvedClass> resolved,
		Map<String, Class<?>> registeredServices, Dsl dsl, List<ParseResult<ModelUnit>> parsedSemantics,
		IQueryEnvironment queryEnvironment) {
		this.syntaxes = syntaxes
		this.resolved = resolved
		this.registeredServices = registeredServices
		this.dsl = dsl
		this.parsedSemantics = parsedSemantics
		this.queryEnvironment = queryEnvironment
		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName).compileEcoreRelated(eClass, aleClass).
			applyIfTrue(aleClass !== null, [
				addMethods(
				aleClass.methods.filter[!(it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true')].map [
					compile(aleClass, eClass)
				])
			]).applyIfTrue(dsl.dslProp.getOrDefault("truffle", "false") == "true", [
				addAnnotation(
					AnnotationSpec.builder(ClassName.get("com.oracle.truffle.api.nodes", "NodeInfo")).addMember(
						"description", '$S', eClass.name).build
				)
			]).applyIfTrue(aleClass !== null, [
				addFields(aleClass.methods.filter [
					it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'
				].map [
					FieldSpec.builder(
						ClassName.get('com.oracle.truffle.api.nodes', 'IndirectCallNode'), '''dispatch«it.operationRef.name.toFirstUpper»''').
						addModifiers(PRIVATE).addAnnotation(
							ClassName.get("com.oracle.truffle.api.nodes.Node", "Child")).build
				])
			]).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factory).build
		javaFile.writeTo(directory)
		
	//	generateDispatchClasses(aleClass, directory, eClass)

	}
	
	def generateDispatchClasses(ExtendedClass aleClass, File directory, EClass eClass) {
		if (aleClass !== null) {
			// Generation of the dispatch classes
			aleClass.methods.filter[it.dispatch && dsl.dslProp.getOrDefault('dispatch', 'false') == 'true'].forEach [ method |

				val factoryDispatch = TypeSpec.
					classBuilder('''«eClass.name»Dispatch«method.operationRef.name.toFirstUpper»''').superclass(
						ClassName.get("com.oracle.truffle.api.nodes", "Node")).addField(
						FieldSpec.builder(int, 'INLINE_CACHE_SIZE', PUBLIC, STATIC, FINAL).initializer('3').build).
					addMethod(
						MethodSpec.methodBuilder('''executeDispatch''').addModifiers(PUBLIC, ABSTRACT).
							addParameter(Object, 'function').addParameter(typeof(Object[]), 'arguments').
							returns(Object).build).addMethod(
						MethodSpec.methodBuilder('doDirect').addAnnotation(
							AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Specialization')).
								addMember('limit', '"INLINE_CACHE_SIZE"').addMember('guards',
									'"function.getCallTarget() == cached"') // TODO: find out how to identify the name of the operation to call on the function
								.addMember('assumptions', '"callTargetStable"').build
						).addModifiers(PROTECTED, STATIC).returns(Object).addParameter(
							ParameterSpec.builder(method.operationRef.EParameters.head.EType.resolveType, 'function').
								build
						).addParameter(typeof(Object[]), 'arguments').addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api', 'Assumption'),
								'callTargetStable').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"function.getCallTargetStable()"') // TODO: how to add such operations on the SLFunction ? // do wo infere that we have to add them since it is used as a first parameter of a dispatch somewhere ?
									.build
							).build
						).addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api', 'RootCallTarget'),
								'cachedTarget').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"function.getCallTarget()"') // TODO: how to add such operations on the SLFunction ? // do wo infere that we have to add them since it is used as a first parameter of a dispatch somewhere ?
									.build
							).build
						).addParameter(
							ParameterSpec.builder(ClassName.get('com.oracle.truffle.api.nodes', 'DirectCallNode'),
								'callNode').addAnnotation(
								AnnotationSpec.builder(ClassName.get('com.oracle.truffle.api.dsl', 'Cached')).
									addMember('value', '"create(cachedTarget)"') // TODO: how to add such operations on the SLFunction ? // do wo infere that we have to add them since it is used as a first parameter of a dispatch somewhere ?
									.build
							).build
						)
						.addCode("return callNode.call(arguments);")
						.build
					).addModifiers(PUBLIC, ABSTRACT).build

				val javaFileDispatch = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factoryDispatch).build
				javaFileDispatch.writeTo(directory)

			]
		}
	}

	def MethodSpec compile(Method method, ExtendedClass aleClass, EClass aClass) {
		val retType = if (method.operationRef.EType !== null) {
				if (method.operationRef.EType instanceof EClass &&
					!(method.operationRef.EType.EPackage == EcorePackage.eINSTANCE)) {
					ClassName.get((method.operationRef.EType as EClass).classInterfacePackageName(packageRoot),
						(method.operationRef.EType as EClass).name)
				} else {
					TypeName.get(method.operationRef.EType.instanceClass)

				}
			} else
				null

		MethodSpec.methodBuilder(method.operationRef.name).addModifiers(PUBLIC).applyIfTrue(retType !== null, [
			returns(retType)
		]).addParameters(method.operationRef.EParameters.map [
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
		]).openMethod(method.operationRef.EType).compileBody(method.body).closeMethod(method.operationRef.EType).build
	}

	def MethodSpec.Builder closeMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement("return result")
		} else {
			builder
		}
	}

	def resolveType(EClassifier e) {
		val stxs = syntaxes.values + #[(EcorePackage.eINSTANCE -> null)]
		val stx = stxs.filter [
			it.key.allClasses.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			if (e instanceof EClass) {
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
			} else {
				val GenClass gclass = gm.allGenPkgs.map [
					it.genClasses.filter [
						it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
					]
				].flatten.head
				val split = gclass.qualifiedInterfaceName.split("\\.")
				val pkg = newArrayList(split).reverse.tail.toList.reverse.join(".")
				val cn = split.last
				ClassName.get(pkg, cn)

			}
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}

	}

	def MethodSpec.Builder openMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement('''$T result''', type.solveType)
		} else {
			builder
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureAssignment body) {
		val t = infereType(body.target).head
		if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
			builderSeed.
				addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression»)''')
		} else if (t.type instanceof EClass || t.type instanceof EDataType) {
			builderSeed.
				addStatement('''«body.target.compileExpression.escapeDollar».set«body.targetFeature.toFirstUpper»(«body.value.compileExpression.escapeDollar»)''')
		} else {
			builderSeed.
				addStatement('''«body.target.compileExpression».«body.targetFeature» = «body.value.compileExpression»''')

		}

	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureInsert body) {
		builderSeed.
			addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().add(«body.value.compileExpression»)''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeatureRemove body) {
		builderSeed.
			addStatement('''«body.target.compileExpression».get«body.targetFeature.toFirstUpper»().remove(«body.value.compileExpression»)''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableAssignment body) {
		builderSeed.addStatement('''«body.name» = «body.value.compileExpression.escapeDollar»''')
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, VariableDeclaration body) {

		val inft = body.initialValue.infereType.head
		if (inft instanceof SequenceType) {
			val t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"),
				ClassName.get(inft.collectionType.type as Class<?>))
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression.escapeDollar»)''', t,
				body.name, t)
		} else {
			val t = body.type.solveType
			// TODO: the cast shold be conditional and only happend is a oclIsKindOf/oclIsTypeOf hapenned in a parent branch.
			builderSeed.addStatement('''$T $L = (($T)«body.initialValue.compileExpression.escapeDollar»)''', t,
				body.name, t)

		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, Block body) {
		body.statements.fold(builderSeed, [ builder, statement |
			builder.compileBody(statement)
		])
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ExpressionStatement body) {
		builderSeed.addStatement(body.expression.compileExpression.escapeDollar)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, FeaturePut body) {
		builderSeed.addStatement('''throw new $T("FeaturePut not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ForEach body) {
		val lt = infereType(body.collectionExpression).head as SequenceType

		if (lt.collectionType.type instanceof EClass) {
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression»)''',
				(lt.collectionType.type as EClass).solveType, body.variable).compileBody(body.body).endControlFlow
		} else {
			builderSeed.beginControlFlow('''for($T $L: «body.collectionExpression.compileExpression»)''',
				lt.collectionType.type as Class<?>, body.variable).compileBody(body.body).endControlFlow
		}
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, If body) {
		var ret = builderSeed.beginControlFlow('''if($L)''', body.blocks.head.condition.compileExpression).compileBody(
			body.blocks.head.block).endControlFlow
		for (ConditionalBlock x : body.blocks.tail) {
			ret = ret.beginControlFlow('''else if ($L''', x.condition.compileExpression).compileBody(x.block).
				endControlFlow
		}
		if (body.^else !== null)
			ret = ret.beginControlFlow("else").compileBody(body.^else).endControlFlow
		ret
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, ConditionalBlock body) {
		builderSeed.addStatement('''throw new $T("ConditionalBlock not implemented")''', RuntimeException)
	}

	def dispatch MethodSpec.Builder compileBody(MethodSpec.Builder builderSeed, While body) {
		val a = builderSeed.beginControlFlow("while ($L)", body.condition.compileExpression)
		a.compileBody(body.body).endControlFlow
	}

	def dispatch String compileExpression(Call call) {
		switch (call.serviceName) {
			case "not": '''!(«call.arguments.get(0).compileExpression»)'''
			case "greaterThan": '''(«call.arguments.get(0).compileExpression») > («call.arguments.get(1).compileExpression»)'''
			case "differs": '''(«call.arguments.get(0).compileExpression») != («call.arguments.get(1).compileExpression»)'''
			case "sub": '''(«call.arguments.get(0).compileExpression») - («call.arguments.get(1).compileExpression»)'''
			case "add": '''(«call.arguments.get(0).compileExpression») + («call.arguments.get(1).compileExpression»)'''
			case "divOp": '''(«call.arguments.get(0).compileExpression») / («call.arguments.get(1).compileExpression»)'''
			case "equals": '''java.util.Objects.equals((«call.arguments.get(0).compileExpression»), («call.arguments.get(1).compileExpression»))'''
			case "lessThan": '''(«call.arguments.get(0).compileExpression») < («call.arguments.get(1).compileExpression»)'''
			case "mult": '''(«call.arguments.get(0).compileExpression») * («call.arguments.get(1).compileExpression»)'''
			case "unaryMin": '''-(«call.arguments.get(0).compileExpression»)'''
			case "first":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(«call.arguments.get(0).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "size":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(«call.arguments.get(0).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "at":
				if (call.type == CallType.COLLECTIONCALL)
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
				else
					'''/*FIRST «call»*/'''
			case "select":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "filter":
				if (call.type == CallType.COLLECTIONCALL) {
					val t = infereType(call.arguments.get(1)).head
					if (t instanceof EClassifierType) {
						'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», it -> it instanceof «call.arguments.get(1).compileExpression»)'''
					} else {
						'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(«call.arguments.get(0).compileExpression», «call.arguments.get(1).compileExpression»)'''
					}
				} else {
					'''/*FIRST «call»*/'''
				}
			case "isEmpty":
				if (call.type == CallType.COLLECTIONCALL) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(«call.arguments.get(0).compileExpression»)'''
				} else {
					'''/*FIRST «call»*/'''
				}
			case "oclIsKindOf":
				if (call.type == CallType.CALLORAPPLY) {
					'''«call.arguments.get(0).compileExpression» instanceof «call.arguments.get(1).compileExpression»'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			case "log":
				if (call.type == CallType.CALLORAPPLY) {
					'''org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(«call.arguments.get(0).compileExpression»)'''
				} else {
					'''/*OCLISKINDOF*/'''
				}
			default:
				if (call.type == CallType.CALLORAPPLY)
					if (call.serviceName == 'aqlFeatureAccess') {
						val t = infereType(call).head
						if (t instanceof SequenceType && (t as SequenceType).collectionType.type instanceof EClass) {
							'''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else if (t.type instanceof EClass || t.type instanceof EDataType) {
							if (t.type instanceof EDataType && ((t.type as EDataType).instanceClass == Boolean ||
								(t.type as EDataType).instanceClass == boolean))
								'''«call.arguments.head.compileExpression».is«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
							else
								'''«call.arguments.head.compileExpression».get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()'''
						} else {
							'''«call.arguments.head.compileExpression».«IF call.arguments.get(1) instanceof StringLiteral»get«(call.arguments.get(1) as StringLiteral).value.toFirstUpper»()«ELSE»«call.arguments.get(1).compileExpression»«ENDIF»'''

						}
					} else if (call.serviceName == 'create') {
						val e = call.arguments.get(0)
						val t = infereType(e).head
						val ecls = t.type as EClass
						val epks = ecls.EPackage
						'''«epks.factoryInterfacePackageName(packageRoot)».«epks.factoryInterfaceClassName».eINSTANCE.create«ecls.name»()'''
					} else {
						val argumentsh = call.arguments.head
						val ts = argumentsh.infereType
						val t = ts.head
						val re = resolved.filter [
							if (t.type instanceof EClass) {
								val tecls = t.type as EClass
								it.ECls.name == tecls.name && it.ECls.EPackage.name == tecls.EPackage.name
							} else {
								false
							}
						].head
						if (re !== null) {
							val allMethods = re.getAleCls.allMethods
							val methodExist = allMethods.exists [
								it.operationRef.name == call.serviceName
							]
							if (methodExist) {
								val method = allMethods.filter[it.operationRef.name == call.serviceName].head
								if(method.isDispatch) {
									'''this.dispatch«method.operationRef.name.toFirstUpper».call(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
								} else {
									'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''
								}
							} else {

								val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].
									flatten.toList

								val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
									it.value.name == call.serviceName
								].head

								if (candidate !== null) {
									'''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)'''
								} else {
									'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''

								}
							}
						} else {
							val methods = registeredServices.entrySet.map[e|e.value.methods.map[e.key -> it]].flatten

							val candidate = methods.filter[Modifier.isStatic(it.value.modifiers)].filter [
								it.value.name == call.serviceName
							].head

							if (candidate !== null) {
								'''«candidate.key».«candidate.value.name»(«FOR p : call.arguments SEPARATOR ', '»«p.compileExpression»«ENDFOR»)'''
							} else {
								'''«call.arguments.head.compileExpression».«call.serviceName»(«FOR param : call.arguments.tail SEPARATOR ','»«param.compileExpression»«ENDFOR»)'''

							}
						}
					}
				else
					'''/*Call «call»*/'''
		}
	}

	def dispatch String compileExpression(And call) {
		'''((«call.arguments.get(0).compileExpression») && («call.arguments.get(1).compileExpression»))'''
	}

	def dispatch String compileExpression(ErrorCall call) {
		'''/*ERRORCALL*/'''
	}

	def dispatch String compileExpression(Implies call) {
		'''/*IMPLIES*/'''
	}

	def dispatch String compileExpression(Or call) {
		'''((«call.arguments.get(0).compileExpression») || («call.arguments.get(1).compileExpression»))'''
	}

	def dispatch String compileExpression(ErrorConditional call) {
		'''/*ERRORCONDITIONAL*/'''
	}

	def dispatch String compileExpression(ErrorBinding call) {
		'''/*ERRORBINDING*/'''
	}

	def dispatch String compileExpression(EEnumLiteral call) {
		'''/*EENUMLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorExpression call) {
		'''/*ERROREXPRESSION*/'''
	}

	def dispatch String compileExpression(ErrorStringLiteral call) {
		'''/*ERRORSTRINGLITERAL*/'''
	}

	def dispatch String compileExpression(ErrorTypeLiteral call) {
		'''/*ERRORTYPELITERAL*/'''
	}

	def dispatch String compileExpression(ErrorVariableDeclaration call) {
		'''/*ERRORVARIABLEDECLARATION*/'''
	}

	def dispatch String compileExpression(Let call) {
		'''/*let*/'''
	}

	def dispatch String compileExpression(BooleanLiteral call) {
		if(call.value) 'true' else 'false'
	}

	def dispatch String compileExpression(EnumLiteral call) {
		'''/*ENUMLITERAL*/'''
	}

	def dispatch String compileExpression(IntegerLiteral call) {
		call.value.toString
	}

	def dispatch String compileExpression(Lambda call) {
		'''(«FOR p : call.parameters SEPARATOR ', '»«p.name»«ENDFOR») -> «call.expression.compileExpression»'''
	}

	def dispatch String compileExpression(NullLiteral call) {
		'null'
	}

	def dispatch String compileExpression(RealLiteral call) {
		call.value.toString
	}

	def dispatch String compileExpression(SequenceInExtensionLiteral call) {
		'''org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.createEList(«FOR a : call.values SEPARATOR ', '»«a.compileExpression»«ENDFOR»)'''
	}

	def dispatch String compileExpression(SetInExtensionLiteral call) {
		'''/*SETINEXTENSIONLITERAL*/'''
	}

	def dispatch String compileExpression(StringLiteral call) {
		'''"«call.value»"'''
	}

	def dispatch String compileExpression(TypeLiteral call) {
		'''«(call.value as EClass).solveType»'''
	}

	def dispatch String compileExpression(Switch call) {
		'''/*SWITCH*/'''
	}

	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def dispatch String compileExpression(VarRef call) {
		if(call.variableName == 'self') 'this' else call.variableName
	}

	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		edt.instanceClass
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

	def infereType(Expression exp) {
		val base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		base.getPossibleTypes(exp)
	}

	def escapeDollar(String s) {
		s.replaceAll("\\$\\(", "\\$\\$(")
	}

	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}

	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls

		resolved.filter[it.eCls == ecls || it.eCls.isSuperTypeOf(ecls)].map [
			it.aleCls
		].filter[it !== null]
	}
}
