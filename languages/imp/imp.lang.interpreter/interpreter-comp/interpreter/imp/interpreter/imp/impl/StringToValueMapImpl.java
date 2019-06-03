package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class StringToValueMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, Value> {
	protected static final String KEY_EDEFAULT = null;

	protected String key = KEY_EDEFAULT;

	protected Value value;

	protected int hash = -1;

	protected StringToValueMapImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.STRING_TO_VALUE_MAP;
	}

	public String getTypedKey() {
		return key;
	}

	public void setTypedKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.STRING_TO_VALUE_MAP__KEY, oldKey, key));
	}

	public Value getTypedValue() {
		return value;
	}

	public NotificationChain basicSetTypedValue(Value newValue, NotificationChain msgs) {
		Value oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.STRING_TO_VALUE_MAP__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedValue(Value newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.STRING_TO_VALUE_MAP__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.STRING_TO_VALUE_MAP__VALUE, null, msgs);
			msgs = basicSetTypedValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.STRING_TO_VALUE_MAP__VALUE, newValue, newValue));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.STRING_TO_VALUE_MAP__VALUE :
				return basicSetTypedValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.STRING_TO_VALUE_MAP__KEY :
				return getTypedKey();
			case ImpPackage.STRING_TO_VALUE_MAP__VALUE :
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.STRING_TO_VALUE_MAP__KEY :
				setTypedKey((String) newValue);
				return;
			case ImpPackage.STRING_TO_VALUE_MAP__VALUE :
				setTypedValue((Value) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.STRING_TO_VALUE_MAP__KEY :
				setTypedKey(KEY_EDEFAULT);
				return;
			case ImpPackage.STRING_TO_VALUE_MAP__VALUE :
				setTypedValue((Value) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.STRING_TO_VALUE_MAP__KEY :
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case ImpPackage.STRING_TO_VALUE_MAP__VALUE :
				return value != null;
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

	public Value getValue() {
		return getTypedValue();
	}

	public Value setValue(Value value) {
		Value oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<String, Value> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<String, Value>)container.eGet(eContainmentFeature());
	}
}
