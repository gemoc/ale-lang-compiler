/**
 */
package multipleinheritence.util;

import multipleinheritence.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see multipleinheritence.MultipleinheritencePackage
 * @generated
 */
public class MultipleinheritenceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MultipleinheritencePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleinheritenceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MultipleinheritencePackage.eINSTANCE;
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
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleinheritenceSwitch<Adapter> modelSwitch = new MultipleinheritenceSwitch<Adapter>() {
		@Override
		public Adapter caseNewEClass1(NewEClass1 object) {
			return createNewEClass1Adapter();
		}

		@Override
		public Adapter caseNewEClass2(NewEClass2 object) {
			return createNewEClass2Adapter();
		}

		@Override
		public Adapter caseNewEClass3(NewEClass3 object) {
			return createNewEClass3Adapter();
		}

		@Override
		public Adapter caseNewEClass4(NewEClass4 object) {
			return createNewEClass4Adapter();
		}

		@Override
		public Adapter caseNewEClass5(NewEClass5 object) {
			return createNewEClass5Adapter();
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
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link multipleinheritence.NewEClass1 <em>New EClass1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see multipleinheritence.NewEClass1
	 * @generated
	 */
	public Adapter createNewEClass1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link multipleinheritence.NewEClass2 <em>New EClass2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see multipleinheritence.NewEClass2
	 * @generated
	 */
	public Adapter createNewEClass2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link multipleinheritence.NewEClass3 <em>New EClass3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see multipleinheritence.NewEClass3
	 * @generated
	 */
	public Adapter createNewEClass3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link multipleinheritence.NewEClass4 <em>New EClass4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see multipleinheritence.NewEClass4
	 * @generated
	 */
	public Adapter createNewEClass4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link multipleinheritence.NewEClass5 <em>New EClass5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see multipleinheritence.NewEClass5
	 * @generated
	 */
	public Adapter createNewEClass5Adapter() {
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

} //MultipleinheritenceAdapterFactory
