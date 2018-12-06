package boa.interpreter.boa.impl;

import boa.interpreter.boa.CmpOpEqual;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CmpOpEqualDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected CmpOpEqualDispatchWrapperEval(CmpOpEqual it) {
    this.callTargetStable = new CyclicAssumption("CmpOpEqualDispatchWrapperEval_4.8124552330600984E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new CmpOpEqualEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
