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

import testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept F</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptFImpl#getConceptg <em>Conceptg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptFImpl extends MinimalEObjectImpl.Container implements ConceptF {
	/**
	 * The cached value of the '{@link #getConceptg() <em>Conceptg</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptg()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptG> conceptg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptFImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_F;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptG> getConceptg() {
		if (conceptg == null) {
			conceptg = new EObjectWithInverseResolvingEList.ManyInverse<ConceptG>(ConceptG.class, this, TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG, TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF);
		}
		return conceptg;
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
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConceptg()).basicAdd(otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG:
				return ((InternalEList<?>)getConceptg()).basicRemove(otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG:
				return getConceptg();
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
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG:
				getConceptg().clear();
				getConceptg().addAll((Collection<? extends ConceptG>)newValue);
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
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG:
				getConceptg().clear();
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
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG:
				return conceptg != null && !conceptg.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptFImpl
