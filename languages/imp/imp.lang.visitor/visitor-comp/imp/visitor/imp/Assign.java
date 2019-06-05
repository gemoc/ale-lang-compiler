package imp.visitor.imp;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Assign extends EObject, AcceptInterface, Stmt {
	String getName();

	void setName(String value);

	Expr getExp();

	void setExp(Expr value);
}
