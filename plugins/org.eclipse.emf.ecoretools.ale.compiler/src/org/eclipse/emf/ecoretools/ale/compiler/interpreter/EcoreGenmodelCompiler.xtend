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

	// val alexRoot = input.allContents.head as AlexRoot
	// val project = alexRoot.eResource.URI.segment(1)
	// val gm = alexRoot.ecoreImport.uri.loadGenmodel
	// val abstractSyntax = gm.EPackage
	// TODO: Produce a relevant genmodel here
//		val target = alexRoot.compileTarget
//
//		val clonegm = EcoreUtil2.copy(gm)
//
//		clonegm.modelDirectory = '''/«project»/src-gen'''
//		clonegm.modelPluginID = '''«project»'''
//		clonegm.modelName = '''«target.name.toFirstUpper»'''
//		clonegm.foreignModel.clear
//		clonegm.foreignModel += '''./«target.name».ecore'''
//		clonegm.genPackages.clear
//
//		clonegm.initialize(newArrayList())
//
//		val rsgm = rsp.get.createResource(
//			URI.createURI('''platform:/resource/«project»/src-gen/«target.name».genmodel'''))
//		rsgm.contents += clonegm
//
//		val asb = EcoreUtil2.copy(abstractSyntax)
//
//		asb.nsURI = '''http://«target.name».«alexRoot.name».«abstractSyntax.name»/'''
//		asb.name = target.name
//		asb.nsPrefix = target.name
//
//		val rsas = rsp.get.createResource(URI.createURI('''platform:/resource/«project»/src-gen/«target.name».ecore'''))
//		rsas.contents += asb
//
//		clonegm.initialize(newArrayList(asb))
//
//		rsgm.save(null)
//		rsas.save(null)
	}
}
