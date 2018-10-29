package boa_dynamic.interpreter.boa_dynamic.impl;

import boa.interpreter.boa.Expr;
import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalFunRes;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "EvalFunRes"
)
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

  public void setExp(Expr newExp) {
    Expr oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, Boa_dynamicPackage.EVAL_FUN_RES__EXP, oldExp, exp));
  }

  public Expr getExp() {
    return exp;}

  public void setCtx(Ctx newCtx) {
    Ctx oldCtx = ctx;
    ctx = newCtx;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, Boa_dynamicPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
  }

  public Ctx getCtx() {
    return ctx;}

  protected EClass eStaticClass() {
    return Boa_dynamicPackage.Literals.EVAL_FUN_RES;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_FUN_RES__EXP:
    	setExp((boa.interpreter.boa.Expr) newValue);
    return;
    case Boa_dynamicPackage.EVAL_FUN_RES__CTX:
    	setCtx((boa_dynamic.interpreter.boa_dynamic.Ctx) newValue);
    return;
    case Boa_dynamicPackage.EVAL_FUN_RES__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_FUN_RES__EXP:
    	setExp((boa.interpreter.boa.Expr) null);
    return;
    case Boa_dynamicPackage.EVAL_FUN_RES__CTX:
    	setCtx((boa_dynamic.interpreter.boa_dynamic.Ctx) null);
    return;
    case Boa_dynamicPackage.EVAL_FUN_RES__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_FUN_RES__EXP:
    return getExp();
    case Boa_dynamicPackage.EVAL_FUN_RES__CTX:
    return getCtx();
    case Boa_dynamicPackage.EVAL_FUN_RES__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_FUN_RES__EXP:
    	return exp != null;
    case Boa_dynamicPackage.EVAL_FUN_RES__CTX:
    	return ctx != null;
    case Boa_dynamicPackage.EVAL_FUN_RES__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
