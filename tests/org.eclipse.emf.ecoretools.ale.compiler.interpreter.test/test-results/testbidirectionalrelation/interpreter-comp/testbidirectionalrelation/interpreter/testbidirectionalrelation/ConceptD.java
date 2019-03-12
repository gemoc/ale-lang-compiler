package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;

public interface ConceptD extends EObject {
	ConceptE getConcepte();

	void setConcepte(ConceptE value);
}
