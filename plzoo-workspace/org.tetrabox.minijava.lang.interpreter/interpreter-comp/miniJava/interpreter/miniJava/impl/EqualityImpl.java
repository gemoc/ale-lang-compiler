package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Equality;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class EqualityImpl extends ExpressionImpl implements Equality {
  protected Expression left;

  protected Expression right;

  protected EqualityImpl() {
    super();
  }

  public void setLeft(Expression newLeft) {
    if (newLeft != left) {
    	NotificationChain msgs = null;
    	if (left != null)
    		msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__LEFT, null, msgs);
    	if (newLeft != null)
    		msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__LEFT, null, msgs);
    	msgs = basicSetLeft(newLeft, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__LEFT, newLeft, newLeft));
  }

  public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs) {
    Expression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__LEFT, oldLeft, newLeft);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getLeft() {
    return left;
  }

  public void setRight(Expression newRight) {
    if (newRight != right) {
    	NotificationChain msgs = null;
    	if (right != null)
    		msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__RIGHT, null, msgs);
    	if (newRight != null)
    		msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__RIGHT, null, msgs);
    	msgs = basicSetRight(newRight, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__RIGHT, newRight, newRight));
  }

  public NotificationChain basicSetRight(Expression newRight, NotificationChain msgs) {
    Expression oldRight = right;
    right = newRight;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__RIGHT, oldRight, newRight);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getRight() {
    return right;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.EQUALITY;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.EQUALITY__LEFT:
    	setLeft((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    case MiniJavaPackage.EQUALITY__RIGHT:
    	setRight((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.EQUALITY__LEFT:
    	setLeft((miniJava.interpreter.miniJava.Expression) null);
    return;
    case MiniJavaPackage.EQUALITY__RIGHT:
    	setRight((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.EQUALITY__LEFT:
    return getLeft();
    case MiniJavaPackage.EQUALITY__RIGHT:
    return getRight();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.EQUALITY__LEFT:
    	return left != null;
    case MiniJavaPackage.EQUALITY__RIGHT:
    	return right != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__LEFT:
    	return basicSetLeft(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.EQUALITY__RIGHT:
    	return basicSetRight(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.Value left = ((miniJava.interpreter.miniJava.Value)this.left.evaluateExpression(state));
        miniJava.interpreter.miniJava.Value right = ((miniJava.interpreter.miniJava.Value)this.right.evaluateExpression(state));
        boolean tmp = ((boolean)false);
        if(left instanceof miniJava.interpreter.miniJava.IntegerValue) {
          if(right instanceof miniJava.interpreter.miniJava.IntegerValue) {
            miniJava.interpreter.miniJava.IntegerValue ileft = ((miniJava.interpreter.miniJava.IntegerValue)left);
            miniJava.interpreter.miniJava.IntegerValue iright = ((miniJava.interpreter.miniJava.IntegerValue)right);
            tmp = java.util.Objects.equals((ileft.getValue()), (iright.getValue()));
          }
        }
        else {
          if(left instanceof miniJava.interpreter.miniJava.StringValue) {
            if(right instanceof miniJava.interpreter.miniJava.StringValue) {
              miniJava.interpreter.miniJava.StringValue ileft = ((miniJava.interpreter.miniJava.StringValue)left);
              miniJava.interpreter.miniJava.StringValue iright = ((miniJava.interpreter.miniJava.StringValue)right);
              tmp = java.util.Objects.equals((ileft.getValue()), (iright.getValue()));
            }
          }
          else {
            if(left instanceof miniJava.interpreter.miniJava.BooleanValue) {
              if(right instanceof miniJava.interpreter.miniJava.BooleanValue) {
                miniJava.interpreter.miniJava.BooleanValue ileft = ((miniJava.interpreter.miniJava.BooleanValue)left);
                miniJava.interpreter.miniJava.BooleanValue iright = ((miniJava.interpreter.miniJava.BooleanValue)right);
                tmp = java.util.Objects.equals((ileft.isValue()), (iright.isValue()));
              }
            }
            else {
              if(left instanceof miniJava.interpreter.miniJava.NullValue) {
                if(right instanceof miniJava.interpreter.miniJava.NullValue) {
                  tmp = true;
                }
              }
              else {
                if(left instanceof miniJava.interpreter.miniJava.ObjectRefValue) {
                  if(right instanceof miniJava.interpreter.miniJava.ObjectRefValue) {
                    miniJava.interpreter.miniJava.ObjectRefValue ileft = ((miniJava.interpreter.miniJava.ObjectRefValue)left);
                    miniJava.interpreter.miniJava.ObjectRefValue iright = ((miniJava.interpreter.miniJava.ObjectRefValue)right);
                    tmp = java.util.Objects.equals((ileft.getInstance()), (iright.getInstance()));
                  }
                }
              }
            }
          }
        }
        miniJava.interpreter.miniJava.BooleanValue tmpo = ((miniJava.interpreter.miniJava.BooleanValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
        tmpo.setValue(tmp);
        result = tmpo;
        ;
    return result;
  }
}
