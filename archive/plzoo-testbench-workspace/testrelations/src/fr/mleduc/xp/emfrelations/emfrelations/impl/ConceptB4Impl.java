/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA4;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB4;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept B4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptB4Impl#getConcepta4 <em>Concepta4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptB4Impl extends MinimalEObjectImpl.Container implements ConceptB4 {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptB4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA4 getConcepta4() {
		if (eContainerFeatureID() != EmfrelationsPackage.CONCEPT_B4__CONCEPTA4) return null;
		return (ConceptA4)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcepta4(ConceptA4 newConcepta4, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConcepta4, EmfrelationsPackage.CONCEPT_B4__CONCEPTA4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcepta4(ConceptA4 newConcepta4) {
		if (newConcepta4 != eInternalContainer() || (eContainerFeatureID() != EmfrelationsPackage.CONCEPT_B4__CONCEPTA4 && newConcepta4 != null)) {
			if (EcoreUtil.isAncestor(this, newConcepta4))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConcepta4 != null)
				msgs = ((InternalEObject)newConcepta4).eInverseAdd(this, EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, ConceptA4.class, msgs);
			msgs = basicSetConcepta4(newConcepta4, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B4__CONCEPTA4, newConcepta4, newConcepta4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConcepta4((ConceptA4)otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				return basicSetConcepta4(null, msgs);
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
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				return eInternalContainer().eInverseRemove(this, EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, ConceptA4.class, msgs);
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
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				return getConcepta4();
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
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				setConcepta4((ConceptA4)newValue);
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
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				setConcepta4((ConceptA4)null);
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
			case EmfrelationsPackage.CONCEPT_B4__CONCEPTA4:
				return getConcepta4() != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptB4Impl
