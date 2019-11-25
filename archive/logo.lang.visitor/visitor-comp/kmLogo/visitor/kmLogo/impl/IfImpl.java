package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Block;
import kmLogo.visitor.kmLogo.If;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class IfImpl extends ControlStructureImpl implements If {
  protected Block thenPart;

  protected Block elsePart;

  protected IfImpl() {
    super();
  }

  public void setThenPart(Block newThenPart) {
    if (newThenPart != thenPart) {
    	NotificationChain msgs = null;
    	if (thenPart != null)
    		msgs = ((InternalEObject)thenPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.visitor.kmLogo.KmLogoPackage.IF__THEN_PART, null, msgs);
    	if (newThenPart != null)
    		msgs = ((InternalEObject)newThenPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.visitor.kmLogo.KmLogoPackage.IF__THEN_PART, null, msgs);
    	msgs = basicSetThenPart(newThenPart, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.visitor.kmLogo.KmLogoPackage.IF__THEN_PART, newThenPart, newThenPart));
  }

  public NotificationChain basicSetThenPart(Block newThenPart, NotificationChain msgs) {
    Block oldThenPart = thenPart;
    thenPart = newThenPart;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.visitor.kmLogo.KmLogoPackage.IF__THEN_PART, oldThenPart, newThenPart);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Block getThenPart() {
    return thenPart;}

  public void setElsePart(Block newElsePart) {
    if (newElsePart != elsePart) {
    	NotificationChain msgs = null;
    	if (elsePart != null)
    		msgs = ((InternalEObject)elsePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.visitor.kmLogo.KmLogoPackage.IF__ELSE_PART, null, msgs);
    	if (newElsePart != null)
    		msgs = ((InternalEObject)newElsePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.visitor.kmLogo.KmLogoPackage.IF__ELSE_PART, null, msgs);
    	msgs = basicSetElsePart(newElsePart, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.visitor.kmLogo.KmLogoPackage.IF__ELSE_PART, newElsePart, newElsePart));
  }

  public NotificationChain basicSetElsePart(Block newElsePart, NotificationChain msgs) {
    Block oldElsePart = elsePart;
    elsePart = newElsePart;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.visitor.kmLogo.KmLogoPackage.IF__ELSE_PART, oldElsePart, newElsePart);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
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
    	setThenPart((kmLogo.visitor.kmLogo.Block) newValue);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmLogo.visitor.kmLogo.Block) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmLogo.visitor.kmLogo.Block) null);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmLogo.visitor.kmLogo.Block) null);
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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.visitor.kmLogo.KmLogoPackage.IF__THEN_PART:
    	return basicSetThenPart(null, msgs);
    case kmLogo.visitor.kmLogo.KmLogoPackage.IF__ELSE_PART:
    	return basicSetElsePart(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__If(this);}
}
