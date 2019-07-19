package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import fsm.interpreter.fsm.FsmPackage;
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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "FSM"
)
public class FSMImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected static final String NAME_EDEFAULT = null;

	protected static final String UNDERPROCESSTRIGGER_EDEFAULT = null;

	protected static final String CONSUMMEDSTRING_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected String underProcessTrigger = UNDERPROCESSTRIGGER_EDEFAULT;

	protected String consummedString = CONSUMMEDSTRING_EDEFAULT;

	protected EList<StateImpl> ownedStates;

	protected EList<TransitionImpl> ownedTransitions;

	protected BufferImpl inputBuffer;

	protected BufferImpl outputBuffer;

	protected StateImpl initialState;

	protected StateImpl currentState;

	protected FSMImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return FsmPackage.Literals.FSM;
	}

	@TruffleBoundary
	public String getName() {
		return name;
	}

	@TruffleBoundary
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__NAME, oldName, name));
	}

	@TruffleBoundary
	public EList<StateImpl> getOwnedStates() {
		if (ownedStates == null) {
			ownedStates = new EObjectContainmentWithInverseEList<StateImpl>(StateImpl.class, this, FsmPackage.FSM__OWNED_STATES, FsmPackage.STATE__FSM);
		}
		return ownedStates;
	}

	@TruffleBoundary
	public EList<TransitionImpl> getOwnedTransitions() {
		if (ownedTransitions == null) {
			ownedTransitions = new EObjectContainmentWithInverseEList<TransitionImpl>(TransitionImpl.class, this, FsmPackage.FSM__OWNED_TRANSITIONS, FsmPackage.TRANSITION__FSM);
		}
		return ownedTransitions;
	}

	@TruffleBoundary
	public BufferImpl getInputBuffer() {
		if (inputBuffer != null && inputBuffer.eIsProxy()) {
			InternalEObject oldInputBuffer = (InternalEObject) inputBuffer;
			inputBuffer = (BufferImpl) eResolveProxy(oldInputBuffer);
			if (inputBuffer != oldInputBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__INPUT_BUFFER, oldInputBuffer, inputBuffer));
			}
		}
		return inputBuffer;
	}

	public BufferImpl basicGetInputBuffer() {
		return inputBuffer;
	}

	@TruffleBoundary
	public NotificationChain basicSetInputBuffer(BufferImpl newInputBuffer, NotificationChain msgs) {
		BufferImpl oldInputBuffer = inputBuffer;
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

	@TruffleBoundary
	public void setInputBuffer(BufferImpl newInputBuffer) {
		if (newInputBuffer != inputBuffer) {
			NotificationChain msgs = null;
			if (inputBuffer != null)
				msgs = ((InternalEObject) inputBuffer).eInverseRemove(this, FsmPackage.BUFFER__OUTGOING_FSM, BufferImpl.class, msgs);
			if (newInputBuffer != null)
				msgs = ((InternalEObject) newInputBuffer).eInverseAdd(this, FsmPackage.BUFFER__OUTGOING_FSM, BufferImpl.class, msgs);
			msgs = basicSetInputBuffer(newInputBuffer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INPUT_BUFFER, newInputBuffer, newInputBuffer));
	}

	@TruffleBoundary
	public BufferImpl getOutputBuffer() {
		if (outputBuffer != null && outputBuffer.eIsProxy()) {
			InternalEObject oldOutputBuffer = (InternalEObject) outputBuffer;
			outputBuffer = (BufferImpl) eResolveProxy(oldOutputBuffer);
			if (outputBuffer != oldOutputBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__OUTPUT_BUFFER, oldOutputBuffer, outputBuffer));
			}
		}
		return outputBuffer;
	}

	public BufferImpl basicGetOutputBuffer() {
		return outputBuffer;
	}

	@TruffleBoundary
	public NotificationChain basicSetOutputBuffer(BufferImpl newOutputBuffer, NotificationChain msgs) {
		BufferImpl oldOutputBuffer = outputBuffer;
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

	@TruffleBoundary
	public void setOutputBuffer(BufferImpl newOutputBuffer) {
		if (newOutputBuffer != outputBuffer) {
			NotificationChain msgs = null;
			if (outputBuffer != null)
				msgs = ((InternalEObject) outputBuffer).eInverseRemove(this, FsmPackage.BUFFER__INCOMING_FSM, BufferImpl.class, msgs);
			if (newOutputBuffer != null)
				msgs = ((InternalEObject) newOutputBuffer).eInverseAdd(this, FsmPackage.BUFFER__INCOMING_FSM, BufferImpl.class, msgs);
			msgs = basicSetOutputBuffer(newOutputBuffer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__OUTPUT_BUFFER, newOutputBuffer, newOutputBuffer));
	}

	@TruffleBoundary
	public StateImpl getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject) initialState;
			initialState = (StateImpl) eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	public StateImpl basicGetInitialState() {
		return initialState;
	}

	@TruffleBoundary
	public void setInitialState(StateImpl newInitialState) {
		StateImpl oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__INITIAL_STATE, oldInitialState, initialState));
	}

	@TruffleBoundary
	public StateImpl getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject) currentState;
			currentState = (StateImpl) eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.FSM__CURRENT_STATE, oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	public StateImpl basicGetCurrentState() {
		return currentState;
	}

	@TruffleBoundary
	public void setCurrentState(StateImpl newCurrentState) {
		StateImpl oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__CURRENT_STATE, oldCurrentState, currentState));
	}

	@TruffleBoundary
	public String getUnderProcessTrigger() {
		return underProcessTrigger;
	}

	@TruffleBoundary
	public void setUnderProcessTrigger(String newUnderProcessTrigger) {
		String oldUnderProcessTrigger = underProcessTrigger;
		underProcessTrigger = newUnderProcessTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__UNDER_PROCESS_TRIGGER, oldUnderProcessTrigger, underProcessTrigger));
	}

	@TruffleBoundary
	public String getConsummedString() {
		return consummedString;
	}

	@TruffleBoundary
	public void setConsummedString(String newConsummedString) {
		String oldConsummedString = consummedString;
		consummedString = newConsummedString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.FSM__CONSUMMED_STRING, oldConsummedString, consummedString));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.FSM__OWNED_STATES :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedStates()).basicAdd(otherEnd, msgs);
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedTransitions()).basicAdd(otherEnd, msgs);
			case FsmPackage.FSM__INPUT_BUFFER :
				if (inputBuffer != null)
					msgs = ((InternalEObject) inputBuffer).eInverseRemove(this, FsmPackage.BUFFER__OUTGOING_FSM, BufferImpl.class, msgs);
				return basicSetInputBuffer((BufferImpl) otherEnd, msgs);
			case FsmPackage.FSM__OUTPUT_BUFFER :
				if (outputBuffer != null)
					msgs = ((InternalEObject) outputBuffer).eInverseRemove(this, FsmPackage.BUFFER__INCOMING_FSM, BufferImpl.class, msgs);
				return basicSetOutputBuffer((BufferImpl) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
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
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.FSM__NAME :
				setName((String) newValue);
				return;
			case FsmPackage.FSM__OWNED_STATES :
				getOwnedStates().clear();
				getOwnedStates().addAll((Collection<? extends StateImpl>) newValue);
				return;
			case FsmPackage.FSM__OWNED_TRANSITIONS :
				getOwnedTransitions().clear();
				getOwnedTransitions().addAll((Collection<? extends TransitionImpl>) newValue);
				return;
			case FsmPackage.FSM__INPUT_BUFFER :
				setInputBuffer((BufferImpl) newValue);
				return;
			case FsmPackage.FSM__OUTPUT_BUFFER :
				setOutputBuffer((BufferImpl) newValue);
				return;
			case FsmPackage.FSM__INITIAL_STATE :
				setInitialState((StateImpl) newValue);
				return;
			case FsmPackage.FSM__CURRENT_STATE :
				setCurrentState((StateImpl) newValue);
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
	@TruffleBoundary
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
				setInputBuffer((BufferImpl) null);
				return;
			case FsmPackage.FSM__OUTPUT_BUFFER :
				setOutputBuffer((BufferImpl) null);
				return;
			case FsmPackage.FSM__INITIAL_STATE :
				setInitialState((StateImpl) null);
				return;
			case FsmPackage.FSM__CURRENT_STATE :
				setCurrentState((StateImpl) null);
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
	@TruffleBoundary
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

	public void initialize() {
		this.setCurrentState(this.getInitialState());
		this.setUnderProcessTrigger("");
		this.setConsummedString("");
	}

	public void run() {
		this.setUnderProcessTrigger(((BufferImpl) (this.getInputBuffer())).dequeue());
		LogService.log(((("run SM") + (this.name)) + (" step on ")) + (this.underProcessTrigger));
		((StateImpl) (this.getCurrentState())).step((String) (this.underProcessTrigger));
		this.setUnderProcessTrigger("");
	}
}
