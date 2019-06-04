package boa.lang.interpreter.tests

import boa.BoaPackage
import boa.File
import boa.lang.tests.AbstractBoaTest
import emfswitch.emfswitch.EmfswitchSwitchImplementation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import emfswitch.emfswitch.operation.FileOperation

class BoaTests extends AbstractBoaTest {

	static EmfswitchSwitchImplementation rev

	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE)
		rev = new EmfswitchSwitchImplementation
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val File result = resource.contents.head as File
		(rev.doSwitch(result) as FileOperation).eval
	}

}
