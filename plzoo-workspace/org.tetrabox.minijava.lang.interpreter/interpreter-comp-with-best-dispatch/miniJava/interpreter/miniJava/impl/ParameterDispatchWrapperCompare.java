package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Parameter;

public class ParameterDispatchWrapperCompare {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ParameterDispatchWrapperCompare(Parameter it) {
    this.callTargetStable = new CyclicAssumption("ParameterDispatchWrapperCompare_1.0690443357831331E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ParameterCompareRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
