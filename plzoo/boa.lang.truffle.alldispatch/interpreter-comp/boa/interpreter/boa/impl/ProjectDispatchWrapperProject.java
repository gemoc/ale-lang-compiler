package boa.interpreter.boa.impl;

import boa.interpreter.boa.Project;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ProjectDispatchWrapperProject {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ProjectDispatchWrapperProject(Project it) {
    this.callTargetStable = new CyclicAssumption("ProjectDispatchWrapperProject_3798097.9057300747");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ProjectProjectRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
