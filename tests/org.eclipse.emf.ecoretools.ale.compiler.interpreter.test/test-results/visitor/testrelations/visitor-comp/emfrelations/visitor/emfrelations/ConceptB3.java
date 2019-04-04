package emfrelations.visitor.emfrelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptB3 extends EObject, AcceptInterface {
	EList<ConceptA3> getConcepta3();
}
