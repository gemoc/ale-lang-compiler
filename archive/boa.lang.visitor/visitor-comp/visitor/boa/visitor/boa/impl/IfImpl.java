package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.Expr;
import visitor.boa.visitor.boa.If;
import visitor.visitor.VisitorInterface;

public class IfImpl extends ExprImpl implements If {
  protected Expr cond;

  protected Expr thn;

  protected Expr els;

  protected IfImpl() {
    super();
  }

  public void setCond(Expr newCond) {
    if (newCond != cond) {
    	NotificationChain msgs = null;
    	if (cond != null)
    		msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.IF__COND, null, msgs);
    	if (newCond != null)
    		msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.IF__COND, null, msgs);
    	msgs = basicSetCond(newCond, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.IF__COND, newCond, newCond));
  }

  public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
    Expr oldCond = cond;
    cond = newCond;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.IF__COND, oldCond, newCond);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getCond() {
    return cond;}

  public void setThn(Expr newThn) {
    if (newThn != thn) {
    	NotificationChain msgs = null;
    	if (thn != null)
    		msgs = ((InternalEObject)thn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.IF__THN, null, msgs);
    	if (newThn != null)
    		msgs = ((InternalEObject)newThn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.IF__THN, null, msgs);
    	msgs = basicSetThn(newThn, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.IF__THN, newThn, newThn));
  }

  public NotificationChain basicSetThn(Expr newThn, NotificationChain msgs) {
    Expr oldThn = thn;
    thn = newThn;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.IF__THN, oldThn, newThn);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getThn() {
    return thn;}

  public void setEls(Expr newEls) {
    if (newEls != els) {
    	NotificationChain msgs = null;
    	if (els != null)
    		msgs = ((InternalEObject)els).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.IF__ELS, null, msgs);
    	if (newEls != null)
    		msgs = ((InternalEObject)newEls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.IF__ELS, null, msgs);
    	msgs = basicSetEls(newEls, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.IF__ELS, newEls, newEls));
  }

  public NotificationChain basicSetEls(Expr newEls, NotificationChain msgs) {
    Expr oldEls = els;
    els = newEls;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.IF__ELS, oldEls, newEls);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getEls() {
    return els;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.IF;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.IF__COND:
    	setCond((visitor.boa.visitor.boa.Expr) newValue);
    return;
    case BoaPackage.IF__THN:
    	setThn((visitor.boa.visitor.boa.Expr) newValue);
    return;
    case BoaPackage.IF__ELS:
    	setEls((visitor.boa.visitor.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.IF__COND:
    	setCond((visitor.boa.visitor.boa.Expr) null);
    return;
    case BoaPackage.IF__THN:
    	setThn((visitor.boa.visitor.boa.Expr) null);
    return;
    case BoaPackage.IF__ELS:
    	setEls((visitor.boa.visitor.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case visitor.boa.visitor.boa.BoaPackage.IF__COND:
    	return basicSetCond(null, msgs);
    case visitor.boa.visitor.boa.BoaPackage.IF__THN:
    	return basicSetThn(null, msgs);
    case visitor.boa.visitor.boa.BoaPackage.IF__ELS:
    	return basicSetEls(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__If(this);}
}
