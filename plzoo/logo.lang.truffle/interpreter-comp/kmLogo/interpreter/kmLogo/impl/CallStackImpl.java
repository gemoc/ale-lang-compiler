package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import kmLogo.interpreter.kmLogo.CallStack;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.StackFrame;

@NodeInfo(
    description = "CallStack"
)
public class CallStackImpl extends MinimalEObjectImpl.Container implements CallStack {
  protected EList<StackFrame> frames;

  protected CallStackImpl() {
    super();
  }

  @TruffleBoundary
  public EList<StackFrame> getFrames() {
    if(frames == null) {
    	frames = new EObjectContainmentEList<StackFrame>(kmLogo.interpreter.kmLogo.StackFrame.class, this, KmLogoPackage.CALL_STACK__FRAMES);
    }
    return frames;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.CALL_STACK;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.CALL_STACK__FRAMES:
    	getFrames().clear();
    	getFrames().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.StackFrame>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CALL_STACK__FRAMES:
    	getFrames().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.CALL_STACK__FRAMES:
    return getFrames();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.CALL_STACK__FRAMES:
    	return frames != null && !frames.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.CALL_STACK__FRAMES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getFrames()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
