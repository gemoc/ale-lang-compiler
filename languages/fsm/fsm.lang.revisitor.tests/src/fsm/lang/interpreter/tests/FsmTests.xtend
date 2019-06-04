package fsm.lang.interpreter.tests

import fsm.lang.tests.AbstractFsmTest
import fsm.model.fsm.FsmPackage
import fsm.model.fsm.System
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import fsm.impl.FsmImplementation

class FsmTests extends AbstractFsmTest {
	
	static FsmImplementation rev
	
	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE)
		rev = new FsmImplementation {}
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as System
		rev.$(result).main(30)
	}
}