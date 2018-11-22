package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.ArithOpTimes;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

public class ArithOpTimesImpl extends ArithOpImpl implements ArithOpTimes {
  protected ArithOpTimesImpl() {
    super();
  }

  protected EClass eStaticClass() {
    return BoaPackage.Literals.ARITH_OP_TIMES;}

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
    interpreter.boa.interpreter.boa.EvalRes vlhs = ((interpreter.boa.interpreter.boa.EvalRes)this.lhs.eval(ctx));
        interpreter.boa.interpreter.boa.EvalRes vrhs = ((interpreter.boa.interpreter.boa.EvalRes)this.rhs.eval(ctx));
        if(vlhs instanceof interpreter.boa.interpreter.boa.EvalIntRes) {
          if(vrhs instanceof interpreter.boa.interpreter.boa.EvalIntRes) {
            interpreter.boa.interpreter.boa.EvalIntRes ivlhs = ((interpreter.boa.interpreter.boa.EvalIntRes)vlhs);
            interpreter.boa.interpreter.boa.EvalIntRes ivrhs = ((interpreter.boa.interpreter.boa.EvalIntRes)vrhs);
            interpreter.boa.interpreter.boa.EvalIntRes ret = ((interpreter.boa.interpreter.boa.EvalIntRes)interpreter.boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalIntRes());
            ret.setValue((ivlhs.getValue()) * (ivrhs.getValue()));
            result = ret;
          }
          else {
            result = null;
          }
        }
        else {
          result = null;
        }
        ;
    return result;
  }
}
