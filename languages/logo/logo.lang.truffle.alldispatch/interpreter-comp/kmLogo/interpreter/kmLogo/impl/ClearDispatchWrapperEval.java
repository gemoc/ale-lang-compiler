package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Clear;

public class ClearDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ClearDispatchWrapperEval(Clear it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ClearDispatchWrapperEval_9.692096704189244E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ClearEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
