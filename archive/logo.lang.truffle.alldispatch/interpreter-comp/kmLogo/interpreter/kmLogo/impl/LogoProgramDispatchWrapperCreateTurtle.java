package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.LogoProgram;

public class LogoProgramDispatchWrapperCreateTurtle {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected LogoProgramDispatchWrapperCreateTurtle(LogoProgram it) {
    this.callTargetStable = new CyclicAssumption("LogoProgramDispatchWrapperCreateTurtle_2.14537692272928E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new LogoProgramCreateTurtleRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
