package testmaprelations.visitor.testmaprelations.impl;

import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import testmaprelations.visitor.testmaprelations.CA4;
import testmaprelations.visitor.testmaprelations.CB4;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;
import visitor.VisitorInterface;

public class CB4Impl extends MinimalEObjectImpl.Container implements CB4 {
	protected CB4Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB4;
	}

	public Entry<CA4, CB4> getMapca0tocb0mapentry() {
		if (eContainerFeatureID() != TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY)
			return null;
		return (Entry<CA4, CB4>) eInternalContainer();
	}

	public NotificationChain basicSetMapca0tocb0mapentry(Entry<CA4, CB4> newMapca0tocb0mapentry,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newMapca0tocb0mapentry, TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY, msgs);
		return msgs;
	}

	public void setMapca0tocb0mapentry(Entry<CA4, CB4> newMapca0tocb0mapentry) {
		if (newMapca0tocb0mapentry != eInternalContainer() || (eContainerFeatureID() != TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY && newMapca0tocb0mapentry != null)) {
			if (EcoreUtil.isAncestor(this, (EObject) newMapca0tocb0mapentry))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMapca0tocb0mapentry != null)
				msgs = ((InternalEObject) newMapca0tocb0mapentry).eInverseAdd(this, TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE, Entry.class, msgs);
			msgs = basicSetMapca0tocb0mapentry(newMapca0tocb0mapentry, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY, newMapca0tocb0mapentry, newMapca0tocb0mapentry));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMapca0tocb0mapentry((Entry<CA4, CB4>) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				return basicSetMapca0tocb0mapentry(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				return eInternalContainer().eInverseRemove(this, TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY__VALUE, Entry.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				return getMapca0tocb0mapentry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				setMapca0tocb0mapentry((Entry<CA4, CB4>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				setMapca0tocb0mapentry((Entry<CA4, CB4>) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB4__MAPCA0TOCB0MAPENTRY :
				return getMapca0tocb0mapentry() != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestmaprelations__CB4(this);
	}
}
