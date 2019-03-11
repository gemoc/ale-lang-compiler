package test1.interpreter.test1.impl;

import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import test1.interpreter.test1.ConceptB;
import test1.interpreter.test1.Test1Package;

public class ConceptBImpl extends ConceptAImpl implements ConceptB {
  protected ConceptBImpl() {
    super();
  }

  protected EClass eStaticClass() {
    return Test1Package.Literals.CONCEPT_B;}

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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void exec() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("okb");
        ;
  }

  public int execB() {
    int result;
    result = 1;
        ;
    return result;
  }
}
