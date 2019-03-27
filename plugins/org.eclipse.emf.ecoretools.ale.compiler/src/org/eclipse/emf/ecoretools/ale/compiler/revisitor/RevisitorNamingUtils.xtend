package org.eclipse.emf.ecoretools.ale.compiler.revisitor

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import com.squareup.javapoet.ClassName
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

class RevisitorNamingUtils {

	def String getRevisitorPackageFqn(GenPackage pkg) {
		
		val pkgName = if(pkg.basePackage === null || pkg.basePackage == '') {
			pkg.getEcorePackage.name
		} else {
			pkg.basePackage
		}
		
		'''«pkgName».revisitor'''
	}

	def String getRevisitorInterfaceName(GenPackage pkg) {
		'''«pkg.getEcorePackage.name.toFirstUpper»Revisitor'''
	}

	def String getRevisitorInterfaceFqn(GenPackage pkg) '''«pkg.revisitorPackageFqn».«pkg.revisitorInterfaceName»'''

	def String getRevisitorInterfacePath(GenPackage pkg) {
		val pn = if(pkg.basePackage !== null && pkg.basePackage != '') {
			pkg.basePackage
		} else {
			pkg.getEcorePackage.name
		}
		'''src/«FOR fragment: pn.split("\\.") SEPARATOR '/'»«fragment»«ENDFOR»/revisitor'''
	
	}

	def String getTypeParamName(EClass cls) '''«cls.EPackage.name.replaceAll("\\.", "").toFirstUpper»__«cls.name»T'''

	def String getDenotationName(EClass cls) '''«cls.EPackage.name.toFirstLower»__«cls.name»'''

	def String getDenotationName(
		Pair<EClass, EClass> cls) '''«cls.key.denotationName»«IF cls.value !== null»__AS__«cls.value.denotationName»«ENDIF»'''

	def String getDenotationName(EClass parent, EClass child) '''«parent.denotationName»_«child.denotationName»'''

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
	
	def String classInterfacePackageName(EClass eClass, String packageRoot) {
		eClass.EPackage.factoryInterfacePackageName(packageRoot)
	}
	
	def String factoryInterfacePackageName(EPackage ePackage, String packageRoot) {
		'''«IF packageRoot !== null && packageRoot != ''»«packageRoot».«ENDIF»«ePackage.name».revisitor.«ePackage.name»'''
	}
}
