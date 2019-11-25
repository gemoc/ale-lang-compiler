package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;

public class StoreImpl extends MinimalEObjectImpl.Container implements Store {
  protected EMap<String, Value> values;

  protected StoreImpl() {
    super();
  }

  public EMap<String, Value> getValues() {
    if (values == null) {
    	values = new EcoreEMap<String, Value>(ImpPackage.Literals.STRING_TO_VALUE_MAP, StringToValueMapImpl.class, this, ImpPackage.STORE__VALUES);
    }
    return values;
  }

  protected EClass eStaticClass() {
    return ImpPackage.Literals.STORE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.STORE__VALUES:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getValues()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.STORE__VALUES:
    	getValues().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.STORE__VALUES:
    if (coreType)
    	return getValues();
    else
    	return getValues().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.STORE__VALUES:
    	return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.STORE__VALUES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
