package org.eclipse.emf.ecoretools.ale.compiler.ui

import java.lang.reflect.Modifier
import java.util.List
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager

class EclipseServiceRegistrationManager extends ServicesRegistrationManager {
	
	val JavaExtensionsManager javaExtensions
	
	new() {
		javaExtensions = JavaExtensionsManager.createManagerWithOverride();
		javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {

			override loaded(String arg0, Class<?> arg1) {
				System.err.println('''service registration: «arg0» -> «arg1» ''')
				val classname = arg1.simpleName
				val packagename = arg1.package.name
				val pair = packagename -> classname
				for(method : arg1.declaredMethods){
					if(Modifier.isStatic(method.modifiers)){
						registeredServices.put(method.name, pair)
					}
				}
			}

			override notFound(String arg0) {
				System.err.println('''«arg0» not found during services registration''')
			}

			override unloaded(String arg0, Class<?> arg1) {
				registeredServices = registeredServices.filter[k, v| v.value != arg1.name || v.key != arg1.package.name]
			}

		});
	}
	
	override registerServices(String projectName, List<ParsedFile<ModelUnit>> parsedSemantics) {
		if (javaExtensions !== null) {
			javaExtensions.updateScope(newHashSet(), #{projectName})

			val services = parsedSemantics.map[root].filter[it !== null].map[services].flatten + #[TrigoServices.name]
			registerServices(services.toList)

		}
	}

	private def registerServices(List<String> services) {
		if (javaExtensions !== null) {
			services.forEach[javaExtensions.addImport(it)]
			javaExtensions.reloadIfNeeded()
		}
	}
	
	
}