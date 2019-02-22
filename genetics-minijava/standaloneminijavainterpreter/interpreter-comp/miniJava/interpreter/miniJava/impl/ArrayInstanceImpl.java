package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class ArrayInstanceImpl extends MinimalEObjectImpl.Container implements ArrayInstance {
  protected static final int SIZE_EDEFAULT = 0;

  protected int size = SIZE_EDEFAULT;

  protected EList<Value> value;

  protected ArrayInstanceImpl() {
    super();
  }

  public int getSize() {
    return size;}

  public void setSize(int size) {
    this.size = size;}

  @TruffleBoundary
  public EList<Value> getValue() {
    if(value == null) {
    	value = new EObjectContainmentEList<Value>(miniJava.interpreter.miniJava.Value.class, this, MiniJavaPackage.ARRAY_INSTANCE__VALUE);
    }
    return value;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.ARRAY_INSTANCE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
    	getValue().clear();
    	getValue().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Value>) newValue);
    return;
    case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
    	setSize((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
    	getValue().clear();
    return;
    case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
    	setSize(SIZE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
    return getValue();
    case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
    return getSize();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
    	return value != null && !value.isEmpty();
    case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
    	return size != SIZE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.ARRAY_INSTANCE__VALUE:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValue()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
