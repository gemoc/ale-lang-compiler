package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.PenDown;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.ecore.EClass;

public class PenDownImpl extends PrimitiveImpl implements PenDown {
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PENDOWN;}

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
    turtle.setPenUp(false);
    result = 0.0;
    return result;
  }
}
