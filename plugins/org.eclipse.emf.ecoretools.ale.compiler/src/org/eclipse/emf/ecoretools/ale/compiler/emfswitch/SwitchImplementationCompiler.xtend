package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler.ResolvedClass

import static javax.lang.model.element.Modifier.*
import com.squareup.javapoet.MethodSpec

class SwitchImplementationCompiler {

	extension SwitchNamingUtils namingUtils = new SwitchNamingUtils
	val File directory
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	val String packageRoot
	
	val List<ResolvedClass> resolved

	new(File rootDirectory, Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, List<ResolvedClass> resolved) {
		this.directory = rootDirectory
		this.syntaxes = syntaxes
		this.packageRoot = packageRoot
		this.resolved = resolved
	}

	def compile() {
		val firstPackage = syntaxes.entrySet.head.value
		val gp = firstPackage.value.genPackages.head

		val abstractSwitchType = ParameterizedTypeName.get(ClassName.get(gp.utilitiesPackageName, gp.switchClassName),
			ClassName.get(Object))

		val factory = TypeSpec.classBuilder(namingUtils.switchImplementationClassName(packageRoot))
			.superclass(abstractSwitchType)
			.addMethods(resolved.map[resolved | 
				MethodSpec
					.methodBuilder('''case«resolved.eCls.name.toFirstUpper»''')
					.addParameter(ClassName.get(resolved.genCls.genPackage.interfacePackageName, resolved.genCls.interfaceName), 'it')
					.addCode('''
					return new $T(it, this);
					''', ClassName.get(namingUtils.operationPackageName(packageRoot), namingUtils.operationClassName(resolved.eCls)))
					.returns(Object)
					.addModifiers(PUBLIC)
					.addAnnotation(Override)
					.build
			])
			.addModifiers(PUBLIC)
			.build

		val javaFile = JavaFile.builder(namingUtils.switchImplementationPackageName(packageRoot), factory).build

		javaFile.writeTo(directory)
	}
}
