package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.PrintStatement;

public class PrintStatementDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected PrintStatementDispatchWrapperEvaluateStatement(PrintStatement it) {
    this.callTargetStable = new CyclicAssumption("PrintStatementDispatchWrapperEvaluateStatement_1.3740892749219302E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new PrintStatementEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
