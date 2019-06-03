package logo.benchmark.emfswitch;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import emfswitch.emfswitch.operation.LogoProgramOperation;
import kmLogo.KmLogoPackage;
import kmLogo.LogoProgram;

public class LogoBenchmarkSwitch {
	public static void main(String[] args) {
		final String file = args[0];
		final int itt = Integer.parseInt(args[1]);

		KmLogoPackage.eINSTANCE.eClass();

		EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE);

//		LogService.MUTE = true;

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
//		final VisitorImplementation visitor = new VisitorImplementation();
		EmfswitchSwitchImplementation emfswitch = new EmfswitchSwitchImplementation();

		final long[] times = new long[itt];

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final LogoProgram result = (LogoProgram) resource.getContents().get(0);

			final long start = System.currentTimeMillis();
//			((LogoProgramOperation) result.accept(visitor)).eval();
			((LogoProgramOperation) emfswitch.caseLogoProgram(result)).eval();

			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
