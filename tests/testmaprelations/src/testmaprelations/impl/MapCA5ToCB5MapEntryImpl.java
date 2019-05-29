/**
 */
package testmaprelations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testmaprelations.CA5;
import testmaprelations.CB5;
import testmaprelations.TestmaprelationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map CA5 To CB5 Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.impl.MapCA5ToCB5MapEntryImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link testmaprelations.impl.MapCA5ToCB5MapEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MapCA5ToCB5MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<EList<CA5>,EList<CB5>> {
	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected EList<CA5> key;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected EList<CB5> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapCA5ToCB5MapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA5_TO_CB5_MAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CA5> getTypedKey() {
		if (key == null) {
			key = new EObjectContainmentWithInverseEList<CA5>(CA5.class, this, TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY, TestmaprelationsPackage.CA5__MAPCA0TOCB0MAPENTRY);
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CB5> getTypedValue() {
		if (value == null) {
			value = new EObjectContainmentWithInverseEList<CB5>(CB5.class, this, TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE, TestmaprelationsPackage.CB5__MAPCA0TOCB0MAPENTRY);
		}
		return value;
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
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypedKey()).basicAdd(otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypedValue()).basicAdd(otherEnd, msgs);
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
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY:
				return ((InternalEList<?>)getTypedKey()).basicRemove(otherEnd, msgs);
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE:
				return ((InternalEList<?>)getTypedValue()).basicRemove(otherEnd, msgs);
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
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY:
				return getTypedKey();
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE:
				return getTypedValue();
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
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY:
				getTypedKey().clear();
				getTypedKey().addAll((Collection<? extends CA5>) newValue);
				return;
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE:
				getTypedValue().clear();
				getTypedValue().addAll((Collection<? extends CB5>) newValue);
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
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY:
				getTypedKey().clear();
				return;
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE:
				getTypedValue().clear();
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
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__KEY:
				return key != null && !key.isEmpty();
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY__VALUE:
				return value != null && !value.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int hash = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CA5> getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(EList<CA5> key) {
		getTypedKey().addAll(key);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CB5> getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CB5> setValue(EList<CB5> value) {
		EList<CB5> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<EList<CA5>, EList<CB5>> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<EList<CA5>, EList<CB5>>)container.eGet(eContainmentFeature());
	}

} //MapCA5ToCB5MapEntryImpl
