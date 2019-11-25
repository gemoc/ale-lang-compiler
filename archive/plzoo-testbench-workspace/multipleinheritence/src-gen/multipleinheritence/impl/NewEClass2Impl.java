/**
 */
package multipleinheritence.impl;

import multipleinheritence.MultipleinheritencePackage;
import multipleinheritence.NewEClass2;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New EClass2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link multipleinheritence.impl.NewEClass2Impl#getF2 <em>F2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewEClass2Impl extends MinimalEObjectImpl.Container implements NewEClass2 {
	/**
	 * The default value of the '{@link #getF2() <em>F2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF2()
	 * @generated
	 * @ordered
	 */
	protected static final int F2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getF2() <em>F2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF2()
	 * @generated
	 * @ordered
	 */
	protected int f2 = F2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEClass2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipleinheritencePackage.Literals.NEW_ECLASS2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getF2() {
		return f2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF2(int newF2) {
		int oldF2 = f2;
		f2 = newF2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS2__F2, oldF2,
					f2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS2__F2:
			return getF2();
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
		case MultipleinheritencePackage.NEW_ECLASS2__F2:
			setF2((Integer) newValue);
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
		case MultipleinheritencePackage.NEW_ECLASS2__F2:
			setF2(F2_EDEFAULT);
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
		case MultipleinheritencePackage.NEW_ECLASS2__F2:
			return f2 != F2_EDEFAULT;
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
		result.append(" (f2: ");
		result.append(f2);
		result.append(')');
		return result.toString();
	}

} //NewEClass2Impl
