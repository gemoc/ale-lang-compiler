package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ArrayRefValueImpl extends ValueImpl implements ArrayRefValue {
  protected ArrayInstance instance;

  protected ArrayRefValueImpl() {
    super();
  }

  public void setInstance(ArrayInstance newInstance) {
    ArrayInstance oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE, oldInstance, instance));
  }

  public ArrayInstance getInstance() {
    if (instance != null && instance.eIsProxy()) {
    	InternalEObject oldinstance = (InternalEObject) instance;
    	instance = (ArrayInstance) eResolveProxy(oldinstance);
    	if (instance != oldinstance) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE,
    					oldinstance, instance));
    	}
    }
    return instance;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.ARRAY_REF_VALUE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ArrayInstance) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ArrayInstance) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
    return getInstance();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
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

  public Value copy() {
    Value result;
    miniJava.interpreter.miniJava.ArrayRefValue tmp = ((miniJava.interpreter.miniJava.ArrayRefValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createArrayRefValue());
        tmp.setInstance(this.instance);
        result = tmp;
        ;
    return result;
  }
}
