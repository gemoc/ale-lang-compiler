package petrinet.model;

import petrinet.model.petrinet.Arc;
import petrinet.model.petrinet.Petrinet;
import petrinet.model.petrinet.PetrinetFactory;
import petrinet.model.petrinet.Place;
import petrinet.model.petrinet.Transition;

public class MainTmp {
	public static void main(final String[] args) {
		final PetrinetFactory f = PetrinetFactory.eINSTANCE;
		final Petrinet petrinet = f.createPetrinet();

		final Place p1 = f.createPlace();
		p1.setName("p1");

		final Place p2 = f.createPlace();
		p2.setName("p2");

		final Place p3 = f.createPlace();
		p3.setName("p3");

		final Transition t0 = f.createTransition();
		t0.setName("t0");

		final Arc a0 = f.createArc();
		a0.setSource(p1);
		a0.setTarget(t0);

		final Arc a1 = f.createArc();
		a1.setSource(p2);
		a1.setTarget(t0);

		final Arc a2 = f.createArc();
		a2.setSource(t0);
		a2.setTarget(p3);

		petrinet.getNodes().add(p1);
		petrinet.getNodes().add(p2);
		petrinet.getNodes().add(p3);
		petrinet.getNodes().add(t0);

		petrinet.getArcs().add(a0);
		petrinet.getArcs().add(a1);
		petrinet.getArcs().add(a2);

		System.out.println(petrinet);
	}
}
