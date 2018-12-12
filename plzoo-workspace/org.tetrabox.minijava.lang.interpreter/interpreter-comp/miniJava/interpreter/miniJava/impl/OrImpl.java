package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Or;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class OrImpl extends ExpressionImpl implements Or {
  protected Expression left;

  protected Expression right;

  protected OrImpl() {
    super();
  }

  public void setLeft(Expression newLeft) {
    if (newLeft != left) {
    	NotificationChain msgs = null;
    	if (left != null)
    		msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.OR__LEFT, null, msgs);
    	if (newLeft != null)
    		msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.OR__LEFT, null, msgs);
    	msgs = basicSetLeft(newLeft, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.OR__LEFT, newLeft, newLeft));
  }

  public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs) {
    Expression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.OR__LEFT, oldLeft, newLeft);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getLeft() {
    return left;}

  public void setRight(Expression newRight) {
    if (newRight != right) {
    	NotificationChain msgs = null;
    	if (right != null)
    		msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.OR__RIGHT, null, msgs);
    	if (newRight != null)
    		msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.OR__RIGHT, null, msgs);
    	msgs = basicSetRight(newRight, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.OR__RIGHT, newRight, newRight));
  }

  public NotificationChain basicSetRight(Expression newRight, NotificationChain msgs) {
    Expression oldRight = right;
    right = newRight;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.OR__RIGHT, oldRight, newRight);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getRight() {
    return right;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.OR;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.OR__LEFT:
    	setLeft((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    case MiniJavaPackage.OR__RIGHT:
    	setRight((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OR__LEFT:
    	setLeft((miniJava.interpreter.miniJava.Expression) null);
    return;
    case MiniJavaPackage.OR__RIGHT:
    	setRight((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.OR__LEFT:
    return getLeft();
    case MiniJavaPackage.OR__RIGHT:
    return getRight();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OR__LEFT:
    	return left != null;
    case MiniJavaPackage.OR__RIGHT:
    	return right != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.OR__LEFT:
    	return basicSetLeft(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.OR__RIGHT:
    	return basicSetRight(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
