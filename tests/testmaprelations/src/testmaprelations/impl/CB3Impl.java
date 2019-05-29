/**
 */
package testmaprelations.impl;

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

import testmaprelations.CA3;
import testmaprelations.CB3;
import testmaprelations.TestmaprelationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CB3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.impl.CB3Impl#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CB3Impl extends MinimalEObjectImpl.Container implements CB3 {
	/**
	 * The cached value of the '{@link #getMapca0tocb0mapentry() <em>Mapca0tocb0mapentry</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapca0tocb0mapentry()
	 * @generated
	 * @ordered
	 */
	protected EList<Map.Entry<EList<CA3>, EList<CB3>>> mapca0tocb0mapentry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CB3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Map.Entry<EList<CA3>, EList<CB3>>> getMapca0tocb0mapentry() {
		if (mapca0tocb0mapentry == null) {
			mapca0tocb0mapentry = new EObjectWithInverseResolvingEList.ManyInverse<Map.Entry<EList<CA3>, EList<CB3>>>(Entry.class, this, TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY, TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY__VALUE);
		}
		return mapca0tocb0mapentry;
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
			case TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMapca0tocb0mapentry()).basicAdd(otherEnd, msgs);
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
			case TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY:
				return ((InternalEList<?>)getMapca0tocb0mapentry()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY:
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
			case TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY:
				getMapca0tocb0mapentry().clear();
				getMapca0tocb0mapentry().addAll((Collection<? extends Map.Entry<EList<CA3>, EList<CB3>>>) newValue);
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
			case TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY:
				getMapca0tocb0mapentry().clear();
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
			case TestmaprelationsPackage.CB3__MAPCA0TOCB0MAPENTRY:
				return mapca0tocb0mapentry != null && !mapca0tocb0mapentry.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CB3Impl
