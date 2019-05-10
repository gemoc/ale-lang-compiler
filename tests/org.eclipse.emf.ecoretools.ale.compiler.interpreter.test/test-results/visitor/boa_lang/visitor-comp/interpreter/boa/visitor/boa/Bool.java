package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface Bool extends EObject, AcceptInterface, Expr {
	boolean isValue();

	void setValue(boolean value);
}
