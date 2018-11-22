package boa.benchmark;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

import boa.BoaPackage;
import boa.File;

public class ALEInterpreterBoaFib {
	public static void main(final String[] args) throws IOException {
		BoaPackage.eINSTANCE.eClass();

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		final int SIZE = 2000;
		final long[] times = new long[SIZE];
		for (int i = 0; i < SIZE; i++) {
			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI("/home/manuel/runtime-ale-lang/boa.benchmark/fib2.xmi");
			final Resource resource = resSet.getResource(createFileURI, true);
			final File result = (File) resource.getContents().get(0);
			Dsl environment = new Dsl(Arrays.asList("/home/manuel/runtime-ale-lang/petrinet.lang/model/petrinet.ecore"),
					Arrays.asList("/home/manuel/runtime-ale-lang/petrinet.lang/src/petrinet_exec.ale"));
			List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(new ALEInterpreter().getQueryEnvironment()))
					.parse(environment);

			final long start = System.currentTimeMillis();
			IEvaluationResult res = new ALEInterpreter().eval(result, Arrays.asList(), parsedSemantics);
			times[i] = System.currentTimeMillis() - start;
		}

		System.out.println(Arrays.toString(times));
	}
}
