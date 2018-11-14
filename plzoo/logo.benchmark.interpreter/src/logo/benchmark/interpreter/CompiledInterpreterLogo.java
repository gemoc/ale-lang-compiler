package logo.benchmark.interpreter;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.LogoProgram;

public class LogoInterpreterBenchmarjk {
	public static void main(String[] args) {

		LogService.MUTE = true;
		final int SIZE = 100;
		final long[] times = new long[SIZE];
		for (int i = 0; i < SIZE; i++) {
			KmLogoPackage.eINSTANCE.eClass();

			final ResourceSet resSet = new ResourceSetImpl();
			resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

			URI createPlatformResourceURI = URI.createFileURI(
					"/home/manuel/dev/java/ale-lang/examples/logo.example/data/LogoProgramCompiledInterpreter.xmi");
			final Resource resource = resSet.getResource(createPlatformResourceURI, true);

			final LogoProgram model = (LogoProgram) resource.getContents().get(0);

			long start = System.currentTimeMillis();
			model.eval();
			times[i] = System.currentTimeMillis() - start;

		}

		System.out.println(Arrays.toString(times));
	}
}
