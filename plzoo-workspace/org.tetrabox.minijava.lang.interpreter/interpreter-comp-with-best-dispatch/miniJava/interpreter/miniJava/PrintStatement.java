package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.PrintStatementDispatchWrapperEvaluateStatement;
import org.eclipse.emf.ecore.EObject;

public interface PrintStatement extends EObject, NodeInterface, Statement {
  Expression getExpression();

  void setExpression(Expression value);

  void evaluateStatement(State state);

  PrintStatementDispatchWrapperEvaluateStatement getCachedEvaluateStatement();
}
