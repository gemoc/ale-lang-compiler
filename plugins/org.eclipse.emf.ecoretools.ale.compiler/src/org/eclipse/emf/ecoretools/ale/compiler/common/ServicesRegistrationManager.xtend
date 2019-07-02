package org.eclipse.emf.ecoretools.ale.compiler.common

import java.util.List
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import java.util.Map

abstract class ServicesRegistrationManager {
	
	protected val Map<String, Class<?>> registeredServices
	
	new(Map<String, Class<?>> rs) {
		registeredServices = rs
	}
	abstract def void registerServices(String projectName, List<ParseResult<ModelUnit>> parsedSemantics)
}