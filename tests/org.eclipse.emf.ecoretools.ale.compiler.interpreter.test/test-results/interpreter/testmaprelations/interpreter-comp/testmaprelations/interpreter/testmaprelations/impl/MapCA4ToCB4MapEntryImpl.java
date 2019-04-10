package testmaprelations.interpreter.testmaprelations.impl;

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
import testmaprelations.interpreter.testmaprelations.CA4;
import testmaprelations.interpreter.testmaprelations.CB4;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class MapCA4ToCB4MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<CA4, CB4> {

	protected CA4 key;

	protected CB4 value;

	protected MapCA4ToCB4MapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA4_TO_CB4_MAP_ENTRY;
	}

	public CA4 getTypedKey() {
		return key;
	}

	public NotificationChain basicSetTypedKey(CA4 newKey, NotificationChain msgs) {
		CA4 oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY, oldKey, newKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedKey(CA4 newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null)
				msgs = ((InternalEObject)key).eInverseRemove(this, TestmaprelationsPackage.CA4__MAPCA0TOCB0MAPENTRY, CA4.class, msgs);
			if (newKey != null)
				msgs = ((InternalEObject)newKey).eInverseAdd(this, TestmaprelationsPackage.CA4__MAPCA0TOCB0MAPENTRY, CA4.class, msgs);
			msgs = basicSetTypedKey(newKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY, newKey, newKey));
	}

	public CB4 getTypedValue() {
		return value;
	}

	public NotificationChain basicSetTypedValue(CB4 newValue, NotificationChain msgs) {
		CB4 oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	public void setTypedValue(CB4 newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY, CB4.class, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY, CB4.class, msgs);
			msgs = basicSetTypedValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE, newValue, newValue));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY :
				if (key != null)
					msgs = ((InternalEObject)key).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY, null, msgs);
				return basicSetTypedKey((CA4)otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE :
				if (value != null)
					msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE, null, msgs);
				return basicSetTypedValue((CB4)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY :
				return basicSetTypedKey(null, msgs);
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE :
				return basicSetTypedValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY :
				return getTypedKey();
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE :
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY :
				setTypedKey((CA4)newValue);
				return;
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE :
				setTypedValue((CB4)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY :
				setTypedKey((CA4)null);
				return;
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE :
				setTypedValue((CB4)null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__KEY :
				return key != null;
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE :
				return value != null;
		}
		return super.eIsSet(featureID);
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

	public CA4 getKey() {
		return getTypedKey();
	}

	public void setKey(CA4 key) {
		setTypedKey(key);
	}

	public CB4 getValue() {
		return getTypedValue();
	}

	public CB4 setValue(CB4 value) {
		CB4 oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<CA4, CB4> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<CA4, CB4>)container.eGet(eContainmentFeature());
	}
}
