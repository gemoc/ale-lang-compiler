package testmaprelations.interpreter.testmaprelations.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testmaprelations.interpreter.testmaprelations.CA3;
import testmaprelations.interpreter.testmaprelations.CB3;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class CA3Impl extends MinimalEObjectImpl.Container implements CA3 {
	protected EList<Map.Entry<EList<CA3>, EList<CB3>>> mapca0tocb0mapentry;

	protected CA3Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CA3;
	}

	public EList<Map.Entry<EList<CA3>, EList<CB3>>> getMapca0tocb0mapentry() {
		if (mapca0tocb0mapentry == null) {
			mapca0tocb0mapentry = new EObjectWithInverseResolvingEList.ManyInverse<Map.Entry<EList<CA3>, EList<CB3>>>(Entry.class, this, TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY, TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__KEY);
		}
		return mapca0tocb0mapentry;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY :
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMapca0tocb0mapentry()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY :
				return ((InternalEList<?>)getMapca0tocb0mapentry()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY :
				return getMapca0tocb0mapentry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY :
				getMapca0tocb0mapentry().clear();
				getMapca0tocb0mapentry().addAll((Collection<? extends Map.Entry<EList<CA3>, EList<CB3>>>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY :
				getMapca0tocb0mapentry().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CA3__MAPCA0TOCB0MAPENTRY :
				return mapca0tocb0mapentry != null && !mapca0tocb0mapentry.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
