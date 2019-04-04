package test1.visitor.test1;

import java.lang.Boolean;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA extends EObject, AcceptInterface {
	EList<Boolean> getBs();

	long getB();

	void setB(long value);
}
