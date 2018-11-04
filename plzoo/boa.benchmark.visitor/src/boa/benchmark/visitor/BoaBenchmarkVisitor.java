package boa.benchmark.visitor;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.File;
import visitor.visitor.VisitorImplementation;
import visitor.visitor.operation.boa.FileOperation;

public class BoaBenchmarkVisitor {
	public static void main(final String[] args) {
		final String file = args[0];
		final int itt = Integer.parseInt(args[1]);

		BoaPackage.eINSTANCE.eClass();

		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		final VisitorImplementation visitor = new VisitorImplementation();

		final long[] times = new long[itt];

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final File result = (File) resource.getContents().get(0);

			final long start = System.currentTimeMillis();
			((FileOperation) result.accept(visitor)).eval();

			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
