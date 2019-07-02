package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import java.util.List
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import java.util.Map
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices

class EclipseServiceRegistrationManager extends ServicesRegistrationManager {
	
	val JavaExtensionsManager javaExtensions
	
	new(Map<String, Class<?>> rs) {
		super(rs)
		
		javaExtensions = JavaExtensionsManager.createManagerWithOverride();
		javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {

			override loaded(String arg0, Class<?> arg1) {
				System.err.println('''service registration: «arg0» -> «arg1» ''')
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
	
	override registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics) {
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