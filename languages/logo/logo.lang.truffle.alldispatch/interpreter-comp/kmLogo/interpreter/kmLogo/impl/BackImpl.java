package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.Back;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "Back"
)
public class BackImpl extends PrimitiveImpl implements Back {
  @Child
  protected Expression steps;

  @CompilationFinal
  private BackDispatchWrapperEval cachedEval;

  private ExpressionDispatchEval dispatchExpressionEval;

  private TurtleDispatchForward dispatchTurtleForward;

  protected BackImpl() {
    super();
    this.cachedEval = new kmLogo.interpreter.kmLogo.impl.BackDispatchWrapperEval(this);
    this.dispatchExpressionEval = kmLogo.interpreter.kmLogo.impl.ExpressionDispatchEvalNodeGen.create(); 
    this.dispatchTurtleForward = kmLogo.interpreter.kmLogo.impl.TurtleDispatchForwardNodeGen.create(); 
  }

  @TruffleBoundary
  public void setSteps(Expression newSteps) {
    if (newSteps != steps) {
    	NotificationChain msgs = null;
    	if (steps != null)
    		msgs = ((InternalEObject)steps).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.BACK__STEPS, null, msgs);
    	if (newSteps != null)
    		msgs = ((InternalEObject)newSteps).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.BACK__STEPS, null, msgs);
    	msgs = basicSetSteps(newSteps, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.BACK__STEPS, newSteps, newSteps));
  }

  @TruffleBoundary
  public NotificationChain basicSetSteps(Expression newSteps, NotificationChain msgs) {
    Expression oldSteps = steps;
    steps = newSteps;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.BACK__STEPS, oldSteps, newSteps);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expression getSteps() {
    return steps;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.BACK;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmLogo.interpreter.kmLogo.Expression) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	setSteps((kmLogo.interpreter.kmLogo.Expression) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    return getSteps();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.BACK__STEPS:
    	return steps != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.BACK__STEPS:
    	return basicSetSteps(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public double eval(Turtle turtle) {
    double result;
    double move = ((double)((double)dispatchExpressionEval.executeDispatch(this.steps.getCachedEval(), new Object[] {turtle})));
        dispatchTurtleForward.executeDispatch(turtle.getCachedForward(), new Object[] {-(move)});
        result = 0.0;
        ;
    return result;
  }

  public BackDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }
}
