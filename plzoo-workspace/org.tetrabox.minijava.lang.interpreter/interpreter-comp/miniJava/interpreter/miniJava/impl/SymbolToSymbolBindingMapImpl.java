package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class SymbolToSymbolBindingMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<Symbol, SymbolBinding> {
  protected Symbol key;

  protected SymbolBinding value;

  protected int hash = -1;

  protected SymbolToSymbolBindingMapImpl() {
    super();
  }

  public void setKey(Symbol newKey) {
    Symbol oldKey = key;
    key = newKey;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY, oldKey, key));
  }

  public Symbol getKey() {
    if (key != null && key.eIsProxy()) {
    	InternalEObject oldkey = (InternalEObject) key;
    	key = (Symbol) eResolveProxy(oldkey);
    	if (key != oldkey) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY,
    					oldkey, key));
    	}
    }
    return key;
  }

  public SymbolBinding setValue(SymbolBinding newValue) {
    SymbolBinding oldValue = this.value;
    this.value = newValue;
    return oldValue;
  }

  public SymbolBinding getValue() {
    if (value != null && value.eIsProxy()) {
    	InternalEObject oldvalue = (InternalEObject) value;
    	value = (SymbolBinding) eResolveProxy(oldvalue);
    	if (value != oldvalue) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE,
    					oldvalue, value));
    	}
    }
    return value;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.SYMBOL_TO_SYMBOL_BINDING_MAP;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
    	setKey((miniJava.interpreter.miniJava.Symbol) newValue);
    return;
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
    	setValue((miniJava.interpreter.miniJava.SymbolBinding) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
    	setKey((miniJava.interpreter.miniJava.Symbol) null);
    return;
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
    	setValue((miniJava.interpreter.miniJava.SymbolBinding) null);
    return;
    }
    super.eUnset(featureID);
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

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
    	return key != null;
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void setHash(int hash) {
    this.hash = hash;
  }

  public int getHash() {
    if (hash == -1) {
    	Object theKey = getKey();
    	hash = (theKey == null ? 0 : theKey.hashCode());
    }
    return hash;
  }
}
