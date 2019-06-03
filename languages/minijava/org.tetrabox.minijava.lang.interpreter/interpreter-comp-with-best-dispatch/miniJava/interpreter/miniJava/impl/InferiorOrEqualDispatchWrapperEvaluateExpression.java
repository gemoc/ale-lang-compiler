package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.InferiorOrEqual;

public class InferiorOrEqualDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected InferiorOrEqualDispatchWrapperEvaluateExpression(InferiorOrEqual it) {
    this.callTargetStable = new CyclicAssumption("InferiorOrEqualDispatchWrapperEvaluateExpression_4.209832689714481E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new InferiorOrEqualEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
