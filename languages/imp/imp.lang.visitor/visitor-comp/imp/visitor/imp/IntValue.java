package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface IntValue extends EObject, AcceptInterface, Value {
	int getValue();

	void setValue(int value);
}
