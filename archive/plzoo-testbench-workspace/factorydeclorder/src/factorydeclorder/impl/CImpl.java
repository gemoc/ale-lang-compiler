/**
 */
package factorydeclorder.impl;

import factorydeclorder.A;
import factorydeclorder.C;
import factorydeclorder.D;
import factorydeclorder.FactorydeclorderPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link factorydeclorder.impl.CImpl#getFa <em>Fa</em>}</li>
 *   <li>{@link factorydeclorder.impl.CImpl#isFc <em>Fc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CImpl extends BImpl implements C {
	protected static final int FA_EDEFAULT = 0;

	protected int fa = FA_EDEFAULT;

	protected static final boolean FC_EDEFAULT = false;

	protected boolean fc = FC_EDEFAULT;

	protected CImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FactorydeclorderPackage.Literals.C;
	}

	public int getFa() {
		return fa;
	}

	public void setFa(int newFa) {
		int oldFa = fa;
		fa = newFa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FactorydeclorderPackage.C__FA, oldFa, fa));
	}

	public boolean isFc() {
		return fc;
	}

	public void setFc(boolean newFc) {
		boolean oldFc = fc;
		fc = newFc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FactorydeclorderPackage.C__FC, oldFc, fc));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FactorydeclorderPackage.C__FA:
				return getFa();
			case FactorydeclorderPackage.C__FC:
				return isFc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FactorydeclorderPackage.C__FA:
				setFa((Integer)newValue);
				return;
			case FactorydeclorderPackage.C__FC:
				setFc((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FactorydeclorderPackage.C__FA:
				setFa(FA_EDEFAULT);
				return;
			case FactorydeclorderPackage.C__FC:
				setFc(FC_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FactorydeclorderPackage.C__FA:
				return fa != FA_EDEFAULT;
			case FactorydeclorderPackage.C__FC:
				return fc != FC_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == D.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == A.class) {
			switch (derivedFeatureID) {
				case FactorydeclorderPackage.C__FA: return FactorydeclorderPackage.A__FA;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == D.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == A.class) {
			switch (baseFeatureID) {
				case FactorydeclorderPackage.A__FA: return FactorydeclorderPackage.C__FA;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
}
