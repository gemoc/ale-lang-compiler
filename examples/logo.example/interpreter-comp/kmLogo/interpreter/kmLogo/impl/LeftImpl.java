package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Left;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class LeftImpl extends PrimitiveImpl implements Left {
  protected Expression angle;

  protected LeftImpl() {
    super();
  }

  public void setAngle(Expression newAngle) {
    if (newAngle != angle) {
    	NotificationChain msgs = null;
    	if (angle != null)
    		msgs = ((InternalEObject)angle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.LEFT__ANGLE, null, msgs);
    	if (newAngle != null)
    		msgs = ((InternalEObject)newAngle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.LEFT__ANGLE, null, msgs);
    	msgs = basicSetAngle(newAngle, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.LEFT__ANGLE, newAngle, newAngle));
  }

  public NotificationChain basicSetAngle(Expression newAngle, NotificationChain msgs) {
    Expression oldAngle = angle;
    angle = newAngle;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.LEFT__ANGLE, oldAngle, newAngle);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getAngle() {
    return angle;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.LEFT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.LEFT__ANGLE:
    	setAngle((kmLogo.interpreter.kmLogo.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.LEFT__ANGLE:
    	setAngle((kmLogo.interpreter.kmLogo.Expression) null);
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
