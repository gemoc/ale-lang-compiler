package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalFunRes;
import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
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

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  @TruffleBoundary
  public void setExp(Expr newExp) {
    Expr oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
  }

  @TruffleBoundary
  public Expr getExp() {
    if (exp != null && exp.eIsProxy()) {
    	InternalEObject oldexp = (InternalEObject) exp;
    	exp = (Expr) eResolveProxy(oldexp);
    	if (exp != oldexp) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__EXP,
    					oldexp, exp));
    	}
    }
    return exp;
  }

  @TruffleBoundary
  public void setCtx(Ctx newCtx) {
    Ctx oldCtx = ctx;
    ctx = newCtx;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
  }

  @TruffleBoundary
  public Ctx getCtx() {
    if (ctx != null && ctx.eIsProxy()) {
    	InternalEObject oldctx = (InternalEObject) ctx;
    	ctx = (Ctx) eResolveProxy(oldctx);
    	if (ctx != oldctx) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.EVAL_FUN_RES__CTX,
    					oldctx, ctx));
    	}
    }
    return ctx;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.EVAL_FUN_RES;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.EVAL_FUN_RES__EXP:
    	setExp((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.EVAL_FUN_RES__CTX:
    	setCtx((boa.interpreter.boa.Ctx) newValue);
    return;
    case BoaPackage.EVAL_FUN_RES__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_FUN_RES__EXP:
    	setExp((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.EVAL_FUN_RES__CTX:
    	setCtx((boa.interpreter.boa.Ctx) null);
    return;
    case BoaPackage.EVAL_FUN_RES__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.EVAL_FUN_RES__EXP:
    return getExp();
    case BoaPackage.EVAL_FUN_RES__CTX:
    return getCtx();
    case BoaPackage.EVAL_FUN_RES__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_FUN_RES__EXP:
    	return exp != null;
    case BoaPackage.EVAL_FUN_RES__CTX:
    	return ctx != null;
    case BoaPackage.EVAL_FUN_RES__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
