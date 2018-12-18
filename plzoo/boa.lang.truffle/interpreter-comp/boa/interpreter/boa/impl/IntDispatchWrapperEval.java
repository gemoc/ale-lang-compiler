package boa.interpreter.boa.impl;

import boa.interpreter.boa.Int;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class IntDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected IntDispatchWrapperEval(Int it) {
    this.callTargetStable = new CyclicAssumption("IntDispatchWrapperEval_8.788075502027142E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new IntEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
