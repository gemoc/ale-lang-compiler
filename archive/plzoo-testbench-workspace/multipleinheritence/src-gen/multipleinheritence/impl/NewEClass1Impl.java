/**
 */
package multipleinheritence.impl;

import multipleinheritence.MultipleinheritencePackage;
import multipleinheritence.NewEClass1;
import multipleinheritence.NewEClass3;
import multipleinheritence.NewEClass4;
import multipleinheritence.NewEClass5;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New EClass1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link multipleinheritence.impl.NewEClass1Impl#getF4 <em>F4</em>}</li>
 *   <li>{@link multipleinheritence.impl.NewEClass1Impl#getF5 <em>F5</em>}</li>
 *   <li>{@link multipleinheritence.impl.NewEClass1Impl#getF3 <em>F3</em>}</li>
 *   <li>{@link multipleinheritence.impl.NewEClass1Impl#getF1 <em>F1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewEClass1Impl extends NewEClass2Impl implements NewEClass1 {
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
	 * The default value of the '{@link #getF1() <em>F1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF1()
	 * @generated
	 * @ordered
	 */
	protected static final int F1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getF1() <em>F1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF1()
	 * @generated
	 * @ordered
	 */
	protected int f1 = F1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEClass1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipleinheritencePackage.Literals.NEW_ECLASS1;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS1__F4, oldF4,
					f4));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS1__F5, oldF5,
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS1__F3, oldF3,
					f3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getF1() {
		return f1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF1(int newF1) {
		int oldF1 = f1;
		f1 = newF1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipleinheritencePackage.NEW_ECLASS1__F1, oldF1,
					f1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MultipleinheritencePackage.NEW_ECLASS1__F4:
			return getF4();
		case MultipleinheritencePackage.NEW_ECLASS1__F5:
			return getF5();
		case MultipleinheritencePackage.NEW_ECLASS1__F3:
			return getF3();
		case MultipleinheritencePackage.NEW_ECLASS1__F1:
			return getF1();
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
		case MultipleinheritencePackage.NEW_ECLASS1__F4:
			setF4((Integer) newValue);
			return;
		case MultipleinheritencePackage.NEW_ECLASS1__F5:
			setF5((Integer) newValue);
			return;
		case MultipleinheritencePackage.NEW_ECLASS1__F3:
			setF3((Integer) newValue);
			return;
		case MultipleinheritencePackage.NEW_ECLASS1__F1:
			setF1((Integer) newValue);
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
		case MultipleinheritencePackage.NEW_ECLASS1__F4:
			setF4(F4_EDEFAULT);
			return;
		case MultipleinheritencePackage.NEW_ECLASS1__F5:
			setF5(F5_EDEFAULT);
			return;
		case MultipleinheritencePackage.NEW_ECLASS1__F3:
			setF3(F3_EDEFAULT);
			return;
		case MultipleinheritencePackage.NEW_ECLASS1__F1:
			setF1(F1_EDEFAULT);
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
		case MultipleinheritencePackage.NEW_ECLASS1__F4:
			return f4 != F4_EDEFAULT;
		case MultipleinheritencePackage.NEW_ECLASS1__F5:
			return f5 != F5_EDEFAULT;
		case MultipleinheritencePackage.NEW_ECLASS1__F3:
			return f3 != F3_EDEFAULT;
		case MultipleinheritencePackage.NEW_ECLASS1__F1:
			return f1 != F1_EDEFAULT;
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
		if (baseClass == NewEClass4.class) {
			switch (derivedFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS1__F4:
				return MultipleinheritencePackage.NEW_ECLASS4__F4;
			default:
				return -1;
			}
		}
		if (baseClass == NewEClass5.class) {
			switch (derivedFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS1__F5:
				return MultipleinheritencePackage.NEW_ECLASS5__F5;
			default:
				return -1;
			}
		}
		if (baseClass == NewEClass3.class) {
			switch (derivedFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS1__F3:
				return MultipleinheritencePackage.NEW_ECLASS3__F3;
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
		if (baseClass == NewEClass4.class) {
			switch (baseFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS4__F4:
				return MultipleinheritencePackage.NEW_ECLASS1__F4;
			default:
				return -1;
			}
		}
		if (baseClass == NewEClass5.class) {
			switch (baseFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS5__F5:
				return MultipleinheritencePackage.NEW_ECLASS1__F5;
			default:
				return -1;
			}
		}
		if (baseClass == NewEClass3.class) {
			switch (baseFeatureID) {
			case MultipleinheritencePackage.NEW_ECLASS3__F3:
				return MultipleinheritencePackage.NEW_ECLASS1__F3;
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
		result.append(" (f4: ");
		result.append(f4);
		result.append(", f5: ");
		result.append(f5);
		result.append(", f3: ");
		result.append(f3);
		result.append(", f1: ");
		result.append(f1);
		result.append(')');
		return result.toString();
	}

} //NewEClass1Impl
