/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA2;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB2;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptA2Impl#getConceptb2 <em>Conceptb2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptA2Impl extends MinimalEObjectImpl.Container implements ConceptA2 {
	/**
	 * The cached value of the '{@link #getConceptb2() <em>Conceptb2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb2()
	 * @generated
	 * @ordered
	 */
	protected ConceptB2 conceptb2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptA2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB2 getConceptb2() {
		if (conceptb2 != null && conceptb2.eIsProxy()) {
			InternalEObject oldConceptb2 = (InternalEObject)conceptb2;
			conceptb2 = (ConceptB2)eResolveProxy(oldConceptb2);
			if (conceptb2 != oldConceptb2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_A2__CONCEPTB2, oldConceptb2, conceptb2));
			}
		}
		return conceptb2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB2 basicGetConceptb2() {
		return conceptb2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConceptb2(ConceptB2 newConceptb2, NotificationChain msgs) {
		ConceptB2 oldConceptb2 = conceptb2;
		conceptb2 = newConceptb2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A2__CONCEPTB2, oldConceptb2, newConceptb2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptb2(ConceptB2 newConceptb2) {
		if (newConceptb2 != conceptb2) {
			NotificationChain msgs = null;
			if (conceptb2 != null)
				msgs = ((InternalEObject)conceptb2).eInverseRemove(this, EmfrelationsPackage.CONCEPT_B2__CONCEPTA2, ConceptB2.class, msgs);
			if (newConceptb2 != null)
				msgs = ((InternalEObject)newConceptb2).eInverseAdd(this, EmfrelationsPackage.CONCEPT_B2__CONCEPTA2, ConceptB2.class, msgs);
			msgs = basicSetConceptb2(newConceptb2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A2__CONCEPTB2, newConceptb2, newConceptb2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A2__CONCEPTB2:
				if (conceptb2 != null)
					msgs = ((InternalEObject)conceptb2).eInverseRemove(this, EmfrelationsPackage.CONCEPT_B2__CONCEPTA2, ConceptB2.class, msgs);
				return basicSetConceptb2((ConceptB2)otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_A2__CONCEPTB2:
				return basicSetConceptb2(null, msgs);
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
			case EmfrelationsPackage.CONCEPT_A2__CONCEPTB2:
				if (resolve) return getConceptb2();
				return basicGetConceptb2();
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
			case EmfrelationsPackage.CONCEPT_A2__CONCEPTB2:
				setConceptb2((ConceptB2)newValue);
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
			case EmfrelationsPackage.CONCEPT_A2__CONCEPTB2:
				setConceptb2((ConceptB2)null);
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
			case EmfrelationsPackage.CONCEPT_A2__CONCEPTB2:
				return conceptb2 != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptA2Impl
