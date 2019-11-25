package boa.benchmark.emfswitch;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import boa.BoaPackage;
import boa.File;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import emfswitch.emfswitch.operation.FileOperation;

public class BoaBenchmarkSwitch {
	public static void main(final String[] args) {
		final String file = args[0];
		final int itt = Integer.parseInt(args[1]);

		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		EmfswitchSwitchImplementation emfswitch = new EmfswitchSwitchImplementation() {
		};
		final long[] times = new long[itt];

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final File result = (File) resource.getContents().get(0);

			final long start = System.currentTimeMillis();
			((FileOperation) emfswitch.doSwitch(result)).eval();

			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
