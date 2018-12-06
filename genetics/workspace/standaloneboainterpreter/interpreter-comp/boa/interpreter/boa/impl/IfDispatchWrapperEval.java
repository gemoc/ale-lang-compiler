package boa.interpreter.boa.impl;

import boa.interpreter.boa.If;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class IfDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected IfDispatchWrapperEval(If it) {
    this.callTargetStable = new CyclicAssumption("IfDispatchWrapperEval_8.068616230969937E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new IfEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
