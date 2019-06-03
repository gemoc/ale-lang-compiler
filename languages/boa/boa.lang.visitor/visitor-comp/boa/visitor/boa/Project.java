package boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Project extends EObject, AcceptInterface, Expr {
	String getName();

	void setName(String value);

	Expr getExp();

	void setExp(Expr value);
}
