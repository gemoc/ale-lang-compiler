package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.ForStatement;

public class ForStatementDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ForStatementDispatchWrapperEvaluateStatement(ForStatement it) {
    this.callTargetStable = new CyclicAssumption("ForStatementDispatchWrapperEvaluateStatement_9.428377622108442E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ForStatementEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
