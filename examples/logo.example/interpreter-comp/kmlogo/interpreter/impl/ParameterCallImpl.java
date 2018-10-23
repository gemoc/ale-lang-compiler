package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Parameter;
import kmlogo.interpreter.ParameterCall;
import kmlogo.interpreter.StackFrame;
import kmlogo.interpreter.Turtle;
import kmlogo.interpreter.Variable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ParameterCallImpl extends ExpressionImpl implements ParameterCall {
  private Parameter parameter;

  public void setParameter(Parameter newParameter) {
    if (newParameter != parameter) {
    	NotificationChain msgs = null;
    	if (parameter != null)
    		msgs = ((InternalEObject) parameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.PARAMETER_CALL__PARAMETER, null, msgs);
    	if (newParameter != null)
    		msgs = ((InternalEObject) newParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.PARAMETER_CALL__PARAMETER, null, msgs);
    	msgs = basicSetParameter(newParameter, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER_CALL__PARAMETER, newParameter, newParameter));
  }

  private NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Parameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER_CALL__PARAMETER,
    			oldParameter, newParameter);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Parameter getParameter() {
    return parameter;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PARAMETERCALL;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmlogo.interpreter.impl.ParameterImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmlogo.interpreter.impl.ParameterImpl) null);
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
