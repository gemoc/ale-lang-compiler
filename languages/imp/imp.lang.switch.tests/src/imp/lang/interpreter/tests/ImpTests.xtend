package imp.lang.interpreter.tests

import emfswitch.SwitchImplementation
import imp.lang.tests.AbstractImpTest
import imp.model.imp.ImpFactory
import imp.model.imp.ImpPackage
import imp.model.imp.Stmt
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import emfswitch.operation.StmtOperation

class ImpTests extends AbstractImpTest {
	static SwitchImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE)
		rev = new SwitchImplementation()
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as Stmt
		val s = ImpFactory.eINSTANCE.createStore
		val op = rev.doSwitch(result) as StmtOperation
		op.execute(s)
	}
}
