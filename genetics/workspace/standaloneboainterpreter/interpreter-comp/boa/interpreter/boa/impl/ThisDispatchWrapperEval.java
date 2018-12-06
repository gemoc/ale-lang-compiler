package boa.interpreter.boa.impl;

import boa.interpreter.boa.This;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ThisDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ThisDispatchWrapperEval(This it) {
    this.callTargetStable = new CyclicAssumption("ThisDispatchWrapperEval_7.230227659133871E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ThisEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
