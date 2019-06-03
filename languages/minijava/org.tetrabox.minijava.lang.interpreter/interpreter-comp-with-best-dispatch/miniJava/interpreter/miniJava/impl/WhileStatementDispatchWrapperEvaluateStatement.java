package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.WhileStatement;

public class WhileStatementDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected WhileStatementDispatchWrapperEvaluateStatement(WhileStatement it) {
    this.callTargetStable = new CyclicAssumption("WhileStatementDispatchWrapperEvaluateStatement_5.943899454665049E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new WhileStatementEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
