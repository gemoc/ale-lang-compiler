package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

import static javax.lang.model.element.Modifier.*
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils

class OperationInterfaceCompiler {

	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension VisitorNamingUtils namingUtils = new VisitorNamingUtils
	extension JavaPoetUtils = new JavaPoetUtils
	extension VisitorTypeSystemUtil tsu
	val File directory
	val String packageRoot
	val Map<String, Pair<EPackage, GenModel>> syntaxes
	

	new(File directory, String packageRoot, Map<String, Pair<EPackage, GenModel>> syntaxes) {
		this.directory = directory
		this.packageRoot = packageRoot
		this.syntaxes = syntaxes
		this.tsu = new VisitorTypeSystemUtil(syntaxes, namingUtils, packageRoot)
	}

	def compile(EClass eClass, ExtendedClass aleClass) {
		val factory = TypeSpec.interfaceBuilder(namingUtils.operationInterfaceClassName(eClass)).
			addSuperinterfaces(eClass.ESuperTypes.map [
				ClassName.get(namingUtils.operationInterfacePackageName(packageRoot, it),
					namingUtils.operationInterfaceClassName(it))
			]).applyIfTrue(aleClass !== null, [
				addMethods(aleClass.methods.map [ method |

					val retType = method.operationRef.EType?.resolveType2

					MethodSpec.methodBuilder(method.operationRef.name).applyIfTrue(retType !==
						null, [returns(retType)]).addParameters(method.operationRef.EParameters.map [ param |
						if (param.EType.instanceClass !== null) {
							if (param.EType instanceof EClass && !(param.EType.EPackage == EcorePackage.eINSTANCE)) {
								ParameterSpec.builder(
									ClassName.get((param.EType as EClass).classInterfacePackageName(packageRoot),
										(param.EType as EClass).name), param.name).build
							} else {
								ParameterSpec.builder(param.EType.instanceClass, param.name).build

							}
						} else {
							ParameterSpec.builder(param.EType.resolveType, param.name).build
						}
					]).addModifiers(ABSTRACT, PUBLIC).build
				])

			]).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(namingUtils.operationInterfacePackageName(packageRoot, eClass), factory)
			.indent('\t')
			.build

		javaFile.writeTo(directory)
	}
	
	def resolveType(EClassifier e) {
		val stxs = syntaxes.values + #[(EcorePackage.eINSTANCE -> null)]
		val stx = stxs.filter [
			it.key.allClasses.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			if (e instanceof EClass) {
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
			} else {
				val GenClass gclass = gm.allGenPkgs.map [
					it.genClasses.filter [
						it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
					]
				].flatten.head
				val split = gclass.qualifiedInterfaceName.split("\\.")
				val pkg = newArrayList(split).reverse.tail.toList.reverse.join(".")
				val cn = split.last
				ClassName.get(pkg, cn)

			}
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}

	}
}
