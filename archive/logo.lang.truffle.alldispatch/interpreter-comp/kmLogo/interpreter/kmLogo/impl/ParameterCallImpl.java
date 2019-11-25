package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Parameter;
import kmLogo.interpreter.kmLogo.ParameterCall;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "ParameterCall"
)
public class ParameterCallImpl extends ExpressionImpl implements ParameterCall {
  protected Parameter parameter;

  protected ParameterCallImpl() {
    super();
  }

  @TruffleBoundary
  public void setParameter(Parameter newParameter) {
    Parameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER_CALL__PARAMETER, oldParameter, parameter));
  }

  @TruffleBoundary
  public Parameter getParameter() {
    return parameter;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PARAMETER_CALL;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmLogo.interpreter.kmLogo.Parameter) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmLogo.interpreter.kmLogo.Parameter) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    return getParameter();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	return parameter != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public double eval(Turtle turtle) {
    double result;
    result = 0.0;
        for(kmLogo.interpreter.kmLogo.StackFrame frame: turtle.getCallStack().getFrames()) {
          for(kmLogo.interpreter.kmLogo.Variable var: frame.getVariables()) {
            if(java.util.Objects.equals((var.getName()), (this.parameter.getName()))) {
              result = var.getValue();
            }
          }
        }
        ;
    return result;
  }
}
