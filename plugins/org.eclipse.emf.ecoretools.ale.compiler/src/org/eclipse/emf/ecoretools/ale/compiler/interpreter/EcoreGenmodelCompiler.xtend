package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import org.eclipse.emf.ecore.EPackage
import java.util.List
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.EcoreUtil2

class EcoreGenmodelCompiler {
	def compileEcoreGenmodel(List<EPackage> ePackages, String path) {

		val resSet = new ResourceSetImpl

		ePackages.forEach [ ePackage |
			val ecoreRes = resSet.createResource(URI.createFileURI('''«path»/«ePackage.name».ecore'''))
			ecoreRes.contents += EcoreUtil2.copy(ePackage) => [
				it.nsURI = '''http://«ePackage.name».«ePackage.name».«ePackage.name»/'''
			]
			ecoreRes.save(null)
		]
	}
}
