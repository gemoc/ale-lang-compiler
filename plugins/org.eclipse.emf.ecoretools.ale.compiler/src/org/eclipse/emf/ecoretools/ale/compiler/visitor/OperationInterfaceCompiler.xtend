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

class OperationInterfaceCompiler {

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
		val factory = TypeSpec.interfaceBuilder(namingUtils.operationInterfaceClassName(eClass)).
			addSuperinterfaces(eClass.ESuperTypes.map [
				ClassName.get(namingUtils.operationInterfacePackageName(packageRoot, it),
					namingUtils.operationInterfaceClassName(it))
			]).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(namingUtils.operationInterfacePackageName(packageRoot, eClass), factory).build

		javaFile.writeTo(directory)
	}
}
