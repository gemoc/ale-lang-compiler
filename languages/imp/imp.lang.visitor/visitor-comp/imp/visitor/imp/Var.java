package imp.visitor.imp;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Var extends EObject, AcceptInterface, Expr {
	String getName();

	void setName(String value);
}
