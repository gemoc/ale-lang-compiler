/**
 */
package boa.impl;

import boa.BoaPackage;
import boa.Ctx;
import boa.EvalFunRes;
import boa.Expr;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eval Fun Res</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link boa.impl.EvalFunResImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link boa.impl.EvalFunResImpl#getCtx <em>Ctx</em>}</li>
 *   <li>{@link boa.impl.EvalFunResImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EvalFunResImpl extends EvalResImpl implements EvalFunRes {
	/**
	 * The cached value of the '{@link #getExp() <em>Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected Expr exp;

	/**
	 * The cached value of the '{@link #getCtx() <em>Ctx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCtx()
	 * @generated
	 * @ordered
	 */
	protected Ctx ctx;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvalFunResImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EVAL_FUN_RES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getExp() {
		if (exp != null && exp.eIsProxy()) {
			InternalEObject oldExp = (InternalEObject)exp;
			exp = (Expr)eResolveProxy(oldExp);
			if (exp != oldExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
			}
		}
		return exp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr basicGetExp() {
		return exp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExp(Expr newExp) {
		Expr oldExp = exp;
		exp = newExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ctx getCtx() {
		if (ctx != null && ctx.eIsProxy()) {
			InternalEObject oldCtx = (InternalEObject)ctx;
			ctx = (Ctx)eResolveProxy(oldCtx);
			if (ctx != oldCtx) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
			}
		}
		return ctx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ctx basicGetCtx() {
		return ctx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCtx(Ctx newCtx) {
		Ctx oldCtx = ctx;
		ctx = newCtx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP:
				if (resolve) return getExp();
				return basicGetExp();
			case BoaPackage.EVAL_FUN_RES__CTX:
				if (resolve) return getCtx();
				return basicGetCtx();
			case BoaPackage.EVAL_FUN_RES__NAME:
				return getName();
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
			case BoaPackage.EVAL_FUN_RES__EXP:
				setExp((Expr)newValue);
				return;
			case BoaPackage.EVAL_FUN_RES__CTX:
				setCtx((Ctx)newValue);
				return;
			case BoaPackage.EVAL_FUN_RES__NAME:
				setName((String)newValue);
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
			case BoaPackage.EVAL_FUN_RES__EXP:
				setExp((Expr)null);
				return;
			case BoaPackage.EVAL_FUN_RES__CTX:
				setCtx((Ctx)null);
				return;
			case BoaPackage.EVAL_FUN_RES__NAME:
				setName(NAME_EDEFAULT);
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
			case BoaPackage.EVAL_FUN_RES__EXP:
				return exp != null;
			case BoaPackage.EVAL_FUN_RES__CTX:
				return ctx != null;
			case BoaPackage.EVAL_FUN_RES__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EvalFunResImpl
