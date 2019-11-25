/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA11;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB11;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A11</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptA11Impl#getConceptb11 <em>Conceptb11</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptA11Impl extends MinimalEObjectImpl.Container implements ConceptA11 {
	/**
	 * The cached value of the '{@link #getConceptb11() <em>Conceptb11</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb11()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptB11> conceptb11;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptA11Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptB11> getConceptb11() {
		if (conceptb11 == null) {
			conceptb11 = new EObjectContainmentEList<ConceptB11>(ConceptB11.class, this, EmfrelationsPackage.CONCEPT_A11__CONCEPTB11);
		}
		return conceptb11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11:
				return ((InternalEList<?>)getConceptb11()).basicRemove(otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11:
				return getConceptb11();
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
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11:
				getConceptb11().clear();
				getConceptb11().addAll((Collection<? extends ConceptB11>)newValue);
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
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11:
				getConceptb11().clear();
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
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11:
				return conceptb11 != null && !conceptb11.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptA11Impl
