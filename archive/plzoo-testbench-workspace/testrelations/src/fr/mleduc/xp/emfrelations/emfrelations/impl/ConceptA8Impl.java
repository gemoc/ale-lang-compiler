/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA8;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB8;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A8</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptA8Impl#getConceptb8 <em>Conceptb8</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptA8Impl extends MinimalEObjectImpl.Container implements ConceptA8 {
	/**
	 * The cached value of the '{@link #getConceptb8() <em>Conceptb8</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb8()
	 * @generated
	 * @ordered
	 */
	protected ConceptB8 conceptb8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptA8Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB8 getConceptb8() {
		if (conceptb8 != null && conceptb8.eIsProxy()) {
			InternalEObject oldConceptb8 = (InternalEObject)conceptb8;
			conceptb8 = (ConceptB8)eResolveProxy(oldConceptb8);
			if (conceptb8 != oldConceptb8) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_A8__CONCEPTB8, oldConceptb8, conceptb8));
			}
		}
		return conceptb8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB8 basicGetConceptb8() {
		return conceptb8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptb8(ConceptB8 newConceptb8) {
		ConceptB8 oldConceptb8 = conceptb8;
		conceptb8 = newConceptb8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A8__CONCEPTB8, oldConceptb8, conceptb8));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8:
				if (resolve) return getConceptb8();
				return basicGetConceptb8();
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
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8:
				setConceptb8((ConceptB8)newValue);
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
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8:
				setConceptb8((ConceptB8)null);
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
			case EmfrelationsPackage.CONCEPT_A8__CONCEPTB8:
				return conceptb8 != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptA8Impl
