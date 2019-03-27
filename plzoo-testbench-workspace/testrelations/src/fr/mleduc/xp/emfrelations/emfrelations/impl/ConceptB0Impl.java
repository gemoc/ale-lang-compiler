/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA0;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB0;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept B0</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptB0Impl#getConcepta0 <em>Concepta0</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptB0Impl extends MinimalEObjectImpl.Container implements ConceptB0 {
	/**
	 * The cached value of the '{@link #getConcepta0() <em>Concepta0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcepta0()
	 * @generated
	 * @ordered
	 */
	protected ConceptA0 concepta0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptB0Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA0 getConcepta0() {
		if (concepta0 != null && concepta0.eIsProxy()) {
			InternalEObject oldConcepta0 = (InternalEObject)concepta0;
			concepta0 = (ConceptA0)eResolveProxy(oldConcepta0);
			if (concepta0 != oldConcepta0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, oldConcepta0, concepta0));
			}
		}
		return concepta0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA0 basicGetConcepta0() {
		return concepta0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcepta0(ConceptA0 newConcepta0, NotificationChain msgs) {
		ConceptA0 oldConcepta0 = concepta0;
		concepta0 = newConcepta0;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, oldConcepta0, newConcepta0);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcepta0(ConceptA0 newConcepta0) {
		if (newConcepta0 != concepta0) {
			NotificationChain msgs = null;
			if (concepta0 != null)
				msgs = ((InternalEObject)concepta0).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, ConceptA0.class, msgs);
			if (newConcepta0 != null)
				msgs = ((InternalEObject)newConcepta0).eInverseAdd(this, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, ConceptA0.class, msgs);
			msgs = basicSetConcepta0(newConcepta0, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, newConcepta0, newConcepta0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0:
				if (concepta0 != null)
					msgs = ((InternalEObject)concepta0).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, ConceptA0.class, msgs);
				return basicSetConcepta0((ConceptA0)otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0:
				return basicSetConcepta0(null, msgs);
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
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0:
				if (resolve) return getConcepta0();
				return basicGetConcepta0();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0:
				setConcepta0((ConceptA0)newValue);
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
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0:
				setConcepta0((ConceptA0)null);
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
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0:
				return concepta0 != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptB0Impl
