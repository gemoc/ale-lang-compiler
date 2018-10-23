package minifsm.interpreter.impl;

import java.lang.Object;
import java.lang.String;
import minifsm.interpreter.FSM;
import minifsm.interpreter.MinifsmPackage;
import minifsm.interpreter.State;
import minifsm.interpreter.Transition;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
  private String EVENT_EDEFAULT = null;

  private String event = EVENT_EDEFAULT;

  private State incoming;

  private State outgoing;

  private FSM fsm;

  public String getEvent() {
    return event;}

  public void setEvent(String event) {
    this.event = event;}

  public void setIncoming(State newIncoming) {
    if (newIncoming != incoming) {
    	NotificationChain msgs = null;
    	if (incoming != null)
    		msgs = ((InternalEObject) incoming).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinifsmPackage.TRANSITION__INCOMING, null, msgs);
    	if (newIncoming != null)
    		msgs = ((InternalEObject) newIncoming).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinifsmPackage.TRANSITION__INCOMING, null, msgs);
    	msgs = basicSetIncoming(newIncoming, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__INCOMING, newIncoming, newIncoming));
  }

  private NotificationChain basicSetIncoming(State newIncoming, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    State oldIncoming = incoming;
    incoming = newIncoming;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__INCOMING,
    			oldIncoming, newIncoming);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public State getIncoming() {
    return incoming;}

  public void setOutgoing(State newOutgoing) {
    if (newOutgoing != outgoing) {
    	NotificationChain msgs = null;
    	if (outgoing != null)
    		msgs = ((InternalEObject) outgoing).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinifsmPackage.TRANSITION__OUTGOING, null, msgs);
    	if (newOutgoing != null)
    		msgs = ((InternalEObject) newOutgoing).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinifsmPackage.TRANSITION__OUTGOING, null, msgs);
    	msgs = basicSetOutgoing(newOutgoing, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__OUTGOING, newOutgoing, newOutgoing));
  }

  private NotificationChain basicSetOutgoing(State newOutgoing, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    State oldOutgoing = outgoing;
    outgoing = newOutgoing;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__OUTGOING,
    			oldOutgoing, newOutgoing);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public State getOutgoing() {
    return outgoing;}

  public void setFsm(FSM newFsm) {
    if (newFsm != fsm) {
    	NotificationChain msgs = null;
    	if (fsm != null)
    		msgs = ((InternalEObject) fsm).eInverseRemove(this, MinifsmPackage.FSM__TRANSITIONS, minifsm.interpreter.FSM.class, msgs);
    	if (newFsm != null)
    		msgs = ((InternalEObject) newFsm).eInverseAdd(this, MinifsmPackage.FSM__TRANSITIONS, minifsm.interpreter.FSM.class,
    				msgs);
    	msgs = basicSetFsm(newFsm, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__FSM, newFsm, newFsm));
  }

  private NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    FSM oldFsm = fsm;
    fsm = newFsm;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinifsmPackage.TRANSITION__FSM,
    			oldFsm, newFsm);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public FSM getFsm() {
    return fsm;}

  protected EClass eStaticClass() {
    return MinifsmPackage.Literals.TRANSITION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MinifsmPackage.TRANSITION__INCOMING:
    	setIncoming((minifsm.interpreter.impl.StateImpl) newValue);
    return;
    case MinifsmPackage.TRANSITION__OUTGOING:
    	setOutgoing((minifsm.interpreter.impl.StateImpl) newValue);
    return;
    case MinifsmPackage.TRANSITION__FSM:
    	setFsm((minifsm.interpreter.impl.FSMImpl) newValue);
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
    	setIncoming((minifsm.interpreter.impl.StateImpl) null);
    return;
    case MinifsmPackage.TRANSITION__OUTGOING:
    	setOutgoing((minifsm.interpreter.impl.StateImpl) null);
    return;
    case MinifsmPackage.TRANSITION__FSM:
    	setFsm((minifsm.interpreter.impl.FSMImpl) null);
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
    	return fsm != null;
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
    	if (fsm != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) fsm).eInverseRemove(this, MinifsmPackage.FSM__TRANSITIONS, FSM.class,
    				msgs);
    	return basicSetFsm((minifsm.interpreter.FSM) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public boolean isActivated() {
    boolean result;
    result = ((java.util.Objects.equals((this.getEvent()), (this.getFsm().getCurrentEvent()))) && (java.util.Objects.equals((this.getIncoming()), (this.getFsm().getCurrentState()))));
    return result;
  }
}
