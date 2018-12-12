package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewArray;
import miniJava.interpreter.miniJava.TypeRef;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class NewArrayImpl extends ExpressionImpl implements NewArray {
  protected TypeRef type;

  protected Expression size;

  protected NewArrayImpl() {
    super();
  }

  public void setType(TypeRef newType) {
    if (newType != type) {
    	NotificationChain msgs = null;
    	if (type != null)
    		msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__TYPE, null, msgs);
    	if (newType != null)
    		msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__TYPE, null, msgs);
    	msgs = basicSetType(newType, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__TYPE, newType, newType));
  }

  public NotificationChain basicSetType(TypeRef newType, NotificationChain msgs) {
    TypeRef oldType = type;
    type = newType;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__TYPE, oldType, newType);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public TypeRef getType() {
    return type;}

  public void setSize(Expression newSize) {
    if (newSize != size) {
    	NotificationChain msgs = null;
    	if (size != null)
    		msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__SIZE, null, msgs);
    	if (newSize != null)
    		msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__SIZE, null, msgs);
    	msgs = basicSetSize(newSize, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__SIZE, newSize, newSize));
  }

  public NotificationChain basicSetSize(Expression newSize, NotificationChain msgs) {
    Expression oldSize = size;
    size = newSize;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__SIZE, oldSize, newSize);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getSize() {
    return size;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.NEW_ARRAY;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.NEW_ARRAY__TYPE:
    	setType((miniJava.interpreter.miniJava.TypeRef) newValue);
    return;
    case MiniJavaPackage.NEW_ARRAY__SIZE:
    	setSize((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_ARRAY__TYPE:
    	setType((miniJava.interpreter.miniJava.TypeRef) null);
    return;
    case MiniJavaPackage.NEW_ARRAY__SIZE:
    	setSize((miniJava.interpreter.miniJava.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.NEW_ARRAY__TYPE:
    return getType();
    case MiniJavaPackage.NEW_ARRAY__SIZE:
    return getSize();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.NEW_ARRAY__TYPE:
    	return type != null;
    case MiniJavaPackage.NEW_ARRAY__SIZE:
    	return size != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__TYPE:
    	return basicSetType(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.NEW_ARRAY__SIZE:
    	return basicSetSize(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
