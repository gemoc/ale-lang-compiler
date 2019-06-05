package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface If extends EObject, AcceptInterface, Stmt {
	Expr getCond();

	void setCond(Expr value);

	Stmt getLhs();

	void setLhs(Stmt value);

	Stmt getRhs();

	void setRhs(Stmt value);
}
