package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassInterfaceCompiler

import static javax.lang.model.element.Modifier.*

class VisitorEClassInterfaceCompiler {

	extension VisitorNamingUtils namingUtils
	EClassInterfaceCompiler ecic
	
	
	new(VisitorNamingUtils namingUtils, CommonCompilerUtils ccu) {
		this.namingUtils = namingUtils
		this.ecic = new EClassInterfaceCompiler(namingUtils, ccu)
	}
	
	def dispatch compileEClassInterface(EEnum eEnum, File directory, String packageRoot) {
		ecic.compileEClassInterface(eEnum, directory,  packageRoot)
	}

	def dispatch compileEClassInterface(EClass eClass, File directory, String packageRoot) {

		// TODO: in case of truffle option: add parent interface com.oracle.truffle.api.nodes.NodeInterface
		// TODO: weave the dynamically declared fields on the class
		val attributesMethods = ecic.getAttributeMethods(eClass, packageRoot)

		val referencesMethods = ecic.getReferenceMethods(eClass, packageRoot)

		// VISITOR SPECIFIC
		val factory = TypeSpec.interfaceBuilder(eClass.classInterfaceClassName).addSuperinterface(EObject).
			addSuperinterface(
				ClassName.get(namingUtils.acceptInterfacePackageName(packageRoot),
					namingUtils.acceptInterfaceClassName)).addSuperinterfaces(eClass.ESuperTypes.map [
				ClassName.get(it.classInterfacePackageName(packageRoot), it.classInterfaceClassName)
			]).addMethods(attributesMethods + referencesMethods).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classInterfacePackageName(packageRoot), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)

	}
}
