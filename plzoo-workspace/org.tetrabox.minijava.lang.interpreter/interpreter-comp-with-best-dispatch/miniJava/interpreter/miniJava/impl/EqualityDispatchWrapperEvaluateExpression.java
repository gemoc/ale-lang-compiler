package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Equality;

public class EqualityDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected EqualityDispatchWrapperEvaluateExpression(Equality it) {
    this.callTargetStable = new CyclicAssumption("EqualityDispatchWrapperEvaluateExpression_3.369725701706069E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new EqualityEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
