package logo.lang.interpreter.tests

import kmLogo.interpreter.kmLogo.KmLogoPackage
import kmLogo.interpreter.kmLogo.LogoProgram
import logo.lang.tests.AbstractLogoTest
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class LogoTest extends AbstractLogoTest {
	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE)
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as LogoProgram
		result.eval
	}
}
