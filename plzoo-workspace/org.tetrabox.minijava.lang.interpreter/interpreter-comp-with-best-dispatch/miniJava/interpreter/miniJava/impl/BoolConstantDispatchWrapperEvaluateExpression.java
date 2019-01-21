package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.BoolConstant;

public class BoolConstantDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected BoolConstantDispatchWrapperEvaluateExpression(BoolConstant it) {
    this.callTargetStable = new CyclicAssumption("BoolConstantDispatchWrapperEvaluateExpression_2.3533653318868414E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new BoolConstantEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
