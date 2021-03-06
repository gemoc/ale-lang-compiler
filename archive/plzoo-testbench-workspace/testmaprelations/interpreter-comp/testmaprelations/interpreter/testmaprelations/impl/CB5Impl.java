package testmaprelations.interpreter.testmaprelations.impl;

import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import testmaprelations.interpreter.testmaprelations.CA5;
import testmaprelations.interpreter.testmaprelations.CB5;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class CB5Impl extends MinimalEObjectImpl.Container implements CB5 {
	protected CB5Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB5;
	}

	public Entry<EList<CA5>, EList<CB5>> getMapca0tocb0mapentry() {
		if (eContainerFeatureID() != TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY)
			return null;
		return (Entry<EList<CA5>, EList<CB5>>) eInternalContainer();
	}

	public NotificationChain basicSetMapca0tocb0mapentry(
			Entry<EList<CA5>, EList<CB5>> newMapca0tocb0mapentry, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newMapca0tocb0mapentry, TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY, msgs);
		return msgs;
	}

	public void setMapca0tocb0mapentry(Entry<EList<CA5>, EList<CB5>> newMapca0tocb0mapentry) {
		if (newMapca0tocb0mapentry != eInternalContainer() || (eContainerFeatureID() != TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY && newMapca0tocb0mapentry != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newMapca0tocb0mapentry))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMapca0tocb0mapentry != null)
				msgs = ((InternalEObject) newMapca0tocb0mapentry).eInverseAdd(this, TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE, Entry.class, msgs);
			msgs = basicSetMapca0tocb0mapentry(newMapca0tocb0mapentry, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY, newMapca0tocb0mapentry, newMapca0tocb0mapentry));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMapca0tocb0mapentry((Entry) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				return basicSetMapca0tocb0mapentry(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				return eInternalContainer().eInverseRemove(this, TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE, Entry.class, msgs); // E
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				return getMapca0tocb0mapentry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				setMapca0tocb0mapentry((Entry<EList<CA5>, EList<CB5>>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				setMapca0tocb0mapentry((Entry<EList<CA5>, EList<CB5>>) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY :
				return getMapca0tocb0mapentry() != null;
		}
		return super.eIsSet(featureID);
	}
}
