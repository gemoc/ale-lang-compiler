package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Method;

public class MethodDispatchWrapperCall {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected MethodDispatchWrapperCall(Method it) {
    this.callTargetStable = new CyclicAssumption("MethodDispatchWrapperCall_1.5332357891525667E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new MethodCallRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
