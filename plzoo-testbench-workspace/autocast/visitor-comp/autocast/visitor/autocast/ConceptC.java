package autocast.visitor.autocast;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptC extends EObject, AcceptInterface {
	EList<ConceptA> getAx();
}
