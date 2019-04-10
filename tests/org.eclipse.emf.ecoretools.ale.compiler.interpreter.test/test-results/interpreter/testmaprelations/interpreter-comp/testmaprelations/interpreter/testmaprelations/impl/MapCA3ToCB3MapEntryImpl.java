package testmaprelations.interpreter.testmaprelations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testmaprelations.interpreter.testmaprelations.CA3;
import testmaprelations.interpreter.testmaprelations.CB3;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class MapCA3ToCB3MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<EList<CA3>, EList<CB3>> {

	protected EList<CA3> key;

	protected EList<CB3> value;

	protected MapCA3ToCB3MapEntryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA3_TO_CB3_MAP_ENTRY;
	}

	public EList<CA3> getTypedKey() {
		if (key == null) {
			key = new EObjectWithInverseResolvingEList.ManyInverse<CA3>(CA3.class, this, TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY, TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY);
		}
		return key;
	}

	public EList<CB3> getTypedValue() {
		if (value == null) {
			value = new EObjectWithInverseResolvingEList.ManyInverse<CB3>(CB3.class, this, TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE, TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY);
		}
		return value;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY :
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypedKey()).basicAdd(otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE :
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypedValue()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY :
				return ((InternalEList<?>)getTypedKey()).basicRemove(otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE :
				return ((InternalEList<?>)getTypedValue()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY :
				return getTypedKey();
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE :
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY :
				getTypedKey().clear();
				getTypedKey().addAll((Collection<? extends CA3>)newValue);
				return;
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE :
				getTypedValue().clear();
				getTypedValue().addAll((Collection<? extends CB3>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY :
				getTypedKey().clear();
				return;
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE :
				getTypedValue().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY :
				return key != null && !key.isEmpty();
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE :
				return value != null && !value.isEmpty();
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

	public EList<CA3> getKey() {
		return getTypedKey();
	}

	public void setKey(EList<CA3> key) {
		getTypedKey().addAll(key);
	}

	public EList<CB3> getValue() {
		return getTypedValue();
	}

	public EList<CB3> setValue(EList<CB3> value) {
		EList<CB3> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}

	public EMap<EList<CA3>, EList<CB3>> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<EList<CA3>, EList<CB3>>)container.eGet(eContainmentFeature());
	}
}
