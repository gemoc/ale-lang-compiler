package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EFactory
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class FactoryInterfaceCompiler {
	extension EcoreGenNamingUtils namingUtils
	extension CompilerDsl compilerDsl = new CompilerDsl

	new(EcoreGenNamingUtils namingUtils) {
		this.namingUtils = namingUtils
	}

	def compileFactoryInterface(EPackage abstractSyntax, File directory, String packageRoot, Dsl dsl) {
		val factoryInterfaceType = abstractSyntax.factoryIntClassName(packageRoot) 
		val packageInterfaceType = abstractSyntax.packageIntClassName(packageRoot) 
		
		val factoryImplType = ClassName.get(abstractSyntax.factoryImplementationPackageName(packageRoot),
			abstractSyntax.factoryImplementationClassName)
		val einstance = FieldSpec.builder(factoryInterfaceType, "eINSTANCE", PUBLIC, FINAL, STATIC).
			initializer('''$T.init()''', factoryImplType).build
		val factory = TypeSpec.interfaceBuilder(abstractSyntax.factoryInterfaceClassName).addSuperinterface(EFactory).
			addField(einstance).addMethods(abstractSyntax.EClassifiers.filter(EClass).filter [
				!abstract && !(it.instanceClass !== null && it.instanceClass == Map.Entry)
			].map [
				MethodSpec.methodBuilder('''create«it.name.toFirstUpper»''').returns(
					if(dsl.truffle)
					ClassName.get(it.classImplementationPackageName(packageRoot), it.classImplementationClassName)
					else
					ClassName.get(it.classInterfacePackageName(packageRoot), it.classInterfaceClassName)).
					addModifiers(ABSTRACT, PUBLIC).build
			]).addMethod(
				MethodSpec.methodBuilder('''get«abstractSyntax.name.toFirstUpper»Package''').returns(
					packageInterfaceType).addModifiers(ABSTRACT, PUBLIC).build
			).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(abstractSyntax.factoryInterfacePackageName(packageRoot), factory).indent('\t').
			build

		javaFile.writeTo(directory)

	}
}
