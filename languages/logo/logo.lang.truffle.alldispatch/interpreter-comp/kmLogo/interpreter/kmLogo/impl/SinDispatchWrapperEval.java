package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Sin;

public class SinDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected SinDispatchWrapperEval(Sin it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("SinDispatchWrapperEval_9.030536316317272E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new SinEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
