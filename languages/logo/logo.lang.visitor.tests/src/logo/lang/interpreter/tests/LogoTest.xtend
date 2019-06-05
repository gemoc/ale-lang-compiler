package logo.lang.interpreter.tests

import kmLogo.visitor.kmLogo.KmLogoPackage
import kmLogo.visitor.kmLogo.LogoProgram
import logo.lang.tests.AbstractLogoTest
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import visitor.VisitorImplementation
import visitor.operation.kmLogo.LogoProgramOperation

class LogoTest extends AbstractLogoTest {

	static VisitorImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE)
		rev = new VisitorImplementation()
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as LogoProgram
		val lpo = result.accept(rev) as LogoProgramOperation
		lpo.eval
	}
}
