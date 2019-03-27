package emfrelations.visitor.emfrelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA4 extends EObject, AcceptInterface {
	ConceptB4 getConceptb4();

	void setConceptb4(ConceptB4 value);
}
