package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.ArrayAccess;

public class ArrayAccessDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ArrayAccessDispatchWrapperEvaluateExpression(ArrayAccess it) {
    this.callTargetStable = new CyclicAssumption("ArrayAccessDispatchWrapperEvaluateExpression_9996832.610164925");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ArrayAccessEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
