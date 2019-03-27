/**
 */
package testbidirectionalrelation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptCImpl#getConceptb <em>Conceptb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
	/**
	 * The cached value of the '{@link #getConceptb() <em>Conceptb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb()
	 * @generated
	 * @ordered
	 */
	protected ConceptB conceptb;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB getConceptb() {
		if (conceptb != null && conceptb.eIsProxy()) {
			InternalEObject oldConceptb = (InternalEObject)conceptb;
			conceptb = (ConceptB)eResolveProxy(oldConceptb);
			if (conceptb != oldConceptb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, oldConceptb, conceptb));
			}
		}
		return conceptb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB basicGetConceptb() {
		return conceptb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConceptb(ConceptB newConceptb, NotificationChain msgs) {
		ConceptB oldConceptb = conceptb;
		conceptb = newConceptb;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, oldConceptb, newConceptb);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptb(ConceptB newConceptb) {
		if (newConceptb != conceptb) {
			NotificationChain msgs = null;
			if (conceptb != null)
				msgs = ((InternalEObject)conceptb).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, ConceptB.class, msgs);
			if (newConceptb != null)
				msgs = ((InternalEObject)newConceptb).eInverseAdd(this, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, ConceptB.class, msgs);
			msgs = basicSetConceptb(newConceptb, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, newConceptb, newConceptb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB:
				if (conceptb != null)
					msgs = ((InternalEObject)conceptb).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, ConceptB.class, msgs);
				return basicSetConceptb((ConceptB)otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB:
				return basicSetConceptb(null, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB:
				if (resolve) return getConceptb();
				return basicGetConceptb();
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
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB:
				setConceptb((ConceptB)newValue);
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
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB:
				setConceptb((ConceptB)null);
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
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB:
				return conceptb != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptCImpl
