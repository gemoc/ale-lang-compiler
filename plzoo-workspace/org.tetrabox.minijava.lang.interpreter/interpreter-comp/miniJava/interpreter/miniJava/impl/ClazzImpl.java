package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ClazzImpl extends TypeDeclarationImpl implements Clazz {
  protected static final boolean ISABSTRACT_EDEFAULT = false;

  protected boolean isabstract = ISABSTRACT_EDEFAULT;

  protected Clazz superClass;

  protected ClazzImpl() {
    super();
  }

  public boolean isIsabstract() {
    return isabstract;}

  public void setIsabstract(boolean isabstract) {
    this.isabstract = isabstract;}

  public void setSuperClass(Clazz newSuperClass) {
    Clazz oldSuperClass = superClass;
    superClass = newSuperClass;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ__SUPER_CLASS, oldSuperClass, superClass));
  }

  public Clazz getSuperClass() {
    if (superClass != null && superClass.eIsProxy()) {
    	InternalEObject oldsuperClass = (InternalEObject) superClass;
    	superClass = (Clazz) eResolveProxy(oldsuperClass);
    	if (superClass != oldsuperClass) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ__SUPER_CLASS,
    					oldsuperClass, superClass));
    	}
    }
    return superClass;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.CLAZZ;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ__ISABSTRACT:
    	setIsabstract((boolean) newValue);
    return;
    case MiniJavaPackage.CLAZZ__SUPER_CLASS:
    	setSuperClass((miniJava.interpreter.miniJava.Clazz) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ__ISABSTRACT:
    	setIsabstract(ISABSTRACT_EDEFAULT);
    return;
    case MiniJavaPackage.CLAZZ__SUPER_CLASS:
    	setSuperClass((miniJava.interpreter.miniJava.Clazz) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ__ISABSTRACT:
    return isIsabstract();
    case MiniJavaPackage.CLAZZ__SUPER_CLASS:
    return getSuperClass();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CLAZZ__ISABSTRACT:
    	return isabstract != ISABSTRACT_EDEFAULT;
    case MiniJavaPackage.CLAZZ__SUPER_CLASS:
    	return superClass != null;
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
