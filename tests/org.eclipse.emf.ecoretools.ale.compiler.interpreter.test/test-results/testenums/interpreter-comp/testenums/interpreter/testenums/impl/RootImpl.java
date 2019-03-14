
package testenums.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import testenums.Enum1;
import testenums.Root;
import testenums.TestenumsPackage;


public class RootImpl extends MinimalEObjectImpl.Container implements Root {
	
	protected static final Enum1 ENUM_EDEFAULT = Enum1.LITERAL0;

	
	protected Enum1 enum_ = ENUM_EDEFAULT;

	
	protected EList<Enum1> enums;

	
	protected RootImpl() {
		super();
	}

	
	@Override
	protected EClass eStaticClass() {
		return TestenumsPackage.Literals.ROOT;
	}

	
	public Enum1 getEnum() {
		return enum_;
	}

	
	public void setEnum(Enum1 newEnum) {
		Enum1 oldEnum = enum_;
		enum_ = newEnum == null ? ENUM_EDEFAULT : newEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestenumsPackage.ROOT__ENUM, oldEnum, enum_));
	}

	
	public EList<Enum1> getEnums() {
		if (enums == null) {
			enums = new EDataTypeUniqueEList<Enum1>(Enum1.class, this, TestenumsPackage.ROOT__ENUMS);
		}
		return enums;
	}

	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestenumsPackage.ROOT__ENUM:
				return getEnum();
			case TestenumsPackage.ROOT__ENUMS:
				return getEnums();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestenumsPackage.ROOT__ENUM:
				setEnum((Enum1)newValue);
				return;
			case TestenumsPackage.ROOT__ENUMS:
				getEnums().clear();
				getEnums().addAll((Collection<? extends Enum1>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestenumsPackage.ROOT__ENUM:
				setEnum(ENUM_EDEFAULT);
				return;
			case TestenumsPackage.ROOT__ENUMS:
				getEnums().clear();
				return;
		}
		super.eUnset(featureID);
	}

	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestenumsPackage.ROOT__ENUM:
				return enum_ != ENUM_EDEFAULT;
			case TestenumsPackage.ROOT__ENUMS:
				return enums != null && !enums.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (enum: ");
		result.append(enum_);
		result.append(", enums: ");
		result.append(enums);
		result.append(')');
		return result.toString();
	}

} //RootImpl
