package boa.lang.interpreter.tests

import boa.BoaPackage
import boa.lang.tests.AbstractBoaTest
import boa_exec_revisitor.impl.Boa_exec_revisitorImplementation
import boa.File
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class BoaTests extends AbstractBoaTest {

	static Boa_exec_revisitorImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE)
		rev = new Boa_exec_revisitorImplementation {} 
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val File result = resource.contents.head as File
		rev.$(result).eval()
	}

}
