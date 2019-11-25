/**
 */
package multipleinheritence.impl;

import multipleinheritence.MultipleinheritencePackage;
import multipleinheritence.NewEClass3;
import multipleinheritence.NewEClass5;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New EClass3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link multipleinheritence.impl.NewEClass3Impl#getF5 <em>F5</em>}</li>
 *   <li>{@link multipleinheritence.impl.NewEClass3Impl#getF3 <em>F3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewEClass3Impl extends NewEClass4Impl implements NewEClass3 {
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
	 * The default value of the '{@link #getF3() <em>F3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF3()
	 * @generated
	 * @ordered
	 */
	protected static final int F3_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getF3() <em>F3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF3()
	 * @generated
	 * @ordered
	 */
	protected int f3 = F3_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEClass3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipleinheritencePackage.Literals.NEW_ECLASS3;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS3__F5, oldF5,
					f5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getF3() {
		return f3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF3(int newF3) {
		int oldF3 = f3;
		f3 = newF3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS3__F3, oldF3,
					f3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS3__F5:
			return getF5();
		case MultipleinheritencePackage.NEW_ECLASS3__F3:
			return getF3();
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
		case MultipleinheritencePackage.NEW_ECLASS3__F5:
			setF5((Integer) newValue);
			return;
		case MultipleinheritencePackage.NEW_ECLASS3__F3:
			setF3((Integer) newValue);
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
		case MultipleinheritencePackage.NEW_ECLASS3__F5:
			setF5(F5_EDEFAULT);
			return;
		case MultipleinheritencePackage.NEW_ECLASS3__F3:
			setF3(F3_EDEFAULT);
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
		case MultipleinheritencePackage.NEW_ECLASS3__F5:
			return f5 != F5_EDEFAULT;
		case MultipleinheritencePackage.NEW_ECLASS3__F3:
			return f3 != F3_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NewEClass5.class) {
			switch (derivedFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS3__F5:
				return MultipleinheritencePackage.NEW_ECLASS5__F5;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NewEClass5.class) {
			switch (baseFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS5__F5:
				return MultipleinheritencePackage.NEW_ECLASS3__F5;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", f3: ");
		result.append(f3);
		result.append(')');
		return result.toString();
	}

} //NewEClass3Impl
