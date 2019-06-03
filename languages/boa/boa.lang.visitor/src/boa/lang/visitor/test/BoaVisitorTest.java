package boa.lang.visitor.test;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.File;
import visitor.VisitorImplementation;
import visitor.operation.boa.FileOperation;

public class BoaVisitorTest {
	public static void main(String[] args) {
		BoaPackage.eINSTANCE.eClass();

		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		final ResourceSetImpl resSet = new ResourceSetImpl();
		final URI createFileURI = URI.createFileURI("/home/manuel/runtime-ale-lang/boa.benchmark/fib2.xmi");
		final Resource resource = resSet.getResource(createFileURI, true);
		final File result = (File) resource.getContents().get(0);

		VisitorImplementation visitor = new VisitorImplementation();
		((FileOperation) result.accept(visitor)).eval();

	}
}
