package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.Transition;
import java.lang.IllegalArgumentException;
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "State"
)
public class StateImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements State {
	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected EList<Transition> incoming;

	protected EList<Transition> outgoing;

	protected StateImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return FsmPackage.Literals.STATE;
	}

	@TruffleBoundary
	public EList<Transition> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FsmPackage.STATE__INCOMING, FsmPackage.TRANSITION__TGT);
		}
		return incoming;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.STATE__NAME, oldName, name));
	}

	@TruffleBoundary
	public EList<Transition> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FsmPackage.STATE__OUTGOING, FsmPackage.TRANSITION__SRC);
		}
		return outgoing;
	}

	@TruffleBoundary
	public FSM getFsm() {
		if (eContainerFeatureID() != FsmPackage.STATE__FSM)
			return null;
		return (FSM) eInternalContainer();
	}

	public NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newFsm, FsmPackage.STATE__FSM, msgs);
		return msgs;
	}

	@TruffleBoundary
	public void setFsm(FSM newFsm) {
		if (newFsm != eInternalContainer() || (eContainerFeatureID() != FsmPackage.STATE__FSM && newFsm != null)) {
			if (EcoreUtil.isAncestor(this, newFsm))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFsm != null)
				msgs = ((InternalEObject) newFsm).eInverseAdd(this, FsmPackage.FSM__OWNED_STATES, FSM.class, msgs);
			msgs = basicSetFsm(newFsm, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.STATE__FSM, newFsm, newFsm));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.STATE__INCOMING :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncoming()).basicAdd(otherEnd, msgs);
			case FsmPackage.STATE__OUTGOING :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutgoing()).basicAdd(otherEnd, msgs);
			case FsmPackage.STATE__FSM :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFsm((FSM) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.STATE__INCOMING :
				return ((InternalEList<?>) getIncoming()).basicRemove(otherEnd, msgs);
			case FsmPackage.STATE__OUTGOING :
				return ((InternalEList<?>) getOutgoing()).basicRemove(otherEnd, msgs);
			case FsmPackage.STATE__FSM :
				return basicSetFsm(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FsmPackage.STATE__FSM :
				return eInternalContainer().eInverseRemove(this, FsmPackage.FSM__OWNED_STATES, FSM.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmPackage.STATE__INCOMING :
				return getIncoming();
			case FsmPackage.STATE__NAME :
				return getName();
			case FsmPackage.STATE__OUTGOING :
				return getOutgoing();
			case FsmPackage.STATE__FSM :
				return getFsm();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.STATE__INCOMING :
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Transition>) newValue);
				return;
			case FsmPackage.STATE__NAME :
				setName((String) newValue);
				return;
			case FsmPackage.STATE__OUTGOING :
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Transition>) newValue);
				return;
			case FsmPackage.STATE__FSM :
				setFsm((FSM) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmPackage.STATE__INCOMING :
				getIncoming().clear();
				return;
			case FsmPackage.STATE__NAME :
				setName(NAME_EDEFAULT);
				return;
			case FsmPackage.STATE__OUTGOING :
				getOutgoing().clear();
				return;
			case FsmPackage.STATE__FSM :
				setFsm((FSM) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmPackage.STATE__INCOMING :
				return incoming != null && !incoming.isEmpty();
			case FsmPackage.STATE__NAME :
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FsmPackage.STATE__OUTGOING :
				return outgoing != null && !outgoing.isEmpty();
			case FsmPackage.STATE__FSM :
				return getFsm() != null;
		}
		return super.eIsSet(featureID);
	}

	public void step(String inputString) {
		Transition validTransition = ((Transition) (CollectionService.head(CollectionService.select(this.getOutgoing(), (t) -> EqualService.equals((inputString), (t.getTrigger()))))));
		if (EqualService.equals((validTransition), (null))) {
			((Buffer) (this.getFsm().getOutputBuffer())).enqueue((String) (inputString));
		}
		else {
			((Transition) (validTransition)).fire();
		}
	}
}
