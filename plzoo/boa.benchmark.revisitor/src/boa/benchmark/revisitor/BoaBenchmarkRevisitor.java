package boa.benchmark.revisitor;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import boa.BoaPackage;
import boa.File;
import boa_exec.impl.Boa_execImplementation;

public class BoaBenchmarkRevisitor {
	public static void main(final String[] args) {
		final String file = args[0];
		final int itt = Integer.parseInt(args[1]);

		BoaPackage.eINSTANCE.eClass();

		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		final long[] times = new long[itt];

		final Boa_execImplementation visitor = new Boa_execImplementation() {
		};

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final File result = (File) resource.getContents().get(0);

			final long start = System.currentTimeMillis();
			visitor.$(result).eval();
			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
