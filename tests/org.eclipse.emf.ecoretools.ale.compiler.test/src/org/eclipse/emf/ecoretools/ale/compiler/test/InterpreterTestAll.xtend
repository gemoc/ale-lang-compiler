package org.eclipse.emf.ecoretools.ale.compiler.test

import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.util.List
import java.util.Map
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.TrueFileFilter
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.ALERevisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.visitor.ALEVisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
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
		"interpreter" -> [f|compileProjectInterpreter(f)],
//		"interpreter.truffle" -> [f|compileProjectInterpreterTruffle(f)]
		"revisitor" -> [f|compileProjectRevisitor(f)],
		"switch" -> [f|compileProjectSwitch(f)],
		"visitor" -> [f|compileProjectVisitor(f)]
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
			//.filter[it.path == "assets/minijava"]
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
		compilers.entrySet.sortBy[it.key].map [ en |
			val k = en.key
			DynamicContainer.dynamicContainer(k, compilations.get(k).entrySet.sortBy[it.key.absolutePath].map [ e |
				val d = e.key
				val tmpDir = e.value
				val expectedDir = new File('''test-results/«k»/«d.name»''')
				if(!expectedDir.exists) println('''«expectedDir» does not exist.''')
				val files = FileUtils.listFiles(expectedDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)
					.sortBy [it.absolutePath]
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

	def static ServicesRegistrationManager getServices(String pts) {
		switch (pts) {
			case "assets/boa_lang":
//				newHashMap(
//					"execboa.MapService" -> MapService,
//					"execboa.MathService" -> MathService,
//					"execboa.SerializeService" -> SerializeService
//				)
				new ServicesRegistrationManager() {
					override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
						
						// MapService
						this.registeredServices.put("put", "execboa" -> "MapService")
						this.registeredServices.put("putAll", "execboa" -> "MapService")
						this.registeredServices.put("replaceWith", "execboa" -> "MapService")
						this.registeredServices.put("getFromMap", "execboa" -> "MapService")
						this.registeredServices.put("mapToString", "execboa" -> "MapService")
						this.registeredServices.put("containsKey", "execboa" -> "MapService")
						this.registeredServices.put("newMap", "execboa" -> "MapService")
						
						// MathService
						this.registeredServices.put("mod", "execboa" -> "MathService")
					
						// SerializeService
						this.registeredServices.put("serialize", "execboa" -> "SerializeService")
					}

				}
			case "assets/minijava":
//				newHashMap(
//					"execboa.MapService" -> MapService,
//					"execboa.MathService" -> MathService
//				)
				new ServicesRegistrationManager() {
					override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
						this.registeredServices.put("put", "execboa" -> "MapService")
						this.registeredServices.put("putAll", "execboa" -> "MapService")
						this.registeredServices.put("replaceWith", "execboa" -> "MapService")
						this.registeredServices.put("getFromMap", "execboa" -> "MapService")
						this.registeredServices.put("mapToString", "execboa" -> "MapService")
						this.registeredServices.put("containsKey", "execboa" -> "MapService")
						this.registeredServices.put("newMap", "execboa" -> "MapService")
						
						this.registeredServices.put("mod", "execboa" -> "MathService")
						
						
					}

				}
			case "assets/logo_lang":
//				newHashMap(
//					"org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices" -> TrigoServices
//				)
				new ServicesRegistrationManager() {
					override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
						this.registeredServices.put("cosinus", "org.eclipse.emf.ecoretools.ale.core.interpreter.services" -> "TrigoServices")
						this.registeredServices.put("sinus", "org.eclipse.emf.ecoretools.ale.core.interpreter.services" -> "TrigoServices")
						this.registeredServices.put("tan", "org.eclipse.emf.ecoretools.ale.core.interpreter.services" -> "TrigoServices")
					}

				}
			case "assets/testmap1":
//				newHashMap(
//					"execboa.MapService" -> MapService
//				)
				new ServicesRegistrationManager() {
					override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
						this.registeredServices.put("put", "execboa" -> "MapService")
						this.registeredServices.put("putAll", "execboa" -> "MapService")
						this.registeredServices.put("replaceWith", "execboa" -> "MapService")
						this.registeredServices.put("getFromMap", "execboa" -> "MapService")
						this.registeredServices.put("mapToString", "execboa" -> "MapService")
						this.registeredServices.put("containsKey", "execboa" -> "MapService")
						this.registeredServices.put("newMap", "execboa" -> "MapService")
					}

				}
			default:
				new ServicesRegistrationManager() {
					override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {}	
				}
		}
	}

	def static compileProjectInterpreter(File directory) {

		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALEInterpreterImplementationCompiler(directory.name, tmpDir,
			new Dsl('''«directory.path»/test.dsl'''), new EcoreUtils, directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile()
		tmpDir
	}

	def static compileProjectInterpreterTruffle(File directory) {

		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val dsl = new Dsl('''«directory.path»/test.dsl''')
		//dsl.truffle = true // TODO reintegrate truffle

		val compiler = new ALEInterpreterImplementationCompiler(directory.name, tmpDir, dsl, new EcoreUtils,
			directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile()
		tmpDir
	}

	def static compileProjectRevisitor(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile

		val compiler = new ALERevisitorImplementationCompiler(directory.name, tmpDir,
			new Dsl('''«directory.path»/test.dsl'''), new EcoreUtils, new JavaPoetUtils, directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile()
		tmpDir
	}

	def static compileProjectSwitch(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALESwitchImplementationCompiler(directory.name, tmpDir,
			new Dsl('''«directory.path»/test.dsl'''), new EcoreUtils, directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile()
		tmpDir
	}

	def static compileProjectVisitor(File directory) {
		val tmpDir = Files.createTempDirectory('ale_compiler').toFile
		val compiler = new ALEVisitorImplementationCompiler(directory.name, tmpDir,
			new Dsl('''«directory.path»/test.dsl'''), new EcoreUtils, directory.path.services)

		GenModelPackage.eINSTANCE.eClass
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("genmodel", new XMIResourceFactoryImpl)

		compiler.compile()
		tmpDir
	}
}
