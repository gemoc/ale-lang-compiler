package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "EvalFunRes"
)
public class EvalFunResImpl extends EvalResImpl {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected ExprImpl exp;

	protected CtxImpl ctx;

	protected EvalFunResImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EVAL_FUN_RES;
	}

	@TruffleBoundary
	public ExprImpl getExp() {
		if (exp != null && exp.eIsProxy()) {
			InternalEObject oldExp = (InternalEObject) exp;
			exp = (ExprImpl) eResolveProxy(oldExp);
			if (exp != oldExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
			}
		}
		return exp;
	}

	public ExprImpl basicGetExp() {
		return exp;
	}

	@TruffleBoundary
	public void setExp(ExprImpl newExp) {
		ExprImpl oldExp = exp;
		exp = newExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
	}

	@TruffleBoundary
	public CtxImpl getCtx() {
		if (ctx != null && ctx.eIsProxy()) {
			InternalEObject oldCtx = (InternalEObject) ctx;
			ctx = (CtxImpl) eResolveProxy(oldCtx);
			if (ctx != oldCtx) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
			}
		}
		return ctx;
	}

	public CtxImpl basicGetCtx() {
		return ctx;
	}

	@TruffleBoundary
	public void setCtx(CtxImpl newCtx) {
		CtxImpl oldCtx = ctx;
		ctx = newCtx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
	}

	@TruffleBoundary
	public String getName() {
		return name;
	}

	@TruffleBoundary
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__NAME, oldName, name));
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP :
				setExp((ExprImpl) newValue);
				return;
			case BoaPackage.EVAL_FUN_RES__CTX :
				setCtx((CtxImpl) newValue);
				return;
			case BoaPackage.EVAL_FUN_RES__NAME :
				setName((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.EVAL_FUN_RES__EXP :
				setExp((ExprImpl) null);
				return;
			case BoaPackage.EVAL_FUN_RES__CTX :
				setCtx((CtxImpl) null);
				return;
			case BoaPackage.EVAL_FUN_RES__NAME :
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
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
