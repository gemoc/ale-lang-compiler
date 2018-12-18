package boa.interpreter.boa.impl;

import boa.interpreter.boa.Let;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class LetDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected LetDispatchWrapperEval(Let it) {
    this.callTargetStable = new CyclicAssumption("LetDispatchWrapperEval_1.5857202575487223E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new LetEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
