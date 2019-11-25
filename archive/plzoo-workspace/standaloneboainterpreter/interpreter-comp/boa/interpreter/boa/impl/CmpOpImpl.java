package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.CmpOp;
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
    description = "CmpOp"
)
public abstract class CmpOpImpl extends ExprImpl implements CmpOp {
  @Child
  protected Expr lhs;

  @Child
  protected Expr rhs;

  protected CmpOpImpl() {
    super();
  }

  @TruffleBoundary
  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.CMP_OP__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.CMP_OP__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.CMP_OP__LHS, newLhs, newLhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.CMP_OP__LHS, oldLhs, newLhs);
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
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.CMP_OP__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.CMP_OP__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.CMP_OP__RHS, newRhs, newRhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.CMP_OP__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getRhs() {
    return rhs;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.CMP_OP;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.CMP_OP__LHS:
    	setLhs((boa.interpreter.boa.Expr) newValue);
    return;
    case BoaPackage.CMP_OP__RHS:
    	setRhs((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.CMP_OP__LHS:
    	setLhs((boa.interpreter.boa.Expr) null);
    return;
    case BoaPackage.CMP_OP__RHS:
    	setRhs((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.CMP_OP__LHS:
    return getLhs();
    case BoaPackage.CMP_OP__RHS:
    return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.CMP_OP__LHS:
    	return lhs != null;
    case BoaPackage.CMP_OP__RHS:
    	return rhs != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.CMP_OP__LHS:
    	return basicSetLhs(null, msgs);
    case boa.interpreter.boa.BoaPackage.CMP_OP__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
