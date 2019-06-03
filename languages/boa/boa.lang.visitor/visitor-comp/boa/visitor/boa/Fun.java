package boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Fun extends EObject, AcceptInterface, Expr {
	String getName();

	void setName(String value);

	Expr getBody();

	void setBody(Expr value);
}
