package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import boa.interpreter.boa.If;
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
    description = "If"
)
public class IfImpl extends ExprImpl implements If {
  @Child
  protected Expr cond;

  @Child
  protected Expr thn;

  @Child
  protected Expr els;

  protected IfImpl() {
    super();
  }

  @TruffleBoundary
  public void setCond(Expr newCond) {
    if (newCond != cond) {
    	NotificationChain msgs = null;
    	if (cond != null)
    		msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.IF__COND, null, msgs);
    	if (newCond != null)
    		msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.IF__COND, null, msgs);
    	msgs = basicSetCond(newCond, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.IF__COND, newCond, newCond));
  }

  @TruffleBoundary
  public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
    Expr oldCond = cond;
    cond = newCond;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.IF__COND, oldCond, newCond);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getCond() {
    return cond;
  }

  @TruffleBoundary
  public void setThn(Expr newThn) {
    if (newThn != thn) {
    	NotificationChain msgs = null;
    	if (thn != null)
    		msgs = ((InternalEObject)thn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.IF__THN, null, msgs);
    	if (newThn != null)
    		msgs = ((InternalEObject)newThn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.IF__THN, null, msgs);
    	msgs = basicSetThn(newThn, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.IF__THN, newThn, newThn));
  }

  @TruffleBoundary
  public NotificationChain basicSetThn(Expr newThn, NotificationChain msgs) {
    Expr oldThn = thn;
    thn = newThn;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.IF__THN, oldThn, newThn);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getThn() {
    return thn;
  }

  @TruffleBoundary
  public void setEls(Expr newEls) {
    if (newEls != els) {
    	NotificationChain msgs = null;
    	if (els != null)
    		msgs = ((InternalEObject)els).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.IF__ELS, null, msgs);
    	if (newEls != null)
    		msgs = ((InternalEObject)newEls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.IF__ELS, null, msgs);
    	msgs = basicSetEls(newEls, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.IF__ELS, newEls, newEls));
  }

  @TruffleBoundary
  public NotificationChain basicSetEls(Expr newEls, NotificationChain msgs) {
    Expr oldEls = els;
    els = newEls;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.IF__ELS, oldEls, newEls);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getEls() {
    return els;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.IF;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.IF__COND:
    	setCond((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.IF__THN:
    	setThn((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.IF__ELS:
    	setEls((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.IF__COND:
    	setCond((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.IF__THN:
    	setThn((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.IF__ELS:
    	setEls((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.IF__COND:
    return getCond();
    case BoaPackage.IF__THN:
    return getThn();
    case BoaPackage.IF__ELS:
    return getEls();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.IF__COND:
    	return cond != null;
    case BoaPackage.IF__THN:
    	return thn != null;
    case BoaPackage.IF__ELS:
    	return els != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.IF__COND:
    	return basicSetCond(null, msgs);
    case boa.interpreter.boa.BoaPackage.IF__THN:
    	return basicSetThn(null, msgs);
    case boa.interpreter.boa.BoaPackage.IF__ELS:
    	return basicSetEls(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    boa.interpreter.boa.EvalRes vcond = ((boa.interpreter.boa.EvalRes)this.cond.eval(ctx));
        if(vcond instanceof boa.interpreter.boa.EvalBoolRes) {
          boa.interpreter.boa.EvalBoolRes bvcond = ((boa.interpreter.boa.EvalBoolRes)vcond);
          if(bvcond.isValue()) {
            result = this.thn.eval(ctx);
          }
          else {
            result = this.els.eval(ctx);
          }
        }
        else {
          result = null;
        }
        ;
    return result;
  }
}
