
package testenums;

import org.eclipse.emf.ecore.EFactory;


public interface TestenumsFactory extends EFactory {
	
	TestenumsFactory eINSTANCE = testenums.impl.TestenumsFactoryImpl.init();

	
	Root createRoot();

	
	TestenumsPackage getTestenumsPackage();

} //TestenumsFactory
