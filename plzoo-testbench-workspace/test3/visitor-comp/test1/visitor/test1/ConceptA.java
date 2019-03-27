package test1.visitor.test1;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA extends EObject, AcceptInterface {
	EList<ConceptC> getCs();
}
