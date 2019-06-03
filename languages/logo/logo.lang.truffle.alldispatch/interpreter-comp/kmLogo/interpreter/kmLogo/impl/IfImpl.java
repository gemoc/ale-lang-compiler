package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.If;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "If"
)
public class IfImpl extends ControlStructureImpl implements If {
  @Child
  protected Block thenPart;

  @Child
  protected Block elsePart;

  @CompilationFinal
  private IfDispatchWrapperEval cachedEval;

  private BlockDispatchEval dispatchBlockEval;

  private ExpressionDispatchEval dispatchExpressionEval;

  protected IfImpl() {
    super();
    this.cachedEval = new kmLogo.interpreter.kmLogo.impl.IfDispatchWrapperEval(this);
    this.dispatchBlockEval = kmLogo.interpreter.kmLogo.impl.BlockDispatchEvalNodeGen.create(); 
    this.dispatchExpressionEval = kmLogo.interpreter.kmLogo.impl.ExpressionDispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  public void setThenPart(Block newThenPart) {
    if (newThenPart != thenPart) {
    	NotificationChain msgs = null;
    	if (thenPart != null)
    		msgs = ((InternalEObject)thenPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.IF__THEN_PART, null, msgs);
    	if (newThenPart != null)
    		msgs = ((InternalEObject)newThenPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.IF__THEN_PART, null, msgs);
    	msgs = basicSetThenPart(newThenPart, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.IF__THEN_PART, newThenPart, newThenPart));
  }

  @TruffleBoundary
  public NotificationChain basicSetThenPart(Block newThenPart, NotificationChain msgs) {
    Block oldThenPart = thenPart;
    thenPart = newThenPart;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.IF__THEN_PART, oldThenPart, newThenPart);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Block getThenPart() {
    return thenPart;}

  @TruffleBoundary
  public void setElsePart(Block newElsePart) {
    if (newElsePart != elsePart) {
    	NotificationChain msgs = null;
    	if (elsePart != null)
    		msgs = ((InternalEObject)elsePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.IF__ELSE_PART, null, msgs);
    	if (newElsePart != null)
    		msgs = ((InternalEObject)newElsePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.IF__ELSE_PART, null, msgs);
    	msgs = basicSetElsePart(newElsePart, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.IF__ELSE_PART, newElsePart, newElsePart));
  }

  @TruffleBoundary
  public NotificationChain basicSetElsePart(Block newElsePart, NotificationChain msgs) {
    Block oldElsePart = elsePart;
    elsePart = newElsePart;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.IF__ELSE_PART, oldElsePart, newElsePart);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Block getElsePart() {
    return elsePart;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.IF;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmLogo.interpreter.kmLogo.Block) newValue);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmLogo.interpreter.kmLogo.Block) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	setThenPart((kmLogo.interpreter.kmLogo.Block) null);
    return;
    case KmLogoPackage.IF__ELSE_PART:
    	setElsePart((kmLogo.interpreter.kmLogo.Block) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    return getThenPart();
    case KmLogoPackage.IF__ELSE_PART:
    return getElsePart();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.IF__THEN_PART:
    	return thenPart != null;
    case KmLogoPackage.IF__ELSE_PART:
    	return elsePart != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.IF__THEN_PART:
    	return basicSetThenPart(null, msgs);
    case kmLogo.interpreter.kmLogo.KmLogoPackage.IF__ELSE_PART:
    	return basicSetElsePart(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public double eval(Turtle turtle) {
    double result;
    if((((double)dispatchExpressionEval.executeDispatch(this.condition.getCachedEval(), new Object[] {turtle}))) != (0.0)) {
          result = ((double)dispatchBlockEval.executeDispatch(this.thenPart.getCachedEval(), new Object[] {turtle}));
        }
        else {
          if((this.elsePart) != (null)) {
            result = ((double)dispatchBlockEval.executeDispatch(this.elsePart.getCachedEval(), new Object[] {turtle}));
          }
          else {
            result = 0.0;
          }
        }
        ;
    return result;
  }

  public IfDispatchWrapperEval getCachedEval() {
    return this.cachedEval;
  }
}
