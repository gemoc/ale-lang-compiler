package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.CmpOpLess;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalBoolRes;
import boa.interpreter.boa.EvalIntRes;
import boa.interpreter.boa.EvalRes;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "CmpOpLess"
)
public class CmpOpLessImpl extends CmpOpImpl implements CmpOpLess {
  protected CmpOpLessImpl() {
    super();
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.CMP_OP_LESS;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
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
    EvalRes vlhs = ((EvalRes)this.getLhs().eval(ctx));
    EvalRes vrhs = ((EvalRes)this.getRhs().eval(ctx));
    if(vlhs instanceof boa.interpreter.boa.EvalIntRes) {
      if(vrhs instanceof boa.interpreter.boa.EvalIntRes) {
        EvalIntRes ivlhs = ((EvalIntRes)vlhs);
        EvalIntRes ivrhs = ((EvalIntRes)vrhs);
        EvalBoolRes ret = ((EvalBoolRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalBoolRes());
        ret.setValue((ivlhs.getValue()) < (ivrhs.getValue()));
        result = ret;
      }
      else {
        result = null;
      }
    }
    else {
      result = null;
    }
    return result;
  }
}
