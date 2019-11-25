package petrinet.benchmark.interpreter;

import petrinet.interpreter.petrinet.Arc;
import petrinet.interpreter.petrinet.Petrinet;
import petrinet.interpreter.petrinet.PetrinetFactory;
import petrinet.interpreter.petrinet.Place;
import petrinet.interpreter.petrinet.Transition;

public class ModelFactory {
	private static final PetrinetFactory f = PetrinetFactory.eINSTANCE;

	public static Petrinet chainOfOne(final int nbElements) {
		final Petrinet petrinet = f.createPetrinet();

		Place p0 = f.createPlace();
		p0.setName("p0");
		p0.setTokenNb(1);
		petrinet.getNodes().add(p0);

		for (int i = 0; i < nbElements; i++) {
			final Transition t = f.createTransition();
			t.setName("t" + i);
			petrinet.getNodes().add(t);

			final Arc a = f.createArc();
			a.setSource(p0);
			a.setTarget(t);
			petrinet.getArcs().add(a);

			final Place p1 = f.createPlace();
			p1.setTokenNb(0);
			p1.setName("p" + (i + 1));
			petrinet.getNodes().add(p1);

			final Arc a1 = f.createArc();
			a1.setSource(t);
			a1.setTarget(p1);
			petrinet.getArcs().add(a1);

			p0 = p1;
		}

		return petrinet;
	}

	public static Petrinet manyToOne(final int nbElements) {
		final Petrinet petrinet = f.createPetrinet();

		final Transition t0 = f.createTransition();
		t0.setName("t0");
		for (int i = 0; i < nbElements; i++) {
			final Place p1 = f.createPlace();
			p1.setName("p" + (i + 1));
			p1.setTokenNb(1);
			final Arc a0 = f.createArc();
			a0.setSource(p1);
			a0.setTarget(t0);
			petrinet.getNodes().add(p1);
			petrinet.getArcs().add(a0);
		}

		final Place p3 = f.createPlace();
		p3.setName("p3");

		final Arc a2 = f.createArc();
		a2.setSource(t0);
		a2.setTarget(p3);

		petrinet.getNodes().add(p3);
		petrinet.getNodes().add(t0);

		petrinet.getArcs().add(a2);
		return petrinet;
	}
}
