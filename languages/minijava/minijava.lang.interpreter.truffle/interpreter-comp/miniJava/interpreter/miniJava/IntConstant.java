package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface IntConstant extends EObject, NodeInterface, Expression {
	int getValue();

	void setValue(int value);

	Value evaluateExpression(State state);
}
