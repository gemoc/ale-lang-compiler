package emfrelations.visitor.emfrelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA3 extends EObject, AcceptInterface {
	EList<ConceptB3> getConceptb3();
}
