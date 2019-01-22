package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;

@NodeInfo(
    description = "SymbolToSymbolBindingMap"
)
public class SymbolToSymbolBindingMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<Symbol, SymbolBinding> {
  protected Symbol key;

  protected SymbolBinding value;

  protected int hash = -1;

  protected SymbolToSymbolBindingMapImpl() {
    super();
  }

  @TruffleBoundary
  public void setKey(Symbol newKey) {
    Symbol oldKey = key;
    key = newKey;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY, oldKey, key));
  }

  @TruffleBoundary
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

  @TruffleBoundary
  public SymbolBinding setValue(SymbolBinding newValue) {
    SymbolBinding oldValue = this.value;
    this.value = newValue;
    return oldValue;
  }

  @TruffleBoundary
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

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.SYMBOL_TO_SYMBOL_BINDING_MAP;}

  @TruffleBoundary
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

  @TruffleBoundary
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

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
    return getKey();
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__KEY:
    	return key != null;
    case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
  public void setHash(int hash) {
    this.hash = hash;
  }

  @TruffleBoundary
  public int getHash() {
    if (hash == -1) {
    	Object theKey = getKey();
    	hash = (theKey == null ? 0 : theKey.hashCode());
    }
    return hash;
  }
}
