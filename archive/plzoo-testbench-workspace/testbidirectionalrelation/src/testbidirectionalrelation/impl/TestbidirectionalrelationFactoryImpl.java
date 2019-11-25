/**
 */
package testbidirectionalrelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import testbidirectionalrelation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestbidirectionalrelationFactoryImpl extends EFactoryImpl implements TestbidirectionalrelationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestbidirectionalrelationFactory init() {
		try {
			TestbidirectionalrelationFactory theTestbidirectionalrelationFactory = (TestbidirectionalrelationFactory)EPackage.Registry.INSTANCE.getEFactory(TestbidirectionalrelationPackage.eNS_URI);
			if (theTestbidirectionalrelationFactory != null) {
				return theTestbidirectionalrelationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestbidirectionalrelationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbidirectionalrelationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestbidirectionalrelationPackage.CONCEPT_A: return createConceptA();
			case TestbidirectionalrelationPackage.CONCEPT_B: return createConceptB();
			case TestbidirectionalrelationPackage.CONCEPT_C: return createConceptC();
			case TestbidirectionalrelationPackage.CONCEPT_D: return createConceptD();
			case TestbidirectionalrelationPackage.CONCEPT_E: return createConceptE();
			case TestbidirectionalrelationPackage.CONCEPT_F: return createConceptF();
			case TestbidirectionalrelationPackage.CONCEPT_G: return createConceptG();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA createConceptA() {
		ConceptAImpl conceptA = new ConceptAImpl();
		return conceptA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB createConceptB() {
		ConceptBImpl conceptB = new ConceptBImpl();
		return conceptB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptC createConceptC() {
		ConceptCImpl conceptC = new ConceptCImpl();
		return conceptC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptD createConceptD() {
		ConceptDImpl conceptD = new ConceptDImpl();
		return conceptD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptE createConceptE() {
		ConceptEImpl conceptE = new ConceptEImpl();
		return conceptE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptF createConceptF() {
		ConceptFImpl conceptF = new ConceptFImpl();
		return conceptF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptG createConceptG() {
		ConceptGImpl conceptG = new ConceptGImpl();
		return conceptG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbidirectionalrelationPackage getTestbidirectionalrelationPackage() {
		return (TestbidirectionalrelationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestbidirectionalrelationPackage getPackage() {
		return TestbidirectionalrelationPackage.eINSTANCE;
	}

} //TestbidirectionalrelationFactoryImpl
