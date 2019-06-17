package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import fsm.interpreter.fsm.FsmPackage;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "System"
)
public class SystemImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected EList<FSMImpl> ownedFsms;

	protected EList<BufferImpl> ownedBuffers;

	@Children
	private BufferImpl[] ownedBuffersArr;

	@Children
	private FSMImpl[] ownedFsmsArr;

	protected SystemImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return FsmPackage.Literals.SYSTEM;
	}

	@TruffleBoundary
	public EList<FSMImpl> getOwnedFsms() {
		if (ownedFsms == null) {
			ownedFsms = new EObjectContainmentEList<FSMImpl>(FSMImpl.class, this, FsmPackage.SYSTEM__OWNED_FSMS);
		}
		return ownedFsms;
	}

	@TruffleBoundary
	public EList<BufferImpl> getOwnedBuffers() {
		if (ownedBuffers == null) {
			ownedBuffers = new EObjectContainmentEList<BufferImpl>(BufferImpl.class, this, FsmPackage.SYSTEM__OWNED_BUFFERS);
		}
		return ownedBuffers;
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
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
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				getOwnedFsms().clear();
				getOwnedFsms().addAll((Collection<? extends FSMImpl>) newValue);
				return;
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				getOwnedBuffers().clear();
				getOwnedBuffers().addAll((Collection<? extends BufferImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
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
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmPackage.SYSTEM__OWNED_FSMS :
				return ownedFsms != null && !ownedFsms.isEmpty();
			case FsmPackage.SYSTEM__OWNED_BUFFERS :
				return ownedBuffers != null && !ownedBuffers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void intialize() {
		if (this.ownedBuffersArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.ownedBuffers != null) this.ownedBuffersArr = this.ownedBuffers.toArray(new BufferImpl[0]);
			else this.ownedBuffersArr = new BufferImpl[] {};
		}
		if (this.ownedFsmsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.ownedFsms != null) this.ownedFsmsArr = this.ownedFsms.toArray(new FSMImpl[0]);
			else this.ownedFsmsArr = new FSMImpl[] {};
		}
		for (FSMImpl fsm : this.ownedFsmsArr) {
			((FSMImpl) (fsm)).initialize();
		}
		for (BufferImpl b : this.ownedBuffersArr) {
			((BufferImpl) (b)).initialize();
		}

	}

	public void main(int limit) {
		if (this.ownedBuffersArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.ownedBuffers != null) this.ownedBuffersArr = this.ownedBuffers.toArray(new BufferImpl[0]);
			else this.ownedBuffersArr = new BufferImpl[] {};
		}
		if (this.ownedFsmsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.ownedFsms != null) this.ownedFsmsArr = this.ownedFsms.toArray(new FSMImpl[0]);
			else this.ownedFsmsArr = new FSMImpl[] {};
		}
		((SystemImpl) (this)).intialize();
		boolean anFSMRan = ((boolean) (true));
		int cptr = ((int) (0));
		while (((anFSMRan) && ((cptr) < (limit)))) {
			anFSMRan = false;
			for (FSMImpl fsm : this.ownedFsmsArr) {
				if (!(((BufferImpl) (fsm.getInputBuffer())).bisEmpty())) {
					((FSMImpl) (fsm)).run();
					anFSMRan = true;
				}
				cptr = (cptr) + (1);
			}
		}

	}
}
