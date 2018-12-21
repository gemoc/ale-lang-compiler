package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface This extends EObject, NodeInterface, Expression {
  Value evaluateExpression(State state);
}
