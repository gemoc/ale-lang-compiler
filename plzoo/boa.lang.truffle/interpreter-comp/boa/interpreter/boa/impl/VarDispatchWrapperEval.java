package boa.interpreter.boa.impl;

import boa.interpreter.boa.Var;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class VarDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected VarDispatchWrapperEval(Var it) {
    this.callTargetStable = new CyclicAssumption("VarDispatchWrapperEval_6408011.16547763");
    this.callTarget = Truffle.getRuntime().createCallTarget(new VarEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
