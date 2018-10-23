package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Left;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class LeftImpl extends PrimitiveImpl implements Left {
  private Expression angle;

  public void setAngle(Expression newAngle) {
    Expression oldAngle = angle;
    angle = newAngle;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.LEFT__ANGLE, oldAngle, angle));
  }

  public Expression getAngle() {
    return angle;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.LEFT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.LEFT__ANGLE:
    	setAngle((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.LEFT__ANGLE:
    	setAngle((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.LEFT__ANGLE:
    	return getAngle();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.LEFT__ANGLE:
    	return angle != null;
    }
    return super.eIsSet(featureID);
  }

  public double eval(Turtle turtle) {
    double result;
    double angle = ((double)this.getAngle().eval(turtle));
    turtle.rotate(angle);
    result = 0.0;
    return result;
  }
}
