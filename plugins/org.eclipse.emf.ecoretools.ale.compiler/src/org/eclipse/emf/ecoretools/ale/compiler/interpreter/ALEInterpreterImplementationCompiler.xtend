package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager
import org.eclipse.xtend.lib.annotations.Data

class ALEInterpreterImplementationCompiler {

	@Data
	static class ResolvedClass {
		ExtendedClass aleCls
		public EClass eCls
		GenClass genCls
	}

	extension EcoreUtils = new EcoreUtils

	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	val Map<String, Class<?>> registeredServices = newHashMap
	val JavaExtensionsManager javaExtensions
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	var List<ResolvedClass> resolved

	new() {
		this.queryEnvironment = createQueryEnvironment(false, null)
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE)
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE)
		javaExtensions = JavaExtensionsManager.createManagerWithOverride();
		javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {

			override loaded(String arg0, Class<?> arg1) {
				registeredServices.put(arg0, arg1)
			}

			override notFound(String arg0) {
				throw new RuntimeException('''«arg0» not found during services registration''')
			}

			override unloaded(String arg0, Class<?> arg1) {
				registeredServices.remove(arg0);
			}

		});
	}

	def private IQueryEnvironment createQueryEnvironment(boolean b, Object object) {
		val IQueryEnvironment newEnv = new ExtensionEnvironment()
		newEnv.registerEPackage(EcorePackage.eINSTANCE)
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
			EStringToStringMapEntryImpl)
		newEnv
	}

	def compile(String projectName, File projectRoot, Dsl dsl) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

		registerServices(projectName)

		// must be last !
		compile(projectRoot)
	}

	def registerServices(String projectName) {

		javaExtensions.updateScope(newHashSet(), #{projectName});

		val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
		registerServices(services.toList);
	}

	def registerServices(List<String> services) {
		services.forEach[javaExtensions.addImport(it)]
		javaExtensions.reloadIfNeeded();
	}

	def private void compile(File projectRoot) {
		val compileDirectory = new File(projectRoot, "interpreter-comp")

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		// load all syntaxes in a cache
		syntaxes = dsl.allSyntaxes.toMap([it], [(loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel)])
		val syntax = syntaxes.get(dsl.allSyntaxes.head).key
		resolved = resolve(aleClasses, syntax)

		val fic = new FactoryInterfaceCompiler
		val fimplc = new FactoryImplementationCompiler
		
		val pic = new PackageInterfaceCompiler
		val pimplc = new PackageImplementationCompiler
		
		val eic = new EClassInterfaceCompiler
		val eimplc = new EClassImplementationCompiler

		// TODO: generate ecore + genmodel !
		syntaxes.forEach [ key, pairEPackageGenModel |
			fic.compileFactoryInterface(pairEPackageGenModel.key, compileDirectory)
			fimplc.compileFactoryImplementation(pairEPackageGenModel.key, compileDirectory)
			
			pic.compilePackageInterface(pairEPackageGenModel.key, compileDirectory)
			pimplc.compilePackageImplementation(pairEPackageGenModel.key, compileDirectory)

			for (EClass eclazz : pairEPackageGenModel.key.allClasses) {
				val rc = resolved.filter[it.eCls.name == eclazz.name && it.eCls.EPackage.name == eclazz.EPackage.name].
					head
				eic.compileEClassInterface(eclazz, rc?.aleCls, compileDirectory)
				eimplc.compileEClassImplementation(eclazz, rc?.aleCls, compileDirectory, syntaxes, resolved, registeredServices, dsl, parsedSemantics, queryEnvironment)
			}

		]
	}

	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax) {
		syntax.allClasses.map [ eClass |
			val aleClass = aleClasses.filter [
				it.name == eClass.name || it.name == eClass.EPackage.name + '.' + eClass.name
			].head
			val GenClass gl = syntaxes.filter[k, v|v.key.allClasses.contains(eClass)].values.map[value].map [
				it.genPackages.map[it.genClasses].flatten
			].flatten.filter[it.ecoreClass == eClass].head
			new ResolvedClass(aleClass, eClass, gl)
		]
	}
}
