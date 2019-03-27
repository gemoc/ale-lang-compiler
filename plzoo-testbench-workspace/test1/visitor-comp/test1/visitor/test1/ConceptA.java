package test1.visitor.test1;

import java.lang.Boolean;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA extends EObject, AcceptInterface {
	Boolean getBs();

	void setBs(Boolean value);

	long getB();

	void setB(long value);
}
