package boa.interpreter.boa.impl;

import boa.interpreter.boa.App;
import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalBoundFunRes;
import boa.interpreter.boa.EvalFunRes;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
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

  @TruffleBoundary
  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.APP__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.APP__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.APP__LHS, newLhs, newLhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.APP__LHS, oldLhs, newLhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getLhs() {
    return lhs;}

  @TruffleBoundary
  public void setRhs(Expr newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.APP__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.APP__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.APP__RHS, newRhs, newRhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.APP__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getRhs() {
    return rhs;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.APP;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    	setLhs((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.APP__RHS:
    	setRhs((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    	setLhs((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.APP__RHS:
    	setRhs((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    return getLhs();
    case BoaPackage.APP__RHS:
    return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.APP__LHS:
    	return lhs != null;
    case BoaPackage.APP__RHS:
    	return rhs != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.APP__LHS:
    	return basicSetLhs(null, msgs);
    case boa.interpreter.boa.BoaPackage.APP__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)this.getLhs().eval(ctx));
    EvalRes vrhs = ((EvalRes)this.getRhs().eval(ctx));
    if(vlhs instanceof boa.interpreter.boa.EvalFunRes) {
      if(vlhs instanceof boa.interpreter.boa.EvalBoundFunRes) {
        EvalBoundFunRes fct = ((EvalBoundFunRes)vlhs);
        Ctx callCtx = ((Ctx)boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
        execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
        execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
        execboa.MapService.replaceWith(callCtx.getTh(), fct.getTh());
        EvalRes fe = ((EvalRes)this.callFunc(fct,callCtx));
        if(fe instanceof boa.interpreter.boa.EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes)fe);
          EvalBoundFunRes tmp = ((EvalBoundFunRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
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
        EvalFunRes fct = ((EvalFunRes)vlhs);
        Ctx callCtx = ((Ctx)boa.interpreter.boa.BoaFactory.eINSTANCE.createCtx());
        execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
        execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
        execboa.MapService.replaceWith(callCtx.getTh(), ctx.getTh());
        EvalRes fe = ((EvalRes)this.callFunc(fct,callCtx));
        if(fe instanceof boa.interpreter.boa.EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes)fe);
          EvalBoundFunRes tmp = ((EvalBoundFunRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
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
    return result;
  }

  public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
    EvalRes result;
    result = fct.getExp().eval(callCtx);
    return result;
  }
}
