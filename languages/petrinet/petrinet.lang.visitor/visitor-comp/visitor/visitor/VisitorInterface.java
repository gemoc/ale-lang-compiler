package visitor.visitor;

import java.lang.Object;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.petrinet.visitor.petrinet.Place;
import visitor.petrinet.visitor.petrinet.Transition;

public interface VisitorInterface {
	Object visitpetrinet__Petrinet(Petrinet it);

	Object visitpetrinet__Arc(Arc it);

	Object visitpetrinet__Transition(Transition it);

	Object visitpetrinet__Place(Place it);
}
