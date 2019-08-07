package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Statement extends EObject, NodeInterface {
	void evaluateStatement(State state);
}
