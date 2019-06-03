package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Mult;

public class MultDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected MultDispatchWrapperEval(Mult it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("MultDispatchWrapperEval_8.356295178617635E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new MultEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
