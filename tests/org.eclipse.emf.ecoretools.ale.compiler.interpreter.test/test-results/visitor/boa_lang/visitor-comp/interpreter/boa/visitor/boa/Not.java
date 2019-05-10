package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface Not extends EObject, AcceptInterface, Expr {
	Expr getValue();

	void setValue(Expr value);
}
