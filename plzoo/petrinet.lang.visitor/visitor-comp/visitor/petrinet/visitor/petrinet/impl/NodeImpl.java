package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Node;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;

public abstract class NodeImpl extends MinimalEObjectImpl.Container implements Node {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected EList<Arc> incomming;

  protected EList<Arc> outgoing;

  protected NodeImpl() {
    super();
  }

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
    	getIncomming().addAll((java.util.Collection<? extends visitor.petrinet.visitor.petrinet.Arc>) newValue);
    return;
    case PetrinetPackage.NODE__OUTGOING:
    	getOutgoing().clear();
    	getOutgoing().addAll((java.util.Collection<? extends visitor.petrinet.visitor.petrinet.Arc>) newValue);
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
    	return incomming != null && !incomming.isEmpty();
    case PetrinetPackage.NODE__OUTGOING:
    	return outgoing != null && !outgoing.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
}
