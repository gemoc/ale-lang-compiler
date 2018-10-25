package petrinet.interpreter.petrinet.impl;

import java.lang.Object;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import petrinet.interpreter.petrinet.Arc;
import petrinet.interpreter.petrinet.Node;
import petrinet.interpreter.petrinet.Petrinet;
import petrinet.interpreter.petrinet.PetrinetPackage;

public class PetrinetImpl extends MinimalEObjectImpl.Container implements Petrinet {
  private EList<Node> nodes;

  private EList<Arc> arcs;

  public EList<Node> getNodes() {
    if(nodes == null) {
    	nodes = new EObjectContainmentEList<Node>(petrinet.interpreter.petrinet.Node.class, this, PetrinetPackage.PETRINET__NODES);
    }
    return nodes;
  }

  public EList<Arc> getArcs() {
    if(arcs == null) {
    	arcs = new EObjectContainmentEList<Arc>(petrinet.interpreter.petrinet.Arc.class, this, PetrinetPackage.PETRINET__ARCS);
    }
    return arcs;
  }

  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.PETRINET;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    	getNodes().clear();
    	getNodes().addAll((java.util.Collection<? extends petrinet.interpreter.petrinet.impl.NodeImpl>) newValue);
    return;
    case PetrinetPackage.PETRINET__ARCS:
    	getArcs().clear();
    	getArcs().addAll((java.util.Collection<? extends petrinet.interpreter.petrinet.impl.ArcImpl>) newValue);
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
    	return nodes != null;
    case PetrinetPackage.PETRINET__ARCS:
    	return arcs != null;
    }
    return super.eIsSet(featureID);
  }

  public void run() {
    boolean stop = ((boolean)false);
    while (!(stop)) {
      Node enabledNode = ((Node)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getNodes(), (n) -> n.canFire())));
      if((enabledNode) != (null)) {
        enabledNode.fire();
      }
      else {
        stop = true;
      }
    }
  }
}
