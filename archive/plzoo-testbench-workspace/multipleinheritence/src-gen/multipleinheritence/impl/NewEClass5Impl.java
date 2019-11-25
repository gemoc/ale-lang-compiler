/**
 */
package multipleinheritence.impl;

import multipleinheritence.MultipleinheritencePackage;
import multipleinheritence.NewEClass5;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New EClass5</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link multipleinheritence.impl.NewEClass5Impl#getF5 <em>F5</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewEClass5Impl extends MinimalEObjectImpl.Container implements NewEClass5 {
	/**
	 * The default value of the '{@link #getF5() <em>F5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF5()
	 * @generated
	 * @ordered
	 */
	protected static final int F5_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getF5() <em>F5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF5()
	 * @generated
	 * @ordered
	 */
	protected int f5 = F5_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEClass5Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipleinheritencePackage.Literals.NEW_ECLASS5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getF5() {
		return f5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF5(int newF5) {
		int oldF5 = f5;
		f5 = newF5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS5__F5, oldF5,
					f5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS5__F5:
			return getF5();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS5__F5:
			setF5((Integer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS5__F5:
			setF5(F5_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS5__F5:
			return f5 != F5_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (f5: ");
		result.append(f5);
		result.append(')');
		return result.toString();
	}

} //NewEClass5Impl
