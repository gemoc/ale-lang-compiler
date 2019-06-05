package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface BoolValue extends EObject, AcceptInterface, Value {
	boolean isValue();

	void setValue(boolean value);
}
