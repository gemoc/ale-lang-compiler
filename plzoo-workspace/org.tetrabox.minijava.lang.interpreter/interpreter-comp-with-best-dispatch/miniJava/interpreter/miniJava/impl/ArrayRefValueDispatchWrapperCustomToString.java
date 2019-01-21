package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.ArrayRefValue;

public class ArrayRefValueDispatchWrapperCustomToString extends ValueDispatchWrapperCustomToString {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ArrayRefValueDispatchWrapperCustomToString(ArrayRefValue it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ArrayRefValueDispatchWrapperCustomToString_5.035973312990709E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ArrayRefValueCustomToStringRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
