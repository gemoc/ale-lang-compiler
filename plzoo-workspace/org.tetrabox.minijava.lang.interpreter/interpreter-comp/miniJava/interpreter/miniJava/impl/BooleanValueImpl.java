package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.String;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class BooleanValueImpl extends ValueImpl implements BooleanValue {
  protected static final boolean VALUE_EDEFAULT = false;

  protected boolean value = VALUE_EDEFAULT;

  protected BooleanValueImpl() {
    super();
  }

  public boolean isValue() {
    return value;}

  public void setValue(boolean value) {
    this.value = value;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.BOOLEAN_VALUE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.BOOLEAN_VALUE__VALUE:
    	setValue((boolean) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.BOOLEAN_VALUE__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.BOOLEAN_VALUE__VALUE:
    return isValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.BOOLEAN_VALUE__VALUE:
    	return value != VALUE_EDEFAULT;
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
    result = (this.value) + ("");
        ;
    return result;
  }

  @TruffleBoundary
  public Value copyj() {
    Value result;
    miniJava.interpreter.miniJava.BooleanValue tmp = ((miniJava.interpreter.miniJava.BooleanValue)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
        tmp.setValue(this.value);
        result = tmp;
        ;
    return result;
  }
}
