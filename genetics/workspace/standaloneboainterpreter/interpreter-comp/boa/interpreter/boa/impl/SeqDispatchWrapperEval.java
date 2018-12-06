package boa.interpreter.boa.impl;

import boa.interpreter.boa.Seq;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class SeqDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected SeqDispatchWrapperEval(Seq it) {
    this.callTargetStable = new CyclicAssumption("SeqDispatchWrapperEval_8.687244458030194E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new SeqEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
