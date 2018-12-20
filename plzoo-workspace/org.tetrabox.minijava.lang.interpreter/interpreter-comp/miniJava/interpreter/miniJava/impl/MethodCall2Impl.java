package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.MethodCall;
import miniJava.interpreter.miniJava.MethodCall2;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "MethodCall2"
)
public class MethodCall2Impl extends CallImpl implements MethodCall2 {
  protected MethodCall methodcall;

  protected MethodCall2Impl() {
    super();
  }

  @TruffleBoundary
  public void setMethodcall(MethodCall newMethodcall) {
    MethodCall oldMethodcall = methodcall;
    methodcall = newMethodcall;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL2__METHODCALL, oldMethodcall, methodcall));
  }

  @TruffleBoundary
  public MethodCall getMethodcall() {
    if (methodcall != null && methodcall.eIsProxy()) {
    	InternalEObject oldmethodcall = (InternalEObject) methodcall;
    	methodcall = (MethodCall) eResolveProxy(oldmethodcall);
    	if (methodcall != oldmethodcall) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.METHOD_CALL2__METHODCALL,
    					oldmethodcall, methodcall));
    	}
    }
    return methodcall;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.METHOD_CALL2;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    	setMethodcall((miniJava.interpreter.miniJava.MethodCall) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    	setMethodcall((miniJava.interpreter.miniJava.MethodCall) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    return getMethodcall();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL2__METHODCALL:
    	return methodcall != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
