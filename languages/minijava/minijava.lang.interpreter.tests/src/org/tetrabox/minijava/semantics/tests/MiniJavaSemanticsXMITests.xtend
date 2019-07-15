package org.tetrabox.minijava.semantics.tests

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EPackage
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.BeforeAll
import miniJava.interpreter.miniJava.MiniJavaPackage
import miniJava.interpreter.miniJava.Program
import org.junit.jupiter.api.DynamicTest
import minijava.lang.tests.AbstractMinijavaTest

class MiniJavaSemanticsXMITests extends AbstractMinijavaTest{
	
	@BeforeAll
	def static void before() {
		EPackage.Registry.INSTANCE.put("http://www.example.org/MiniJava", MiniJavaPackage.eINSTANCE)
	}

	@TestFactory
	def Iterable<DynamicTest> testInterpreters() {
		this.test0
	}

	override execute(Resource resource) {
		val result = resource.contents.head as Program
		result.execute
	}
	
}