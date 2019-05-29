package factorydeclorder.visitor.factorydeclorder;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface A extends EObject, AcceptInterface, D, B {
	int getFa();

	void setFa(int value);
}
