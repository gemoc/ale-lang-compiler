package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import truffle.petrinet.interpreter.petrinet.Node;

public class NodeDispatchWrapperFire {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected NodeDispatchWrapperFire(Node it) {
    this.callTargetStable = new CyclicAssumption("NodeDispatchWrapperFire_3.3736549015165746E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new NodeFireRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
