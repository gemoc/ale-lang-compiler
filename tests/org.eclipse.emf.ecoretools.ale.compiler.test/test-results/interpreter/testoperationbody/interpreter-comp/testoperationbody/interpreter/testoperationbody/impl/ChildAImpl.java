package testoperationbody.interpreter.testoperationbody.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import testoperationbody.interpreter.testoperationbody.ChildA;
import testoperationbody.interpreter.testoperationbody.EnumA;
import testoperationbody.interpreter.testoperationbody.TestoperationbodyPackage;

public class ChildAImpl extends ParentImpl implements ChildA {
	protected static final EnumA VALUE_EDEFAULT = EnumA.CASE1;

	protected EnumA value = VALUE_EDEFAULT;

	protected ChildAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CHILD_A;
	}

	public EnumA getValue() {
		return value;
	}

	public void setValue(EnumA newValue) {
		EnumA oldValue = value;
		value = newValue == null ? VALUE_EDEFAULT : newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.CHILD_A__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestoperationbodyPackage.CHILD_A__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestoperationbodyPackage.CHILD_A__VALUE :
				setValue((EnumA) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.CHILD_A__VALUE :
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.CHILD_A__VALUE :
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void overriden() {
	}

	public EnumA onlyA() {
		EnumA result;
		result = (EnumA) (this.value);
		return result;
	}
}
