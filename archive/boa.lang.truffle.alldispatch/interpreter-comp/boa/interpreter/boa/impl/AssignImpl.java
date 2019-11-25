package boa.interpreter.boa.impl;

import boa.interpreter.boa.Assign;
import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "Assign"
)
public class AssignImpl extends ExprImpl implements Assign {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  @Child
  protected Expr lhs;

  @Child
  protected Expr rhs;

  private ExprDispatchEval dispatchExprEval;

  protected AssignImpl() {
    super();
    this.dispatchExprEval = boa.interpreter.boa.impl.ExprDispatchEvalNodeGen.create(); 
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  @TruffleBoundary
  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.ASSIGN__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.ASSIGN__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.ASSIGN__LHS, newLhs, newLhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.ASSIGN__LHS, oldLhs, newLhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getLhs() {
    return lhs;}

  @TruffleBoundary
  public void setRhs(Expr newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.ASSIGN__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.ASSIGN__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.ASSIGN__RHS, newRhs, newRhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.ASSIGN__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getRhs() {
    return rhs;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.ASSIGN;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    	setLhs((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.ASSIGN__RHS:
    	setRhs((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.ASSIGN__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    	setLhs((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.ASSIGN__RHS:
    	setRhs((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.ASSIGN__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    return getLhs();
    case BoaPackage.ASSIGN__RHS:
    return getRhs();
    case BoaPackage.ASSIGN__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    	return lhs != null;
    case BoaPackage.ASSIGN__RHS:
    	return rhs != null;
    case BoaPackage.ASSIGN__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.ASSIGN__LHS:
    	return basicSetLhs(null, msgs);
    case boa.interpreter.boa.BoaPackage.ASSIGN__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    boa.interpreter.boa.EvalRes vlhs = ((boa.interpreter.boa.EvalRes)((boa.interpreter.boa.EvalRes)dispatchExprEval.executeDispatch(this.lhs.getCachedEval(), new Object[] {ctx})));
        boa.interpreter.boa.EvalRes vrhs = ((boa.interpreter.boa.EvalRes)((boa.interpreter.boa.EvalRes)dispatchExprEval.executeDispatch(this.rhs.getCachedEval(), new Object[] {ctx})));
        if(vlhs instanceof boa.interpreter.boa.EvalMapRes) {
          boa.interpreter.boa.EvalMapRes mvlhs = ((boa.interpreter.boa.EvalMapRes)vlhs);
          if(execboa.MapService.containsKey(mvlhs.getValues(), this.name)) {
            execboa.MapService.put(mvlhs.getValues(), this.name, vrhs);
            result = vrhs;
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
