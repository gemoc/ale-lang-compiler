package testmaprelations.visitor.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testmaprelations.visitor.testmaprelations.CA6;
import testmaprelations.visitor.testmaprelations.CB6;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;

public class MapCA6ToCB6MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<CA6, CB6> {
	protected CA6 key;

	protected CB6 value;

	protected int hash = -1;

	protected MapCA6ToCB6MapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA6_TO_CB6_MAP_ENTRY;
	}

	public CA6 getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject) key;
			key = (CA6) eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__KEY,
							oldKey, key));
			}
		}
		return key;
	}

	public CA6 basicGetTypedKey() {
		return key;
	}

	public void setTypedKey(CA6 newKey) {
		CA6 oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__KEY, oldKey, key));
	}

	public CB6 getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject) value;
			value = (CB6) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__VALUE,
							oldValue, value));
			}
		}
		return value;
	}

	public CB6 basicGetTypedValue() {
		return value;
	}

	public void setTypedValue(CB6 newValue) {
		CB6 oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__KEY :
				if (resolve)
					return getTypedKey();
				return basicGetTypedKey();
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__VALUE :
				if (resolve)
					return getTypedValue();
				return basicGetTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__KEY :
				setTypedKey((CA6) newValue);
				return;
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__VALUE :
				setTypedValue((CB6) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__KEY :
				setTypedKey((CA6) null);
				return;
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__VALUE :
				setTypedValue((CB6) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__KEY :
				return key != null;
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY__VALUE :
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

	public CA6 getKey() {
		return getTypedKey();
	}

	public void setKey(CA6 key) {
		setTypedKey(key);
	}

	public CB6 getValue() {
		return getTypedValue();
	}

	public CB6 setValue(CB6 value) {
		CB6 oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<CA6, CB6> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<CA6, CB6>)container.eGet(eContainmentFeature());
	}
}
