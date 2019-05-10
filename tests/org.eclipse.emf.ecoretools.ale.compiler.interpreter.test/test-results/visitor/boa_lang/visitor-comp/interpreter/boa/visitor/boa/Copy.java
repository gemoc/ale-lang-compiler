package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface Copy extends EObject, AcceptInterface, Expr {
	Expr getCopy();

	void setCopy(Expr value);
}
