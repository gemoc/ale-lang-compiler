package fsm.visitor.fsm.impl;

import fsm.visitor.fsm.Buffer;
import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.FsmPackage;
import fsm.visitor.fsm.State;
import fsm.visitor.fsm.Transition;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

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

	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.FSM;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__NAME, oldName, name));
	}

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

	public Buffer getInputBuffer() {
		if (inputBuffer != null && inputBuffer.eIsProxy()) {
			InternalEObject oldInputBuffer = (InternalEObject) inputBuffer;
			inputBuffer = (Buffer) eResolveProxy(oldInputBuffer);
			if (inputBuffer != oldInputBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__INPUT_BUFFER, oldInputBuffer, inputBuffer));
			}
		}
		return inputBuffer;
	}

	public Buffer basicGetInputBuffer() {
		return inputBuffer;
	}

	public NotificationChain basicSetInputBuffer(Buffer newInputBuffer, NotificationChain msgs) {
		Buffer oldInputBuffer = inputBuffer;
		inputBuffer = newInputBuffer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INPUT_BUFFER, oldInputBuffer, newInputBuffer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setInputBuffer(Buffer newInputBuffer) {
		if (newInputBuffer != inputBuffer) {
			NotificationChain msgs = null;
			if (inputBuffer != null)
				msgs = ((InternalEObject) inputBuffer).eInverseRemove(this, FsmPackage.BUFFER__OUTGOING_FSM, Buffer.class, msgs);
			if (newInputBuffer != null)
				msgs = ((InternalEObject) newInputBuffer).eInverseAdd(this, FsmPackage.BUFFER__OUTGOING_FSM, Buffer.class, msgs);
			msgs = basicSetInputBuffer(newInputBuffer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INPUT_BUFFER, newInputBuffer, newInputBuffer));
	}

	public Buffer getOutputBuffer() {
		if (outputBuffer != null && outputBuffer.eIsProxy()) {
			InternalEObject oldOutputBuffer = (InternalEObject) outputBuffer;
			outputBuffer = (Buffer) eResolveProxy(oldOutputBuffer);
			if (outputBuffer != oldOutputBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__OUTPUT_BUFFER, oldOutputBuffer, outputBuffer));
			}
		}
		return outputBuffer;
	}

	public Buffer basicGetOutputBuffer() {
		return outputBuffer;
	}

	public NotificationChain basicSetOutputBuffer(Buffer newOutputBuffer, NotificationChain msgs) {
		Buffer oldOutputBuffer = outputBuffer;
		outputBuffer = newOutputBuffer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__OUTPUT_BUFFER, oldOutputBuffer, newOutputBuffer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setOutputBuffer(Buffer newOutputBuffer) {
		if (newOutputBuffer != outputBuffer) {
			NotificationChain msgs = null;
			if (outputBuffer != null)
				msgs = ((InternalEObject) outputBuffer).eInverseRemove(this, FsmPackage.BUFFER__INCOMING_FSM, Buffer.class, msgs);
			if (newOutputBuffer != null)
				msgs = ((InternalEObject) newOutputBuffer).eInverseAdd(this, FsmPackage.BUFFER__INCOMING_FSM, Buffer.class, msgs);
			msgs = basicSetOutputBuffer(newOutputBuffer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__OUTPUT_BUFFER, newOutputBuffer, newOutputBuffer));
	}

	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject) initialState;
			initialState = (State) eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	public State basicGetInitialState() {
		return initialState;
	}

	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INITIAL_STATE, oldInitialState, initialState));
	}

	public State getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject) currentState;
			currentState = (State) eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__CURRENT_STATE, oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	public State basicGetCurrentState() {
		return currentState;
	}

	public void setCurrentState(State newCurrentState) {
		State oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__CURRENT_STATE, oldCurrentState, currentState));
	}

	public String getUnderProcessTrigger() {
		return underProcessTrigger;
	}

	public void setUnderProcessTrigger(String newUnderProcessTrigger) {
		String oldUnderProcessTrigger = underProcessTrigger;
		underProcessTrigger = newUnderProcessTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__UNDER_PROCESS_TRIGGER, oldUnderProcessTrigger, underProcessTrigger));
	}

	public String getConsummedString() {
		return consummedString;
	}

	public void setConsummedString(String newConsummedString) {
		String oldConsummedString = consummedString;
		consummedString = newConsummedString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__CONSUMMED_STRING, oldConsummedString, consummedString));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.FSM__OWNED_STATES :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedStates()).basicAdd(otherEnd, msgs);
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedTransitions()).basicAdd(otherEnd, msgs);
			case FsmPackage.FSM__INPUT_BUFFER :
				if (inputBuffer != null)
					msgs = ((InternalEObject) inputBuffer).eInverseRemove(this, FsmPackage.BUFFER__OUTGOING_FSM, Buffer.class, msgs);
				return basicSetInputBuffer((Buffer) otherEnd, msgs);
			case FsmPackage.FSM__OUTPUT_BUFFER :
				if (outputBuffer != null)
					msgs = ((InternalEObject) outputBuffer).eInverseRemove(this, FsmPackage.BUFFER__INCOMING_FSM, Buffer.class, msgs);
				return basicSetOutputBuffer((Buffer) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.FSM__OWNED_STATES :
				return ((InternalEList<?>) getOwnedStates()).basicRemove(otherEnd, msgs);
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				return ((InternalEList<?>) getOwnedTransitions()).basicRemove(otherEnd, msgs);
			case FsmPackage.FSM__INPUT_BUFFER :
				return basicSetInputBuffer(null, msgs);
			case FsmPackage.FSM__OUTPUT_BUFFER :
				return basicSetOutputBuffer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmPackage.FSM__NAME :
				return getName();
			case FsmPackage.FSM__OWNED_STATES :
				return getOwnedStates();
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				return getOwnedTransitions();
			case FsmPackage.FSM__INPUT_BUFFER :
				if (resolve)
					return getInputBuffer();
				return basicGetInputBuffer();
			case FsmPackage.FSM__OUTPUT_BUFFER :
				if (resolve)
					return getOutputBuffer();
				return basicGetOutputBuffer();
			case FsmPackage.FSM__INITIAL_STATE :
				if (resolve)
					return getInitialState();
				return basicGetInitialState();
			case FsmPackage.FSM__CURRENT_STATE :
				if (resolve)
					return getCurrentState();
				return basicGetCurrentState();
			case FsmPackage.FSM__UNDER_PROCESS_TRIGGER :
				return getUnderProcessTrigger();
			case FsmPackage.FSM__CONSUMMED_STRING :
				return getConsummedString();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.FSM__NAME :
				setName((String) newValue);
				return;
			case FsmPackage.FSM__OWNED_STATES :
				getOwnedStates().clear();
				getOwnedStates().addAll((Collection<? extends State>) newValue);
				return;
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				getOwnedTransitions().clear();
				getOwnedTransitions().addAll((Collection<? extends Transition>) newValue);
				return;
			case FsmPackage.FSM__INPUT_BUFFER :
				setInputBuffer((Buffer) newValue);
				return;
			case FsmPackage.FSM__OUTPUT_BUFFER :
				setOutputBuffer((Buffer) newValue);
				return;
			case FsmPackage.FSM__INITIAL_STATE :
				setInitialState((State) newValue);
				return;
			case FsmPackage.FSM__CURRENT_STATE :
				setCurrentState((State) newValue);
				return;
			case FsmPackage.FSM__UNDER_PROCESS_TRIGGER :
				setUnderProcessTrigger((String) newValue);
				return;
			case FsmPackage.FSM__CONSUMMED_STRING :
				setConsummedString((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmPackage.FSM__NAME :
				setName(NAME_EDEFAULT);
				return;
			case FsmPackage.FSM__OWNED_STATES :
				getOwnedStates().clear();
				return;
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				getOwnedTransitions().clear();
				return;
			case FsmPackage.FSM__INPUT_BUFFER :
				setInputBuffer((Buffer) null);
				return;
			case FsmPackage.FSM__OUTPUT_BUFFER :
				setOutputBuffer((Buffer) null);
				return;
			case FsmPackage.FSM__INITIAL_STATE :
				setInitialState((State) null);
				return;
			case FsmPackage.FSM__CURRENT_STATE :
				setCurrentState((State) null);
				return;
			case FsmPackage.FSM__UNDER_PROCESS_TRIGGER :
				setUnderProcessTrigger(UNDERPROCESSTRIGGER_EDEFAULT);
				return;
			case FsmPackage.FSM__CONSUMMED_STRING :
				setConsummedString(CONSUMMEDSTRING_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmPackage.FSM__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FsmPackage.FSM__OWNED_STATES :
				return ownedStates != null && !ownedStates.isEmpty();
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				return ownedTransitions != null && !ownedTransitions.isEmpty();
			case FsmPackage.FSM__INPUT_BUFFER :
				return inputBuffer != null;
			case FsmPackage.FSM__OUTPUT_BUFFER :
				return outputBuffer != null;
			case FsmPackage.FSM__INITIAL_STATE :
				return initialState != null;
			case FsmPackage.FSM__CURRENT_STATE :
				return currentState != null;
			case FsmPackage.FSM__UNDER_PROCESS_TRIGGER :
				return UNDERPROCESSTRIGGER_EDEFAULT == null ? underProcessTrigger != null : !UNDERPROCESSTRIGGER_EDEFAULT.equals(underProcessTrigger);
			case FsmPackage.FSM__CONSUMMED_STRING :
				return CONSUMMEDSTRING_EDEFAULT == null ? consummedString != null : !CONSUMMEDSTRING_EDEFAULT.equals(consummedString);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfsm__FSM(this);
	}
}
