package test1.interpreter.test1.impl;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import test1.interpreter.test1.Test1Package;

public class StringToIntegerMapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, Integer> {
	protected static final String KEY_EDEFAULT = null;

	protected static final Integer VALUE_EDEFAULT = null;

	protected String key = KEY_EDEFAULT;

	protected Integer value = VALUE_EDEFAULT;

	protected int hash = -1;

	protected StringToIntegerMapEntryImpl() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	protected EClass eStaticClass() {
		return Test1Package.Literals.STRING_TO_INTEGER_MAP_ENTRY;
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				setKey((java.lang.String) newValue);
				return;
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				setValue((java.lang.Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	public void eUnset(int featureID) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				setKey(KEY_EDEFAULT);
				return;
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				return getKey();
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				return key != KEY_EDEFAULT;
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}
}
