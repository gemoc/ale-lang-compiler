package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.UnaryExpression;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public abstract class UnaryExpressionImpl extends ExpressionImpl implements UnaryExpression {
  private Expression expression;

  public void setExpression(Expression newExpression) {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, oldExpression, expression));
  }

  public Expression getExpression() {
    return expression;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.UNARY_EXPRESSION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	setExpression((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	setExpression((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	return getExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	return expression != null;
    }
    return super.eIsSet(featureID);
  }
}
