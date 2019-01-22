package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

public class ObjectInstanceImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements ObjectInstance {
  protected EList<FieldBinding> fieldbindings;

  protected Clazz type;

  protected ObjectInstanceImpl() {
    super();
  }

  
  public EList<FieldBinding> getFieldbindings() {
    if(fieldbindings == null) {
    	fieldbindings = new EObjectContainmentEList<FieldBinding>(miniJava.interpreter.miniJava.FieldBinding.class, this, MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS);
    }
    return fieldbindings;
  }

  
  public void setType(Clazz newType) {
    Clazz oldType = type;
    type = newType;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_INSTANCE__TYPE, oldType, type));
  }

  
  public Clazz getType() {
    if (type != null && type.eIsProxy()) {
    	InternalEObject oldtype = (InternalEObject) type;
    	type = (Clazz) eResolveProxy(oldtype);
    	if (type != oldtype) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.OBJECT_INSTANCE__TYPE,
    					oldtype, type));
    	}
    }
    return type;
  }

  
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.OBJECT_INSTANCE;}

  
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
    	getFieldbindings().clear();
    	getFieldbindings().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.FieldBinding>) newValue);
    return;
    case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
    	setType((miniJava.interpreter.miniJava.Clazz) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
    	getFieldbindings().clear();
    return;
    case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
    	setType((miniJava.interpreter.miniJava.Clazz) null);
    return;
    }
    super.eUnset(featureID);
  }

  
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
    return getFieldbindings();
    case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
    return getType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
    	return fieldbindings != null && !fieldbindings.isEmpty();
    case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
    	return type != null;
    }
    return super.eIsSet(featureID);
  }

  
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getFieldbindings()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
