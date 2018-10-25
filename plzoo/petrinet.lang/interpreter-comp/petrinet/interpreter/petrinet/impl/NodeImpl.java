package petrinet.interpreter.petrinet.impl;

import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import petrinet.interpreter.petrinet.Arc;
import petrinet.interpreter.petrinet.Node;
import petrinet.interpreter.petrinet.PetrinetPackage;

public abstract class NodeImpl extends MinimalEObjectImpl.Container implements Node {
  private static final String NAME_EDEFAULT = null;

  private String name = NAME_EDEFAULT;

  private EList<Arc> incomming;

  private EList<Arc> outgoing;

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public EList<Arc> getIncomming() {
    if (incomming == null) {
    	incomming = new EObjectContainmentWithInverseEList<Arc>(Arc.class, this, PetrinetPackage.NODE__INCOMMING, PetrinetPackage.ARC__TARGET);
    }
    return incomming;
  }

  public EList<Arc> getOutgoing() {
    if (outgoing == null) {
    	outgoing = new EObjectContainmentWithInverseEList<Arc>(Arc.class, this, PetrinetPackage.NODE__OUTGOING, PetrinetPackage.ARC__SOURCE);
    }
    return outgoing;
  }

  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.NODE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.NODE__NAME:
    	setName((java.lang.String) newValue);
    return;
    case PetrinetPackage.NODE__INCOMMING:
    	getIncomming().clear();
    	getIncomming().addAll((java.util.Collection<? extends petrinet.interpreter.petrinet.impl.ArcImpl>) newValue);
    return;
    case PetrinetPackage.NODE__OUTGOING:
    	getOutgoing().clear();
    	getOutgoing().addAll((java.util.Collection<? extends petrinet.interpreter.petrinet.impl.ArcImpl>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case PetrinetPackage.NODE__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case PetrinetPackage.NODE__INCOMMING:
    	getIncomming().clear();
    return;
    case PetrinetPackage.NODE__OUTGOING:
    	getOutgoing().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PetrinetPackage.NODE__NAME:
    	return getName();
    case PetrinetPackage.NODE__INCOMMING:
    	return getIncomming();
    case PetrinetPackage.NODE__OUTGOING:
    	return getOutgoing();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PetrinetPackage.NODE__NAME:
    	return name != NAME_EDEFAULT;
    case PetrinetPackage.NODE__INCOMMING:
    	return incomming != null;
    case PetrinetPackage.NODE__OUTGOING:
    	return outgoing != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case PetrinetPackage.NODE__INCOMMING:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getIncomming()).basicAdd(otherEnd, msgs);

    case PetrinetPackage.NODE__OUTGOING:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getOutgoing()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public boolean canFire() {
    boolean result;
    result = false;
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
    return result;
  }

  public void fire() {
  }

  public void removeToken() {
  }

  public void addToken() {
  }
}
