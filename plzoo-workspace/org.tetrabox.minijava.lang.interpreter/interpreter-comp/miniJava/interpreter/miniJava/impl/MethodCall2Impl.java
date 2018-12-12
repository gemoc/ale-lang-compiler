package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.MethodCall;
import miniJava.interpreter.miniJava.MethodCall2;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class MethodCall2Impl extends CallImpl implements MethodCall2 {
  protected MethodCall methodcall;

  protected MethodCall2Impl() {
    super();
  }

  public void setMethodcall(MethodCall newMethodcall) {
    MethodCall oldMethodcall = methodcall;
    methodcall = newMethodcall;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL2__METHODCALL, oldMethodcall, methodcall));
  }

  public MethodCall getMethodcall() {
    return methodcall;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.METHOD_CALL2;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    	setMethodcall((miniJava.interpreter.miniJava.MethodCall) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    	setMethodcall((miniJava.interpreter.miniJava.MethodCall) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    return getMethodcall();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    	return methodcall != null;
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
