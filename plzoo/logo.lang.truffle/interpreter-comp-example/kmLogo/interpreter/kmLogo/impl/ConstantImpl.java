package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import kmLogo.interpreter.kmLogo.Constant;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;

@NodeInfo(description = "Constant")
public class ConstantImpl extends ExpressionImpl implements Constant {
	protected static final double VALUE_EDEFAULT = 0.0;

	protected double value = VALUE_EDEFAULT;

	protected ConstantImpl() {
		super();
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CONSTANT;
	}

	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KmLogoPackage.CONSTANT__VALUE:
			setValue((double) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
		case KmLogoPackage.CONSTANT__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KmLogoPackage.CONSTANT__VALUE:
			return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KmLogoPackage.CONSTANT__VALUE:
			return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public double eval(Turtle turtle) {
		double result;
		result = this.getValue();
		return result;
	}
}
