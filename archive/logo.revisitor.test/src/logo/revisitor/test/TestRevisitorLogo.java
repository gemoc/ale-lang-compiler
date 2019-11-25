package logo.revisitor.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import LogoProgram_revisitor.impl.LogoProgram_revisitorImplementation;
import kmLogo.KmLogoPackage;
import kmLogo.LogoProgram;

public class TestRevisitorLogo {

	@Test
	public void testLogoProgram() throws Exception {
		KmLogoPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI.createPlatformPluginURI("/logo.example/data/LogoProgram.xmi", true);
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		final LogoProgram model = (LogoProgram) resource.getContents().get(0);

		LogoProgram_revisitorImplementation logoProgramImplementation = new LogoProgram_revisitorImplementation() {
		};
		logoProgramImplementation.$(model).eval();

		System.out.println("yolo");
	}
}
