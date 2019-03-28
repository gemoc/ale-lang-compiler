
package testoperationbody;

import org.eclipse.emf.ecore.EFactory;


public interface TestoperationbodyFactory extends EFactory {
	
	TestoperationbodyFactory eINSTANCE = testoperationbody.impl.TestoperationbodyFactoryImpl.init();

	
	Main createMain();

	
	ConceptA createConceptA();

	
	ChildA createChildA();

	
	ChildB createChildB();

	
	TestoperationbodyPackage getTestoperationbodyPackage();

} //TestoperationbodyFactory
