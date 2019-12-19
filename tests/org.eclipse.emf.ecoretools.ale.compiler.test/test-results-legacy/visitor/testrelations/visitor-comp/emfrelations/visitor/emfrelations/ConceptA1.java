package emfrelations.visitor.emfrelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA1 extends EObject, AcceptInterface {
	EList<ConceptB1> getConceptb1();
}
