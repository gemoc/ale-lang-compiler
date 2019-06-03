package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;

public class IntegerValueImpl extends ValueImpl implements IntegerValue {
	protected static final int VALUE_EDEFAULT = 0;

	protected int value = VALUE_EDEFAULT;

	protected IntegerValueImpl() {
		super();
	}

	public Value copy() {
		Value result;
		IntegerValue tmp = ((IntegerValue) MiniJavaFactory.eINSTANCE.createIntegerValue());
		tmp.setValue(this.value);
		result = tmp;
		;
		return result;
	}

	public String customToString() {
		String result;
		result = (this.value) + ("");
		;
		return result;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.INTEGER_VALUE__VALUE:
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
		case MiniJavaPackage.INTEGER_VALUE__VALUE:
			return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.INTEGER_VALUE__VALUE:
			setValue((int) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.INTEGER_VALUE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.INTEGER_VALUE__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
