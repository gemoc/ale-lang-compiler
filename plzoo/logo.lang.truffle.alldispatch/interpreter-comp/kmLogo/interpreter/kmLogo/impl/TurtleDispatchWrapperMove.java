package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Turtle;

public class TurtleDispatchWrapperMove {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected TurtleDispatchWrapperMove(Turtle it) {
    this.callTargetStable = new CyclicAssumption("TurtleDispatchWrapperMove_6.2455789116363846E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new TurtleMoveRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
