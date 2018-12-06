package boa.interpreter.boa.impl;

import boa.interpreter.boa.CmpOpLess;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CmpOpLessDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected CmpOpLessDispatchWrapperEval(CmpOpLess it) {
    this.callTargetStable = new CyclicAssumption("CmpOpLessDispatchWrapperEval_1.534656808890035E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new CmpOpLessEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
