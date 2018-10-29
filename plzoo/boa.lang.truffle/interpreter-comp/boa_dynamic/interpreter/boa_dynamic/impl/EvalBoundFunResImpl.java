package boa_dynamic.interpreter.boa_dynamic.impl;

import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.interpreter.boa_dynamic.EvalBoundFunRes;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;

@NodeInfo(
    description = "EvalBoundFunRes"
)
public class EvalBoundFunResImpl extends EvalFunResImpl implements EvalBoundFunRes {
  protected EMap<String, EvalRes> th;

  protected EvalBoundFunResImpl() {
    super();
  }

  public EMap<String, EvalRes> getTh() {
    if (th == null) {
    	th = new EcoreEMap<String, EvalRes>(Boa_dynamicPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH);
    }
    return th;
  }

  protected EClass eStaticClass() {
    return Boa_dynamicPackage.Literals.EVAL_BOUND_FUN_RES;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getTh()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
    	getTh().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
    if (coreType)
    	return getTh();
    else
    	return getTh().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
    	return th != null && !th.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage.EVAL_BOUND_FUN_RES__TH:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getTh()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
