package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

abstract class EcoreNotGenNamingUtils extends AbstractNamingUtils {
	
	GenPackage genPackage
	
	new(GenPackage genPackage) {
		this.genPackage = genPackage
	}
	
	override packageInterfacePackageName(EPackage epkg, String packageRoot) {
		genPackage.packageName
	}
}