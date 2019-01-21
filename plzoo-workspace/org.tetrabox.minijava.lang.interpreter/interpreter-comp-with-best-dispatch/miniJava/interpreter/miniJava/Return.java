package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.ReturnDispatchWrapperEvaluateStatement;
import org.eclipse.emf.ecore.EObject;

public interface Return extends EObject, NodeInterface, Statement {
  Expression getExpression();

  void setExpression(Expression value);

  void evaluateStatement(State state);

  ReturnDispatchWrapperEvaluateStatement getCachedEvaluateStatement();
}
