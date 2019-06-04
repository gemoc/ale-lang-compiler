package fsm.lang.interpreter.tests

import emfswitch.SwitchImplementation
import fsm.lang.tests.AbstractFsmTest
import fsm.model.fsm.FsmPackage
import fsm.model.fsm.System
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import emfswitch.operation.SystemOperation

class FsmTests extends AbstractFsmTest {

	static SwitchImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE)
		rev = new SwitchImplementation {
		}
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as System
		(rev.doSwitch(result) as SystemOperation).main(30)
	}
}
