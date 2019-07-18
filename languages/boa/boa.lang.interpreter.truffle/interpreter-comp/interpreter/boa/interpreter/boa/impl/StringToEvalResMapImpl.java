package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "StringToEvalResMap"
)
public class StringToEvalResMapImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements BasicEMap.Entry<String, EvalResImpl> {
	protected static final String KEY_EDEFAULT = null;

	protected String key = KEY_EDEFAULT;

	protected EvalResImpl value;

	protected int hash = -1;

	protected StringToEvalResMapImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.STRING_TO_EVAL_RES_MAP;
	}

	@TruffleBoundary
	public String getTypedKey() {
		return key;
	}

	@TruffleBoundary
	public void setTypedKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.STRING_TO_EVAL_RES_MAP__KEY, oldKey, key));
	}

	@TruffleBoundary
	public EvalResImpl getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject) value;
			value = (EvalResImpl) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE, oldValue, value));
			}
		}
		return value;
	}

	public EvalResImpl basicGetTypedValue() {
		return value;
	}

	@TruffleBoundary
	public void setTypedValue(EvalResImpl newValue) {
		EvalResImpl oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE, oldValue, value));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				return getTypedKey();
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				if (resolve)
					return getTypedValue();
				return basicGetTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				setTypedKey((String) newValue);
				return;
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				setTypedValue((EvalResImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				setTypedKey(KEY_EDEFAULT);
				return;
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				setTypedValue((EvalResImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY :
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE :
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	@TruffleBoundary
	public void setHash(int hash) {
		this.hash = hash;
	}

	public String getKey() {
		return getTypedKey();
	}

	public void setKey(String key) {
		setTypedKey(key);
	}

	public EvalResImpl getValue() {
		return getTypedValue();
	}

	public EvalResImpl setValue(EvalResImpl value) {
		EvalResImpl oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	@TruffleBoundary
	public EMap<String, EvalResImpl> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<String, EvalResImpl>)container.eGet(eContainmentFeature());
	}
}
