package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Clear;
import kmlogo.interpreter.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class ClearImpl extends PrimitiveImpl implements Clear {
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.CLEAR;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    }
    return super.eIsSet(featureID);
  }

  public double eval(EClassifier turtle) {
    double result;
    result = 0.0;
    return result;
  }
}
