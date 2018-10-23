package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Back;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class BackImpl extends PrimitiveImpl implements Back {
  private Expression steps;

  public void setSteps(Expression newSteps) {
    Expression oldSteps = steps;
    steps = newSteps;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BACK__STEPS, oldSteps, steps));
  }

  public Expression getSteps() {
    return steps;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.BACK;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) null);
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
