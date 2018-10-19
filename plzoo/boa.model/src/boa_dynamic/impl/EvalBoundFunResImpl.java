/**
 */
package boa_dynamic.impl;

import boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.EvalBoundFunRes;

import boa_dynamic.EvalRes;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eval Bound Fun Res</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link boa_dynamic.impl.EvalBoundFunResImpl#getTh <em>Th</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EvalBoundFunResImpl extends EvalFunResImpl implements EvalBoundFunRes {
	/**
	 * The cached value of the '{@link #getTh() <em>Th</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTh()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EvalRes> th;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvalBoundFunResImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Boa_dynamicPackage.Literals.EVAL_BOUND_FUN_RES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EvalRes> getTh() {
		if (th == null) {
			th = new EcoreEMap<String,EvalRes>(Boa_dynamicPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH);
		}
		return th;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
				return ((InternalEList<?>)getTh()).basicRemove(otherEnd, msgs);
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
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
				if (coreType) return getTh();
				else return getTh().map();
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
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
				((EStructuralFeature.Setting)getTh()).set(newValue);
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
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
				getTh().clear();
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
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
				return th != null && !th.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EvalBoundFunResImpl
