package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Var extends EObject, AcceptInterface, Expr {
	String getName();

	void setName(String value);
}
