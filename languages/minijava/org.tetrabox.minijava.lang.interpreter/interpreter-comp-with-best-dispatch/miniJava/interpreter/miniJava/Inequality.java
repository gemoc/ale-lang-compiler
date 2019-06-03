package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.InequalityDispatchWrapperEvaluateExpression;
import org.eclipse.emf.ecore.EObject;

public interface Inequality extends EObject, NodeInterface, Expression {
  Expression getLeft();

  void setLeft(Expression value);

  Expression getRight();

  void setRight(Expression value);

  Value evaluateExpression(State state);

  InequalityDispatchWrapperEvaluateExpression getCachedEvaluateExpression();
}
