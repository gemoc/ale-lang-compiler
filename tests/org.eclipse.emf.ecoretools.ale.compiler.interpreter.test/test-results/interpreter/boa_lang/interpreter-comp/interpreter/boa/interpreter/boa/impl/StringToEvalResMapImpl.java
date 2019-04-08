package interpreter.boa.interpreter.boa.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.EvalRes;

public class StringToEvalResMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, EvalRes> {
	protected static final String KEY_EDEFAULT = null;

	protected String key = KEY_EDEFAULT;

	protected EvalRes value;

	protected int hash = -1;

	protected StringToEvalResMapImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.STRING_TO_EVAL_RES_MAP;
	}

	public String getTypedKey() {
		return key;
	}

	public void setTypedKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.STRING_TO_EVAL_RES_MAP__KEY, oldKey, key));
	}

	public EvalRes getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (EvalRes)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE, oldValue, value));
			}
		}
		return value;
	}

	public EvalRes basicGetTypedValue() {
		return value;
	}

	public void setTypedValue(EvalRes newValue) {
		EvalRes oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE, oldValue, value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				return getTypedKey();
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				if (resolve) return getTypedValue();
				return basicGetTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				setTypedKey((String)newValue);
				return;
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				setTypedValue((EvalRes)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				setTypedKey(KEY_EDEFAULT);
				return;
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				setTypedValue((EvalRes)null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public String getKey() {
		return getTypedKey();
	}

	public void setKey(String key) {
		setTypedKey(key);
	}

	public EvalRes getValue() {
		return getTypedValue();
	}

	public EvalRes setValue(EvalRes value) {
		EvalRes oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	public EMap<String, EvalRes> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<String, EvalRes>)container.eGet(eContainmentFeature());
	}
}
