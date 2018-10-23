package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Sin;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.ecore.EClass;

public class SinImpl extends UnaryExpressionImpl implements Sin {
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.SIN;}

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
    result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.sinus(this.getExpression().eval(turtle));
    return result;
  }
}
