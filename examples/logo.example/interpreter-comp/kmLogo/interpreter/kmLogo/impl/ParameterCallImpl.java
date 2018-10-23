package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Parameter;
import kmLogo.interpreter.kmLogo.ParameterCall;
import kmLogo.interpreter.kmLogo.StackFrame;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.Variable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ParameterCallImpl extends ExpressionImpl implements ParameterCall {
  private Parameter parameter;

  public void setParameter(Parameter newParameter) {
    Parameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER_CALL__PARAMETER, oldParameter, parameter));
  }

  public Parameter getParameter() {
    return parameter;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PARAMETER_CALL;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmLogo.interpreter.kmLogo.impl.ParameterImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmLogo.interpreter.kmLogo.impl.ParameterImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	return getParameter();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	return parameter != null;
    }
    return super.eIsSet(featureID);
  }

  public double eval(Turtle turtle) {
    double result;
    result = 0.0;
    for(StackFrame frame: turtle.getCallStack().getFrames()) {
      for(Variable var: frame.getVariables()) {
        if(java.util.Objects.equals((var.getName()), (this.getParameter().getName()))) {
          result = var.getValue();
        }
      }
    }
    return result;
  }
}
