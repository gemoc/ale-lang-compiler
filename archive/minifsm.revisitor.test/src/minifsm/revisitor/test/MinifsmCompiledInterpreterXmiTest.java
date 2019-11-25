package minifsm.revisitor.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import minifsm.interpreter.minifsm.FSM;
import minifsm.interpreter.minifsm.MinifsmPackage;


public class MinifsmCompiledInterpreterXmiTest {
	@Test
	public void test() throws Exception {
		MinifsmPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI.createPlatformPluginURI("/minifsm/model/FSM_interpreter.xmi", true);
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		final FSM model = (FSM) resource.getContents().get(0);

		model.entryPoint();
	}
}
