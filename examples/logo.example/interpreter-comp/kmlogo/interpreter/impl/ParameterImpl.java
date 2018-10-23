package kmlogo.interpreter.impl;

import java.lang.Object;
import java.lang.String;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Parameter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ParameterImpl extends MinimalEObjectImpl.Container implements Parameter {
  private String NAME_EDEFAULT = null;

  private String name = NAME_EDEFAULT;

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PARAMETER;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER__NAME:
    	return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PARAMETER__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }
}
