package petrinet_exec.impl;

import petrinet.revisitor.PetrinetRevisitor;
import petrinet_exec.impl.operation.Arc;
import petrinet_exec.impl.operation.Node;
import petrinet_exec.impl.operation.Petrinet;
import petrinet_exec.impl.operation.Place;
import petrinet_exec.impl.operation.Transition;
import petrinet_exec.impl.operation.impl.ArcImpl;
import petrinet_exec.impl.operation.impl.NodeImpl;
import petrinet_exec.impl.operation.impl.PetrinetImpl;
import petrinet_exec.impl.operation.impl.PlaceImpl;
import petrinet_exec.impl.operation.impl.TransitionImpl;

public interface Petrinet_execImplementation extends PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> {
  default Petrinet petrinet__Petrinet(petrinet.lang.petrinet.Petrinet it) {
    return new PetrinetImpl(it, this);
  }

  default Node petrinet__Node(petrinet.lang.petrinet.Node it) {
    return new NodeImpl(it, this);
  }

  default Arc petrinet__Arc(petrinet.lang.petrinet.Arc it) {
    return new ArcImpl(it, this);
  }

  default Transition petrinet__Transition(petrinet.lang.petrinet.Transition it) {
    return new TransitionImpl(it, this);
  }

  default Place petrinet__Place(petrinet.lang.petrinet.Place it) {
    return new PlaceImpl(it, this);
  }
}
