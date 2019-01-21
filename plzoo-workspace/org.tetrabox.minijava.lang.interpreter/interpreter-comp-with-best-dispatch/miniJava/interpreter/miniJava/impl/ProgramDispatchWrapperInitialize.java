package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.Program;

public class ProgramDispatchWrapperInitialize {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ProgramDispatchWrapperInitialize(Program it) {
    this.callTargetStable = new CyclicAssumption("ProgramDispatchWrapperInitialize_3.047653635830351E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ProgramInitializeRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
