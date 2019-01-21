package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.State;

public class StateDispatchWrapperPushNewFrame {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected StateDispatchWrapperPushNewFrame(State it) {
    this.callTargetStable = new CyclicAssumption("StateDispatchWrapperPushNewFrame_2.152643938334664E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new StatePushNewFrameRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
