package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Expr;
import boa.interpreter.boa.Field;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
    description = "Field"
)
public class FieldImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Field {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  @Child
  protected Expr value;

  protected FieldImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  @TruffleBoundary
  public void setValue(Expr newValue) {
    if (newValue != value) {
    	NotificationChain msgs = null;
    	if (value != null)
    		msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.FIELD__VALUE, null, msgs);
    	if (newValue != null)
    		msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.FIELD__VALUE, null, msgs);
    	msgs = basicSetValue(newValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.FIELD__VALUE, newValue, newValue));
  }

  @TruffleBoundary
  public NotificationChain basicSetValue(Expr newValue, NotificationChain msgs) {
    Expr oldValue = value;
    value = newValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.FIELD__VALUE, oldValue, newValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getValue() {
    return value;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.FIELD;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.FIELD__NAME:
    	setName((java.lang.String) newValue);
    return;
    case BoaPackage.FIELD__VALUE:
    	setValue((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.FIELD__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case BoaPackage.FIELD__VALUE:
    	setValue((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.FIELD__NAME:
    return getName();
    case BoaPackage.FIELD__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.FIELD__NAME:
    	return name != NAME_EDEFAULT;
    case BoaPackage.FIELD__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.FIELD__VALUE:
    	return basicSetValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
