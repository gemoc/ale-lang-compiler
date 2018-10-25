package boa_dynamic.interpreter.boa_dynamic.impl;

import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.interpreter.boa_dynamic.EvalMapRes;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;

public class EvalMapResImpl extends EvalResImpl implements EvalMapRes {
  protected EMap<String, EvalRes> values;

  protected EvalMapResImpl() {
    super();
  }

  public EMap<String, EvalRes> getValues() {
    if (values == null) {
    	values = new EcoreEMap<String, EvalRes>(Boa_dynamicPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, Boa_dynamicPackage.EVAL_MAP_RES__VALUES);
    }
    return values;
  }

  protected EClass eStaticClass() {
    return Boa_dynamicPackage.Literals.EVAL_MAP_RES;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_MAP_RES__VALUES:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getValues()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_MAP_RES__VALUES:
    	getValues().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_MAP_RES__VALUES:
    if (coreType)
    	return getValues();
    else
    	return getValues().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_MAP_RES__VALUES:
    	return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage.EVAL_MAP_RES__VALUES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
