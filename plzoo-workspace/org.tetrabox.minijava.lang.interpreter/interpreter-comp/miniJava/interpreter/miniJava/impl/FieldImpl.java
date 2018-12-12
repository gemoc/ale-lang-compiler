package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class FieldImpl extends MemberImpl implements Field {
  protected Expression defaultValue;

  protected FieldImpl() {
    super();
  }

  public void setDefaultValue(Expression newDefaultValue) {
    if (newDefaultValue != defaultValue) {
    	NotificationChain msgs = null;
    	if (defaultValue != null)
    		msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FIELD__DEFAULT_VALUE, null, msgs);
    	if (newDefaultValue != null)
    		msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FIELD__DEFAULT_VALUE, null, msgs);
    	msgs = basicSetDefaultValue(newDefaultValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FIELD__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
  }

  public NotificationChain basicSetDefaultValue(Expression newDefaultValue,
      NotificationChain msgs) {
    Expression oldDefaultValue = defaultValue;
    defaultValue = newDefaultValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FIELD__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getDefaultValue() {
    return defaultValue;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.FIELD;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.FIELD__DEFAULT_VALUE:
    	setDefaultValue((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FIELD__DEFAULT_VALUE:
    	setDefaultValue((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.FIELD__DEFAULT_VALUE:
    return getDefaultValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FIELD__DEFAULT_VALUE:
    	return defaultValue != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.FIELD__DEFAULT_VALUE:
    	return basicSetDefaultValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
