package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;

public interface ConceptC extends EObject {
	ConceptB getConceptb();

	void setConceptb(ConceptB value);
}