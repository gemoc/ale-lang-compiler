/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA1;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB1;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept B1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptB1Impl#getConcepta1 <em>Concepta1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptB1Impl extends MinimalEObjectImpl.Container implements ConceptB1 {
	/**
	 * The cached value of the '{@link #getConcepta1() <em>Concepta1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcepta1()
	 * @generated
	 * @ordered
	 */
	protected ConceptA1 concepta1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptB1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA1 getConcepta1() {
		if (concepta1 != null && concepta1.eIsProxy()) {
			InternalEObject oldConcepta1 = (InternalEObject)concepta1;
			concepta1 = (ConceptA1)eResolveProxy(oldConcepta1);
			if (concepta1 != oldConcepta1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1, oldConcepta1, concepta1));
			}
		}
		return concepta1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA1 basicGetConcepta1() {
		return concepta1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcepta1(ConceptA1 newConcepta1, NotificationChain msgs) {
		ConceptA1 oldConcepta1 = concepta1;
		concepta1 = newConcepta1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1, oldConcepta1, newConcepta1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcepta1(ConceptA1 newConcepta1) {
		if (newConcepta1 != concepta1) {
			NotificationChain msgs = null;
			if (concepta1 != null)
				msgs = ((InternalEObject)concepta1).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, ConceptA1.class, msgs);
			if (newConcepta1 != null)
				msgs = ((InternalEObject)newConcepta1).eInverseAdd(this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, ConceptA1.class, msgs);
			msgs = basicSetConcepta1(newConcepta1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1, newConcepta1, newConcepta1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1:
				if (concepta1 != null)
					msgs = ((InternalEObject)concepta1).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, ConceptA1.class, msgs);
				return basicSetConcepta1((ConceptA1)otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1:
				return basicSetConcepta1(null, msgs);
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
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1:
				if (resolve) return getConcepta1();
				return basicGetConcepta1();
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
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1:
				setConcepta1((ConceptA1)newValue);
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
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1:
				setConcepta1((ConceptA1)null);
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
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1:
				return concepta1 != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptB1Impl
