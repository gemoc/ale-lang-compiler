package boa.lang.interpreter.tests

import boa.lang.tests.AbstractBoaTest
import interpreter.boa.interpreter.boa.BoaPackage
import interpreter.boa.interpreter.boa.File
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class BoaTests extends AbstractBoaTest {

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE)
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as File
		result.eval
	}
}
