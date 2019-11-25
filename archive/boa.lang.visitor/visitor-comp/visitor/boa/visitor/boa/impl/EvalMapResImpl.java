package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;

public class EvalMapResImpl extends EvalResImpl implements EvalMapRes {
  protected EMap<String, EvalRes> values;

  protected EvalMapResImpl() {
    super();
  }

  public EMap<String, EvalRes> getValues() {
    if (values == null) {
    	values = new EcoreEMap<String, EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.EVAL_MAP_RES__VALUES);
    }
    return values;
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.EVAL_MAP_RES;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getValues()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    	getValues().clear();
    return;
    }
    super.eUnset(featureID);
  }

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

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.EVAL_MAP_RES__VALUES:
    	return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case visitor.boa.visitor.boa.BoaPackage.EVAL_MAP_RES__VALUES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__EvalMapRes(this);}
}
