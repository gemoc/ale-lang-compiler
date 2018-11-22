package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Int;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class IntImpl extends ExprImpl implements Int {
  protected static final int VALUE_EDEFAULT = 0;

  protected int value = VALUE_EDEFAULT;

  protected IntImpl() {
    super();
  }

  public int getValue() {
    return value;}

  public void setValue(int value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.INT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.INT__VALUE:
    	setValue((int) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.INT__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.INT__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.INT__VALUE:
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

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    interpreter.boa.interpreter.boa.EvalIntRes ret = ((interpreter.boa.interpreter.boa.EvalIntRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalIntRes());
        ret.setValue(this.value);
        result = ret;
        ;
    return result;
  }
}
