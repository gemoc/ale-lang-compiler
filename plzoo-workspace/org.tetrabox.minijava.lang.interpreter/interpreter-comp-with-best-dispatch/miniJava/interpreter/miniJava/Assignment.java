package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.AssignmentDispatchWrapperEvaluateStatement;
import org.eclipse.emf.ecore.EObject;

public interface Assignment extends EObject, NodeInterface, Statement {
  Assignee getAssignee();

  void setAssignee(Assignee value);

  Expression getValue();

  void setValue(Expression value);

  void evaluateStatement(State state);

  AssignmentDispatchWrapperEvaluateStatement getCachedEvaluateStatement();
}
