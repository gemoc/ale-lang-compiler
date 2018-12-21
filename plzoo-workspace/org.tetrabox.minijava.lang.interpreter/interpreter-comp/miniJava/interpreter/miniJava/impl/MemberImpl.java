package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class MemberImpl extends TypedDeclarationImpl implements Member {
  protected static final AccessLevel ACCESS_EDEFAULT = miniJava.interpreter.miniJava.AccessLevel.valueOf("PRIVATE");

  protected AccessLevel access = ACCESS_EDEFAULT;

  protected MemberImpl() {
    super();
  }

  public AccessLevel getAccess() {
    return access;}

  public void setAccess(AccessLevel access) {
    this.access = access;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.MEMBER;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    	setAccess((miniJava.interpreter.miniJava.AccessLevel) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    	setAccess(ACCESS_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    return getAccess();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    	return access != ACCESS_EDEFAULT;
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
