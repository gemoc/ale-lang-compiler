package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils

abstract class GenmodelNamingUtils  extends AbstractNamingUtils{
	def String normalizeUpperField(String input)
	def String normalizeUpperField(String input, String className)
	def String packageInterfaceClassName(EPackage ePackage)
	def String packageInterfacePackageName(EPackage ePackage, String packageRoot)
	def String packageImplementationClassName(EPackage ePackage)
	def String factoryInterfaceClassName(EPackage ePackage)
	def String normalizeUpperMethod(String input, String className)
	def String packageImplementationPackageName(EPackage ePackage, String packageRoot)
	def String factoryImplementationClassName(EPackage ePackage)
	def String factoryImplementationPackageName(EPackage ePackage, String packageRoot)
}