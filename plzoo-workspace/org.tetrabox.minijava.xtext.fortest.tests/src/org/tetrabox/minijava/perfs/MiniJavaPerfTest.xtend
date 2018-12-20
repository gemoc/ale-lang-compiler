package org.tetrabox.minijava.perfs

import com.google.inject.Inject
import miniJava.interpreter.miniJava.Program
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.tetrabox.minijava.semantics.tests.util.MiniJavaTestUtil
import org.tetrabox.minijava.xtext.fortest.tests.MiniJavaInjectorProvider
import org.junit.Ignore
import org.graalvm.polyglot.Context

//@RunWith(XtextRunner)
//@InjectWith(MiniJavaInjectorProvider)
class MiniJavaPerfTest {
//	@Inject
//	extension MiniJavaTestUtil testUtil
//	@Inject XtextResourceSet rs
//	@Test
//	@Ignore
	def static void main(String[] args) {

		val cptr = 50;
		val context = Context.create();
		val results = newArrayList
		for (var i = 0; i < cptr; i++) {
			val res = context.eval('miniJava', i.toString);
			results.add(res.asLong)
		}
		println('''«FOR i : results BEFORE '[' SEPARATOR ', ' AFTER ']'»«i»«ENDFOR»''')
	}
}
