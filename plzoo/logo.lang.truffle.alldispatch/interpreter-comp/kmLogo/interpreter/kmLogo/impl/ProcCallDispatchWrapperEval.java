package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.ProcCall;

public class ProcCallDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ProcCallDispatchWrapperEval(ProcCall it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ProcCallDispatchWrapperEval_4.6783764934422985E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ProcCallEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
