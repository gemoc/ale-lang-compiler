package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoolOpOr;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class BoolOpOrDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected BoolOpOrDispatchWrapperEval(BoolOpOr it) {
    this.callTargetStable = new CyclicAssumption("BoolOpOrDispatchWrapperEval_3656001.125574403");
    this.callTarget = Truffle.getRuntime().createCallTarget(new BoolOpOrEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
