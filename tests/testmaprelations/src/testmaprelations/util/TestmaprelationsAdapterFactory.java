/**
 */
package testmaprelations.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import testmaprelations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see testmaprelations.TestmaprelationsPackage
 * @generated
 */
public class TestmaprelationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestmaprelationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestmaprelationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TestmaprelationsPackage.eINSTANCE;
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
	protected TestmaprelationsSwitch<Adapter> modelSwitch =
		new TestmaprelationsSwitch<Adapter>() {
			@Override
			public Adapter caseMapCA0ToCB0MapEntry(Map.Entry<CA0, CB0> object) {
				return createMapCA0ToCB0MapEntryAdapter();
			}
			@Override
			public Adapter caseCA0(CA0 object) {
				return createCA0Adapter();
			}
			@Override
			public Adapter caseCB0(CB0 object) {
				return createCB0Adapter();
			}
			@Override
			public Adapter caseMapCA1ToCB1MapEntry(Map.Entry<EList<CA1>, EList<CB1>> object) {
				return createMapCA1ToCB1MapEntryAdapter();
			}
			@Override
			public Adapter caseCB1(CB1 object) {
				return createCB1Adapter();
			}
			@Override
			public Adapter caseCA1(CA1 object) {
				return createCA1Adapter();
			}
			@Override
			public Adapter caseCA2(CA2 object) {
				return createCA2Adapter();
			}
			@Override
			public Adapter caseCB2(CB2 object) {
				return createCB2Adapter();
			}
			@Override
			public Adapter caseMapCA2ToCB2MapEntry(Map.Entry<CA2, CB2> object) {
				return createMapCA2ToCB2MapEntryAdapter();
			}
			@Override
			public Adapter caseCB3(CB3 object) {
				return createCB3Adapter();
			}
			@Override
			public Adapter caseCA3(CA3 object) {
				return createCA3Adapter();
			}
			@Override
			public Adapter caseMapCA3ToCB3MapEntry(Map.Entry<EList<CA3>, EList<CB3>> object) {
				return createMapCA3ToCB3MapEntryAdapter();
			}
			@Override
			public Adapter caseCA4(CA4 object) {
				return createCA4Adapter();
			}
			@Override
			public Adapter caseMapCA4ToCB4MapEntry(Map.Entry<CA4, CB4> object) {
				return createMapCA4ToCB4MapEntryAdapter();
			}
			@Override
			public Adapter caseCB4(CB4 object) {
				return createCB4Adapter();
			}
			@Override
			public Adapter caseCA5(CA5 object) {
				return createCA5Adapter();
			}
			@Override
			public Adapter caseCB5(CB5 object) {
				return createCB5Adapter();
			}
			@Override
			public Adapter caseMapCA5ToCB5MapEntry(Map.Entry<EList<CA5>, EList<CB5>> object) {
				return createMapCA5ToCB5MapEntryAdapter();
			}
			@Override
			public Adapter caseMapCA6ToCB6MapEntry(Map.Entry<CA6, CB6> object) {
				return createMapCA6ToCB6MapEntryAdapter();
			}
			@Override
			public Adapter caseCA6(CA6 object) {
				return createCA6Adapter();
			}
			@Override
			public Adapter caseCB6(CB6 object) {
				return createCB6Adapter();
			}
			@Override
			public Adapter caseCA7(CA7 object) {
				return createCA7Adapter();
			}
			@Override
			public Adapter caseMapCA7ToCB7MapEntry(Map.Entry<EList<CA7>, EList<CB7>> object) {
				return createMapCA7ToCB7MapEntryAdapter();
			}
			@Override
			public Adapter caseCB7(CB7 object) {
				return createCB7Adapter();
			}
			@Override
			public Adapter caseCA8(CA8 object) {
				return createCA8Adapter();
			}
			@Override
			public Adapter caseMapCA8ToCB8MapEntry(Map.Entry<CA8, CB8> object) {
				return createMapCA8ToCB8MapEntryAdapter();
			}
			@Override
			public Adapter caseCB8(CB8 object) {
				return createCB8Adapter();
			}
			@Override
			public Adapter caseMapCA9ToCB9MapEntry(Map.Entry<EList<CA9>, EList<CB9>> object) {
				return createMapCA9ToCB9MapEntryAdapter();
			}
			@Override
			public Adapter caseCB9(CB9 object) {
				return createCB9Adapter();
			}
			@Override
			public Adapter caseCA9(CA9 object) {
				return createCA9Adapter();
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
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA0 To CB0 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA0ToCB0MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA0 <em>CA0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA0
	 * @generated
	 */
	public Adapter createCA0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB0 <em>CB0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB0
	 * @generated
	 */
	public Adapter createCB0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA1 To CB1 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA1ToCB1MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB1 <em>CB1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB1
	 * @generated
	 */
	public Adapter createCB1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA1 <em>CA1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA1
	 * @generated
	 */
	public Adapter createCA1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA2 <em>CA2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA2
	 * @generated
	 */
	public Adapter createCA2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB2 <em>CB2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB2
	 * @generated
	 */
	public Adapter createCB2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA2 To CB2 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA2ToCB2MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB3 <em>CB3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB3
	 * @generated
	 */
	public Adapter createCB3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA3 <em>CA3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA3
	 * @generated
	 */
	public Adapter createCA3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA3 To CB3 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA3ToCB3MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA4 <em>CA4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA4
	 * @generated
	 */
	public Adapter createCA4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA4 To CB4 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA4ToCB4MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB4 <em>CB4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB4
	 * @generated
	 */
	public Adapter createCB4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA5 <em>CA5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA5
	 * @generated
	 */
	public Adapter createCA5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB5 <em>CB5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB5
	 * @generated
	 */
	public Adapter createCB5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA5 To CB5 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA5ToCB5MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA6 To CB6 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA6ToCB6MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA6 <em>CA6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA6
	 * @generated
	 */
	public Adapter createCA6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB6 <em>CB6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB6
	 * @generated
	 */
	public Adapter createCB6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA7 <em>CA7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA7
	 * @generated
	 */
	public Adapter createCA7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA7 To CB7 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA7ToCB7MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB7 <em>CB7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB7
	 * @generated
	 */
	public Adapter createCB7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA8 <em>CA8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA8
	 * @generated
	 */
	public Adapter createCA8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA8 To CB8 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA8ToCB8MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB8 <em>CB8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB8
	 * @generated
	 */
	public Adapter createCB8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Map CA9 To CB9 Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createMapCA9ToCB9MapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CB9 <em>CB9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CB9
	 * @generated
	 */
	public Adapter createCB9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link testmaprelations.CA9 <em>CA9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see testmaprelations.CA9
	 * @generated
	 */
	public Adapter createCA9Adapter() {
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

} //TestmaprelationsAdapterFactory
