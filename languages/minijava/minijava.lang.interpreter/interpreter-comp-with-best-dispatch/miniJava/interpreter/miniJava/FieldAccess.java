package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.FieldAccessDispatchWrapperEvaluateExpression;
import org.eclipse.emf.ecore.EObject;

public interface FieldAccess extends EObject, NodeInterface, Expression {
  Expression getReceiver();

  void setReceiver(Expression value);

  Field getField();

  void setField(Field value);

  Value evaluateExpression(State state);

  FieldAccessDispatchWrapperEvaluateExpression getCachedEvaluateExpression();
}
