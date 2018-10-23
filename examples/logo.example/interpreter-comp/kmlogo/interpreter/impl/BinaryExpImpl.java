package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.BinaryExp;
import kmlogo.interpreter.Expression;
import kmlogo.interpreter.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public abstract class BinaryExpImpl extends ExpressionImpl implements BinaryExp {
  private Expression lhs;

  private Expression rhs;

  public void setLhs(Expression newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__LHS, newLhs, newLhs));
  }

  private NotificationChain basicSetLhs(Expression newLhs, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Expression oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__LHS,
    			oldLhs, newLhs);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Expression getLhs() {
    return lhs;}

  public void setRhs(Expression newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__RHS, newRhs, newRhs));
  }

  private NotificationChain basicSetRhs(Expression newRhs, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Expression oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__RHS,
    			oldRhs, newRhs);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Expression getRhs() {
    return rhs;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.BINARYEXP;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.BINARY_EXP__LHS:
    	setLhs((kmlogo.interpreter.impl.ExpressionImpl) newValue);
    return;
    case KmLogoPackage.BINARY_EXP__RHS:
    	setRhs((kmlogo.interpreter.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BINARY_EXP__LHS:
    	setLhs((kmlogo.interpreter.impl.ExpressionImpl) null);
    return;
    case KmLogoPackage.BINARY_EXP__RHS:
    	setRhs((kmlogo.interpreter.impl.ExpressionImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.BINARY_EXP__LHS:
    	return getLhs();
    case KmLogoPackage.BINARY_EXP__RHS:
    	return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BINARY_EXP__LHS:
    	return lhs != null;
    case KmLogoPackage.BINARY_EXP__RHS:
    	return rhs != null;
    }
    return super.eIsSet(featureID);
  }
}
