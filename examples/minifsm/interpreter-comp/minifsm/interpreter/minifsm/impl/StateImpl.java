package minifsm.interpreter.minifsm.impl;

import java.lang.Object;
import java.lang.String;
import minifsm.interpreter.minifsm.MinifsmPackage;
import minifsm.interpreter.minifsm.State;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class StateImpl extends MinimalEObjectImpl.Container implements State {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected StateImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  protected EClass eStaticClass() {
    return MinifsmPackage.Literals.STATE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MinifsmPackage.STATE__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MinifsmPackage.STATE__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MinifsmPackage.STATE__NAME:
    	return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MinifsmPackage.STATE__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public void execute() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log((" Execute ") + (this.getName()));
  }
}
