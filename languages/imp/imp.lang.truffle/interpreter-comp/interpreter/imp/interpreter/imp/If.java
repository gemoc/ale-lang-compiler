package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface If extends EObject, NodeInterface, Stmt {
	Expr getCond();

	void setCond(Expr value);

	Stmt getLhs();

	void setLhs(Stmt value);

	Stmt getRhs();

	void setRhs(Stmt value);

	Store execute(Store s);
}
