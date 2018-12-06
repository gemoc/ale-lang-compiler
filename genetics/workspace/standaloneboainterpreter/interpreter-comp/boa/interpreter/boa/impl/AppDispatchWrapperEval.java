package boa.interpreter.boa.impl;

import boa.interpreter.boa.App;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class AppDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected AppDispatchWrapperEval(App it) {
    this.callTargetStable = new CyclicAssumption("AppDispatchWrapperEval_3.1378938040435955E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new AppEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
