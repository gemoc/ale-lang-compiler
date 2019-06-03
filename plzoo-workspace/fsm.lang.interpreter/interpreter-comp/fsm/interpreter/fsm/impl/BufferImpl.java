package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class BufferImpl extends MinimalEObjectImpl.Container implements Buffer {
	protected static final String INITIALVALUE_EDEFAULT = null;

	protected static final String NAME_EDEFAULT = null;

	protected static final String CURRENTVALUES_EDEFAULT = null;

	protected String initialValue = INITIALVALUE_EDEFAULT;

	protected String name = NAME_EDEFAULT;

	protected String currentValues = CURRENTVALUES_EDEFAULT;

	protected FSM outgoingFSM;

	protected FSM incomingFSM;

	protected BufferImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.BUFFER;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String newInitialValue) {
		String oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INITIAL_VALUE, oldInitialValue, initialValue));
	}

	public FSM getOutgoingFSM() {
		if (outgoingFSM != null && outgoingFSM.eIsProxy()) {
			InternalEObject oldOutgoingFSM = (InternalEObject) outgoingFSM;
			outgoingFSM = (FSM) eResolveProxy(oldOutgoingFSM);
			if (outgoingFSM != oldOutgoingFSM) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.BUFFER__OUTGOING_FSM, oldOutgoingFSM, outgoingFSM));
			}
		}
		return outgoingFSM;
	}

	public FSM basicGetOutgoingFSM() {
		return outgoingFSM;
	}

	public NotificationChain basicSetOutgoingFSM(FSM newOutgoingFSM, NotificationChain msgs) {
		FSM oldOutgoingFSM = outgoingFSM;
		outgoingFSM = newOutgoingFSM;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__OUTGOING_FSM, oldOutgoingFSM, newOutgoingFSM);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setOutgoingFSM(FSM newOutgoingFSM) {
		if (newOutgoingFSM != outgoingFSM) {
			NotificationChain msgs = null;
			if (outgoingFSM != null)
				msgs = ((InternalEObject) outgoingFSM).eInverseRemove(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class, msgs);
			if (newOutgoingFSM != null)
				msgs = ((InternalEObject) newOutgoingFSM).eInverseAdd(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class, msgs);
			msgs = basicSetOutgoingFSM(newOutgoingFSM, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__OUTGOING_FSM, newOutgoingFSM, newOutgoingFSM));
	}

	public FSM getIncomingFSM() {
		if (incomingFSM != null && incomingFSM.eIsProxy()) {
			InternalEObject oldIncomingFSM = (InternalEObject) incomingFSM;
			incomingFSM = (FSM) eResolveProxy(oldIncomingFSM);
			if (incomingFSM != oldIncomingFSM) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.BUFFER__INCOMING_FSM, oldIncomingFSM, incomingFSM));
			}
		}
		return incomingFSM;
	}

	public FSM basicGetIncomingFSM() {
		return incomingFSM;
	}

	public NotificationChain basicSetIncomingFSM(FSM newIncomingFSM, NotificationChain msgs) {
		FSM oldIncomingFSM = incomingFSM;
		incomingFSM = newIncomingFSM;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INCOMING_FSM, oldIncomingFSM, newIncomingFSM);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setIncomingFSM(FSM newIncomingFSM) {
		if (newIncomingFSM != incomingFSM) {
			NotificationChain msgs = null;
			if (incomingFSM != null)
				msgs = ((InternalEObject) incomingFSM).eInverseRemove(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class, msgs);
			if (newIncomingFSM != null)
				msgs = ((InternalEObject) newIncomingFSM).eInverseAdd(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class, msgs);
			msgs = basicSetIncomingFSM(newIncomingFSM, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INCOMING_FSM, newIncomingFSM, newIncomingFSM));
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__NAME, oldName, name));
	}

	public String getCurrentValues() {
		return currentValues;
	}

	public void setCurrentValues(String newCurrentValues) {
		String oldCurrentValues = currentValues;
		currentValues = newCurrentValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__CURRENT_VALUES, oldCurrentValues, currentValues));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.BUFFER__OUTGOING_FSM :
				if (outgoingFSM != null)
					msgs = ((InternalEObject) outgoingFSM).eInverseRemove(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class, msgs);
				return basicSetOutgoingFSM((FSM) otherEnd, msgs);
			case FsmPackage.BUFFER__INCOMING_FSM :
				if (incomingFSM != null)
					msgs = ((InternalEObject) incomingFSM).eInverseRemove(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class, msgs);
				return basicSetIncomingFSM((FSM) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.BUFFER__OUTGOING_FSM :
				return basicSetOutgoingFSM(null, msgs);
			case FsmPackage.BUFFER__INCOMING_FSM :
				return basicSetIncomingFSM(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmPackage.BUFFER__INITIAL_VALUE :
				return getInitialValue();
			case FsmPackage.BUFFER__OUTGOING_FSM :
				if (resolve)
					return getOutgoingFSM();
				return basicGetOutgoingFSM();
			case FsmPackage.BUFFER__INCOMING_FSM :
				if (resolve)
					return getIncomingFSM();
				return basicGetIncomingFSM();
			case FsmPackage.BUFFER__NAME :
				return getName();
			case FsmPackage.BUFFER__CURRENT_VALUES :
				return getCurrentValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.BUFFER__INITIAL_VALUE :
				setInitialValue((String) newValue);
				return;
			case FsmPackage.BUFFER__OUTGOING_FSM :
				setOutgoingFSM((FSM) newValue);
				return;
			case FsmPackage.BUFFER__INCOMING_FSM :
				setIncomingFSM((FSM) newValue);
				return;
			case FsmPackage.BUFFER__NAME :
				setName((String) newValue);
				return;
			case FsmPackage.BUFFER__CURRENT_VALUES :
				setCurrentValues((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmPackage.BUFFER__INITIAL_VALUE :
				setInitialValue(INITIALVALUE_EDEFAULT);
				return;
			case FsmPackage.BUFFER__OUTGOING_FSM :
				setOutgoingFSM((FSM) null);
				return;
			case FsmPackage.BUFFER__INCOMING_FSM :
				setIncomingFSM((FSM) null);
				return;
			case FsmPackage.BUFFER__NAME :
				setName(NAME_EDEFAULT);
				return;
			case FsmPackage.BUFFER__CURRENT_VALUES :
				setCurrentValues(CURRENTVALUES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmPackage.BUFFER__INITIAL_VALUE :
				return INITIALVALUE_EDEFAULT == null ? initialValue != null : !INITIALVALUE_EDEFAULT.equals(initialValue);
			case FsmPackage.BUFFER__OUTGOING_FSM :
				return outgoingFSM != null;
			case FsmPackage.BUFFER__INCOMING_FSM :
				return incomingFSM != null;
			case FsmPackage.BUFFER__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FsmPackage.BUFFER__CURRENT_VALUES :
				return CURRENTVALUES_EDEFAULT == null ? currentValues != null : !CURRENTVALUES_EDEFAULT.equals(currentValues);
		}
		return super.eIsSet(featureID);
	}

	public void initialize() {
		if (!EqualService.equals((this.initialValue), (null))) {
			this.setCurrentValues(this.initialValue);
		}
		else {
			this.setCurrentValues("'empty'");
		}
	}

	public boolean bisEmpty() {
		boolean result;
		result = (boolean) (((EqualService.equals((CollectionService.size(this.currentValues)), (0))) || (EqualService.equals((this.currentValues), ("'empty'"))))) ;
		return result;
	}

	public void enqueue(String v) {
		if (((Buffer) (this)).bisEmpty()) {
			this.setCurrentValues(v);
		}
		else {
			this.setCurrentValues(((this.currentValues) + (",")) + (v));
		}
	}

	public String dequeue() {
		String result;
		String res = ((String) (""));
		int firstComma = ((int) (this.currentValues.indexOf((String) (","))));
		if ((firstComma) < (0)) {
			res = this.currentValues;
			this.setCurrentValues("'empty'");
			result = (String) (res) ;
		}
		else {
			res = this.currentValues.substring((Integer) (0), (int) (firstComma));
			this.setCurrentValues(this.currentValues.substring(((firstComma) + (1)), (Integer) (CollectionService.size(this.currentValues))));
			result = (String) (res) ;
		}
		return result;
	}
}
