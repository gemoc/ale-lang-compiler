package logo.lang.visitor.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.LogoProgram;
import visitor.VisitorImplementation;
import visitor.operation.kmLogo.LogoProgramOperation;

public class LogoVisitorTest {
	public static void main(String[] args) {
		KmLogoPackage.eINSTANCE.eClass();

		final ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI createPlatformResourceURI = URI.createFileURI(
				"/home/manuel/dev/java/ale-lang/examples/logo.example/data/LogoProgramCompiledInterpreter.xmi");
		final Resource resource = resSet.getResource(createPlatformResourceURI, true);

		final LogoProgram model = (LogoProgram) resource.getContents().get(0);

		VisitorImplementation visitor = new VisitorImplementation();

		((LogoProgramOperation) model.accept(visitor)).eval();
	}
}
