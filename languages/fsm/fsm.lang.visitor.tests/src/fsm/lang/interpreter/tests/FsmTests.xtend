package fsm.lang.interpreter.tests

import fsm.lang.tests.AbstractFsmTest
import fsm.visitor.fsm.FsmPackage
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import visitor.VisitorImplementation
import visitor.operation.fsm.SystemOperation

class FsmTests extends AbstractFsmTest {

	static VisitorImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE)
		rev = new VisitorImplementation
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as fsm.visitor.fsm.System
		(result.accept(rev) as SystemOperation).main(30)
	}
}
