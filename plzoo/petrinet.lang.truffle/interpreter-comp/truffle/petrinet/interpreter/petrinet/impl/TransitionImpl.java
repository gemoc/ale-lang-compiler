package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import truffle.petrinet.interpreter.petrinet.Arc;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;
import truffle.petrinet.interpreter.petrinet.Transition;

@NodeInfo(
    description = "Transition"
)
public class TransitionImpl extends NodeImpl implements Transition {
  protected TransitionImpl() {
    super();
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.TRANSITION;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
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
