package kmLogo.interpreter.kmLogo.impl;

import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Variable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class VariableImpl extends MinimalEObjectImpl.Container implements Variable {
	protected static final String NAME_EDEFAULT = null;

	protected static final double VALUE_EDEFAULT = 0.0;

	protected String name = NAME_EDEFAULT;

	protected double value = VALUE_EDEFAULT;

	protected VariableImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.VARIABLE;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.VARIABLE__NAME, oldName, name));
	}

	public double getValue() {
		return value;
	}

	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.VARIABLE__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.VARIABLE__NAME :
				return getName();
			case KmLogoPackage.VARIABLE__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.VARIABLE__NAME :
				setName((String) newValue);
				return;
			case KmLogoPackage.VARIABLE__VALUE :
				setValue((Double) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.VARIABLE__NAME :
				setName(NAME_EDEFAULT);
				return;
			case KmLogoPackage.VARIABLE__VALUE :
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.VARIABLE__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KmLogoPackage.VARIABLE__VALUE :
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
}
