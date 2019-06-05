package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface While extends EObject, AcceptInterface, Stmt {
	Expr getCond();

	void setCond(Expr value);

	Stmt getBody();

	void setBody(Stmt value);
}
