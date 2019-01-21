package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.ArrayAccessDispatchWrapperEvaluateExpression;
import org.eclipse.emf.ecore.EObject;

public interface ArrayAccess extends EObject, NodeInterface, Expression {
  Expression getObject();

  void setObject(Expression value);

  Expression getIndex();

  void setIndex(Expression value);

  Value evaluateExpression(State state);

  ArrayAccessDispatchWrapperEvaluateExpression getCachedEvaluateExpression();
}
