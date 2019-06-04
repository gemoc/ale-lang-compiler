package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface Binary extends EObject, Expr {
	BinaryOp getOp();

	void setOp(BinaryOp value);

	Expr getLhs();

	void setLhs(Expr value);

	Expr getRhs();

	void setRhs(Expr value);

	Value evaluate(Store s);
}
