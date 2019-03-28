package testoperationbody.interpreter.testoperationbody;

import org.eclipse.emf.ecore.EFactory;
import testoperationbody.interpreter.testoperationbody.impl.TestoperationbodyFactoryImpl;

public interface TestoperationbodyFactory extends EFactory {
	TestoperationbodyFactory eINSTANCE = TestoperationbodyFactoryImpl.init();

	Main createMain();

	ConceptA createConceptA();

	ChildA createChildA();

	ChildB createChildB();

	TestoperationbodyPackage getTestoperationbodyPackage();
}
