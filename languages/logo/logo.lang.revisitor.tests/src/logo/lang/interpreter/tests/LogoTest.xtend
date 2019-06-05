package logo.lang.interpreter.tests

import LogoProgram_revisitor.impl.LogoProgram_revisitorImplementation
import kmLogo.KmLogoPackage
import kmLogo.LogoProgram
import logo.lang.tests.AbstractLogoTest
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class LogoTest extends AbstractLogoTest {

	static LogoProgram_revisitorImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE)
		rev = new LogoProgram_revisitorImplementation() {
		}
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as LogoProgram
//		result.eval
		rev.$(result).eval
	}
}
