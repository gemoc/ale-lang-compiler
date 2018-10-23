package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Lower;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.ecore.EClass;

public class LowerImpl extends BinaryExpImpl implements Lower {
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.LOWER;}

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

  public double eval(Turtle turtle) {
    double result;
    if((this.getLhs().eval(turtle)) < (this.getRhs().eval(turtle))) {
      result = 1.0;
    }
    else {
      result = 0.0;
    }
    return result;
  }
}
