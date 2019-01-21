package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.BooleanValue;

public class BooleanValueDispatchWrapperCustomToString extends ValueDispatchWrapperCustomToString {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected BooleanValueDispatchWrapperCustomToString(BooleanValue it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("BooleanValueDispatchWrapperCustomToString_4.4189824546024494E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new BooleanValueCustomToStringRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
