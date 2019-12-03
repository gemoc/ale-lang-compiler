package testaccessors.visitor.testaccessors.impl;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import testaccessors.visitor.testaccessors.EAcc;
import testaccessors.visitor.testaccessors.TestaccessorsPackage;
import visitor.VisitorInterface;

public class EAccImpl extends MinimalEObjectImpl.Container implements EAcc {
	protected static final boolean B_EDEFAULT = false;

	protected static final int I_EDEFAULT = 0;

	protected boolean b = B_EDEFAULT;

	protected int i = I_EDEFAULT;

	protected EList<Boolean> bs;

	protected EList<Integer> is;

	protected EAccImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestaccessorsPackage.Literals.EACC;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean newB) {
		boolean oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestaccessorsPackage.EACC__B, oldB, b));
	}

	public int getI() {
		return i;
	}

	public void setI(int newI) {
		int oldI = i;
		i = newI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestaccessorsPackage.EACC__I, oldI, i));
	}

	public EList<Boolean> isBs() {
		if (bs == null) {
			bs = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, TestaccessorsPackage.EACC__BS);
		}
		return bs;
	}

	public EList<Integer> getIs() {
		if (is == null) {
			is = new EDataTypeUniqueEList<Integer>(Integer.class, this, TestaccessorsPackage.EACC__IS);
		}
		return is;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestaccessorsPackage.EACC__B :
				return isB();
			case TestaccessorsPackage.EACC__I :
				return getI();
			case TestaccessorsPackage.EACC__BS :
				return getBs();
			case TestaccessorsPackage.EACC__IS :
				return getIs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestaccessorsPackage.EACC__B :
				setB((Boolean) newValue);
				return;
			case TestaccessorsPackage.EACC__I :
				setI((Integer) newValue);
				return;
			case TestaccessorsPackage.EACC__BS :
				getBs().clear();
				getBs().addAll((Collection<? extends Boolean>) newValue);
				return;
			case TestaccessorsPackage.EACC__IS :
				getIs().clear();
				getIs().addAll((Collection<? extends Integer>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestaccessorsPackage.EACC__B :
				setB(B_EDEFAULT);
				return;
			case TestaccessorsPackage.EACC__I :
				setI(I_EDEFAULT);
				return;
			case TestaccessorsPackage.EACC__BS :
				getBs().clear();
				return;
			case TestaccessorsPackage.EACC__IS :
				getIs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestaccessorsPackage.EACC__B :
				return b != B_EDEFAULT;
			case TestaccessorsPackage.EACC__I :
				return i != I_EDEFAULT;
			case TestaccessorsPackage.EACC__BS :
				return bs != null && !bs.isEmpty();
			case TestaccessorsPackage.EACC__IS :
				return is != null && !is.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestaccessors__EAcc(this);
	}
}
