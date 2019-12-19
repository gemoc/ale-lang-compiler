package testbidirectionalrelation.visitor.testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptD extends EObject, AcceptInterface {
	ConceptE getConcepte();

	void setConcepte(ConceptE value);
}
