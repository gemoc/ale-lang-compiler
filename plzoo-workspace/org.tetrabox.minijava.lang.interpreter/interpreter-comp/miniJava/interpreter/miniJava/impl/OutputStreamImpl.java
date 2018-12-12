package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.OutputStream;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class OutputStreamImpl extends MinimalEObjectImpl.Container implements OutputStream {
  protected static final String STREAM_EDEFAULT = null;

  protected String stream = STREAM_EDEFAULT;

  protected OutputStreamImpl() {
    super();
  }

  public String getStream() {
    return stream;}

  public void setStream(String stream) {
    this.stream = stream;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.OUTPUT_STREAM;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.OUTPUT_STREAM__STREAM:
    	setStream((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OUTPUT_STREAM__STREAM:
    	setStream(STREAM_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.OUTPUT_STREAM__STREAM:
    return getStream();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OUTPUT_STREAM__STREAM:
    	return stream != STREAM_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
