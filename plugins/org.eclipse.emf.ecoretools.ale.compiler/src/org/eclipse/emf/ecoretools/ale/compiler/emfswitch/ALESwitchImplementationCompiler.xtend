package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClassifier
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

class ALESwitchImplementationCompiler {
	extension EcoreUtils = new EcoreUtils

	var Dsl dsl
	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	val Map<String, Class<?>> registeredServices = newHashMap
	val JavaExtensionsManager javaExtensions
	var Map<String, Pair<EPackage, GenModel>> syntaxes
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

	def registerServices(String projectName) {

		javaExtensions.updateScope(newHashSet(), #{projectName});

		val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
		registerServices(services.toList);
	}

	def registerServices(List<String> services) {
		services.forEach[javaExtensions.addImport(it)]
		javaExtensions.reloadIfNeeded();
	}

	def IStatus compile(String projectName, File projectRoot, Dsl dsl) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)
		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		syntaxes = dsl.allSyntaxes.toMap([it], [
			return (loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel)
		])
		val syntax = syntaxes.get(dsl.allSyntaxes.head).key
		resolved = resolve(aleClasses, syntax)

		registerServices(projectName)

		// must be last !
		compile(projectRoot, projectName)

		Status.OK_STATUS
	}

	def private void compile(File projectRoot, String projectName) {
		val compileDirectory = new File(projectRoot, "switch-comp")
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val String packageRoot = dsl.dslProp.get("rootPackage") as String

		val sic = new SwitchImplementationCompiler(compileDirectory, syntaxes, packageRoot, resolved)

		sic.compile

		val soc = new SwitchOperationCompiler(packageRoot, compileDirectory, syntaxes, queryEnvironment,
			parsedSemantics, resolved, registeredServices, dsl)

		resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry"].forEach [ resolved |
			soc.compile(resolved)
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
			if(gl === null) throw new RuntimeException('''gl is null''')
			new ResolvedClass(aleClass, eClass, gl)
		]
	}

	@Data
	static class ResolvedClass {
		ExtendedClass aleCls
		public EClassifier eCls
		GenClass genCls
	}
}
