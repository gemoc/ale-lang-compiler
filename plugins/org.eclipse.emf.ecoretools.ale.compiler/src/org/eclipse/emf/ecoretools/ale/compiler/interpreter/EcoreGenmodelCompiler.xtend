package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import java.util.List
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel

class EcoreGenmodelCompiler {
	def compileEcoreGenmodel(List<EPackage> ePackages, String path, String projectName) {

		val resSet = new ResourceSetImpl

		ePackages.forEach [ ePackage |
			val ecoreRes = resSet.createResource(URI.createFileURI('''«path»/«ePackage.name».ecore'''))
			ecoreRes.contents += EcoreUtil2.copy(ePackage) => [
				it.nsURI = '''http://«ePackage.name».«ePackage.name».«ePackage.name»/'''
			]
			ecoreRes.save(null)
			
			// TODO: define genmodel
			val gm = GenModelFactory.eINSTANCE.createGenModel
			gm.initialize(#[ePackage])
			gm.modelDirectory = '''/«projectName»/interpreter-comp'''
			gm.genPackages.head.basePackage = '''«ePackage.name».interpreter'''
			gm.complianceLevel = GenJDKLevel.JDK80_LITERAL
			
			val gmRes = resSet.createResource(URI.createFileURI('''«path»/«ePackage.name».genmodel'''))
			gmRes.contents += gm
			gmRes.save(null)
			
		]
	}
}
