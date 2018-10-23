package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.BinaryExp;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public abstract class BinaryExpImpl extends ExpressionImpl implements BinaryExp {
  private Expression lhs;

  private Expression rhs;

  public void setLhs(Expression newLhs) {
    Expression oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__LHS, oldLhs, lhs));
  }

  public Expression getLhs() {
    return lhs;}

  public void setRhs(Expression newRhs) {
    Expression oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__RHS, oldRhs, rhs));
  }

  public Expression getRhs() {
    return rhs;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.BINARY_EXP;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.BINARY_EXP__LHS:
    	setLhs((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) newValue);
    return;
    case KmLogoPackage.BINARY_EXP__RHS:
    	setRhs((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BINARY_EXP__LHS:
    	setLhs((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) null);
    return;
    case KmLogoPackage.BINARY_EXP__RHS:
    	setRhs((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) null);
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
