/**
 */
package multipleinheritence.impl;

import multipleinheritence.MultipleinheritencePackage;
import multipleinheritence.NewEClass4;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New EClass4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link multipleinheritence.impl.NewEClass4Impl#getF4 <em>F4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewEClass4Impl extends MinimalEObjectImpl.Container implements NewEClass4 {
	/**
	 * The default value of the '{@link #getF4() <em>F4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF4()
	 * @generated
	 * @ordered
	 */
	protected static final int F4_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getF4() <em>F4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF4()
	 * @generated
	 * @ordered
	 */
	protected int f4 = F4_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEClass4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipleinheritencePackage.Literals.NEW_ECLASS4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getF4() {
		return f4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF4(int newF4) {
		int oldF4 = f4;
		f4 = newF4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS4__F4, oldF4,
					f4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS4__F4:
			return getF4();
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
		case MultipleinheritencePackage.NEW_ECLASS4__F4:
			setF4((Integer) newValue);
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
		case MultipleinheritencePackage.NEW_ECLASS4__F4:
			setF4(F4_EDEFAULT);
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
		case MultipleinheritencePackage.NEW_ECLASS4__F4:
			return f4 != F4_EDEFAULT;
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
		result.append(" (f4: ");
		result.append(f4);
		result.append(')');
		return result.toString();
	}

} //NewEClass4Impl
