package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface BinaryExp extends EObject, NodeInterface, Expression {
	Expression getLhs();

	void setLhs(Expression value);

	Expression getRhs();

	void setRhs(Expression value);
}
