package boa.interpreter.boa.impl;

import boa.interpreter.boa.With;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class WithDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected WithDispatchWrapperEval(With it) {
    this.callTargetStable = new CyclicAssumption("WithDispatchWrapperEval_5.0860954907582924E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new WithEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
