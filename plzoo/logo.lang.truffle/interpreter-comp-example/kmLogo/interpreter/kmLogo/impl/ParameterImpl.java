package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Parameter;

@NodeInfo(description = "Parameter")
public class ParameterImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Parameter {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected ParameterImpl() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PARAMETER;
	}

	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER__NAME:
			setName((java.lang.String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER__NAME:
			setName(NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER__NAME:
			return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KmLogoPackage.PARAMETER__NAME:
			return name != NAME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
}
