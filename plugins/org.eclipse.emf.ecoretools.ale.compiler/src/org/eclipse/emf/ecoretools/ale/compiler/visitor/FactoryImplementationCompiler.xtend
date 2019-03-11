package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.impl.EFactoryImpl
import org.eclipse.emf.ecore.plugin.EcorePlugin

import static javax.lang.model.element.Modifier.*

class FactoryImplementationCompiler {

	extension VisitorCompilerUtils = new VisitorCompilerUtils
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils

	def compileFactoryImplementation(EPackage abstractSyntax, File directory, String packageRoot) {

		val allClasses = abstractSyntax.EClassifiers.filter(EClass)

		val factoryInterfaceType = ClassName.get(abstractSyntax.factoryInterfacePackageName(packageRoot),
			abstractSyntax.factoryInterfaceClassName)

		val packageInterfaceType = ClassName.get(abstractSyntax.packageInterfacePackageName(packageRoot),
			abstractSyntax.packageInterfaceClassName)

		val constructor = MethodSpec.constructorBuilder.addModifiers(PUBLIC).build

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

		val createMethod = MethodSpec.methodBuilder('create').returns(EObject).addParameter(
			ParameterSpec.builder(EClass, 'eClass').build).addCode('''
			switch (eClass.getClassifierID()) {
			«FOR eClass : allClasses.filter[!it.abstract]»
				case $1T.«eClass.name.normalizeUpperField»:
					«IF eClass.instanceClass !== null && eClass.instanceClass == Map.Entry»
						return (org.eclipse.emf.ecore.EObject) create«eClass.name»();
					«ELSE»
						return create«eClass.name»();
					«ENDIF»
			«ENDFOR»
			default:
				throw new $2T("The class '" + eClass.getName() + "' is not a valid classifier");
			}
		''', packageInterfaceType, IllegalArgumentException).addModifiers(PUBLIC).build

		val createMethods = allClasses.filter[!abstract].map [ eClass |
			val returnType = if (eClass.instanceClass !== null && eClass.instanceClass == Map.Entry) {
					// is map
					val key = eClass.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
					val value = eClass.eContents.filter(EStructuralFeature).filter[it.name == "value"].head
					ParameterizedTypeName.get(ClassName.get(Map.Entry), key.EType.scopedInterfaceTypeRef(packageRoot),
						value.EType.scopedInterfaceTypeRef(packageRoot))
				} else {
					ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName)
				}
			val classImplType = ClassName.get(eClass.classImplementationPackageName(packageRoot),
				eClass.classImplementationClassName)

			MethodSpec.methodBuilder('''create«eClass.name.toFirstUpper»''').returns(returnType).addCode('''
				$1T ret = new $1T();
				return ret;
			''', classImplType).addModifiers(PUBLIC).build
		]

		val getPackageMethod = MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Package''').returns(
			packageInterfaceType).addCode('''return ($1T)getEPackage();''', packageInterfaceType).addModifiers(PUBLIC).
			build

		val factory = TypeSpec.classBuilder(abstractSyntax.factoryImplementationClassName).superclass(EFactoryImpl).
			addSuperinterface(factoryInterfaceType).addMethods(
				#[constructor, initMethod, createMethod, getPackageMethod] + createMethods).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.factoryImplementationPackageName(packageRoot), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
}
