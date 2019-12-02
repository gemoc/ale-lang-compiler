package factorydeclorder.interpreter.factorydeclorder.impl;

import factorydeclorder.interpreter.factorydeclorder.A;
import factorydeclorder.interpreter.factorydeclorder.B;
import factorydeclorder.interpreter.factorydeclorder.FactorydeclorderPackage;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class AImpl extends DImpl implements A {
	protected static final long FB_EDEFAULT = 0;

	protected static final int FA_EDEFAULT = 0;

	protected long fb = FB_EDEFAULT;

	protected int fa = FA_EDEFAULT;

	protected AImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FactorydeclorderPackage.Literals.A;
	}

	public long getFb() {
		return fb;
	}

	public void setFb(long newFb) {
		long oldFb = fb;
		fb = newFb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FactorydeclorderPackage.A__FB, oldFb, fb));
	}

	public int getFa() {
		return fa;
	}

	public void setFa(int newFa) {
		int oldFa = fa;
		fa = newFa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FactorydeclorderPackage.A__FA, oldFa, fa));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FactorydeclorderPackage.A__FB :
				return getFb();
			case FactorydeclorderPackage.A__FA :
				return getFa();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FactorydeclorderPackage.A__FB :
				setFb((Long) newValue);
				return;
			case FactorydeclorderPackage.A__FA :
				setFa((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FactorydeclorderPackage.A__FB :
				setFb(FB_EDEFAULT);
				return;
			case FactorydeclorderPackage.A__FA :
				setFa(FA_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FactorydeclorderPackage.A__FB :
				return fb != FB_EDEFAULT;
			case FactorydeclorderPackage.A__FA :
				return fa != FA_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == B.class) {
			switch (derivedFeatureID) {
				case FactorydeclorderPackage.A__FB: return FactorydeclorderPackage.B__FB;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == B.class) {
			switch (baseFeatureID) {
				case FactorydeclorderPackage.B__FB: return FactorydeclorderPackage.A__FB;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
}
