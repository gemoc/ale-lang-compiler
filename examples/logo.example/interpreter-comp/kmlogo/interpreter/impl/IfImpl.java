package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Block;
import kmlogo.interpreter.If;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class IfImpl extends ControlStructureImpl implements If {
  private Block thenPart;

  private Block elsePart;

  public void setThenPart(Block newThenPart) {
    if (newThenPart != thenPart) {
    	NotificationChain msgs = null;
    	if (thenPart != null)
    		msgs = ((InternalEObject) thenPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__THEN_PART, null, msgs);
    	if (newThenPart != null)
    		msgs = ((InternalEObject) newThenPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__THEN_PART, null, msgs);
    	msgs = basicSetThenPart(newThenPart, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__THEN_PART, newThenPart, newThenPart));
  }

  private NotificationChain basicSetThenPart(Block newThenPart, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Block oldThenPart = thenPart;
    thenPart = newThenPart;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__THEN_PART,
    			oldThenPart, newThenPart);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Block getThenPart() {
    return thenPart;}

  public void setElsePart(Block newElsePart) {
    if (newElsePart != elsePart) {
    	NotificationChain msgs = null;
    	if (elsePart != null)
    		msgs = ((InternalEObject) elsePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__ELSE_PART, null, msgs);
    	if (newElsePart != null)
    		msgs = ((InternalEObject) newElsePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__ELSE_PART, null, msgs);
    	msgs = basicSetElsePart(newElsePart, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__ELSE_PART, newElsePart, newElsePart));
  }

  private NotificationChain basicSetElsePart(Block newElsePart, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Block oldElsePart = elsePart;
    elsePart = newElsePart;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__ELSE_PART,
    			oldElsePart, newElsePart);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Block getElsePart() {
    return elsePart;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.IF;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmlogo.interpreter.impl.BlockImpl) newValue);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmlogo.interpreter.impl.BlockImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmlogo.interpreter.impl.BlockImpl) null);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmlogo.interpreter.impl.BlockImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	return getThenPart();
    case KmLogoPackage.IF__ELSE_PART:
    	return getElsePart();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	return thenPart != null;
    case KmLogoPackage.IF__ELSE_PART:
    	return elsePart != null;
    }
    return super.eIsSet(featureID);
  }

  public double eval(Turtle turtle) {
    double result;
    if((this.getCondition().eval(turtle)) != (0.0)) {
      result = this.getThenPart().eval(turtle);
    }
    else {
      if((this.getElsePart()) != (null)) {
        result = this.getElsePart().eval(turtle);
      }
      else {
        result = 0.0;
      }
    }
    return result;
  }
}
