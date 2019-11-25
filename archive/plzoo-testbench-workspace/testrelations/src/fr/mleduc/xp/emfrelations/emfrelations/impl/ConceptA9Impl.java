/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA9;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB9;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A9</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.impl.ConceptA9Impl#getConceptb9 <em>Conceptb9</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptA9Impl extends MinimalEObjectImpl.Container implements ConceptA9 {
	/**
	 * The cached value of the '{@link #getConceptb9() <em>Conceptb9</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptb9()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptB9> conceptb9;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptA9Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptB9> getConceptb9() {
		if (conceptb9 == null) {
			conceptb9 = new EObjectResolvingEList<ConceptB9>(ConceptB9.class, this, EmfrelationsPackage.CONCEPT_A9__CONCEPTB9);
		}
		return conceptb9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9:
				return getConceptb9();
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
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9:
				getConceptb9().clear();
				getConceptb9().addAll((Collection<? extends ConceptB9>)newValue);
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
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9:
				getConceptb9().clear();
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
			case EmfrelationsPackage.CONCEPT_A9__CONCEPTB9:
				return conceptb9 != null && !conceptb9.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptA9Impl
