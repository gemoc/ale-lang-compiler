package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Copy;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class CopyImpl extends ExprImpl implements Copy {
  protected Expr copy;

  protected CopyImpl() {
    super();
  }

  public void setCopy(Expr newCopy) {
    if (newCopy != copy) {
    	NotificationChain msgs = null;
    	if (copy != null)
    		msgs = ((InternalEObject)copy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.COPY__COPY, null, msgs);
    	if (newCopy != null)
    		msgs = ((InternalEObject)newCopy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.boa.interpreter.boa.BoaPackage.COPY__COPY, null, msgs);
    	msgs = basicSetCopy(newCopy, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.COPY__COPY, newCopy, newCopy));
  }

  public NotificationChain basicSetCopy(Expr newCopy, NotificationChain msgs) {
    Expr oldCopy = copy;
    copy = newCopy;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.boa.interpreter.boa.BoaPackage.COPY__COPY, oldCopy, newCopy);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getCopy() {
    return copy;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.COPY;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    	setCopy((interpreter.boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    	setCopy((interpreter.boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    return getCopy();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    	return copy != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.boa.interpreter.boa.BoaPackage.COPY__COPY:
    	return basicSetCopy(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalRes vcopy = ((interpreter.boa.interpreter.boa.EvalRes)this.copy.eval(ctx));
        if(vcopy instanceof interpreter.boa.interpreter.boa.EvalMapRes) {
          interpreter.boa.interpreter.boa.EvalMapRes mvcopy = ((interpreter.boa.interpreter.boa.EvalMapRes)vcopy);
          interpreter.boa.interpreter.boa.EvalMapRes ret = ((interpreter.boa.interpreter.boa.EvalMapRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalMapRes());
          execboa.MapService.putAll(ret.getValues(), mvcopy.getValues());
          result = ret;
        }
        else {
          result = null;
        }
        ;
    return result;
  }
}
