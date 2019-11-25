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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptA4Impl#getConceptb4 <em>Conceptb4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptA4Impl extends MinimalEObjectImpl.Container implements ConceptA4 {
	/**
	 * The cached value of the '{@link #getConceptb4() <em>Conceptb4</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb4()
	 * @generated
	 * @ordered
	 */
	protected ConceptB4 conceptb4;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptA4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB4 getConceptb4() {
		return conceptb4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConceptb4(ConceptB4 newConceptb4, NotificationChain msgs) {
		ConceptB4 oldConceptb4 = conceptb4;
		conceptb4 = newConceptb4;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, oldConceptb4, newConceptb4);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptb4(ConceptB4 newConceptb4) {
		if (newConceptb4 != conceptb4) {
			NotificationChain msgs = null;
			if (conceptb4 != null)
				msgs = ((InternalEObject)conceptb4).eInverseRemove(this, EmfrelationsPackage.CONCEPT_B4__CONCEPTA4, ConceptB4.class, msgs);
			if (newConceptb4 != null)
				msgs = ((InternalEObject)newConceptb4).eInverseAdd(this, EmfrelationsPackage.CONCEPT_B4__CONCEPTA4, ConceptB4.class, msgs);
			msgs = basicSetConceptb4(newConceptb4, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, newConceptb4, newConceptb4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4:
				if (conceptb4 != null)
					msgs = ((InternalEObject)conceptb4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, null, msgs);
				return basicSetConceptb4((ConceptB4)otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4:
				return basicSetConceptb4(null, msgs);
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
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4:
				return getConceptb4();
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
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4:
				setConceptb4((ConceptB4)newValue);
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
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4:
				setConceptb4((ConceptB4)null);
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
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4:
				return conceptb4 != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptA4Impl
