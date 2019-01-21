package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.SuperiorOrEqual;

public class SuperiorOrEqualDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected SuperiorOrEqualDispatchWrapperEvaluateExpression(SuperiorOrEqual it) {
    this.callTargetStable = new CyclicAssumption("SuperiorOrEqualDispatchWrapperEvaluateExpression_7.29175259230985E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new SuperiorOrEqualEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
