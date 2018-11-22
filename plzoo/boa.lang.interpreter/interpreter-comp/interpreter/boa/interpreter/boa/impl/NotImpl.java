package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.Not;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class NotImpl extends ExprImpl implements Not {
  protected Expr value;

  protected NotImpl() {
    super();
  }

  public void setValue(Expr newValue) {
    if (newValue != value) {
    	NotificationChain msgs = null;
    	if (value != null)
    		msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.NOT__VALUE, null, msgs);
    	if (newValue != null)
    		msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.NOT__VALUE, null, msgs);
    	msgs = basicSetValue(newValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.NOT__VALUE, newValue, newValue));
  }

  public NotificationChain basicSetValue(Expr newValue, NotificationChain msgs) {
    Expr oldValue = value;
    value = newValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.NOT__VALUE, oldValue, newValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getValue() {
    return value;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.NOT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    	setValue((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    	setValue((interpreter.boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.boa.interpreter.boa.BoaPackage.NOT__VALUE:
    	return basicSetValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalRes vvalue = ((interpreter.boa.interpreter.boa.EvalRes)this.value.eval(ctx));
        if(vvalue instanceof interpreter.boa.interpreter.boa.EvalBoolRes) {
          interpreter.boa.interpreter.boa.EvalBoolRes bvvalue = ((interpreter.boa.interpreter.boa.EvalBoolRes)vvalue);
          interpreter.boa.interpreter.boa.EvalBoolRes ret = ((interpreter.boa.interpreter.boa.EvalBoolRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoolRes());
          ret.setValue(!(bvvalue.isValue()));
          result = ret;
        }
        else {
          result = null;
        }
        ;
    return result;
  }
}
