package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.If;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class IfImpl extends ControlStructureImpl implements If {
  private Block thenPart;

  private Block elsePart;

  public void setThenPart(Block newThenPart) {
    Block oldThenPart = thenPart;
    thenPart = newThenPart;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__THEN_PART, oldThenPart, thenPart));
  }

  public Block getThenPart() {
    return thenPart;}

  public void setElsePart(Block newElsePart) {
    Block oldElsePart = elsePart;
    elsePart = newElsePart;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__ELSE_PART, oldElsePart, elsePart));
  }

  public Block getElsePart() {
    return elsePart;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.IF;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmLogo.interpreter.kmLogo.impl.BlockImpl) newValue);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmLogo.interpreter.kmLogo.impl.BlockImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmLogo.interpreter.kmLogo.impl.BlockImpl) null);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmLogo.interpreter.kmLogo.impl.BlockImpl) null);
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
