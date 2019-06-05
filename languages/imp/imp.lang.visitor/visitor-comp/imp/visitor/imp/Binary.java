package imp.visitor.imp;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Binary extends EObject, AcceptInterface, Expr {
	BinaryOp getOp();

	void setOp(BinaryOp value);

	Expr getLhs();

	void setLhs(Expr value);

	Expr getRhs();

	void setRhs(Expr value);
}
