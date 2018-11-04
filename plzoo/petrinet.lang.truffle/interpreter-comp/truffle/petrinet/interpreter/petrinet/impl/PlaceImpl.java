package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;
import truffle.petrinet.interpreter.petrinet.Place;

@NodeInfo(
    description = "Place"
)
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

  @TruffleBoundary
  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.PLACE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	setTokenNb((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	setTokenNb(TOKENNB_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    return getTokenNb();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PLACE__TOKEN_NB:
    	return tokenNb != TOKENNB_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
