package factorydeclorder.visitor.factorydeclorder;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface C extends EObject, AcceptInterface, B, A {
	boolean isFc();

	void setFc(boolean value);
}
