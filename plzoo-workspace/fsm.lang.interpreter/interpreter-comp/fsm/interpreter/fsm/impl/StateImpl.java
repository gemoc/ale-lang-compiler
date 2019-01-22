package fsm.interpreter.fsm.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.Transition;

public class StateImpl extends MinimalEObjectImpl.Container implements State {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected EList<Transition> incoming;

  protected EList<Transition> outgoing;

  protected StateImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public EList<Transition> getIncoming() {
    if (incoming == null) {
    	incoming = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, FsmPackage.STATE__INCOMING, FsmPackage.TRANSITION__TGT);
    }
    return incoming;
  }

  public EList<Transition> getOutgoing() {
    if (outgoing == null) {
    	outgoing = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, FsmPackage.STATE__OUTGOING, FsmPackage.TRANSITION__SRC);
    }
    return outgoing;
  }

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

  public NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newFsm, FsmPackage.STATE__FSM, msgs);
    return msgs;
  }

  public FSM getFsm() {
    if (eContainerFeatureID() != FsmPackage.STATE__FSM) return null;
    return (FSM)eInternalContainer();
  }

  protected EClass eStaticClass() {
    return FsmPackage.Literals.STATE;}

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
    List<fsm.interpreter.fsm.Transition> validTransitions = ((List<fsm.interpreter.fsm.Transition>)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getOutgoing(), (t) -> org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((inputString), (t.getTrigger()))));
        if(org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(validTransitions)), (0))) {
          this.getFsm().getOutputBuffer().enqueue(inputString);
        }
        if((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(validTransitions)) > (1)) {
          org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("Non Determinism");
        }
        if(org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(validTransitions)), (1))) {
          org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(validTransitions, 0).fire();
        }
        ;
  }
}
