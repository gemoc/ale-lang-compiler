package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Binary extends EObject, NodeInterface, Expr {
	BinaryOp getOp();

	void setOp(BinaryOp value);

	Expr getLhs();

	void setLhs(Expr value);

	Expr getRhs();

	void setRhs(Expr value);
}
