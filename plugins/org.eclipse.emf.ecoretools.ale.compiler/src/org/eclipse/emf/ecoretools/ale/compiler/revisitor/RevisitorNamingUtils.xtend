package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import com.squareup.javapoet.ClassName
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreNotGenNamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment

class RevisitorNamingUtils extends EcoreNotGenNamingUtils {
	
	extension CompilerDsl compilerDsl = new CompilerDsl
	
	new(GenPackage genPackage) {
		super(genPackage)
	}

	override getIdentifier() { "revisitor" }

	def String getRevisitorPackageFqn(GenPackage pkg) {

		val pkgName = if (pkg.basePackage === null || pkg.basePackage == '') {
				pkg.getEcorePackage.name
			} else {
				pkg.basePackage
			}

		'''«pkgName».«identifier»'''
	}
	
	def String getRevisitorInterfacePath(GenPackage pkg) {
		val pn = if(pkg.basePackage !== null && pkg.basePackage != '') {
			pkg.basePackage
		} else {
			pkg.getEcorePackage.name
		}
		val modelDir = pkg.genModel.modelDirectory
		val i = modelDir.indexOf("/",1)
		
		'''«modelDir.substring(i+1)»/«FOR fragment: pn.split("\\.") SEPARATOR '/'»«fragment»«ENDFOR»/revisitor'''
	
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

	def String getRevisitorImplementationPackage(IAleEnvironment dsl) {
		'''«dsl.sourceFileName».impl'''
	}

	def String getRevisitorOperationInterfacePackage(IAleEnvironment dsl) {
		'''«dsl.revisitorImplementationPackage».operation'''
	}

	def String getRevisitorOperationImplementationPackage(IAleEnvironment dsl) {
		'''«dsl.revisitorOperationInterfacePackage».impl'''
	}

	def String getRevisitorOperationInterfaceClassName(EClass ecls) {
		'''«ecls.name»Op'''
	}

	def String getRevisitorOperationImplementationClassName(EClass ecls) {
		'''«ecls.name»OpImpl'''
	}

	def ClassName getRevisitorOperationInterfaceClassName(IAleEnvironment dsl, EClass ecls) {
		ClassName.get(dsl.revisitorOperationInterfacePackage, ecls.revisitorOperationInterfaceClassName)
	}

	def ClassName getRevisitorOperationImplementationClassName(IAleEnvironment dsl, EClass ecls) {
		ClassName.get(dsl.revisitorOperationImplementationPackage, ecls.revisitorOperationImplementationClassName)
	}

	def String getRevisitorImplementationClass(IAleEnvironment dsl) {
		val name = dsl.sourceFileName
		val camelCased = name.split("\\.").map[toFirstUpper].join
		'''«camelCased»Implementation'''
	}
	
//	override packageInterfacePackageName(EPackage epkg, String packageRoot) {
//		epkg.name
//	}
	
}
