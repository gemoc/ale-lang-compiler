package imp.visitor.imp.impl;

import imp.visitor.imp.ImpPackage;
import imp.visitor.imp.IntConst;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class IntConstImpl extends ExprImpl implements IntConst {
	protected static final int VALUE_EDEFAULT = 0;

	protected int value = VALUE_EDEFAULT;

	protected IntConstImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.INT_CONST;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.INT_CONST__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.INT_CONST__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.INT_CONST__VALUE :
				setValue((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.INT_CONST__VALUE :
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.INT_CONST__VALUE :
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitimp__IntConst(this);
	}
}
