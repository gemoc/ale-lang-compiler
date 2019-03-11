package test1.interpreter.test1.impl;

import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import test1.interpreter.test1.ConceptC;
import test1.interpreter.test1.Test1Package;

public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
  protected static final int NBR_EDEFAULT = 0;

  protected int nbr = NBR_EDEFAULT;

  protected ConceptCImpl() {
    super();
  }

  public int getNbr() {
    return nbr;}

  public void setNbr(int nbr) {
    this.nbr = nbr;}

  protected EClass eStaticClass() {
    return Test1Package.Literals.CONCEPT_C;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case Test1Package.CONCEPT_C__NBR:
    	setNbr((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case Test1Package.CONCEPT_C__NBR:
    	setNbr(NBR_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case Test1Package.CONCEPT_C__NBR:
    return getNbr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case Test1Package.CONCEPT_C__NBR:
    	return nbr != NBR_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void call() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(this.nbr);
        ;
  }
}
