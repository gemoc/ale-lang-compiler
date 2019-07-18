package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
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
		description = "SymbolToSymbolBindingMap"
)
public class SymbolToSymbolBindingMapImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements BasicEMap.Entry<SymbolImpl, SymbolBindingImpl> {
	protected SymbolImpl key;

	protected SymbolBindingImpl value;

	protected int hash = -1;

	protected SymbolToSymbolBindingMapImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.SYMBOL_TO_SYMBOL_BINDING_MAP;
	}

	@TruffleBoundary
	public SymbolImpl getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject) key;
			key = (SymbolImpl) eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY, oldKey, key));
			}
		}
		return key;
	}

	public SymbolImpl basicGetTypedKey() {
		return key;
	}

	@TruffleBoundary
	public void setTypedKey(SymbolImpl newKey) {
		SymbolImpl oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY, oldKey, key));
	}

	@TruffleBoundary
	public SymbolBindingImpl getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject) value;
			value = (SymbolBindingImpl) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE, oldValue, value));
			}
		}
		return value;
	}

	public SymbolBindingImpl basicGetTypedValue() {
		return value;
	}

	@TruffleBoundary
	public void setTypedValue(SymbolBindingImpl newValue) {
		SymbolBindingImpl oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE, oldValue, value));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY :
				if (resolve)
					return getTypedKey();
				return basicGetTypedKey();
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE :
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
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY :
				setTypedKey((SymbolImpl) newValue);
				return;
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE :
				setTypedValue((SymbolBindingImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY :
				setTypedKey((SymbolImpl) null);
				return;
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE :
				setTypedValue((SymbolBindingImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY :
				return key != null;
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE :
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

	public SymbolImpl getKey() {
		return getTypedKey();
	}

	public void setKey(SymbolImpl key) {
		setTypedKey(key);
	}

	public SymbolBindingImpl getValue() {
		return getTypedValue();
	}

	public SymbolBindingImpl setValue(SymbolBindingImpl value) {
		SymbolBindingImpl oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	@TruffleBoundary
	public EMap<SymbolImpl, SymbolBindingImpl> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<SymbolImpl, SymbolBindingImpl>)container.eGet(eContainmentFeature());
	}
}
