package petrinet.revisitor;

public interface PetrinetRevisitor<Petrinet__ArcT, Petrinet__NodeT, Petrinet__PetrinetT, Petrinet__PlaceT extends Petrinet__NodeT, Petrinet__TransitionT extends Petrinet__NodeT> {
	Petrinet__ArcT petrinet__Arc(final petrinet.lang.petrinet.Arc it);
	Petrinet__PetrinetT petrinet__Petrinet(final petrinet.lang.petrinet.Petrinet it);
	Petrinet__PlaceT petrinet__Place(final petrinet.lang.petrinet.Place it);
	Petrinet__TransitionT petrinet__Transition(final petrinet.lang.petrinet.Transition it);

	default Petrinet__ArcT $(final petrinet.lang.petrinet.Arc it) {
		return petrinet__Arc(it);
	}
	default Petrinet__NodeT $(final petrinet.lang.petrinet.Node it) {
		if (it.getClass() == petrinet.lang.petrinet.impl.PlaceImpl.class)
			return petrinet__Place((petrinet.lang.petrinet.Place) it);
		if (it.getClass() == petrinet.lang.petrinet.impl.TransitionImpl.class)
			return petrinet__Transition((petrinet.lang.petrinet.Transition) it);
		return null;
	}
	default Petrinet__PetrinetT $(final petrinet.lang.petrinet.Petrinet it) {
		return petrinet__Petrinet(it);
	}
	default Petrinet__PlaceT $(final petrinet.lang.petrinet.Place it) {
		return petrinet__Place(it);
	}
	default Petrinet__TransitionT $(final petrinet.lang.petrinet.Transition it) {
		return petrinet__Transition(it);
	}
}
