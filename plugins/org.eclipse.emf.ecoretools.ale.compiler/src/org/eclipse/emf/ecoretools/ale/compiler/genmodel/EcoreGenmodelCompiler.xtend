package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import java.io.File
import java.util.List
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.xtext.EcoreUtil2

class EcoreGenmodelCompiler {
	
	val String compilationDirectory
	val String ePackageSuffix
	
	new(String compilationDirectory, String ePackageSuffix)  {
		this.compilationDirectory = compilationDirectory
		this.ePackageSuffix = ePackageSuffix
	}
	
	def compileEcoreGenmodel(List<EPackage> ePackages, String path, String projectName) {

		val resSet = new ResourceSetImpl
		
		resSet.getResourceFactoryRegistry.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/emf/2002/GenModel", GenModelPackage.eINSTANCE)
		resSet.resourceFactoryRegistry.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/emf/2002/Ecore", EcorePackage.eINSTANCE)

		ePackages.forEach [ ePackage |
			val tmpf = new File(path)
			if (!tmpf.exists) {
				tmpf.mkdirs
			}
			val uri = '''«path»/«ePackage.name».ecore'''
			val ecoreRes = resSet.createResource(URI.createURI(uri))
			ecoreRes.contents += EcoreUtil2.copy(ePackage) => [
				it.nsURI = '''http://«ePackage.name».«ePackage.name».«ePackage.name»/'''
			]
			ecoreRes.save(null)

			// TODO: define genmodel
			val gm = GenModelFactory.eINSTANCE.createGenModel
			gm.initialize(#[ePackage])
			gm.modelDirectory = '''/«projectName»/«compilationDirectory»'''
			gm.genPackages.head.basePackage = '''«ePackage.name».«ePackageSuffix»'''
			gm.complianceLevel = GenJDKLevel.JDK80_LITERAL
			gm.foreignModel += '''«ePackage.name».ecore'''

			val gmRes = resSet.createResource(URI.createFileURI('''«path»/«ePackage.name».genmodel'''))
			gmRes.contents += gm
			gmRes.save(null)

		]
	}
}
