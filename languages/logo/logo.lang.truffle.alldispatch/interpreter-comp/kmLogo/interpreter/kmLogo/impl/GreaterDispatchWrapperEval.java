package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Greater;

public class GreaterDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected GreaterDispatchWrapperEval(Greater it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("GreaterDispatchWrapperEval_9.071246926764618E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new GreaterEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
