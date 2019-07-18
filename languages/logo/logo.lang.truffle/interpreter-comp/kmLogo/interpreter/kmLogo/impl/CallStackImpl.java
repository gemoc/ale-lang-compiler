package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

public class CallStackImpl extends MinimalEObjectImpl.Container {
	protected EList<StackFrameImpl> frames;

	protected CallStackImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CALL_STACK;
	}

	@TruffleBoundary
	public EList<StackFrameImpl> getFrames() {
		if (frames == null) {
			frames = new EObjectContainmentEList<StackFrameImpl>(StackFrameImpl.class, this, KmLogoPackage.CALL_STACK__FRAMES);
		}
		return frames;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.CALL_STACK__FRAMES :
				return ((InternalEList<?>) getFrames()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.CALL_STACK__FRAMES :
				return getFrames();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.CALL_STACK__FRAMES :
				getFrames().clear();
				getFrames().addAll((Collection<? extends StackFrameImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.CALL_STACK__FRAMES :
				getFrames().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.CALL_STACK__FRAMES :
				return frames != null && !frames.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
