package testbidirectionalrelation.visitor.testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptC extends EObject, AcceptInterface {
	ConceptB getConceptb();

	void setConceptb(ConceptB value);
}
