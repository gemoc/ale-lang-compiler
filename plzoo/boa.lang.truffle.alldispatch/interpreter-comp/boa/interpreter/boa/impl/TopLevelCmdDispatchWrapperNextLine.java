package boa.interpreter.boa.impl;

import boa.interpreter.boa.TopLevelCmd;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class TopLevelCmdDispatchWrapperNextLine {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected TopLevelCmdDispatchWrapperNextLine(TopLevelCmd it) {
    this.callTargetStable = new CyclicAssumption("TopLevelCmdDispatchWrapperNextLine_8.926405886470462E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new TopLevelCmdNextLineRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
