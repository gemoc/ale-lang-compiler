package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.BooleanValue;

public class BooleanValueDispatchWrapperCopyj {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected BooleanValueDispatchWrapperCopyj(BooleanValue it) {
    this.callTargetStable = new CyclicAssumption("BooleanValueDispatchWrapperCopyj_5.014929739427773E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new BooleanValueCopyjRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
