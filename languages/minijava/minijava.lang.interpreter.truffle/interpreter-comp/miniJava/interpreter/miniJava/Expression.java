package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expression extends EObject, NodeInterface, Statement, Assignee {
	void evaluateStatement(State state);

	Value evaluateExpression(State state);
}
