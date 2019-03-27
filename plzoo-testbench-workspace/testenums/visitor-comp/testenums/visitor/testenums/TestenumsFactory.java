package testenums.visitor.testenums;

import org.eclipse.emf.ecore.EFactory;
import testenums.visitor.testenums.impl.TestenumsFactoryImpl;

public interface TestenumsFactory extends EFactory {
	TestenumsFactory eINSTANCE = TestenumsFactoryImpl.init();

	Root createRoot();

	TestenumsPackage getTestenumsPackage();
}
