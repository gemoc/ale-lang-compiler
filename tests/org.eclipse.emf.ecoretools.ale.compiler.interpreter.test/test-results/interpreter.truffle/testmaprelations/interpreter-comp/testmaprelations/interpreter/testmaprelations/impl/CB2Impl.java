package testmaprelations.interpreter.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import testmaprelations.interpreter.testmaprelations.CA2;
import testmaprelations.interpreter.testmaprelations.CB2;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class CB2Impl extends MinimalEObjectImpl.Container implements CB2 {
	protected EList<Entry<CA2, CB2>> mapca0tocb0mapentry;

	protected CB2Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB2;
	}

	public EList<Entry<CA2, CB2>> getMapca0tocb0mapentry() {
		if (mapca0tocb0mapentry == null) {
			mapca0tocb0mapentry = new EObjectWithInverseResolvingEList<Entry<CA2, CB2>>(Entry.class, this, TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY, TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY__VALUE);
		}
		return mapca0tocb0mapentry;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getMapca0tocb0mapentry()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY :
				return ((InternalEList<?>) getMapca0tocb0mapentry()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY :
				return getMapca0tocb0mapentry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY :
				getMapca0tocb0mapentry().clear();
				getMapca0tocb0mapentry().addAll((Collection<? extends Entry<CA2, CB2>>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY :
				getMapca0tocb0mapentry().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB2__MAPCA0TOCB0MAPENTRY :
				return mapca0tocb0mapentry != null && !mapca0tocb0mapentry.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
