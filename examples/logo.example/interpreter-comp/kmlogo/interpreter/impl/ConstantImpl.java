package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.Constant;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Turtle;
import org.eclipse.emf.ecore.EClass;

public class ConstantImpl extends ExpressionImpl implements Constant {
  private double VALUE_EDEFAULT = 0.0;

  private double value = VALUE_EDEFAULT;

  public double getValue() {
    return value;}

  public void setValue(double value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.CONSTANT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.CONSTANT__VALUE:
    	setValue((double) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CONSTANT__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.CONSTANT__VALUE:
    	return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CONSTANT__VALUE:
    	return value != VALUE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public double eval(Turtle turtle) {
    double result;
    result = this.getValue();
    return result;
  }
}
