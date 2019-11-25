package emfrelations.visitor.emfrelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptB1 extends EObject, AcceptInterface {
	ConceptA1 getConcepta1();

	void setConcepta1(ConceptA1 value);
}
