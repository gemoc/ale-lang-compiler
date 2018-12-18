package boa.interpreter.boa.impl;

import boa.interpreter.boa.Project;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ProjectDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ProjectDispatchWrapperEval(Project it) {
    this.callTargetStable = new CyclicAssumption("ProjectDispatchWrapperEval_4.471872847714159E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ProjectEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
