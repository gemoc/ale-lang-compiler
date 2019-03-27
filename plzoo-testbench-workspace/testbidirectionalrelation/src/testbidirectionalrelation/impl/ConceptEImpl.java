/**
 */
package testbidirectionalrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptEImpl#getConceptd <em>Conceptd</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptEImpl extends MinimalEObjectImpl.Container implements ConceptE {
	/**
	 * The cached value of the '{@link #getConceptd() <em>Conceptd</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptd()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptD> conceptd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_E;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptD> getConceptd() {
		if (conceptd == null) {
			conceptd = new EObjectWithInverseResolvingEList<ConceptD>(ConceptD.class, this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE);
		}
		return conceptd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConceptd()).basicAdd(otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD:
				return ((InternalEList<?>)getConceptd()).basicRemove(otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD:
				return getConceptd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD:
				getConceptd().clear();
				getConceptd().addAll((Collection<? extends ConceptD>)newValue);
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
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD:
				getConceptd().clear();
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
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD:
				return conceptd != null && !conceptd.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptEImpl
