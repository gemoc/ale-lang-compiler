package emfrelations.visitor.emfrelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptB2 extends EObject, AcceptInterface {
	EList<ConceptA2> getConcepta2();
}
