package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.PenDown;

public class PenDownDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected PenDownDispatchWrapperEval(PenDown it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("PenDownDispatchWrapperEval_3.2190932142818872E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new PenDownEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
