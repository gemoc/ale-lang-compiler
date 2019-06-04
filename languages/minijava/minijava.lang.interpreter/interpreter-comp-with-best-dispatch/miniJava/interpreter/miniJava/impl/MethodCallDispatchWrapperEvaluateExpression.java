package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.MethodCall;

public class MethodCallDispatchWrapperEvaluateExpression {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected MethodCallDispatchWrapperEvaluateExpression(MethodCall it) {
    this.callTargetStable = new CyclicAssumption("MethodCallDispatchWrapperEvaluateExpression_4.148486184002264E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new MethodCallEvaluateExpressionRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
