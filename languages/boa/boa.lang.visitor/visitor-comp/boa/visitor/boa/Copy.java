package boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Copy extends EObject, AcceptInterface, Expr {
	Expr getCopy();

	void setCopy(Expr value);
}
