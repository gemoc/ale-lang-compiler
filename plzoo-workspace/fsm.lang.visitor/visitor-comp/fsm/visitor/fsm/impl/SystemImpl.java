package fsm.visitor.fsm.impl;

import fsm.visitor.fsm.Buffer;
import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.FsmPackage;
import fsm.visitor.fsm.System;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class SystemImpl extends MinimalEObjectImpl.Container implements System {
	protected EList<FSM> ownedFsms;

	protected EList<Buffer> ownedBuffers;

	protected SystemImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.SYSTEM;
	}

	public EList<FSM> getOwnedFsms() {
		if (ownedFsms == null) {
			ownedFsms = new EObjectContainmentEList<FSM>(FSM.class, this, FsmPackage.SYSTEM__OWNED_FSMS);
		}
		return ownedFsms;
	}

	public EList<Buffer> getOwnedBuffers() {
		if (ownedBuffers == null) {
			ownedBuffers = new EObjectContainmentEList<Buffer>(Buffer.class, this, FsmPackage.SYSTEM__OWNED_BUFFERS);
		}
		return ownedBuffers;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				return ((InternalEList<?>) getOwnedFsms()).basicRemove(otherEnd, msgs);
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				return ((InternalEList<?>) getOwnedBuffers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				return getOwnedFsms();
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				return getOwnedBuffers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				getOwnedFsms().clear();
				getOwnedFsms().addAll((Collection<? extends FSM>) newValue);
				return;
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				getOwnedBuffers().clear();
				getOwnedBuffers().addAll((Collection<? extends Buffer>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				getOwnedFsms().clear();
				return;
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				getOwnedBuffers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				return ownedFsms != null && !ownedFsms.isEmpty();
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				return ownedBuffers != null && !ownedBuffers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfsm__System(this);
	}
}
