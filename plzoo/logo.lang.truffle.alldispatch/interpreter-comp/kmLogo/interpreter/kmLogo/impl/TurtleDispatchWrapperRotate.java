package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Turtle;

public class TurtleDispatchWrapperRotate {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected TurtleDispatchWrapperRotate(Turtle it) {
    this.callTargetStable = new CyclicAssumption("TurtleDispatchWrapperRotate_7.591402908879836E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new TurtleRotateRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
