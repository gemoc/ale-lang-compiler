package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "Member"
)
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

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.MEMBER;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    	setAccess((miniJava.interpreter.miniJava.AccessLevel) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    	setAccess(ACCESS_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    return getAccess();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.MEMBER__ACCESS:
    	return access != ACCESS_EDEFAULT;
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
