package testmaprelations.interpreter.testmaprelations.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import testmaprelations.interpreter.testmaprelations.CA0;
import testmaprelations.interpreter.testmaprelations.CB0;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class CB0Impl extends MinimalEObjectImpl.Container implements CB0 {
	protected Map.Entry<CA0, CB0> mapca0tocb0mapentry;
	
	protected CB0Impl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB0;
	}
	
	public Map.Entry<CA0, CB0> getMapca0tocb0mapentry() {
		if (mapca0tocb0mapentry != null && ((EObject)mapca0tocb0mapentry).eIsProxy()) {
			InternalEObject oldMapca0tocb0mapentry = (InternalEObject)mapca0tocb0mapentry;
			mapca0tocb0mapentry = (Map.Entry<CA0, CB0>)eResolveProxy(oldMapca0tocb0mapentry);
			if (mapca0tocb0mapentry != oldMapca0tocb0mapentry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY, oldMapca0tocb0mapentry, mapca0tocb0mapentry));
			}
		}
		return mapca0tocb0mapentry;
	}
	
	public Map.Entry<CA0, CB0> basicGetMapca0tocb0mapentry() {
		return mapca0tocb0mapentry;
	}
	
	public NotificationChain basicSetMapca0tocb0mapentry(Map.Entry<CA0, CB0> newMapca0tocb0mapentry, NotificationChain msgs) {
		Map.Entry<CA0, CB0> oldMapca0tocb0mapentry = mapca0tocb0mapentry;
		mapca0tocb0mapentry = newMapca0tocb0mapentry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY, oldMapca0tocb0mapentry, newMapca0tocb0mapentry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	public void setMapca0tocb0mapentry(Map.Entry<CA0, CB0> newMapca0tocb0mapentry) {
		if (newMapca0tocb0mapentry != mapca0tocb0mapentry) {
			NotificationChain msgs = null;
			if (mapca0tocb0mapentry != null)
				msgs = ((InternalEObject)mapca0tocb0mapentry).eInverseRemove(this, TestmaprelationsPackage.MAP_CA0_TO_CB0_MAP_ENTRY__VALUE, Map.Entry.class, msgs);
			if (newMapca0tocb0mapentry != null)
				msgs = ((InternalEObject)newMapca0tocb0mapentry).eInverseAdd(this, TestmaprelationsPackage.MAP_CA0_TO_CB0_MAP_ENTRY__VALUE, Map.Entry.class, msgs);
			msgs = basicSetMapca0tocb0mapentry(newMapca0tocb0mapentry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY, newMapca0tocb0mapentry, newMapca0tocb0mapentry));
	}
	
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY:
				if (mapca0tocb0mapentry != null)
					msgs = ((InternalEObject)mapca0tocb0mapentry).eInverseRemove(this, TestmaprelationsPackage.MAP_CA0_TO_CB0_MAP_ENTRY__VALUE, Map.Entry.class, msgs);
				return basicSetMapca0tocb0mapentry((Map.Entry<CA0, CB0>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY:
				return basicSetMapca0tocb0mapentry(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY:
				if (resolve) return getMapca0tocb0mapentry();
				return basicGetMapca0tocb0mapentry();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY:
				setMapca0tocb0mapentry((Map.Entry<CA0, CB0>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY:
				setMapca0tocb0mapentry((Map.Entry<CA0, CB0>)null);
				return;
		}
		super.eUnset(featureID);
	}
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB0__MAPCA0TOCB0MAPENTRY:
				return mapca0tocb0mapentry != null;
		}
		return super.eIsSet(featureID);
	}
}
