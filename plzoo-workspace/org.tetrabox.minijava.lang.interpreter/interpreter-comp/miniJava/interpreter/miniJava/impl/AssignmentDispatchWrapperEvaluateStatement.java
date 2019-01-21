package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Assignment;

public class AssignmentDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected AssignmentDispatchWrapperEvaluateStatement(Assignment it) {
    this.callTargetStable = new CyclicAssumption("AssignmentDispatchWrapperEvaluateStatement_3.2948273342781015E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new AssignmentEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
