package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

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
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler.ResolvedClass
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass

class TypeSystemUtils {

	val Map<String, Pair<EPackage, GenModel>> syntaxes
	extension EcoreUtils ecoreUtils = new EcoreUtils
	extension SwitchNamingUtils namingUtils = new SwitchNamingUtils
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
		edt.instanceClass
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
				ClassName.get(operationPackageName(packageRoot), e.name)
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
	
	def infereType(Expression exp) {
		base.getPossibleTypes(exp)
	}
	
	def allMethods(ExtendedClass aleClass) {
		aleClass.allParents.map [
			it.methods
		].flatten
	}
	
	def allParents(ExtendedClass aleClass) {
		val ecls = resolved.filter[it.getAleCls == aleClass].head.eCls

		resolved.filter[it.eCls == ecls || it.eCls.isSuperTypeOf(ecls)].map [
			it.getAleCls
		].filter[it !== null]
	}
}
