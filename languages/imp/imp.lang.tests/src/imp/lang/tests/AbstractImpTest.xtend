package imp.lang.tests;

import java.io.ByteArrayOutputStream
import java.io.File
import org.apache.commons.io.FileUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest

import static org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.*

abstract class AbstractImpTest {

	val langname = 'imp'

	def Iterable<DynamicTest> test0() {

		val root = new File('''../«langname».lang.tests/programs/''')

		root.listFiles.filter[it.isFile].filter[it.name.endsWith('''.«langname».xmi''')].map [
			DynamicTest.dynamicTest(it.name, [
				genericTest(it.absolutePath, FileUtils.readFileToString(new File(it.absolutePath + '.expected')))
			])
		]
	}

	def genericTest(String file, String expectedResult) {
		LogService.TOSDTOUT = false

		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		val resSet = new ResourceSetImpl
		val createFileURI = URI.createFileURI(file);
		val resource = resSet.getResource(createFileURI, true)
		val res = this.execute(resource)
		val baou = new ByteArrayOutputStream
		val er = new XMIResourceImpl
		er.contents += res
		er.save(baou, null)

		Assertions.assertEquals(expectedResult, baou.toString)
	}

	abstract def EObject execute(Resource resource)
}
