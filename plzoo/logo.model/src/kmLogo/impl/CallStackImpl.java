/**
 */
package kmLogo.impl;

import java.util.Collection;

import kmLogo.CallStack;
import kmLogo.KmLogoPackage;
import kmLogo.StackFrame;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

public class CallStackImpl extends MinimalEObjectImpl.Container implements CallStack {
	protected EList<StackFrame> frames;

	protected CallStackImpl() {
		super();
	}

	public EList<StackFrame> getFrames() {
		if (frames == null) {
			frames = new EObjectContainmentEList<StackFrame>(StackFrame.class, this, KmLogoPackage.CALL_STACK__FRAMES);
		}
		return frames;
	}

	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CALL_STACK;
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KmLogoPackage.CALL_STACK__FRAMES:
			getFrames().clear();
			getFrames().addAll((Collection<? extends StackFrame>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case KmLogoPackage.CALL_STACK__FRAMES:
			getFrames().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KmLogoPackage.CALL_STACK__FRAMES:
			return getFrames();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KmLogoPackage.CALL_STACK__FRAMES:
			return frames != null && !frames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KmLogoPackage.CALL_STACK__FRAMES:
			return ((InternalEList<?>) getFrames()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

} // CallStackImpl
