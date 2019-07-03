package org.eclipse.emf.ecoretools.ale.compiler.common

import java.util.List
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import java.util.Map

abstract class ServicesRegistrationManager {
	
	protected var Map<String, Pair<String, String>> registeredServices = newHashMap
	
	abstract def void registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics)
	
	def Map<String, Pair<String, String>> getRegisteredServices(){
		return registeredServices
	}
}