package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArrayLength extends EObject, NodeInterface, Expression {
	Expression getArray();

	void setArray(Expression value);

	Value evaluateExpression(State state);
}
