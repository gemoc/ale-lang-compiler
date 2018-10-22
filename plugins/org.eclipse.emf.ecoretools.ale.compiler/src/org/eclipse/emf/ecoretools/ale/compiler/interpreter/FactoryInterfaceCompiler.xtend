package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.TypeSpec
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecore.EFactory
import com.squareup.javapoet.ClassName
import javax.lang.model.element.Modifier
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.JavaFile

class FactoryInterfaceCompiler {
	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils

	def compileFactoryInterface(EPackage abstractSyntax, java.io.File directory) {
		val factoryInterfaceType = ClassName.get(abstractSyntax.factoryInterfacePackageName,
			abstractSyntax.factoryInterfaceClassName)
		val factoryImplType = ClassName.get(abstractSyntax.factoryImplementationPackageName,
			abstractSyntax.factoryImplementationClassName)
		val einstance = FieldSpec.builder(factoryInterfaceType, "eINSTANCE", Modifier.PUBLIC, Modifier.FINAL,
			Modifier.STATIC).initializer('''$T.init()''', factoryImplType).build
		val factory = TypeSpec.interfaceBuilder(abstractSyntax.factoryInterfaceClassName).addSuperinterface(EFactory).
			addField(einstance).addMethods(abstractSyntax.allClasses.map [
				MethodSpec.methodBuilder('''create«it.name.toFirstUpper»''').returns(
					ClassName.get(it.classInterfacePackageName, it.classInterfaceClassName)).addModifiers(
					Modifier.ABSTRACT, Modifier.PUBLIC).build
			]).addModifiers(Modifier.PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.factoryInterfacePackageName, factory).build

		javaFile.writeTo(directory)

	}
}
