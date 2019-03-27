/**
 */
package x.y.z.functioncall.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.ConceptC;
import x.y.z.functioncall.FunctioncallPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link x.y.z.functioncall.impl.ConceptCImpl#getConcepta2 <em>Concepta2</em>}</li>
 *   <li>{@link x.y.z.functioncall.impl.ConceptCImpl#getConcepta1 <em>Concepta1</em>}</li>
 *   <li>{@link x.y.z.functioncall.impl.ConceptCImpl#getConceptb <em>Conceptb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
	/**
	 * The cached value of the '{@link #getConcepta2() <em>Concepta2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcepta2()
	 * @generated
	 * @ordered
	 */
	protected ConceptA concepta2;

	/**
	 * The cached value of the '{@link #getConcepta1() <em>Concepta1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcepta1()
	 * @generated
	 * @ordered
	 */
	protected ConceptA concepta1;

	/**
	 * The cached value of the '{@link #getConceptb() <em>Conceptb</em>}' containment reference.
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
		return FunctioncallPackage.Literals.CONCEPT_C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA getConcepta2() {
		return concepta2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcepta2(ConceptA newConcepta2, NotificationChain msgs) {
		ConceptA oldConcepta2 = concepta2;
		concepta2 = newConcepta2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctioncallPackage.CONCEPT_C__CONCEPTA2, oldConcepta2, newConcepta2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcepta2(ConceptA newConcepta2) {
		if (newConcepta2 != concepta2) {
			NotificationChain msgs = null;
			if (concepta2 != null)
				msgs = ((InternalEObject)concepta2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctioncallPackage.CONCEPT_C__CONCEPTA2, null, msgs);
			if (newConcepta2 != null)
				msgs = ((InternalEObject)newConcepta2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctioncallPackage.CONCEPT_C__CONCEPTA2, null, msgs);
			msgs = basicSetConcepta2(newConcepta2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctioncallPackage.CONCEPT_C__CONCEPTA2, newConcepta2, newConcepta2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA getConcepta1() {
		return concepta1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcepta1(ConceptA newConcepta1, NotificationChain msgs) {
		ConceptA oldConcepta1 = concepta1;
		concepta1 = newConcepta1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctioncallPackage.CONCEPT_C__CONCEPTA1, oldConcepta1, newConcepta1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcepta1(ConceptA newConcepta1) {
		if (newConcepta1 != concepta1) {
			NotificationChain msgs = null;
			if (concepta1 != null)
				msgs = ((InternalEObject)concepta1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctioncallPackage.CONCEPT_C__CONCEPTA1, null, msgs);
			if (newConcepta1 != null)
				msgs = ((InternalEObject)newConcepta1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctioncallPackage.CONCEPT_C__CONCEPTA1, null, msgs);
			msgs = basicSetConcepta1(newConcepta1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctioncallPackage.CONCEPT_C__CONCEPTA1, newConcepta1, newConcepta1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptB getConceptb() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctioncallPackage.CONCEPT_C__CONCEPTB, oldConceptb, newConceptb);
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
				msgs = ((InternalEObject)conceptb).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctioncallPackage.CONCEPT_C__CONCEPTB, null, msgs);
			if (newConceptb != null)
				msgs = ((InternalEObject)newConceptb).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctioncallPackage.CONCEPT_C__CONCEPTB, null, msgs);
			msgs = basicSetConceptb(newConceptb, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctioncallPackage.CONCEPT_C__CONCEPTB, newConceptb, newConceptb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2:
				return basicSetConcepta2(null, msgs);
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1:
				return basicSetConcepta1(null, msgs);
			case FunctioncallPackage.CONCEPT_C__CONCEPTB:
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
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2:
				return getConcepta2();
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1:
				return getConcepta1();
			case FunctioncallPackage.CONCEPT_C__CONCEPTB:
				return getConceptb();
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
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2:
				setConcepta2((ConceptA)newValue);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1:
				setConcepta1((ConceptA)newValue);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTB:
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
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2:
				setConcepta2((ConceptA)null);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1:
				setConcepta1((ConceptA)null);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTB:
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
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2:
				return concepta2 != null;
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1:
				return concepta1 != null;
			case FunctioncallPackage.CONCEPT_C__CONCEPTB:
				return conceptb != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptCImpl
