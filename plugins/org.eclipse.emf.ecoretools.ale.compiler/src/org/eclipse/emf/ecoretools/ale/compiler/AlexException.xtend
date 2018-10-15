package org.eclipse.emf.ecoretools.ale.compiler

class AlexException extends Exception {
	new() {
		super()
	}
	
	new(String s) {
		super(s)
	}
	
	new(Throwable t) {
		super(t)
	}
	
	new (String s, Throwable t) {
		super(s, t)
	}
}