package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.Interface;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.TypeDeclaration;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class TypeDeclarationImpl extends NamedElementImpl implements TypeDeclaration {
  protected static final AccessLevel ACCESSLEVEL_EDEFAULT = miniJava.interpreter.miniJava.AccessLevel.valueOf("PRIVATE");

  protected AccessLevel accessLevel = ACCESSLEVEL_EDEFAULT;

  protected EList<Interface> implementz;

  protected EList<Member> members;

  protected TypeDeclarationImpl() {
    super();
  }

  public AccessLevel getAccessLevel() {
    return accessLevel;}

  public void setAccessLevel(AccessLevel accessLevel) {
    this.accessLevel = accessLevel;}

  public EList<Interface> getImplementz() {
    if(implementz == null) {
    	implementz = new EObjectContainmentEList<Interface>(miniJava.interpreter.miniJava.Interface.class, this, MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ);
    }
    return implementz;
  }

  public EList<Member> getMembers() {
    if(members == null) {
    	members = new EObjectContainmentEList<Member>(miniJava.interpreter.miniJava.Member.class, this, MiniJavaPackage.TYPE_DECLARATION__MEMBERS);
    }
    return members;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.TYPE_DECLARATION;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL:
    	setAccessLevel((miniJava.interpreter.miniJava.AccessLevel) newValue);
    return;
    case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ:
    	getImplementz().clear();
    	getImplementz().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Interface>) newValue);
    return;
    case MiniJavaPackage.TYPE_DECLARATION__MEMBERS:
    	getMembers().clear();
    	getMembers().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Member>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL:
    	setAccessLevel(ACCESSLEVEL_EDEFAULT);
    return;
    case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ:
    	getImplementz().clear();
    return;
    case MiniJavaPackage.TYPE_DECLARATION__MEMBERS:
    	getMembers().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL:
    return getAccessLevel();
    case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ:
    return getImplementz();
    case MiniJavaPackage.TYPE_DECLARATION__MEMBERS:
    return getMembers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL:
    	return accessLevel != ACCESSLEVEL_EDEFAULT;
    case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ:
    	return implementz != null && !implementz.isEmpty();
    case MiniJavaPackage.TYPE_DECLARATION__MEMBERS:
    	return members != null && !members.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.TYPE_DECLARATION__MEMBERS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getMembers()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
