package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.Expr;
import visitor.visitor.VisitorInterface;

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
    	eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__EXP, oldExp, exp));
  }

  public Expr getExp() {
    return exp;}

  public void setCtx(Ctx newCtx) {
    Ctx oldCtx = ctx;
    ctx = newCtx;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.EVAL_FUN_RES__CTX, oldCtx, ctx));
  }

  public Ctx getCtx() {
    return ctx;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.EVAL_FUN_RES;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.EVAL_FUN_RES__EXP:
    	setExp((visitor.boa.visitor.boa.Expr) newValue);
    return;
    case BoaPackage.EVAL_FUN_RES__CTX:
    	setCtx((visitor.boa.visitor.boa.Ctx) newValue);
    return;
    case BoaPackage.EVAL_FUN_RES__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_FUN_RES__EXP:
    	setExp((visitor.boa.visitor.boa.Expr) null);
    return;
    case BoaPackage.EVAL_FUN_RES__CTX:
    	setCtx((visitor.boa.visitor.boa.Ctx) null);
    return;
    case BoaPackage.EVAL_FUN_RES__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__EvalFunRes(this);}
}
