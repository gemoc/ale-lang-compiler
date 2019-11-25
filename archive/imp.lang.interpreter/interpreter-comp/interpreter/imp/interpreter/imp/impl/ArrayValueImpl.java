package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ArrayValue;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class ArrayValueImpl extends ValueImpl implements ArrayValue {
  protected EList<Value> values;

  protected ArrayValueImpl() {
    super();
  }

  public EList<Value> getValues() {
    if(values == null) {
    	values = new EObjectContainmentEList<Value>(interpreter.imp.interpreter.imp.Value.class, this, ImpPackage.ARRAY_VALUE__VALUES);
    }
    return values;
  }

  protected EClass eStaticClass() {
    return ImpPackage.Literals.ARRAY_VALUE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.ARRAY_VALUE__VALUES:
    	getValues().clear();
    	getValues().addAll((java.util.Collection<? extends interpreter.imp.interpreter.imp.Value>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.ARRAY_VALUE__VALUES:
    	getValues().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.ARRAY_VALUE__VALUES:
    return getValues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.ARRAY_VALUE__VALUES:
    	return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.ARRAY_VALUE__VALUES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
