package emfrelations.visitor.emfrelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptB4 extends EObject, AcceptInterface {
	ConceptA4 getConcepta4();

	void setConcepta4(ConceptA4 value);
}
