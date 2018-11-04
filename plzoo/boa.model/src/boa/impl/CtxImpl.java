/**
 */
package boa.impl;

import boa.BoaPackage;
import boa.Ctx;
import boa.EvalRes;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ctx</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link boa.impl.CtxImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link boa.impl.CtxImpl#getTh <em>Th</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CtxImpl extends MinimalEObjectImpl.Container implements Ctx {
	/**
	 * The cached value of the '{@link #getEnv() <em>Env</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnv()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EvalRes> env;

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
	protected CtxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CTX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EvalRes> getEnv() {
		if (env == null) {
			env = new EcoreEMap<String,EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__ENV);
		}
		return env;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EvalRes> getTh() {
		if (th == null) {
			th = new EcoreEMap<String,EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__TH);
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
			case BoaPackage.CTX__ENV:
				return ((InternalEList<?>)getEnv()).basicRemove(otherEnd, msgs);
			case BoaPackage.CTX__TH:
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
			case BoaPackage.CTX__ENV:
				if (coreType) return getEnv();
				else return getEnv().map();
			case BoaPackage.CTX__TH:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.CTX__ENV:
				((EStructuralFeature.Setting)getEnv()).set(newValue);
				return;
			case BoaPackage.CTX__TH:
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
			case BoaPackage.CTX__ENV:
				getEnv().clear();
				return;
			case BoaPackage.CTX__TH:
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
			case BoaPackage.CTX__ENV:
				return env != null && !env.isEmpty();
			case BoaPackage.CTX__TH:
				return th != null && !th.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CtxImpl
