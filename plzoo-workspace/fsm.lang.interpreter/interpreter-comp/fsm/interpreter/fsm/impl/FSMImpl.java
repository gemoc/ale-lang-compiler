package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.Transition;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;

public class FSMImpl extends MinimalEObjectImpl.Container implements FSM {
  protected static final String NAME_EDEFAULT = null;

  protected static final String UNDERPROCESSTRIGGER_EDEFAULT = null;

  protected static final String CONSUMMEDSTRING_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected String underProcessTrigger = UNDERPROCESSTRIGGER_EDEFAULT;

  protected String consummedString = CONSUMMEDSTRING_EDEFAULT;

  protected EList<State> ownedStates;

  protected EList<Transition> ownedTransitions;

  protected Buffer inputBuffer;

  protected Buffer outputBuffer;

  protected State initialState;

  protected State currentState;

  protected FSMImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public String getUnderProcessTrigger() {
    return underProcessTrigger;}

  public void setUnderProcessTrigger(String underProcessTrigger) {
    this.underProcessTrigger = underProcessTrigger;}

  public String getConsummedString() {
    return consummedString;}

  public void setConsummedString(String consummedString) {
    this.consummedString = consummedString;}

  public EList<State> getOwnedStates() {
    if (ownedStates == null) {
    	ownedStates = new EObjectContainmentWithInverseEList<State>(State.class, this, FsmPackage.FSM__OWNED_STATES, FsmPackage.STATE__FSM);
    }
    return ownedStates;
  }

  public EList<Transition> getOwnedTransitions() {
    if (ownedTransitions == null) {
    	ownedTransitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, FsmPackage.FSM__OWNED_TRANSITIONS, FsmPackage.TRANSITION__FSM);
    }
    return ownedTransitions;
  }

  public void setInputBuffer(Buffer newInputBuffer) {
    if (newInputBuffer != inputBuffer) {
    	NotificationChain msgs = null;
    	if (inputBuffer != null)
    		msgs = ((InternalEObject) inputBuffer).eInverseRemove(this, FsmPackage.BUFFER__OUTGOING_FSM, fsm.interpreter.fsm.Buffer.class, msgs);
    	if (newInputBuffer != null)
    		msgs = ((InternalEObject) newInputBuffer).eInverseAdd(this, FsmPackage.BUFFER__OUTGOING_FSM, fsm.interpreter.fsm.Buffer.class,
    				msgs);
    	msgs = basicSetInputBuffer(newInputBuffer, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INPUT_BUFFER, newInputBuffer, newInputBuffer));
  }

  private NotificationChain basicSetInputBuffer(Buffer newInputBuffer, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Buffer oldInputBuffer = inputBuffer;
    inputBuffer = newInputBuffer;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INPUT_BUFFER,
    			oldInputBuffer, newInputBuffer);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Buffer getInputBuffer() {
    if (inputBuffer != null && inputBuffer.eIsProxy()) {
    	InternalEObject oldinputBuffer = (InternalEObject) inputBuffer;
    	inputBuffer = (Buffer) eResolveProxy(oldinputBuffer);
    	if (inputBuffer != oldinputBuffer) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__INPUT_BUFFER,
    					oldinputBuffer, inputBuffer));
    	}
    }
    return inputBuffer;
  }

  public void setOutputBuffer(Buffer newOutputBuffer) {
    if (newOutputBuffer != outputBuffer) {
    	NotificationChain msgs = null;
    	if (outputBuffer != null)
    		msgs = ((InternalEObject) outputBuffer).eInverseRemove(this, FsmPackage.BUFFER__INCOMING_FSM, fsm.interpreter.fsm.Buffer.class, msgs);
    	if (newOutputBuffer != null)
    		msgs = ((InternalEObject) newOutputBuffer).eInverseAdd(this, FsmPackage.BUFFER__INCOMING_FSM, fsm.interpreter.fsm.Buffer.class,
    				msgs);
    	msgs = basicSetOutputBuffer(newOutputBuffer, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__OUTPUT_BUFFER, newOutputBuffer, newOutputBuffer));
  }

  private NotificationChain basicSetOutputBuffer(Buffer newOutputBuffer, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Buffer oldOutputBuffer = outputBuffer;
    outputBuffer = newOutputBuffer;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__OUTPUT_BUFFER,
    			oldOutputBuffer, newOutputBuffer);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Buffer getOutputBuffer() {
    if (outputBuffer != null && outputBuffer.eIsProxy()) {
    	InternalEObject oldoutputBuffer = (InternalEObject) outputBuffer;
    	outputBuffer = (Buffer) eResolveProxy(oldoutputBuffer);
    	if (outputBuffer != oldoutputBuffer) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__OUTPUT_BUFFER,
    					oldoutputBuffer, outputBuffer));
    	}
    }
    return outputBuffer;
  }

  public void setInitialState(State newInitialState) {
    State oldInitialState = initialState;
    initialState = newInitialState;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INITIAL_STATE, oldInitialState, initialState));
  }

  public State getInitialState() {
    if (initialState != null && initialState.eIsProxy()) {
    	InternalEObject oldinitialState = (InternalEObject) initialState;
    	initialState = (State) eResolveProxy(oldinitialState);
    	if (initialState != oldinitialState) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__INITIAL_STATE,
    					oldinitialState, initialState));
    	}
    }
    return initialState;
  }

  public void setCurrentState(State newCurrentState) {
    State oldCurrentState = currentState;
    currentState = newCurrentState;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__CURRENT_STATE, oldCurrentState, currentState));
  }

  public State getCurrentState() {
    if (currentState != null && currentState.eIsProxy()) {
    	InternalEObject oldcurrentState = (InternalEObject) currentState;
    	currentState = (State) eResolveProxy(oldcurrentState);
    	if (currentState != oldcurrentState) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__CURRENT_STATE,
    					oldcurrentState, currentState));
    	}
    }
    return currentState;
  }

  protected EClass eStaticClass() {
    return FsmPackage.Literals.FSM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FsmPackage.FSM__NAME:
    	setName((java.lang.String) newValue);
    return;
    case FsmPackage.FSM__OWNED_STATES:
    	getOwnedStates().clear();
    	getOwnedStates().addAll((java.util.Collection<? extends fsm.interpreter.fsm.State>) newValue);
    return;
    case FsmPackage.FSM__OWNED_TRANSITIONS:
    	getOwnedTransitions().clear();
    	getOwnedTransitions().addAll((java.util.Collection<? extends fsm.interpreter.fsm.Transition>) newValue);
    return;
    case FsmPackage.FSM__INPUT_BUFFER:
    	setInputBuffer((fsm.interpreter.fsm.Buffer) newValue);
    return;
    case FsmPackage.FSM__OUTPUT_BUFFER:
    	setOutputBuffer((fsm.interpreter.fsm.Buffer) newValue);
    return;
    case FsmPackage.FSM__INITIAL_STATE:
    	setInitialState((fsm.interpreter.fsm.State) newValue);
    return;
    case FsmPackage.FSM__CURRENT_STATE:
    	setCurrentState((fsm.interpreter.fsm.State) newValue);
    return;
    case FsmPackage.FSM__UNDER_PROCESS_TRIGGER:
    	setUnderProcessTrigger((java.lang.String) newValue);
    return;
    case FsmPackage.FSM__CONSUMMED_STRING:
    	setConsummedString((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case FsmPackage.FSM__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case FsmPackage.FSM__OWNED_STATES:
    	getOwnedStates().clear();
    return;
    case FsmPackage.FSM__OWNED_TRANSITIONS:
    	getOwnedTransitions().clear();
    return;
    case FsmPackage.FSM__INPUT_BUFFER:
    	setInputBuffer((fsm.interpreter.fsm.Buffer) null);
    return;
    case FsmPackage.FSM__OUTPUT_BUFFER:
    	setOutputBuffer((fsm.interpreter.fsm.Buffer) null);
    return;
    case FsmPackage.FSM__INITIAL_STATE:
    	setInitialState((fsm.interpreter.fsm.State) null);
    return;
    case FsmPackage.FSM__CURRENT_STATE:
    	setCurrentState((fsm.interpreter.fsm.State) null);
    return;
    case FsmPackage.FSM__UNDER_PROCESS_TRIGGER:
    	setUnderProcessTrigger(UNDERPROCESSTRIGGER_EDEFAULT);
    return;
    case FsmPackage.FSM__CONSUMMED_STRING:
    	setConsummedString(CONSUMMEDSTRING_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FsmPackage.FSM__NAME:
    return getName();
    case FsmPackage.FSM__OWNED_STATES:
    return getOwnedStates();
    case FsmPackage.FSM__OWNED_TRANSITIONS:
    return getOwnedTransitions();
    case FsmPackage.FSM__INPUT_BUFFER:
    return getInputBuffer();
    case FsmPackage.FSM__OUTPUT_BUFFER:
    return getOutputBuffer();
    case FsmPackage.FSM__INITIAL_STATE:
    return getInitialState();
    case FsmPackage.FSM__CURRENT_STATE:
    return getCurrentState();
    case FsmPackage.FSM__UNDER_PROCESS_TRIGGER:
    return getUnderProcessTrigger();
    case FsmPackage.FSM__CONSUMMED_STRING:
    return getConsummedString();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FsmPackage.FSM__NAME:
    	return name != NAME_EDEFAULT;
    case FsmPackage.FSM__OWNED_STATES:
    	return ownedStates != null && !ownedStates.isEmpty();
    case FsmPackage.FSM__OWNED_TRANSITIONS:
    	return ownedTransitions != null && !ownedTransitions.isEmpty();
    case FsmPackage.FSM__INPUT_BUFFER:
    	return inputBuffer != null;
    case FsmPackage.FSM__OUTPUT_BUFFER:
    	return outputBuffer != null;
    case FsmPackage.FSM__INITIAL_STATE:
    	return initialState != null;
    case FsmPackage.FSM__CURRENT_STATE:
    	return currentState != null;
    case FsmPackage.FSM__UNDER_PROCESS_TRIGGER:
    	return underProcessTrigger != UNDERPROCESSTRIGGER_EDEFAULT;
    case FsmPackage.FSM__CONSUMMED_STRING:
    	return consummedString != CONSUMMEDSTRING_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case fsm.interpreter.fsm.FsmPackage.FSM__OWNED_STATES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getOwnedStates()).basicRemove(otherEnd, msgs);
    case fsm.interpreter.fsm.FsmPackage.FSM__OWNED_TRANSITIONS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getOwnedTransitions()).basicRemove(otherEnd, msgs);
    case fsm.interpreter.fsm.FsmPackage.FSM__INPUT_BUFFER:
    	return basicSetInputBuffer(null, msgs);
    case fsm.interpreter.fsm.FsmPackage.FSM__OUTPUT_BUFFER:
    	return basicSetOutputBuffer(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case FsmPackage.FSM__OWNED_STATES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getOwnedStates()).basicAdd(otherEnd, msgs);

    case FsmPackage.FSM__OWNED_TRANSITIONS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.InternalEObject>) (org.eclipse.emf.ecore.util.InternalEList<?>) getOwnedTransitions()).basicAdd(otherEnd, msgs);

    case FsmPackage.FSM__INPUT_BUFFER:
    	if (inputBuffer != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) inputBuffer).eInverseRemove(this, FsmPackage.BUFFER__OUTGOING_FSM, Buffer.class,
    				msgs);
    	return basicSetInputBuffer((fsm.interpreter.fsm.Buffer) otherEnd, msgs);

    case FsmPackage.FSM__OUTPUT_BUFFER:
    	if (outputBuffer != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) outputBuffer).eInverseRemove(this, FsmPackage.BUFFER__INCOMING_FSM, Buffer.class,
    				msgs);
    	return basicSetOutputBuffer((fsm.interpreter.fsm.Buffer) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public void initialize() {
    this.setCurrentState(this.initialState);
        this.setUnderProcessTrigger("");
        this.setConsummedString("");
        ;
  }

  public void run() {
    this.setUnderProcessTrigger(this.inputBuffer.dequeue());
        org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(((("run SM") + (this.name)) + (" step on ")) + (this.underProcessTrigger));
        this.currentState.step(this.underProcessTrigger);
        this.setUnderProcessTrigger("");
        ;
  }
}
