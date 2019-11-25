package testmaprelations.interpreter.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import testmaprelations.interpreter.testmaprelations.CA9;
import testmaprelations.interpreter.testmaprelations.CB9;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class MapCA9ToCB9MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<EList<CA9>, EList<CB9>> {
	protected EList<CA9> key;

	protected EList<CB9> value;

	protected int hash = -1;

	protected MapCA9ToCB9MapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA9_TO_CB9_MAP_ENTRY;
	}

	public EList<CA9> getTypedKey() {
		if (key == null) {
			key = new EObjectContainmentEList<CA9>(CA9.class, this, TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__KEY);
		}
		return key;
	}

	public EList<CB9> getTypedValue() {
		if (value == null) {
			value = new EObjectContainmentEList<CB9>(CB9.class, this, TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__VALUE);
		}
		return value;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__KEY :
				return ((InternalEList<?>) getTypedKey()).basicRemove(otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__VALUE :
				return ((InternalEList<?>) getTypedValue()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__KEY :
				return getTypedKey();
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__VALUE :
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__KEY :
				getTypedKey().clear();
				getTypedKey().addAll((Collection<? extends CA9>)newValue);
				return;
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__VALUE :
				getTypedValue().clear();
				getTypedValue().addAll((Collection<? extends CB9>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__KEY :
				getTypedKey().clear();
				return;
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__VALUE :
				getTypedValue().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__KEY :
				return key != null && !key.isEmpty();
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY__VALUE :
				return value != null && !value.isEmpty();
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

	public EList<CA9> getKey() {
		return getTypedKey();
	}

	public void setKey(EList<CA9> key) {
		getTypedKey().addAll(key);
	}

	public EList<CB9> getValue() {
		return getTypedValue();
	}

	public EList<CB9> setValue(EList<CB9> value) {
		EList<CB9> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}

	public EMap<EList<CA9>, EList<CB9>> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<EList<CA9>, EList<CB9>>)container.eGet(eContainmentFeature());
	}
}
