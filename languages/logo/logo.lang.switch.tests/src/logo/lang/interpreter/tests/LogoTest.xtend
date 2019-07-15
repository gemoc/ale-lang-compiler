package logo.lang.interpreter.tests

import emfswitch.emfswitch.EmfswitchSwitchImplementation
import kmLogo.KmLogoPackage
import kmLogo.LogoProgram
import logo.lang.tests.AbstractLogoTest
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import emfswitch.emfswitch.operation.LogoProgramOperation

class LogoTest extends AbstractLogoTest { 

	static EmfswitchSwitchImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE)
		rev = new EmfswitchSwitchImplementation()
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as LogoProgram
		val lpo = rev.doSwitch(result) as LogoProgramOperation
		lpo.eval
	}
}
