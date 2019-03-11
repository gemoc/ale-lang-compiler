package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils

import static javax.lang.model.element.Modifier.*

class AcceptInterfaceCompiler {
	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension VisitorCompilerUtils = new VisitorCompilerUtils
	extension JavaPoetUtils = new JavaPoetUtils
	val File directory
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val String packageRoot

	new(File rootDirectory, Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot) {
		this.directory = rootDirectory
		this.syntaxes = syntaxes
		this.packageRoot = packageRoot
	}

	def compile() {
		val factory = TypeSpec.interfaceBuilder(namingUtils.acceptInterfaceClassName).addMethod(
			MethodSpec.methodBuilder('accept').addParameter(
				ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot),
					namingUtils.visitorInterfaceClassName), 'accept').addModifiers(ABSTRACT, PUBLIC).returns(Object).
				build).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(namingUtils.acceptInterfacePackageName(packageRoot), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
}
