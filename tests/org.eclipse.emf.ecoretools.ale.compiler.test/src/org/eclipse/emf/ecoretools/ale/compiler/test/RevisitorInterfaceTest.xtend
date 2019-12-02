package org.eclipse.emf.ecoretools.ale.compiler.test

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import org.apache.commons.io.FileUtils
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecoretools.ale.compiler.RevisitorInterfaceGenerator
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class RevisitorInterfaceTest {

	def static void cleanupProject(File tmpDir) {
		FileUtils.deleteDirectory(tmpDir);
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		new File("assets").listFiles.filter[it.isDirectory].map [ directory |
			GenModelPackage.eINSTANCE.eClass
			Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
			Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)
			val dsl = new Dsl('''«directory.path»/test.dsl''')
			val syntax = dsl.allSyntaxes.head
			val uriEcore = URI.createURI(syntax)
			val uriGenmodel = URI.createURI(syntax.replaceAll(".ecore$", ".genmodel"))
			val rsi = new ResourceSetImpl
			val ecoreRes = rsi.getResource(uriEcore, true).contents.head as EPackage
			val genmodelRes = rsi.getResource(uriGenmodel, true).contents.head as GenModel
			rsi.URIConverter = new URIConverterImpl() {
				override InputStream createInputStream(URI uri) throws IOException {
					return new FileInputStream(new File(directory, uri.toString));
				}
			}
			DynamicTest.dynamicTest('''Revisitor interface «directory»''', [
				try {
					val inter = new RevisitorInterfaceGenerator(genmodelRes.genPackages.head).generateInterface(ecoreRes, genmodelRes,
						genmodelRes.genPackages.head)
					val charset = Charset.defaultCharset().toString;
					val expected = FileUtils.readFileToString(new File('''revisitors-result/«directory.name».java'''),
						charset);
					Assertions.assertEquals(expected, inter)
				} catch (Exception e) {
					Assertions.fail(e);
				}
			])
		]
	}

}
