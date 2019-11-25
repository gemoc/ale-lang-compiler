package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Back;
import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class BackImpl extends PrimitiveImpl implements Back {
  protected Expression steps;

  protected BackImpl() {
    super();
  }

  public void setSteps(Expression newSteps) {
    if (newSteps != steps) {
    	NotificationChain msgs = null;
    	if (steps != null)
    		msgs = ((InternalEObject)steps).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.visitor.kmLogo.KmLogoPackage.BACK__STEPS, null, msgs);
    	if (newSteps != null)
    		msgs = ((InternalEObject)newSteps).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.visitor.kmLogo.KmLogoPackage.BACK__STEPS, null, msgs);
    	msgs = basicSetSteps(newSteps, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.visitor.kmLogo.KmLogoPackage.BACK__STEPS, newSteps, newSteps));
  }

  public NotificationChain basicSetSteps(Expression newSteps, NotificationChain msgs) {
    Expression oldSteps = steps;
    steps = newSteps;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.visitor.kmLogo.KmLogoPackage.BACK__STEPS, oldSteps, newSteps);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getSteps() {
    return steps;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.BACK;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmLogo.visitor.kmLogo.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmLogo.visitor.kmLogo.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    return getSteps();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	return steps != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.visitor.kmLogo.KmLogoPackage.BACK__STEPS:
    	return basicSetSteps(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__Back(this);}
}
