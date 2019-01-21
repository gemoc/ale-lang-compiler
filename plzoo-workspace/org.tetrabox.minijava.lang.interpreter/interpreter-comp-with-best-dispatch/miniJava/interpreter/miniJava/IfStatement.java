package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.IfStatementDispatchWrapperEvaluateStatement;
import org.eclipse.emf.ecore.EObject;

public interface IfStatement extends EObject, NodeInterface, Statement {
  Expression getExpression();

  void setExpression(Expression value);

  Block getThenBlock();

  void setThenBlock(Block value);

  Block getElseBlock();

  void setElseBlock(Block value);

  void evaluateStatement(State state);

  IfStatementDispatchWrapperEvaluateStatement getCachedEvaluateStatement();
}
