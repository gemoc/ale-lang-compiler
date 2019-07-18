package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "ParameterCall"
)
public class ParameterCallImpl extends ExpressionImpl {
	protected ParameterImpl parameter;

	protected ParameterCallImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PARAMETER_CALL;
	}

	@TruffleBoundary
	public ParameterImpl getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject) parameter;
			parameter = (ParameterImpl) eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KmLogoPackage.PARAMETER_CALL__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	public ParameterImpl basicGetParameter() {
		return parameter;
	}

	@TruffleBoundary
	public void setParameter(ParameterImpl newParameter) {
		ParameterImpl oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER_CALL__PARAMETER, oldParameter, parameter));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER_CALL__PARAMETER :
				if (resolve)
					return getParameter();
				return basicGetParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER_CALL__PARAMETER :
				setParameter((ParameterImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER_CALL__PARAMETER :
				setParameter((ParameterImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER_CALL__PARAMETER :
				return parameter != null;
		}
		return super.eIsSet(featureID);
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) (0.0) ;
		for (StackFrameImpl frame : turtle.getCallStack().getFrames()) {
			for (VariableImpl var : frame.getVariables()) {
				if (EqualService.equals((var.getName()), (this.getParameter().getName()))) {
					result = (double) (var.getValue()) ;
				}
			}
		}
		return result;
	}
}
