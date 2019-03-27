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
 * An implementation of the model object '<em><b>Concept G</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.impl.ConceptGImpl#getConceptf <em>Conceptf</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptGImpl extends MinimalEObjectImpl.Container implements ConceptG {
	/**
	 * The cached value of the '{@link #getConceptf() <em>Conceptf</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptf()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptF> conceptf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptGImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_G;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptF> getConceptf() {
		if (conceptf == null) {
			conceptf = new EObjectWithInverseResolvingEList.ManyInverse<ConceptF>(ConceptF.class, this, TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF, TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG);
		}
		return conceptf;
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
			case TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConceptf()).basicAdd(otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF:
				return ((InternalEList<?>)getConceptf()).basicRemove(otherEnd, msgs);
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
			case TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF:
				return getConceptf();
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
			case TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF:
				getConceptf().clear();
				getConceptf().addAll((Collection<? extends ConceptF>)newValue);
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
			case TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF:
				getConceptf().clear();
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
			case TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF:
				return conceptf != null && !conceptf.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptGImpl
