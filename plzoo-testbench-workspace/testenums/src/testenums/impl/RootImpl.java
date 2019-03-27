/**
 */
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testenums.impl.RootImpl#getEnum <em>Enum</em>}</li>
 *   <li>{@link testenums.impl.RootImpl#getEnums <em>Enums</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootImpl extends MinimalEObjectImpl.Container implements Root {
	/**
	 * The default value of the '{@link #getEnum() <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnum()
	 * @generated
	 * @ordered
	 */
	protected static final Enum1 ENUM_EDEFAULT = Enum1.LITERAL0;

	/**
	 * The cached value of the '{@link #getEnum() <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnum()
	 * @generated
	 * @ordered
	 */
	protected Enum1 enum_ = ENUM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnums() <em>Enums</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnums()
	 * @generated
	 * @ordered
	 */
	protected EList<Enum1> enums;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestenumsPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enum1 getEnum() {
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnum(Enum1 newEnum) {
		Enum1 oldEnum = enum_;
		enum_ = newEnum == null ? ENUM_EDEFAULT : newEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestenumsPackage.ROOT__ENUM, oldEnum, enum_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enum1> getEnums() {
		if (enums == null) {
			enums = new EDataTypeUniqueEList<Enum1>(Enum1.class, this, TestenumsPackage.ROOT__ENUMS);
		}
		return enums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
