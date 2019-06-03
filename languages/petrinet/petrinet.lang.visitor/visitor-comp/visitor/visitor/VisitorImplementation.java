package visitor.visitor;

import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.petrinet.visitor.petrinet.Place;
import visitor.petrinet.visitor.petrinet.Transition;
import visitor.visitor.operation.petrinet.ArcOperation;
import visitor.visitor.operation.petrinet.PetrinetOperation;
import visitor.visitor.operation.petrinet.PlaceOperation;
import visitor.visitor.operation.petrinet.TransitionOperation;
import visitor.visitor.operation.petrinet.impl.ArcOperationImpl;
import visitor.visitor.operation.petrinet.impl.PetrinetOperationImpl;
import visitor.visitor.operation.petrinet.impl.PlaceOperationImpl;
import visitor.visitor.operation.petrinet.impl.TransitionOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public PetrinetOperation visitpetrinet__Petrinet(Petrinet it) {
		return new PetrinetOperationImpl(it, this);
	}

	public ArcOperation visitpetrinet__Arc(Arc it) {
		return new ArcOperationImpl(it, this);
	}

	public TransitionOperation visitpetrinet__Transition(Transition it) {
		return new TransitionOperationImpl(it, this);
	}

	public PlaceOperation visitpetrinet__Place(Place it) {
		return new PlaceOperationImpl(it, this);
	}
}
