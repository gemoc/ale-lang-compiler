package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Method;

public class MethodDispatchWrapperEvaluateStatement {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected MethodDispatchWrapperEvaluateStatement(Method it) {
    this.callTargetStable = new CyclicAssumption("MethodDispatchWrapperEvaluateStatement_5.857812839715143E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new MethodEvaluateStatementRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
