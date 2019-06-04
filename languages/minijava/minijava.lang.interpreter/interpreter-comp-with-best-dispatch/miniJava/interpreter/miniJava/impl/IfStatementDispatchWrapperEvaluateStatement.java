package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.IfStatement;

public class IfStatementDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected IfStatementDispatchWrapperEvaluateStatement(IfStatement it) {
    this.callTargetStable = new CyclicAssumption("IfStatementDispatchWrapperEvaluateStatement_5.959996906839787E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new IfStatementEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
