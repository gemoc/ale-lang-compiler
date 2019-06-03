package fsm.visitor.fsm.impl;

import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.FsmPackage;
import fsm.visitor.fsm.State;
import fsm.visitor.fsm.Transition;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import visitor.VisitorInterface;

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

	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.TRANSITION;
	}

	public State getTgt() {
		if (tgt != null && tgt.eIsProxy()) {
			InternalEObject oldTgt = (InternalEObject) tgt;
			tgt = (State) eResolveProxy(oldTgt);
			if (tgt != oldTgt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.TRANSITION__TGT, oldTgt, tgt));
			}
		}
		return tgt;
	}

	public State basicGetTgt() {
		return tgt;
	}

	public NotificationChain basicSetTgt(State newTgt, NotificationChain msgs) {
		State oldTgt = tgt;
		tgt = newTgt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__TGT, oldTgt, newTgt);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTgt(State newTgt) {
		if (newTgt != tgt) {
			NotificationChain msgs = null;
			if (tgt != null)
				msgs = ((InternalEObject) tgt).eInverseRemove(this, FsmPackage.STATE__INCOMING, State.class, msgs);
			if (newTgt != null)
				msgs = ((InternalEObject) newTgt).eInverseAdd(this, FsmPackage.STATE__INCOMING, State.class, msgs);
			msgs = basicSetTgt(newTgt, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__TGT, newTgt, newTgt));
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__NAME, oldName, name));
	}

	public State getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject) src;
			src = (State) eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.TRANSITION__SRC, oldSrc, src));
			}
		}
		return src;
	}

	public State basicGetSrc() {
		return src;
	}

	public NotificationChain basicSetSrc(State newSrc, NotificationChain msgs) {
		State oldSrc = src;
		src = newSrc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__SRC, oldSrc, newSrc);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setSrc(State newSrc) {
		if (newSrc != src) {
			NotificationChain msgs = null;
			if (src != null)
				msgs = ((InternalEObject) src).eInverseRemove(this, FsmPackage.STATE__OUTGOING, State.class, msgs);
			if (newSrc != null)
				msgs = ((InternalEObject) newSrc).eInverseAdd(this, FsmPackage.STATE__OUTGOING, State.class, msgs);
			msgs = basicSetSrc(newSrc, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__SRC, newSrc, newSrc));
	}

	public FSM getFsm() {
		if (eContainerFeatureID() != FsmPackage.TRANSITION__FSM)
			return null;
		return (FSM) eInternalContainer();
	}

	public NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newFsm, FsmPackage.TRANSITION__FSM, msgs);
		return msgs;
	}

	public void setFsm(FSM newFsm) {
		if (newFsm != eInternalContainer() || (eContainerFeatureID() != FsmPackage.TRANSITION__FSM && newFsm != null)) {
			if (EcoreUtil.isAncestor(this, newFsm))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFsm != null)
				msgs = ((InternalEObject) newFsm).eInverseAdd(this, FsmPackage.FSM__OWNED_TRANSITIONS, FSM.class, msgs);
			msgs = basicSetFsm(newFsm, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__FSM, newFsm, newFsm));
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String newTrigger) {
		String oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__TRIGGER, oldTrigger, trigger));
	}

	public String getAction() {
		return action;
	}

	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRANSITION__ACTION, oldAction, action));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.TRANSITION__TGT :
				if (tgt != null)
					msgs = ((InternalEObject) tgt).eInverseRemove(this, FsmPackage.STATE__INCOMING, State.class, msgs);
				return basicSetTgt((State) otherEnd, msgs);
			case FsmPackage.TRANSITION__SRC :
				if (src != null)
					msgs = ((InternalEObject) src).eInverseRemove(this, FsmPackage.STATE__OUTGOING, State.class, msgs);
				return basicSetSrc((State) otherEnd, msgs);
			case FsmPackage.TRANSITION__FSM :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFsm((FSM) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.TRANSITION__TGT :
				return basicSetTgt(null, msgs);
			case FsmPackage.TRANSITION__SRC :
				return basicSetSrc(null, msgs);
			case FsmPackage.TRANSITION__FSM :
				return basicSetFsm(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FsmPackage.TRANSITION__FSM :
				return eInternalContainer().eInverseRemove(this, FsmPackage.FSM__OWNED_TRANSITIONS, FSM.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmPackage.TRANSITION__TGT :
				if (resolve)
					return getTgt();
				return basicGetTgt();
			case FsmPackage.TRANSITION__NAME :
				return getName();
			case FsmPackage.TRANSITION__SRC :
				if (resolve)
					return getSrc();
				return basicGetSrc();
			case FsmPackage.TRANSITION__FSM :
				return getFsm();
			case FsmPackage.TRANSITION__TRIGGER :
				return getTrigger();
			case FsmPackage.TRANSITION__ACTION :
				return getAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.TRANSITION__TGT :
				setTgt((State) newValue);
				return;
			case FsmPackage.TRANSITION__NAME :
				setName((String) newValue);
				return;
			case FsmPackage.TRANSITION__SRC :
				setSrc((State) newValue);
				return;
			case FsmPackage.TRANSITION__FSM :
				setFsm((FSM) newValue);
				return;
			case FsmPackage.TRANSITION__TRIGGER :
				setTrigger((String) newValue);
				return;
			case FsmPackage.TRANSITION__ACTION :
				setAction((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmPackage.TRANSITION__TGT :
				setTgt((State) null);
				return;
			case FsmPackage.TRANSITION__NAME :
				setName(NAME_EDEFAULT);
				return;
			case FsmPackage.TRANSITION__SRC :
				setSrc((State) null);
				return;
			case FsmPackage.TRANSITION__FSM :
				setFsm((FSM) null);
				return;
			case FsmPackage.TRANSITION__TRIGGER :
				setTrigger(TRIGGER_EDEFAULT);
				return;
			case FsmPackage.TRANSITION__ACTION :
				setAction(ACTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmPackage.TRANSITION__TGT :
				return tgt != null;
			case FsmPackage.TRANSITION__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FsmPackage.TRANSITION__SRC :
				return src != null;
			case FsmPackage.TRANSITION__FSM :
				return getFsm() != null;
			case FsmPackage.TRANSITION__TRIGGER :
				return TRIGGER_EDEFAULT == null ? trigger != null : !TRIGGER_EDEFAULT.equals(trigger);
			case FsmPackage.TRANSITION__ACTION :
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfsm__Transition(this);
	}
}
