package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface Int extends EObject, AcceptInterface, Expr {
	int getValue();

	void setValue(int value);
}
