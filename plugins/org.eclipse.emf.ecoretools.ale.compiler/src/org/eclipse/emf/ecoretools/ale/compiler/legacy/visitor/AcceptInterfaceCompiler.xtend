package org.eclipse.emf.ecoretools.ale.compiler.legacy.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File

import static javax.lang.model.element.Modifier.*

@Deprecated
class AcceptInterfaceCompiler {
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	val File directory
	val String packageRoot

	new(File rootDirectory, String packageRoot) {
		this.directory = rootDirectory
		this.packageRoot = packageRoot
	}

	def compile() {
		val factory = TypeSpec.interfaceBuilder(namingUtils.acceptInterfaceClassName).addMethod(
			MethodSpec.methodBuilder('accept')
				.addParameter(ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot), namingUtils.visitorInterfaceClassName), 'accept')
				.addModifiers(ABSTRACT, PUBLIC)
				.returns(Object).build)
				.addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(namingUtils.acceptInterfacePackageName(packageRoot), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
}
