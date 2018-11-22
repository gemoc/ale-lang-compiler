package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Repeat;

public class RepeatDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected RepeatDispatchWrapperEval(Repeat it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("RepeatDispatchWrapperEval_8.481493059866457E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new RepeatEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
