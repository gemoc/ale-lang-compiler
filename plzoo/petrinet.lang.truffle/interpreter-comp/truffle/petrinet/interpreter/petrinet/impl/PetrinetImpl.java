package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;
import truffle.petrinet.interpreter.petrinet.Arc;
import truffle.petrinet.interpreter.petrinet.Node;
import truffle.petrinet.interpreter.petrinet.Petrinet;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;

@NodeInfo(
    description = "Petrinet"
)
public class PetrinetImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Petrinet {
  protected EList<Node> nodes;

  protected EList<Arc> arcs;

  @Children
  private Node[] nodesArr;

  private NodeDispatchFire dispatchNodeFire;

  protected PetrinetImpl() {
    super();
    this.dispatchNodeFire = truffle.petrinet.interpreter.petrinet.impl.NodeDispatchFireNodeGen.create(); 
  }

  @TruffleBoundary
  public EList<Node> getNodes() {
    if(nodes == null) {
    	nodes = new EObjectContainmentEList<Node>(truffle.petrinet.interpreter.petrinet.Node.class, this, PetrinetPackage.PETRINET__NODES);
    }
    return nodes;
  }

  @TruffleBoundary
  public EList<Arc> getArcs() {
    if(arcs == null) {
    	arcs = new EObjectContainmentEList<Arc>(truffle.petrinet.interpreter.petrinet.Arc.class, this, PetrinetPackage.PETRINET__ARCS);
    }
    return arcs;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.PETRINET;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    	getNodes().clear();
    	getNodes().addAll((java.util.Collection<? extends truffle.petrinet.interpreter.petrinet.Node>) newValue);
    return;
    case PetrinetPackage.PETRINET__ARCS:
    	getArcs().clear();
    	getArcs().addAll((java.util.Collection<? extends truffle.petrinet.interpreter.petrinet.Arc>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
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

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    return getNodes();
    case PetrinetPackage.PETRINET__ARCS:
    return getArcs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PetrinetPackage.PETRINET__NODES:
    	return nodes != null && !nodes.isEmpty();
    case PetrinetPackage.PETRINET__ARCS:
    	return arcs != null && !arcs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case truffle.petrinet.interpreter.petrinet.PetrinetPackage.PETRINET__NODES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
    case truffle.petrinet.interpreter.petrinet.PetrinetPackage.PETRINET__ARCS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArcs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void run() {
    if(this.nodesArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.nodesArr = this.nodes.toArray(new truffle.petrinet.interpreter.petrinet.Node[0]);
        			};
    int x = ((int)0);
        boolean stop = ((boolean)false);
        while (!(stop)) {
          truffle.petrinet.interpreter.petrinet.Node enabledNode = ((truffle.petrinet.interpreter.petrinet.Node)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.nodesArr, (n) -> n.canFire())));
          if((enabledNode) != (null)) {
            x = (x) + (1);
            dispatchNodeFire.executeDispatch(enabledNode.getCachedFire(), new Object[] {});
          }
          else {
            stop = true;
          }
        }
        org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(x);
        ;
  }
}
