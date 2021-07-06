package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Locale
import java.util.Map
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.impl.EFactoryImpl
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment

import static javax.lang.model.element.Modifier.*

class FactoryImplementationCompiler {

	extension EcoreGenNamingUtils namingUtils
	extension CommonCompilerUtils ccu
	extension TruffleHelper th
	IAleEnvironment dsl
	extension CompilerDsl compilerDsl = new CompilerDsl
	
	new(EcoreGenNamingUtils namingUtils, CommonCompilerUtils ccu, TruffleHelper th, IAleEnvironment dsl) {
		this.namingUtils = namingUtils
		this.ccu = ccu
		this.th = th
		this.dsl = dsl
	}

	def compileFactoryImplementation(EPackage abstractSyntax, File directory, String packageRoot) {
		this.compileFactoryImplementation(abstractSyntax, directory, packageRoot, false)
	}

	def compileFactoryImplementation(EPackage abstractSyntax, File directory, String packageRoot, boolean isTruffle) {
		val allClasses = abstractSyntax.EClassifiers.filter(EClass)
		val allEnum = abstractSyntax.EClassifiers.filter(EEnum)

		val factoryInterfaceType = abstractSyntax.factoryIntClassName(packageRoot) 		
		val packageInterfaceType = abstractSyntax.packageIntClassName(packageRoot) 
		
		val constructor = MethodSpec.constructorBuilder.addModifiers(PUBLIC)
			.addCode('''
			super();
			''')
			.build

		val ctn = abstractSyntax.name
		val ctnf = '''«ctn.toFirstUpper»Factory'''

		val initMethod = MethodSpec.methodBuilder("init").addModifiers(STATIC, PUBLIC).returns(factoryInterfaceType).
			addCode('''
				try {
					«ctnf» the«ctnf» = («ctnf») $T.INSTANCE.getEFactory($T.eNS_URI);
					if (the«ctnf» != null) {
						return the«ctnf»;
					}
				} catch (Exception exception) {
					$T.INSTANCE.log(exception);
				}
				return new «ctnf»Impl();
			''', EPackage.Registry, packageInterfaceType, EcorePlugin).build

		val createMethod = MethodSpec.methodBuilder('create')
			.addAnnotation(Override)
			.returns(EObject)
			.addTruffleBoundaryAnnotation(isTruffle)
			.addParameter(ParameterSpec.builder(EClass, 'eClass').build)
			.addNamedCode('''
			switch (eClass.getClassifierID()) {
				«FOR eClass : allClasses.filter[!it.abstract]» 
				case $pit:T.«eClass.name.normalizeUpperField» :
					«IF eClass.instanceClass !== null && eClass.instanceClass == Map.Entry»
					return ($eo:T) create«eClass.name»();
					«ELSE»
					return create«eClass.name»();
					«ENDIF»
				«ENDFOR»
				default :
					throw new $iae:T("The class '" + eClass.getName() + "' is not a valid classifier");
			}
		''', newHashMap(
			"pit" -> packageInterfaceType,
			"iae" -> IllegalArgumentException,
			"eo" -> EObject
			
		)).addModifiers(PUBLIC).build
		
		val createFromStringMethodMap = newHashMap(
			"iae" -> ClassName.get(IllegalArgumentException)	
		)
		
		for(eEnum: allEnum) {
			val packageClassName =  abstractSyntax.packageIntClassName(packageRoot)
			createFromStringMethodMap.put('''type«eEnum.name»'''.toString, packageClassName)
		}
		
		val createFromStringMethod = if(!allEnum.empty) {
			#[MethodSpec
			.methodBuilder('createFromString')
			.addAnnotation(Override)
			.returns(Object)
			.addParameter(ClassName.get('org.eclipse.emf.ecore', 'EDataType'), 'eDataType')
			.addParameter(String, 'initialValue')
			.addNamedCode('''
			switch (eDataType.getClassifierID()) {
				«FOR eEnum:allEnum»
				case $type«eEnum.name»:T.«eEnum.name.normalizeUpperField» :
					return create«eEnum.name»FromString(eDataType, initialValue);
				«ENDFOR»
				default :
					throw new $iae:T("The datatype '" + eDataType.getName() + "' is not a valid classifier");
			}
			''', createFromStringMethodMap)
			.addModifiers(PUBLIC)
			.build, MethodSpec
			.methodBuilder('convertToString')
			.returns(String)
			.addAnnotation(Override)
			.addParameter(ClassName.get('org.eclipse.emf.ecore', 'EDataType'), 'eDataType')
			.addParameter(Object, 'instanceValue')
			.addNamedCode('''
			switch (eDataType.getClassifierID()) {
				«FOR eEnum: allEnum»
				case $type«eEnum.name»:T.«eEnum.name.normalizeUpperField» :
					return convert«eEnum.name»ToString(eDataType, instanceValue);
				«ENDFOR»
				default :
					throw new $iae:T("The datatype '" + eDataType.getName() + "' is not a valid classifier");
			}
			''', createFromStringMethodMap)
			.addModifiers(PUBLIC)
			.build]
			
			} else #[]
			
	
			
		val methodsFromString = allEnum.map[eEnum|
			
			val enumType = ClassName.get(eEnum.classInterfacePackageName(packageRoot), eEnum.classInterfaceClassName)
			val methodFrom  = MethodSpec
				.methodBuilder('''create«eEnum.name»FromString''')
				.returns(enumType)
				.addParameter(ClassName.get('org.eclipse.emf.ecore', 'EDataType'), 'eDataType')
				.addParameter(String, 'initialValue')
				.addCode('''
				$1T result = $1T.get(initialValue);
				if (result == null)
					throw new IllegalArgumentException(
							"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				return result;
				''', enumType)
				.addModifiers(PUBLIC)
				.build
			val methodTo = MethodSpec
				.methodBuilder('''convert«eEnum.name»ToString''')
				.addParameter(ClassName.get('org.eclipse.emf.ecore', 'EDataType'), 'eDataType')
				.addParameter(Object, 'instanceValue')
				.returns(String)
				.addCode('''
				return instanceValue == null ? null : instanceValue.toString();
				''')
				.addModifiers(PUBLIC)
				.build
			
			#[methodFrom, methodTo]
		].flatten
			

		val createMethods = allClasses.filter[!abstract].map [ eClass |
			val returnType = if (eClass.instanceClass !== null && eClass.instanceClass == Map.Entry) {
					// is map
					val key = eClass.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
					val value = eClass.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
					ParameterizedTypeName.get(ClassName.get(Map.Entry), key.resolveFieldType(packageRoot),
						value.resolveFieldType(packageRoot))
				} else {
					if(dsl.truffle)
						ClassName.get(eClass.classImplementationPackageName(packageRoot), eClass.classImplementationClassName)
					else
						ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName)
				}
			val classImplType = ClassName.get(eClass.classImplementationPackageName(packageRoot),
				eClass.classImplementationClassName)


			val safeName = CodeGenUtil.uncapPrefixedName(eClass.name, false, Locale.^default).normalizeVarName
			MethodSpec.methodBuilder('''create«eClass.name.toFirstUpper»''')
				.addTruffleBoundaryAnnotation(isTruffle)
				.returns(returnType)
				.addCode('''
					$1T «safeName» = new $1T();
					return «safeName»;
				''', classImplType)
				.addModifiers(PUBLIC)
				.build
		]

		val getPackageMethod = MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Package''').returns(
			packageInterfaceType).addCode('''
			return ($1T) getEPackage();
			''', packageInterfaceType).addModifiers(PUBLIC).
			build
			
		val getDeprecatedPackageMethod = MethodSpec.methodBuilder('''getPackage''')
			.addAnnotation(Deprecated)
			.returns(packageInterfaceType)
			.addCode('''
				return $1T.eINSTANCE;
			''', packageInterfaceType)
			.addModifiers(PUBLIC, STATIC).build

		val factory = TypeSpec.classBuilder(abstractSyntax.factoryImplementationClassName).superclass(EFactoryImpl)
			.addSuperinterface(factoryInterfaceType)
			.addMethods(#[initMethod, constructor, createMethod] + createFromStringMethod + createMethods + methodsFromString + #[getPackageMethod,getDeprecatedPackageMethod])
			.addModifiers(PUBLIC)
			.build

		val javaFile = JavaFile.builder(abstractSyntax.factoryImplementationPackageName(packageRoot), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
}
