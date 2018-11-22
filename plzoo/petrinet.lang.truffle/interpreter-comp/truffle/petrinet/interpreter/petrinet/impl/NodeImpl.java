package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;
import truffle.petrinet.interpreter.petrinet.Arc;
import truffle.petrinet.interpreter.petrinet.Node;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;

@NodeInfo(
    description = "Node"
)
public abstract class NodeImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Node {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected EList<Arc> incomming;

  protected EList<Arc> outgoing;

  @CompilationFinal
  private NodeDispatchWrapperFire cachedFire;

  protected NodeImpl() {
    super();
    this.cachedFire = new truffle.petrinet.interpreter.petrinet.impl.NodeDispatchWrapperFire(this);
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  @TruffleBoundary
  public EList<Arc> getIncomming() {
    if (incomming == null) {
    	incomming = new EObjectContainmentWithInverseEList<Arc>(Arc.class, this, PetrinetPackage.NODE__INCOMMING, PetrinetPackage.ARC__TARGET);
    }
    return incomming;
  }

  @TruffleBoundary
  public EList<Arc> getOutgoing() {
    if (outgoing == null) {
    	outgoing = new EObjectContainmentWithInverseEList<Arc>(Arc.class, this, PetrinetPackage.NODE__OUTGOING, PetrinetPackage.ARC__SOURCE);
    }
    return outgoing;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return PetrinetPackage.Literals.NODE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PetrinetPackage.NODE__NAME:
    	setName((java.lang.String) newValue);
    return;
    case PetrinetPackage.NODE__INCOMMING:
    	getIncomming().clear();
    	getIncomming().addAll((java.util.Collection<? extends truffle.petrinet.interpreter.petrinet.Arc>) newValue);
    return;
    case PetrinetPackage.NODE__OUTGOING:
    	getOutgoing().clear();
    	getOutgoing().addAll((java.util.Collection<? extends truffle.petrinet.interpreter.petrinet.Arc>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
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

  @TruffleBoundary
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

  @TruffleBoundary
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

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
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
        ;
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
        ;
    return result;
  }

  public void fire() {
    ;
  }

  public void removeToken() {
    ;
  }

  public void addToken() {
    ;
  }

  public NodeDispatchWrapperFire getCachedFire() {
    return this.cachedFire;
  }
}
