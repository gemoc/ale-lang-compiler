package boa.interpreter.boa.impl;

import boa.interpreter.boa.CmpOpUnequal;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CmpOpUnequalDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected CmpOpUnequalDispatchWrapperEval(CmpOpUnequal it) {
    this.callTargetStable = new CyclicAssumption("CmpOpUnequalDispatchWrapperEval_7.037863400218292E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new CmpOpUnequalEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
