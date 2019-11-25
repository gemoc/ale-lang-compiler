package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.EvalMapRes;
import boa.interpreter.boa.EvalRes;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;

@NodeInfo(
    description = "EvalMapRes"
)
public class EvalMapResImpl extends EvalResImpl implements EvalMapRes {
  protected EMap<String, EvalRes> values;

  protected EvalMapResImpl() {
    super();
  }

  @TruffleBoundary
  public EMap<String, EvalRes> getValues() {
    if (values == null) {
    	values = new EcoreEMap<String, EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.EVAL_MAP_RES__VALUES);
    }
    return values;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.EVAL_MAP_RES;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getValues()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    	getValues().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    if (coreType)
    	return getValues();
    else
    	return getValues().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    	return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.EVAL_MAP_RES__VALUES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
