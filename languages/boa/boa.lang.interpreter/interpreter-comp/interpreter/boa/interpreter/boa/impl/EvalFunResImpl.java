package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalFunRes;
import interpreter.boa.interpreter.boa.Expr;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class EvalFunResImpl extends EvalResImpl implements EvalFunRes {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected Expr exp;

	protected Ctx ctx;

	protected EvalFunResImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EVAL_FUN_RES;
	}

	public Expr getExp() {
		if (exp != null && exp.eIsProxy()) {
			InternalEObject oldExp = (InternalEObject) exp;
			exp = (Expr) eResolveProxy(oldExp);
			if (exp != oldExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
			}
		}
		return exp;
	}

	public Expr basicGetExp() {
		return exp;
	}

	public void setExp(Expr newExp) {
		Expr oldExp = exp;
		exp = newExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
	}

	public Ctx getCtx() {
		if (ctx != null && ctx.eIsProxy()) {
			InternalEObject oldCtx = (InternalEObject) ctx;
			ctx = (Ctx) eResolveProxy(oldCtx);
			if (ctx != oldCtx) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
			}
		}
		return ctx;
	}

	public Ctx basicGetCtx() {
		return ctx;
	}

	public void setCtx(Ctx newCtx) {
		Ctx oldCtx = ctx;
		ctx = newCtx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__NAME, oldName, name));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP :
				if (resolve)
					return getExp();
				return basicGetExp();
			case BoaPackage.EVAL_FUN_RES__CTX :
				if (resolve)
					return getCtx();
				return basicGetCtx();
			case BoaPackage.EVAL_FUN_RES__NAME :
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP :
				setExp((Expr) newValue);
				return;
			case BoaPackage.EVAL_FUN_RES__CTX :
				setCtx((Ctx) newValue);
				return;
			case BoaPackage.EVAL_FUN_RES__NAME :
				setName((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP :
				setExp((Expr) null);
				return;
			case BoaPackage.EVAL_FUN_RES__CTX :
				setCtx((Ctx) null);
				return;
			case BoaPackage.EVAL_FUN_RES__NAME :
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP :
				return exp != null;
			case BoaPackage.EVAL_FUN_RES__CTX :
				return ctx != null;
			case BoaPackage.EVAL_FUN_RES__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}
}
