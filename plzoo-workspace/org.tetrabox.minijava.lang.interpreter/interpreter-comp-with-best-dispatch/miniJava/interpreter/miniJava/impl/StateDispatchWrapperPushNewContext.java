package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.State;

public class StateDispatchWrapperPushNewContext {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected StateDispatchWrapperPushNewContext(State it) {
    this.callTargetStable = new CyclicAssumption("StateDispatchWrapperPushNewContext_2.246324198228963E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new StatePushNewContextRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
