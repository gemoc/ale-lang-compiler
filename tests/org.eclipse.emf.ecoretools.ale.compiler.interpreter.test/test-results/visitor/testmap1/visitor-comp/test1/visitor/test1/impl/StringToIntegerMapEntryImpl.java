package test1.visitor.test1.impl;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import test1.visitor.test1.Test1Package;

public class StringToIntegerMapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, Integer> {
	protected static final String KEY_EDEFAULT = null;

	protected static final Integer VALUE_EDEFAULT = null;

	protected String key = KEY_EDEFAULT;

	protected Integer value = VALUE_EDEFAULT;

	protected int hash = -1;

	protected StringToIntegerMapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.STRING_TO_INTEGER_MAP_ENTRY;
	}

	public String getTypedKey() {
		return key;
	}

	public void setTypedKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY, oldKey, key));
	}

	public Integer getTypedValue() {
		return value;
	}

	public void setTypedValue(Integer newValue) {
		Integer oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				return getTypedKey();
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				setTypedKey((String) newValue);
				return;
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				setTypedValue((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				setTypedKey(KEY_EDEFAULT);
				return;
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				setTypedValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__KEY :
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case Test1Package.STRING_TO_INTEGER_MAP_ENTRY__VALUE :
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public String getKey() {
		return getTypedKey();
	}

	public void setKey(String key) {
		setTypedKey(key);
	}

	public Integer getValue() {
		return getTypedValue();
	}

	public Integer setValue(Integer value) {
		Integer oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<String, Integer> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<String, Integer>)container.eGet(eContainmentFeature());
	}
}
