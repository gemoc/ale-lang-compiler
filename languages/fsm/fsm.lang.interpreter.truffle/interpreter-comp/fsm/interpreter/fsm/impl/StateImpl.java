package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.Transition;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
    description = "State"
)
public class StateImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements State {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected EList<Transition> incoming;

  protected EList<Transition> outgoing;

  @Children
  private Transition[] outgoingArr;

  @CompilationFinal
  private StateDispatchWrapperStep cachedStep;

  protected StateImpl() {
    super();
    this.cachedStep = new fsm.interpreter.fsm.impl.StateDispatchWrapperStep(this);
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  @TruffleBoundary
  public EList<Transition> getIncoming() {
    if (incoming == null) {
    	incoming = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, FsmPackage.STATE__INCOMING, FsmPackage.TRANSITION__TGT);
    }
    return incoming;
  }

  @TruffleBoundary
  public EList<Transition> getOutgoing() {
    if (outgoing == null) {
    	outgoing = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, FsmPackage.STATE__OUTGOING, FsmPackage.TRANSITION__SRC);
    }
    return outgoing;
  }

  @TruffleBoundary
  public void setFsm(FSM newFsm) {
    if (newFsm != eInternalContainer() || (eContainerFeatureID() != FsmPackage.STATE__FSM && newFsm != null)) {
    	if (EcoreUtil.isAncestor(this, newFsm))
    		throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
    	NotificationChain msgs = null;
    	if (eInternalContainer() != null)
    		msgs = eBasicRemoveFromContainer(msgs);
    	if (newFsm != null)
    		msgs = ((InternalEObject)newFsm).eInverseAdd(this, FsmPackage.FSM__OWNED_STATES , FSM.class, msgs);
    	msgs = basicSetFsm(newFsm, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.STATE__FSM , newFsm, newFsm));
  }

  @TruffleBoundary
  public NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newFsm, FsmPackage.STATE__FSM, msgs);
    return msgs;
  }

  @TruffleBoundary
  public FSM getFsm() {
    if (eContainerFeatureID() != FsmPackage.STATE__FSM) return null;
    return (FSM)eInternalContainer();
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return FsmPackage.Literals.STATE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FsmPackage.STATE__INCOMING:
    	getIncoming().clear();
    	getIncoming().addAll((java.util.Collection<? extends fsm.interpreter.fsm.Transition>) newValue);
    return;
    case FsmPackage.STATE__NAME:
    	setName((java.lang.String) newValue);
    return;
    case FsmPackage.STATE__OUTGOING:
    	getOutgoing().clear();
    	getOutgoing().addAll((java.util.Collection<? extends fsm.interpreter.fsm.Transition>) newValue);
    return;
    case FsmPackage.STATE__FSM:
    	setFsm((fsm.interpreter.fsm.FSM) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case FsmPackage.STATE__INCOMING:
    	getIncoming().clear();
    return;
    case FsmPackage.STATE__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case FsmPackage.STATE__OUTGOING:
    	getOutgoing().clear();
    return;
    case FsmPackage.STATE__FSM:
    	setFsm((fsm.interpreter.fsm.FSM) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FsmPackage.STATE__INCOMING:
    return getIncoming();
    case FsmPackage.STATE__NAME:
    return getName();
    case FsmPackage.STATE__OUTGOING:
    return getOutgoing();
    case FsmPackage.STATE__FSM:
    return getFsm();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FsmPackage.STATE__INCOMING:
    	return incoming != null && !incoming.isEmpty();
    case FsmPackage.STATE__NAME:
    	return name != NAME_EDEFAULT;
    case FsmPackage.STATE__OUTGOING:
    	return outgoing != null && !outgoing.isEmpty();
    case FsmPackage.STATE__FSM:
    	return getFsm() != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case fsm.interpreter.fsm.FsmPackage.STATE__INCOMING:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getIncoming()).basicRemove(otherEnd, msgs);
    case fsm.interpreter.fsm.FsmPackage.STATE__OUTGOING:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getOutgoing()).basicRemove(otherEnd, msgs);
    case fsm.interpreter.fsm.FsmPackage.STATE__FSM:
    	return basicSetFsm(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case FsmPackage.STATE__INCOMING:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getIncoming()).basicAdd(otherEnd, msgs);

    case FsmPackage.STATE__OUTGOING:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getOutgoing()).basicAdd(otherEnd, msgs);

    case FsmPackage.STATE__FSM:
    	if (eInternalContainer() != null)
    			msgs = eBasicRemoveFromContainer(msgs);
    		return basicSetFsm((fsm.interpreter.fsm.FSM)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public void step(String inputString) {
    if(this.outgoingArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.outgoing != null) this.outgoingArr = this.outgoing.toArray(new fsm.interpreter.fsm.Transition[0]);
        				else this.outgoingArr = new fsm.interpreter.fsm.Transition[] {};
        				
        			};
    fsm.interpreter.fsm.Transition validTransition = ((fsm.interpreter.fsm.Transition)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.outgoingArr, (t) -> org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((inputString), (t.getTrigger())))));
        if(org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((validTransition), (null))) {
          this.getFsm().getOutputBuffer().enqueue(inputString);
        }
        else {
          validTransition.fire();
        }
        ;
  }

  public StateDispatchWrapperStep getCachedStep() {
    return this.cachedStep;
  }
}
