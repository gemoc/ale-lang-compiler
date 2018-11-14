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

class VisitorInterfaceCompiler {
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
		val factory = TypeSpec.interfaceBuilder(namingUtils.visitorInterfaceClassName).addMethods(syntaxes.values.map [
			key
		].map[allClasses].flatten.filter[!it.abstract].map [ eClass |
			MethodSpec.methodBuilder('''visit«eClass.EPackage.name»__«eClass.name»''').addParameter(
				ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName), 'it').
				addModifiers(ABSTRACT, PUBLIC).returns(Object).build
		]).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(namingUtils.visitorInterfacePackageName(packageRoot), factory).build

		javaFile.writeTo(directory)
	}
}
