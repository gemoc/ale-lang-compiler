package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class FieldBindingImpl extends MinimalEObjectImpl.Container implements FieldBinding {
  protected Field field;

  protected Value value;

  protected FieldBindingImpl() {
    super();
  }

  public void setField(Field newField) {
    Field oldField = field;
    field = newField;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_BINDING__FIELD, oldField, field));
  }

  public Field getField() {
    return field;}

  public void setValue(Value newValue) {
    if (newValue != value) {
    	NotificationChain msgs = null;
    	if (value != null)
    		msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_BINDING__VALUE, null, msgs);
    	if (newValue != null)
    		msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_BINDING__VALUE, null, msgs);
    	msgs = basicSetValue(newValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_BINDING__VALUE, newValue, newValue));
  }

  public NotificationChain basicSetValue(Value newValue, NotificationChain msgs) {
    Value oldValue = value;
    value = newValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_BINDING__VALUE, oldValue, newValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Value getValue() {
    return value;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.FIELD_BINDING;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_BINDING__FIELD:
    	setField((miniJava.interpreter.miniJava.Field) newValue);
    return;
    case MiniJavaPackage.FIELD_BINDING__VALUE:
    	setValue((miniJava.interpreter.miniJava.Value) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_BINDING__FIELD:
    	setField((miniJava.interpreter.miniJava.Field) null);
    return;
    case MiniJavaPackage.FIELD_BINDING__VALUE:
    	setValue((miniJava.interpreter.miniJava.Value) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_BINDING__FIELD:
    return getField();
    case MiniJavaPackage.FIELD_BINDING__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FIELD_BINDING__FIELD:
    	return field != null;
    case MiniJavaPackage.FIELD_BINDING__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.FIELD_BINDING__VALUE:
    	return basicSetValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
