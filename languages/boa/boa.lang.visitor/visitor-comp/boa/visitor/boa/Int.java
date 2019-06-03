package boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Int extends EObject, AcceptInterface, Expr {
	int getValue();

	void setValue(int value);
}
