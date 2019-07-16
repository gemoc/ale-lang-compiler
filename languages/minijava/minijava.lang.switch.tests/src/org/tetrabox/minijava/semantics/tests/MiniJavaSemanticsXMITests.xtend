package org.tetrabox.minijava.semantics.tests

import emfswitch.operation.ProgramOperation
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Consumer
import miniJava.MiniJavaPackage
import miniJava.State
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.tetrabox.minijava.xtext.tests.MiniJavaInjectorProvider

@RunWith(XtextRunner)
@InjectWith(MiniJavaInjectorProvider)
class MiniJavaSemanticsXMITests {
	
	@Test
	def void minijava_sort() {
		genericXMITest("programs/minijava_sort.xmi")
	}
	@Test
	def void minijava_fibonacci() {
		genericXMITest("programs/minijava_fibonacci.xmi")
	}
	@Test
	def void minijava_binarytree() {
		genericXMITest("programs/minijava_binarytree.xmi")
	}
	@Test
	def void minijava_fannkuchredux() {
		genericXMITest("programs/minijava_fannkuchredux.xmi")
	}
	
	def void genericXMITest(String path){
		EPackage.Registry.INSTANCE.put("http://www.example.org/MiniJava", MiniJavaPackage.eINSTANCE)

		val result = loadFromXMI(path) as ProgramOperation;
		val expected = new String(Files.readAllBytes(Paths.get(path+".expected")))

		Assert.assertNotNull(result)
		result.initialize(new BasicEList)
		
		val state = result.execute()
		val oracle = [ State s |
			Assert::assertTrue(expected.compareTo(s.outputStream.stream.join("\n")) == 0)
		] as Consumer<State>
		
		oracle.accept(state);
	}
	
	private def ProgramOperation loadFromXMI(String file) {
		val reg = Resource.Factory.Registry.INSTANCE
		val m = reg.getExtensionToFactoryMap()
		m.put("xmi", new XMIResourceFactoryImpl())

		val resSet = new ResourceSetImpl()
		val createFileURI = URI.createFileURI(file)
		val resource = resSet.getResource(createFileURI, true)
		val result = resource.getContents().get(0) as ProgramOperation
		
		return result
	}
}