package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Right;

public class RightDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected RightDispatchWrapperEval(Right it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("RightDispatchWrapperEval_4.920927269183061E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new RightEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
