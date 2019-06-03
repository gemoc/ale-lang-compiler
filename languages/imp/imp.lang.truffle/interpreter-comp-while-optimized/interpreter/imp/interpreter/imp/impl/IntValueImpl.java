package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntValue;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "IntValue"
)
public class IntValueImpl extends ValueImpl implements IntValue {
  protected static final int VALUE_EDEFAULT = 0;

  protected int value = VALUE_EDEFAULT;

  protected IntValueImpl() {
    super();
  }

  public int getValue() {
    return value;}

  public void setValue(int value) {
    this.value = value;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return ImpPackage.Literals.INT_VALUE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.INT_VALUE__VALUE:
    	setValue((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.INT_VALUE__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.INT_VALUE__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.INT_VALUE__VALUE:
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
}
