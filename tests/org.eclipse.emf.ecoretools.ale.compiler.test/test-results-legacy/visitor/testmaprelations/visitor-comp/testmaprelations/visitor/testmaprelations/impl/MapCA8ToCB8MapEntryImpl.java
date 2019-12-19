package testmaprelations.visitor.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testmaprelations.visitor.testmaprelations.CA8;
import testmaprelations.visitor.testmaprelations.CB8;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;

public class MapCA8ToCB8MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<CA8, CB8> {
	protected CA8 key;

	protected CB8 value;

	protected int hash = -1;

	protected MapCA8ToCB8MapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA8_TO_CB8_MAP_ENTRY;
	}

	public CA8 getTypedKey() {
		return key;
	}

	public NotificationChain basicSetTypedKey(CA8 newKey, NotificationChain msgs) {
		CA8 oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY, oldKey, newKey);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedKey(CA8 newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null)
				msgs = ((InternalEObject) key).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY, null, msgs);
			if (newKey != null)
				msgs = ((InternalEObject) newKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY, null, msgs);
			msgs = basicSetTypedKey(newKey, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY, newKey, newKey));
	}

	public CB8 getTypedValue() {
		return value;
	}

	public NotificationChain basicSetTypedValue(CB8 newValue, NotificationChain msgs) {
		CB8 oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedValue(CB8 newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE, null, msgs);
			msgs = basicSetTypedValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE, newValue, newValue));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY :
				return basicSetTypedKey(null, msgs);
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE :
				return basicSetTypedValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY :
				return getTypedKey();
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE :
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY :
				setTypedKey((CA8) newValue);
				return;
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE :
				setTypedValue((CB8) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY :
				setTypedKey((CA8) null);
				return;
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE :
				setTypedValue((CB8) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__KEY :
				return key != null;
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY__VALUE :
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

	public CA8 getKey() {
		return getTypedKey();
	}

	public void setKey(CA8 key) {
		setTypedKey(key);
	}

	public CB8 getValue() {
		return getTypedValue();
	}

	public CB8 setValue(CB8 value) {
		CB8 oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<CA8, CB8> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<CA8, CB8>)container.eGet(eContainmentFeature());
	}
}
