package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Fun extends EObject, AcceptInterface, Expr {
	String getName();

	void setName(String value);

	Expr getBody();

	void setBody(Expr value);
}
