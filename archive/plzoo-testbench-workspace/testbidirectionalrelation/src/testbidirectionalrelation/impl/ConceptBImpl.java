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
 * An implementation of the model object '<em><b>Concept B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptBImpl#getConceptc <em>Conceptc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptBImpl extends MinimalEObjectImpl.Container implements ConceptB {
	/**
	 * The cached value of the '{@link #getConceptc() <em>Conceptc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptc()
	 * @generated
	 * @ordered
	 */
	protected ConceptC conceptc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptC getConceptc() {
		if (conceptc != null && conceptc.eIsProxy()) {
			InternalEObject oldConceptc = (InternalEObject)conceptc;
			conceptc = (ConceptC)eResolveProxy(oldConceptc);
			if (conceptc != oldConceptc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, oldConceptc, conceptc));
			}
		}
		return conceptc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptC basicGetConceptc() {
		return conceptc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConceptc(ConceptC newConceptc, NotificationChain msgs) {
		ConceptC oldConceptc = conceptc;
		conceptc = newConceptc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, oldConceptc, newConceptc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptc(ConceptC newConceptc) {
		if (newConceptc != conceptc) {
			NotificationChain msgs = null;
			if (conceptc != null)
				msgs = ((InternalEObject)conceptc).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, ConceptC.class, msgs);
			if (newConceptc != null)
				msgs = ((InternalEObject)newConceptc).eInverseAdd(this, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, ConceptC.class, msgs);
			msgs = basicSetConceptc(newConceptc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, newConceptc, newConceptc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC:
				if (conceptc != null)
					msgs = ((InternalEObject)conceptc).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, ConceptC.class, msgs);
				return basicSetConceptc((ConceptC)otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC:
				return basicSetConceptc(null, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC:
				if (resolve) return getConceptc();
				return basicGetConceptc();
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
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC:
				setConceptc((ConceptC)newValue);
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
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC:
				setConceptc((ConceptC)null);
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
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC:
				return conceptc != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptBImpl
