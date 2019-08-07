package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Not extends EObject, NodeInterface, Expression {
	Expression getExpression();

	void setExpression(Expression value);

	Value evaluateExpression(State state);
}
