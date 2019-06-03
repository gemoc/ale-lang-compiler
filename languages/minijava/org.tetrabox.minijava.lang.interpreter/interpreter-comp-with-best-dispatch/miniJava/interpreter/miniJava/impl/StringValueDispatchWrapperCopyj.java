package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.StringValue;

public class StringValueDispatchWrapperCopyj {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected StringValueDispatchWrapperCopyj(StringValue it) {
    this.callTargetStable = new CyclicAssumption("StringValueDispatchWrapperCopyj_4.286411889511382E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new StringValueCopyjRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
