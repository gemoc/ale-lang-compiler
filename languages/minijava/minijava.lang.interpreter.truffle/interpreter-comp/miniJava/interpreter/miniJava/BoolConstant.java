package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface BoolConstant extends EObject, NodeInterface, Expression {
	String getValue();

	void setValue(String value);

	Value evaluateExpression(State state);
}
