/**
 */
package fsm.model.fsm.impl;

import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.FsmPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsm.model.fsm.impl.BufferImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link fsm.model.fsm.impl.BufferImpl#getOutgoingFSM <em>Outgoing FSM</em>}</li>
 *   <li>{@link fsm.model.fsm.impl.BufferImpl#getIncomingFSM <em>Incoming FSM</em>}</li>
 *   <li>{@link fsm.model.fsm.impl.BufferImpl#getName <em>Name</em>}</li>
 *   <li>{@link fsm.model.fsm.impl.BufferImpl#getCurrentValues <em>Current Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferImpl extends MinimalEObjectImpl.Container implements Buffer {
	/**
	 * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected String initialValue = INITIAL_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoingFSM() <em>Outgoing FSM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingFSM()
	 * @generated
	 * @ordered
	 */
	protected FSM outgoingFSM;

	/**
	 * The cached value of the '{@link #getIncomingFSM() <em>Incoming FSM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingFSM()
	 * @generated
	 * @ordered
	 */
	protected FSM incomingFSM;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentValues() <em>Current Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValues()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_VALUES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentValues() <em>Current Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValues()
	 * @generated
	 * @ordered
	 */
	protected String currentValues = CURRENT_VALUES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.BUFFER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(String newInitialValue) {
		String oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INITIAL_VALUE, oldInitialValue,
					initialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM getOutgoingFSM() {
		if (outgoingFSM != null && outgoingFSM.eIsProxy()) {
			InternalEObject oldOutgoingFSM = (InternalEObject) outgoingFSM;
			outgoingFSM = (FSM) eResolveProxy(oldOutgoingFSM);
			if (outgoingFSM != oldOutgoingFSM) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.BUFFER__OUTGOING_FSM,
							oldOutgoingFSM, outgoingFSM));
			}
		}
		return outgoingFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM basicGetOutgoingFSM() {
		return outgoingFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingFSM(FSM newOutgoingFSM, NotificationChain msgs) {
		FSM oldOutgoingFSM = outgoingFSM;
		outgoingFSM = newOutgoingFSM;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					FsmPackage.BUFFER__OUTGOING_FSM, oldOutgoingFSM, newOutgoingFSM);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutgoingFSM(FSM newOutgoingFSM) {
		if (newOutgoingFSM != outgoingFSM) {
			NotificationChain msgs = null;
			if (outgoingFSM != null)
				msgs = ((InternalEObject) outgoingFSM).eInverseRemove(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class,
						msgs);
			if (newOutgoingFSM != null)
				msgs = ((InternalEObject) newOutgoingFSM).eInverseAdd(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class,
						msgs);
			msgs = basicSetOutgoingFSM(newOutgoingFSM, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__OUTGOING_FSM, newOutgoingFSM,
					newOutgoingFSM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM getIncomingFSM() {
		if (incomingFSM != null && incomingFSM.eIsProxy()) {
			InternalEObject oldIncomingFSM = (InternalEObject) incomingFSM;
			incomingFSM = (FSM) eResolveProxy(oldIncomingFSM);
			if (incomingFSM != oldIncomingFSM) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.BUFFER__INCOMING_FSM,
							oldIncomingFSM, incomingFSM));
			}
		}
		return incomingFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM basicGetIncomingFSM() {
		return incomingFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingFSM(FSM newIncomingFSM, NotificationChain msgs) {
		FSM oldIncomingFSM = incomingFSM;
		incomingFSM = newIncomingFSM;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					FsmPackage.BUFFER__INCOMING_FSM, oldIncomingFSM, newIncomingFSM);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingFSM(FSM newIncomingFSM) {
		if (newIncomingFSM != incomingFSM) {
			NotificationChain msgs = null;
			if (incomingFSM != null)
				msgs = ((InternalEObject) incomingFSM).eInverseRemove(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class,
						msgs);
			if (newIncomingFSM != null)
				msgs = ((InternalEObject) newIncomingFSM).eInverseAdd(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class,
						msgs);
			msgs = basicSetIncomingFSM(newIncomingFSM, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INCOMING_FSM, newIncomingFSM,
					newIncomingFSM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentValues() {
		return currentValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValues(String newCurrentValues) {
		String oldCurrentValues = currentValues;
		currentValues = newCurrentValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__CURRENT_VALUES, oldCurrentValues,
					currentValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FsmPackage.BUFFER__OUTGOING_FSM:
			if (outgoingFSM != null)
				msgs = ((InternalEObject) outgoingFSM).eInverseRemove(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class,
						msgs);
			return basicSetOutgoingFSM((FSM) otherEnd, msgs);
		case FsmPackage.BUFFER__INCOMING_FSM:
			if (incomingFSM != null)
				msgs = ((InternalEObject) incomingFSM).eInverseRemove(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class,
						msgs);
			return basicSetIncomingFSM((FSM) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FsmPackage.BUFFER__OUTGOING_FSM:
			return basicSetOutgoingFSM(null, msgs);
		case FsmPackage.BUFFER__INCOMING_FSM:
			return basicSetIncomingFSM(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FsmPackage.BUFFER__INITIAL_VALUE:
			return getInitialValue();
		case FsmPackage.BUFFER__OUTGOING_FSM:
			if (resolve)
				return getOutgoingFSM();
			return basicGetOutgoingFSM();
		case FsmPackage.BUFFER__INCOMING_FSM:
			if (resolve)
				return getIncomingFSM();
			return basicGetIncomingFSM();
		case FsmPackage.BUFFER__NAME:
			return getName();
		case FsmPackage.BUFFER__CURRENT_VALUES:
			return getCurrentValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FsmPackage.BUFFER__INITIAL_VALUE:
			setInitialValue((String) newValue);
			return;
		case FsmPackage.BUFFER__OUTGOING_FSM:
			setOutgoingFSM((FSM) newValue);
			return;
		case FsmPackage.BUFFER__INCOMING_FSM:
			setIncomingFSM((FSM) newValue);
			return;
		case FsmPackage.BUFFER__NAME:
			setName((String) newValue);
			return;
		case FsmPackage.BUFFER__CURRENT_VALUES:
			setCurrentValues((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case FsmPackage.BUFFER__INITIAL_VALUE:
			setInitialValue(INITIAL_VALUE_EDEFAULT);
			return;
		case FsmPackage.BUFFER__OUTGOING_FSM:
			setOutgoingFSM((FSM) null);
			return;
		case FsmPackage.BUFFER__INCOMING_FSM:
			setIncomingFSM((FSM) null);
			return;
		case FsmPackage.BUFFER__NAME:
			setName(NAME_EDEFAULT);
			return;
		case FsmPackage.BUFFER__CURRENT_VALUES:
			setCurrentValues(CURRENT_VALUES_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FsmPackage.BUFFER__INITIAL_VALUE:
			return INITIAL_VALUE_EDEFAULT == null ? initialValue != null : !INITIAL_VALUE_EDEFAULT.equals(initialValue);
		case FsmPackage.BUFFER__OUTGOING_FSM:
			return outgoingFSM != null;
		case FsmPackage.BUFFER__INCOMING_FSM:
			return incomingFSM != null;
		case FsmPackage.BUFFER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case FsmPackage.BUFFER__CURRENT_VALUES:
			return CURRENT_VALUES_EDEFAULT == null ? currentValues != null
					: !CURRENT_VALUES_EDEFAULT.equals(currentValues);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (initialValue: ");
		result.append(initialValue);
		result.append(", name: ");
		result.append(name);
		result.append(", currentValues: ");
		result.append(currentValues);
		result.append(')');
		return result.toString();
	}

} //BufferImpl
