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

@RunWith(XtextRunner)
@InjectWith(MiniJavaInjectorProvider)
class MiniJavaPerfTest {
	@Inject
	extension MiniJavaTestUtil testUtil

	@Inject XtextResourceSet rs

	@Test
	@Ignore
	def void binaryTree() {
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE)
		val resource = rs.getResource(
			URI.createURI("/home/manuel/dev/java/ale-lang/runtime-New_configuration/test/src/binarytree.minijava"),
			true)
		val result = resource.getContents().get(0) as Program
//		EcoreUtil.resolveAll(result)
		EcoreUtil.resolveAll(rs)
		Assert.assertNotNull(result)
//		helper.assertNoErrors(result)
		result.initialize(new BasicEList())
		val state = result.execute()
		println(state)
	}
}
