package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Back;
import kmlogo.interpreter.Expression;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class BackImpl extends PrimitiveImpl implements Back {
  private Expression steps;

  public void setSteps(Expression newSteps) {
    if (newSteps != steps) {
    	NotificationChain msgs = null;
    	if (steps != null)
    		msgs = ((InternalEObject) steps).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BACK__STEPS, null, msgs);
    	if (newSteps != null)
    		msgs = ((InternalEObject) newSteps).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BACK__STEPS, null, msgs);
    	msgs = basicSetSteps(newSteps, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BACK__STEPS, newSteps, newSteps));
  }

  private NotificationChain basicSetSteps(Expression newSteps, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Expression oldSteps = steps;
    steps = newSteps;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.BACK__STEPS,
    			oldSteps, newSteps);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
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
    	setSteps((kmlogo.interpreter.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmlogo.interpreter.impl.ExpressionImpl) null);
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

  public double eval(Turtle turtle) {
    double result;
    double move = ((double)this.getSteps().eval(turtle));
    turtle.forward(-(move));
    result = 0.0;
    return result;
  }
}
