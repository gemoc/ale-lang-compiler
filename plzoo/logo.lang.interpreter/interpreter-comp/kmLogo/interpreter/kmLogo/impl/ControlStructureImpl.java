package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.ControlStructure;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ControlStructureImpl extends InstructionImpl implements ControlStructure {
  protected Expression condition;

  protected ControlStructureImpl() {
    super();
  }

  public void setCondition(Expression newCondition) {
    if (newCondition != condition) {
    	NotificationChain msgs = null;
    	if (condition != null)
    		msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.CONTROL_STRUCTURE__CONDITION, null, msgs);
    	if (newCondition != null)
    		msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.CONTROL_STRUCTURE__CONDITION, null, msgs);
    	msgs = basicSetCondition(newCondition, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.CONTROL_STRUCTURE__CONDITION, newCondition, newCondition));
  }

  public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
    Expression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.CONTROL_STRUCTURE__CONDITION, oldCondition, newCondition);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getCondition() {
    return condition;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.CONTROL_STRUCTURE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	setCondition((kmLogo.interpreter.kmLogo.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	setCondition((kmLogo.interpreter.kmLogo.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    return getCondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	return condition != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	return basicSetCondition(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
