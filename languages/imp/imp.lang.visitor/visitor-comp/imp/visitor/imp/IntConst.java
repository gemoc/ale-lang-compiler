package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface IntConst extends EObject, AcceptInterface, Expr {
	int getValue();

	void setValue(int value);
}
