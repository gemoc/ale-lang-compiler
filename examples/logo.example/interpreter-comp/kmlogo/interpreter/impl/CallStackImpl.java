package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.CallStack;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.StackFrame;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class CallStackImpl extends MinimalEObjectImpl.Container implements CallStack {
  private EList<StackFrame> frames;

  public EList<StackFrame> getFrames() {
    if(frames == null) {
    	frames = new EObjectContainmentEList<StackFrame>(kmlogo.interpreter.StackFrame.class, this, KmLogoPackage.CALL_STACK__FRAMES);
    }
    return frames;
  }

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.CALLSTACK;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.CALL_STACK__FRAMES:
    	getFrames().clear();
    	getFrames().addAll((java.util.Collection<? extends kmlogo.interpreter.impl.StackFrameImpl>) newValue);
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
    	return frames != null;
    }
    return super.eIsSet(featureID);
  }
}
