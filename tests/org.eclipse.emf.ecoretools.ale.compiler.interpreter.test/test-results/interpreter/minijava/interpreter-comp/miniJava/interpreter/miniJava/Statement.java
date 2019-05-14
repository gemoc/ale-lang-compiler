package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

public interface Statement extends EObject {
	void evaluateStatement(State state);
}
