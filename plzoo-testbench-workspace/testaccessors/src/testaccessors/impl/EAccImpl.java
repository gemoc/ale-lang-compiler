/**
 */
package testaccessors.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import testaccessors.EAcc;
import testaccessors.TestaccessorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EAcc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testaccessors.impl.EAccImpl#isB <em>B</em>}</li>
 *   <li>{@link testaccessors.impl.EAccImpl#getI <em>I</em>}</li>
 *   <li>{@link testaccessors.impl.EAccImpl#getBs <em>Bs</em>}</li>
 *   <li>{@link testaccessors.impl.EAccImpl#getIs <em>Is</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EAccImpl extends MinimalEObjectImpl.Container implements EAcc {
	/**
	 * The default value of the '{@link #isB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isB()
	 * @generated
	 * @ordered
	 */
	protected static final boolean B_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isB()
	 * @generated
	 * @ordered
	 */
	protected boolean b = B_EDEFAULT;

	/**
	 * The default value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected static final int I_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected int i = I_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBs() <em>Bs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBs()
	 * @generated
	 * @ordered
	 */
	protected EList<Boolean> bs;

	/**
	 * The cached value of the '{@link #getIs() <em>Is</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIs()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> is;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAccImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestaccessorsPackage.Literals.EACC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(boolean newB) {
		boolean oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestaccessorsPackage.EACC__B, oldB, b));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getI() {
		return i;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setI(int newI) {
		int oldI = i;
		i = newI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestaccessorsPackage.EACC__I, oldI, i));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Boolean> getBs() {
		if (bs == null) {
			bs = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, TestaccessorsPackage.EACC__BS);
		}
		return bs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getIs() {
		if (is == null) {
			is = new EDataTypeUniqueEList<Integer>(Integer.class, this, TestaccessorsPackage.EACC__IS);
		}
		return is;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestaccessorsPackage.EACC__B:
				return isB();
			case TestaccessorsPackage.EACC__I:
				return getI();
			case TestaccessorsPackage.EACC__BS:
				return getBs();
			case TestaccessorsPackage.EACC__IS:
				return getIs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestaccessorsPackage.EACC__B:
				setB((Boolean)newValue);
				return;
			case TestaccessorsPackage.EACC__I:
				setI((Integer)newValue);
				return;
			case TestaccessorsPackage.EACC__BS:
				getBs().clear();
				getBs().addAll((Collection<? extends Boolean>)newValue);
				return;
			case TestaccessorsPackage.EACC__IS:
				getIs().clear();
				getIs().addAll((Collection<? extends Integer>)newValue);
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
			case TestaccessorsPackage.EACC__B:
				setB(B_EDEFAULT);
				return;
			case TestaccessorsPackage.EACC__I:
				setI(I_EDEFAULT);
				return;
			case TestaccessorsPackage.EACC__BS:
				getBs().clear();
				return;
			case TestaccessorsPackage.EACC__IS:
				getIs().clear();
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
			case TestaccessorsPackage.EACC__B:
				return b != B_EDEFAULT;
			case TestaccessorsPackage.EACC__I:
				return i != I_EDEFAULT;
			case TestaccessorsPackage.EACC__BS:
				return bs != null && !bs.isEmpty();
			case TestaccessorsPackage.EACC__IS:
				return is != null && !is.isEmpty();
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (b: ");
		result.append(b);
		result.append(", i: ");
		result.append(i);
		result.append(", bs: ");
		result.append(bs);
		result.append(", is: ");
		result.append(is);
		result.append(')');
		return result.toString();
	}

} //EAccImpl
