package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.FieldAccess;

public class FieldAccessDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected FieldAccessDispatchWrapperEvaluateExpression(FieldAccess it) {
    this.callTargetStable = new CyclicAssumption("FieldAccessDispatchWrapperEvaluateExpression_3.4256712693174675E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new FieldAccessEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
