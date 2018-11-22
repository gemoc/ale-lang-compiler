package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.App;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalFunRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class AppImpl extends ExprImpl implements App {
  protected Expr lhs;

  protected Expr rhs;

  protected AppImpl() {
    super();
  }

  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.APP__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.APP__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.APP__LHS, newLhs, newLhs));
  }

  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.APP__LHS, oldLhs, newLhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getLhs() {
    return lhs;}

  public void setRhs(Expr newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.APP__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.APP__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.APP__RHS, newRhs, newRhs));
  }

  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.APP__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getRhs() {
    return rhs;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.APP;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    	setLhs((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.APP__RHS:
    	setRhs((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    	setLhs((interpreter.boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.APP__RHS:
    	setRhs((interpreter.boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    return getLhs();
    case BoaPackage.APP__RHS:
    return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    	return lhs != null;
    case BoaPackage.APP__RHS:
    	return rhs != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.boa.interpreter.boa.BoaPackage.APP__LHS:
    	return basicSetLhs(null, msgs);
    case interpreter.boa.interpreter.boa.BoaPackage.APP__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalRes vlhs = ((interpreter.boa.interpreter.boa.EvalRes)this.lhs.eval(ctx));
        interpreter.boa.interpreter.boa.EvalRes vrhs = ((interpreter.boa.interpreter.boa.EvalRes)this.rhs.eval(ctx));
        if(vlhs instanceof interpreter.boa.interpreter.boa.EvalFunRes) {
          if(vlhs instanceof interpreter.boa.interpreter.boa.EvalBoundFunRes) {
            interpreter.boa.interpreter.boa.EvalBoundFunRes fct = ((interpreter.boa.interpreter.boa.EvalBoundFunRes)vlhs);
            interpreter.boa.interpreter.boa.Ctx callCtx = ((interpreter.boa.interpreter.boa.Ctx)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
            execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
            execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
            execboa.MapService.replaceWith(callCtx.getTh(), fct.getTh());
            interpreter.boa.interpreter.boa.EvalRes fe = ((interpreter.boa.interpreter.boa.EvalRes)this.callFunc(fct,callCtx));
            if(fe instanceof interpreter.boa.interpreter.boa.EvalFunRes) {
              interpreter.boa.interpreter.boa.EvalFunRes fun = ((interpreter.boa.interpreter.boa.EvalFunRes)fe);
              interpreter.boa.interpreter.boa.EvalBoundFunRes tmp = ((interpreter.boa.interpreter.boa.EvalBoundFunRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
              tmp.setExp(fun.getExp());
              tmp.setCtx(fun.getCtx());
              tmp.setName(fun.getName());
              execboa.MapService.replaceWith(tmp.getTh(), fct.getTh());
              result = tmp;
            }
            else {
              result = fe;
            }
          }
          else {
            interpreter.boa.interpreter.boa.EvalFunRes fct = ((interpreter.boa.interpreter.boa.EvalFunRes)vlhs);
            interpreter.boa.interpreter.boa.Ctx callCtx = ((interpreter.boa.interpreter.boa.Ctx)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
            execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
            execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
            execboa.MapService.replaceWith(callCtx.getTh(), ctx.getTh());
            interpreter.boa.interpreter.boa.EvalRes fe = ((interpreter.boa.interpreter.boa.EvalRes)this.callFunc(fct,callCtx));
            if(fe instanceof interpreter.boa.interpreter.boa.EvalFunRes) {
              interpreter.boa.interpreter.boa.EvalFunRes fun = ((interpreter.boa.interpreter.boa.EvalFunRes)fe);
              interpreter.boa.interpreter.boa.EvalBoundFunRes tmp = ((interpreter.boa.interpreter.boa.EvalBoundFunRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
              tmp.setExp(fun.getExp());
              tmp.setCtx(fun.getCtx());
              tmp.setName(fun.getName());
              execboa.MapService.replaceWith(tmp.getTh(), ctx.getTh());
              result = tmp;
            }
            else {
              result = fe;
            }
          }
        }
        else {
          result = null;
        }
        ;
    return result;
  }

  public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
    EvalRes result;
    result = fct.getExp().eval(callCtx);
        ;
    return result;
  }
}
