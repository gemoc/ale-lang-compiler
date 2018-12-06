package boa.interpreter.boa.impl;

import boa.interpreter.boa.File;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class FileDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected FileDispatchWrapperEval(File it) {
    this.callTargetStable = new CyclicAssumption("FileDispatchWrapperEval_1.841897196935613E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new FileEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
