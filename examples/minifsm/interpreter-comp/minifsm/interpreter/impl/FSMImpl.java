package minifsm.interpreter.impl;

import java.lang.Object;
import java.lang.String;
import minifsm.interpreter.FSM;
import minifsm.interpreter.MinifsmPackage;
import minifsm.interpreter.State;
import minifsm.interpreter.Transition;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class FSMImpl extends MinimalEObjectImpl.Container implements FSM {
  private String CURRENTEVENT_EDEFAULT = null;

  private String currentEvent = CURRENTEVENT_EDEFAULT;

  private EList<State> states;

  private EList<Transition> transitions;

  private State currentState;

  public String getCurrentEvent() {
    return currentEvent;}

  public void setCurrentEvent(String currentEvent) {
    this.currentEvent = currentEvent;}

  public EList<State> getStates() {
    if(states == null) {
    	states = new EObjectContainmentEList<State>(minifsm.interpreter.State.class, this, MinifsmPackage.FSM__STATES);
    }
    return states;
  }

  public EList<Transition> getTransitions() {
    if(transitions == null) {
    	transitions = new EObjectContainmentEList<Transition>(minifsm.interpreter.Transition.class, this, MinifsmPackage.FSM__TRANSITIONS);
    }
    return transitions;
  }

  public void setCurrentState(State newCurrentState) {
    if (newCurrentState != currentState) {
    	NotificationChain msgs = null;
    	if (currentState != null)
    		msgs = ((InternalEObject) currentState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinifsmPackage.FSM__CURRENT_STATE, null, msgs);
    	if (newCurrentState != null)
    		msgs = ((InternalEObject) newCurrentState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinifsmPackage.FSM__CURRENT_STATE, null, msgs);
    	msgs = basicSetCurrentState(newCurrentState, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.FSM__CURRENT_STATE, newCurrentState, newCurrentState));
  }

  private NotificationChain basicSetCurrentState(State newCurrentState, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    State oldCurrentState = currentState;
    currentState = newCurrentState;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinifsmPackage.FSM__CURRENT_STATE,
    			oldCurrentState, newCurrentState);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public State getCurrentState() {
    return currentState;}

  protected EClass eStaticClass() {
    return MinifsmPackage.Literals.FSM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MinifsmPackage.FSM__STATES:
    	getStates().clear();
    	getStates().addAll((java.util.Collection<? extends minifsm.interpreter.impl.StateImpl>) newValue);
    return;
    case MinifsmPackage.FSM__TRANSITIONS:
    	getTransitions().clear();
    	getTransitions().addAll((java.util.Collection<? extends minifsm.interpreter.impl.TransitionImpl>) newValue);
    return;
    case MinifsmPackage.FSM__CURRENT_STATE:
    	setCurrentState((minifsm.interpreter.impl.StateImpl) newValue);
    return;
    case MinifsmPackage.FSM__CURRENT_EVENT:
    	setCurrentEvent((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MinifsmPackage.FSM__STATES:
    	getStates().clear();
    return;
    case MinifsmPackage.FSM__TRANSITIONS:
    	getTransitions().clear();
    return;
    case MinifsmPackage.FSM__CURRENT_STATE:
    	setCurrentState((minifsm.interpreter.impl.StateImpl) null);
    return;
    case MinifsmPackage.FSM__CURRENT_EVENT:
    	setCurrentEvent(CURRENTEVENT_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MinifsmPackage.FSM__STATES:
    	return getStates();
    case MinifsmPackage.FSM__TRANSITIONS:
    	return getTransitions();
    case MinifsmPackage.FSM__CURRENT_STATE:
    	return getCurrentState();
    case MinifsmPackage.FSM__CURRENT_EVENT:
    	return getCurrentEvent();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MinifsmPackage.FSM__STATES:
    	return states != null;
    case MinifsmPackage.FSM__TRANSITIONS:
    	return transitions != null;
    case MinifsmPackage.FSM__CURRENT_STATE:
    	return currentState != null;
    case MinifsmPackage.FSM__CURRENT_EVENT:
    	return currentEvent != CURRENTEVENT_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case MinifsmPackage.FSM__TRANSITIONS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getTransitions()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public void handle(String event) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Handle ") + (event));
    this.setCurrentEvent(event);
    this.setCurrentState(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getTransitions(), (t) -> t.isActivated())).getOutgoing());
  }

  public void entryPoint() {
    EList<String> events = ((EList<String>)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.createEList("event1", "event2"));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("Start");
    this.setCurrentState(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getStates(), it -> it instanceof minifsm.interpreter.Initial)));
    this.getCurrentState().execute();
    for(String event: events) {
      this.handle(event);
      this.getCurrentState().execute();
    }
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("End");
  }
}
