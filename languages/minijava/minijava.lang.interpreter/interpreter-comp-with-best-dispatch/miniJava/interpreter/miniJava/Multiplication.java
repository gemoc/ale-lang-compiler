package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.MultiplicationDispatchWrapperEvaluateExpression;
import org.eclipse.emf.ecore.EObject;

public interface Multiplication extends EObject, NodeInterface, Expression {
  Expression getLeft();

  void setLeft(Expression value);

  Expression getRight();

  void setRight(Expression value);

  Value evaluateExpression(State state);

  MultiplicationDispatchWrapperEvaluateExpression getCachedEvaluateExpression();
}
