package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import com.squareup.javapoet.ClassName
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import com.squareup.javapoet.TypeName
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass

class TypeSystemUtils {

	val Map<String, Pair<EPackage, GenModel>> syntaxes
	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension InterpreterNamingUtils namingUtils = new InterpreterNamingUtils
	val String packageRoot
	val BaseValidator base
	var List<ResolvedClass> resolved

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, BaseValidator base, List<ResolvedClass> resolved) {
		this.syntaxes = syntaxes
		this.packageRoot = packageRoot
		this.base = base
		this.resolved = resolved
	}

	def dispatch solveType(EClass type) {
		resolveType(type)
	}

	def dispatch solveType(EDataType edt) {
		if(edt.instanceClass.primitive) {
			edt.instanceClass
		} else {
			ClassName.get(edt.instanceClass)
		}
	}

	def resolveType(EClassifier e) {
		val stxs = syntaxes.values + #[(EcorePackage.eINSTANCE -> null)]
		val stx = stxs.filter [
			it.key.allClassifiers.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			if (e instanceof EClass) {
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
			} else if(e instanceof EEnum) {
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
			}else {
				val GenClassifier gclass = gm.allGenPkgs.map [
					it.genClassifiers.filter [
						it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
					]
				].flatten.head
				if(gclass instanceof GenClass) {
					ClassName.get(gclass.qualifiedInterfaceName, gclass.name)
				} else if (gclass instanceof GenEnum) {
					ClassName.get(gclass.genPackage.interfacePackageName, gclass.name)
				}

			}
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}

	}
	
	def infereType(Expression exp) {
		base.getPossibleTypes(exp)
	}
	
	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}
	
	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.aleCls == aleClass].head.eCls

		resolved.filter[it.eCls == ecls || it.eCls instanceof EClass && ecls instanceof EClass && (it.eCls as EClass).isSuperTypeOf(ecls as EClass)].map [
			it.aleCls
		].filter[it !== null]
	}
	
	def dispatch TypeName resolveType2(Object type) {
		return null
	}
	
	def dispatch TypeName resolveType2(Class<?> clazz) {
		return TypeName.get(clazz)
	}
	
	def dispatch TypeName resolveType2(EClassifier type) {
		if (type.instanceClass !== null) {
			TypeName.get(type.instanceClass)
		} else {
			type.resolveType
		}	
	}
}
