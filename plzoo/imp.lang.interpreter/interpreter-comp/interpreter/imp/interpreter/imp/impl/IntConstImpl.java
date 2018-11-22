package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntConst;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class IntConstImpl extends ExprImpl implements IntConst {
  protected static final int VALUE_EDEFAULT = 0;

  protected int value = VALUE_EDEFAULT;

  protected IntConstImpl() {
    super();
  }

  public int getValue() {
    return value;}

  public void setValue(int value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return ImpPackage.Literals.INT_CONST;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.INT_CONST__VALUE:
    	setValue((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.INT_CONST__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.INT_CONST__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.INT_CONST__VALUE:
    	return value != VALUE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluate(Store s) {
    Value result;
    interpreter.imp.interpreter.imp.IntValue tmp = ((interpreter.imp.interpreter.imp.IntValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue());
        tmp.setValue(this.value);
        result = tmp;
        ;
    return result;
  }
}
