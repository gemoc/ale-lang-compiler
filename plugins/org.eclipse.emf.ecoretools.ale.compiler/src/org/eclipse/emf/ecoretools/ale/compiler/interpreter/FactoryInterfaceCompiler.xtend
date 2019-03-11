package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.TypeSpec
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EFactory
import com.squareup.javapoet.ClassName
import static javax.lang.model.element.Modifier.*
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.JavaFile
import org.eclipse.emf.ecore.EClass
import java.util.Map

class FactoryInterfaceCompiler {
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils

	def compileFactoryInterface(EPackage abstractSyntax, java.io.File directory, String packageRoot) {
		val factoryInterfaceType = ClassName.get(abstractSyntax.factoryInterfacePackageName(packageRoot),
			abstractSyntax.factoryInterfaceClassName)
		val packageInterfaceType = ClassName.get(abstractSyntax.packageInterfacePackageName(packageRoot),
			abstractSyntax.packageInterfaceClassName)
		val factoryImplType = ClassName.get(abstractSyntax.factoryImplementationPackageName(packageRoot),
			abstractSyntax.factoryImplementationClassName)
		val einstance = FieldSpec.builder(factoryInterfaceType, "eINSTANCE", PUBLIC, FINAL, STATIC).
			initializer('''$T.init()''', factoryImplType).build
		val factory = TypeSpec.interfaceBuilder(abstractSyntax.factoryInterfaceClassName).addSuperinterface(EFactory).
			addField(einstance).addMethods(abstractSyntax.EClassifiers.filter(EClass).filter [
				!abstract && !(it.instanceClass !== null && it.instanceClass == Map.Entry)
			].map [
				MethodSpec.methodBuilder('''create«it.name.toFirstUpper»''').returns(
					ClassName.get(it.classInterfacePackageName(packageRoot), it.classInterfaceClassName)).
					addModifiers(ABSTRACT, PUBLIC).build
			]).addMethod(
				MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Package''').returns(
					packageInterfaceType).addModifiers(ABSTRACT, PUBLIC).build
			).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.factoryInterfacePackageName(packageRoot), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)

	}
}
