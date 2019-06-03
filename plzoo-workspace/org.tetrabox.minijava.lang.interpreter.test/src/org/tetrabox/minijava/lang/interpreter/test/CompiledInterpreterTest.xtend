package org.tetrabox.minijava.lang.interpreter.test

import miniJava.interpreter.miniJava.MiniJavaPackage
import miniJava.interpreter.miniJava.Program
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.junit.Test

class CompiledInterpreterTest {

	@Test
	def testBinaryTree() {
		test0('/home/manuel/dev/java/ale-lang/genetics-minijava/binarytree.minijava.xmi')
	}

	@Test
	def testFannkuchredux() {
		test0('/home/manuel/dev/java/ale-lang/genetics-minijava/fannkuchredux.minijava.xmi')
	}

	@Test
	def testFib() {
		test0('/home/manuel/dev/java/ale-lang/genetics-minijava/fib.minijava.xmi')
	}

	@Test
	def testSort() {
		test0('/home/manuel/dev/java/ale-lang/genetics-minijava/sort.minijava.xmi')
	}

	def test0(String path) {
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('xmi', new XMIResourceFactoryImpl)
		EPackage.Registry.INSTANCE.put('http://miniJava.miniJava.miniJava/', MiniJavaPackage.eINSTANCE);
		val rs = new ResourceSetImpl
		val result = rs.getResource(URI.createURI(path), true).contents.head as Program
		result.initialize(null)
		result.main
	}
}
