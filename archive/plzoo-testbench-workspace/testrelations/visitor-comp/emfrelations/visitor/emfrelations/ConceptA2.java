package emfrelations.visitor.emfrelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA2 extends EObject, AcceptInterface {
	ConceptB2 getConceptb2();

	void setConceptb2(ConceptB2 value);
}
