package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassGetterCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassImplementationCompiler
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class VisitorEClassImplementationCompiler {
	extension VisitorNamingUtils namingUtils
	extension JavaPoetUtils jpu
	extension EClassImplementationCompiler ecic

	var Map<String, Pair<EPackage, GenModel>> syntaxes
	val Dsl dsl
	val String packageRoot

	new(String packageRoot, Dsl dsl, List<ResolvedClass> resolved, CommonCompilerUtils ccu) {
		this.packageRoot = packageRoot
		this.dsl = dsl
		this.namingUtils = new VisitorNamingUtils
		this.jpu = new JavaPoetUtils
		this.ecic = new EClassImplementationCompiler(ccu, namingUtils, new EClassGetterCompiler(namingUtils, ccu, resolved), jpu, resolved)
	}
	
	def TypeSpec.Builder addAcceptMethod(TypeSpec.Builder builder, EClass eClass) {
		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
		builder.applyIfTrue(!eClass.abstract && !isMapElement, [
			addMethod(
				MethodSpec.methodBuilder('accept').addAnnotation(Override).addParameter(
					ClassName.get(namingUtils.visitorInterfacePackageName(packageRoot),
						namingUtils.visitorInterfaceClassName), 'visitor').addModifiers(PUBLIC).returns(Object).
					addCode('''
						return visitor.visit«eClass.EPackage.name»__«eClass.name»(this);
					''').build
			)
		])
	}

	def dispatch compileEClassImplementation(EEnum eClass, File directory) {
		// TODO
	}

	def dispatch compileEClassImplementation(EClass eClass, File directory) {
		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName)
		.compileEcoreRelated(eClass, packageRoot, dsl)
		.addAcceptMethod(eClass)
		.addModifiers(PUBLIC).addMethod(MethodSpec.constructorBuilder.addCode('''
				super();
			''').addModifiers(PROTECTED).build).build

		val javaFile = JavaFile.builder(eClass.classImplementationPackageName(packageRoot), factory).indent('\t').build
		javaFile.writeTo(directory)
	}

	def getEcoreInterfacesPackage() {
		val gm = syntaxes.get(dsl.allSyntaxes.head).value
		gm.genPackages.head.qualifiedPackageName
	}

	def boolean isResolveProxies(EStructuralFeature eStructuralFeature) {
		if (eStructuralFeature instanceof EReference) {
			val isContainer = eStructuralFeature.isContainer
			val isContains = eStructuralFeature.isContainment
			!isContainer && !isContains && eStructuralFeature.isResolveProxies
		} else {
			false
		}
	}

	def boolean isListType(ETypedElement eTypedElement) {
		eTypedElement !== null &&
			(eTypedElement.isMany() ||
				((eTypedElement instanceof EClass) &&
					(eTypedElement as EClass).instanceClassName == "java.util.Map$Entry"))
	}
}
