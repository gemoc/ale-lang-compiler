/**
 */
package testmaprelations.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import testmaprelations.CA5;
import testmaprelations.CB5;
import testmaprelations.TestmaprelationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CB5</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.impl.CB5Impl#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CB5Impl extends MinimalEObjectImpl.Container implements CB5 {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CB5Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Map.Entry<EList<CA5>, EList<CB5>> getMapca0tocb0mapentry() {
		if (eContainerFeatureID() != TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY) return null;
		return (Map.Entry<EList<CA5>, EList<CB5>>)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapca0tocb0mapentry(Map.Entry<EList<CA5>, EList<CB5>> newMapca0tocb0mapentry, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMapca0tocb0mapentry, TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapca0tocb0mapentry(Map.Entry<EList<CA5>, EList<CB5>> newMapca0tocb0mapentry) {
		if (newMapca0tocb0mapentry != eInternalContainer() || (eContainerFeatureID() != TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY && newMapca0tocb0mapentry != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newMapca0tocb0mapentry))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMapca0tocb0mapentry != null)
				msgs = ((InternalEObject)newMapca0tocb0mapentry).eInverseAdd(this, TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE, Map.Entry.class, msgs);
			msgs = basicSetMapca0tocb0mapentry(newMapca0tocb0mapentry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY, newMapca0tocb0mapentry, newMapca0tocb0mapentry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMapca0tocb0mapentry((Map.Entry<EList<CA5>, EList<CB5>>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				return basicSetMapca0tocb0mapentry(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				return eInternalContainer().eInverseRemove(this, TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE, Map.Entry.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				return getMapca0tocb0mapentry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				setMapca0tocb0mapentry((Map.Entry<EList<CA5>, EList<CB5>>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				setMapca0tocb0mapentry((Map.Entry<EList<CA5>, EList<CB5>>)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY:
				return getMapca0tocb0mapentry() != null;
		}
		return super.eIsSet(featureID);
	}

} //CB5Impl
