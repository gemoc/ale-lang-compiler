package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import interpreter.imp.interpreter.imp.Var;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class VarImpl extends ExprImpl implements Var {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected VarImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  protected EClass eStaticClass() {
    return ImpPackage.Literals.VAR;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluate(Store s) {
    Value result;
    result = s.getValues().get(this.name);
        ;
    return result;
  }
}
