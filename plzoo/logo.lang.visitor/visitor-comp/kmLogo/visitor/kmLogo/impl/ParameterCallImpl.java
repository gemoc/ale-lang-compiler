package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Parameter;
import kmLogo.visitor.kmLogo.ParameterCall;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class ParameterCallImpl extends ExpressionImpl implements ParameterCall {
  protected Parameter parameter;

  protected ParameterCallImpl() {
    super();
  }

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
    	setParameter((kmLogo.visitor.kmLogo.Parameter) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER_CALL__PARAMETER:
    	setParameter((kmLogo.visitor.kmLogo.Parameter) null);
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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__ParameterCall(this);}
}
