package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.ecore.EFactory;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.impl.TestbidirectionalrelationFactoryImpl;

public interface TestbidirectionalrelationFactory extends EFactory {
	TestbidirectionalrelationFactory eINSTANCE = TestbidirectionalrelationFactoryImpl.init();

	ConceptA createConceptA();

	ConceptB createConceptB();

	ConceptC createConceptC();

	ConceptD createConceptD();

	ConceptE createConceptE();

	ConceptF createConceptF();

	ConceptG createConceptG();

	TestbidirectionalrelationPackage getTestbidirectionalrelationPackage();
}
