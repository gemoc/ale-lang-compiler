package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Inequality;

public class InequalityDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected InequalityDispatchWrapperEvaluateExpression(Inequality it) {
    this.callTargetStable = new CyclicAssumption("InequalityDispatchWrapperEvaluateExpression_2.7076416109683502E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new InequalityEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
