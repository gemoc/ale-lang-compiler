package petrinet.interpreter.petrinet.impl;

import java.lang.Object;
import org.eclipse.emf.ecore.EClass;
import petrinet.interpreter.petrinet.PetrinetPackage;
import petrinet.interpreter.petrinet.Place;

public class PlaceImpl extends NodeImpl implements Place {
  private static final int TOKENNB_EDEFAULT = 0;

  private int tokenNb = TOKENNB_EDEFAULT;

  public int getTokenNb() {
    return tokenNb;}

  public void setTokenNb(int tokenNb) {
    this.tokenNb = tokenNb;}

  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.PLACE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	setTokenNb((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	setTokenNb(TOKENNB_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	return getTokenNb();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	return tokenNb != TOKENNB_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public boolean canFire() {
    boolean result;
    result = false;
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = (this.getTokenNb()) > (0);
    return result;
  }

  public void fire() {
  }

  public void removeToken() {
    this.setTokenNb((this.getTokenNb()) - (1));
  }

  public void addToken() {
    this.setTokenNb((this.getTokenNb()) + (1));
  }
}
