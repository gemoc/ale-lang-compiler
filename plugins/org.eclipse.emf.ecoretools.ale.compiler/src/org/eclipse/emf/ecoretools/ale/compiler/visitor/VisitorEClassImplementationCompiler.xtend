package org.eclipse.emf.ecoretools.ale.compiler.visitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.util.BasicEMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassGetterCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EClassImplementationCompiler
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

import static javax.lang.model.element.Modifier.*

class VisitorEClassImplementationCompiler {
	extension VisitorNamingUtils namingUtils
	extension CommonCompilerUtils ccu
	extension JavaPoetUtils jpu
	EClassImplementationCompiler ecic

	var Map<String, Pair<EPackage, GenModel>> syntaxes
	val Dsl dsl
	val String packageRoot

	new(String packageRoot, Dsl dsl) {
		this.packageRoot = packageRoot
		this.dsl = dsl
		this.namingUtils = new VisitorNamingUtils
		this.ccu = new CommonCompilerUtils(namingUtils)
		this.jpu = new JavaPoetUtils
		this.ecic = new EClassImplementationCompiler(ccu, namingUtils, new EClassGetterCompiler(namingUtils), jpu)
	}

	private def TypeSpec.Builder compileEcoreRelated(TypeSpec.Builder builder, EClass eClass) {
		val isMapElement = eClass.instanceClass !== null && eClass.instanceClass == Map.Entry
		val ePackageInterfaceType = eClass.packageIntClassName(packageRoot) 
		
		val hasSuperType = !eClass.ESuperTypes.empty
		val superType = eClass.ESuperTypes.head

		val fieldsEAttributes = ecic.getFieldsEAttributes(eClass, packageRoot)
		val fieldsEReferences = ecic.getFieldsEReferences(eClass, packageRoot)
		val methodsEReferences = ecic.getMethodsEReferences(eClass, packageRoot, dsl, ePackageInterfaceType,
			isMapElement)

		val eStaticClassMethod = ecic.getEStaticClass(eClass, dsl, packageRoot)

		val eSetMethod = ecic.getESet(eClass, dsl, packageRoot)
		val eUnsetMethod = ecic.getEUnset(eClass, dsl, packageRoot)
		val eGetMethod = ecic.getEGet(eClass, dsl, packageRoot)
		val eIsSetMethod = ecic.getEIsSet(eClass, dsl, packageRoot)
		val eInverseRemove = ecic.getEInverseRemove(eClass, dsl, packageRoot)
		val eBasicRemoveFromContainerFeature = ecic.getEBasicRemoveFromContainerFeature(eClass, dsl, packageRoot)

		val eInverseAdd = ecic.getEInverseAdd(eClass, dsl, packageRoot)
		
		val eMethods = #[eInverseAdd, eInverseRemove, eBasicRemoveFromContainerFeature, eGetMethod, eSetMethod, eUnsetMethod, eIsSetMethod].map[it.map[#[it]].orElse(#[])].flatten

		val key = eClass.eContents.filter(EStructuralFeature).filter[it.name == "key"].head
		val value = eClass.eContents.filter(EStructuralFeature).filter[it.name == "value"].head

		builder.applyIfTrue(eClass.isAbstract, [addModifiers(ABSTRACT)]).applyIfTrue(hasSuperType, [
			superclass(
				ClassName.get(superType.classImplementationPackageName(packageRoot),
					superType.classImplementationClassName))
		]).applyIfTrue(isMapElement, [
			it.addSuperinterface(
				ParameterizedTypeName.get(ClassName.get(BasicEMap.Entry),
					key.EType.scopedInterfaceTypeRef(packageRoot).box,
					value.EType.scopedInterfaceTypeRef(packageRoot).box))
		]).applyIfTrue(!hasSuperType, [superclass(ClassName.get(MinimalEObjectImpl.Container))]).applyIfTrue(
			!isMapElement, [
				addSuperinterface(
					ClassName.get(eClass.classInterfacePackageName(packageRoot), eClass.classInterfaceClassName))
			])
			.addFields(fieldsEAttributes)
			.addFields(fieldsEReferences)
			.addMethod(eStaticClassMethod)
			.addMethods(methodsEReferences)
		 	.addMethods(eMethods)
		.applyIfTrue(isMapElement, [
			it.addField(FieldSpec.builder(int, 'hash', PROTECTED).initializer('-1').build).addMethod(
				MethodSpec.methodBuilder('setHash').addParameter(int, 'hash').addCode('''
					this.hash = hash;
				''').addModifiers(PUBLIC).build).addMethod(MethodSpec.methodBuilder('getHash').returns(int).addCode('''
				if (hash == -1) {
					Object theKey = getKey();
					hash = (theKey == null ? 0 : theKey.hashCode());
				}
				return hash;
			''').addModifiers(PUBLIC).build)
		]).applyIfTrue(!eClass.abstract && !isMapElement, [
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

	def compileEClassImplementation(EClass eClass, File directory) {
		val factory = TypeSpec.classBuilder(eClass.classImplementationClassName).compileEcoreRelated(eClass).
			addModifiers(PUBLIC).addMethod(MethodSpec.constructorBuilder.addCode('''
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
