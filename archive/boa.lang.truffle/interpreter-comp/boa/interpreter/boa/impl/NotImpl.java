package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import boa.interpreter.boa.Not;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "Not"
)
public class NotImpl extends ExprImpl implements Not {
  @Child
  protected Expr value;

  protected NotImpl() {
    super();
  }

  @TruffleBoundary
  public void setValue(Expr newValue) {
    if (newValue != value) {
    	NotificationChain msgs = null;
    	if (value != null)
    		msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.NOT__VALUE, null, msgs);
    	if (newValue != null)
    		msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.NOT__VALUE, null, msgs);
    	msgs = basicSetValue(newValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.NOT__VALUE, newValue, newValue));
  }

  @TruffleBoundary
  public NotificationChain basicSetValue(Expr newValue, NotificationChain msgs) {
    Expr oldValue = value;
    value = newValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.NOT__VALUE, oldValue, newValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getValue() {
    return value;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.NOT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    	setValue((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    	setValue((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.NOT__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.NOT__VALUE:
    	return basicSetValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    boa.interpreter.boa.EvalRes vvalue = ((boa.interpreter.boa.EvalRes)this.value.eval(ctx));
        if(vvalue instanceof boa.interpreter.boa.EvalBoolRes) {
          boa.interpreter.boa.EvalBoolRes bvvalue = ((boa.interpreter.boa.EvalBoolRes)vvalue);
          boa.interpreter.boa.EvalBoolRes ret = ((boa.interpreter.boa.EvalBoolRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoolRes());
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
