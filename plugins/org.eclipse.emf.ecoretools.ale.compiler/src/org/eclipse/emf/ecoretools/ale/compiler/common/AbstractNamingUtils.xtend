package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.ClassName
import javax.lang.model.SourceVersion
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

abstract class AbstractNamingUtils {
	
//	GenPackage genPackage
//	
//	new(GenPackage genPackage) {
//		this.genPackage = genPackage
//	}
	
	def String factoryInterfaceClassName(EPackage ePackage) {
		'''«ePackage.name.toFirstUpper»Factory'''
	}
	
	def packageFactoryClassName(EPackage ePackage, String packageRoot) {
		ClassName.get(ePackage.packageInterfacePackageName(packageRoot), ePackage.factoryInterfaceClassName)
	}
	
	def String packageInterfacePackageName(EPackage epkg, String packageRoot)
	

	def String classInterfacePackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryInterfacePackageName(packageRoot)
	}
	
	def String classImplementationPackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryImplementationPackageName(packageRoot)
	}

	def String classInterfacePackageName(EEnum eEnum, String packageRoot) {
		eEnum.EPackage.factoryInterfacePackageName(packageRoot)
	}

	def String getIdentifier()
	
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null && packageRoot != ''»«packageRoot».«ENDIF»«ePackage.name».«identifier».«ePackage.name»'''
	}
	
	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot) {
		'''«factoryInterfacePackageName(ePackage, packageRoot)».impl'''
	}

	def String normalizeVarName(String name) {
		val _name = name.toFirstLower
		if(SourceVersion.isKeyword(_name)) {
			'''«_name»_'''
		} else {
			_name
		}
	}

	def String normalizeVarNewName(String name) '''new«name.toFirstUpper»'''

	def String normalizeVarOldName(String name) '''old«name.toFirstUpper»'''
}
