package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface EvalBoolRes extends EObject, AcceptInterface, EvalRes {
	boolean isValue();

	void setValue(boolean value);
}
