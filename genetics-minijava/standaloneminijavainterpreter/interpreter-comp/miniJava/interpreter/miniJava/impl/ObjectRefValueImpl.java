package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
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

  @TruffleBoundary
  public void setInstance(ObjectInstance newInstance) {
    ObjectInstance oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE, oldInstance, instance));
  }

  @TruffleBoundary
  public ObjectInstance getInstance() {
    if (instance != null && instance.eIsProxy()) {
    	InternalEObject oldinstance = (InternalEObject) instance;
    	instance = (ObjectInstance) eResolveProxy(oldinstance);
    	if (instance != oldinstance) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE,
    					oldinstance, instance));
    	}
    }
    return instance;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.OBJECT_REF_VALUE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ObjectInstance) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ObjectInstance) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    return getInstance();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
    	return instance != null;
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

  @TruffleBoundary
  public String customToString() {
    String result;
    result = this.instance.toString();
        ;
    return result;
  }

  @TruffleBoundary
  public Value copyj() {
    Value result;
    miniJava.interpreter.miniJava.ObjectRefValue tmp = ((miniJava.interpreter.miniJava.ObjectRefValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createObjectRefValue());
        tmp.setInstance(this.instance);
        result = tmp;
        ;
    return result;
  }
}
