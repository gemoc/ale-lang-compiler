package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractNamingUtils
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

class RevisitorNamingUtils extends AbstractNamingUtils {

	override getIdentifier() { "revisitor" }

	def String getRevisitorPackageFqn(GenPackage pkg) {

		val pkgName = if (pkg.basePackage === null || pkg.basePackage == '') {
				pkg.getEcorePackage.name
			} else {
				pkg.basePackage
			}

		'''«pkgName».«identifier»'''
	}

	def String getRevisitorInterfaceName(GenPackage pkg) {
		'''«pkg.getEcorePackage.name.toFirstUpper»Revisitor'''
	}

	def String getRevisitorInterfaceFqn(GenPackage pkg) '''«pkg.revisitorPackageFqn».«pkg.revisitorInterfaceName»'''

	def String getDenotationName(EClass cls) '''«cls.EPackage.name.toFirstLower»__«cls.name»'''

	def String getDenotationName(Pair<EClass, EClass> cls) {
		'''«cls.key.denotationName»«IF cls.value !== null»__AS__«cls.value.denotationName»«ENDIF»'''
	}

	def String getVarName(EClass cls) '''it'''

	def String getRevisitorImplementationPackage(Dsl dsl) {
		'''«dsl.sourceFileName».impl'''
	}

	def String getRevisitorOperationInterfacePackage(Dsl dsl) {
		'''«dsl.revisitorImplementationPackage».operation'''
	}

	def String getRevisitorOperationImplementationPackage(Dsl dsl) {
		'''«dsl.revisitorOperationInterfacePackage».impl'''
	}

	def String getRevisitorOperationInterfaceClassName(EClass ecls) {
		'''«ecls.name»Op'''
	}

	def String getRevisitorOperationImplementationClassName(EClass ecls) {
		'''«ecls.name»OpImpl'''
	}

	def ClassName getRevisitorOperationInterfaceClassName(Dsl dsl, EClass ecls) {
		ClassName.get(dsl.revisitorOperationInterfacePackage, ecls.revisitorOperationInterfaceClassName)
	}

	def ClassName getRevisitorOperationImplementationClassName(Dsl dsl, EClass ecls) {
		ClassName.get(dsl.revisitorOperationImplementationPackage, ecls.revisitorOperationImplementationClassName)
	}

	def String getRevisitorImplementationClass(Dsl dsl) {
		val name = dsl.sourceFileName
		val camelCased = name.split("\\.").map[toFirstUpper].join
		'''«camelCased»Implementation'''
	}
}
