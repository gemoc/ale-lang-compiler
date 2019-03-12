package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.ecore.EFactory;

public interface TestbidirectionalrelationFactory extends EFactory {

	TestbidirectionalrelationFactory eINSTANCE = testbidirectionalrelation.impl.TestbidirectionalrelationFactoryImpl
			.init();

	ConceptA createConceptA();

	ConceptB createConceptB();

	ConceptC createConceptC();

	ConceptD createConceptD();

	ConceptE createConceptE();

	ConceptF createConceptF();

	ConceptG createConceptG();

	TestbidirectionalrelationPackage getTestbidirectionalrelationPackage();

}