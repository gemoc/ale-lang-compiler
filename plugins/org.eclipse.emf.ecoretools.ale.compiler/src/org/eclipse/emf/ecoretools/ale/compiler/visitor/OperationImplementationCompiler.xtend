package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

import static javax.lang.model.element.Modifier.*

class OperationImplementationCompiler {

	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension VisitorCompilerUtils = new VisitorCompilerUtils
	extension JavaPoetUtils = new JavaPoetUtils
	val File directory
	val String packageRoot

	new(File directory, String packageRoot) {
		this.directory = directory
		this.packageRoot = packageRoot
	}

	def compile(EClass eClass, ExtendedClass aleClass) {
		val classInterfaceType = ClassName.get(namingUtils.classInterfacePackageName(eClass, packageRoot),
			namingUtils.classInterfaceClassName(eClass))

		val operationInterfaceType = ClassName.get(namingUtils.operationInterfacePackageName(packageRoot, eClass),
			namingUtils.operationInterfaceClassName(eClass))

		val visitorInterfaceType = ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot),
			namingUtils.visitorInterfaceClassName)

		val factory = TypeSpec.classBuilder(namingUtils.operationImplementationClassName(eClass)).addSuperinterface(
			operationInterfaceType).addModifiers(PUBLIC).addField(classInterfaceType, 'it', PRIVATE, FINAL).addField(
			visitorInterfaceType, 'vis', PRIVATE, FINAL).addMethod(
			MethodSpec.constructorBuilder.addParameter(classInterfaceType, 'it').addParameter(visitorInterfaceType,
				'vis').addCode('''
				this.it = it;
				this.vis = vis;
			''').addModifiers(PUBLIC).build).build

		val javaFile = JavaFile.builder(namingUtils.operationImplementationPackageName(packageRoot, eClass), factory).
			build

		javaFile.writeTo(directory)
	}
}
