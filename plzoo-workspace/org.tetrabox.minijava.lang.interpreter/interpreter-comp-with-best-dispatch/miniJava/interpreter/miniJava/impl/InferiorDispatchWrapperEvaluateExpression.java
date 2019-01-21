package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Inferior;

public class InferiorDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected InferiorDispatchWrapperEvaluateExpression(Inferior it) {
    this.callTargetStable = new CyclicAssumption("InferiorDispatchWrapperEvaluateExpression_7.005336444093949E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new InferiorEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
