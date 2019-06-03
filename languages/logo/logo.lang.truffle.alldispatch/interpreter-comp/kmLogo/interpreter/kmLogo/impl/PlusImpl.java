package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Plus;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

@NodeInfo(
    description = "Plus"
)
public class PlusImpl extends BinaryExpImpl implements Plus {
  @CompilationFinal
  private PlusDispatchWrapperEval cachedEval;

  private ExpressionDispatchEval dispatchExpressionEval;

  protected PlusImpl() {
    super();
    this.cachedEval = new kmLogo.interpreter.kmLogo.impl.PlusDispatchWrapperEval(this);
    this.dispatchExpressionEval = kmLogo.interpreter.kmLogo.impl.ExpressionDispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PLUS;}

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

  public double eval(Turtle turtle) {
    double result;
    result = (((double)dispatchExpressionEval.executeDispatch(this.lhs.getCachedEval(), new Object[] {turtle}))) + (((double)dispatchExpressionEval.executeDispatch(this.rhs.getCachedEval(), new Object[] {turtle})));
        ;
    return result;
  }

  public PlusDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }
}
