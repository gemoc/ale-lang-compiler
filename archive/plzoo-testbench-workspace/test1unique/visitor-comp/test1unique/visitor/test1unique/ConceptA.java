package test1unique.visitor.test1unique;

import java.lang.Boolean;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA extends EObject, AcceptInterface {
	EList<Boolean> getBs();
}
