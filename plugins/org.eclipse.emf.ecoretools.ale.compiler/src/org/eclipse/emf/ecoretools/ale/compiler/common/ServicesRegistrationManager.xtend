package org.eclipse.emf.ecoretools.ale.compiler.common

import java.util.List
import java.util.Map
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit

abstract class ServicesRegistrationManager {
	
	protected var Map<String, Pair<String, String>> registeredServices = newHashMap
	
	abstract def void registerServices(String projectName, List<ParsedFile<ModelUnit>> parsedSemantics)
	
	def Map<String, Pair<String, String>> getRegisteredServices(){
		return registeredServices
	}
}