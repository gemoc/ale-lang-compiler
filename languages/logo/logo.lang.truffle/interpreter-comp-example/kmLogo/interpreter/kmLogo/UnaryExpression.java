package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface UnaryExpression extends EObject, NodeInterface, Expression {
	Expression getExpression();

	void setExpression(Expression value);
}
