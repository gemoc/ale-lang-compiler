package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;

public class SymbolToSymbolBindingMapImpl extends MinimalEObjectImpl.Container
		implements BasicEMap.Entry<Symbol, SymbolBinding> {
	protected int hash = -1;

	protected Symbol key;

	protected SymbolBinding value;

	protected SymbolToSymbolBindingMapImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
			return getKey();
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
			return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
			return key != null;
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
			return value != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
			setKey((Symbol) newValue);
			return;
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
			setValue((SymbolBinding) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.SYMBOL_TO_SYMBOL_BINDING_MAP;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
			setKey((Symbol) null);
			return;
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
			setValue((SymbolBinding) null);
			return;
		}
		super.eUnset(featureID);
	}

	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	public Symbol getKey() {
		return key;
	}

	public SymbolBinding getValue() {
		return value;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public void setKey(Symbol newKey) {
		Symbol oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY,
					oldKey, key));
	}

	public SymbolBinding setValue(SymbolBinding newValue) {
		SymbolBinding oldValue = this.value;
		this.value = newValue;
		return oldValue;
	}
}
