package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Mult;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

public class MultImpl extends BinaryExpImpl implements Mult {
  protected MultImpl() {
    super();
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.MULT;}

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
    result = (this.getLhs().eval(turtle)) * (this.getRhs().eval(turtle));
    return result;
  }
}
