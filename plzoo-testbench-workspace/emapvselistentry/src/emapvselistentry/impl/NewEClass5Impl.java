
package emapvselistentry.impl;

import emapvselistentry.EmapvselistentryPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;


public class NewEClass5Impl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<Integer,Boolean> {
	
	protected static final Integer KEY_EDEFAULT = null;

	
	protected Integer key = KEY_EDEFAULT;

	
	protected static final Boolean VALUE_EDEFAULT = null;

	
	protected Boolean value = VALUE_EDEFAULT;

	
	protected NewEClass5Impl() {
		super();
	}

	
	@Override
	protected EClass eStaticClass() {
		return EmapvselistentryPackage.Literals.NEW_ECLASS5;
	}

	
	public Integer getTypedKey() {
		return key;
	}

	
	public void setTypedKey(Integer newKey) {
		Integer oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmapvselistentryPackage.NEW_ECLASS5__KEY, oldKey, key));
	}

	
	public Boolean getTypedValue() {
		return value;
	}

	
	public void setTypedValue(Boolean newValue) {
		Boolean oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmapvselistentryPackage.NEW_ECLASS5__VALUE, oldValue, value));
	}

	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS5__KEY:
				return getTypedKey();
			case EmapvselistentryPackage.NEW_ECLASS5__VALUE:
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS5__KEY:
				setTypedKey((Integer)newValue);
				return;
			case EmapvselistentryPackage.NEW_ECLASS5__VALUE:
				setTypedValue((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS5__KEY:
				setTypedKey(KEY_EDEFAULT);
				return;
			case EmapvselistentryPackage.NEW_ECLASS5__VALUE:
				setTypedValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS5__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case EmapvselistentryPackage.NEW_ECLASS5__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (key: ");
		result.append(key);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

	
	protected int hash = -1;

	
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

	
	public Integer getKey() {
		return getTypedKey();
	}

	
	public void setKey(Integer key) {
		setTypedKey(key);
	}

	
	public Boolean getValue() {
		return getTypedValue();
	}

	
	public Boolean setValue(Boolean value) {
		Boolean oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	
	@SuppressWarnings("unchecked")
	public EMap<Integer, Boolean> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<Integer, Boolean>)container.eGet(eContainmentFeature());
	}

} //NewEClass5Impl
