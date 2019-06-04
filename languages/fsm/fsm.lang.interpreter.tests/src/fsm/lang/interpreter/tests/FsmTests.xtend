package fsm.lang.interpreter.tests

import fsm.interpreter.fsm.FsmPackage
import fsm.interpreter.fsm.System
import fsm.lang.tests.AbstractFsmTest
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class FsmTests extends AbstractFsmTest {
	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE)
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as System
		result.main(30)
	}
}