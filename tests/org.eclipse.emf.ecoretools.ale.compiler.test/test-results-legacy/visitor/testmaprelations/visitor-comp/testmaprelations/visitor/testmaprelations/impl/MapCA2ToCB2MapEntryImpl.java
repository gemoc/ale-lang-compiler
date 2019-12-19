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
import testmaprelations.visitor.testmaprelations.CA2;
import testmaprelations.visitor.testmaprelations.CB2;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;

public class MapCA2ToCB2MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<CA2, CB2> {
	protected CA2 key;

	protected CB2 value;

	protected int hash = -1;

	protected MapCA2ToCB2MapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA2_TO_CB2_MAP_ENTRY;
	}

	public CA2 getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject) key;
			key = (CA2) eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY, oldKey, key));
			}
		}
		return key;
	}

	public CA2 basicGetTypedKey() {
		return key;
	}

	public NotificationChain basicSetTypedKey(CA2 newKey, NotificationChain msgs) {
		CA2 oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY, oldKey, newKey);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedKey(CA2 newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null)
				msgs = ((InternalEObject) key).eInverseRemove(this, TestmaprelationsPackage.CA2__MAPCA0TOCB0MAPENTRY, CA2.class, msgs);
			if (newKey != null)
				msgs = ((InternalEObject) newKey).eInverseAdd(this, TestmaprelationsPackage.CA2__MAPCA0TOCB0MAPENTRY, CA2.class, msgs);
			msgs = basicSetTypedKey(newKey, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY, newKey, newKey));
	}

	public CB2 getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject) value;
			value = (CB2) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE, oldValue, value));
			}
		}
		return value;
	}

	public CB2 basicGetTypedValue() {
		return value;
	}

	public NotificationChain basicSetTypedValue(CB2 newValue, NotificationChain msgs) {
		CB2 oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedValue(CB2 newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY, CB2.class, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY, CB2.class, msgs);
			msgs = basicSetTypedValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE, newValue, newValue));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY :
				if (key != null)
					msgs = ((InternalEObject) key).eInverseRemove(this, TestmaprelationsPackage.CA2__MAPCA0TOCB0MAPENTRY, CA2.class, msgs);
				return basicSetTypedKey((CA2) otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE :
				if (value != null)
					msgs = ((InternalEObject) value).eInverseRemove(this, TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY, CB2.class, msgs);
				return basicSetTypedValue((CB2) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY :
				return basicSetTypedKey(null, msgs);
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE :
				return basicSetTypedValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY :
				if (resolve)
					return getTypedKey();
				return basicGetTypedKey();
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE :
				if (resolve)
					return getTypedValue();
				return basicGetTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY :
				setTypedKey((CA2) newValue);
				return;
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE :
				setTypedValue((CB2) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY :
				setTypedKey((CA2) null);
				return;
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE :
				setTypedValue((CB2) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__KEY :
				return key != null;
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE :
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

	public CA2 getKey() {
		return getTypedKey();
	}

	public void setKey(CA2 key) {
		setTypedKey(key);
	}

	public CB2 getValue() {
		return getTypedValue();
	}

	public CB2 setValue(CB2 value) {
		CB2 oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<CA2, CB2> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<CA2, CB2>)container.eGet(eContainmentFeature());
	}
}
