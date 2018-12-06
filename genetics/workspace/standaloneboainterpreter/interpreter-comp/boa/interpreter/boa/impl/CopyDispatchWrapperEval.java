package boa.interpreter.boa.impl;

import boa.interpreter.boa.Copy;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CopyDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected CopyDispatchWrapperEval(Copy it) {
    this.callTargetStable = new CyclicAssumption("CopyDispatchWrapperEval_6.995387787698655E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new CopyEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
