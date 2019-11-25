package logo.revisitor.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import LogoProgram_revisitor.impl.operation.LogoProgram;
import kmLogo.KmLogoPackage;

public class TestCompiledInterpreterLogo {

	@Test
	public void testLogoProgram() throws Exception {
		KmLogoPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI
				.createPlatformPluginURI("/logo.example/data/LogoProgramCompiledInterpreter.xmi", true);
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		final LogoProgram model = (LogoProgram) resource.getContents().get(0);

		model.eval();
	}
}
