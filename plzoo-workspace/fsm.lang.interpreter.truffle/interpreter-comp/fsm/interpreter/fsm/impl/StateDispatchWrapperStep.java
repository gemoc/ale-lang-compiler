package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import fsm.interpreter.fsm.State;

public class StateDispatchWrapperStep {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected StateDispatchWrapperStep(State it) {
    this.callTargetStable = new CyclicAssumption("StateDispatchWrapperStep_7176654.8393239025");
    this.callTarget = Truffle.getRuntime().createCallTarget(new StateStepRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
