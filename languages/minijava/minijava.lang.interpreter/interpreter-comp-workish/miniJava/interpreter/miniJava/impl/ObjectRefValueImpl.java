package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ObjectRefValueImpl extends ValueImpl implements ObjectRefValue {
  protected ObjectInstance instance;

  protected ObjectRefValueImpl() {
    super();
  }

  public void setInstance(ObjectInstance newInstance) {
    ObjectInstance oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE, oldInstance, instance));
  }

  public ObjectInstance getInstance() {
    return instance;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.OBJECT_REF_VALUE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ObjectInstance) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ObjectInstance) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    return getInstance();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    	return instance != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public String customToString() {
    String result;
    result = this.instance.toString();
        ;
    return result;
  }

  public Value copy() {
    Value result;
    miniJava.interpreter.miniJava.ObjectRefValue tmp = ((miniJava.interpreter.miniJava.ObjectRefValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createObjectRefValue());
        tmp.setInstance(this.instance);
        result = tmp;
        ;
    return result;
  }
}
