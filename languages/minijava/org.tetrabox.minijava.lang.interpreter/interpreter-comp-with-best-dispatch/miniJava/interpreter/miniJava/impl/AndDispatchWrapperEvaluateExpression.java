package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.And;

public class AndDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected AndDispatchWrapperEvaluateExpression(And it) {
    this.callTargetStable = new CyclicAssumption("AndDispatchWrapperEvaluateExpression_6179079.5465805");
    this.callTarget = Truffle.getRuntime().createCallTarget(new AndEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
