package boa.lang.interpreter.tests

import boa.lang.tests.AbstractBoaTest
import boa.visitor.boa.BoaPackage
import boa.visitor.boa.File
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import visitor.VisitorImplementation
import visitor.operation.boa.FileOperation

class BoaTests extends AbstractBoaTest {

	static VisitorImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE)
		rev = new VisitorImplementation
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val File result = resource.contents.head as File
		(result.accept(rev) as FileOperation).eval
	}

}
