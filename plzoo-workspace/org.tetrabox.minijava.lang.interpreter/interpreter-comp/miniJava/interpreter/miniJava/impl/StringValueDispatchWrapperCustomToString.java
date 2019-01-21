package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.StringValue;

public class StringValueDispatchWrapperCustomToString extends ValueDispatchWrapperCustomToString {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected StringValueDispatchWrapperCustomToString(StringValue it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("StringValueDispatchWrapperCustomToString_7.087884573149094E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new StringValueCustomToStringRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
