package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Expression;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.UnaryExpression;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public abstract class UnaryExpressionImpl extends ExpressionImpl implements UnaryExpression {
  private Expression expression;

  public void setExpression(Expression newExpression) {
    if (newExpression != expression) {
    	NotificationChain msgs = null;
    	if (expression != null)
    		msgs = ((InternalEObject) expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, null, msgs);
    	if (newExpression != null)
    		msgs = ((InternalEObject) newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, null, msgs);
    	msgs = basicSetExpression(newExpression, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, newExpression, newExpression));
  }

  private NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.UNARY_EXPRESSION__EXPRESSION,
    			oldExpression, newExpression);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Expression getExpression() {
    return expression;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.UNARYEXPRESSION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	setExpression((kmlogo.interpreter.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	setExpression((kmlogo.interpreter.impl.ExpressionImpl) null);
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
