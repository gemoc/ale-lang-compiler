package minifsm.revisitor.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import MiniFsm.impl.MiniFsmImplementation;
import minifsm.FSM;
import minifsm.MinifsmPackage;

public class MinifsmCompiledRevisitorTest {
	@Test
	public void test() throws Exception {
		MinifsmPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI.createPlatformPluginURI("/minifsm/model/FSM.xmi", true);
//		URI createPlatformResourceURI = URI.createFileURI("/home/manuel/dev/java/ale-lang/examples/minifsm/model/FSM.xmi");
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		final FSM model = (FSM) resource.getContents().get(0);

		new MiniFsmImplementation() {
		}.$(model).entryPoint();
	}
}
