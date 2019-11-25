/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.util;

import fr.mleduc.xp.emfrelations.emfrelations.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage
 * @generated
 */
public class EmfrelationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmfrelationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfrelationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EmfrelationsPackage.eINSTANCE;
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
	protected EmfrelationsSwitch<Adapter> modelSwitch =
		new EmfrelationsSwitch<Adapter>() {
			@Override
			public Adapter caseConceptA0(ConceptA0 object) {
				return createConceptA0Adapter();
			}
			@Override
			public Adapter caseConceptB0(ConceptB0 object) {
				return createConceptB0Adapter();
			}
			@Override
			public Adapter caseConceptA1(ConceptA1 object) {
				return createConceptA1Adapter();
			}
			@Override
			public Adapter caseConceptB1(ConceptB1 object) {
				return createConceptB1Adapter();
			}
			@Override
			public Adapter caseConceptA2(ConceptA2 object) {
				return createConceptA2Adapter();
			}
			@Override
			public Adapter caseConceptB2(ConceptB2 object) {
				return createConceptB2Adapter();
			}
			@Override
			public Adapter caseConceptA3(ConceptA3 object) {
				return createConceptA3Adapter();
			}
			@Override
			public Adapter caseConceptB3(ConceptB3 object) {
				return createConceptB3Adapter();
			}
			@Override
			public Adapter caseConceptA4(ConceptA4 object) {
				return createConceptA4Adapter();
			}
			@Override
			public Adapter caseConceptB4(ConceptB4 object) {
				return createConceptB4Adapter();
			}
			@Override
			public Adapter caseConceptA5(ConceptA5 object) {
				return createConceptA5Adapter();
			}
			@Override
			public Adapter caseConceptB5(ConceptB5 object) {
				return createConceptB5Adapter();
			}
			@Override
			public Adapter caseConceptA8(ConceptA8 object) {
				return createConceptA8Adapter();
			}
			@Override
			public Adapter caseConceptB8(ConceptB8 object) {
				return createConceptB8Adapter();
			}
			@Override
			public Adapter caseConceptA9(ConceptA9 object) {
				return createConceptA9Adapter();
			}
			@Override
			public Adapter caseConceptB9(ConceptB9 object) {
				return createConceptB9Adapter();
			}
			@Override
			public Adapter caseConceptA10(ConceptA10 object) {
				return createConceptA10Adapter();
			}
			@Override
			public Adapter caseConceptB10(ConceptB10 object) {
				return createConceptB10Adapter();
			}
			@Override
			public Adapter caseConceptA11(ConceptA11 object) {
				return createConceptA11Adapter();
			}
			@Override
			public Adapter caseConceptB11(ConceptB11 object) {
				return createConceptB11Adapter();
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
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA0 <em>Concept A0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA0
	 * @generated
	 */
	public Adapter createConceptA0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB0 <em>Concept B0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB0
	 * @generated
	 */
	public Adapter createConceptB0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA1 <em>Concept A1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA1
	 * @generated
	 */
	public Adapter createConceptA1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB1 <em>Concept B1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB1
	 * @generated
	 */
	public Adapter createConceptB1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA2 <em>Concept A2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA2
	 * @generated
	 */
	public Adapter createConceptA2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB2 <em>Concept B2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB2
	 * @generated
	 */
	public Adapter createConceptB2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA3 <em>Concept A3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA3
	 * @generated
	 */
	public Adapter createConceptA3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB3 <em>Concept B3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB3
	 * @generated
	 */
	public Adapter createConceptB3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA4 <em>Concept A4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA4
	 * @generated
	 */
	public Adapter createConceptA4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB4 <em>Concept B4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB4
	 * @generated
	 */
	public Adapter createConceptB4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA5 <em>Concept A5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA5
	 * @generated
	 */
	public Adapter createConceptA5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB5 <em>Concept B5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB5
	 * @generated
	 */
	public Adapter createConceptB5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA8 <em>Concept A8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA8
	 * @generated
	 */
	public Adapter createConceptA8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB8 <em>Concept B8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB8
	 * @generated
	 */
	public Adapter createConceptB8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA9 <em>Concept A9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA9
	 * @generated
	 */
	public Adapter createConceptA9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB9 <em>Concept B9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB9
	 * @generated
	 */
	public Adapter createConceptB9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA10 <em>Concept A10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA10
	 * @generated
	 */
	public Adapter createConceptA10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB10 <em>Concept B10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB10
	 * @generated
	 */
	public Adapter createConceptB10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA11 <em>Concept A11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA11
	 * @generated
	 */
	public Adapter createConceptA11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB11 <em>Concept B11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB11
	 * @generated
	 */
	public Adapter createConceptB11Adapter() {
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

} //EmfrelationsAdapterFactory
