package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Copy;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "Copy"
)
public class CopyImpl extends ExprImpl implements Copy {
  @Child
  protected Expr copy;

  private ExprDispatchEval dispatchExprEval;

  protected CopyImpl() {
    super();
    this.dispatchExprEval = boa.interpreter.boa.impl.ExprDispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  public void setCopy(Expr newCopy) {
    if (newCopy != copy) {
    	NotificationChain msgs = null;
    	if (copy != null)
    		msgs = ((InternalEObject)copy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.COPY__COPY, null, msgs);
    	if (newCopy != null)
    		msgs = ((InternalEObject)newCopy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.COPY__COPY, null, msgs);
    	msgs = basicSetCopy(newCopy, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.COPY__COPY, newCopy, newCopy));
  }

  @TruffleBoundary
  public NotificationChain basicSetCopy(Expr newCopy, NotificationChain msgs) {
    Expr oldCopy = copy;
    copy = newCopy;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.COPY__COPY, oldCopy, newCopy);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getCopy() {
    return copy;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.COPY;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    	setCopy((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    	setCopy((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    return getCopy();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.COPY__COPY:
    	return copy != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.COPY__COPY:
    	return basicSetCopy(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    boa.interpreter.boa.EvalRes vcopy = ((boa.interpreter.boa.EvalRes)((boa.interpreter.boa.EvalRes)dispatchExprEval.executeDispatch(this.copy.getCachedEval(), new Object[] {ctx})));
        if(vcopy instanceof boa.interpreter.boa.EvalMapRes) {
          boa.interpreter.boa.EvalMapRes mvcopy = ((boa.interpreter.boa.EvalMapRes)vcopy);
          boa.interpreter.boa.EvalMapRes ret = ((boa.interpreter.boa.EvalMapRes)boa.interpreter.boa.BoaFactory.eINSTANCE.createEvalMapRes());
          execboa.MapService.putAll(ret.getValues(), mvcopy.getValues());
          result = ret;
        }
        else {
          result = null;
        }
        ;
    return result;
  }
}
