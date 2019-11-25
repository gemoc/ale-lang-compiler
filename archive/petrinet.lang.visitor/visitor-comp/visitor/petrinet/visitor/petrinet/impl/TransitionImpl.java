package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.petrinet.visitor.petrinet.Transition;
import visitor.visitor.VisitorInterface;

public class TransitionImpl extends NodeImpl implements Transition {
  protected TransitionImpl() {
    super();
  }

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

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Object accept(VisitorInterface visitor) {
    return visitor.visitpetrinet__Transition(this);}
}
