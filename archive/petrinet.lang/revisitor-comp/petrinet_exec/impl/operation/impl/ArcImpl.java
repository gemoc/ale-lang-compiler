package petrinet_exec.impl.operation.impl;

import petrinet.revisitor.PetrinetRevisitor;
import petrinet_exec.impl.operation.Arc;
import petrinet_exec.impl.operation.Node;
import petrinet_exec.impl.operation.Petrinet;
import petrinet_exec.impl.operation.Place;
import petrinet_exec.impl.operation.Transition;

public class ArcImpl implements Arc {
  private PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev;

  private petrinet.lang.petrinet.Arc obj;

  public ArcImpl(petrinet.lang.petrinet.Arc obj,
      PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public boolean canFire() {
    boolean result;
    result = rev.$(this.obj.getSource()).hasToken();
    return result;
  }

  public void removeToken() {
    rev.$(this.obj.getSource()).removeToken();
  }

  public void addToken() {
    rev.$(this.obj.getTarget()).addToken();
  }
}
