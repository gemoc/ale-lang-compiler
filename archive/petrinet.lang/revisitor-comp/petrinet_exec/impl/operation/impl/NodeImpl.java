package petrinet_exec.impl.operation.impl;

import petrinet.revisitor.PetrinetRevisitor;
import petrinet_exec.impl.operation.Arc;
import petrinet_exec.impl.operation.Node;
import petrinet_exec.impl.operation.Petrinet;
import petrinet_exec.impl.operation.Place;
import petrinet_exec.impl.operation.Transition;

public class NodeImpl implements Node {
  private PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev;

  private petrinet.lang.petrinet.Node obj;

  public NodeImpl(petrinet.lang.petrinet.Node obj,
      PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public boolean canFire() {
    boolean result;
    result = false;
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
    return result;
  }

  public void fire() {
  }

  public void removeToken() {
  }

  public void addToken() {
  }
}
