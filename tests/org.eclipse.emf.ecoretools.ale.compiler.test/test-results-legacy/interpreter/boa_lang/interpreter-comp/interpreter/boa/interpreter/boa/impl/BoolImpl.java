package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Bool;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalBoolRes;
import interpreter.boa.interpreter.boa.EvalRes;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class BoolImpl extends ExprImpl implements Bool {
	protected static final boolean VALUE_EDEFAULT = false;

	protected boolean value = VALUE_EDEFAULT;

	protected BoolImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.BOOL;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean newValue) {
		boolean oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.BOOL__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.BOOL__VALUE :
				return isValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.BOOL__VALUE :
				setValue((Boolean) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.BOOL__VALUE :
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.BOOL__VALUE :
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
		ret.setValue(this.value);
		result = (EvalRes) (ret) ;
		return result;
	}
}
