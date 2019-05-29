package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Constant;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ConstantImpl extends ExpressionImpl implements Constant {
	protected static final double VALUE_EDEFAULT = 0.0;

	protected double value = VALUE_EDEFAULT;

	protected ConstantImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CONSTANT;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.CONSTANT__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.CONSTANT__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.CONSTANT__VALUE :
				setValue((Double) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.CONSTANT__VALUE :
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.CONSTANT__VALUE :
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (this.value) ;
		return result;
	}
}
