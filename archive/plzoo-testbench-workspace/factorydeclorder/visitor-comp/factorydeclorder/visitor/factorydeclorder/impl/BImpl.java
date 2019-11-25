package factorydeclorder.visitor.factorydeclorder.impl;

import factorydeclorder.visitor.factorydeclorder.B;
import factorydeclorder.visitor.factorydeclorder.FactorydeclorderPackage;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class BImpl extends MinimalEObjectImpl.Container implements B {
	protected static final long FB_EDEFAULT = 0;

	protected long fb = FB_EDEFAULT;

	protected BImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FactorydeclorderPackage.Literals.B;
	}

	public long getFb() {
		return fb;
	}

	public void setFb(long newFb) {
		long oldFb = fb;
		fb = newFb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FactorydeclorderPackage.B__FB, oldFb, fb));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FactorydeclorderPackage.B__FB :
				return getFb();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FactorydeclorderPackage.B__FB :
				setFb((Long) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FactorydeclorderPackage.B__FB :
				setFb(FB_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FactorydeclorderPackage.B__FB :
				return fb != FB_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfactorydeclorder__B(this);
	}
}
