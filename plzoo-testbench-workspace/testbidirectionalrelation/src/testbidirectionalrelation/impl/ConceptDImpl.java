/**
 */
package testbidirectionalrelation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptDImpl#getConcepte <em>Concepte</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptDImpl extends MinimalEObjectImpl.Container implements ConceptD {
	/**
	 * The cached value of the '{@link #getConcepte() <em>Concepte</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcepte()
	 * @generated
	 * @ordered
	 */
	protected ConceptE concepte;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptE getConcepte() {
		if (concepte != null && concepte.eIsProxy()) {
			InternalEObject oldConcepte = (InternalEObject)concepte;
			concepte = (ConceptE)eResolveProxy(oldConcepte);
			if (concepte != oldConcepte) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE, oldConcepte, concepte));
			}
		}
		return concepte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptE basicGetConcepte() {
		return concepte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcepte(ConceptE newConcepte, NotificationChain msgs) {
		ConceptE oldConcepte = concepte;
		concepte = newConcepte;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE, oldConcepte, newConcepte);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcepte(ConceptE newConcepte) {
		if (newConcepte != concepte) {
			NotificationChain msgs = null;
			if (concepte != null)
				msgs = ((InternalEObject)concepte).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, ConceptE.class, msgs);
			if (newConcepte != null)
				msgs = ((InternalEObject)newConcepte).eInverseAdd(this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, ConceptE.class, msgs);
			msgs = basicSetConcepte(newConcepte, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE, newConcepte, newConcepte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE:
				if (concepte != null)
					msgs = ((InternalEObject)concepte).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, ConceptE.class, msgs);
				return basicSetConcepte((ConceptE)otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE:
				return basicSetConcepte(null, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE:
				if (resolve) return getConcepte();
				return basicGetConcepte();
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
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE:
				setConcepte((ConceptE)newValue);
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
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE:
				setConcepte((ConceptE)null);
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
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE:
				return concepte != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptDImpl
