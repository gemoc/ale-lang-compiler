package petrinet.lang.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

import petrinet.lang.petrinet.Petrinet;
import petrinet.lang.petrinet.Place;

public class InterpreterTest {

	ALEInterpreter interpreter;

	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}

	@Test
	public void test1() {
		Petrinet model = ModelFactory.chainOfOne(Param.SIZE);

		Dsl environment = new Dsl(Arrays.asList("/home/manuel/runtime-ale-lang/petrinet.lang/model/petrinet.ecore"),
				Arrays.asList("/home/manuel/runtime-ale-lang/petrinet.lang/src/petrinet_exec.ale"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);

		long start = System.currentTimeMillis();
		IEvaluationResult res = interpreter.eval(model, Arrays.asList(), parsedSemantics);
		System.out.println("interpreter 1 : " + (System.currentTimeMillis() - start));
		assertEquals(1,
				model.getNodes().stream().filter(x -> x instanceof Place && ((Place) x).getTokenNb() == 1).count());
	}

	@Test
	public void test2() {
		Petrinet model = ModelFactory.manyToOne(Param.SIZE);

		Dsl environment = new Dsl(Arrays.asList("/home/manuel/runtime-ale-lang/petrinet.lang/model/petrinet.ecore"),
				Arrays.asList("/home/manuel/runtime-ale-lang/petrinet.lang/src/petrinet_exec.ale"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
//		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		long start = System.currentTimeMillis();
		IEvaluationResult res = interpreter.eval(model, Arrays.asList(), parsedSemantics);
		System.out.println("interpreter 2 : " + (System.currentTimeMillis() - start));

		assertEquals(1,
				model.getNodes().stream().filter(x -> x instanceof Place && ((Place) x).getTokenNb() == 1).count());
	}
}
