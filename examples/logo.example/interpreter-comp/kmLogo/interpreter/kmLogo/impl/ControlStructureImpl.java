package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.ControlStructure;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ControlStructureImpl extends InstructionImpl implements ControlStructure {
  private Expression condition;

  public void setCondition(Expression newCondition) {
    Expression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.CONTROL_STRUCTURE__CONDITION, oldCondition, condition));
  }

  public Expression getCondition() {
    return condition;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.CONTROL_STRUCTURE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	setCondition((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	setCondition((kmLogo.interpreter.kmLogo.impl.ExpressionImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	return getCondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CONTROL_STRUCTURE__CONDITION:
    	return condition != null;
    }
    return super.eIsSet(featureID);
  }
}
