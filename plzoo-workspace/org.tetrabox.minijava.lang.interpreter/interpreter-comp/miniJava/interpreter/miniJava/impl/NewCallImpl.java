package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewCall;
import miniJava.interpreter.miniJava.NewObject;

public class NewCallImpl extends CallImpl implements NewCall {
  protected NewObject newz;

  protected NewCallImpl() {
    super();
  }

  @TruffleBoundary
  public void setNewz(NewObject newNewz) {
    NewObject oldNewz = newz;
    newz = newNewz;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_CALL__NEWZ, oldNewz, newz));
  }

  @TruffleBoundary
  public NewObject getNewz() {
    if (newz != null && newz.eIsProxy()) {
    	InternalEObject oldnewz = (InternalEObject) newz;
    	newz = (NewObject) eResolveProxy(oldnewz);
    	if (newz != oldnewz) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.NEW_CALL__NEWZ,
    					oldnewz, newz));
    	}
    }
    return newz;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NEW_CALL;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.NEW_CALL__NEWZ:
    	setNewz((miniJava.interpreter.miniJava.NewObject) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_CALL__NEWZ:
    	setNewz((miniJava.interpreter.miniJava.NewObject) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.NEW_CALL__NEWZ:
    return getNewz();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_CALL__NEWZ:
    	return newz != null;
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
