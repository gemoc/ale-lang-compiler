package emfrelations.visitor.emfrelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA10 extends EObject, AcceptInterface {
	ConceptB10 getConceptb10();

	void setConceptb10(ConceptB10 value);
}
