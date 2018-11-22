package minifsm.revisitor.test;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

import minifsm.FSM;
import minifsm.MinifsmPackage;

public class MinifsmInterpreterTest {
	ALEInterpreter interpreter;

	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}

	@Test
	public void test() {
		MinifsmPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI
				.createFileURI("/home/manuel/dev/java/ale-lang/examples/minifsm/model/FSM.xmi");
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

//		Dsl environment = new Dsl(Arrays.asList("/home/manuel/dev/java/ale-lang/examples/minifsm/model/MiniFsm.ecore"),
//				Arrays.asList("/home/manuel/dev/java/ale-lang/examples/minifsm/model/MiniFsm.ale"));
		Dsl environment = new Dsl(
				Arrays.asList("file:///home/manuel/dev/java/ale-lang/examples/minifsm/model/MiniFsm.ecore"),
				Arrays.asList("file:///home/manuel/dev/java/ale-lang/examples/minifsm/model/MiniFsm.ale"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		FSM model = (FSM) resource.getContents().get(0);

		long start = System.currentTimeMillis();
		IEvaluationResult res = interpreter.eval(model, Arrays.asList(), parsedSemantics);
		System.out.println("interpreter 1 : " + (System.currentTimeMillis() - start));

	}
}
