package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Unary extends EObject, AcceptInterface, Expr {
	UnaryOp getOp();

	void setOp(UnaryOp value);

	Expr getExpr();

	void setExpr(Expr value);
}
