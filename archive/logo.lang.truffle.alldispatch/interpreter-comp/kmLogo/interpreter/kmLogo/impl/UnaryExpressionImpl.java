package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.UnaryExpression;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "UnaryExpression"
)
public abstract class UnaryExpressionImpl extends ExpressionImpl implements UnaryExpression {
  @Child
  protected Expression expression;

  protected UnaryExpressionImpl() {
    super();
  }

  @TruffleBoundary
  public void setExpression(Expression newExpression) {
    if (newExpression != expression) {
    	NotificationChain msgs = null;
    	if (expression != null)
    		msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, null, msgs);
    	if (newExpression != null)
    		msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, null, msgs);
    	msgs = basicSetExpression(newExpression, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, newExpression, newExpression));
  }

  @TruffleBoundary
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.UNARY_EXPRESSION__EXPRESSION, oldExpression, newExpression);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getExpression() {
    return expression;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.UNARY_EXPRESSION;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	setExpression((kmLogo.interpreter.kmLogo.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	setExpression((kmLogo.interpreter.kmLogo.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    return getExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	return expression != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.UNARY_EXPRESSION__EXPRESSION:
    	return basicSetExpression(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
