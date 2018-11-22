package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.PenUp;

public class PenUpDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected PenUpDispatchWrapperEval(PenUp it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("PenUpDispatchWrapperEval_3.956841924884154E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new PenUpEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
