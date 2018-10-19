package petrinet_exec.impl.operation.impl;

import petrinet.revisitor.PetrinetRevisitor;
import petrinet_exec.impl.operation.Arc;
import petrinet_exec.impl.operation.Node;
import petrinet_exec.impl.operation.Petrinet;
import petrinet_exec.impl.operation.Place;
import petrinet_exec.impl.operation.Transition;

public class TransitionImpl implements Transition {
  private PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev;

  private petrinet.lang.petrinet.Transition obj;

  public TransitionImpl(petrinet.lang.petrinet.Transition obj,
      PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public boolean canFire() {
    boolean result;
    result = !(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.obj.getIncomming(), (it) -> rev.$(it).canFire())));
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
    return result;
  }

  public void fire() {
    for(petrinet.lang.petrinet.Arc it: this.obj.getIncomming()) {
      rev.$(it).removeToken();
    }
    for(petrinet.lang.petrinet.Arc it: this.obj.getOutgoing()) {
      rev.$(it).addToken();
    }
  }

  public void removeToken() {
  }

  public void addToken() {
  }
}
