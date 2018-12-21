package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Neg;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class NegImpl extends ExpressionImpl implements Neg {
  protected Expression expression;

  protected NegImpl() {
    super();
  }

  public void setExpression(Expression newExpression) {
    if (newExpression != expression) {
    	NotificationChain msgs = null;
    	if (expression != null)
    		msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.NEG__EXPRESSION, null, msgs);
    	if (newExpression != null)
    		msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.NEG__EXPRESSION, null, msgs);
    	msgs = basicSetExpression(newExpression, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.NEG__EXPRESSION, newExpression, newExpression));
  }

  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.NEG__EXPRESSION, oldExpression, newExpression);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getExpression() {
    return expression;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NEG;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.NEG__EXPRESSION:
    	setExpression((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEG__EXPRESSION:
    	setExpression((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.NEG__EXPRESSION:
    return getExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEG__EXPRESSION:
    	return expression != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.NEG__EXPRESSION:
    	return basicSetExpression(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.IntegerValue left = ((miniJava.interpreter.miniJava.IntegerValue)this.expression.evaluateExpression(state));
        miniJava.interpreter.miniJava.IntegerValue tmp = ((miniJava.interpreter.miniJava.IntegerValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createIntegerValue());
        tmp.setValue(-(left.getValue()));
        result = tmp;
        ;
    return result;
  }
}
