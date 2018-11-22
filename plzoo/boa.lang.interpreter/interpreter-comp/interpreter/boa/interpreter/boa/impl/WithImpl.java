package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.With;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class WithImpl extends ExprImpl implements With {
  protected Expr lhs;

  protected Expr rhs;

  protected WithImpl() {
    super();
  }

  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.WITH__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.WITH__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.WITH__LHS, newLhs, newLhs));
  }

  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.WITH__LHS, oldLhs, newLhs);
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
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.WITH__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.WITH__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.WITH__RHS, newRhs, newRhs));
  }

  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.WITH__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getRhs() {
    return rhs;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.WITH;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.WITH__LHS:
    	setLhs((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.WITH__RHS:
    	setRhs((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.WITH__LHS:
    	setLhs((interpreter.boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.WITH__RHS:
    	setRhs((interpreter.boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.WITH__LHS:
    return getLhs();
    case BoaPackage.WITH__RHS:
    return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.WITH__LHS:
    	return lhs != null;
    case BoaPackage.WITH__RHS:
    	return rhs != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.boa.interpreter.boa.BoaPackage.WITH__LHS:
    	return basicSetLhs(null, msgs);
    case interpreter.boa.interpreter.boa.BoaPackage.WITH__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalRes vlhs = ((interpreter.boa.interpreter.boa.EvalRes)this.lhs.eval(ctx));
        interpreter.boa.interpreter.boa.EvalRes vrhs = ((interpreter.boa.interpreter.boa.EvalRes)this.rhs.eval(ctx));
        if(vlhs instanceof interpreter.boa.interpreter.boa.EvalMapRes) {
          interpreter.boa.interpreter.boa.EvalMapRes mvlhs = ((interpreter.boa.interpreter.boa.EvalMapRes)vlhs);
          if(vrhs instanceof interpreter.boa.interpreter.boa.EvalMapRes) {
            interpreter.boa.interpreter.boa.EvalMapRes mvrhs = ((interpreter.boa.interpreter.boa.EvalMapRes)vrhs);
            interpreter.boa.interpreter.boa.EvalMapRes ret = ((interpreter.boa.interpreter.boa.EvalMapRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalMapRes());
            execboa.MapService.putAll(ret.getValues(), mvlhs.getValues());
            execboa.MapService.putAll(ret.getValues(), mvrhs.getValues());
            result = ret;
          }
          else {
            result = null;
          }
        }
        else {
          result = null;
        }
        ;
    return result;
  }
}
