package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Null extends EObject, NodeInterface, Expression {
  Value evaluateExpression(State state);
}
