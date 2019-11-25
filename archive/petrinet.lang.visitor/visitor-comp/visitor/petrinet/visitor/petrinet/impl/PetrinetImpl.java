package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Node;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.visitor.VisitorInterface;

public class PetrinetImpl extends MinimalEObjectImpl.Container implements Petrinet {
  protected EList<Node> nodes;

  protected EList<Arc> arcs;

  protected PetrinetImpl() {
    super();
  }

  public EList<Node> getNodes() {
    if(nodes == null) {
    	nodes = new EObjectContainmentEList<Node>(visitor.petrinet.visitor.petrinet.Node.class, this, PetrinetPackage.PETRINET__NODES);
    }
    return nodes;
  }

  public EList<Arc> getArcs() {
    if(arcs == null) {
    	arcs = new EObjectContainmentEList<Arc>(visitor.petrinet.visitor.petrinet.Arc.class, this, PetrinetPackage.PETRINET__ARCS);
    }
    return arcs;
  }

  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.PETRINET;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    	getNodes().clear();
    	getNodes().addAll((java.util.Collection<? extends visitor.petrinet.visitor.petrinet.Node>) newValue);
    return;
    case PetrinetPackage.PETRINET__ARCS:
    	getArcs().clear();
    	getArcs().addAll((java.util.Collection<? extends visitor.petrinet.visitor.petrinet.Arc>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    	getNodes().clear();
    return;
    case PetrinetPackage.PETRINET__ARCS:
    	getArcs().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    return getNodes();
    case PetrinetPackage.PETRINET__ARCS:
    return getArcs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    	return nodes != null && !nodes.isEmpty();
    case PetrinetPackage.PETRINET__ARCS:
    	return arcs != null && !arcs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case visitor.petrinet.visitor.petrinet.PetrinetPackage.PETRINET__NODES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
    case visitor.petrinet.visitor.petrinet.PetrinetPackage.PETRINET__ARCS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArcs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Object accept(VisitorInterface visitor) {
    return visitor.visitpetrinet__Petrinet(this);}
}
