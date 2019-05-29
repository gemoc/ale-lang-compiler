package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeSystemUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass

class RevisitorTypeSystemUtils extends CommonTypeSystemUtils {
	extension EcoreUtils eu

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, EcoreUtils eu, List<ResolvedClass> resolved) {
		super(syntaxes, resolved)
		this.eu = eu
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

	override resolveType(EClassifier e) {
		val stxs = syntaxes.values + #[(EcorePackage.eINSTANCE -> null)]
		val stx = stxs.filter [
			it.key.allClassifiers.exists [
				it.name == e.name && it.EPackage.name == (e.eContainer as EPackage).name
			]
		].head

		val gm = stx.value

		if (gm !== null) {
			if (e instanceof EClass) {
				if (e.instanceClassName == "java.util.Map$Entry") {
					val keyType = e.EStructuralFeatures.filter[it.name == 'key'].head.EType.solveType
					val valueType = e.EStructuralFeatures.filter[it.name == 'value'].head.EType.solveType
					ParameterizedTypeName.get(ClassName.get(Map.Entry), keyType, valueType)
				} else {
					val GenClass gl = syntaxes.filter [ k, v |
						v.key.allClasses.exists[it.name == e.name && it.EPackage.name == e.EPackage.name]
					].values.map[value].map [
						it.genPackages.map[it.genClasses].flatten
					].flatten.filter [
						it.ecoreClass.name == e.name && it.ecoreClass.EPackage.name == e.EPackage.name
					].head
					ClassName.get(gl.genPackage.interfacePackageName, e.name)

				}
			} else {
				val GenClassifier gclass = gm.allGenPkgs.map [
					it.genClassifiers.filter [
						it.name == e.name && it.genPackage.getEcorePackage.name == (e.eContainer as EPackage).name
					]
				].flatten.head

				if (gclass instanceof GenClass) {
					ClassName.get(gclass.qualifiedInterfaceName, gclass.name)
				} else if (gclass instanceof GenEnum) {
					ClassName.get(gclass.genPackage.interfacePackageName, gclass.name)
				}

			}
		} else {
			ClassName.get("org.eclipse.emf.ecore", e.name)
		}
	}

}
