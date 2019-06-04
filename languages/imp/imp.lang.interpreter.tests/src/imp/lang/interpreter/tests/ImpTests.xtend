package imp.lang.interpreter.tests

import imp.lang.tests.AbstractImpTest
import interpreter.imp.interpreter.imp.ImpPackage
import interpreter.imp.interpreter.imp.Stmt
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import interpreter.imp.interpreter.imp.ImpFactory

class ImpTests extends AbstractImpTest {
	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE)
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as Stmt
		val s = ImpFactory.eINSTANCE.createStore
		result.execute(s)
	}
}
