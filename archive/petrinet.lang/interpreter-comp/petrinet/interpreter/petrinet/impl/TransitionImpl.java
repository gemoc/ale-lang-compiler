package petrinet.interpreter.petrinet.impl;

import java.lang.Object;
import org.eclipse.emf.ecore.EClass;
import petrinet.interpreter.petrinet.Arc;
import petrinet.interpreter.petrinet.PetrinetPackage;
import petrinet.interpreter.petrinet.Transition;

public class TransitionImpl extends NodeImpl implements Transition {
  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.TRANSITION;}

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

  public boolean canFire() {
    boolean result;
    result = !(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getIncomming(), (it) -> it.canFire())));
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
    return result;
  }

  public void fire() {
    for(Arc it: this.getIncomming()) {
      it.removeToken();
    }
    for(Arc it: this.getOutgoing()) {
      it.addToken();
    }
  }

  public void removeToken() {
  }

  public void addToken() {
  }
}
