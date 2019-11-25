/**
 */
package testbidirectionalrelation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import testbidirectionalrelation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage
 * @generated
 */
public class TestbidirectionalrelationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestbidirectionalrelationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbidirectionalrelationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TestbidirectionalrelationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestbidirectionalrelationSwitch<Adapter> modelSwitch =
		new TestbidirectionalrelationSwitch<Adapter>() {
			@Override
			public Adapter caseConceptA(ConceptA object) {
				return createConceptAAdapter();
			}
			@Override
			public Adapter caseConceptB(ConceptB object) {
				return createConceptBAdapter();
			}
			@Override
			public Adapter caseConceptC(ConceptC object) {
				return createConceptCAdapter();
			}
			@Override
			public Adapter caseConceptD(ConceptD object) {
				return createConceptDAdapter();
			}
			@Override
			public Adapter caseConceptE(ConceptE object) {
				return createConceptEAdapter();
			}
			@Override
			public Adapter caseConceptF(ConceptF object) {
				return createConceptFAdapter();
			}
			@Override
			public Adapter caseConceptG(ConceptG object) {
				return createConceptGAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptA <em>Concept A</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptA
	 * @generated
	 */
	public Adapter createConceptAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptB <em>Concept B</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptB
	 * @generated
	 */
	public Adapter createConceptBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptC <em>Concept C</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptC
	 * @generated
	 */
	public Adapter createConceptCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptD <em>Concept D</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptD
	 * @generated
	 */
	public Adapter createConceptDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptE <em>Concept E</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptE
	 * @generated
	 */
	public Adapter createConceptEAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptF <em>Concept F</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptF
	 * @generated
	 */
	public Adapter createConceptFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testbidirectionalrelation.ConceptG <em>Concept G</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testbidirectionalrelation.ConceptG
	 * @generated
	 */
	public Adapter createConceptGAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TestbidirectionalrelationAdapterFactory
