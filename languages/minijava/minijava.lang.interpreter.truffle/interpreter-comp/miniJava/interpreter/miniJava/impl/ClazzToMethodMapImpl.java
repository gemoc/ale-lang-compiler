package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "ClazzToMethodMap"
)
public class ClazzToMethodMapImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements BasicEMap.Entry<Clazz, Method> {
	protected Clazz key;

	protected Method value;

	protected int hash = -1;

	protected ClazzToMethodMapImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.CLAZZ_TO_METHOD_MAP;
	}

	@TruffleBoundary
	public Clazz getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject) key;
			key = (Clazz) eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY, oldKey, key));
			}
		}
		return key;
	}

	public Clazz basicGetTypedKey() {
		return key;
	}

	@TruffleBoundary
	public void setTypedKey(Clazz newKey) {
		Clazz oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY, oldKey, key));
	}

	@TruffleBoundary
	public Method getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject) value;
			value = (Method) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE, oldValue, value));
			}
		}
		return value;
	}

	public Method basicGetTypedValue() {
		return value;
	}

	@TruffleBoundary
	public void setTypedValue(Method newValue) {
		Method oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE, oldValue, value));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY :
				if (resolve)
					return getTypedKey();
				return basicGetTypedKey();
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE :
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
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY :
				setTypedKey((Clazz) newValue);
				return;
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE :
				setTypedValue((Method) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY :
				setTypedKey((Clazz) null);
				return;
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE :
				setTypedValue((Method) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY :
				return key != null;
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE :
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

	public Clazz getKey() {
		return getTypedKey();
	}

	public void setKey(Clazz key) {
		setTypedKey(key);
	}

	public Method getValue() {
		return getTypedValue();
	}

	public Method setValue(Method value) {
		Method oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	@TruffleBoundary
	public EMap<Clazz, Method> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<Clazz, Method>)container.eGet(eContainmentFeature());
	}
}
