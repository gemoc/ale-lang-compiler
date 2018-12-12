package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.StringValue;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class StringValueImpl extends ValueImpl implements StringValue {
  protected static final String VALUE_EDEFAULT = null;

  protected String value = VALUE_EDEFAULT;

  protected StringValueImpl() {
    super();
  }

  public String getValue() {
    return value;}

  public void setValue(String value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.STRING_VALUE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
    	setValue((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STRING_VALUE__VALUE:
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
