package factorydeclorder.visitor.factorydeclorder;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface B extends EObject, AcceptInterface {
	long getFb();

	void setFb(long value);
}
