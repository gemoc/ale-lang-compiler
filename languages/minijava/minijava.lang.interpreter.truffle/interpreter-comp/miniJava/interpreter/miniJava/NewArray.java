package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface NewArray extends EObject, NodeInterface, Expression {
	TypeRef getType();

	void setType(TypeRef value);

	Expression getSize();

	void setSize(Expression value);

	Value evaluateExpression(State state);
}
