package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.visitor.VisitorInterface;

public class EvalBoolResImpl extends EvalResImpl implements EvalBoolRes {
  protected static final boolean VALUE_EDEFAULT = false;

  protected boolean value = VALUE_EDEFAULT;

  protected EvalBoolResImpl() {
    super();
  }

  public boolean isValue() {
    return value;}

  public void setValue(boolean value) {
    this.value = value;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.EVAL_BOOL_RES;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.EVAL_BOOL_RES__VALUE:
    	setValue((boolean) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_BOOL_RES__VALUE:
    	setValue(VALUE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.EVAL_BOOL_RES__VALUE:
    return isValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_BOOL_RES__VALUE:
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

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__EvalBoolRes(this);}
}
