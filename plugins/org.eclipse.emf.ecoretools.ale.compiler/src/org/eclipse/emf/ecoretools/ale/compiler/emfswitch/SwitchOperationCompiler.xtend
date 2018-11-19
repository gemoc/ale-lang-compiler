package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler.ResolvedClass

import static javax.lang.model.element.Modifier.*

class SwitchOperationCompiler {

	extension SwitchNamingUtils namingUtils = new SwitchNamingUtils

	val String packageRoot
	val File directory

	new(String packageRoot, File directory) {
		this.packageRoot = packageRoot
		this.directory = directory
	}

	def compile(ResolvedClass resolved) {
		
		val eClassType = ClassName.get(resolved.genCls.genPackage.interfacePackageName, resolved.genCls.interfaceName)
		val switchType = ClassName.get(namingUtils.switchImplementationPackageName(packageRoot), namingUtils.switchImplementationClassName(packageRoot))
		
		val factory = TypeSpec.classBuilder(namingUtils.operationClassName(resolved.eCls))
			.addField(eClassType, 'it', PRIVATE, FINAL)
			.addField(switchType, 'emfswitch', PRIVATE, FINAL)
			.addMethod(MethodSpec.constructorBuilder
				.addParameter(eClassType, 'it')
				.addParameter(switchType, 'emfswitch')
				.addCode('''
				this.it = it;
				this.emfswitch = emfswitch;
				''')
				.addModifiers(PUBLIC)
				.build
			)
			.addModifiers(PUBLIC)
			.build

		val javaFile = JavaFile.builder(namingUtils.operationPackageName(packageRoot), factory).build

		javaFile.writeTo(directory)
	}
}
