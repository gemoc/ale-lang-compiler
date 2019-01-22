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

import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaPackage;

@NodeInfo(
    description = "ClazzToMethodMap"
)
public class ClazzToMethodMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<Clazz, Method> {
  protected Clazz key;

  protected Method value;

  protected int hash = -1;

  protected ClazzToMethodMapImpl() {
    super();
  }

  @TruffleBoundary
  public void setKey(Clazz newKey) {
    Clazz oldKey = key;
    key = newKey;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY, oldKey, key));
  }

  @TruffleBoundary
  public Clazz getKey() {
    if (key != null && key.eIsProxy()) {
    	InternalEObject oldkey = (InternalEObject) key;
    	key = (Clazz) eResolveProxy(oldkey);
    	if (key != oldkey) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY,
    					oldkey, key));
    	}
    }
    return key;
  }

  @TruffleBoundary
  public Method setValue(Method newValue) {
    Method oldValue = this.value;
    this.value = newValue;
    return oldValue;
  }

  @TruffleBoundary
  public Method getValue() {
    if (value != null && value.eIsProxy()) {
    	InternalEObject oldvalue = (InternalEObject) value;
    	value = (Method) eResolveProxy(oldvalue);
    	if (value != oldvalue) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE,
    					oldvalue, value));
    	}
    }
    return value;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.CLAZZ_TO_METHOD_MAP;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY:
    	setKey((miniJava.interpreter.miniJava.Clazz) newValue);
    return;
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE:
    	setValue((miniJava.interpreter.miniJava.Method) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY:
    	setKey((miniJava.interpreter.miniJava.Clazz) null);
    return;
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE:
    	setValue((miniJava.interpreter.miniJava.Method) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY:
    return getKey();
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__KEY:
    	return key != null;
    case MiniJavaPackage.CLAZZ_TO_METHOD_MAP__VALUE:
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
