package testbidirectionalrelation.visitor.testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptB extends EObject, AcceptInterface {
	ConceptC getConceptc();

	void setConceptc(ConceptC value);
}
