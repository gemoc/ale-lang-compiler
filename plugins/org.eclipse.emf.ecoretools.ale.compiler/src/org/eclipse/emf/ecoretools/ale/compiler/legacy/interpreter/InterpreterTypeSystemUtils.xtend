package org.eclipse.emf.ecoretools.ale.compiler.legacy.interpreter

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.TypeName
import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonTypeSystemUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

@Deprecated
class InterpreterTypeSystemUtils extends CommonTypeSystemUtils {
	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension AbstractNamingUtils namingUtils
	val String packageRoot
	val Dsl dsl
	

	new(Map<String, Pair<EPackage, GenModel>> syntaxes, String packageRoot, List<ResolvedClass> resolved,
		AbstractNamingUtils nu, Dsl dsl) {
		super(syntaxes, resolved)
		this.packageRoot = packageRoot
		this.namingUtils = nu
		this.dsl = dsl
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
//				if(dsl.truffle)
//				ClassName.get(e.classImplementationPackageName(packageRoot), e.name+'Impl')
//				else
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
			} else if (e instanceof EEnum) {
				ClassName.get(e.classInterfacePackageName(packageRoot), e.name)
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

	

	def dispatch TypeName resolveType2(Object type) {
		return null
	}

	def dispatch TypeName resolveType2(Class<?> clazz) {
		return TypeName.get(clazz)
	}

	def dispatch TypeName resolveType2(EClassifier type) {
		val rt = if (type instanceof EEnum) {
				type.resolveType
			} else if (type instanceof EClass) {
				type.resolveType
			} else if (type.instanceClass !== null) {
				TypeName.get(type.instanceClass)
			} else {
				type.resolveType
			}
		if (rt.toString == "org.eclipse.acceleo.query.runtime.impl.Nothing") {
			println('NOTHING')
		}
		rt
	}
}
