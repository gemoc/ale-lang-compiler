package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.MethodCallDispatchWrapperEvaluateExpression;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface MethodCall extends EObject, NodeInterface, Expression {
  Expression getReceiver();

  void setReceiver(Expression value);

  Method getMethod();

  void setMethod(Method value);

  EList<Expression> getArgs();

  Value evaluateExpression(State state);

  void call(Method realMethod, State state);

  MethodCallDispatchWrapperEvaluateExpression getCachedEvaluateExpression();
}
