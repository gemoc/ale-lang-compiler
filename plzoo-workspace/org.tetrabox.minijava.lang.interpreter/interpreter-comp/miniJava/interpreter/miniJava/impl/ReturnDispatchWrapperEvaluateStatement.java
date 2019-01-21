package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Return;

public class ReturnDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ReturnDispatchWrapperEvaluateStatement(Return it) {
    this.callTargetStable = new CyclicAssumption("ReturnDispatchWrapperEvaluateStatement_3.0347861738477588E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ReturnEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
