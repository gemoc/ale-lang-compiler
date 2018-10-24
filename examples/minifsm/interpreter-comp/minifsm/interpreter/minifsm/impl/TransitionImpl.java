package minifsm.interpreter.minifsm.impl;

import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.String;
import minifsm.interpreter.minifsm.FSM;
import minifsm.interpreter.minifsm.MinifsmPackage;
import minifsm.interpreter.minifsm.State;
import minifsm.interpreter.minifsm.Transition;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
  protected static final String EVENT_EDEFAULT = null;

  protected String event = EVENT_EDEFAULT;

  protected State incoming;

  protected State outgoing;

  protected TransitionImpl() {
    super();
  }

  public String getEvent() {
    return event;}

  public void setEvent(String event) {
    this.event = event;}

  public void setIncoming(State newIncoming) {
    State oldIncoming = incoming;
    incoming = newIncoming;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__INCOMING, oldIncoming, incoming));
  }

  public State getIncoming() {
    return incoming;}

  public void setOutgoing(State newOutgoing) {
    State oldOutgoing = outgoing;
    outgoing = newOutgoing;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__OUTGOING, oldOutgoing, outgoing));
  }

  public State getOutgoing() {
    return outgoing;}

  public void setFsm(FSM newFsm) {
    if (newFsm != eInternalContainer() || (eContainerFeatureID() != MinifsmPackage.TRANSITION__FSM && newFsm != null)) {
    	if (EcoreUtil.isAncestor(this, newFsm))
    		throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
    	NotificationChain msgs = null;
    	if (eInternalContainer() != null)
    		msgs = eBasicRemoveFromContainer(msgs);
    	if (newFsm != null)
    		msgs = ((InternalEObject)newFsm).eInverseAdd(this, MinifsmPackage.TRANSITION__FSM , FSM.class, msgs);
    	msgs = basicSetFsm(newFsm, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__FSM , newFsm, newFsm));
  }

  private NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newFsm, MinifsmPackage.TRANSITION__FSM, msgs);
    return msgs;
  }

  public FSM getFsm() {
    if (eContainerFeatureID() != MinifsmPackage.TRANSITION__FSM) return null;
    return (FSM)eInternalContainer();
  }

  protected EClass eStaticClass() {
    return MinifsmPackage.Literals.TRANSITION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MinifsmPackage.TRANSITION__INCOMING:
    	setIncoming((minifsm.interpreter.minifsm.State) newValue);
    return;
    case MinifsmPackage.TRANSITION__OUTGOING:
    	setOutgoing((minifsm.interpreter.minifsm.State) newValue);
    return;
    case MinifsmPackage.TRANSITION__FSM:
    	setFsm((minifsm.interpreter.minifsm.FSM) newValue);
    return;
    case MinifsmPackage.TRANSITION__EVENT:
    	setEvent((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MinifsmPackage.TRANSITION__INCOMING:
    	setIncoming((minifsm.interpreter.minifsm.State) null);
    return;
    case MinifsmPackage.TRANSITION__OUTGOING:
    	setOutgoing((minifsm.interpreter.minifsm.State) null);
    return;
    case MinifsmPackage.TRANSITION__FSM:
    	setFsm((minifsm.interpreter.minifsm.FSM) null);
    return;
    case MinifsmPackage.TRANSITION__EVENT:
    	setEvent(EVENT_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MinifsmPackage.TRANSITION__INCOMING:
    	return getIncoming();
    case MinifsmPackage.TRANSITION__OUTGOING:
    	return getOutgoing();
    case MinifsmPackage.TRANSITION__FSM:
    	return getFsm();
    case MinifsmPackage.TRANSITION__EVENT:
    	return getEvent();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MinifsmPackage.TRANSITION__INCOMING:
    	return incoming != null;
    case MinifsmPackage.TRANSITION__OUTGOING:
    	return outgoing != null;
    case MinifsmPackage.TRANSITION__FSM:
    	return getFsm() != null;
    case MinifsmPackage.TRANSITION__EVENT:
    	return event != EVENT_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case MinifsmPackage.TRANSITION__FSM:
    	if (eInternalContainer() != null)
    			msgs = eBasicRemoveFromContainer(msgs);
    		return basicSetFsm((minifsm.interpreter.minifsm.FSM)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public boolean isActivated() {
    boolean result;
    result = ((java.util.Objects.equals((this.getEvent()), (this.getFsm().getCurrentEvent()))) && (java.util.Objects.equals((this.getIncoming()), (this.getFsm().getCurrentState()))));
    return result;
  }
}
