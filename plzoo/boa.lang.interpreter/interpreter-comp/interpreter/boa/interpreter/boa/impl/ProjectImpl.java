package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalFunRes;
import interpreter.boa.interpreter.boa.EvalMapRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.Project;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ProjectImpl extends ExprImpl implements Project {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected Expr exp;

  protected ProjectImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public void setExp(Expr newExp) {
    if (newExp != exp) {
    	NotificationChain msgs = null;
    	if (exp != null)
    		msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.PROJECT__EXP, null, msgs);
    	if (newExp != null)
    		msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.PROJECT__EXP, null, msgs);
    	msgs = basicSetExp(newExp, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.PROJECT__EXP, newExp, newExp));
  }

  public NotificationChain basicSetExp(Expr newExp, NotificationChain msgs) {
    Expr oldExp = exp;
    exp = newExp;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.PROJECT__EXP, oldExp, newExp);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getExp() {
    return exp;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.PROJECT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    	setExp((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.PROJECT__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    	setExp((interpreter.boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.PROJECT__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    return getExp();
    case BoaPackage.PROJECT__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.PROJECT__EXP:
    	return exp != null;
    case BoaPackage.PROJECT__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.boa.interpreter.boa.BoaPackage.PROJECT__EXP:
    	return basicSetExp(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalRes vexp = ((interpreter.boa.interpreter.boa.EvalRes)this.exp.eval(ctx));
        if(vexp instanceof interpreter.boa.interpreter.boa.EvalMapRes) {
          interpreter.boa.interpreter.boa.EvalMapRes mvexp = ((interpreter.boa.interpreter.boa.EvalMapRes)vexp);
          if(execboa.MapService.containsKey(mvexp.getValues(), this.name)) {
            interpreter.boa.interpreter.boa.EvalRes x = ((interpreter.boa.interpreter.boa.EvalRes)mvexp.getValues().get(this.name));
            if(x instanceof interpreter.boa.interpreter.boa.EvalFunRes) {
              interpreter.boa.interpreter.boa.EvalFunRes func = ((interpreter.boa.interpreter.boa.EvalFunRes)x);
              result = this.project(func,mvexp);
            }
            else {
              result = x;
            }
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

  public EvalRes project(EvalFunRes func, EvalMapRes mvexp) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalBoundFunRes ret = ((interpreter.boa.interpreter.boa.EvalBoundFunRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
        ret.setExp(func.getExp());
        ret.setCtx(func.getCtx());
        ret.setName(func.getName());
        execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
        result = ret;
        ;
    return result;
  }
}
