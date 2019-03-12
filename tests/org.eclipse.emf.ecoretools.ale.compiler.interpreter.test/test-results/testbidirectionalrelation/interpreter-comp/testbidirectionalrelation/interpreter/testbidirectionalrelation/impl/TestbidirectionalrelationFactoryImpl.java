package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import testbidirectionalrelation.*;

public class TestbidirectionalrelationFactoryImpl extends EFactoryImpl
		implements
			TestbidirectionalrelationFactory {

	public static TestbidirectionalrelationFactory init() {
		try {
			TestbidirectionalrelationFactory theTestbidirectionalrelationFactory = (TestbidirectionalrelationFactory) EPackage.Registry.INSTANCE
					.getEFactory(TestbidirectionalrelationPackage.eNS_URI);
			if (theTestbidirectionalrelationFactory != null) {
				return theTestbidirectionalrelationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestbidirectionalrelationFactoryImpl();
	}

	public TestbidirectionalrelationFactoryImpl() {
		super();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestbidirectionalrelationPackage.CONCEPT_A :
				return createConceptA();
			case TestbidirectionalrelationPackage.CONCEPT_B :
				return createConceptB();
			case TestbidirectionalrelationPackage.CONCEPT_C :
				return createConceptC();
			case TestbidirectionalrelationPackage.CONCEPT_D :
				return createConceptD();
			case TestbidirectionalrelationPackage.CONCEPT_E :
				return createConceptE();
			case TestbidirectionalrelationPackage.CONCEPT_F :
				return createConceptF();
			case TestbidirectionalrelationPackage.CONCEPT_G :
				return createConceptG();
			default :
				throw new IllegalArgumentException(
						"The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public ConceptA createConceptA() {
		ConceptAImpl conceptA = new ConceptAImpl();
		return conceptA;
	}

	public ConceptB createConceptB() {
		ConceptBImpl conceptB = new ConceptBImpl();
		return conceptB;
	}

	public ConceptC createConceptC() {
		ConceptCImpl conceptC = new ConceptCImpl();
		return conceptC;
	}

	public ConceptD createConceptD() {
		ConceptDImpl conceptD = new ConceptDImpl();
		return conceptD;
	}

	public ConceptE createConceptE() {
		ConceptEImpl conceptE = new ConceptEImpl();
		return conceptE;
	}

	public ConceptF createConceptF() {
		ConceptFImpl conceptF = new ConceptFImpl();
		return conceptF;
	}

	public ConceptG createConceptG() {
		ConceptGImpl conceptG = new ConceptGImpl();
		return conceptG;
	}

	public TestbidirectionalrelationPackage getTestbidirectionalrelationPackage() {
		return (TestbidirectionalrelationPackage) getEPackage();
	}

	@Deprecated
	public static TestbidirectionalrelationPackage getPackage() {
		return TestbidirectionalrelationPackage.eINSTANCE;
	}
}
