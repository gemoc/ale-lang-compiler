package petrinet_exec.impl.operation.impl;

import petrinet.revisitor.PetrinetRevisitor;
import petrinet_exec.impl.operation.Arc;
import petrinet_exec.impl.operation.Node;
import petrinet_exec.impl.operation.Petrinet;
import petrinet_exec.impl.operation.Place;
import petrinet_exec.impl.operation.Transition;

public class PlaceImpl extends NodeImpl implements Place {
  private PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev;

  private petrinet.lang.petrinet.Place obj;

  public PlaceImpl(petrinet.lang.petrinet.Place obj,
      PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev) {
    super(obj, rev);
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
    result = (this.obj.getTokenNb()) > (0);
    return result;
  }

  public void fire() {
  }

  public void removeToken() {
    this.obj.setTokenNb((this.obj.getTokenNb()) - (1));
  }

  public void addToken() {
    this.obj.setTokenNb((this.obj.getTokenNb()) + (1));
  }
}
