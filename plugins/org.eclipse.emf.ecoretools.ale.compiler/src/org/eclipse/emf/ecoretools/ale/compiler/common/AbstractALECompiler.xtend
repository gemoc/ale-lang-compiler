package org.eclipse.emf.ecoretools.ale.compiler.common

import java.util.List
import java.util.Map
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel

abstract class AbstractALECompiler {
	protected val JavaExtensionsManager javaExtensions
	protected val Map<String, Class<?>> registeredServices = newHashMap
	protected extension EcoreUtils = new EcoreUtils

	new() {
		javaExtensions = JavaExtensionsManager.createManagerWithOverride();
		javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {

			override loaded(String arg0, Class<?> arg1) {
				registeredServices.put(arg0, arg1)
			}

			override notFound(String arg0) {
				System.err.println('''«arg0» not found during services registration''')
			}

			override unloaded(String arg0, Class<?> arg1) {
				registeredServices.remove(arg0);
			}

		});
	}
	
	new(Map<String, Class<?>> services) {
		this();
		registeredServices.putAll(services)
	}

	def registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {

		javaExtensions.updateScope(newHashSet(), #{projectName})

		val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
		registerServices(services.toList)
	}

	def registerServices(List<String> services) {
		services.forEach[javaExtensions.addImport(it)]
		javaExtensions.reloadIfNeeded()
	}
	
	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax, Map<String, Pair<EPackage, GenModel>> syntaxes) {
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
}
