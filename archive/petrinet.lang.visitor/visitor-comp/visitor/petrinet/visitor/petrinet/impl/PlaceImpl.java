package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.petrinet.visitor.petrinet.Place;
import visitor.visitor.VisitorInterface;

public class PlaceImpl extends NodeImpl implements Place {
  protected static final int TOKENNB_EDEFAULT = 0;

  protected int tokenNb = TOKENNB_EDEFAULT;

  protected PlaceImpl() {
    super();
  }

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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Object accept(VisitorInterface visitor) {
    return visitor.visitpetrinet__Place(this);}
}
