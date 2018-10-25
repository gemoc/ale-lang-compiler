/**
 */
package boa_dynamic.impl;

import boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.EvalRes;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class StringToEvalResMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, EvalRes> {
	protected static final String KEY_EDEFAULT = null;

	protected String key = KEY_EDEFAULT;

	protected EvalRes value;

	protected StringToEvalResMapImpl() {
		super();
	}

	public String getKey() {
		return getTypedKey();
	}

	public void setKey(String key) {
		setTypedKey(key);
	}

	public EvalRes setValue(EvalRes value) {
		EvalRes oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}
	
	public EvalRes getValue() {
		return getTypedValue();
	}

	protected EClass eStaticClass() {
		return Boa_dynamicPackage.Literals.STRING_TO_EVAL_RES_MAP;
	}
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__KEY:
			setTypedKey((String) newValue);
			return;
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__VALUE:
			setTypedValue((EvalRes) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}
	
	public void eUnset(int featureID) {
		switch (featureID) {
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__KEY:
			setTypedKey(KEY_EDEFAULT);
			return;
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__VALUE:
			setTypedValue((EvalRes) null);
			return;
		}
		super.eUnset(featureID);
	}
	
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__KEY:
			return getTypedKey();
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__VALUE:
			if (resolve)
				return getTypedValue();
			return basicGetTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__KEY:
			return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
		case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__VALUE:
			return value != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvalRes getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (EvalRes)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvalRes basicGetTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedValue(EvalRes newValue) {
		EvalRes oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP__VALUE, oldValue, value));
	}

	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (key: ");
		result.append(key);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected int hash = -1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, EvalRes> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<String, EvalRes>)container.eGet(eContainmentFeature());
	}

} // StringToEvalResMapImpl
