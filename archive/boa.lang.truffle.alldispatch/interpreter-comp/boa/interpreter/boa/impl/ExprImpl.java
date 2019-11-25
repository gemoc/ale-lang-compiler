package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "Expr"
)
public abstract class ExprImpl extends TopLevelCmdImpl implements Expr {
  @CompilationFinal
  private ExprDispatchWrapperEval cachedEval;

  private ExprDispatchEval dispatchExprEval;

  protected ExprImpl() {
    super();
    this.cachedEval = new boa.interpreter.boa.impl.ExprDispatchWrapperEval(this);
    this.dispatchExprEval = boa.interpreter.boa.impl.ExprDispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.EXPR;}

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
    result = null;
        ;
    return result;
  }

  public void nextLine(Ctx ctx) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(execboa.SerializeService.serialize(((boa.interpreter.boa.EvalRes)dispatchExprEval.executeDispatch(this.getCachedEval(), new Object[] {ctx}))));
        ;
  }

  public ExprDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }
}
