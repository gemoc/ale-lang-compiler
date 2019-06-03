package petrinet.lang.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.junit.Before;
import org.junit.Test;

import petrinet.interpreter.petrinet.Arc;
import petrinet.interpreter.petrinet.Petrinet;
import petrinet.interpreter.petrinet.PetrinetFactory;
import petrinet.interpreter.petrinet.Place;
import petrinet.interpreter.petrinet.Transition;


public class CompilerInterpreterTest {

	ALEInterpreter interpreter;

	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}

	@Test
	public void test1() {
		PetrinetFactory f = PetrinetFactory.eINSTANCE;
		final Petrinet petrinet = f.createPetrinet();
		int nbElements = Param.SIZE;
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

//		Dsl environment = new Dsl(Arrays.asList("model/petrinet.ecore"), Arrays.asList("model/petrinet_exec.ale"));
//		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
//				.parse(environment);
//		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		// IEvaluationResult res = interpreter.eval(model, Arrays.asList(),
		// parsedSemantics);

		long start = System.currentTimeMillis();
		petrinet.run();

		System.out.println("compiled interpreter 1 : " + (System.currentTimeMillis() - start));

		assertEquals(1,
				petrinet.getNodes().stream().filter(x -> x instanceof Place && ((Place) x).getTokenNb() == 1).count());
	}

	@Test
	public void test2() {
		PetrinetFactory f = PetrinetFactory.eINSTANCE;
		int nbElements = Param.SIZE;
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

		long start = System.currentTimeMillis();
		petrinet.run();

		System.out.println("compiled interpreter 2 : " + (System.currentTimeMillis() - start));

//		Petrinet_execImplementation rev = new Petrinet_execImplementation() {
//		};
//
//		rev.$(model).run();
//
		assertEquals(1,
				petrinet.getNodes().stream().filter(x -> x instanceof Place && ((Place) x).getTokenNb() == 1).count());
	}
}
