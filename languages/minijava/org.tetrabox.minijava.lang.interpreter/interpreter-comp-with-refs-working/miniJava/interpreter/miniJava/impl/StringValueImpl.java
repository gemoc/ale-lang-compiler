package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Value;

public class StringValueImpl extends ValueImpl implements StringValue {
	protected static final String VALUE_EDEFAULT = null;

	protected String value = VALUE_EDEFAULT;

	protected StringValueImpl() {
		super();
	}

	public Value copy() {
		Value result;
		StringValue tmp = ((StringValue) MiniJavaFactory.eINSTANCE.createStringValue());
		tmp.setValue(this.value);
		result = tmp;
		;
		return result;
	}

	public String customToString() {
		String result;
		result = this.value.toString();
		;
		return result;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.STRING_VALUE__VALUE:
			return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.STRING_VALUE__VALUE:
			return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.STRING_VALUE__VALUE:
			setValue((java.lang.String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.STRING_VALUE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.STRING_VALUE__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
