package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Multiplication;

public class MultiplicationDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected MultiplicationDispatchWrapperEvaluateExpression(Multiplication it) {
    this.callTargetStable = new CyclicAssumption("MultiplicationDispatchWrapperEvaluateExpression_4.624855911187009E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new MultiplicationEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
