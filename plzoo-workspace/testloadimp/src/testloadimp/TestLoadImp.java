package testloadimp;

import imp.model.imp.ImpFactory;
import imp.model.imp.ImpPackage;
import imp.model.imp.IntValue;
import imp.model.imp.Stmt;
import imp.model.imp.Store;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class TestLoadImp {
	public static void main(String[] args) {
		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		for (int i = 0; i < 10; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI("ittfib.imp.xmi");
			final Resource resource = resSet.getResource(createFileURI, true);
			final Stmt result = (Stmt) resource.getContents().get(0);

			Store createStore = ImpFactory.eINSTANCE.createStore();
			IntValue createIntValue = ImpFactory.eINSTANCE.createIntValue();
			createIntValue.setValue(i + 1);
			createStore.getValues().put("n", createIntValue);

			System.out.println((i + 1) + " -> " + null);
		}
	}
}
