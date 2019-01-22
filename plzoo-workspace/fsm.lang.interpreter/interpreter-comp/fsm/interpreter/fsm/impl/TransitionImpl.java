package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.Transition;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
  protected static final String NAME_EDEFAULT = null;

  protected static final String TRIGGER_EDEFAULT = null;

  protected static final String ACTION_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected String trigger = TRIGGER_EDEFAULT;

  protected String action = ACTION_EDEFAULT;

  protected State tgt;

  protected State src;

  protected TransitionImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public String getTrigger() {
    return trigger;}

  public void setTrigger(String trigger) {
    this.trigger = trigger;}

  public String getAction() {
    return action;}

  public void setAction(String action) {
    this.action = action;}

  public void setTgt(State newTgt) {
    if (newTgt != tgt) {
    	NotificationChain msgs = null;
    	if (tgt != null)
    		msgs = ((InternalEObject) tgt).eInverseRemove(this, FsmPackage.STATE__INCOMING, fsm.interpreter.fsm.State.class, msgs);
    	if (newTgt != null)
    		msgs = ((InternalEObject) newTgt).eInverseAdd(this, FsmPackage.STATE__INCOMING, fsm.interpreter.fsm.State.class,
    				msgs);
    	msgs = basicSetTgt(newTgt, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__TGT, newTgt, newTgt));
  }

  private NotificationChain basicSetTgt(State newTgt, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    State oldTgt = tgt;
    tgt = newTgt;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__TGT,
    			oldTgt, newTgt);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public State getTgt() {
    if (tgt != null && tgt.eIsProxy()) {
    	InternalEObject oldtgt = (InternalEObject) tgt;
    	tgt = (State) eResolveProxy(oldtgt);
    	if (tgt != oldtgt) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.TRANSITION__TGT,
    					oldtgt, tgt));
    	}
    }
    return tgt;
  }

  public void setSrc(State newSrc) {
    if (newSrc != src) {
    	NotificationChain msgs = null;
    	if (src != null)
    		msgs = ((InternalEObject) src).eInverseRemove(this, FsmPackage.STATE__OUTGOING, fsm.interpreter.fsm.State.class, msgs);
    	if (newSrc != null)
    		msgs = ((InternalEObject) newSrc).eInverseAdd(this, FsmPackage.STATE__OUTGOING, fsm.interpreter.fsm.State.class,
    				msgs);
    	msgs = basicSetSrc(newSrc, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__SRC, newSrc, newSrc));
  }

  private NotificationChain basicSetSrc(State newSrc, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    State oldSrc = src;
    src = newSrc;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__SRC,
    			oldSrc, newSrc);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public State getSrc() {
    if (src != null && src.eIsProxy()) {
    	InternalEObject oldsrc = (InternalEObject) src;
    	src = (State) eResolveProxy(oldsrc);
    	if (src != oldsrc) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.TRANSITION__SRC,
    					oldsrc, src));
    	}
    }
    return src;
  }

  public void setFsm(FSM newFsm) {
    if (newFsm != eInternalContainer() || (eContainerFeatureID() != FsmPackage.TRANSITION__FSM && newFsm != null)) {
    	if (EcoreUtil.isAncestor(this, newFsm))
    		throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
    	NotificationChain msgs = null;
    	if (eInternalContainer() != null)
    		msgs = eBasicRemoveFromContainer(msgs);
    	if (newFsm != null)
    		msgs = ((InternalEObject)newFsm).eInverseAdd(this, FsmPackage.FSM__OWNED_TRANSITIONS , FSM.class, msgs);
    	msgs = basicSetFsm(newFsm, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__FSM , newFsm, newFsm));
  }

  public NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newFsm, FsmPackage.TRANSITION__FSM, msgs);
    return msgs;
  }

  public FSM getFsm() {
    if (eContainerFeatureID() != FsmPackage.TRANSITION__FSM) return null;
    return (FSM)eInternalContainer();
  }

  protected EClass eStaticClass() {
    return FsmPackage.Literals.TRANSITION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FsmPackage.TRANSITION__TGT:
    	setTgt((fsm.interpreter.fsm.State) newValue);
    return;
    case FsmPackage.TRANSITION__NAME:
    	setName((java.lang.String) newValue);
    return;
    case FsmPackage.TRANSITION__SRC:
    	setSrc((fsm.interpreter.fsm.State) newValue);
    return;
    case FsmPackage.TRANSITION__FSM:
    	setFsm((fsm.interpreter.fsm.FSM) newValue);
    return;
    case FsmPackage.TRANSITION__TRIGGER:
    	setTrigger((java.lang.String) newValue);
    return;
    case FsmPackage.TRANSITION__ACTION:
    	setAction((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case FsmPackage.TRANSITION__TGT:
    	setTgt((fsm.interpreter.fsm.State) null);
    return;
    case FsmPackage.TRANSITION__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case FsmPackage.TRANSITION__SRC:
    	setSrc((fsm.interpreter.fsm.State) null);
    return;
    case FsmPackage.TRANSITION__FSM:
    	setFsm((fsm.interpreter.fsm.FSM) null);
    return;
    case FsmPackage.TRANSITION__TRIGGER:
    	setTrigger(TRIGGER_EDEFAULT);
    return;
    case FsmPackage.TRANSITION__ACTION:
    	setAction(ACTION_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FsmPackage.TRANSITION__TGT:
    return getTgt();
    case FsmPackage.TRANSITION__NAME:
    return getName();
    case FsmPackage.TRANSITION__SRC:
    return getSrc();
    case FsmPackage.TRANSITION__FSM:
    return getFsm();
    case FsmPackage.TRANSITION__TRIGGER:
    return getTrigger();
    case FsmPackage.TRANSITION__ACTION:
    return getAction();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FsmPackage.TRANSITION__TGT:
    	return tgt != null;
    case FsmPackage.TRANSITION__NAME:
    	return name != NAME_EDEFAULT;
    case FsmPackage.TRANSITION__SRC:
    	return src != null;
    case FsmPackage.TRANSITION__FSM:
    	return getFsm() != null;
    case FsmPackage.TRANSITION__TRIGGER:
    	return trigger != TRIGGER_EDEFAULT;
    case FsmPackage.TRANSITION__ACTION:
    	return action != ACTION_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case fsm.interpreter.fsm.FsmPackage.TRANSITION__TGT:
    	return basicSetTgt(null, msgs);
    case fsm.interpreter.fsm.FsmPackage.TRANSITION__SRC:
    	return basicSetSrc(null, msgs);
    case fsm.interpreter.fsm.FsmPackage.TRANSITION__FSM:
    	return basicSetFsm(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case FsmPackage.TRANSITION__TGT:
    	if (tgt != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) tgt).eInverseRemove(this, FsmPackage.STATE__INCOMING, State.class,
    				msgs);
    	return basicSetTgt((fsm.interpreter.fsm.State) otherEnd, msgs);

    case FsmPackage.TRANSITION__SRC:
    	if (src != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) src).eInverseRemove(this, FsmPackage.STATE__OUTGOING, State.class,
    				msgs);
    	return basicSetSrc((fsm.interpreter.fsm.State) otherEnd, msgs);

    case FsmPackage.TRANSITION__FSM:
    	if (eInternalContainer() != null)
    			msgs = eBasicRemoveFromContainer(msgs);
    		return basicSetFsm((fsm.interpreter.fsm.FSM)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public void fire() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(((("Firing ") + (this.name)) + (" and entering ")) + (this.tgt.getName()));
        fsm.interpreter.fsm.FSM fsm = ((fsm.interpreter.fsm.FSM)this.src.getFsm());
        fsm.setCurrentState(this.tgt);
        fsm.getOutputBuffer().enqueue(this.action);
        fsm.setConsummedString((fsm.getConsummedString()) + (fsm.getUnderProcessTrigger()));
        ;
  }
}
