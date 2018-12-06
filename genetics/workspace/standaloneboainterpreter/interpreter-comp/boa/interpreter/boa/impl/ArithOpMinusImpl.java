package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpMinus;
import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "ArithOpMinus"
)
public class ArithOpMinusImpl extends ArithOpImpl implements ArithOpMinus {
  @CompilationFinal
  private ArithOpMinusDispatchWrapperEval cachedEval;

  protected ArithOpMinusImpl() {
    super();
    this.cachedEval = new boa.interpreter.boa.impl.ArithOpMinusDispatchWrapperEval(this);
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.ARITH_OP_MINUS;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
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

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    boa.interpreter.boa.EvalRes vlhs = ((boa.interpreter.boa.EvalRes)this.lhs.eval(ctx));
        boa.interpreter.boa.EvalRes vrhs = ((boa.interpreter.boa.EvalRes)this.rhs.eval(ctx));
        if(vlhs instanceof boa.interpreter.boa.EvalIntRes) {
          if(vrhs instanceof boa.interpreter.boa.EvalIntRes) {
            boa.interpreter.boa.EvalIntRes ivlhs = ((boa.interpreter.boa.EvalIntRes)vlhs);
            boa.interpreter.boa.EvalIntRes ivrhs = ((boa.interpreter.boa.EvalIntRes)vrhs);
            boa.interpreter.boa.EvalIntRes ret = ((boa.interpreter.boa.EvalIntRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalIntRes());
            ret.setValue((ivlhs.getValue()) - (ivrhs.getValue()));
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

  public ArithOpMinusDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }
}
