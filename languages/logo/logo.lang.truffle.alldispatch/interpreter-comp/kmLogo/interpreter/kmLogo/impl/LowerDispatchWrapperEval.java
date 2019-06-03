package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Lower;

public class LowerDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected LowerDispatchWrapperEval(Lower it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("LowerDispatchWrapperEval_4047008.9983688984");
    this.callTarget = Truffle.getRuntime().createCallTarget(new LowerEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
