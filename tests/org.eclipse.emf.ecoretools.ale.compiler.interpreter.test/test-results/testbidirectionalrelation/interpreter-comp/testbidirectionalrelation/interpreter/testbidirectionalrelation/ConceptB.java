package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;

public interface ConceptB extends EObject {
	ConceptC getConceptc();

	void setConceptc(ConceptC value);
}