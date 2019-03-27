/**
 */
package test1.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import test1.ConceptA;
import test1.Test1uniquePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test1.impl.ConceptAImpl#getBs <em>Bs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	/**
	 * The cached value of the '{@link #getBs() <em>Bs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBs()
	 * @generated
	 * @ordered
	 */
	protected EList<Boolean> bs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Test1uniquePackage.Literals.CONCEPT_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Boolean> getBs() {
		if (bs == null) {
			bs = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, Test1uniquePackage.CONCEPT_A__BS);
		}
		return bs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1uniquePackage.CONCEPT_A__BS:
				return getBs();
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
			case Test1uniquePackage.CONCEPT_A__BS:
				getBs().clear();
				getBs().addAll((Collection<? extends Boolean>)newValue);
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
			case Test1uniquePackage.CONCEPT_A__BS:
				getBs().clear();
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
			case Test1uniquePackage.CONCEPT_A__BS:
				return bs != null && !bs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (bs: ");
		result.append(bs);
		result.append(')');
		return result.toString();
	}

} //ConceptAImpl
