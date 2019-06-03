package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface IntValue extends EObject, Value {
	int getValue();

	void setValue(int value);
}
