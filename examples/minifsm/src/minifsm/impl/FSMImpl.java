/**
 */
package minifsm.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import minifsm.FSM;
import minifsm.MinifsmPackage;
import minifsm.State;
import minifsm.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>FSM</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link minifsm.impl.FSMImpl#getStates <em>States</em>}</li>
 * <li>{@link minifsm.impl.FSMImpl#getTransitions <em>Transitions</em>}</li>
 * <li>{@link minifsm.impl.FSMImpl#getCurrentState <em>Current State</em>}</li>
 * <li>{@link minifsm.impl.FSMImpl#getCurrentEvent <em>Current Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMImpl extends MinimalEObjectImpl.Container implements FSM {
	/**
	 * The default value of the '{@link #getCurrentEvent() <em>Current Event</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrentEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentEvent() <em>Current Event</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrentEvent()
	 * @generated
	 * @ordered
	 */
	protected String currentEvent = CURRENT_EVENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected State currentState;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FSMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCurrentEvent() {
		return currentEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrentEvent(String newCurrentEvent) {
		String oldCurrentEvent = currentEvent;
		currentEvent = newCurrentEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.FSM__CURRENT_EVENT, oldCurrentEvent,
					currentEvent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, MinifsmPackage.FSM__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this,
					MinifsmPackage.FSM__TRANSITIONS, MinifsmPackage.TRANSITION__FSM);
		}
		return transitions;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrentState(State newCurrentState) {
		State oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinifsmPackage.FSM__CURRENT_STATE, oldCurrentState,
					currentState));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public State getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject) currentState;
			currentState = (State) eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MinifsmPackage.FSM__CURRENT_STATE,
							oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MinifsmPackage.Literals.FSM;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MinifsmPackage.FSM__STATES:
			getStates().clear();
			getStates().addAll((Collection<? extends State>) newValue);
			return;
		case MinifsmPackage.FSM__TRANSITIONS:
			getTransitions().clear();
			getTransitions().addAll((Collection<? extends Transition>) newValue);
			return;
		case MinifsmPackage.FSM__CURRENT_STATE:
			setCurrentState((State) newValue);
			return;
		case MinifsmPackage.FSM__CURRENT_EVENT:
			setCurrentEvent((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MinifsmPackage.FSM__STATES:
			getStates().clear();
			return;
		case MinifsmPackage.FSM__TRANSITIONS:
			getTransitions().clear();
			return;
		case MinifsmPackage.FSM__CURRENT_STATE:
			setCurrentState((State) null);
			return;
		case MinifsmPackage.FSM__CURRENT_EVENT:
			setCurrentEvent(CURRENT_EVENT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MinifsmPackage.FSM__STATES:
			return getStates();
		case MinifsmPackage.FSM__TRANSITIONS:
			return getTransitions();
		case MinifsmPackage.FSM__CURRENT_STATE:
			if (resolve)
				return getCurrentState();
			return basicGetCurrentState();
		case MinifsmPackage.FSM__CURRENT_EVENT:
			return getCurrentEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MinifsmPackage.FSM__STATES:
			return states != null && !states.isEmpty();
		case MinifsmPackage.FSM__TRANSITIONS:
			return transitions != null && !transitions.isEmpty();
		case MinifsmPackage.FSM__CURRENT_STATE:
			return currentState != null;
		case MinifsmPackage.FSM__CURRENT_EVENT:
			return CURRENT_EVENT_EDEFAULT == null ? currentEvent != null : !CURRENT_EVENT_EDEFAULT.equals(currentEvent);
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MinifsmPackage.FSM__TRANSITIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getTransitions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public State basicGetCurrentState() {
		return currentState;
	}

	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void handle(String event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MinifsmPackage.FSM__STATES:
			return ((InternalEList<?>) getStates()).basicRemove(otherEnd, msgs);
		case MinifsmPackage.FSM__TRANSITIONS:
			return ((InternalEList<?>) getTransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	

	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case MinifsmPackage.FSM___HANDLE__STRING:
			handle((String) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (currentEvent: ");
		result.append(currentEvent);
		result.append(')');
		return result.toString();
	}

} // FSMImpl
