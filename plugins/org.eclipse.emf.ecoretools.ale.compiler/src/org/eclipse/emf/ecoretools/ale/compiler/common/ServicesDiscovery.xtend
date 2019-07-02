package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback
import java.util.Map

class ServicesDiscovery {
	def JavaExtensionsManager initEclipse(Map<String, Class<?>> registeredServices){
		val javaExtensions = JavaExtensionsManager.createManagerWithOverride();
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
		return javaExtensions
	}
	
	def JavaExtensionsManager initMaven(Map<String, Class<?>> registeredServices){
		val javaExtensions = JavaExtensionsManager.createManagerWithOverride();
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
		return javaExtensions
	}
}