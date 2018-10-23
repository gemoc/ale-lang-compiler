package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import javax.lang.model.element.Modifier
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.impl.EFactoryImpl
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils

class FactoryImplementationCompiler {

	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils

	def compileFactoryImplementation(EPackage abstractSyntax, File directory) {

		val allClasses = abstractSyntax.EClassifiers.filter(EClass)

		val factoryInterfaceType = ClassName.get(abstractSyntax.factoryInterfacePackageName,
			abstractSyntax.factoryInterfaceClassName)

		val packageInterfaceType = ClassName.get(abstractSyntax.packageInterfacePackageName,
			abstractSyntax.packageInterfaceClassName)

		val constructor = MethodSpec.constructorBuilder.addModifiers(Modifier.PRIVATE).build

		val ctn = abstractSyntax.name
		val ctnf = '''«ctn.toFirstUpper»Factory'''

		val initMethod = MethodSpec.methodBuilder("init").addModifiers(Modifier.STATIC, Modifier.PUBLIC).returns(
			factoryInterfaceType).addCode('''
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
					return create«eClass.name»();
			«ENDFOR»
			default:
				throw new $2T("The class '" + eClass.getName() + "' is not a valid classifier");
			}
		''', packageInterfaceType, IllegalArgumentException).addModifiers(Modifier.PUBLIC).build

		val createMethods = allClasses.filter[!abstract].map [ eClass |
			val classImplType = ClassName.get(eClass.classImplementationPackageName,
				eClass.classImplementationClassName)
			MethodSpec.methodBuilder('''create«eClass.name.toFirstUpper»''').returns(
				ClassName.get(eClass.classInterfacePackageName, eClass.classInterfaceClassName)).addCode('''
				$1T ret = new $1T();
				return ret;
			''', classImplType).addModifiers(Modifier.PUBLIC).build
		]

		val factory = TypeSpec.classBuilder(abstractSyntax.factoryImplementationClassName).superclass(EFactoryImpl).
			addSuperinterface(factoryInterfaceType).addMethods(#[constructor, initMethod, createMethod] +
				createMethods).addModifiers(Modifier.PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.factoryImplementationPackageName, factory).build

		javaFile.writeTo(directory)
	}
}
