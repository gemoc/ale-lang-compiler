package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface EvalIntRes extends EObject, AcceptInterface, EvalRes {
	int getValue();

	void setValue(int value);
}
