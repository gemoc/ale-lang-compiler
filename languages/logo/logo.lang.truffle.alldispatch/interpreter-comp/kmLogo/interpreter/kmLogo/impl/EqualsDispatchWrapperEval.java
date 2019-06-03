package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Equals;

public class EqualsDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected EqualsDispatchWrapperEval(Equals it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("EqualsDispatchWrapperEval_8.480566043380147E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new EqualsEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
