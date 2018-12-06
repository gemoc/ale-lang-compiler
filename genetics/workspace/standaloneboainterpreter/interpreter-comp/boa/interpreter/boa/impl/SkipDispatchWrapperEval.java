package boa.interpreter.boa.impl;

import boa.interpreter.boa.Skip;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class SkipDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected SkipDispatchWrapperEval(Skip it) {
    this.callTargetStable = new CyclicAssumption("SkipDispatchWrapperEval_3078073.3887599045");
    this.callTarget = Truffle.getRuntime().createCallTarget(new SkipEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
