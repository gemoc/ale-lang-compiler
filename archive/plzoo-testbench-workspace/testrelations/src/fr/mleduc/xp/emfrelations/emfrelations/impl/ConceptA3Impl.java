/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA3;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB3;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptA3Impl#getConceptb3 <em>Conceptb3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptA3Impl extends MinimalEObjectImpl.Container implements ConceptA3 {
	/**
	 * The cached value of the '{@link #getConceptb3() <em>Conceptb3</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb3()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptB3> conceptb3;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptA3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptB3> getConceptb3() {
		if (conceptb3 == null) {
			conceptb3 = new EObjectWithInverseResolvingEList.ManyInverse<ConceptB3>(ConceptB3.class, this, EmfrelationsPackage.CONCEPT_A3__CONCEPTB3, EmfrelationsPackage.CONCEPT_B3__CONCEPTA3);
		}
		return conceptb3;
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
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConceptb3()).basicAdd(otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3:
				return ((InternalEList<?>)getConceptb3()).basicRemove(otherEnd, msgs);
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
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3:
				return getConceptb3();
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
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3:
				getConceptb3().clear();
				getConceptb3().addAll((Collection<? extends ConceptB3>)newValue);
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
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3:
				getConceptb3().clear();
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
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3:
				return conceptb3 != null && !conceptb3.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptA3Impl
