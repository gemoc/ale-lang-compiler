package org.eclipse.emf.ecoretools.ale.compiler.interpreter.test

import execboa.MapService
import execboa.MathService
import execboa.SerializeService
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.util.Map
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.TrueFileFilter
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.ALERevisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.visitor.ALEVisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DynamicContainer
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

import static spoon.testing.Assert.assertThat

class InterpreterTestAll {

	static Map<String, Map<File, File>> compilations = newHashMap

	static val compilers = newHashMap(
//		"interpreter" -> [f|compileProjectInterpreter(f)],
//		"revisitor" -> [f|compileProjectRevisitor(f)],
		"switch" -> [f|compileProjectSwitch(f)] //,
//		"visitor" -> [f|compileProjectVisitor(f)]
	)

	private static final boolean DEBUG = true

	def static void log(String txt) {
		if(DEBUG) println(txt)
	}

	@BeforeAll
	def static void beforeAll() {
		compilers.forEach [ p1, p2 |
			compilations.put(p1, newHashMap)
		]

		compilers.forEach [ k, v |
			new File("assets").listFiles.filter[it.isDirectory]
				.filter[it.path == "assets/minijava"]
				.forEach [
				try {
					compilations.get(k).put(it, v.apply(it))
				} catch (Exception e) {
					println('''Compilation failed for «k» -> «it»:''')
					e.printStackTrace
				}
			]
		]

	}

	@AfterAll
	def static void afterAll() {
		if (!DEBUG) {
			compilations.forEach [ p1, p2 |
				p2.forEach [ p10, p20 |
					p20.cleanupProject
				]
			]
		} else {
			compilations.forEach [ p1, p2 |
				println('''# Compiled «p1»''')
				p2.forEach [ p10, p20 |
					println('''«p10» -> «p20»''')
				]
			]
		}
	}

	def static void cleanupProject(File tmpDir) {
		FileUtils.deleteDirectory(tmpDir);
	}

	@TestFactory
	def Iterable<DynamicContainer> testInterpreters() {
		compilers.entrySet.map [ en |
			val k = en.key
			DynamicContainer.dynamicContainer(k, compilations.get(k).entrySet.map [ e |
				val d = e.key
				val tmpDir = e.value
				val expectedDir = new File('''test-results/«k»/«d.name»''')
				val files = FileUtils.listFiles(expectedDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
				val tmpfiles = FileUtils.listFiles(tmpDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
				DynamicContainer.dynamicContainer(d.name, files.map [ f |
					val relative = expectedDir.toPath().relativize(f.toPath());
					val relativePath = relative.toFile().getPath();
					DynamicTest.dynamicTest(relativePath, [
						val bfile = new File(tmpDir, relativePath);
						if (bfile.exists()) {

							try {
								assertThat(f).isEqualTo(bfile)
							} catch (AssertionError ae) {
								val charset = Charset.defaultCharset().toString;
								val expected = FileUtils.readFileToString(f, charset);
								val result = FileUtils.readFileToString(bfile, charset);
								Assertions.assertEquals(expected, result);
							}
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
			])
		]
	}

	def static Map<String, Class<?>> getServices(String pts) {
		switch (pts) {
			case "assets/boa_lang":
				newHashMap(
					"execboa.MapService" -> MapService,
					"execboa.MathService" -> MathService,
					"execboa.SerializeService" -> SerializeService
				)
			case "assets/minijava":
				newHashMap(
					"execboa.MapService" -> MapService,
					"execboa.MathService" -> MathService
				)
			case "assets/logo_lang":
				newHashMap(
					"org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices" -> TrigoServices
				)
			case "assets/testmap1":
				newHashMap(
					"execboa.MapService" -> MapService
				)
			default:
				newHashMap
		}
	}

	def static compileProjectInterpreter(File directory) {

//		if(directory.path == "assets/testmap1") {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALEInterpreterImplementationCompiler(directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile(directory.name, tmpDir, new Dsl('''«directory.path»/test.dsl'''), newHashMap)
		tmpDir
//		}
	}

	def static compileProjectRevisitor(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile

		val compiler = new ALERevisitorImplementationCompiler(directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile(directory.name, tmpDir, new Dsl('''«directory.path»/test.dsl'''))
		tmpDir
	}

	def static compileProjectSwitch(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALESwitchImplementationCompiler(directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile(directory.name, tmpDir, new Dsl('''«directory.path»/test.dsl'''))
		tmpDir
	}

	def static compileProjectVisitor(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALEVisitorImplementationCompiler(directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile(directory.name, tmpDir, new Dsl('''«directory.path»/test.dsl'''), newHashMap)
		tmpDir
	}
}
