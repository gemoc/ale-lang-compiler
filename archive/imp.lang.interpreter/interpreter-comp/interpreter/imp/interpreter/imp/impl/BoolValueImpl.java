package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.BoolValue;
import interpreter.imp.interpreter.imp.ImpPackage;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class BoolValueImpl extends ValueImpl implements BoolValue {
  protected static final boolean VALUE_EDEFAULT = false;

  protected boolean value = VALUE_EDEFAULT;

  protected BoolValueImpl() {
    super();
  }

  public boolean isValue() {
    return value;}

  public void setValue(boolean value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return ImpPackage.Literals.BOOL_VALUE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.BOOL_VALUE__VALUE:
    	setValue((boolean) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.BOOL_VALUE__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.BOOL_VALUE__VALUE:
    return isValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.BOOL_VALUE__VALUE:
    	return value != VALUE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
