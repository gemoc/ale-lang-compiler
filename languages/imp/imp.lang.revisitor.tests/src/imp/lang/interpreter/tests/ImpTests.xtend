package imp.lang.interpreter.tests

import imp.lang.tests.AbstractImpTest
import imp.model.imp.ImpFactory
import imp.model.imp.ImpPackage
import imp.model.imp.Stmt
import imp_revisitor.impl.Imp_revisitorImplementation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class ImpTests extends AbstractImpTest {
	static Imp_revisitorImplementation rev
	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE)
		rev = new Imp_revisitorImplementation() {}
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as Stmt
		val s = ImpFactory.eINSTANCE.createStore
		rev.$(result).execute(s)
	}
}
