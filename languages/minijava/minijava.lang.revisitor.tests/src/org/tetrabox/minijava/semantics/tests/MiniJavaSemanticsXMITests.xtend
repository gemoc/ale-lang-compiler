package org.tetrabox.minijava.semantics.tests

import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Consumer
import miniJava.MiniJavaPackage
import miniJava.State
import minijava_exec.impl.operation.ProgramOp
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
import miniJava.Program
import minijava_exec.impl.Minijava_execImplementation

@RunWith(XtextRunner)
@InjectWith(MiniJavaInjectorProvider)
class MiniJavaSemanticsXMITests {
	
	@Test
	def void minijava_sort() {
		genericXMITest("../../../programs/minijava_sort.xmi")
	}
	@Test
	def void minijava_fibonacci() {
		genericXMITest("../../../programs/minijava_fibonacci.xmi")
	}
	@Test
	def void minijava_binarytree() {
		genericXMITest("../../../programs/minijava_binarytree.xmi")
	}
	@Test
	def void minijava_fannkuchredux() {
		genericXMITest("../../../programs/minijava_fannkuchredux.xmi")
	}
	
	def void genericXMITest(String path){
		EPackage.Registry.INSTANCE.put("http://miniJava.miniJava.miniJava/", MiniJavaPackage.eINSTANCE)

		val result = loadFromXMI(path) as Program;
		val expected = new String(Files.readAllBytes(Paths.get(path+".expected")))

		Assert.assertNotNull(result)
		val rev = new Minijava_execImplementation() {};
		val po = rev.$(result)
		po.initialize(new BasicEList)
		
		val state = po.execute()
		val oracle = [ State s |
			Assert::assertTrue(expected.compareTo(s.outputStream.stream.join("\n")) == 0)
		] as Consumer<State>
		
		oracle.accept(state);
	}
	
	private def Program loadFromXMI(String file) {
		val reg = Resource.Factory.Registry.INSTANCE
		val m = reg.getExtensionToFactoryMap()
		m.put("xmi", new XMIResourceFactoryImpl())

		val resSet = new ResourceSetImpl()
		val createFileURI = URI.createFileURI(file)
		val resource = resSet.getResource(createFileURI, true)
		val result = resource.getContents().get(0) as Program
		
		return result
	}
}