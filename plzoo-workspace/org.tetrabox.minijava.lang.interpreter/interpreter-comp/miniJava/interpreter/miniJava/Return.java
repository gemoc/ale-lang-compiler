package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Return extends EObject, NodeInterface, Statement {
  Expression getExpression();

  void setExpression(Expression value);

  void evaluateStatement(State state);
}
