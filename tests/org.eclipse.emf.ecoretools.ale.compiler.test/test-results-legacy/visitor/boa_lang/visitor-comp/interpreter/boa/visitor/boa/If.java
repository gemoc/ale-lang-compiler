package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface If extends EObject, AcceptInterface, Expr {
	Expr getCond();

	void setCond(Expr value);

	Expr getThn();

	void setThn(Expr value);

	Expr getEls();

	void setEls(Expr value);
}
