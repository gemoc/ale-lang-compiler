package imp.lang.interpreter.tests

import imp.lang.tests.AbstractImpTest
import imp.visitor.imp.ImpFactory
import imp.visitor.imp.ImpPackage
import imp.visitor.imp.Stmt
import imp.visitor.imp.Store
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import visitor.VisitorImplementation
import visitor.operation.imp.StmtOperation

class ImpTests extends AbstractImpTest {

	static VisitorImplementation visitor

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE)
		visitor = new VisitorImplementation();
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as Stmt
		val Store s = ImpFactory.eINSTANCE.createStore
		val op = result.accept(visitor) as StmtOperation
		op.execute(s)
	}
}
