package minifsm.interpreter.impl;

import java.lang.Object;
import minifsm.interpreter.MinifsmPackage;
import minifsm.interpreter.Terminal;
import org.eclipse.emf.ecore.EClass;

public class TerminalImpl extends StateImpl implements Terminal {
  protected EClass eStaticClass() {
    return MinifsmPackage.Literals.TERMINAL;}

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
}
