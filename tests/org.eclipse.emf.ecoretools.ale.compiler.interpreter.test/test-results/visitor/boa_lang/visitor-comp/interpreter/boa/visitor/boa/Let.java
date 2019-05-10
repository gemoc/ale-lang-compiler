package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Let extends EObject, AcceptInterface, Expr {
	String getName();

	void setName(String value);

	Expr getLhs();

	void setLhs(Expr value);

	Expr getRhs();

	void setRhs(Expr value);
}
