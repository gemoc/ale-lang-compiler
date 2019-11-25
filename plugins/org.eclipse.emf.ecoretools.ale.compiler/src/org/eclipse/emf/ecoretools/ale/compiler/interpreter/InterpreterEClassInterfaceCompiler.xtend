package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreGenNamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.Method

import static javax.lang.model.element.Modifier.*

class InterpreterEClassInterfaceCompiler {

	extension EcoreGenNamingUtils namingUtils
	extension CommonCompilerUtils ccu
	extension JavaPoetUtils jpu
	EClassInterfaceCompiler ecic
	extension CompilerDsl compilerDsl = new CompilerDsl

	new(EcoreGenNamingUtils namingUtils, CommonCompilerUtils ccu) {
		this.namingUtils = namingUtils
		this.ccu = ccu
		this.jpu = new JavaPoetUtils
		this.ecic = new EClassInterfaceCompiler(namingUtils, ccu)
	}

	def dispatch compileEClassInterface(EEnum eEnum, ExtendedClass aleClass, File directory, Dsl dsl,
		String packageRoot) {
		ecic.compileEClassInterface(eEnum, directory, packageRoot)
	}

	def dispatch compileEClassInterface(EClass eClass, ExtendedClass aleClass, File directory, Dsl dsl,
		String packageRoot) {

		// TODO: in case of truffle option: add parent interface com.oracle.truffle.api.nodes.NodeInterface
		// TODO: weave the dynamically declared fields on the class
		val attributesMethods = ecic.getAttributeMethods(eClass, packageRoot)
		val referencesMethods = ecic.getReferenceMethods(eClass, packageRoot)

		// INTERPRETER SPECIFIC
		val operations = getOperations(aleClass, packageRoot)

		val cached = getCached(aleClass, dsl, packageRoot)

		val factory = TypeSpec.interfaceBuilder(eClass.classInterfaceClassName).addSuperinterface(EObject).applyIfTrue(
			dsl.isTruffle && !eClass.EAnnotations.exists [
				it.source == 'RuntimeData'
			], [
				addSuperinterface(ClassName.get("com.oracle.truffle.api.nodes", "NodeInterface"))
			]).addSuperinterfaces(eClass.ESuperTypes.map [
			ClassName.get(it.classInterfacePackageName(packageRoot), it.classInterfaceClassName)
		]).addMethods(attributesMethods + referencesMethods + operations + cached).addModifiers(PUBLIC).build

		val javaFile = JavaFile.builder(eClass.classInterfacePackageName(packageRoot), factory).indent('\t').build

		javaFile.writeTo(directory)

	}

	def getCached(ExtendedClass aleClass, Dsl dsl, String packageRoot) {
		if (aleClass !== null) {
			aleClass.methods.filter [
				it.dispatch && dsl.isTruffle
			].map [
				MethodSpec.methodBuilder('''getCached«it.operationRef.name.toFirstUpper»''').returns(
					ClassName.get(eClass.classImplementationPackageName(
						packageRoot), '''«eClass.name»DispatchWrapper«it.operationRef.name.toFirstUpper»''')).
					addModifiers(PUBLIC, ABSTRACT).build
			]
		} else {
			#[]
		}
	}

	def getOperations(ExtendedClass aleClass, String packageRoot) {
		if (aleClass !== null) {
			// methods signature are only generated when truffle and the dispatch option are not activated, or if activated, only when the dispatch option is not activated on the method
			aleClass.methods.map [ method |
				val params = method.operationRef.EParameters.map [ param |
					ParameterSpec.builder(param.EType.scopedInterfaceTypeRef(packageRoot), param.name).build
				]

				MethodSpec.methodBuilder(method.operationRef.name).returnsIfNotNull(
					method.operationRef.EType?.scopedInterfaceTypeRef(packageRoot)).addParameters(params).
					addModifiers(ABSTRACT, PUBLIC).build
			]
		} else
			#[]
	}

	def MethodSpec.Builder returnsIfNotNull(MethodSpec.Builder builder, TypeName typeName) {
		if (typeName !== null)
			builder.returns(typeName)
		else
			builder
	}
	
	def boolean isDispatch(Method method) {
		// TODO réinitégrer au mm
		false
	}
}
