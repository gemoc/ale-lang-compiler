package emfrelations.visitor.emfrelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA5 extends EObject, AcceptInterface {
	EList<ConceptB5> getConceptb5();
}
