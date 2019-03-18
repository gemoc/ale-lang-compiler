package org.eclipse.emf.ecoretools.ale.compiler.interpreter.test

import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.util.Map
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.TrueFileFilter
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicContainer
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class InterpreterTestAll {

	static Map<File, File> compilations = newHashMap

	private static final boolean DEBUG = false

	@BeforeAll
	def static void beforeAll() {
		new File("assets").listFiles.filter[it.isDirectory].forEach [
			try {
				compilations.put(it, it.compileProject)
			} catch (Exception e) {
				println(e)
			}
		]
	}

	@AfterAll
	def static void afterAll() {
		if (!DEBUG) {
			compilations.forEach [ p1, p2 |
				p2.cleanupProject
			]
		} else {
			compilations.forEach[p1, p2|println('''«p1» -> «p2»''')]
		}
	}

	def static void cleanupProject(File tmpDir) {
		FileUtils.deleteDirectory(tmpDir);
	}

	@TestFactory
	def testInterpreters() {
		compilations.entrySet.map [ e |
			val d = e.key
			val tmpDir = e.value
			val expectedDir = new File('''test-results/«d.name»''')
			val files = FileUtils.listFiles(expectedDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
			val tmpfiles = FileUtils.listFiles(tmpDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
			DynamicContainer.dynamicContainer(d.name, files.map [ f |
				val relative = expectedDir.toPath().relativize(f.toPath());
				val relativePath = relative.toFile().getPath();
				DynamicTest.dynamicTest(relativePath, [
					val bfile = new File(tmpDir, relativePath);
					if (bfile.exists()) {
						val charset = Charset.defaultCharset().toString;
						val expected = FileUtils.readFileToString(f, charset);
						val result = FileUtils.readFileToString(bfile, charset);
						Assertions.assertEquals(expected, result);
					} else {
						Assertions.fail(relativePath + " expected to exist");
					}
				])
			] + tmpfiles.map [ f |
				val a = tmpDir.toPath()
				val bbb = f.toPath()
				val relative = a.relativize(bbb)
				val relativePath = relative.toFile().getPath();
				DynamicTest.dynamicTest(relativePath, [
					val bfile = new File(expectedDir, relativePath);
					if (!bfile.exists) {
						Assertions.fail('''«relativePath» generated but not expected''')
					}
				])
			])
		]
	}

	def static compileProject(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALEInterpreterImplementationCompiler

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile(directory.name, tmpDir, new Dsl('''«directory.path»/test.dsl'''), newHashMap)
		tmpDir
	}
}
