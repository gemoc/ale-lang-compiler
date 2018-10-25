/**
 */
package kmLogo.impl;

import kmLogo.KmLogoPackage;
import kmLogo.Parameter;
import kmLogo.ParameterCall;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ParameterCallImpl extends ExpressionImpl implements ParameterCall {
	protected Parameter parameter;

	protected ParameterCallImpl() {
		super();
	}

	public void setParameter(Parameter newParameter) {
		Parameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER_CALL__PARAMETER, oldParameter,
					parameter));
	}

	public Parameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject) parameter;
			parameter = (Parameter) eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KmLogoPackage.PARAMETER_CALL__PARAMETER,
							oldParameter, parameter));
			}
		}
		return parameter;
	}

	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PARAMETER_CALL;
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER_CALL__PARAMETER:
			setParameter((Parameter) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER_CALL__PARAMETER:
			setParameter((Parameter) null);
			return;
		}
		super.eUnset(featureID);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER_CALL__PARAMETER:
			if (resolve)
				return getParameter();
			return basicGetParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public Parameter basicGetParameter() {
		return parameter;
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER_CALL__PARAMETER:
			return parameter != null;
		}
		return super.eIsSet(featureID);
	}

} // ParameterCallImpl
