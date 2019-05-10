package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface With extends EObject, AcceptInterface, Expr {
	Expr getLhs();

	void setLhs(Expr value);

	Expr getRhs();

	void setRhs(Expr value);
}
