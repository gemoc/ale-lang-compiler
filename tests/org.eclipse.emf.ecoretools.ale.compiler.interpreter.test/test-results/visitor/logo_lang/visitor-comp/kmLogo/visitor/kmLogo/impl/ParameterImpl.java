package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Parameter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ParameterImpl extends MinimalEObjectImpl.Container implements Parameter {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected ParameterImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PARAMETER;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PARAMETER__NAME, oldName, name));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER__NAME :
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER__NAME :
				setName((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER__NAME :
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PARAMETER__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Parameter(this);
	}
}
