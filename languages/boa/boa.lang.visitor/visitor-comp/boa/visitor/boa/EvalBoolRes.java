package boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface EvalBoolRes extends EObject, AcceptInterface, EvalRes {
	boolean isValue();

	void setValue(boolean value);
}
